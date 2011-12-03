package reactive.jswing

import reactive._

//This file was auto generated
trait JComponentReactiveProxy extends ContainerReactiveProxy  {
  override def peer: javax.swing.JComponent
  private[JComponentReactiveProxy] lazy val outer = peer
  trait Signals extends super.Signals {
    //helper method to treat var as signals without specifying the type
    //which might arise visibility problems (e.g.: the listeners field in scala.swing.Component
    @inline private[this] def varAsSignal[T](v: Var[T]) = v: Signal[T]
    lazy val `UIClassID` = varAsSignal(Var(outer.getUIClassID))
    lazy val `accessibleContext` = varAsSignal(Var(outer.getAccessibleContext))
    lazy val `actionMap` = {
      val res = Var(outer.getActionMap)
      res foreach (e => if (e != outer.getActionMap) outer.setActionMap(e))
      res
    }
    override lazy val `alignmentX` = {
      val res = Var(outer.getAlignmentX)
      res foreach (e => if (e != outer.getAlignmentX) outer.setAlignmentX(e))
      res
    }
    override lazy val `alignmentY` = {
      val res = Var(outer.getAlignmentY)
      res foreach (e => if (e != outer.getAlignmentY) outer.setAlignmentY(e))
      res
    }
    lazy val `ancestorListeners` = varAsSignal(Var(outer.getAncestorListeners))
    lazy val `autoscrolls` = {
      val res = Var(outer.getAutoscrolls)
      res foreach (e => if (e != outer.getAutoscrolls) outer.setAutoscrolls(e))
      res
    }
    lazy val `baselineResizeBehavior` = varAsSignal(Var(outer.getBaselineResizeBehavior))
    lazy val `border` = {
      val res = Var(outer.getBorder)
      res foreach (e => if (e != outer.getBorder) outer.setBorder(e))
      res
    }
    lazy val `componentPopupMenu` = {
      val res = Var(outer.getComponentPopupMenu)
      res foreach (e => if (e != outer.getComponentPopupMenu) outer.setComponentPopupMenu(e))
      res
    }
    lazy val `debugGraphicsOptions` = {
      val res = Var(outer.getDebugGraphicsOptions)
      res foreach (e => if (e != outer.getDebugGraphicsOptions) outer.setDebugGraphicsOptions(e))
      res
    }
    lazy val `doubleBuffered` = {
      val res = Var(outer.isDoubleBuffered)
      res foreach (e => if (e != outer.isDoubleBuffered) outer.setDoubleBuffered(e))
      res
    }
    lazy val `graphics` = varAsSignal(Var(outer.getGraphics))
    lazy val `height` = varAsSignal(Var(outer.getHeight))
    lazy val `inheritsPopupMenu` = {
      val res = Var(outer.getInheritsPopupMenu)
      res foreach (e => if (e != outer.getInheritsPopupMenu) outer.setInheritsPopupMenu(e))
      res
    }
    lazy val `inputVerifier` = {
      val res = Var(outer.getInputVerifier)
      res foreach (e => if (e != outer.getInputVerifier) outer.setInputVerifier(e))
      res
    }
    lazy val `managingFocus` = varAsSignal(Var(outer.isManagingFocus))
    override lazy val `maximumSize` = {
      val res = Var(outer.getMaximumSize)
      res foreach (e => if (e != outer.getMaximumSize) outer.setMaximumSize(e))
      res
    }
    override lazy val `minimumSize` = {
      val res = Var(outer.getMinimumSize)
      res foreach (e => if (e != outer.getMinimumSize) outer.setMinimumSize(e))
      res
    }
    lazy val `nextFocusableComponent` = {
      val res = Var(outer.getNextFocusableComponent)
      res foreach (e => if (e != outer.getNextFocusableComponent) outer.setNextFocusableComponent(e))
      res
    }
    lazy val `opaque` = {
      val res = Var(outer.isOpaque)
      res foreach (e => if (e != outer.isOpaque) outer.setOpaque(e))
      res
    }
    lazy val `optimizedDrawingEnabled` = varAsSignal(Var(outer.isOptimizedDrawingEnabled))
    lazy val `paintingForPrint` = varAsSignal(Var(outer.isPaintingForPrint))
    lazy val `paintingTile` = varAsSignal(Var(outer.isPaintingTile))
    override lazy val `preferredSize` = {
      val res = Var(outer.getPreferredSize)
      res foreach (e => if (e != outer.getPreferredSize) outer.setPreferredSize(e))
      res
    }
    lazy val `registeredKeyStrokes` = varAsSignal(Var(outer.getRegisteredKeyStrokes))
    lazy val `requestFocusEnabled` = {
      val res = Var(outer.isRequestFocusEnabled)
      res foreach (e => if (e != outer.isRequestFocusEnabled) outer.setRequestFocusEnabled(e))
      res
    }
    lazy val `rootPane` = varAsSignal(Var(outer.getRootPane))
    lazy val `toolTipText` = {
      val res = Var(outer.getToolTipText)
      res foreach (e => if (e != outer.getToolTipText) outer.setToolTipText(e))
      res
    }
    lazy val `topLevelAncestor` = varAsSignal(Var(outer.getTopLevelAncestor))
    lazy val `transferHandler` = {
      val res = Var(outer.getTransferHandler)
      res foreach (e => if (e != outer.getTransferHandler) outer.setTransferHandler(e))
      res
    }
    lazy val `verifyInputWhenFocusTarget` = {
      val res = Var(outer.getVerifyInputWhenFocusTarget)
      res foreach (e => if (e != outer.getVerifyInputWhenFocusTarget) outer.setVerifyInputWhenFocusTarget(e))
      res
    }
    lazy val `vetoableChangeListeners` = varAsSignal(Var(outer.getVetoableChangeListeners))
    lazy val `visibleRect` = varAsSignal(Var(outer.getVisibleRect))
    lazy val `width` = varAsSignal(Var(outer.getWidth))
    lazy val `x` = varAsSignal(Var(outer.getX))
    lazy val `y` = varAsSignal(Var(outer.getY))
    
