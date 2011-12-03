package reactive.sswing

import reactive._

//This file was auto generated
trait TextAreaReactiveProxy extends TextComponentReactiveProxy  {
  override def peer: scala.swing.TextArea
  private[TextAreaReactiveProxy] lazy val outer = peer
  trait Signals extends super.Signals {
    lazy val `charWrap` = {
      val res = Var(outer.charWrap)
      res foreach (e => if (e != outer.charWrap) outer.charWrap_=(e))
      res
    }
    lazy val `columns` = {
      val res = Var(outer.columns)
      res foreach (e => if (e != outer.columns) outer.columns_=(e))
      res
    }
    lazy val `lineWrap` = {
      val res = Var(outer.lineWrap)
      res foreach (e => if (e != outer.lineWrap) outer.lineWrap_=(e))
      res
    }
    lazy val `rows` = {
      val res = Var(outer.rows)
      res foreach (e => if (e != outer.rows) outer.rows_=(e))
      res
    }
    lazy val `tabSize` = {
      val res = Var(outer.tabSize)
      res foreach (e => if (e != outer.tabSize) outer.tabSize_=(e))
      res
    }
    lazy val `wordWrap` = {
      val res = Var(outer.wordWrap)
      res foreach (e => if (e != outer.wordWrap) outer.wordWrap_=(e))
      res
    }
    
  }
  
  override lazy val signals = new Signals {}
  
  

}
