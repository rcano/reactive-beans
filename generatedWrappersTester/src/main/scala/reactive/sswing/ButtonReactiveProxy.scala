package reactive.sswing

import reactive._

//This file was auto generated
trait ButtonReactiveProxy extends AbstractButtonReactiveProxy  {
  override def peer: scala.swing.Button
  private[ButtonReactiveProxy] lazy val outer = peer
  trait Signals extends super.Signals {
    lazy val `defaultCapable` = {
      val res = Var(outer.defaultCapable)
      res foreach (e => if (e != outer.defaultCapable) outer.defaultCapable_=(e))
      res
    }
    
  }
  
  override lazy val signals = new Signals {}
  
  

}
