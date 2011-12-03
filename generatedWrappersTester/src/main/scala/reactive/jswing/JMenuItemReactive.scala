package reactive.jswing

import reactive._

//This file was auto generated
trait JMenuItemReactive extends javax.swing.JMenuItem with AbstractButtonReactive {
  outer =>
  trait Signals extends super.Signals {
    //helper method to treat var as signals without specifying the type
    //which might arise visibility problems (e.g.: the listeners field in scala.swing.Component
    @inline private[this] def varAsSignal[T](v: Var[T]) = v: Signal[T]
    lazy val `accelerator` = {
      val res = Var(outer.getAccelerator)
      res foreach (e => if (e != outer.getAccelerator) outer.setAccelerator(e))
      res
    }
    lazy val `armed` = {
      val res = Var(outer.isArmed)
      res foreach (e => if (e != outer.isArmed) outer.setArmed(e))
      res
    }
    lazy val `component` = varAsSignal(Var(outer.getComponent))
    lazy val `menuDragMouseListeners` = varAsSignal(Var(outer.getMenuDragMouseListeners))
    lazy val `menuKeyListeners` = varAsSignal(Var(outer.getMenuKeyListeners))
    lazy val `subElements` = varAsSignal(Var(outer.getSubElements))
    
    outer.addPropertyChangeListener(new java.beans.PropertyChangeListener {
      def propertyChange(evt: java.beans.PropertyChangeEvent) {
        def assign[T](s: Signal[T], value: Any) = s match {case v: Var[_] => v.asInstanceOf[Var[T]].value = value.asInstanceOf[T]; case _ =>}
        evt.getPropertyName match {
          case "`accelerator`" => assign(`accelerator`, evt.getNewValue)
          case "`armed`" => assign(`armed`, evt.getNewValue)
          case "`component`" => assign(`component`, evt.getNewValue)
          case "`menuDragMouseListeners`" => assign(`menuDragMouseListeners`, evt.getNewValue)
          case "`menuKeyListeners`" => assign(`menuKeyListeners`, evt.getNewValue)
          case "`subElements`" => assign(`subElements`, evt.getNewValue)
          case _ =>
        }
      }
    })
  }
  
  override lazy val signals = new Signals {}
  
  trait EventStreams extends super.EventStreams {
    object menuKey {
      val menuKeyPressed = new ESource[javax.swing.event.MenuKeyEvent]
      val menuKeyReleased = new ESource[javax.swing.event.MenuKeyEvent]
      val menuKeyTyped = new ESource[javax.swing.event.MenuKeyEvent]
    }
    outer.addMenuKeyListener(new javax.swing.event.MenuKeyListener {
      def menuKeyPressed(evt: javax.swing.event.MenuKeyEvent) {EventStreams.this.menuKey.menuKeyPressed.fire(evt)}
      def menuKeyReleased(evt: javax.swing.event.MenuKeyEvent) {EventStreams.this.menuKey.menuKeyReleased.fire(evt)}
      def menuKeyTyped(evt: javax.swing.event.MenuKeyEvent) {EventStreams.this.menuKey.menuKeyTyped.fire(evt)}
    })
    object menuDragMouse {
      val menuDragMouseEntered = new ESource[javax.swing.event.MenuDragMouseEvent]
      val menuDragMouseExited = new ESource[javax.swing.event.MenuDragMouseEvent]
      val menuDragMouseDragged = new ESource[javax.swing.event.MenuDragMouseEvent]
      val menuDragMouseReleased = new ESource[javax.swing.event.MenuDragMouseEvent]
    }
    outer.addMenuDragMouseListener(new javax.swing.event.MenuDragMouseListener {
      def menuDragMouseEntered(evt: javax.swing.event.MenuDragMouseEvent) {EventStreams.this.menuDragMouse.menuDragMouseEntered.fire(evt)}
      def menuDragMouseExited(evt: javax.swing.event.MenuDragMouseEvent) {EventStreams.this.menuDragMouse.menuDragMouseExited.fire(evt)}
      def menuDragMouseDragged(evt: javax.swing.event.MenuDragMouseEvent) {EventStreams.this.menuDragMouse.menuDragMouseDragged.fire(evt)}
      def menuDragMouseReleased(evt: javax.swing.event.MenuDragMouseEvent) {EventStreams.this.menuDragMouse.menuDragMouseReleased.fire(evt)}
    })
  }
  
  override lazy val events = new EventStreams {}
  

}
