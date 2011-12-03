package reactive.jswing

import reactive._

//This file was auto generated
trait ListSelectionModelReactive extends javax.swing.ListSelectionModel with Observing {
  outer =>
  
  trait EventStreams {
    class ESource[T] extends EventSource[T]
    object listSelection {
      val valueChanged = new ESource[javax.swing.event.ListSelectionEvent]
    }
    outer.addListSelectionListener(new javax.swing.event.ListSelectionListener {
      def valueChanged(evt: javax.swing.event.ListSelectionEvent) {EventStreams.this.listSelection.valueChanged.fire(evt)}
    })
  }
  
  lazy val events = new EventStreams {}
  

}
