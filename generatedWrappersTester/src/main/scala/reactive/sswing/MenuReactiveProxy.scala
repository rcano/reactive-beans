package reactive.sswing

import reactive._

//This file was auto generated
trait MenuReactiveProxy extends AbstractButtonReactiveProxy  {
  override def peer: scala.swing.Menu
  private[MenuReactiveProxy] lazy val outer = peer
  trait Signals extends super.Signals {
    //helper method to treat var as signals without specifying the type
    //which might arise visibility problems (e.g.: the listeners field in scala.swing.Component
    @inline private[this] def varAsSignal[T](v: Var[T]) = v: Signal[T]
    lazy val `contents` = varAsSignal(Var(outer.contents))
    
  }
  
  override lazy val signals = new Signals {}
  
  

}
