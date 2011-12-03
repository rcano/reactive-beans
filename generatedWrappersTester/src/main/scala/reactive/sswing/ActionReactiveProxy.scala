package reactive.sswing

import reactive._

//This file was auto generated
trait ActionReactiveProxy extends Observing {
  def peer: scala.swing.Action
  private[ActionReactiveProxy] lazy val outer = peer
  trait Signals {
    //helper method to treat var as signals without specifying the type
    //which might arise visibility problems (e.g.: the listeners field in scala.swing.Component
    @inline private[this] def varAsSignal[T](v: Var[T]) = v: Signal[T]
    lazy val `accelerator` = {
      val res = Var(outer.accelerator)
      res foreach (e => if (e != outer.accelerator) outer.accelerator_=(e))
      res
    }
    lazy val `enabled` = {
      val res = Var(outer.enabled)
      res foreach (e => if (e != outer.enabled) outer.enabled_=(e))
      res
    }
    lazy val `icon` = {
      val res = Var(outer.icon)
      res foreach (e => if (e != outer.icon) outer.icon_=(e))
      res
    }
    lazy val `longDescription` = {
      val res = Var(outer.longDescription)
      res foreach (e => if (e != outer.longDescription) outer.longDescription_=(e))
      res
    }
    lazy val `mnemonic` = {
      val res = Var(outer.mnemonic)
      res foreach (e => if (e != outer.mnemonic) outer.mnemonic_=(e))
      res
    }
    lazy val `peer` = varAsSignal(Var(outer.peer))
    lazy val `smallIcon` = {
      val res = Var(outer.smallIcon)
      res foreach (e => if (e != outer.smallIcon) outer.smallIcon_=(e))
      res
    }
    lazy val `title` = {
      val res = Var(outer.title)
      res foreach (e => if (e != outer.title) outer.title_=(e))
      res
    }
    lazy val `toolTip` = {
      val res = Var(outer.toolTip)
      res foreach (e => if (e != outer.toolTip) outer.toolTip_=(e))
      res
    }
    
  }
  
  lazy val signals = new Signals {}
  
  

}
