package reactive.sswing

import reactive._

//This file was auto generated
trait TableReactive extends scala.swing.Table with ComponentReactive {
  outer =>
  trait Signals extends super.Signals {
    //helper method to treat var as signals without specifying the type
    //which might arise visibility problems (e.g.: the listeners field in scala.swing.Component
    @inline private[this] def varAsSignal[T](v: Var[T]) = v: Signal[T]
    lazy val `autoResizeMode` = {
      val res = Var(outer.autoResizeMode)
      res foreach (e => if (e != outer.autoResizeMode) outer.autoResizeMode_=(e))
      res
    }
    lazy val `gridColor` = {
      val res = Var(outer.gridColor)
      res foreach (e => if (e != outer.gridColor) outer.gridColor_=(e))
      res
    }
    lazy val `model` = {
      val res = Var(outer.model)
      res foreach (e => if (e != outer.model) outer.model_=(e))
      res
    }
    lazy val `modelListener` = varAsSignal(Var(outer.modelListener))
    lazy val `preferredViewportSize` = {
      val res = Var(outer.preferredViewportSize)
      res foreach (e => if (e != outer.preferredViewportSize) outer.preferredViewportSize_=(e))
      res
    }
    lazy val `rowHeight` = {
      val res = Var(outer.rowHeight)
      res foreach (e => if (e != outer.rowHeight) outer.rowHeight_=(e))
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
    lazy val `showGrid` = {
      val res = Var(outer.showGrid)
      res foreach (e => if (e != outer.showGrid) outer.showGrid_=(e))
      res
    }
    
  }
  
  override lazy val signals = new Signals {}
  
  

}
