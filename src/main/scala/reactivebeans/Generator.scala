package reactivebeans


/**
 * Generator is the main entry point to the reactive beans wrapper.
 */
import java.beans.{Introspector, PropertyDescriptor}
import java.io.{File, PrintStream}
import java.lang.reflect.Modifier
import scala.reflect.NameTransformer

/**
 * Scala signal wrappers Generator.
 * This object is able to inspect the classpath searching for the given classes
 * or package (in which case all its subclasses will be analysied) and
 * will generate wrappers for those beans.
 * It supports standard java beans and also scala beans, whose properties
 * respond to the uniform access principle. 
 * 
 * TODO Add introspector options: auto (determines based on ScalaObject), beans
 * (standard java bean), scala-beans (beans in the scala way)
 */
object Generator {
  
  def usage() {
    println("Options:")
    println("reactive-beans [options] <toProcess>...")
    println("\t -bd --base-directory: directory where generated classes are created, . is assumed as default")
    println("\t -pn --package-name: package name outputed as first line for every class.")
    println("\t -p predicate: Special predicate used to react to signal changes updating the underlying\n" +
            "\t               property. For example, when using swing, the predicate should be _.isVisible\n" +
            "\t               where _ will be the container of the property")
    println("\t -m --bean-guessing-mode: One of:\n" + 
            "\t\t\t\tauto: Will request a standard BeanInfo unless the class extends ScalaObject\n" +
            "\t\t\t\t\tin which case the ScalaIntrospector will be used.\n" +
            "\t\t\t\tjava: Will always force obtaining the BeanInfo via java.beans.Introspector\n" +
            "\t\t\t\t\tuseful when you have created BeanInfo object for your scala class and want\n" +
            "\t\t\t\t\tthe wrapper based on those." +
            "\t\t\t\tscala: Will always force obtaining the BeanInfo via ScalaIntrospector,\n" +
            "\t\t\t\t\tit is here for completeness, but probably will never be used.")
    println("\t <toProcess>: class or package written in java naming convention like javax.swing.JLabel")
    println("Classes to be processed must be already in classpath.")
  }
  
  /*TODO create better console interface to parse options*/
  def main(args: Array[String]) {
    import GetOps._
    val predicateOp = ParamOp("p", "predicate")
    val baseDirOp = ParamOp("bd", "base-directory")
    val beanModeOp = ParamOp("m", "bean-guessing-mode", {
        case "auto"|"java"|"scala" => None
        case other => Some("Supported bean guessing modes are auto, java and scala")
      })
    val packageNameOp = ParamOp("pn", "package-name", s => 
      if (s matches "\\w+(\\.\\w+)*") None
      else Some(s + " is not a valid package name"))
    GetOps.parse(args, predicateOp, baseDirOp, packageNameOp, beanModeOp) match {
      case Success(ops~args, rest) =>
        if (args.isEmpty) return usage()
        val specialPredicate = ops collect {case predicateOp.Instance(value) => value} headOption
        val baseDir = (ops collect {case baseDirOp.Instance(value) => new File(value)} headOption) getOrElse(new File(""))
        val packageName = (ops collect {case packageNameOp.Instance(value) => value} headOption) getOrElse("")
        val beanGuessingMode = (ops collect {
            case beanModeOp.Instance("auto") => BeanGuessMode.Auto
            case beanModeOp.Instance("java") => BeanGuessMode.Java
            case beanModeOp.Instance("scala") => BeanGuessMode.Scala
          } headOption) getOrElse(BeanGuessMode.Auto)
        
        new InstanceGenerator(baseDir,
                              packageName,
                              specialPredicate,
                              beanGuessingMode).generate(args.map(_.value) flatMap ClassLister.listClasses)
      case err => println(err); usage()
    }
  }
  
  object BeanGuessMode extends Enumeration {
    val Auto, Java, Scala = Value
  }
  
