package reactive.sswing

import reactive._

//This file was auto generated
trait FlowPanelReactive extends scala.swing.FlowPanel with ComponentReactive {
  outer =>
  trait Signals extends super.Signals {
    //helper method to treat var as signals without specifying the type
    //which might arise visibility problems (e.g.: the listeners field in scala.swing.Component
    @inline private[this] def varAsSignal[T](v: Var[T]) = v: Signal[T]
    lazy val `contents` = varAsSignal(Var(outer.contents))
    lazy val `hGap` = {
      val res = Var(outer.hGap)
      res foreach (e => if (e != outer.hGap) outer.hGap_=(e))
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
