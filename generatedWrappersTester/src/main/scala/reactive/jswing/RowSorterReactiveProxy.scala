package reactive.jswing

import reactive._

//This file was auto generated
trait RowSorterReactiveProxy[M <: java.lang.Object] extends Observing {
  def peer: javax.swing.RowSorter[M]
  private[RowSorterReactiveProxy] lazy val outer = peer
  
  trait EventStreams {
    class ESource[T] extends EventSource[T]
    object rowSorter {
      val sorterChanged = new ESource[javax.swing.event.RowSorterEvent]
    }
    outer.addRowSorterListener(new javax.swing.event.RowSorterListener {
      def sorterChanged(evt: javax.swing.event.RowSorterEvent) {EventStreams.this.rowSorter.sorterChanged.fire(evt)}
    })
  }
  
  lazy val events = new EventStreams {}
  

}
