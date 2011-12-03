package reactive.jswing

import reactive._

//This file was auto generated
trait JMenuBarReactive extends javax.swing.JMenuBar with JComponentReactive {
  outer =>
  trait Signals extends super.Signals {
    //helper method to treat var as signals without specifying the type
    //which might arise visibility problems (e.g.: the listeners field in scala.swing.Component
    @inline private[this] def varAsSignal[T](v: Var[T]) = v: Signal[T]
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
    lazy val `component` = varAsSignal(Var(outer.getComponent))
    lazy val `helpMenu` = {
      val res = Var(outer.getHelpMenu)
      res foreach (e => if (e != outer.getHelpMenu) outer.setHelpMenu(e))
      res
    }
    lazy val `margin` = {
      val res = Var(outer.getMargin)
      res foreach (e => if (e != outer.getMargin) outer.setMargin(e))
      res
    }
    lazy val `menuCount` = varAsSignal(Var(outer.getMenuCount))
    lazy val `selected` = varAsSignal(Var(outer.isSelected))
    lazy val `selectionModel` = {
      val res = Var(outer.getSelectionModel)
      res foreach (e => if (e != outer.getSelectionModel) outer.setSelectionModel(e))
      res
    }
    lazy val `subElements` = varAsSignal(Var(outer.getSubElements))
    
    outer.addPropertyChangeListener(new java.beans.PropertyChangeListener {
      def propertyChange(evt: java.beans.PropertyChangeEvent) {
        def assign[T](s: Signal[T], value: Any) = s match {case v: Var[_] => v.asInstanceOf[Var[T]].value = value.asInstanceOf[T]; case _ =>}
        evt.getPropertyName match {
          case "`UI`" => assign(`UI`, evt.getNewValue)
          case "`borderPainted`" => assign(`borderPainted`, evt.getNewValue)
          case "`component`" => assign(`component`, evt.getNewValue)
          case "`helpMenu`" => assign(`helpMenu`, evt.getNewValue)
          case "`margin`" => assign(`margin`, evt.getNewValue)
          case "`menuCount`" => assign(`menuCount`, evt.getNewValue)
          case "`selected`" => assign(`selected`, evt.getNewValue)
          case "`selectionModel`" => assign(`selectionModel`, evt.getNewValue)
          case "`subElements`" => assign(`subElements`, evt.getNewValue)
          case _ =>
        }
      }
    })
  }
  
  override lazy val signals = new Signals {}
  
  

}
