package reactive.sswing

import reactive._

//This file was auto generated
trait SplitPaneReactive extends scala.swing.SplitPane with ComponentReactive {
  outer =>
  trait Signals extends super.Signals {
    lazy val `bottomComponent` = {
      val res = Var(outer.bottomComponent)
      res foreach (e => if (e != outer.bottomComponent) outer.bottomComponent_=(e))
      res
    }
    lazy val `continuousLayout` = {
      val res = Var(outer.continuousLayout)
      res foreach (e => if (e != outer.continuousLayout) outer.continuousLayout_=(e))
      res
    }
    lazy val `dividerLocation` = {
      val res = Var(outer.dividerLocation)
      res foreach (e => if (e != outer.dividerLocation) outer.dividerLocation_=(e))
      res
    }
    lazy val `dividerSize` = {
      val res = Var(outer.dividerSize)
      res foreach (e => if (e != outer.dividerSize) outer.dividerSize_=(e))
      res
    }
    lazy val `leftComponent` = {
      val res = Var(outer.leftComponent)
      res foreach (e => if (e != outer.leftComponent) outer.leftComponent_=(e))
      res
    }
    lazy val `oneTouchExpandable` = {
      val res = Var(outer.oneTouchExpandable)
      res foreach (e => if (e != outer.oneTouchExpandable) outer.oneTouchExpandable_=(e))
      res
    }
    lazy val `orientation` = {
      val res = Var(outer.orientation)
      res foreach (e => if (e != outer.orientation) outer.orientation_=(e))
      res
    }
    lazy val `resizeWeight` = {
      val res = Var(outer.resizeWeight)
      res foreach (e => if (e != outer.resizeWeight) outer.resizeWeight_=(e))
      res
    }
    lazy val `rightComponent` = {
      val res = Var(outer.rightComponent)
      res foreach (e => if (e != outer.rightComponent) outer.rightComponent_=(e))
      res
    }
    lazy val `topComponent` = {
      val res = Var(outer.topComponent)
      res foreach (e => if (e != outer.topComponent) outer.topComponent_=(e))
      res
    }
    
  }
  
  override lazy val signals = new Signals {}
  
  

}
