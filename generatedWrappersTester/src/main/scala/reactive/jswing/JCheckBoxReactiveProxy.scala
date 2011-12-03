package reactive.jswing

import reactive._

//This file was auto generated
trait JCheckBoxReactiveProxy extends AbstractButtonReactiveProxy  {
  override def peer: javax.swing.JCheckBox
  private[JCheckBoxReactiveProxy] lazy val outer = peer
  trait Signals extends super.Signals {
    lazy val `borderPaintedFlat` = {
      val res = Var(outer.isBorderPaintedFlat)
      res foreach (e => if (e != outer.isBorderPaintedFlat) outer.setBorderPaintedFlat(e))
      res
    }
    
    outer.addPropertyChangeListener(new java.beans.PropertyChangeListener {
      def propertyChange(evt: java.beans.PropertyChangeEvent) {
        def assign[T](s: Signal[T], value: Any) = s match {case v: Var[_] => v.asInstanceOf[Var[T]].value = value.asInstanceOf[T]; case _ =>}
        evt.getPropertyName match {
          case "`borderPaintedFlat`" => assign(`borderPaintedFlat`, evt.getNewValue)
          case _ =>
        }
      }
    })
  }
  
  override lazy val signals = new Signals {}
  
  

}
