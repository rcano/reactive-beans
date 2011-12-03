package reactive.jswing

import reactive._

//This file was auto generated
trait SwingWorkerReactive[T <: java.lang.Object, V <: java.lang.Object] extends javax.swing.SwingWorker[T, V] with Observing {
  outer =>
  trait Signals {
    //helper method to treat var as signals without specifying the type
    //which might arise visibility problems (e.g.: the listeners field in scala.swing.Component
    @inline private[this] def varAsSignal[T](v: Var[T]) = v: Signal[T]
    lazy val `cancelled` = varAsSignal(Var(outer.isCancelled))
    lazy val `done` = varAsSignal(Var(outer.isDone))
    lazy val `progress` = varAsSignal(Var(outer.getProgress))
    lazy val `propertyChangeSupport` = varAsSignal(Var(outer.getPropertyChangeSupport))
    lazy val `state` = varAsSignal(Var(outer.getState))
    
    outer.addPropertyChangeListener(new java.beans.PropertyChangeListener {
      def propertyChange(evt: java.beans.PropertyChangeEvent) {
        def assign[T](s: Signal[T], value: Any) = s match {case v: Var[_] => v.asInstanceOf[Var[T]].value = value.asInstanceOf[T]; case _ =>}
        evt.getPropertyName match {
          case "`cancelled`" => assign(`cancelled`, evt.getNewValue)
          case "`done`" => assign(`done`, evt.getNewValue)
          case "`progress`" => assign(`progress`, evt.getNewValue)
          case "`propertyChangeSupport`" => assign(`propertyChangeSupport`, evt.getNewValue)
          case "`state`" => assign(`state`, evt.getNewValue)
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
