package reactive.jswing

import reactive._

//This file was auto generated
trait AbstractActionReactiveProxy extends Observing {
  def peer: javax.swing.AbstractAction
  private[AbstractActionReactiveProxy] lazy val outer = peer
  trait Signals {
    //helper method to treat var as signals without specifying the type
    //which might arise visibility problems (e.g.: the listeners field in scala.swing.Component
    @inline private[this] def varAsSignal[T](v: Var[T]) = v: Signal[T]
    lazy val `enabled` = {
      val res = Var(outer.isEnabled)
      res foreach (e => if (e != outer.isEnabled) outer.setEnabled(e))
      res
    }
    lazy val `keys` = varAsSignal(Var(outer.getKeys))
    lazy val `propertyChangeListeners` = varAsSignal(Var(outer.getPropertyChangeListeners))
    
    outer.addPropertyChangeListener(new java.beans.PropertyChangeListener {
      def propertyChange(evt: java.beans.PropertyChangeEvent) {
        def assign[T](s: Signal[T], value: Any) = s match {case v: Var[_] => v.asInstanceOf[Var[T]].value = value.asInstanceOf[T]; case _ =>}
        evt.getPropertyName match {
          case "`enabled`" => assign(`enabled`, evt.getNewValue)
          case "`keys`" => assign(`keys`, evt.getNewValue)
          case "`propertyChangeListeners`" => assign(`propertyChangeListeners`, evt.getNewValue)
          case _ =>
        }
      }
    })
  }
  
  lazy val signals = new Signals {}
  
  trait EventStreams {
    class ESource[T] extends EventSource[T]
    object propertyChange {
      val propertyChange = new ESource[java.beans.PropertyChangeEvent]
    }
    outer.addPropertyChangeListener(new java.beans.PropertyChangeListener {
      def propertyChange(evt: java.beans.PropertyChangeEvent) {EventStreams.this.propertyChange.propertyChange.fire(evt)}
    })
  }
  
  lazy val events = new EventStreams {}
  

}
