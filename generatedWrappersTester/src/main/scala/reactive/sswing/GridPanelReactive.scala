package reactive.sswing

import reactive._

//This file was auto generated
trait GridPanelReactive extends scala.swing.GridPanel with ComponentReactive {
  outer =>
  trait Signals extends super.Signals {
    //helper method to treat var as signals without specifying the type
    //which might arise visibility problems (e.g.: the listeners field in scala.swing.Component
    @inline private[this] def varAsSignal[T](v: Var[T]) = v: Signal[T]
    lazy val `columns` = {
      val res = Var(outer.columns)
      res foreach (e => if (e != outer.columns) outer.columns_=(e))
      res
    }
    lazy val `contents` = varAsSignal(Var(outer.contents))
    lazy val `hGap` = {
      val res = Var(outer.hGap)
      res foreach (e => if (e != outer.hGap) outer.hGap_=(e))
      res
    }
    lazy val `rows` = {
      val res = Var(outer.rows)
      res foreach (e => if (e != outer.rows) outer.rows_=(e))
      res
    }
    lazy val `vGap` = {
      val res = Var(outer.vGap)
      res foreach (e => if (e != outer.vGap) outer.vGap_=(e))
      res
    }
    
  }
  
  override lazy val signals = new Signals {}
  
  

}
