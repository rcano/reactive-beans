package reactivebeans

import java.beans._
import java.lang.reflect.{Method, Modifier}
import scala.reflect.NameTransformer
import scala.tools.scalap.scalax.rules.scalasig._

/**
 * ScalaInstropector will return BeanInfo for scala classes based on the
 * uniform access principle to find properties.
 * Classes that are private or specially protected, will return no property
 * because they cannot be extended, which is a requisite of the Generator.
 * 
 * It also doesn't currently support lifter properties.
 */
object ScalaIntrospector {
  def getBeanInfo(c: Class[_]): BeanInfo = new IntrospectorInstance(c).getBeanInfo()
  
  private class IntrospectorInstance(mainClass: Class[_]) {
    
    var generatedSig = Map[Class[_], (Option[ScalaSig], Seq[MethodSymbol])]()
    var validatedMethodsSymbol = Map[Method, MethodSymbol]()
    def findSig(c: Class[_]) = {
      generatedSig.get(c) match {
        case Some(sig) => sig
        case None =>
          val allSigs = buildHierarchy(c) map {c =>
            ScalaSigParser.parse(c)
          } collect {case Some(v) => v}
          val allMethods = allSigs flatMap(_.topLevelClasses.head.children) collect {case m: MethodSymbol => m}
          val res = (ScalaSigParser.parse(c), allMethods)
          generatedSig += Pair(c, res)
          res
      }
    }
    def buildHierarchy(c: Class[_]) = {
      var res: Seq[Class[_]] = Vector.empty
      var it = c
      while (it != null) {
        res +:= it
        it = it.getSuperclass
      }
      def buildTraitHierarchy(c: Class[_]): Seq[Class[_]] = {
        (if (c.isInterface) Seq(c) else Seq.empty) ++
        (c.getInterfaces flatMap buildTraitHierarchy)
      }
      res ++ buildTraitHierarchy(c).distinct
    }
    def getBeanInfo(): BeanInfo = {
      val classSig = findSig(mainClass)
//      println("***********************************************************+")
//      for (sig <- classSig) {
//        println("\tTop classes for " + mainClass + " = " + buildHierarchy(mainClass))
//        println("\tSymbols for " + mainClass)
//        for (symbol <- sig.symbols) println("\t" + symbol)
//      }
    
      val invalidTopClass = classSig._1.map(_.topLevelClasses.headOption.
                                            map(s => s.isSealed || s.isProtected || s.isPrivate).
                                            getOrElse(false)).getOrElse(false)
      val validator = (m: Method) => {
        if(!invalidTopClass) validateMethod(m)
        else false
      }
    
      val allFields = mainClass.getDeclaredFields
      val grouped = mainClass.getMethods filter validator groupBy {m =>
        val methodName = NameTransformer.decode(m.getName)
        if (methodName contains ("$")) "liftedOrPrivate"
        else if (methodName.endsWith("_=")) "setter" //no further analysis needed, as only scala setters are allowed with this syntax
        else if (m.getParameterTypes.length == 0 &&
                 m.getReturnType != Void.TYPE && 
                 allFields.exists(_.getName == m.getName)) "getter"
        else "method"
      }
      val allGetters = grouped.get("getter").getOrElse(Array.empty[Method])
      val allSetters = grouped.get("setter").getOrElse(Array.empty[Method])
      val allOthers = grouped.get("method").getOrElse(Array.empty[Method])
    
      var settersForGetters: Seq[Method] = Vector.empty
      var properties: Seq[(String, Method, Method)] = Vector.empty
      for (setter <- allSetters) {
        val propName = setter.getName.dropRight(4)
        val getter = mainClass.getMethod(propName)
        properties :+= (NameTransformer.decode(propName), getter, setter)
        settersForGetters :+= getter
      }
      allGetters diff settersForGetters foreach {m =>
        properties :+= (NameTransformer.decode(m.getName), m, null)
      }
      properties = properties sortBy(_._1)
    
    
      new ScalaBeanInfo(mainClass, properties.toArray, allOthers diff settersForGetters)
    }
    
    
    private def validateMethod(m: Method): Boolean = {
      val mName = m.getName
      
      val allMethods = findSig(m.getDeclaringClass)._2
      allMethods find (_.name == mName) match {
        case Some(ms) =>
          val correctModifier = !ms.isPrivate && ms.symbolInfo.privateWithin.isEmpty
          
//              print("\t" + mName + " from " + m.getDeclaringClass + " is a" + (if(res) " valid" else "n invalid") + " method - ")
//              println((ms.isProtected, ms.isPrivate, ms.symbolInfo.privateWithin))
          
          val res = correctModifier && Generator.isValidModifier(m.getModifiers)
          if (res) validatedMethodsSymbol += Pair(m, ms)
          res
        case _ => 
          false
      }
    }
    
    /**
     * Special implementation of BeanInfo
     */
    private class ScalaBeanInfo(clazz: Class[_],
                                properties: Array[(String, Method, Method)],
                                methods: Array[Method]) extends SimpleBeanInfo {
      
      override val getPropertyDescriptors = {
        properties map {case (name, getter, setter) => 
          try {
            val res = new PropertyDescriptor(name, getter, setter) with AdditionalInfo {
//              println("Analysing property " + t._1 + " to see if is vararg. Children: " +
//                      validatedMethodsSymbol(t._3).children.map(p => 
//                  p.name + " - " + p.asInstanceOf[MethodSymbol].infoType
//                ))
              val writeMethodIsVararg = validatedMethodsSymbol.get(setter).map(_.children.head match {
                  case m: MethodSymbol =>
                    m.infoType match {
                      case TypeRefType(_, symbol, _) => symbol.name == "<repeated>"
                      case _ => false
                    }
                  case _ => false
                }) getOrElse(false)
                
              val isPublic = Modifier.isPublic(getter.getModifiers()) &&
                validatedMethodsSymbol.get(getter).map(!_.isProtected).getOrElse(true) // no need to check for isPrivate or isPrivateWithin, that was already validated.
            }
            res setBound true
            res: PropertyDescriptor
          } catch {
            case ex: IntrospectionException =>
              println(Console.YELLOW + "Failed on property " + name + " mismatch on\n\t" + getter + "\n\t" + setter + Console.RESET)
              null
          }
        } filterNot (_ == null) toArray
      }
      override val getMethodDescriptors = Array.empty[MethodDescriptor] // no need to provide methods for the Generator
      override val getBeanDescriptor = {
        val res = new BeanDescriptor(clazz)

        for (sig <- generatedSig.get(clazz); classSig <- sig._1; topLevelClass <- classSig.topLevelClasses) {
          res.setHidden(topLevelClass.isSealed || topLevelClass.isProtected ||
              topLevelClass.isPrivate || topLevelClass.symbolInfo.privateWithin.isDefined
          )

          val types = topLevelClass.children collect {
            case ts@TypeSymbol(info) =>
              ts.infoType match {
                case TypeBoundsType(TypeRefType(lp, ls, lta), TypeRefType(up, us, uta)) =>
                  val sb = new StringBuilder(ts.name)
                  if (ls.path != "scala.Nothing") {
                    sb append " >: " append ls.path
                  }
                  if (us.path != "scala.Any") {
                    sb append " <: " append us.path
                  }
                  ts.name->sb.toString
              }
          }
          res.setValue("typeParametersDef", types.map(_._2).mkString(", "))
          res.setValue("typeParameters", types.map(_._1).mkString(", "))
        }
        
        res
      }
    }
    
  }
}
trait AdditionalInfo {
  def writeMethodIsVararg: Boolean
  def isPublic: Boolean
}