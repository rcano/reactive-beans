package reactive.jswing

import reactive._

//This file was auto generated
trait BoundedRangeModelReactiveProxy extends Observing {
  def peer: javax.swing.BoundedRangeModel
  private[BoundedRangeModelReactiveProxy] lazy val outer = peer
  
  trait EventStreams {
    class ESource[T] extends EventSource[T]
    object change {
      val stateChanged = new ESource[javax.swing.event.ChangeEvent]
    }
    outer.addChangeListener(new javax.swing.event.ChangeListener {
      def stateChanged(evt: javax.swing.event.ChangeEvent) {EventStreams.this.change.stateChanged.fire(evt)}
    })
  }
  
  lazy val events = new EventStreams {}
  

}
