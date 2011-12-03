package reactive.sswing

import reactive._

//This file was auto generated
trait AbstractButtonReactiveProxy extends ComponentReactiveProxy  {
  override def peer: scala.swing.AbstractButton
  private[AbstractButtonReactiveProxy] lazy val outer = peer
  trait Signals extends super.Signals {
    lazy val `borderPainted` = {
      val res = Var(outer.borderPainted)
      res foreach (e => if (e != outer.borderPainted) outer.borderPainted_=(e))
      res
    }
    lazy val `contentAreaFilled` = {
      val res = Var(outer.contentAreaFilled)
      res foreach (e => if (e != outer.contentAreaFilled) outer.contentAreaFilled_=(e))
      res
    }
    lazy val `disabledIcon` = {
      val res = Var(outer.disabledIcon)
      res foreach (e => if (e != outer.disabledIcon) outer.disabledIcon_=(e))
      res
    }
    lazy val `disabledSelectedIcon` = {
      val res = Var(outer.disabledSelectedIcon)
      res foreach (e => if (e != outer.disabledSelectedIcon) outer.disabledSelectedIcon_=(e))
      res
    }
    lazy val `displayedMnemonicIndex` = {
      val res = Var(outer.displayedMnemonicIndex)
      res foreach (e => if (e != outer.displayedMnemonicIndex) outer.displayedMnemonicIndex_=(e))
      res
    }
    lazy val `focusPainted` = {
      val res = Var(outer.focusPainted)
      res foreach (e => if (e != outer.focusPainted) outer.focusPainted_=(e))
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
    lazy val `margin` = {
      val res = Var(outer.margin)
      res foreach (e => if (e != outer.margin) outer.margin_=(e))
      res
    }
    lazy val `mnemonic` = {
      val res = Var(outer.mnemonic)
      res foreach (e => if (e != outer.mnemonic) outer.mnemonic_=(e))
      res
    }
    lazy val `multiClickThreshold` = {
      val res = Var(outer.multiClickThreshold)
      res foreach (e => if (e != outer.multiClickThreshold) outer.multiClickThreshold_=(e))
      res
    }
    lazy val `pressedIcon` = {
      val res = Var(outer.pressedIcon)
      res foreach (e => if (e != outer.pressedIcon) outer.pressedIcon_=(e))
      res
    }
    lazy val `rolloverEnabled` = {
      val res = Var(outer.rolloverEnabled)
      res foreach (e => if (e != outer.rolloverEnabled) outer.rolloverEnabled_=(e))
      res
    }
    lazy val `rolloverIcon` = {
      val res = Var(outer.rolloverIcon)
      res foreach (e => if (e != outer.rolloverIcon) outer.rolloverIcon_=(e))
      res
    }
    lazy val `rolloverSelectedIcon` = {
      val res = Var(outer.rolloverSelectedIcon)
      res foreach (e => if (e != outer.rolloverSelectedIcon) outer.rolloverSelectedIcon_=(e))
      res
    }
    lazy val `selected` = {
      val res = Var(outer.selected)
      res foreach (e => if (e != outer.selected) outer.selected_=(e))
      res
    }
    lazy val `selectedIcon` = {
      val res = Var(outer.selectedIcon)
      res foreach (e => if (e != outer.selectedIcon) outer.selectedIcon_=(e))
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
    
  }
  
  override lazy val signals = new Signals {}
  
  

}
