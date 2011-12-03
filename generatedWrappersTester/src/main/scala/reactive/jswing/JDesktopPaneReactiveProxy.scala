package reactive.jswing

import reactive._

//This file was auto generated
trait JDesktopPaneReactiveProxy extends JComponentReactiveProxy  {
  override def peer: javax.swing.JDesktopPane
  private[JDesktopPaneReactiveProxy] lazy val outer = peer
  trait Signals extends super.Signals {
    //helper method to treat var as signals without specifying the type
    //which might arise visibility problems (e.g.: the listeners field in scala.swing.Component
    @inline private[this] def varAsSignal[T](v: Var[T]) = v: Signal[T]
    lazy val `UI` = {
      val res = Var(outer.getUI)
      res foreach (e => if (e != outer.getUI) outer.setUI(e))
      res
    }
    lazy val `allFrames` = varAsSignal(Var(outer.getAllFrames))
    lazy val `desktopManager` = {
      val res = Var(outer.getDesktopManager)
      res foreach (e => if (e != outer.getDesktopManager) outer.setDesktopManager(e))
      res
    }
    lazy val `dragMode` = {
      val res = Var(outer.getDragMode)
      res foreach (e => if (e != outer.getDragMode) outer.setDragMode(e))
      res
    }
    lazy val `selectedFrame` = {
      val res = Var(outer.getSelectedFrame)
      res foreach (e => if (e != outer.getSelectedFrame) outer.setSelectedFrame(e))
      res
    }
    
    outer.addPropertyChangeListener(new java.beans.PropertyChangeListener {
      def propertyChange(evt: java.beans.PropertyChangeEvent) {
        def assign[T](s: Signal[T], value: Any) = s match {case v: Var[_] => v.asInstanceOf[Var[T]].value = value.asInstanceOf[T]; case _ =>}
        evt.getPropertyName match {
          case "`UI`" => assign(`UI`, evt.getNewValue)
          case "`allFrames`" => assign(`allFrames`, evt.getNewValue)
          case "`desktopManager`" => assign(`desktopManager`, evt.getNewValue)
          case "`dragMode`" => assign(`dragMode`, evt.getNewValue)
          case "`selectedFrame`" => assign(`selectedFrame`, evt.getNewValue)
          case _ =>
        }
      }
    })
  }
  
  override lazy val signals = new Signals {}
  
  

}
