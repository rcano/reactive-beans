package reactive.jswing

import reactive._

//This file was auto generated
trait AbstractCellEditorReactiveProxy extends Observing {
  def peer: javax.swing.AbstractCellEditor
  private[AbstractCellEditorReactiveProxy] lazy val outer = peer
  
  trait EventStreams {
    class ESource[T] extends EventSource[T]
    object cellEditor {
      val editingStopped = new ESource[javax.swing.event.ChangeEvent]
      val editingCanceled = new ESource[javax.swing.event.ChangeEvent]
    }
    outer.addCellEditorListener(new javax.swing.event.CellEditorListener {
      def editingStopped(evt: javax.swing.event.ChangeEvent) {EventStreams.this.cellEditor.editingStopped.fire(evt)}
      def editingCanceled(evt: javax.swing.event.ChangeEvent) {EventStreams.this.cellEditor.editingCanceled.fire(evt)}
    })
  }
  
  lazy val events = new EventStreams {}
  

}
