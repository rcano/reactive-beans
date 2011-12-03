package reactive.sswing

import reactive._

//This file was auto generated
trait ListViewReactiveProxy[A] extends ComponentReactiveProxy  {
  override def peer: scala.swing.ListView[A]
  private[ListViewReactiveProxy] lazy val outer = peer
  trait Signals extends super.Signals {
    lazy val `fixedCellHeight` = {
      val res = Var(outer.fixedCellHeight)
      res foreach (e => if (e != outer.fixedCellHeight) outer.fixedCellHeight_=(e))
      res
    }
    lazy val `fixedCellWidth` = {
      val res = Var(outer.fixedCellWidth)
      res foreach (e => if (e != outer.fixedCellWidth) outer.fixedCellWidth_=(e))
      res
    }
    lazy val `listData` = {
      val res = Var(outer.listData)
      res foreach (e => if (e != outer.listData) outer.listData_=(e))
      res
    }
    lazy val `prototypeCellValue` = {
      val res = Var(outer.prototypeCellValue)
      res foreach (e => if (e != outer.prototypeCellValue) outer.prototypeCellValue_=(e))
      res
    }
    lazy val `renderer` = {
      val res = Var(outer.renderer)
      res foreach (e => if (e != outer.renderer) outer.renderer_=(e))
      res
    }
    lazy val `selectionBackground` = {
      val res = Var(outer.selectionBackground)
      res foreach (e => if (e != outer.selectionBackground) outer.selectionBackground_=(e))
      res
    }
    lazy val `selectionForeground` = {
      val res = Var(outer.selectionForeground)
      res foreach (e => if (e != outer.selectionForeground) outer.selectionForeground_=(e))
      res
    }
    
  }
  
  override lazy val signals = new Signals {}
  
  

}
