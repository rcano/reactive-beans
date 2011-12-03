package reactive.jswing

import reactive._

//This file was auto generated
trait ActionReactive extends javax.swing.Action with Observing {
  outer =>
  trait Signals {
    lazy val `enabled` = {
      val res = Var(outer.isEnabled)
      res foreach (e => if (e != outer.isEnabled) outer.setEnabled(e))
      res
    }
    
    outer.addPropertyChangeListener(new java.beans.PropertyChangeListener {
      def propertyChange(evt: java.beans.PropertyChangeEvent) {
        def assign[T](s: Signal[T], value: Any) = s match {case v: Var[_] => v.asInstanceOf[Var[T]].value = value.asInstanceOf[T]; case _ =>}
        evt.getPropertyName match {
          case "`enabled`" => assign(`enabled`, evt.getNewValue)
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
