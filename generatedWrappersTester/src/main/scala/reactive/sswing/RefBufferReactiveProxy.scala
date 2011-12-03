package reactive.sswing

import reactive._

//This file was auto generated
trait RefBufferReactiveProxy[A <: scala.AnyRef] extends Observing {
  def peer: scala.swing.RefBuffer[A]
  private[RefBufferReactiveProxy] lazy val outer = peer
  trait Signals {
    
  }
  
  lazy val signals = new Signals {}
  
  

}
