package reactive.sswing

import reactive._

//This file was auto generated
trait SwingWorkerReactiveProxy extends Observing {
  def peer: scala.swing.SwingWorker
  private[SwingWorkerReactiveProxy] lazy val outer = peer
  trait Signals {
    lazy val `cancelled` = {
      val res = Var(outer.cancelled)
      res foreach (e => if (e != outer.cancelled) outer.cancelled_=(e))
      res
    }
    lazy val `trapExit` = {
      val res = Var(outer.trapExit)
      res foreach (e => if (e != outer.trapExit) outer.trapExit_=(e))
      res
    }
    
  }
  
  lazy val signals = new Signals {}
  
  

}
