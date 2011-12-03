package reactive.sswing

import reactive._

//This file was auto generated
trait ScrollPaneReactiveProxy extends ComponentReactiveProxy  {
  override def peer: scala.swing.ScrollPane
  private[ScrollPaneReactiveProxy] lazy val outer = peer
  trait Signals extends super.Signals {
    lazy val `columnHeaderView` = {
      val res = Var(outer.columnHeaderView)
      res foreach (e => if (e != outer.columnHeaderView) outer.columnHeaderView_=(e))
      res
    }
    lazy val `horizontalScrollBarPolicy` = {
      val res = Var(outer.horizontalScrollBarPolicy)
      res foreach (e => if (e != outer.horizontalScrollBarPolicy) outer.horizontalScrollBarPolicy_=(e))
      res
    }
    lazy val `rowHeaderView` = {
      val res = Var(outer.rowHeaderView)
      res foreach (e => if (e != outer.rowHeaderView) outer.rowHeaderView_=(e))
      res
    }
    lazy val `verticalScrollBarPolicy` = {
      val res = Var(outer.verticalScrollBarPolicy)
      res foreach (e => if (e != outer.verticalScrollBarPolicy) outer.verticalScrollBarPolicy_=(e))
      res
    }
    lazy val `viewportView` = {
      val res = Var(outer.viewportView)
      res foreach (e => if (e != outer.viewportView) outer.viewportView_=(e))
      res
    }
    
  }
  
  override lazy val signals = new Signals {}
  
  

}
