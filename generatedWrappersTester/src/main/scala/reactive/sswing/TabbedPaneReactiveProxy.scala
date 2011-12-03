package reactive.sswing

import reactive._

//This file was auto generated
trait TabbedPaneReactiveProxy extends ComponentReactiveProxy  {
  override def peer: scala.swing.TabbedPane
  private[TabbedPaneReactiveProxy] lazy val outer = peer
  trait Signals extends super.Signals {
    lazy val `tabLayoutPolicy` = {
      val res = Var(outer.tabLayoutPolicy)
      res foreach (e => if (e != outer.tabLayoutPolicy) outer.tabLayoutPolicy_=(e))
      res
    }
    
  }
  
  override lazy val signals = new Signals {}
  
  

}
