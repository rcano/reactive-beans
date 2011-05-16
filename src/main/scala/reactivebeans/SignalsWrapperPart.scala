package reactivebeans
import java.lang.reflect.Modifier
import Generator._
import scala.reflect.NameTransformer

class SignalsWrapperPart(wrapper: Generator.Wrapper,
                         instance: String,
                         predicate: String,
                         hasDeps: Boolean,
                         p: Generator.Printer) extends WrapperPart(wrapper, instance, predicate, hasDeps, p) {
  def write() {

    p.println("trait Signals" + (if (hasDeps) " extends super.Signals" else "") + " {")

    val peerDeclaredFields = wrapper.peer.getDeclaredFields

    val callOnInstance = instance + "."
    
    p.inBlock {
      for (signal <- wrapper.signals) {
        val readerMethodName = {
          val rm = signal.pd.getReadMethod
          if (peerDeclaredFields.find(f => f.getName == rm.getName &&
            !Modifier.isPrivate(f.getModifiers)).isDefined) rm.getName + "()" //in order to avoid the field
          else rm.getName
        }
        p.println("val " + signal.name + " = " + signal.prefix + "(" +
          callOnInstance + readerMethodName + ")")
        signal match {
          case v@Var(_) =>
            p.print(signal.name + predicate + " foreach (e => if (e != " + callOnInstance + readerMethodName + ") " + callOnInstance +
              NameTransformer.decode(signal.pd.getWriteMethod.getName) + "(")
            p.printlnNP((if (v.writeMethodIsVararg) "e:_*"
            else "e") + "))")
          case Val(_) =>
        }
      }
      p.println()

      //Check for addPropertyChangeListener support, in which case
      //registration for the signals of this wrapper is added
      if (wrapper.hasPropertyChangeListener) {
        p.println(callOnInstance + "addPropertyChangeListener(new java.beans.PropertyChangeListener {")
        p.inBlock {
          p.println("def propertyChange(evt: java.beans.PropertyChangeEvent) {")
          p.inBlock {
            p.println("def cast[R](a: Any) = a.asInstanceOf[R]")
            p.println("evt.getPropertyName match {")
            p.inBlock {
              for (signal <- wrapper.signals) {
                p.println("case \"" + signal.name + "\" => " + signal.name + "() = cast(evt.getNewValue)")
              }
              p.println("case _ =>") //ignore unknown properties
            }; p.println("}")
          }; p.println("}")
        }; p.println("})")
      }
    }

    p.println("}")
    p.println()

    //define the field signals
    p.println((if (hasDeps) "override " else "") + "lazy val signals = new Signals {}")

  }
}