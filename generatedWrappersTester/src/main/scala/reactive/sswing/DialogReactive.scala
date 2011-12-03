package reactive.sswing

import reactive._

//This file was auto generated
trait DialogReactive extends scala.swing.Dialog with WindowReactive {
  outer =>
  trait Signals extends super.Signals {
    //helper method to treat var as signals without specifying the type
    //which might arise visibility problems (e.g.: the listeners field in scala.swing.Component
    @inline private[this] def varAsSignal[T](v: Var[T]) = v: Signal[T]
    lazy val `menuBar` = {
      val res = Var(outer.menuBar)
      res foreach (e => if (e != outer.menuBar) outer.menuBar_=(e))
      res
    }
    lazy val `modal` = {
      val res = Var(outer.modal)
      res foreach (e => if (e != outer.modal) outer.modal_=(e))
      res
    }
    lazy val `peer` = varAsSignal(Var(outer.peer))
    lazy val `resizable` = {
      val res = Var(outer.resizable)
      res foreach (e => if (e != outer.resizable) outer.resizable_=(e))
      res
    }
    lazy val `title` = {
      val res = Var(outer.title)
      res foreach (e => if (e != outer.title) outer.title_=(e))
      res
    }
    
  }
  
  override lazy val signals = new Signals {}
  
  

}