  private[reactivebeans] def isValidModifier(mod: Int) = !Modifier.isStatic(mod) && (Modifier.isPublic(mod) || Modifier.isProtected(mod))
  
  
  /**
   * Only entry point of the Generator
   * @param baseDirectory Directory where generated files will be outputed
   * @param packageName Package declaration at the begining of every file
   * @param specialPredicate special predicate to restrict the listener with a takeWhile
   * @param beanGuessMode Mode for guessing bean, it can be auto, or forced to java or scala.
   * see https://github.com/nafg/reactive/tree/master/reactive-core
   */
  private class InstanceGenerator(baseFolder: File,
                                  packageName: String,
                                  specialPredicate: Option[String],
                                  beanGuessMode: BeanGuessMode.Value) {
    
    private var alreadyGenerated: Map[Class[_], Wrapper] = Map.empty
    
    /**
     * Performs simple filtering of selected classes and delegates actual work to per class generate
     */
    def generate(classes: List[String]) {
      val loadedClasses = classes map {c => 
        try Class.forName(c) 
        catch {case ex => 
            println("Class " + c + " not found")
            null
        }
      } filter (_ != null) filter {c =>
        try {
          if (!c.getName.contains("$")) {
            isValidModifier(c.getModifiers) && !Modifier.isFinal(c.getModifiers)
          } else false
        } catch {case ex => false}
      }
      for (lc <- loadedClasses) {
        generate(lc)
      }
    }
    def generate(clasz: Class[_]): Wrapper = {
      alreadyGenerated.get(clasz) match {
        case Some(generated) => generated
        case None =>
          println("Analysing " + clasz)
          val wrapper = Wrapper(clasz)
          
          //Obtain a bean info
          val bi = beanGuessMode match {
            case BeanGuessMode.Auto =>
              if (classOf[ScalaObject].isAssignableFrom(clasz)) ScalaIntrospector.getBeanInfo(clasz)
              else Introspector.getBeanInfo(clasz)
            case BeanGuessMode.Scala => ScalaIntrospector.getBeanInfo(clasz)
            case BeanGuessMode.Java => Introspector.getBeanInfo(clasz)
          }
          
          val propertyDescriptors = bi.getPropertyDescriptors
          for (pd <- propertyDescriptors if pd.isBound;
               rm = pd.getReadMethod if rm != null;
               wm = pd.getWriteMethod if wm != null) { //only mutable properties are generated
            val rmdc = rm.getDeclaringClass
            if (rmdc != clasz) {
              val dep = generate(rmdc)
              if (!wrapper.alreadyDepends(dep)) wrapper.dependencies :+= dep
            } else wrapper.signals :+= Signal(pd)
          }
          //Sanitize dependencies
          val toRemoveDeps = for (w1 <- wrapper.dependencies;
                                  w2 <- wrapper.dependencies if w1 != w2;
                                  if w1.alreadyDepends(w2)) yield w2
          wrapper.dependencies = wrapper.dependencies diff toRemoveDeps
      
          //Sanitize signals
          val toRemoveSignals = for (signal <- wrapper.signals if (wrapper.alreadyInherits(signal))) yield signal
          wrapper.signals = wrapper.signals diff toRemoveSignals
          
          if (wrapper.signals.nonEmpty) {
            println("Writing wrapper " + wrapper)
            writeWrapper(wrapper) // a wrapper that adds no field is useless
          }
          alreadyGenerated += Pair(clasz, wrapper)
          wrapper
      }
    }
    
    case class Wrapper(peer: Class[_]) {
      var dependencies: Seq[Wrapper] = Vector.empty
      var signals: Seq[Signal] = Vector.empty
      def name = peer.getSimpleName + "Reactive"
      
      def alreadyDepends(w: Wrapper): Boolean = {
        dependencies find (w2 => w == w2 || w2.alreadyDepends(w)) match {
          case Some(_) => true
          case None => false
        }
      }
      def alreadyInherits(s: Signal): Boolean = {
        dependencies find (w => w.signals.contains(s) || w.alreadyInherits(s)) match {
          case Some(_) => true
          case None => false
        }
      }
      
//      def linearDependencies: Seq[Wrapper] = dependencies flatMap (w => w +: w.linearDependencies)
    }
    object Signal {
      def apply(pd: PropertyDescriptor) = if (pd.getWriteMethod == null) Val(pd) else Var(pd)
    }
    sealed abstract class Signal(val prefix: String) {
      def pd: PropertyDescriptor
      lazy val name = pd.getName
      override def toString = prefix + "(" + name + ")"
      def immutable: Boolean
      def mutable = !immutable
      override def equals(that: Any) = that match {
        case s: Signal => s.name == name
        case _ => false
      }
    }
    case class Val(pd: PropertyDescriptor) extends Signal("Val") {val immutable = true}
    case class Var(pd: PropertyDescriptor) extends Signal("Var") {
      val immutable = false
      def writeMethodIsVararg: Boolean = {
        pd.getWriteMethod.isVarArgs || (pd match {
            case ai: AdditionalInfo => ai.writeMethodIsVararg
            case _ => false
          })
      }
    }
    
    
    /**
     * Writes the scala file 
     */
    def writeWrapper(wrapper: Wrapper) {
      baseFolder.mkdirs
      val destFile = new File(baseFolder, wrapper.name + ".scala")
      
      val ps = new PrintStream(destFile)
      try {
        ps.println("package " + packageName)
        ps.println()
        ps.println("//This file was auto generated")
        ps.println("import reactive._")
        ps.println()
        val hasDeps = wrapper.dependencies.nonEmpty
        val parameters = {
          val params = wrapper.peer.getTypeParameters
          if (params.nonEmpty) params.map(p => p.toString).mkString("[", ", ", "]") else ""
        }
        ps.println("trait " + wrapper.name + parameters + " extends " + wrapper.peer.getName + parameters +
                   (if (hasDeps) " with " + wrapper.dependencies.map(_.name).mkString(" with ")
                    else " with Observing")
                   + " { outer =>")
      
      
        //must define trait Signals
        val predicate = specialPredicate match {
          case Some(cond) => ".change.takeWhile{e => " + cond.replaceAll("_\\.", "outer.") + "}"
          case None => ""
        }
        ps.println("\ttrait Signals" + (if (hasDeps) " extends super.Signals" else "") + " {")
        for (signal <- wrapper.signals) {
          ps.print("\t\tval " + signal.name + " = " + signal.prefix + "(")
          ps.println("outer." + signal.pd.getReadMethod.getName + ")")
          signal match {
            case v@Var(_) => 
              ps.print("\t\t" + signal.name + predicate + " foreach (e => outer." + 
                       NameTransformer.decode(signal.pd.getWriteMethod.getName) + "(")
              val wm = signal.pd.getWriteMethod
              if (v.writeMethodIsVararg) ps.print("e:_*")
              else ps.print("e")
              ps.println("))")
            case Val(_) =>
          }
        }
        ps.println("\t}")
        ps.println()
      
        //define the field signals
        ps.print("\t")
        if (hasDeps) ps.print("override ") 
        ps.println("lazy val signals = new Signals {}")
      
        ps.println("}")
      } finally {
        ps.close()
      }
    }
  }

}