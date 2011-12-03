package reactive.jswing

import reactive._

//This file was auto generated
trait JPasswordFieldReactiveProxy extends JTextFieldReactiveProxy  {
  override def peer: javax.swing.JPasswordField
  private[JPasswordFieldReactiveProxy] lazy val outer = peer
  trait Signals extends super.Signals {
    //helper method to treat var as signals without specifying the type
    //which might arise visibility problems (e.g.: the listeners field in scala.swing.Component
    @inline private[this] def varAsSignal[T](v: Var[T]) = v: Signal[T]
    lazy val `echoChar` = {
      val res = Var(outer.getEchoChar)
      res foreach (e => if (e != outer.getEchoChar) outer.setEchoChar(e))
      res
    }
    lazy val `password` = varAsSignal(Var(outer.getPassword))
    
    outer.addPropertyChangeListener(new java.beans.PropertyChangeListener {
      def propertyChange(evt: java.beans.PropertyChangeEvent) {
        def assign[T](s: Signal[T], value: Any) = s match {case v: Var[_] => v.asInstanceOf[Var[T]].value = value.asInstanceOf[T]; case _ =>}
        evt.getPropertyName match {
          case "`echoChar`" => assign(`echoChar`, evt.getNewValue)
          case "`password`" => assign(`password`, evt.getNewValue)
          case _ =>
        }
      }
    })
  }
  
  override lazy val signals = new Signals {}
  
  

}
