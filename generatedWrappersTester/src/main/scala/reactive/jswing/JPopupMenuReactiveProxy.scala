package reactive.jswing

import reactive._

//This file was auto generated
trait JPopupMenuReactiveProxy extends JComponentReactiveProxy  {
  override def peer: javax.swing.JPopupMenu
  private[JPopupMenuReactiveProxy] lazy val outer = peer
  trait Signals extends super.Signals {
    //helper method to treat var as signals without specifying the type
    //which might arise visibility problems (e.g.: the listeners field in scala.swing.Component
    @inline private[this] def varAsSignal[T](v: Var[T]) = v: Signal[T]
    lazy val `UI` = {
      val res = Var(outer.getUI)
      res foreach (e => if (e != outer.getUI) outer.setUI(e))
      res
    }
    lazy val `borderPainted` = {
      val res = Var(outer.isBorderPainted)
      res foreach (e => if (e != outer.isBorderPainted) outer.setBorderPainted(e))
      res
    }
    lazy val `component` = varAsSignal(Var(outer.getComponent))
    lazy val `invoker` = {
      val res = Var(outer.getInvoker)
      res foreach (e => if (e != outer.getInvoker) outer.setInvoker(e))
      res
    }
    lazy val `label` = {
      val res = Var(outer.getLabel)
      res foreach (e => if (e != outer.getLabel) outer.setLabel(e))
      res
    }
    lazy val `lightWeightPopupEnabled` = {
      val res = Var(outer.isLightWeightPopupEnabled)
      res foreach (e => if (e != outer.isLightWeightPopupEnabled) outer.setLightWeightPopupEnabled(e))
      res
    }
    lazy val `margin` = varAsSignal(Var(outer.getMargin))
    lazy val `menuKeyListeners` = varAsSignal(Var(outer.getMenuKeyListeners))
    lazy val `popupMenuListeners` = varAsSignal(Var(outer.getPopupMenuListeners))
    lazy val `selectionModel` = {
      val res = Var(outer.getSelectionModel)
      res foreach (e => if (e != outer.getSelectionModel) outer.setSelectionModel(e))
      res
    }
    lazy val `subElements` = varAsSignal(Var(outer.getSubElements))
    
    outer.addPropertyChangeListener(new java.beans.PropertyChangeListener {
      def propertyChange(evt: java.beans.PropertyChangeEvent) {
        def assign[T](s: Signal[T], value: Any) = s match {case v: Var[_] => v.asInstanceOf[Var[T]].value = value.asInstanceOf[T]; case _ =>}
        evt.getPropertyName match {
          case "`UI`" => assign(`UI`, evt.getNewValue)
          case "`borderPainted`" => assign(`borderPainted`, evt.getNewValue)
          case "`component`" => assign(`component`, evt.getNewValue)
          case "`invoker`" => assign(`invoker`, evt.getNewValue)
          case "`label`" => assign(`label`, evt.getNewValue)
          case "`lightWeightPopupEnabled`" => assign(`lightWeightPopupEnabled`, evt.getNewValue)
          case "`margin`" => assign(`margin`, evt.getNewValue)
          case "`menuKeyListeners`" => assign(`menuKeyListeners`, evt.getNewValue)
          case "`popupMenuListeners`" => assign(`popupMenuListeners`, evt.getNewValue)
          case "`selectionModel`" => assign(`selectionModel`, evt.getNewValue)
          case "`subElements`" => assign(`subElements`, evt.getNewValue)
          case _ =>
        }
      }
    })
  }
  
  override lazy val signals = new Signals {}
  
  trait EventStreams extends super.EventStreams {
    object popupMenu {
      val popupMenuWillBecomeVisible = new ESource[javax.swing.event.PopupMenuEvent]
      val popupMenuWillBecomeInvisible = new ESource[javax.swing.event.PopupMenuEvent]
      val popupMenuCanceled = new ESource[javax.swing.event.PopupMenuEvent]
    }
    outer.addPopupMenuListener(new javax.swing.event.PopupMenuListener {
      def popupMenuWillBecomeVisible(evt: javax.swing.event.PopupMenuEvent) {EventStreams.this.popupMenu.popupMenuWillBecomeVisible.fire(evt)}
      def popupMenuWillBecomeInvisible(evt: javax.swing.event.PopupMenuEvent) {EventStreams.this.popupMenu.popupMenuWillBecomeInvisible.fire(evt)}
      def popupMenuCanceled(evt: javax.swing.event.PopupMenuEvent) {EventStreams.this.popupMenu.popupMenuCanceled.fire(evt)}
    })
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
  }
  
  override lazy val events = new EventStreams {}
  

}
