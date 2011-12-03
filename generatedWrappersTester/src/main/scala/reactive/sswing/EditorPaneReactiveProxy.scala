package reactive.sswing

import reactive._

//This file was auto generated
trait EditorPaneReactiveProxy extends TextComponentReactiveProxy  {
  override def peer: scala.swing.EditorPane
  private[EditorPaneReactiveProxy] lazy val outer = peer
  trait Signals extends super.Signals {
    lazy val `contentType` = {
      val res = Var(outer.contentType)
      res foreach (e => if (e != outer.contentType) outer.contentType_=(e))
      res
    }
    lazy val `editorKit` = {
      val res = Var(outer.editorKit)
      res foreach (e => if (e != outer.editorKit) outer.editorKit_=(e))
      res
    }
    
  }
  
  override lazy val signals = new Signals {}
  
  

}
