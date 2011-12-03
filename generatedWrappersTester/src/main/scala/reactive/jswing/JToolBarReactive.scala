package reactive.jswing

import reactive._

//This file was auto generated
trait JToolBarReactive extends javax.swing.JToolBar with JComponentReactive {
  outer =>
  trait Signals extends super.Signals {
    lazy val `UI` = {
      val res = Var(outer.getUI)
      res foreach (e => if (e != outer.getUI) outer.setUI(e))
      res
    }
    lazy val `borderPainted` = {
      val res = Var(outer.isBorderPainted)
      res foreach (e => if (e != outer.isBorderPainted) outer.setBorderPainted(e))
      res
    }
    lazy val `floatable` = {
      val res = Var(outer.isFloatable)
      res foreach (e => if (e != outer.isFloatable) outer.setFloatable(e))
      res
    }
    lazy val `margin` = {
      val res = Var(outer.getMargin)
      res foreach (e => if (e != outer.getMargin) outer.setMargin(e))
      res
    }
    lazy val `orientation` = {
      val res = Var(outer.getOrientation)
      res foreach (e => if (e != outer.getOrientation) outer.setOrientation(e))
      res
    }
    lazy val `rollover` = {
      val res = Var(outer.isRollover)
      res foreach (e => if (e != outer.isRollover) outer.setRollover(e))
      res
    }
    
    outer.addPropertyChangeListener(new java.beans.PropertyChangeListener {
      def propertyChange(evt: java.beans.PropertyChangeEvent) {
        def assign[T](s: Signal[T], value: Any) = s match {case v: Var[_] => v.asInstanceOf[Var[T]].value = value.asInstanceOf[T]; case _ =>}
        evt.getPropertyName match {
          case "`UI`" => assign(`UI`, evt.getNewValue)
          case "`borderPainted`" => assign(`borderPainted`, evt.getNewValue)
          case "`floatable`" => assign(`floatable`, evt.getNewValue)
          case "`margin`" => assign(`margin`, evt.getNewValue)
          case "`orientation`" => assign(`orientation`, evt.getNewValue)
          case "`rollover`" => assign(`rollover`, evt.getNewValue)
          case _ =>
        }
      }
    })
  }
  
  override lazy val signals = new Signals {}
  
  

}
