package reactive.jswing

import reactive._

//This file was auto generated
trait JViewportReactiveProxy extends JComponentReactiveProxy  {
  override def peer: javax.swing.JViewport
  private[JViewportReactiveProxy] lazy val outer = peer
  trait Signals extends super.Signals {
    //helper method to treat var as signals without specifying the type
    //which might arise visibility problems (e.g.: the listeners field in scala.swing.Component
    @inline private[this] def varAsSignal[T](v: Var[T]) = v: Signal[T]
    lazy val `UI` = {
      val res = Var(outer.getUI)
      res foreach (e => if (e != outer.getUI) outer.setUI(e))
      res
    }
    lazy val `backingStoreEnabled` = {
      val res = Var(outer.isBackingStoreEnabled)
      res foreach (e => if (e != outer.isBackingStoreEnabled) outer.setBackingStoreEnabled(e))
      res
    }
    lazy val `changeListeners` = varAsSignal(Var(outer.getChangeListeners))
    lazy val `extentSize` = {
      val res = Var(outer.getExtentSize)
      res foreach (e => if (e != outer.getExtentSize) outer.setExtentSize(e))
      res
    }
    lazy val `scrollMode` = {
      val res = Var(outer.getScrollMode)
      res foreach (e => if (e != outer.getScrollMode) outer.setScrollMode(e))
      res
    }
    lazy val `view` = {
      val res = Var(outer.getView)
      res foreach (e => if (e != outer.getView) outer.setView(e))
      res
    }
    lazy val `viewPosition` = {
      val res = Var(outer.getViewPosition)
      res foreach (e => if (e != outer.getViewPosition) outer.setViewPosition(e))
      res
    }
    lazy val `viewRect` = varAsSignal(Var(outer.getViewRect))
    lazy val `viewSize` = {
      val res = Var(outer.getViewSize)
      res foreach (e => if (e != outer.getViewSize) outer.setViewSize(e))
      res
    }
    
    outer.addPropertyChangeListener(new java.beans.PropertyChangeListener {
      def propertyChange(evt: java.beans.PropertyChangeEvent) {
        def assign[T](s: Signal[T], value: Any) = s match {case v: Var[_] => v.asInstanceOf[Var[T]].value = value.asInstanceOf[T]; case _ =>}
        evt.getPropertyName match {
          case "`UI`" => assign(`UI`, evt.getNewValue)
          case "`backingStoreEnabled`" => assign(`backingStoreEnabled`, evt.getNewValue)
          case "`changeListeners`" => assign(`changeListeners`, evt.getNewValue)
          case "`extentSize`" => assign(`extentSize`, evt.getNewValue)
          case "`scrollMode`" => assign(`scrollMode`, evt.getNewValue)
          case "`view`" => assign(`view`, evt.getNewValue)
          case "`viewPosition`" => assign(`viewPosition`, evt.getNewValue)
          case "`viewRect`" => assign(`viewRect`, evt.getNewValue)
          case "`viewSize`" => assign(`viewSize`, evt.getNewValue)
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
