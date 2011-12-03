package reactivebeans
import java.lang.reflect.Modifier
import Generator._
import scala.reflect.NameTransformer

class SignalsWrapperPart(wrapper: Generator.Wrapper,
                         instance: String,
                         predicate: String,
                         hasDeps: Boolean,
                         p: Generator.Printer,
                         isProxy: Boolean) extends WrapperPart(wrapper, instance, predicate, hasDeps, p, isProxy) {
  def write() {

    p.println("trait Signals" + (if (hasDeps) " extends super.Signals" else "") + " {")

    val peerDeclaredFields = wrapper.peer.getDeclaredFields

    val callOnInstance = instance + "."

    p.inBlock {
      val signals = if (!isProxy) wrapper.signals else wrapper.signals filter { s =>
        s.pd match {
          case ai: AdditionalInfo => ai.isPublic
          case _ => true
        }
      }
      if (signals exists (_.immutable)) {
        p.println("//helper method to treat var as signals without specifying the type")
        p.println("//which might arise visibility problems (e.g.: the listeners field in scala.swing.Component")
        p.println("@inline private[this] def varAsSignal[T](v: Var[T]) = v: Signal[T]")
      }

      for (signal <- signals) {
        val readerMethodName = {
          val rm = signal.pd.getReadMethod
          if (peerDeclaredFields.find(f => f.getName == rm.getName &&
            !Modifier.isPrivate(f.getModifiers)).isDefined) rm.getName + "()" //in order to avoid the field
          else rm.getName
        }

        val overrides = {
          var res = false
          wrapper.traverse { w =>
            if (w.signals find (_.name == signal.name) isDefined) res = true
          }
          res
        }
        val signalDeclaration = if (overrides) "override lazy val " else "lazy val "
        p.print(signalDeclaration + signal.name + " = ");
        if (signal.immutable) {
          p.printlnNP("varAsSignal(Var(" + callOnInstance + readerMethodName + "))") //even Vals are implemented as Vars, because readonly properties might actually mutate
        } else {
          p.printlnNP("{")
          p.inBlock {
            p.println("val res = Var(" + callOnInstance + readerMethodName + ")")
            p.print("res" + predicate + " foreach (e => if (e != " + callOnInstance + readerMethodName + ") " + callOnInstance +
              NameTransformer.decode(signal.pd.getWriteMethod.getName) + "(")
            p.printlnNP((if (signal.asInstanceOf[Var].writeMethodIsVararg) "e:_*"
            else "e") + "))")
            p.println("res")
          }; p.println("}")
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
            p.println("def assign[T](s: Signal[T], value: Any) = s match {case v: Var[_] => v.asInstanceOf[Var[T]].value = value.asInstanceOf[T]; case _ =>}")
            p.println("evt.getPropertyName match {")
            p.inBlock {
              for (signal <- signals) {
                p.println("case \"" + signal.name + "\" => assign(" + signal.name + ", evt.getNewValue)")
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