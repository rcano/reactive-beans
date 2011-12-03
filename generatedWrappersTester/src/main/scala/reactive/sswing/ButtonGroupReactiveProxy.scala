package reactive.sswing

import reactive._

//This file was auto generated
trait ButtonGroupReactiveProxy extends Observing {
  def peer: scala.swing.ButtonGroup
  private[ButtonGroupReactiveProxy] lazy val outer = peer
  trait Signals {
    //helper method to treat var as signals without specifying the type
    //which might arise visibility problems (e.g.: the listeners field in scala.swing.Component
    @inline private[this] def varAsSignal[T](v: Var[T]) = v: Signal[T]
    lazy val `buttons` = varAsSignal(Var(outer.buttons))
    lazy val `peer` = varAsSignal(Var(outer.peer))
    
  }
  
  lazy val signals = new Signals {}
  
  

}
