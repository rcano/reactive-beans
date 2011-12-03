package reactive.sswing

import reactive._

//This file was auto generated
trait LabelReactive extends scala.swing.Label with ComponentReactive {
  outer =>
  trait Signals extends super.Signals {
    lazy val `disabledIcon` = {
      val res = Var(outer.disabledIcon)
      res foreach (e => if (e != outer.disabledIcon) outer.disabledIcon_=(e))
      res
    }
    lazy val `displayedMnemonicIndex` = {
      val res = Var(outer.displayedMnemonicIndex)
      res foreach (e => if (e != outer.displayedMnemonicIndex) outer.displayedMnemonicIndex_=(e))
      res
    }
    lazy val `horizontalAlignment` = {
      val res = Var(outer.horizontalAlignment)
      res foreach (e => if (e != outer.horizontalAlignment) outer.horizontalAlignment_=(e))
      res
    }
    lazy val `horizontalTextPosition` = {
      val res = Var(outer.horizontalTextPosition)
      res foreach (e => if (e != outer.horizontalTextPosition) outer.horizontalTextPosition_=(e))
      res
    }
    lazy val `icon` = {
      val res = Var(outer.icon)
      res foreach (e => if (e != outer.icon) outer.icon_=(e))
      res
    }
    lazy val `iconTextGap` = {
      val res = Var(outer.iconTextGap)
      res foreach (e => if (e != outer.iconTextGap) outer.iconTextGap_=(e))
      res
    }
    lazy val `text` = {
      val res = Var(outer.text)
      res foreach (e => if (e != outer.text) outer.text_=(e))
      res
    }
    lazy val `verticalAlignment` = {
      val res = Var(outer.verticalAlignment)
      res foreach (e => if (e != outer.verticalAlignment) outer.verticalAlignment_=(e))
      res
    }
    lazy val `verticalTextPosition` = {
      val res = Var(outer.verticalTextPosition)
      res foreach (e => if (e != outer.verticalTextPosition) outer.verticalTextPosition_=(e))
      res
    }
    lazy val `xAlignment` = {
      val res = Var(outer.xAlignment)
      res foreach (e => if (e != outer.xAlignment) outer.xAlignment_=(e))
      res
    }
    lazy val `yAlignment` = {
      val res = Var(outer.yAlignment)
      res foreach (e => if (e != outer.yAlignment) outer.yAlignment_=(e))
      res
    }
    
  }
  
  override lazy val signals = new Signals {}
  
  

}
