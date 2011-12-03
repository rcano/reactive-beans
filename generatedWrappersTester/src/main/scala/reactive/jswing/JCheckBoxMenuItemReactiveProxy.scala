package reactive.jswing

import reactive._

//This file was auto generated
trait JCheckBoxMenuItemReactiveProxy extends JMenuItemReactiveProxy  {
  override def peer: javax.swing.JCheckBoxMenuItem
  private[JCheckBoxMenuItemReactiveProxy] lazy val outer = peer
  trait Signals extends super.Signals {
    lazy val `state` = {
      val res = Var(outer.getState)
      res foreach (e => if (e != outer.getState) outer.setState(e))
      res
    }
    
    outer.addPropertyChangeListener(new java.beans.PropertyChangeListener {
      def propertyChange(evt: java.beans.PropertyChangeEvent) {
        def assign[T](s: Signal[T], value: Any) = s match {case v: Var[_] => v.asInstanceOf[Var[T]].value = value.asInstanceOf[T]; case _ =>}
        evt.getPropertyName match {
          case "`state`" => assign(`state`, evt.getNewValue)
          case _ =>
        }
      }
    })
  }
  
  override lazy val signals = new Signals {}
  
  

}
