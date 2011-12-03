package reactive.jswing

import reactive._

//This file was auto generated
trait ComponentReactive extends java.awt.Component with Observing {
  outer =>
  trait Signals {
    lazy val `background` = {
      val res = Var(outer.getBackground)
      res foreach (e => if (e != outer.getBackground) outer.setBackground(e))
      res
    }
    lazy val `enabled` = {
      val res = Var(outer.isEnabled)
      res foreach (e => if (e != outer.isEnabled) outer.setEnabled(e))
      res
    }
    lazy val `focusable` = {
      val res = Var(outer.isFocusable)
      res foreach (e => if (e != outer.isFocusable) outer.setFocusable(e))
      res
    }
    lazy val `font` = {
      val res = Var(outer.getFont)
      res foreach (e => if (e != outer.getFont) outer.setFont(e))
      res
    }
    lazy val `foreground` = {
      val res = Var(outer.getForeground)
      res foreach (e => if (e != outer.getForeground) outer.setForeground(e))
      res
    }
    lazy val `name` = {
      val res = Var(outer.getName)
      res foreach (e => if (e != outer.getName) outer.setName(e))
      res
    }
    lazy val `visible` = {
      val res = Var(outer.isVisible)
      res foreach (e => if (e != outer.isVisible) outer.setVisible(e))
      res
    }
    
    outer.addPropertyChangeListener(new java.beans.PropertyChangeListener {
      def propertyChange(evt: java.beans.PropertyChangeEvent) {
        def assign[T](s: Signal[T], value: Any) = s match {case v: Var[_] => v.asInstanceOf[Var[T]].value = value.asInstanceOf[T]; case _ =>}
        evt.getPropertyName match {
          case "`background`" => assign(`background`, evt.getNewValue)
          case "`enabled`" => assign(`enabled`, evt.getNewValue)
          case "`focusable`" => assign(`focusable`, evt.getNewValue)
          case "`font`" => assign(`font`, evt.getNewValue)
          case "`foreground`" => assign(`foreground`, evt.getNewValue)
          case "`name`" => assign(`name`, evt.getNewValue)
          case "`visible`" => assign(`visible`, evt.getNewValue)
          case _ =>
        }
      }
    })
  }
  
  lazy val signals = new Signals {}
  
