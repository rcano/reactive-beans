package reactive.sswing

import reactive._

//This file was auto generated
trait ScrollBarReactiveProxy extends ComponentReactiveProxy  {
  override def peer: scala.swing.ScrollBar
  private[ScrollBarReactiveProxy] lazy val outer = peer
  trait Signals extends super.Signals {
    lazy val `blockIncrement` = {
      val res = Var(outer.blockIncrement)
      res foreach (e => if (e != outer.blockIncrement) outer.blockIncrement_=(e))
      res
    }
    lazy val `maximum` = {
      val res = Var(outer.maximum)
      res foreach (e => if (e != outer.maximum) outer.maximum_=(e))
      res
    }
    lazy val `minimum` = {
      val res = Var(outer.minimum)
      res foreach (e => if (e != outer.minimum) outer.minimum_=(e))
      res
    }
    lazy val `orientation` = {
      val res = Var(outer.orientation)
      res foreach (e => if (e != outer.orientation) outer.orientation_=(e))
      res
    }
    lazy val `unitIncrement` = {
      val res = Var(outer.unitIncrement)
      res foreach (e => if (e != outer.unitIncrement) outer.unitIncrement_=(e))
      res
    }
    lazy val `value` = {
      val res = Var(outer.value)
      res foreach (e => if (e != outer.value) outer.value_=(e))
      res
    }
    lazy val `valueIsAjusting` = {
      val res = Var(outer.valueIsAjusting)
      res foreach (e => if (e != outer.valueIsAjusting) outer.valueIsAjusting_=(e))
      res
    }
    lazy val `visibleAmount` = {
      val res = Var(outer.visibleAmount)
      res foreach (e => if (e != outer.visibleAmount) outer.visibleAmount_=(e))
      res
    }
    
  }
  
  override lazy val signals = new Signals {}
  
  

}
