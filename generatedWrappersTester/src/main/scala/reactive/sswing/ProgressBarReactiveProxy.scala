package reactive.sswing

import reactive._

//This file was auto generated
trait ProgressBarReactiveProxy extends ComponentReactiveProxy  {
  override def peer: scala.swing.ProgressBar
  private[ProgressBarReactiveProxy] lazy val outer = peer
  trait Signals extends super.Signals {
    lazy val `indeterminate` = {
      val res = Var(outer.indeterminate)
      res foreach (e => if (e != outer.indeterminate) outer.indeterminate_=(e))
      res
    }
    lazy val `label` = {
      val res = Var(outer.label)
      res foreach (e => if (e != outer.label) outer.label_=(e))
      res
    }
    lazy val `labelPainted` = {
      val res = Var(outer.labelPainted)
      res foreach (e => if (e != outer.labelPainted) outer.labelPainted_=(e))
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
    lazy val `orientation` = {
      val res = Var(outer.orientation)
      res foreach (e => if (e != outer.orientation) outer.orientation_=(e))
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