  trait EventStreams {
    class ESource[T] extends EventSource[T]
    object mouseWheel {
      val mouseWheelMoved = new ESource[java.awt.event.MouseWheelEvent]
    }
    outer.addMouseWheelListener(new java.awt.event.MouseWheelListener {
      def mouseWheelMoved(evt: java.awt.event.MouseWheelEvent) {EventStreams.this.mouseWheel.mouseWheelMoved.fire(evt)}
    })
    object mouse {
      val mousePressed = new ESource[java.awt.event.MouseEvent]
      val mouseReleased = new ESource[java.awt.event.MouseEvent]
      val mouseClicked = new ESource[java.awt.event.MouseEvent]
      val mouseExited = new ESource[java.awt.event.MouseEvent]
      val mouseEntered = new ESource[java.awt.event.MouseEvent]
    }
    outer.addMouseListener(new java.awt.event.MouseListener {
      def mousePressed(evt: java.awt.event.MouseEvent) {EventStreams.this.mouse.mousePressed.fire(evt)}
      def mouseReleased(evt: java.awt.event.MouseEvent) {EventStreams.this.mouse.mouseReleased.fire(evt)}
      def mouseClicked(evt: java.awt.event.MouseEvent) {EventStreams.this.mouse.mouseClicked.fire(evt)}
      def mouseExited(evt: java.awt.event.MouseEvent) {EventStreams.this.mouse.mouseExited.fire(evt)}
      def mouseEntered(evt: java.awt.event.MouseEvent) {EventStreams.this.mouse.mouseEntered.fire(evt)}
    })
    object mouseMotion {
      val mouseMoved = new ESource[java.awt.event.MouseEvent]
      val mouseDragged = new ESource[java.awt.event.MouseEvent]
    }
    outer.addMouseMotionListener(new java.awt.event.MouseMotionListener {
      def mouseMoved(evt: java.awt.event.MouseEvent) {EventStreams.this.mouseMotion.mouseMoved.fire(evt)}
      def mouseDragged(evt: java.awt.event.MouseEvent) {EventStreams.this.mouseMotion.mouseDragged.fire(evt)}
    })
    object component {
      val componentResized = new ESource[java.awt.event.ComponentEvent]
      val componentMoved = new ESource[java.awt.event.ComponentEvent]
      val componentShown = new ESource[java.awt.event.ComponentEvent]
      val componentHidden = new ESource[java.awt.event.ComponentEvent]
    }
    outer.addComponentListener(new java.awt.event.ComponentListener {
      def componentResized(evt: java.awt.event.ComponentEvent) {EventStreams.this.component.componentResized.fire(evt)}
      def componentMoved(evt: java.awt.event.ComponentEvent) {EventStreams.this.component.componentMoved.fire(evt)}
      def componentShown(evt: java.awt.event.ComponentEvent) {EventStreams.this.component.componentShown.fire(evt)}
      def componentHidden(evt: java.awt.event.ComponentEvent) {EventStreams.this.component.componentHidden.fire(evt)}
    })
    object hierarchyBounds {
      val ancestorMoved = new ESource[java.awt.event.HierarchyEvent]
      val ancestorResized = new ESource[java.awt.event.HierarchyEvent]
    }
    outer.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener {
      def ancestorMoved(evt: java.awt.event.HierarchyEvent) {EventStreams.this.hierarchyBounds.ancestorMoved.fire(evt)}
      def ancestorResized(evt: java.awt.event.HierarchyEvent) {EventStreams.this.hierarchyBounds.ancestorResized.fire(evt)}
    })
    object focus {
      val focusGained = new ESource[java.awt.event.FocusEvent]
      val focusLost = new ESource[java.awt.event.FocusEvent]
    }
    outer.addFocusListener(new java.awt.event.FocusListener {
      def focusGained(evt: java.awt.event.FocusEvent) {EventStreams.this.focus.focusGained.fire(evt)}
      def focusLost(evt: java.awt.event.FocusEvent) {EventStreams.this.focus.focusLost.fire(evt)}
    })
    object hierarchy {
      val hierarchyChanged = new ESource[java.awt.event.HierarchyEvent]
    }
    outer.addHierarchyListener(new java.awt.event.HierarchyListener {
      def hierarchyChanged(evt: java.awt.event.HierarchyEvent) {EventStreams.this.hierarchy.hierarchyChanged.fire(evt)}
    })
    object propertyChange {
      val propertyChange = new ESource[java.beans.PropertyChangeEvent]
    }
    outer.addPropertyChangeListener(new java.beans.PropertyChangeListener {
      def propertyChange(evt: java.beans.PropertyChangeEvent) {EventStreams.this.propertyChange.propertyChange.fire(evt)}
    })
    object inputMethod {
      val inputMethodTextChanged = new ESource[java.awt.event.InputMethodEvent]
      val caretPositionChanged = new ESource[java.awt.event.InputMethodEvent]
    }
    outer.addInputMethodListener(new java.awt.event.InputMethodListener {
      def inputMethodTextChanged(evt: java.awt.event.InputMethodEvent) {EventStreams.this.inputMethod.inputMethodTextChanged.fire(evt)}
      def caretPositionChanged(evt: java.awt.event.InputMethodEvent) {EventStreams.this.inputMethod.caretPositionChanged.fire(evt)}
    })
    object key {
      val keyTyped = new ESource[java.awt.event.KeyEvent]
      val keyPressed = new ESource[java.awt.event.KeyEvent]
      val keyReleased = new ESource[java.awt.event.KeyEvent]
    }
    outer.addKeyListener(new java.awt.event.KeyListener {
      def keyTyped(evt: java.awt.event.KeyEvent) {EventStreams.this.key.keyTyped.fire(evt)}
      def keyPressed(evt: java.awt.event.KeyEvent) {EventStreams.this.key.keyPressed.fire(evt)}
      def keyReleased(evt: java.awt.event.KeyEvent) {EventStreams.this.key.keyReleased.fire(evt)}
    })
  }
  
  lazy val events = new EventStreams {}
  

}
