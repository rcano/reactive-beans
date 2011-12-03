package reactive.sswing

import reactive._

//This file was auto generated
trait SliderReactive extends scala.swing.Slider with ComponentReactive {
  outer =>
  trait Signals extends super.Signals {
    lazy val `extent` = {
      val res = Var(outer.extent)
      res foreach (e => if (e != outer.extent) outer.extent_=(e))
      res
    }
    lazy val `labels` = {
      val res = Var(outer.labels)
      res foreach (e => if (e != outer.labels) outer.labels_=(e))
      res
    }
    lazy val `majorTickSpacing` = {
      val res = Var(outer.majorTickSpacing)
      res foreach (e => if (e != outer.majorTickSpacing) outer.majorTickSpacing_=(e))
      res
    }
    lazy val `max` = {
      val res = Var(outer.max)
      res foreach (e => if (e != outer.max) outer.max_=(e))
      res
    }
    lazy val `min` = {
      val res = Var(outer.min)
      res foreach (e => if (e != outer.min) outer.min_=(e))
      res
    }
    lazy val `minorTickSpacing` = {
      val res = Var(outer.minorTickSpacing)
      res foreach (e => if (e != outer.minorTickSpacing) outer.minorTickSpacing_=(e))
      res
    }
    lazy val `orientation` = {
      val res = Var(outer.orientation)
      res foreach (e => if (e != outer.orientation) outer.orientation_=(e))
      res
    }
    lazy val `paintLabels` = {
      val res = Var(outer.paintLabels)
      res foreach (e => if (e != outer.paintLabels) outer.paintLabels_=(e))
      res
    }
    lazy val `paintTicks` = {
      val res = Var(outer.paintTicks)
      res foreach (e => if (e != outer.paintTicks) outer.paintTicks_=(e))
      res
    }
    lazy val `paintTrack` = {
      val res = Var(outer.paintTrack)
      res foreach (e => if (e != outer.paintTrack) outer.paintTrack_=(e))
      res
    }
    lazy val `snapToTicks` = {
      val res = Var(outer.snapToTicks)
      res foreach (e => if (e != outer.snapToTicks) outer.snapToTicks_=(e))
      res
    }
    lazy val `value` = {
      val res = Var(outer.value)
      res foreach (e => if (e != outer.value) outer.value_=(e))
      res
    }
    
  }
  
  override lazy val signals = new Signals {}
  
  

}
