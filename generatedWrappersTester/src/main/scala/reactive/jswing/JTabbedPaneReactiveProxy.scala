package reactive.jswing

import reactive._

//This file was auto generated
trait JTabbedPaneReactiveProxy extends JComponentReactiveProxy  {
  override def peer: javax.swing.JTabbedPane
  private[JTabbedPaneReactiveProxy] lazy val outer = peer
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
    lazy val `model` = {
      val res = Var(outer.getModel)
      res foreach (e => if (e != outer.getModel) outer.setModel(e))
      res
    }
    lazy val `selectedComponent` = {
      val res = Var(outer.getSelectedComponent)
      res foreach (e => if (e != outer.getSelectedComponent) outer.setSelectedComponent(e))
      res
    }
    lazy val `selectedIndex` = {
      val res = Var(outer.getSelectedIndex)
      res foreach (e => if (e != outer.getSelectedIndex) outer.setSelectedIndex(e))
      res
    }
    lazy val `tabCount` = varAsSignal(Var(outer.getTabCount))
    lazy val `tabLayoutPolicy` = {
      val res = Var(outer.getTabLayoutPolicy)
      res foreach (e => if (e != outer.getTabLayoutPolicy) outer.setTabLayoutPolicy(e))
      res
    }
    lazy val `tabPlacement` = {
      val res = Var(outer.getTabPlacement)
      res foreach (e => if (e != outer.getTabPlacement) outer.setTabPlacement(e))
      res
    }
    lazy val `tabRunCount` = varAsSignal(Var(outer.getTabRunCount))
    
    outer.addPropertyChangeListener(new java.beans.PropertyChangeListener {
      def propertyChange(evt: java.beans.PropertyChangeEvent) {
        def assign[T](s: Signal[T], value: Any) = s match {case v: Var[_] => v.asInstanceOf[Var[T]].value = value.asInstanceOf[T]; case _ =>}
        evt.getPropertyName match {
          case "`UI`" => assign(`UI`, evt.getNewValue)
          case "`changeListeners`" => assign(`changeListeners`, evt.getNewValue)
          case "`model`" => assign(`model`, evt.getNewValue)
          case "`selectedComponent`" => assign(`selectedComponent`, evt.getNewValue)
          case "`selectedIndex`" => assign(`selectedIndex`, evt.getNewValue)
          case "`tabCount`" => assign(`tabCount`, evt.getNewValue)
          case "`tabLayoutPolicy`" => assign(`tabLayoutPolicy`, evt.getNewValue)
          case "`tabPlacement`" => assign(`tabPlacement`, evt.getNewValue)
          case "`tabRunCount`" => assign(`tabRunCount`, evt.getNewValue)
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
