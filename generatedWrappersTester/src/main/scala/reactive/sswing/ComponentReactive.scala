package reactive.sswing

import reactive._

//This file was auto generated
trait ComponentReactive extends scala.swing.Component with Observing {
  outer =>
  trait Signals {
    //helper method to treat var as signals without specifying the type
    //which might arise visibility problems (e.g.: the listeners field in scala.swing.Component
    @inline private[this] def varAsSignal[T](v: Var[T]) = v: Signal[T]
    lazy val `Mouse` = varAsSignal(Var(outer.Mouse))
    lazy val `background` = {
      val res = Var(outer.background)
      res foreach (e => if (e != outer.background) outer.background_=(e))
      res
    }
    lazy val `border` = {
      val res = Var(outer.border)
      res foreach (e => if (e != outer.border) outer.border_=(e))
      res
    }
    lazy val `cursor` = {
      val res = Var(outer.cursor)
      res foreach (e => if (e != outer.cursor) outer.cursor_=(e))
      res
    }
    lazy val `enabled` = {
      val res = Var(outer.enabled)
      res foreach (e => if (e != outer.enabled) outer.enabled_=(e))
      res
    }
    lazy val `focusable` = {
      val res = Var(outer.focusable)
      res foreach (e => if (e != outer.focusable) outer.focusable_=(e))
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
    lazy val `initP` = {
      val res = Var(outer.initP)
      res foreach (e => if (e != outer.initP) outer.initP_=(e))
      res
    }
    lazy val `inputVerifier` = {
      val res = Var(outer.inputVerifier)
      res foreach (e => if (e != outer.inputVerifier) outer.inputVerifier_=(e))
      res
    }
    lazy val `listeners` = varAsSignal(Var(outer.listeners))
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
    lazy val `name` = {
      val res = Var(outer.name)
      res foreach (e => if (e != outer.name) outer.name_=(e))
      res
    }
    lazy val `opaque` = {
      val res = Var(outer.opaque)
      res foreach (e => if (e != outer.opaque) outer.opaque_=(e))
      res
    }
    lazy val `peer` = varAsSignal(Var(outer.peer))
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
    lazy val `tooltip` = {
      val res = Var(outer.tooltip)
      res foreach (e => if (e != outer.tooltip) outer.tooltip_=(e))
      res
    }
    lazy val `visible` = {
      val res = Var(outer.visible)
      res foreach (e => if (e != outer.visible) outer.visible_=(e))
      res
    }
    lazy val `xLayoutAlignment` = {
      val res = Var(outer.xLayoutAlignment)
      res foreach (e => if (e != outer.xLayoutAlignment) outer.xLayoutAlignment_=(e))
      res
    }
    lazy val `yLayoutAlignment` = {
      val res = Var(outer.yLayoutAlignment)
      res foreach (e => if (e != outer.yLayoutAlignment) outer.yLayoutAlignment_=(e))
      res
    }
    
  }
  
  lazy val signals = new Signals {}
  
  

}
