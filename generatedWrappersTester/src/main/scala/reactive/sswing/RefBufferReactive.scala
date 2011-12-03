package reactive.sswing

import reactive._

//This file was auto generated
trait RefBufferReactive[A <: scala.AnyRef] extends scala.swing.RefBuffer[A] with Observing {
  outer =>
  trait Signals {
    //helper method to treat var as signals without specifying the type
    //which might arise visibility problems (e.g.: the listeners field in scala.swing.Component
    @inline private[this] def varAsSignal[T](v: Var[T]) = v: Signal[T]
    lazy val `referenceQueue` = varAsSignal(Var(outer.referenceQueue))
    
  }
  
  lazy val signals = new Signals {}
  
  

}
