package reactive.jswing

import reactive._

//This file was auto generated
trait ComboBoxEditorReactive extends javax.swing.ComboBoxEditor with Observing {
  outer =>
  
  trait EventStreams {
    class ESource[T] extends EventSource[T]
    object action {
      val actionPerformed = new ESource[java.awt.event.ActionEvent]
    }
    outer.addActionListener(new java.awt.event.ActionListener {
      def actionPerformed(evt: java.awt.event.ActionEvent) {EventStreams.this.action.actionPerformed.fire(evt)}
    })
  }
  
  lazy val events = new EventStreams {}
  

}
