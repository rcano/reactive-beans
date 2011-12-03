package reactive.jswing

import reactive._

//This file was auto generated
trait JMenuReactiveProxy extends JMenuItemReactiveProxy  {
  override def peer: javax.swing.JMenu
  private[JMenuReactiveProxy] lazy val outer = peer
  trait Signals extends super.Signals {
    //helper method to treat var as signals without specifying the type
    //which might arise visibility problems (e.g.: the listeners field in scala.swing.Component
    @inline private[this] def varAsSignal[T](v: Var[T]) = v: Signal[T]
    lazy val `delay` = {
      val res = Var(outer.getDelay)
      res foreach (e => if (e != outer.getDelay) outer.setDelay(e))
      res
    }
    lazy val `itemCount` = varAsSignal(Var(outer.getItemCount))
    lazy val `menuComponentCount` = varAsSignal(Var(outer.getMenuComponentCount))
    lazy val `menuComponents` = varAsSignal(Var(outer.getMenuComponents))
    lazy val `menuListeners` = varAsSignal(Var(outer.getMenuListeners))
    lazy val `popupMenu` = varAsSignal(Var(outer.getPopupMenu))
    lazy val `popupMenuVisible` = {
      val res = Var(outer.isPopupMenuVisible)
      res foreach (e => if (e != outer.isPopupMenuVisible) outer.setPopupMenuVisible(e))
      res
    }
    lazy val `tearOff` = varAsSignal(Var(outer.isTearOff))
    lazy val `topLevelMenu` = varAsSignal(Var(outer.isTopLevelMenu))
    
    outer.addPropertyChangeListener(new java.beans.PropertyChangeListener {
      def propertyChange(evt: java.beans.PropertyChangeEvent) {
        def assign[T](s: Signal[T], value: Any) = s match {case v: Var[_] => v.asInstanceOf[Var[T]].value = value.asInstanceOf[T]; case _ =>}
        evt.getPropertyName match {
          case "`delay`" => assign(`delay`, evt.getNewValue)
          case "`itemCount`" => assign(`itemCount`, evt.getNewValue)
          case "`menuComponentCount`" => assign(`menuComponentCount`, evt.getNewValue)
          case "`menuComponents`" => assign(`menuComponents`, evt.getNewValue)
          case "`menuListeners`" => assign(`menuListeners`, evt.getNewValue)
          case "`popupMenu`" => assign(`popupMenu`, evt.getNewValue)
          case "`popupMenuVisible`" => assign(`popupMenuVisible`, evt.getNewValue)
          case "`tearOff`" => assign(`tearOff`, evt.getNewValue)
          case "`topLevelMenu`" => assign(`topLevelMenu`, evt.getNewValue)
          case _ =>
        }
      }
    })
  }
  
  override lazy val signals = new Signals {}
  
  trait EventStreams extends super.EventStreams {
    object menu {
      val menuSelected = new ESource[javax.swing.event.MenuEvent]
      val menuDeselected = new ESource[javax.swing.event.MenuEvent]
      val menuCanceled = new ESource[javax.swing.event.MenuEvent]
    }
    outer.addMenuListener(new javax.swing.event.MenuListener {
      def menuSelected(evt: javax.swing.event.MenuEvent) {EventStreams.this.menu.menuSelected.fire(evt)}
      def menuDeselected(evt: javax.swing.event.MenuEvent) {EventStreams.this.menu.menuDeselected.fire(evt)}
      def menuCanceled(evt: javax.swing.event.MenuEvent) {EventStreams.this.menu.menuCanceled.fire(evt)}
    })
  }
  
  override lazy val events = new EventStreams {}
  

}
