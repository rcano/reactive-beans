package reactive.jswing

import reactive._

//This file was auto generated
trait JFormattedTextFieldReactive extends javax.swing.JFormattedTextField with JTextFieldReactive {
  outer =>
  trait Signals extends super.Signals {
    //helper method to treat var as signals without specifying the type
    //which might arise visibility problems (e.g.: the listeners field in scala.swing.Component
    @inline private[this] def varAsSignal[T](v: Var[T]) = v: Signal[T]
    lazy val `editValid` = varAsSignal(Var(outer.isEditValid))
    lazy val `focusLostBehavior` = {
      val res = Var(outer.getFocusLostBehavior)
      res foreach (e => if (e != outer.getFocusLostBehavior) outer.setFocusLostBehavior(e))
      res
    }
    lazy val `formatter` = varAsSignal(Var(outer.getFormatter))
    lazy val `formatterFactory` = {
      val res = Var(outer.getFormatterFactory)
      res foreach (e => if (e != outer.getFormatterFactory) outer.setFormatterFactory(e))
      res
    }
    lazy val `value` = {
      val res = Var(outer.getValue)
      res foreach (e => if (e != outer.getValue) outer.setValue(e))
      res
    }
    
    outer.addPropertyChangeListener(new java.beans.PropertyChangeListener {
      def propertyChange(evt: java.beans.PropertyChangeEvent) {
        def assign[T](s: Signal[T], value: Any) = s match {case v: Var[_] => v.asInstanceOf[Var[T]].value = value.asInstanceOf[T]; case _ =>}
        evt.getPropertyName match {
          case "`editValid`" => assign(`editValid`, evt.getNewValue)
          case "`focusLostBehavior`" => assign(`focusLostBehavior`, evt.getNewValue)
          case "`formatter`" => assign(`formatter`, evt.getNewValue)
          case "`formatterFactory`" => assign(`formatterFactory`, evt.getNewValue)
          case "`value`" => assign(`value`, evt.getNewValue)
          case _ =>
        }
      }
    })
  }
  
  override lazy val signals = new Signals {}
  
  

}
