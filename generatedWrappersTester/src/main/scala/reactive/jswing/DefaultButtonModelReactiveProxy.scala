package reactive.jswing

import reactive._

//This file was auto generated
trait DefaultButtonModelReactiveProxy extends Observing {
  def peer: javax.swing.DefaultButtonModel
  private[DefaultButtonModelReactiveProxy] lazy val outer = peer
  
  trait EventStreams {
    class ESource[T] extends EventSource[T]
    object change {
      val stateChanged = new ESource[javax.swing.event.ChangeEvent]
    }
    outer.addChangeListener(new javax.swing.event.ChangeListener {
      def stateChanged(evt: javax.swing.event.ChangeEvent) {EventStreams.this.change.stateChanged.fire(evt)}
    })
    object item {
      val itemStateChanged = new ESource[java.awt.event.ItemEvent]
    }
    outer.addItemListener(new java.awt.event.ItemListener {
      def itemStateChanged(evt: java.awt.event.ItemEvent) {EventStreams.this.item.itemStateChanged.fire(evt)}
    })
    object action {
      val actionPerformed = new ESource[java.awt.event.ActionEvent]
    }
    outer.addActionListener(new java.awt.event.ActionListener {
      def actionPerformed(evt: java.awt.event.ActionEvent) {EventStreams.this.action.actionPerformed.fire(evt)}
    })
  }
  
  lazy val events = new EventStreams {}
  

}
