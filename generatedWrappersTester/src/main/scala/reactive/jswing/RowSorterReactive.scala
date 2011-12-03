package reactive.jswing

import reactive._

//This file was auto generated
trait RowSorterReactive[M <: java.lang.Object] extends javax.swing.RowSorter[M] with Observing {
  outer =>
  
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
