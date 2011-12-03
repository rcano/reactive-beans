package reactive.sswing

import reactive._

//This file was auto generated
trait PasswordFieldReactiveProxy extends TextFieldReactiveProxy  {
  override def peer: scala.swing.PasswordField
  private[PasswordFieldReactiveProxy] lazy val outer = peer
  trait Signals extends super.Signals {
    lazy val `echoChar` = {
      val res = Var(outer.echoChar)
      res foreach (e => if (e != outer.echoChar) outer.echoChar_=(e))
      res
    }
    
  }
  
  override lazy val signals = new Signals {}
  
  

}
