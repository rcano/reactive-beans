package reactive.sswing

import reactive._

//This file was auto generated
trait TabbedPaneReactive extends scala.swing.TabbedPane with ComponentReactive {
  outer =>
  trait Signals extends super.Signals {
    lazy val `tabLayoutPolicy` = {
      val res = Var(outer.tabLayoutPolicy)
      res foreach (e => if (e != outer.tabLayoutPolicy) outer.tabLayoutPolicy_=(e))
      res
    }
    
  }
  
  override lazy val signals = new Signals {}
  
  

}
