package reactive.jswing

import reactive._

//This file was auto generated
trait JSpinnerReactive extends javax.swing.JSpinner with JComponentReactive {
  outer =>
  trait Signals extends super.Signals {
    //helper method to treat var as signals without specifying the type
    //which might arise visibility problems (e.g.: the listeners field in scala.swing.Component
    @inline private[this] def varAsSignal[T](v: Var[T]) = v: Signal[T]
    lazy val `UI` = {
      val res = Var(outer.getUI)
      res foreach (e => if (e != outer.getUI) outer.setUI(e))
      res
    }
    lazy val `changeListeners` = varAsSignal(Var(outer.getChangeListeners))
    lazy val `editor` = {
      val res = Var(outer.getEditor)
      res foreach (e => if (e != outer.getEditor) outer.setEditor(e))
      res
    }
    lazy val `model` = {
      val res = Var(outer.getModel)
      res foreach (e => if (e != outer.getModel) outer.setModel(e))
      res
    }
    lazy val `nextValue` = varAsSignal(Var(outer.getNextValue))
    lazy val `previousValue` = varAsSignal(Var(outer.getPreviousValue))
    lazy val `value` = {
      val res = Var(outer.getValue)
      res foreach (e => if (e != outer.getValue) outer.setValue(e))
      res
    }
    
    outer.addPropertyChangeListener(new java.beans.PropertyChangeListener {
      def propertyChange(evt: java.beans.PropertyChangeEvent) {
        def assign[T](s: Signal[T], value: Any) = s match {case v: Var[_] => v.asInstanceOf[Var[T]].value = value.asInstanceOf[T]; case _ =>}
        evt.getPropertyName match {
          case "`UI`" => assign(`UI`, evt.getNewValue)
          case "`changeListeners`" => assign(`changeListeners`, evt.getNewValue)
          case "`editor`" => assign(`editor`, evt.getNewValue)
          case "`model`" => assign(`model`, evt.getNewValue)
          case "`nextValue`" => assign(`nextValue`, evt.getNewValue)
          case "`previousValue`" => assign(`previousValue`, evt.getNewValue)
          case "`value`" => assign(`value`, evt.getNewValue)
          case _ =>
        }
      }
    })
  }
  
  override lazy val signals = new Signals {}
  
  trait EventStreams extends super.EventStreams {
    object change {
      val stateChanged = new ESource[javax.swing.event.ChangeEvent]
    }
    outer.addChangeListener(new javax.swing.event.ChangeListener {
      def stateChanged(evt: javax.swing.event.ChangeEvent) {EventStreams.this.change.stateChanged.fire(evt)}
    })
  }
  
  override lazy val events = new EventStreams {}
  

}
