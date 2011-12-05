package reactivebeans

/**
 * Generator is the main entry point to the reactive beans wrapper.
 */
import java.beans.{ Introspector, BeanInfo, PropertyDescriptor, EventSetDescriptor, MethodDescriptor }
import java.io.{ File, PrintStream }
import java.lang.reflect.{Modifier, Type, TypeVariable, ParameterizedType, WildcardType}
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
    println("\t -pn --package-name: package name outputted as first line for every class.")
    println("\t -p predicate: Special predicate used to react to signal changes updating the underlying\n" +
      "\t               property. For example, when using swing, the predicate should be _.isVisible\n" +
      "\t               where _ will be the container of the property")
    println("\t -m --bean-guessing-mode: One of:\n" +
      "\t\t\t\tauto: Will request a standard BeanInfo unless the class extends ScalaObject\n" +
      "\t\t\t\t\tin which case the ScalaIntrospector will be used.\n" +
      "\t\t\t\tjava: Will always force obtaining the BeanInfo via java.beans.Introspector\n" +
      "\t\t\t\t\tuseful when you have created BeanInfo object for your scala class and want\n" +
      "\t\t\t\t\tthe wrapper based on those.\n" +
      "\t\t\t\tscala: Will always force obtaining the BeanInfo via ScalaIntrospector,\n" +
      "\t\t\t\t\tit is here for completeness, but probably will never be used.")
    println("\t --bean-fixes: Specifies classes or packages to look for BeanFix.\n" +
      "\t               Some beans are broken and they don't expose their properties and events\n" +
      "\t               properly, for example all javax.swing.JTextComponents like JTextField and\n" +
      "\t               JTextArea do not expose changes to text property via property changes, so\n" +
      "\t               in order to keep the signal updated, a DocumentListener has to be registered.\n" +
      "\t               Fixes like the one said, are provided by implementations of BeanFix, such\n" +
      "\t               instances get a change to generate more code into the final output.\n" +
      "\t               reactivebeans.defaultbeanfixes.* should be used when creating javax.swing classes,\n" +
      "\t               it contains several common fixes to javax.swing like the one above.")
    println("\t <toProcess>: class or package written in java naming convention like javax.swing.JLabel")
    println("Classes to be processed must be already in classpath.")
  }

  /*TODO create better console interface to parse options*/
  def main(args: Array[String]) {
    import GetOps._
    val predicateOp = ParamOp("p", "predicate")
    val baseDirOp = ParamOp("bd", "base-directory")
    val beanModeOp = ParamOp("m", "bean-guessing-mode", {
      case "auto" | "java" | "scala" => None
      case other => Some("Supported bean guessing modes are auto, java and scala")
    })
    val packageNameOp = ParamOp("pn", "package-name", s =>
      if (s matches "\\w+(\\.\\w+)*") None
      else Some(s + " is not a valid package name"))
    val generateTestClassesOp = ToggleOp("", "generate-test")
    val beanFixesOp = ParamOp("", "bean-fixes")
    GetOps.parse(args, predicateOp, baseDirOp, packageNameOp, beanModeOp, generateTestClassesOp, beanFixesOp) match {
      case Success(ops ~ args, rest) =>
        if (args.isEmpty) return usage()
        val specialPredicate = ops collect { case predicateOp.Instance(value) => value } headOption
        val baseDir = (ops collect { case baseDirOp.Instance(value) => new File(value) } headOption) getOrElse (new File(""))
        val packageName = (ops collect { case packageNameOp.Instance(value) => value } headOption) getOrElse ("")
        val beanGuessingMode = (ops collect {
          case beanModeOp.Instance("auto") => BeanGuessMode.Auto
          case beanModeOp.Instance("java") => BeanGuessMode.Java
          case beanModeOp.Instance("scala") => BeanGuessMode.Scala
        } headOption) getOrElse (BeanGuessMode.Auto)
        val generateTestClasses = (ops collect { case generateTestClassesOp.Instance => true } headOption) getOrElse false
        val beanFixes = (ops collect { case beanFixesOp.Instance(value) => value.split(":").toSeq } headOption) getOrElse (Seq.empty)

        new InstanceGenerator(
          GeneratorSettings(baseDir,
            packageName,
            specialPredicate,
            beanGuessingMode,
            generateTestClasses,
            beanFixes)).generate(args.map(_.value) flatMap ClassLister.listClasses)
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
  private class InstanceGenerator(settings: GeneratorSettings) {
    import settings._
    private var alreadyGenerated: Map[Class[_], Wrapper] = Map.empty
    var generatedWrappers: Seq[Wrapper] = Vector.empty
    val beanFixes = {
      settings.beanFixes flatMap ClassLister.listClasses filter { c =>
        try classOf[BeanFix].isAssignableFrom(Class.forName(c))
        catch {
          case ex =>
            println("WARNING: BeanFix" + c + " not found")
            false
        }
      } map (Class.forName(_).asInstanceOf[Class[BeanFix]])
    }
    /**
     * Performs simple filtering of selected classes and delegates actual work to per class generate
     */
    def generate(classes: List[String]) {
      val loadedClasses = classes map { c =>
        try Class.forName(c)
        catch {
          case ex =>
            println("Class " + c + " not found")
            null
        }
      } filter (_ != null) filter { c =>
        try {
          if (!c.getName.contains("$")) {
            isValidModifier(c.getModifiers) && !Modifier.isFinal(c.getModifiers)
          } else false
        } catch { case ex => false }
      }
      for (lc <- loadedClasses) {
        generate(lc)
      }
      if (settings.generateTestClasses) generateTest(generatedWrappers)
    }
    def generate(clasz: Class[_]): Option[Wrapper] = {
      alreadyGenerated.get(clasz) match {
        case Some(generated) => Some(generated)
        case None =>
          println("Analysing " + clasz)

          //Obtain a bean info
          val bi = beanGuessMode match {
            case BeanGuessMode.Auto =>
              if (classOf[ScalaObject].isAssignableFrom(clasz)) ScalaIntrospector.getBeanInfo(clasz)
              else Introspector.getBeanInfo(clasz)
            case BeanGuessMode.Scala => ScalaIntrospector.getBeanInfo(clasz)
            case BeanGuessMode.Java => Introspector.getBeanInfo(clasz)
          }
          if (bi.getBeanDescriptor().isHidden()) {
            println("\tclass is not public")
            return None
          }
          val wrapper = Wrapper(clasz, bi)

          //          println("\tEvents:")
          //          for (evtDescr <- bi.getEventSetDescriptors) {
          //            println("\t\tGroup: " + evtDescr.getName)
          //            for (evt <- evtDescr.getListenerMethodDescriptors) {
          //              println("\t\t\t" + evt.getName)
          //            }
          //          }

          //Analyse property descriptors
          val propertyDescriptors = bi.getPropertyDescriptors
          if (propertyDescriptors != null) {
            propertyDescriptors foreach {pd =>
              val rm = pd.getReadMethod()
              if (pd.isBound && rm != null) {
                val rmdc = rm.getDeclaringClass
                if (rmdc != clasz) {
                  generate(rmdc) foreach { dep =>
                    if (!wrapper.alreadyDepends(dep)) wrapper.dependencies :+= dep
                  }
                } else wrapper.signals :+= Signal(pd)
              }
            }
          }
          //Analyse eventSetDescriptors, this code is repeated with the propertyDescriptor ones,
          //common stuff should be factored out
          val eventSetDescriptors = bi.getEventSetDescriptors
          if (eventSetDescriptors != null) {
            for (esd <- eventSetDescriptors; alm = esd.getAddListenerMethod) {
              val rmdc = alm.getDeclaringClass
              if (rmdc != clasz) {
                generate(rmdc) foreach { dep =>
                  if (!wrapper.alreadyDepends(dep)) wrapper.dependencies :+= dep
                }
              } else wrapper.streams :+= EventStream(esd)
            }
          }

          //Sanitize dependencies
          val toRemoveDeps = for (
            w1 <- wrapper.dependencies;
            w2 <- wrapper.dependencies if w1 != w2;
            if w1.alreadyDepends(w2)
          ) yield w2
          wrapper.dependencies = wrapper.dependencies filterNot toRemoveDeps.contains

          //Sanitize signals and events
          def sanitize[T <: Named](seqToSanitize: Wrapper => Seq[T]) = {
            val seq = seqToSanitize(wrapper)
            val toRemove = for (named <- seq if (wrapper.alreadyInherits(named))) yield named
            (seq diff toRemove).distinct
          }
          wrapper.signals = sanitize(_.signals)
          wrapper.streams = sanitize(_.streams)

          if (wrapper.signals.nonEmpty || wrapper.streams.nonEmpty) { // a wrapper that adds nothing is useless
            println("Writing wrapper " + wrapper.peer)
            writeWrapper(wrapper, false)
            writeWrapper(wrapper, true)
            generatedWrappers :+= wrapper
          }
          alreadyGenerated += Pair(clasz, wrapper)
          Some(wrapper)
      }
    }

    /**
     * Writes the scala file
     */
    def writeWrapper(wrapper: Wrapper, proxy: Boolean) {
      baseFolder.mkdirs
      val destFile = new File(baseFolder, wrapper.name + (if (proxy) "Proxy" else "") + ".scala")

      val p = Printer(new PrintStream(destFile))

      try {
        p.println("package " + packageName)
        p.println()
        p.println("import reactive._")
        p.println()
        p.println("//This file was auto generated")
        val hasDeps = wrapper.dependencies.nonEmpty
        var hasSignalDeps, hasStreamDeps = false
        wrapper.traverse { w =>
          if (w.signals.nonEmpty) hasSignalDeps = true
          if (w.streams.nonEmpty) hasStreamDeps = true
        }

        if (proxy) {
          p.println("trait " + wrapper.name + "Proxy" + wrapper.parametersDef +
            (if (hasDeps) " extends " + wrapper.dependencies.head.name + "Proxy " + wrapper.dependencies.drop(1).map("with " + _.name + "Proxy").mkString
            else " extends Observing") +
            " {")
        } else {
          p.println("trait " + wrapper.name + wrapper.parametersDef + " extends " + wrapper.peer.getName + wrapper.parametersName +
            (if (hasDeps) " with " + wrapper.dependencies.map(_.name).mkString(" with ")
            else " with Observing") + " {")
        }
        val instance = "outer"
        val callOnInstance = instance + "."

        //calculate predicate
        val predicate = specialPredicate match {
          case Some(cond) =>
            def err = println(Console.YELLOW + "\tWARNING:Could not prove that " + wrapper.peer + " satisfies " + cond + Console.RESET)
            "_\\.(.+)\\(?".r.findFirstMatchIn(cond) match {
              case Some(m) =>
                val methodName = m.group(1)
                if (wrapper.peer.getMethods find (_.getName == methodName) isDefined) {
                  ".change.takeWhile{e => " + cond.replaceAll("_\\.", callOnInstance) + "}"
                } else {
                  err
                  ""
                }
              case _ =>
                err
                ""
            }
          case None => ""
        }
    
        p.inBlock {
          if (proxy) {
            val params = wrapper.parametersName
            if (hasDeps) p.println("override def peer: " + decodeClassName(wrapper.peer) + params)
            else p.println("def peer: " + decodeClassName(wrapper.peer) + params)
            p.println("private[" + wrapper.name + "Proxy] lazy val outer = peer")
          } else {
            p.println("outer =>")
          }

          if (wrapper.signals.nonEmpty) new SignalsWrapperPart(wrapper, instance, predicate, hasSignalDeps, p, proxy).write()
          p.println()
          if (wrapper.streams.nonEmpty) new EventsWrapperPart(wrapper, instance, predicate, hasStreamDeps, p, proxy).write()
          p.println()

          //BeanFixes
          val fixes = beanFixes map (_.getConstructor(classOf[Generator.Wrapper],
            classOf[String],
            classOf[String],
            classOf[Boolean],
            classOf[Generator.Printer],
            classOf[Boolean]).newInstance(wrapper, instance, predicate, hasDeps: java.lang.Boolean, p, proxy: java.lang.Boolean))

          fixes filter (_.isDefinedAt(wrapper.peer)) foreach (_.write())
        }
        p.println()
        p.println("}")
      } finally {
        p.close()
      }
    }

    /**
     * Writes a big TestFile to test properties
     */
    def generateTest(wrappers: Seq[Wrapper]) {
      val testableWrappers = wrappers filter { w =>
        val c = w.peer
        val mod = c.getModifiers
        !Modifier.isAbstract(mod) && !Modifier.isInterface(mod) && Modifier.isPublic(mod) && //instantiable and accessible
          c.getConstructors().find(_.getParameterTypes.length == 0).isDefined //has default constructor
      }

      val p = Printer(new PrintStream(new File(baseFolder, "Tests.scala")))

      try {
        p.println("package " + packageName)
        p.println()
        p.println("import reactive._")
        p.println()
        p.println("//This file was auto generated")

        var neededObjectGenerators: Seq[Class[_]] = Vector.empty

        def testForClassName(c: Class[_]) = "test" + decodeClassName(c).replaceAll("[\\[\\.]", "_").replaceAll("\\]", "")

        p.println("object Tests {"); p.inBlock {
          for (wrapper <- testableWrappers) {
            val testName = "test" + wrapper.peer.getSimpleName
            p.println("def " + testName + "() {"); p.inBlock {
              val params = {
                if (wrapper.parametersDef.isEmpty) ""
                else wrapper.parametersDef.drop(1).dropRight(1).split(",").map(_ => "Unit").mkString("[", ", ", "]")
              }
              p.println("val instance = new " + wrapper.peer.getName + params + "() with " + wrapper.name + params)

              //generate a test per signal
              for (signal <- wrapper.signals) {
                val rm = signal.pd.getReadMethod
                neededObjectGenerators :+= rm.getReturnType
                p.println(testForClassName(rm.getReturnType) + "(\"" + testName + "." + signal.name +
                  "\", instance.signals." + signal.name +
                  ", instance." + signal.pd.getWriteMethod.getName + "(_))")
              }
            }; p.println("}")
          }
          p.println()
          p.println("signal testers")
          neededObjectGenerators = neededObjectGenerators.distinct
          for (neededObject <- neededObjectGenerators) {
            val paramTypeName = decodeClassName(neededObject)
            p.println("def " + testForClassName(neededObject) + "(prefix: String, signal: Var[" + paramTypeName + "], assign: " +
              paramTypeName + " => Unit) {"); p.inBlock {
              p.println("val prev = signal.now")
              p.println("assign(newValueHere)")
              p.println("if (prev == signal.now) println(prefix + \" signal is not being updated by underlying property\")")
            }; p.println("}")
          }
        }; p.println("}")
      } finally {
        p.close()
      }
    }
  }

def decodeType(t: Type): String = t match {
  case c: Class[_] => decodeClassName(c)
  case pt: ParameterizedType => 
    decodeType(pt.getRawType()) + "[" + pt.getActualTypeArguments().map(decodeType).mkString(", ") + "]"
  case tv: TypeVariable[_] => tv.getName
  case wt: WildcardType => "_"
}
  
def decodeClassName(c: Class[_]): String = c match {
      case java.lang.Boolean.TYPE => "Boolean"
      case java.lang.Byte.TYPE => "Byte"
      case java.lang.Short.TYPE => "Short"
      case java.lang.Character.TYPE => "Char"
      case java.lang.Integer.TYPE => "Int"
      case java.lang.Long.TYPE => "Long"
      case java.lang.Float.TYPE => "Float"
      case java.lang.Double.TYPE => "Double"
      case _ =>
        if (c.isArray) "Array[" + decodeClassName(c.getComponentType) + "]"
        else if (c.isMemberClass) decodeClassName(c.getEnclosingClass) + "." + c.getSimpleName
        else c.getName
    }

  case class Wrapper(peer: Class[_], beanInfo: BeanInfo) {
    var dependencies: Seq[Wrapper] = Vector.empty
    var signals: Seq[Signal] = Vector.empty
    var streams: Seq[EventStream] = Vector.empty
    def name = peer.getSimpleName + "Reactive"

    lazy val parametersDef = {
      val tp = beanInfo.getBeanDescriptor().getValue("typeParametersDef").asInstanceOf[String]
      if (tp != null) {if (tp.nonEmpty) "[" + tp + "]" else ""}
      else {
        val params = peer.getTypeParameters
        def paramDef[T](p: Type): String = p match {
          case tp: TypeVariable[_] => tp.getName + {
            val bounds = tp.getBounds
            if (bounds != null && bounds.length != 0) " <: " + bounds.map(paramDef).mkString(" <: ")
            else ""
          }
          case wc: WildcardType => "_"
          case c: Class[_] => decodeClassName(c) + {
            val tp = c.getTypeParameters()
            if (tp.length != 0) " <: " + tp.map(paramDef).mkString(" <: ")
            else ""
          }
        }
        if (params.nonEmpty) params.map(paramDef).mkString("[", ", ", "]") else ""
      }
    }
    
    lazy val parametersName = {
      val tp = beanInfo.getBeanDescriptor().getValue("typeParameters").asInstanceOf[String]
      if (tp != null) {if (tp.nonEmpty) "[" + tp + "]" else ""}
      else {
        val params = peer.getTypeParameters
        if (params.nonEmpty) params.map(decodeType).mkString("[", ", ", "]") else ""
      }
    }

    def alreadyDepends(w: Wrapper): Boolean = {
      dependencies find (w2 => w == w2 || w2.alreadyDepends(w)) match {
        case Some(_) => true
        case None => false
      }
    }
    def alreadyInherits(s: Named): Boolean = {
      val seqToInspect = s match {
        case _: Signal => (_: Wrapper).signals
        case _: EventStream => (_: Wrapper).streams
      }
      dependencies find (w => seqToInspect(w).contains(s) || w.alreadyInherits(s)) match {
        case Some(_) => true
        case None => false
      }
    }

    def traverse(f: Wrapper => Unit) {
      def traverse(w: Wrapper, f: Wrapper => Unit) {
        f(w)
        w.dependencies foreach (traverse(_, f))
      }
      for (d <- dependencies) traverse(d, f)
    }

    lazy val hasPropertyChangeListener: Boolean =
      try {
        val m = peer.getMethod("addPropertyChangeListener", classOf[java.beans.PropertyChangeListener])
        true
      } catch { case ex: NoSuchMethodException => false }
    //      def linearDependencies: Seq[Wrapper] = dependencies flatMap (w => w +: w.linearDependencies)
  }

  sealed trait Named {
    def name: String
  }

  //Signal definition
  object Signal {
    def apply(pd: PropertyDescriptor) = if (pd.getWriteMethod == null) Val(pd) else Var(pd)
  }
  sealed abstract class Signal(val prefix: String) extends Named {
    def pd: PropertyDescriptor
    lazy val name = "`" + pd.getName + "`"
    override def toString = prefix + "(" + name + ")"
    def immutable: Boolean
    def mutable = !immutable
    override def equals(that: Any) = that match {
      case s: Signal => s.name == name && s.immutable == immutable
      case _ => false
    }
    override def hashCode = {
      (if (immutable) 7 else 5) + (name.hashCode * 13)
    }
  }
  case class Val(pd: PropertyDescriptor) extends Signal("Val") { val immutable = true }
  case class Var(pd: PropertyDescriptor) extends Signal("Var") {
    val immutable = false
    def writeMethodIsVararg: Boolean = {
      pd.getWriteMethod.isVarArgs || (pd match {
        case ai: AdditionalInfo => ai.writeMethodIsVararg
        case _ => false
      })
    }
  }
  //EventStrams definition
  case class EventStream(eventSetDescriptor: EventSetDescriptor) extends Named {
    lazy val name = eventSetDescriptor.getName
    override def equals(that: Any) = that match {
      case es: EventStream => es.name == name
      case _ => false
    }
  }

  /**
   * A printer class to abstract indentation handling.
   * Use inBlock to increase indent and be sure that nesting is handled
   * properly.
   */
  trait Printer {
    private var indent = 0
    def indentPrefix = "  " * indent

    protected def printlnImpl(s: String)
    protected def printImpl(s: String)
    def println(s: String = "") = printlnImpl(indentPrefix + s)
    def printlnNP(s: String = "") = printlnImpl(s)
    def print(s: String) = printImpl(indentPrefix + s)
    def printNP(s: String) = printImpl(s)

    def inBlock(code: => Unit) {
      indent += 1
      code
      indent -= 1
    }
    def close()
  }
  object Printer {
    def apply(ps: java.io.PrintStream): Printer = new Printer {
      def printlnImpl(s: String) = ps.println(s)
      def printImpl(s: String) = ps.print(s)
      def close() = ps.close()
    }
  }
}