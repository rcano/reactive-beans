package reactive.sswing

import reactive._

//This file was auto generated
trait TextFieldReactiveProxy extends TextComponentReactiveProxy  {
  override def peer: scala.swing.TextField
  private[TextFieldReactiveProxy] lazy val outer = peer
  trait Signals extends super.Signals {
    lazy val `columns` = {
      val res = Var(outer.columns)
      res foreach (e => if (e != outer.columns) outer.columns_=(e))
      res
    }
    lazy val `horizontalAlignment` = {
      val res = Var(outer.horizontalAlignment)
      res foreach (e => if (e != outer.horizontalAlignment) outer.horizontalAlignment_=(e))
      res
    }
    lazy val `shouldYieldFocus` = {
      val res = Var(outer.shouldYieldFocus)
      res foreach (e => if (e != outer.shouldYieldFocus) outer.shouldYieldFocus_=(e))
      res
    }
    lazy val `verifier` = {
      val res = Var(outer.verifier)
      res foreach (e => if (e != outer.verifier) outer.verifier_=(e))
      res
    }
    
  }
  
  override lazy val signals = new Signals {}
  
  

}
