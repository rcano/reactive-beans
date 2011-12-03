package reactive.jswing

import reactive._

//This file was auto generated
trait ContainerReactiveProxy extends ComponentReactiveProxy  {
  override def peer: java.awt.Container
  private[ContainerReactiveProxy] lazy val outer = peer
  trait Signals extends super.Signals {
    //helper method to treat var as signals without specifying the type
    //which might arise visibility problems (e.g.: the listeners field in scala.swing.Component
    @inline private[this] def varAsSignal[T](v: Var[T]) = v: Signal[T]
    lazy val `alignmentX` = varAsSignal(Var(outer.getAlignmentX))
    lazy val `alignmentY` = varAsSignal(Var(outer.getAlignmentY))
    lazy val `componentCount` = varAsSignal(Var(outer.getComponentCount))
    lazy val `components` = varAsSignal(Var(outer.getComponents))
    lazy val `containerListeners` = varAsSignal(Var(outer.getContainerListeners))
    lazy val `focusCycleRoot` = {
      val res = Var(outer.isFocusCycleRoot)
      res foreach (e => if (e != outer.isFocusCycleRoot) outer.setFocusCycleRoot(e))
      res
    }
    lazy val `focusTraversalPolicy` = {
      val res = Var(outer.getFocusTraversalPolicy)
      res foreach (e => if (e != outer.getFocusTraversalPolicy) outer.setFocusTraversalPolicy(e))
      res
    }
    lazy val `focusTraversalPolicyProvider` = {
      val res = Var(outer.isFocusTraversalPolicyProvider)
      res foreach (e => if (e != outer.isFocusTraversalPolicyProvider) outer.setFocusTraversalPolicyProvider(e))
      res
    }
    lazy val `focusTraversalPolicySet` = varAsSignal(Var(outer.isFocusTraversalPolicySet))
    lazy val `insets` = varAsSignal(Var(outer.getInsets))
    lazy val `layout` = {
      val res = Var(outer.getLayout)
      res foreach (e => if (e != outer.getLayout) outer.setLayout(e))
      res
    }
    lazy val `maximumSize` = varAsSignal(Var(outer.getMaximumSize))
    lazy val `minimumSize` = varAsSignal(Var(outer.getMinimumSize))
    lazy val `preferredSize` = varAsSignal(Var(outer.getPreferredSize))
    lazy val `validateRoot` = varAsSignal(Var(outer.isValidateRoot))
    
    outer.addPropertyChangeListener(new java.beans.PropertyChangeListener {
      def propertyChange(evt: java.beans.PropertyChangeEvent) {
        def assign[T](s: Signal[T], value: Any) = s match {case v: Var[_] => v.asInstanceOf[Var[T]].value = value.asInstanceOf[T]; case _ =>}
        evt.getPropertyName match {
          case "`alignmentX`" => assign(`alignmentX`, evt.getNewValue)
          case "`alignmentY`" => assign(`alignmentY`, evt.getNewValue)
          case "`componentCount`" => assign(`componentCount`, evt.getNewValue)
          case "`components`" => assign(`components`, evt.getNewValue)
          case "`containerListeners`" => assign(`containerListeners`, evt.getNewValue)
          case "`focusCycleRoot`" => assign(`focusCycleRoot`, evt.getNewValue)
          case "`focusTraversalPolicy`" => assign(`focusTraversalPolicy`, evt.getNewValue)
          case "`focusTraversalPolicyProvider`" => assign(`focusTraversalPolicyProvider`, evt.getNewValue)
          case "`focusTraversalPolicySet`" => assign(`focusTraversalPolicySet`, evt.getNewValue)
          case "`insets`" => assign(`insets`, evt.getNewValue)
          case "`layout`" => assign(`layout`, evt.getNewValue)
          case "`maximumSize`" => assign(`maximumSize`, evt.getNewValue)
          case "`minimumSize`" => assign(`minimumSize`, evt.getNewValue)
          case "`preferredSize`" => assign(`preferredSize`, evt.getNewValue)
          case "`validateRoot`" => assign(`validateRoot`, evt.getNewValue)
          case _ =>
        }
      }
    })
  }
  
  override lazy val signals = new Signals {}
  
  trait EventStreams extends super.EventStreams {
    object container {
      val componentAdded = new ESource[java.awt.event.ContainerEvent]
      val componentRemoved = new ESource[java.awt.event.ContainerEvent]
    }
    outer.addContainerListener(new java.awt.event.ContainerListener {
      def componentAdded(evt: java.awt.event.ContainerEvent) {EventStreams.this.container.componentAdded.fire(evt)}
      def componentRemoved(evt: java.awt.event.ContainerEvent) {EventStreams.this.container.componentRemoved.fire(evt)}
    })
  }
  
  override lazy val events = new EventStreams {}
  

}
