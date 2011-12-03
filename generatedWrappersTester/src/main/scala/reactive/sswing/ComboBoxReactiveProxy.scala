package reactive.sswing

import reactive._

//This file was auto generated
trait ComboBoxReactiveProxy[A] extends ComponentReactiveProxy  {
  override def peer: scala.swing.ComboBox[A]
  private[ComboBoxReactiveProxy] lazy val outer = peer
  trait Signals extends super.Signals {
    lazy val `prototypeDisplayValue` = {
      val res = Var(outer.prototypeDisplayValue)
      res foreach (e => if (e != outer.prototypeDisplayValue) outer.prototypeDisplayValue_=(e))
      res
    }
    lazy val `renderer` = {
      val res = Var(outer.renderer)
      res foreach (e => if (e != outer.renderer) outer.renderer_=(e))
      res
    }
    
  }
  
  override lazy val signals = new Signals {}
  
  

}
