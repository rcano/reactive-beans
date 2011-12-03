package reactive.sswing

import reactive._

//This file was auto generated
trait CheckBoxReactiveProxy extends AbstractButtonReactiveProxy  {
  override def peer: scala.swing.CheckBox
  private[CheckBoxReactiveProxy] lazy val outer = peer
  trait Signals extends super.Signals {
    lazy val `borderPaintedFlat` = {
      val res = Var(outer.borderPaintedFlat)
      res foreach (e => if (e != outer.borderPaintedFlat) outer.borderPaintedFlat_=(e))
      res
    }
    
  }
  
  override lazy val signals = new Signals {}
  
  

}
