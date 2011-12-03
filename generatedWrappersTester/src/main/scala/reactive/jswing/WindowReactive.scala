package reactive.jswing

import reactive._

//This file was auto generated
trait WindowReactive extends java.awt.Window with ContainerReactive {
  outer =>
  trait Signals extends super.Signals {
    //helper method to treat var as signals without specifying the type
    //which might arise visibility problems (e.g.: the listeners field in scala.swing.Component
    @inline private[this] def varAsSignal[T](v: Var[T]) = v: Signal[T]
    lazy val `accessibleContext` = varAsSignal(Var(outer.getAccessibleContext))
    lazy val `active` = varAsSignal(Var(outer.isActive))
    lazy val `alwaysOnTop` = {
      val res = Var(outer.isAlwaysOnTop)
      res foreach (e => if (e != outer.isAlwaysOnTop) outer.setAlwaysOnTop(e))
      res
    }
    lazy val `alwaysOnTopSupported` = varAsSignal(Var(outer.isAlwaysOnTopSupported))
    lazy val `autoRequestFocus` = {
      val res = Var(outer.isAutoRequestFocus)
      res foreach (e => if (e != outer.isAutoRequestFocus) outer.setAutoRequestFocus(e))
      res
    }
    lazy val `bufferStrategy` = varAsSignal(Var(outer.getBufferStrategy))
    lazy val `focusCycleRootAncestor` = varAsSignal(Var(outer.getFocusCycleRootAncestor))
    lazy val `focusOwner` = varAsSignal(Var(outer.getFocusOwner))
    lazy val `focusableWindow` = varAsSignal(Var(outer.isFocusableWindow))
    lazy val `focusableWindowState` = {
      val res = Var(outer.getFocusableWindowState)
      res foreach (e => if (e != outer.getFocusableWindowState) outer.setFocusableWindowState(e))
      res
    }
    lazy val `focused` = varAsSignal(Var(outer.isFocused))
    lazy val `iconImages` = {
      val res = Var(outer.getIconImages)
      res foreach (e => if (e != outer.getIconImages) outer.setIconImages(e))
      res
    }
    lazy val `inputContext` = varAsSignal(Var(outer.getInputContext))
    lazy val `locale` = varAsSignal(Var(outer.getLocale))
    lazy val `locationByPlatform` = {
      val res = Var(outer.isLocationByPlatform)
      res foreach (e => if (e != outer.isLocationByPlatform) outer.setLocationByPlatform(e))
      res
    }
    lazy val `modalExclusionType` = {
      val res = Var(outer.getModalExclusionType)
      res foreach (e => if (e != outer.getModalExclusionType) outer.setModalExclusionType(e))
      res
    }
    lazy val `mostRecentFocusOwner` = varAsSignal(Var(outer.getMostRecentFocusOwner))
    lazy val `opacity` = {
      val res = Var(outer.getOpacity)
      res foreach (e => if (e != outer.getOpacity) outer.setOpacity(e))
      res
    }
    lazy val `opaque` = varAsSignal(Var(outer.isOpaque))
    lazy val `ownedWindows` = varAsSignal(Var(outer.getOwnedWindows))
    lazy val `owner` = varAsSignal(Var(outer.getOwner))
    lazy val `shape` = {
      val res = Var(outer.getShape)
      res foreach (e => if (e != outer.getShape) outer.setShape(e))
      res
    }
    lazy val `showing` = varAsSignal(Var(outer.isShowing))
    lazy val `toolkit` = varAsSignal(Var(outer.getToolkit))
    lazy val `type` = {
      val res = Var(outer.getType)
      res foreach (e => if (e != outer.getType) outer.setType(e))
      res
    }
    lazy val `warningString` = varAsSignal(Var(outer.getWarningString))
    lazy val `windowFocusListeners` = varAsSignal(Var(outer.getWindowFocusListeners))
    lazy val `windowListeners` = varAsSignal(Var(outer.getWindowListeners))
    lazy val `windowStateListeners` = varAsSignal(Var(outer.getWindowStateListeners))
    
