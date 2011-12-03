package reactive.jswing

import reactive._

//This file was auto generated
trait ListModelReactiveProxy[E <: java.lang.Object] extends Observing {
  def peer: javax.swing.ListModel[E]
  private[ListModelReactiveProxy] lazy val outer = peer
  
  trait EventStreams {
    class ESource[T] extends EventSource[T]
    object listData {
      val contentsChanged = new ESource[javax.swing.event.ListDataEvent]
      val intervalAdded = new ESource[javax.swing.event.ListDataEvent]
      val intervalRemoved = new ESource[javax.swing.event.ListDataEvent]
    }
    outer.addListDataListener(new javax.swing.event.ListDataListener {
      def contentsChanged(evt: javax.swing.event.ListDataEvent) {EventStreams.this.listData.contentsChanged.fire(evt)}
      def intervalAdded(evt: javax.swing.event.ListDataEvent) {EventStreams.this.listData.intervalAdded.fire(evt)}
      def intervalRemoved(evt: javax.swing.event.ListDataEvent) {EventStreams.this.listData.intervalRemoved.fire(evt)}
    })
  }
  
  lazy val events = new EventStreams {}
  

}