    outer.addPropertyChangeListener(new java.beans.PropertyChangeListener {
      def propertyChange(evt: java.beans.PropertyChangeEvent) {
        def assign[T](s: Signal[T], value: Any) = s match {case v: Var[_] => v.asInstanceOf[Var[T]].value = value.asInstanceOf[T]; case _ =>}
        evt.getPropertyName match {
          case "`UIClassID`" => assign(`UIClassID`, evt.getNewValue)
          case "`accessibleContext`" => assign(`accessibleContext`, evt.getNewValue)
          case "`actionMap`" => assign(`actionMap`, evt.getNewValue)
          case "`alignmentX`" => assign(`alignmentX`, evt.getNewValue)
          case "`alignmentY`" => assign(`alignmentY`, evt.getNewValue)
          case "`ancestorListeners`" => assign(`ancestorListeners`, evt.getNewValue)
          case "`autoscrolls`" => assign(`autoscrolls`, evt.getNewValue)
          case "`baselineResizeBehavior`" => assign(`baselineResizeBehavior`, evt.getNewValue)
          case "`border`" => assign(`border`, evt.getNewValue)
          case "`componentPopupMenu`" => assign(`componentPopupMenu`, evt.getNewValue)
          case "`debugGraphicsOptions`" => assign(`debugGraphicsOptions`, evt.getNewValue)
          case "`doubleBuffered`" => assign(`doubleBuffered`, evt.getNewValue)
          case "`graphics`" => assign(`graphics`, evt.getNewValue)
          case "`height`" => assign(`height`, evt.getNewValue)
          case "`inheritsPopupMenu`" => assign(`inheritsPopupMenu`, evt.getNewValue)
          case "`inputVerifier`" => assign(`inputVerifier`, evt.getNewValue)
          case "`managingFocus`" => assign(`managingFocus`, evt.getNewValue)
          case "`maximumSize`" => assign(`maximumSize`, evt.getNewValue)
          case "`minimumSize`" => assign(`minimumSize`, evt.getNewValue)
          case "`nextFocusableComponent`" => assign(`nextFocusableComponent`, evt.getNewValue)
          case "`opaque`" => assign(`opaque`, evt.getNewValue)
          case "`optimizedDrawingEnabled`" => assign(`optimizedDrawingEnabled`, evt.getNewValue)
          case "`paintingForPrint`" => assign(`paintingForPrint`, evt.getNewValue)
          case "`paintingTile`" => assign(`paintingTile`, evt.getNewValue)
          case "`preferredSize`" => assign(`preferredSize`, evt.getNewValue)
          case "`registeredKeyStrokes`" => assign(`registeredKeyStrokes`, evt.getNewValue)
          case "`requestFocusEnabled`" => assign(`requestFocusEnabled`, evt.getNewValue)
          case "`rootPane`" => assign(`rootPane`, evt.getNewValue)
          case "`toolTipText`" => assign(`toolTipText`, evt.getNewValue)
          case "`topLevelAncestor`" => assign(`topLevelAncestor`, evt.getNewValue)
          case "`transferHandler`" => assign(`transferHandler`, evt.getNewValue)
          case "`verifyInputWhenFocusTarget`" => assign(`verifyInputWhenFocusTarget`, evt.getNewValue)
          case "`vetoableChangeListeners`" => assign(`vetoableChangeListeners`, evt.getNewValue)
          case "`visibleRect`" => assign(`visibleRect`, evt.getNewValue)
          case "`width`" => assign(`width`, evt.getNewValue)
          case "`x`" => assign(`x`, evt.getNewValue)
          case "`y`" => assign(`y`, evt.getNewValue)
          case _ =>
        }
      }
    })
  }
  
  override lazy val signals = new Signals {}
  
  trait EventStreams extends super.EventStreams {
    object ancestor {
      val ancestorMoved = new ESource[javax.swing.event.AncestorEvent]
      val ancestorAdded = new ESource[javax.swing.event.AncestorEvent]
      val ancestorRemoved = new ESource[javax.swing.event.AncestorEvent]
    }
    outer.addAncestorListener(new javax.swing.event.AncestorListener {
      def ancestorMoved(evt: javax.swing.event.AncestorEvent) {EventStreams.this.ancestor.ancestorMoved.fire(evt)}
      def ancestorAdded(evt: javax.swing.event.AncestorEvent) {EventStreams.this.ancestor.ancestorAdded.fire(evt)}
      def ancestorRemoved(evt: javax.swing.event.AncestorEvent) {EventStreams.this.ancestor.ancestorRemoved.fire(evt)}
    })
    object vetoableChange {
      val vetoableChange = new ESource[java.beans.PropertyChangeEvent]
    }
    outer.addVetoableChangeListener(new java.beans.VetoableChangeListener {
      def vetoableChange(evt: java.beans.PropertyChangeEvent) {EventStreams.this.vetoableChange.vetoableChange.fire(evt)}
    })
  }
  
  override lazy val events = new EventStreams {}
  

}
