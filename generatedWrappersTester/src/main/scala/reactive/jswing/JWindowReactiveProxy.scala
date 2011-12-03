package reactive.jswing

import reactive._

//This file was auto generated
trait JWindowReactiveProxy extends WindowReactiveProxy  {
  override def peer: javax.swing.JWindow
  private[JWindowReactiveProxy] lazy val outer = peer
  trait Signals extends super.Signals {
    //helper method to treat var as signals without specifying the type
    //which might arise visibility problems (e.g.: the listeners field in scala.swing.Component
    @inline private[this] def varAsSignal[T](v: Var[T]) = v: Signal[T]
    lazy val `contentPane` = {
      val res = Var(outer.getContentPane)
      res foreach (e => if (e != outer.getContentPane) outer.setContentPane(e))
      res
    }
    lazy val `glassPane` = {
      val res = Var(outer.getGlassPane)
      res foreach (e => if (e != outer.getGlassPane) outer.setGlassPane(e))
      res
    }
    lazy val `graphics` = varAsSignal(Var(outer.getGraphics))
    lazy val `layeredPane` = {
      val res = Var(outer.getLayeredPane)
      res foreach (e => if (e != outer.getLayeredPane) outer.setLayeredPane(e))
      res
    }
    lazy val `rootPane` = varAsSignal(Var(outer.getRootPane))
    lazy val `transferHandler` = {
      val res = Var(outer.getTransferHandler)
      res foreach (e => if (e != outer.getTransferHandler) outer.setTransferHandler(e))
      res
    }
    
    outer.addPropertyChangeListener(new java.beans.PropertyChangeListener {
      def propertyChange(evt: java.beans.PropertyChangeEvent) {
        def assign[T](s: Signal[T], value: Any) = s match {case v: Var[_] => v.asInstanceOf[Var[T]].value = value.asInstanceOf[T]; case _ =>}
        evt.getPropertyName match {
          case "`contentPane`" => assign(`contentPane`, evt.getNewValue)
          case "`glassPane`" => assign(`glassPane`, evt.getNewValue)
          case "`graphics`" => assign(`graphics`, evt.getNewValue)
          case "`layeredPane`" => assign(`layeredPane`, evt.getNewValue)
          case "`rootPane`" => assign(`rootPane`, evt.getNewValue)
          case "`transferHandler`" => assign(`transferHandler`, evt.getNewValue)
          case _ =>
        }
      }
    })
  }
  
  override lazy val signals = new Signals {}
  
  

}
