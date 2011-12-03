package reactive.jswing

import reactive._

//This file was auto generated
trait JTextFieldReactive extends javax.swing.JTextField with JTextComponentReactive {
  outer =>
  trait Signals extends super.Signals {
    //helper method to treat var as signals without specifying the type
    //which might arise visibility problems (e.g.: the listeners field in scala.swing.Component
    @inline private[this] def varAsSignal[T](v: Var[T]) = v: Signal[T]
    lazy val `action` = {
      val res = Var(outer.getAction)
      res foreach (e => if (e != outer.getAction) outer.setAction(e))
      res
    }
    lazy val `actionListeners` = varAsSignal(Var(outer.getActionListeners))
    lazy val `columns` = {
      val res = Var(outer.getColumns)
      res foreach (e => if (e != outer.getColumns) outer.setColumns(e))
      res
    }
    lazy val `horizontalAlignment` = {
      val res = Var(outer.getHorizontalAlignment)
      res foreach (e => if (e != outer.getHorizontalAlignment) outer.setHorizontalAlignment(e))
      res
    }
    lazy val `horizontalVisibility` = varAsSignal(Var(outer.getHorizontalVisibility))
    lazy val `scrollOffset` = {
      val res = Var(outer.getScrollOffset)
      res foreach (e => if (e != outer.getScrollOffset) outer.setScrollOffset(e))
      res
    }
    
    outer.addPropertyChangeListener(new java.beans.PropertyChangeListener {
      def propertyChange(evt: java.beans.PropertyChangeEvent) {
        def assign[T](s: Signal[T], value: Any) = s match {case v: Var[_] => v.asInstanceOf[Var[T]].value = value.asInstanceOf[T]; case _ =>}
        evt.getPropertyName match {
          case "`action`" => assign(`action`, evt.getNewValue)
          case "`actionListeners`" => assign(`actionListeners`, evt.getNewValue)
          case "`columns`" => assign(`columns`, evt.getNewValue)
          case "`horizontalAlignment`" => assign(`horizontalAlignment`, evt.getNewValue)
          case "`horizontalVisibility`" => assign(`horizontalVisibility`, evt.getNewValue)
          case "`scrollOffset`" => assign(`scrollOffset`, evt.getNewValue)
          case _ =>
        }
      }
    })
  }
  
  override lazy val signals = new Signals {}
  
  trait EventStreams extends super.EventStreams {
    object action {
      val actionPerformed = new ESource[java.awt.event.ActionEvent]
    }
    outer.addActionListener(new java.awt.event.ActionListener {
      def actionPerformed(evt: java.awt.event.ActionEvent) {EventStreams.this.action.actionPerformed.fire(evt)}
    })
  }
  
  override lazy val events = new EventStreams {}
  

}
