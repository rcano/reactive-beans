package reactive.sswing

import reactive._

//This file was auto generated
trait WindowReactive extends scala.swing.Window with Observing {
  outer =>
  trait Signals {
    //helper method to treat var as signals without specifying the type
    //which might arise visibility problems (e.g.: the listeners field in scala.swing.Component
    @inline private[this] def varAsSignal[T](v: Var[T]) = v: Signal[T]
    lazy val `background` = {
      val res = Var(outer.background)
      res foreach (e => if (e != outer.background) outer.background_=(e))
      res
    }
    lazy val `bounds` = {
      val res = Var(outer.bounds)
      res foreach (e => if (e != outer.bounds) outer.bounds_=(e))
      res
    }
    lazy val `cursor` = {
      val res = Var(outer.cursor)
      res foreach (e => if (e != outer.cursor) outer.cursor_=(e))
      res
    }
    lazy val `defaultButton` = {
      val res = Var(outer.defaultButton)
      res foreach (e => if (e != outer.defaultButton) outer.defaultButton_=(e))
      res
    }
    lazy val `font` = {
      val res = Var(outer.font)
      res foreach (e => if (e != outer.font) outer.font_=(e))
      res
    }
    lazy val `foreground` = {
      val res = Var(outer.foreground)
      res foreach (e => if (e != outer.foreground) outer.foreground_=(e))
      res
    }
    lazy val `ignoreRepaint` = {
      val res = Var(outer.ignoreRepaint)
      res foreach (e => if (e != outer.ignoreRepaint) outer.ignoreRepaint_=(e))
      res
    }
    lazy val `listeners` = varAsSignal(Var(outer.listeners))
    lazy val `location` = {
      val res = Var(outer.location)
      res foreach (e => if (e != outer.location) outer.location_=(e))
      res
    }
    lazy val `maximumSize` = {
      val res = Var(outer.maximumSize)
      res foreach (e => if (e != outer.maximumSize) outer.maximumSize_=(e))
      res
    }
    lazy val `minimumSize` = {
      val res = Var(outer.minimumSize)
      res foreach (e => if (e != outer.minimumSize) outer.minimumSize_=(e))
      res
    }
    lazy val `preferredSize` = {
      val res = Var(outer.preferredSize)
      res foreach (e => if (e != outer.preferredSize) outer.preferredSize_=(e))
      res
    }
    lazy val `reactions` = varAsSignal(Var(outer.reactions))
    lazy val `size` = {
      val res = Var(outer.size)
      res foreach (e => if (e != outer.size) outer.size_=(e))
      res
    }
    lazy val `visible` = {
      val res = Var(outer.visible)
      res foreach (e => if (e != outer.visible) outer.visible_=(e))
      res
    }
    
  }
  
  lazy val signals = new Signals {}
  
  

}
