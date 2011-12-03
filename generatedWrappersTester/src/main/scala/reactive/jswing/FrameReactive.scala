package reactive.jswing

import reactive._

//This file was auto generated
trait FrameReactive extends java.awt.Frame with WindowReactive {
  outer =>
  trait Signals extends super.Signals {
    //helper method to treat var as signals without specifying the type
    //which might arise visibility problems (e.g.: the listeners field in scala.swing.Component
    @inline private[this] def varAsSignal[T](v: Var[T]) = v: Signal[T]
    lazy val `cursorType` = varAsSignal(Var(outer.getCursorType))
    lazy val `extendedState` = {
      val res = Var(outer.getExtendedState)
      res foreach (e => if (e != outer.getExtendedState) outer.setExtendedState(e))
      res
    }
    lazy val `iconImage` = {
      val res = Var(outer.getIconImage)
      res foreach (e => if (e != outer.getIconImage) outer.setIconImage(e))
      res
    }
    lazy val `maximizedBounds` = {
      val res = Var(outer.getMaximizedBounds)
      res foreach (e => if (e != outer.getMaximizedBounds) outer.setMaximizedBounds(e))
      res
    }
    lazy val `menuBar` = {
      val res = Var(outer.getMenuBar)
      res foreach (e => if (e != outer.getMenuBar) outer.setMenuBar(e))
      res
    }
    lazy val `resizable` = {
      val res = Var(outer.isResizable)
      res foreach (e => if (e != outer.isResizable) outer.setResizable(e))
      res
    }
    lazy val `state` = {
      val res = Var(outer.getState)
      res foreach (e => if (e != outer.getState) outer.setState(e))
      res
    }
    lazy val `title` = {
      val res = Var(outer.getTitle)
      res foreach (e => if (e != outer.getTitle) outer.setTitle(e))
      res
    }
    lazy val `undecorated` = {
      val res = Var(outer.isUndecorated)
      res foreach (e => if (e != outer.isUndecorated) outer.setUndecorated(e))
      res
    }
    
    outer.addPropertyChangeListener(new java.beans.PropertyChangeListener {
      def propertyChange(evt: java.beans.PropertyChangeEvent) {
        def assign[T](s: Signal[T], value: Any) = s match {case v: Var[_] => v.asInstanceOf[Var[T]].value = value.asInstanceOf[T]; case _ =>}
        evt.getPropertyName match {
          case "`cursorType`" => assign(`cursorType`, evt.getNewValue)
          case "`extendedState`" => assign(`extendedState`, evt.getNewValue)
          case "`iconImage`" => assign(`iconImage`, evt.getNewValue)
          case "`maximizedBounds`" => assign(`maximizedBounds`, evt.getNewValue)
          case "`menuBar`" => assign(`menuBar`, evt.getNewValue)
          case "`resizable`" => assign(`resizable`, evt.getNewValue)
          case "`state`" => assign(`state`, evt.getNewValue)
          case "`title`" => assign(`title`, evt.getNewValue)
          case "`undecorated`" => assign(`undecorated`, evt.getNewValue)
          case _ =>
        }
      }
    })
  }
  
  override lazy val signals = new Signals {}
  
  

}