    outer.addPropertyChangeListener(new java.beans.PropertyChangeListener {
      def propertyChange(evt: java.beans.PropertyChangeEvent) {
        def assign[T](s: Signal[T], value: Any) = s match {case v: Var[_] => v.asInstanceOf[Var[T]].value = value.asInstanceOf[T]; case _ =>}
        evt.getPropertyName match {
          case "`accessibleContext`" => assign(`accessibleContext`, evt.getNewValue)
          case "`active`" => assign(`active`, evt.getNewValue)
          case "`alwaysOnTop`" => assign(`alwaysOnTop`, evt.getNewValue)
          case "`alwaysOnTopSupported`" => assign(`alwaysOnTopSupported`, evt.getNewValue)
          case "`autoRequestFocus`" => assign(`autoRequestFocus`, evt.getNewValue)
          case "`bufferStrategy`" => assign(`bufferStrategy`, evt.getNewValue)
          case "`focusCycleRootAncestor`" => assign(`focusCycleRootAncestor`, evt.getNewValue)
          case "`focusOwner`" => assign(`focusOwner`, evt.getNewValue)
          case "`focusableWindow`" => assign(`focusableWindow`, evt.getNewValue)
          case "`focusableWindowState`" => assign(`focusableWindowState`, evt.getNewValue)
          case "`focused`" => assign(`focused`, evt.getNewValue)
          case "`iconImages`" => assign(`iconImages`, evt.getNewValue)
          case "`inputContext`" => assign(`inputContext`, evt.getNewValue)
          case "`locale`" => assign(`locale`, evt.getNewValue)
          case "`locationByPlatform`" => assign(`locationByPlatform`, evt.getNewValue)
          case "`modalExclusionType`" => assign(`modalExclusionType`, evt.getNewValue)
          case "`mostRecentFocusOwner`" => assign(`mostRecentFocusOwner`, evt.getNewValue)
          case "`opacity`" => assign(`opacity`, evt.getNewValue)
          case "`opaque`" => assign(`opaque`, evt.getNewValue)
          case "`ownedWindows`" => assign(`ownedWindows`, evt.getNewValue)
          case "`owner`" => assign(`owner`, evt.getNewValue)
          case "`shape`" => assign(`shape`, evt.getNewValue)
          case "`showing`" => assign(`showing`, evt.getNewValue)
          case "`toolkit`" => assign(`toolkit`, evt.getNewValue)
          case "`type`" => assign(`type`, evt.getNewValue)
          case "`warningString`" => assign(`warningString`, evt.getNewValue)
          case "`windowFocusListeners`" => assign(`windowFocusListeners`, evt.getNewValue)
          case "`windowListeners`" => assign(`windowListeners`, evt.getNewValue)
          case "`windowStateListeners`" => assign(`windowStateListeners`, evt.getNewValue)
          case _ =>
        }
      }
    })
  }
  
  override lazy val signals = new Signals {}
  
  trait EventStreams extends super.EventStreams {
    object windowFocus {
      val windowGainedFocus = new ESource[java.awt.event.WindowEvent]
      val windowLostFocus = new ESource[java.awt.event.WindowEvent]
    }
    outer.addWindowFocusListener(new java.awt.event.WindowFocusListener {
      def windowGainedFocus(evt: java.awt.event.WindowEvent) {EventStreams.this.windowFocus.windowGainedFocus.fire(evt)}
      def windowLostFocus(evt: java.awt.event.WindowEvent) {EventStreams.this.windowFocus.windowLostFocus.fire(evt)}
    })
    object window {
      val windowOpened = new ESource[java.awt.event.WindowEvent]
      val windowClosing = new ESource[java.awt.event.WindowEvent]
      val windowDeactivated = new ESource[java.awt.event.WindowEvent]
      val windowActivated = new ESource[java.awt.event.WindowEvent]
      val windowDeiconified = new ESource[java.awt.event.WindowEvent]
      val windowIconified = new ESource[java.awt.event.WindowEvent]
      val windowClosed = new ESource[java.awt.event.WindowEvent]
    }
    outer.addWindowListener(new java.awt.event.WindowListener {
      def windowOpened(evt: java.awt.event.WindowEvent) {EventStreams.this.window.windowOpened.fire(evt)}
      def windowClosing(evt: java.awt.event.WindowEvent) {EventStreams.this.window.windowClosing.fire(evt)}
      def windowDeactivated(evt: java.awt.event.WindowEvent) {EventStreams.this.window.windowDeactivated.fire(evt)}
      def windowActivated(evt: java.awt.event.WindowEvent) {EventStreams.this.window.windowActivated.fire(evt)}
      def windowDeiconified(evt: java.awt.event.WindowEvent) {EventStreams.this.window.windowDeiconified.fire(evt)}
      def windowIconified(evt: java.awt.event.WindowEvent) {EventStreams.this.window.windowIconified.fire(evt)}
      def windowClosed(evt: java.awt.event.WindowEvent) {EventStreams.this.window.windowClosed.fire(evt)}
    })
    object windowState {
      val windowStateChanged = new ESource[java.awt.event.WindowEvent]
    }
    outer.addWindowStateListener(new java.awt.event.WindowStateListener {
      def windowStateChanged(evt: java.awt.event.WindowEvent) {EventStreams.this.windowState.windowStateChanged.fire(evt)}
    })
  }
  
  override lazy val events = new EventStreams {}
  

}
