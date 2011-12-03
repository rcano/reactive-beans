package reactive.sswing

import reactive._

//This file was auto generated
trait FormattedTextFieldReactiveProxy extends TextComponentReactiveProxy  {
  override def peer: scala.swing.FormattedTextField
  private[FormattedTextFieldReactiveProxy] lazy val outer = peer
  trait Signals extends super.Signals {
    lazy val `focusLostBehavior` = {
      val res = Var(outer.focusLostBehavior)
      res foreach (e => if (e != outer.focusLostBehavior) outer.focusLostBehavior_=(e))
      res
    }
    
  }
  
  override lazy val signals = new Signals {}
  
  

}
