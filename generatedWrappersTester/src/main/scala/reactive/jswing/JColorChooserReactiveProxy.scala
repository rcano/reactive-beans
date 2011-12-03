package reactive.jswing

import reactive._

//This file was auto generated
trait JColorChooserReactiveProxy extends JComponentReactiveProxy  {
  override def peer: javax.swing.JColorChooser
  private[JColorChooserReactiveProxy] lazy val outer = peer
  trait Signals extends super.Signals {
    lazy val `UI` = {
      val res = Var(outer.getUI)
      res foreach (e => if (e != outer.getUI) outer.setUI(e))
      res
    }
    lazy val `chooserPanels` = {
      val res = Var(outer.getChooserPanels)
      res foreach (e => if (e != outer.getChooserPanels) outer.setChooserPanels(e))
      res
    }
    lazy val `color` = {
      val res = Var(outer.getColor)
      res foreach (e => if (e != outer.getColor) outer.setColor(e))
      res
    }
    lazy val `dragEnabled` = {
      val res = Var(outer.getDragEnabled)
      res foreach (e => if (e != outer.getDragEnabled) outer.setDragEnabled(e))
      res
    }
    lazy val `previewPanel` = {
      val res = Var(outer.getPreviewPanel)
      res foreach (e => if (e != outer.getPreviewPanel) outer.setPreviewPanel(e))
      res
    }
    lazy val `selectionModel` = {
      val res = Var(outer.getSelectionModel)
      res foreach (e => if (e != outer.getSelectionModel) outer.setSelectionModel(e))
      res
    }
    
    outer.addPropertyChangeListener(new java.beans.PropertyChangeListener {
      def propertyChange(evt: java.beans.PropertyChangeEvent) {
        def assign[T](s: Signal[T], value: Any) = s match {case v: Var[_] => v.asInstanceOf[Var[T]].value = value.asInstanceOf[T]; case _ =>}
        evt.getPropertyName match {
          case "`UI`" => assign(`UI`, evt.getNewValue)
          case "`chooserPanels`" => assign(`chooserPanels`, evt.getNewValue)
          case "`color`" => assign(`color`, evt.getNewValue)
          case "`dragEnabled`" => assign(`dragEnabled`, evt.getNewValue)
          case "`previewPanel`" => assign(`previewPanel`, evt.getNewValue)
          case "`selectionModel`" => assign(`selectionModel`, evt.getNewValue)
          case _ =>
        }
      }
    })
  }
  
  override lazy val signals = new Signals {}
  
  

}
