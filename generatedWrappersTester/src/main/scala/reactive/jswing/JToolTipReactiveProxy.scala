package reactive.jswing

import reactive._

//This file was auto generated
trait JToolTipReactiveProxy extends JComponentReactiveProxy  {
  override def peer: javax.swing.JToolTip
  private[JToolTipReactiveProxy] lazy val outer = peer
  trait Signals extends super.Signals {
    //helper method to treat var as signals without specifying the type
    //which might arise visibility problems (e.g.: the listeners field in scala.swing.Component
    @inline private[this] def varAsSignal[T](v: Var[T]) = v: Signal[T]
    lazy val `UI` = varAsSignal(Var(outer.getUI))
    lazy val `component` = {
      val res = Var(outer.getComponent)
      res foreach (e => if (e != outer.getComponent) outer.setComponent(e))
      res
    }
    lazy val `tipText` = {
      val res = Var(outer.getTipText)
      res foreach (e => if (e != outer.getTipText) outer.setTipText(e))
      res
    }
    
    outer.addPropertyChangeListener(new java.beans.PropertyChangeListener {
      def propertyChange(evt: java.beans.PropertyChangeEvent) {
        def assign[T](s: Signal[T], value: Any) = s match {case v: Var[_] => v.asInstanceOf[Var[T]].value = value.asInstanceOf[T]; case _ =>}
        evt.getPropertyName match {
          case "`UI`" => assign(`UI`, evt.getNewValue)
          case "`component`" => assign(`component`, evt.getNewValue)
          case "`tipText`" => assign(`tipText`, evt.getNewValue)
          case _ =>
        }
      }
    })
  }
  
  override lazy val signals = new Signals {}
  
  

}
