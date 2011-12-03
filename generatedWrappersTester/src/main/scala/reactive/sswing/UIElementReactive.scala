package reactive.sswing

import reactive._

//This file was auto generated
trait UIElementReactive extends scala.swing.UIElement with Observing {
  outer =>
  trait Signals {
    lazy val `background` = {
      val res = Var(outer.background)
      res foreach (e => if (e != outer.background) outer.background_=(e))
      res
    }
    lazy val `cursor` = {
      val res = Var(outer.cursor)
      res foreach (e => if (e != outer.cursor) outer.cursor_=(e))
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
