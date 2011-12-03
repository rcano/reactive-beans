package reactive.jswing

import reactive._

//This file was auto generated
trait KeyboardFocusManagerReactive extends java.awt.KeyboardFocusManager with Observing {
  outer =>
  trait Signals {
    //helper method to treat var as signals without specifying the type
    //which might arise visibility problems (e.g.: the listeners field in scala.swing.Component
    @inline private[this] def varAsSignal[T](v: Var[T]) = v: Signal[T]
    lazy val `activeWindow` = varAsSignal(Var(outer.getActiveWindow))
    lazy val `currentFocusCycleRoot` = varAsSignal(Var(outer.getCurrentFocusCycleRoot))
    lazy val `defaultFocusTraversalPolicy` = {
      val res = Var(outer.getDefaultFocusTraversalPolicy)
      res foreach (e => if (e != outer.getDefaultFocusTraversalPolicy) outer.setDefaultFocusTraversalPolicy(e))
      res
    }
    lazy val `focusOwner` = varAsSignal(Var(outer.getFocusOwner))
    lazy val `focusedWindow` = varAsSignal(Var(outer.getFocusedWindow))
    lazy val `permanentFocusOwner` = varAsSignal(Var(outer.getPermanentFocusOwner))
    lazy val `propertyChangeListeners` = varAsSignal(Var(outer.getPropertyChangeListeners))
    lazy val `vetoableChangeListeners` = varAsSignal(Var(outer.getVetoableChangeListeners))
    
    outer.addPropertyChangeListener(new java.beans.PropertyChangeListener {
      def propertyChange(evt: java.beans.PropertyChangeEvent) {
        def assign[T](s: Signal[T], value: Any) = s match {case v: Var[_] => v.asInstanceOf[Var[T]].value = value.asInstanceOf[T]; case _ =>}
        evt.getPropertyName match {
          case "`activeWindow`" => assign(`activeWindow`, evt.getNewValue)
          case "`currentFocusCycleRoot`" => assign(`currentFocusCycleRoot`, evt.getNewValue)
          case "`defaultFocusTraversalPolicy`" => assign(`defaultFocusTraversalPolicy`, evt.getNewValue)
          case "`focusOwner`" => assign(`focusOwner`, evt.getNewValue)
          case "`focusedWindow`" => assign(`focusedWindow`, evt.getNewValue)
          case "`permanentFocusOwner`" => assign(`permanentFocusOwner`, evt.getNewValue)
          case "`propertyChangeListeners`" => assign(`propertyChangeListeners`, evt.getNewValue)
          case "`vetoableChangeListeners`" => assign(`vetoableChangeListeners`, evt.getNewValue)
          case _ =>
        }
      }
    })
  }
  
  lazy val signals = new Signals {}
  
  trait EventStreams {
    class ESource[T] extends EventSource[T]
    object propertyChange {
      val propertyChange = new ESource[java.beans.PropertyChangeEvent]
    }
    outer.addPropertyChangeListener(new java.beans.PropertyChangeListener {
      def propertyChange(evt: java.beans.PropertyChangeEvent) {EventStreams.this.propertyChange.propertyChange.fire(evt)}
    })
    object vetoableChange {
      val vetoableChange = new ESource[java.beans.PropertyChangeEvent]
    }
    outer.addVetoableChangeListener(new java.beans.VetoableChangeListener {
      def vetoableChange(evt: java.beans.PropertyChangeEvent) {EventStreams.this.vetoableChange.vetoableChange.fire(evt)}
    })
  }
  
  lazy val events = new EventStreams {}
  

}
