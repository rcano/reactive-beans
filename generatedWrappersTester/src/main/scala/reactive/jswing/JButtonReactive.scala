package reactive.jswing

import reactive._

//This file was auto generated
trait JButtonReactive extends javax.swing.JButton with AbstractButtonReactive {
  outer =>
  trait Signals extends super.Signals {
    //helper method to treat var as signals without specifying the type
    //which might arise visibility problems (e.g.: the listeners field in scala.swing.Component
    @inline private[this] def varAsSignal[T](v: Var[T]) = v: Signal[T]
    lazy val `defaultButton` = varAsSignal(Var(outer.isDefaultButton))
    lazy val `defaultCapable` = {
      val res = Var(outer.isDefaultCapable)
      res foreach (e => if (e != outer.isDefaultCapable) outer.setDefaultCapable(e))
      res
    }
    
    outer.addPropertyChangeListener(new java.beans.PropertyChangeListener {
      def propertyChange(evt: java.beans.PropertyChangeEvent) {
        def assign[T](s: Signal[T], value: Any) = s match {case v: Var[_] => v.asInstanceOf[Var[T]].value = value.asInstanceOf[T]; case _ =>}
        evt.getPropertyName match {
          case "`defaultButton`" => assign(`defaultButton`, evt.getNewValue)
          case "`defaultCapable`" => assign(`defaultCapable`, evt.getNewValue)
          case _ =>
        }
      }
    })
  }
  
  override lazy val signals = new Signals {}
  
  

}
