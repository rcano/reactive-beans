package reactive.sswing

import reactive._

//This file was auto generated
trait SwingApplicationReactiveProxy extends Observing {
  def peer: scala.swing.SwingApplication
  private[SwingApplicationReactiveProxy] lazy val outer = peer
  trait Signals {
    //helper method to treat var as signals without specifying the type
    //which might arise visibility problems (e.g.: the listeners field in scala.swing.Component
    @inline private[this] def varAsSignal[T](v: Var[T]) = v: Signal[T]
    lazy val `reactions` = varAsSignal(Var(outer.reactions))
    
  }
  
  lazy val signals = new Signals {}
  
  

}
