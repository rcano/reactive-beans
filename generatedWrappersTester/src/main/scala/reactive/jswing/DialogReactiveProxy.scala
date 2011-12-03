package reactive.jswing

import reactive._

//This file was auto generated
trait DialogReactiveProxy extends WindowReactiveProxy  {
  override def peer: java.awt.Dialog
  private[DialogReactiveProxy] lazy val outer = peer
  trait Signals extends super.Signals {
    lazy val `modal` = {
      val res = Var(outer.isModal)
      res foreach (e => if (e != outer.isModal) outer.setModal(e))
      res
    }
    lazy val `modalityType` = {
      val res = Var(outer.getModalityType)
      res foreach (e => if (e != outer.getModalityType) outer.setModalityType(e))
      res
    }
    lazy val `resizable` = {
      val res = Var(outer.isResizable)
      res foreach (e => if (e != outer.isResizable) outer.setResizable(e))
      res
    }
    lazy val `title` = {
      val res = Var(outer.getTitle)
      res foreach (e => if (e != outer.getTitle) outer.setTitle(e))
      res
    }
    lazy val `undecorated` = {
      val res = Var(outer.isUndecorated)
      res foreach (e => if (e != outer.isUndecorated) outer.setUndecorated(e))
      res
    }
    
    outer.addPropertyChangeListener(new java.beans.PropertyChangeListener {
      def propertyChange(evt: java.beans.PropertyChangeEvent) {
        def assign[T](s: Signal[T], value: Any) = s match {case v: Var[_] => v.asInstanceOf[Var[T]].value = value.asInstanceOf[T]; case _ =>}
        evt.getPropertyName match {
          case "`modal`" => assign(`modal`, evt.getNewValue)
          case "`modalityType`" => assign(`modalityType`, evt.getNewValue)
          case "`resizable`" => assign(`resizable`, evt.getNewValue)
          case "`title`" => assign(`title`, evt.getNewValue)
          case "`undecorated`" => assign(`undecorated`, evt.getNewValue)
          case _ =>
        }
      }
    })
  }
  
  override lazy val signals = new Signals {}
  
  

}
