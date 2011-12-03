package reactive.jswing

import reactive._

//This file was auto generated
trait JRootPaneReactiveProxy extends JComponentReactiveProxy  {
  override def peer: javax.swing.JRootPane
  private[JRootPaneReactiveProxy] lazy val outer = peer
  trait Signals extends super.Signals {
    lazy val `JMenuBar` = {
      val res = Var(outer.getJMenuBar)
      res foreach (e => if (e != outer.getJMenuBar) outer.setJMenuBar(e))
      res
    }
    lazy val `UI` = {
      val res = Var(outer.getUI)
      res foreach (e => if (e != outer.getUI) outer.setUI(e))
      res
    }
    lazy val `contentPane` = {
      val res = Var(outer.getContentPane)
      res foreach (e => if (e != outer.getContentPane) outer.setContentPane(e))
      res
    }
    lazy val `defaultButton` = {
      val res = Var(outer.getDefaultButton)
      res foreach (e => if (e != outer.getDefaultButton) outer.setDefaultButton(e))
      res
    }
    lazy val `glassPane` = {
      val res = Var(outer.getGlassPane)
      res foreach (e => if (e != outer.getGlassPane) outer.setGlassPane(e))
      res
    }
    lazy val `layeredPane` = {
      val res = Var(outer.getLayeredPane)
      res foreach (e => if (e != outer.getLayeredPane) outer.setLayeredPane(e))
      res
    }
    lazy val `menuBar` = {
      val res = Var(outer.getMenuBar)
      res foreach (e => if (e != outer.getMenuBar) outer.setMenuBar(e))
      res
    }
    lazy val `windowDecorationStyle` = {
      val res = Var(outer.getWindowDecorationStyle)
      res foreach (e => if (e != outer.getWindowDecorationStyle) outer.setWindowDecorationStyle(e))
      res
    }
    
    outer.addPropertyChangeListener(new java.beans.PropertyChangeListener {
      def propertyChange(evt: java.beans.PropertyChangeEvent) {
        def assign[T](s: Signal[T], value: Any) = s match {case v: Var[_] => v.asInstanceOf[Var[T]].value = value.asInstanceOf[T]; case _ =>}
        evt.getPropertyName match {
          case "`JMenuBar`" => assign(`JMenuBar`, evt.getNewValue)
          case "`UI`" => assign(`UI`, evt.getNewValue)
          case "`contentPane`" => assign(`contentPane`, evt.getNewValue)
          case "`defaultButton`" => assign(`defaultButton`, evt.getNewValue)
          case "`glassPane`" => assign(`glassPane`, evt.getNewValue)
          case "`layeredPane`" => assign(`layeredPane`, evt.getNewValue)
          case "`menuBar`" => assign(`menuBar`, evt.getNewValue)
          case "`windowDecorationStyle`" => assign(`windowDecorationStyle`, evt.getNewValue)
          case _ =>
        }
      }
    })
  }
  
  override lazy val signals = new Signals {}
  
  

}
