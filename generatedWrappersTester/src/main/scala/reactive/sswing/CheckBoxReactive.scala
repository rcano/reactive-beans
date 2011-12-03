package reactive.sswing

import reactive._

//This file was auto generated
trait CheckBoxReactive extends scala.swing.CheckBox with AbstractButtonReactive {
  outer =>
  trait Signals extends super.Signals {
    lazy val `borderPaintedFlat` = {
      val res = Var(outer.borderPaintedFlat)
      res foreach (e => if (e != outer.borderPaintedFlat) outer.borderPaintedFlat_=(e))
      res
    }
    
  }
  
  override lazy val signals = new Signals {}
  
  

}
