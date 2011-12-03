package reactive.sswing

import reactive._

//This file was auto generated
trait TextComponentReactiveProxy extends ComponentReactiveProxy  {
  override def peer: scala.swing.TextComponent
  private[TextComponentReactiveProxy] lazy val outer = peer
  trait Signals extends super.Signals {
    lazy val `editable` = {
      val res = Var(outer.editable)
      res foreach (e => if (e != outer.editable) outer.editable_=(e))
      res
    }
    lazy val `text` = {
      val res = Var(outer.text)
      res foreach (e => if (e != outer.text) outer.text_=(e))
      res
    }
    
  }
  
  override lazy val signals = new Signals {}
  
  

}
