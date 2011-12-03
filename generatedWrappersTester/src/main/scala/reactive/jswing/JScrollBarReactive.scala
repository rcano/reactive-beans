package reactive.jswing

import reactive._

//This file was auto generated
trait JScrollBarReactive extends javax.swing.JScrollBar with JComponentReactive {
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
    lazy val `adjustmentListeners` = varAsSignal(Var(outer.getAdjustmentListeners))
    lazy val `blockIncrement` = {
      val res = Var(outer.getBlockIncrement)
      res foreach (e => if (e != outer.getBlockIncrement) outer.setBlockIncrement(e))
      res
    }
    lazy val `maximum` = {
      val res = Var(outer.getMaximum)
      res foreach (e => if (e != outer.getMaximum) outer.setMaximum(e))
      res
    }
    lazy val `minimum` = {
      val res = Var(outer.getMinimum)
      res foreach (e => if (e != outer.getMinimum) outer.setMinimum(e))
      res
    }
    lazy val `model` = {
      val res = Var(outer.getModel)
      res foreach (e => if (e != outer.getModel) outer.setModel(e))
      res
    }
    lazy val `orientation` = {
      val res = Var(outer.getOrientation)
      res foreach (e => if (e != outer.getOrientation) outer.setOrientation(e))
      res
    }
    lazy val `unitIncrement` = {
      val res = Var(outer.getUnitIncrement)
      res foreach (e => if (e != outer.getUnitIncrement) outer.setUnitIncrement(e))
      res
    }
    lazy val `value` = {
      val res = Var(outer.getValue)
      res foreach (e => if (e != outer.getValue) outer.setValue(e))
      res
    }
    lazy val `valueIsAdjusting` = {
      val res = Var(outer.getValueIsAdjusting)
      res foreach (e => if (e != outer.getValueIsAdjusting) outer.setValueIsAdjusting(e))
      res
    }
    lazy val `visibleAmount` = {
      val res = Var(outer.getVisibleAmount)
      res foreach (e => if (e != outer.getVisibleAmount) outer.setVisibleAmount(e))
      res
    }
    
    outer.addPropertyChangeListener(new java.beans.PropertyChangeListener {
      def propertyChange(evt: java.beans.PropertyChangeEvent) {
        def assign[T](s: Signal[T], value: Any) = s match {case v: Var[_] => v.asInstanceOf[Var[T]].value = value.asInstanceOf[T]; case _ =>}
        evt.getPropertyName match {
          case "`UI`" => assign(`UI`, evt.getNewValue)
          case "`adjustmentListeners`" => assign(`adjustmentListeners`, evt.getNewValue)
          case "`blockIncrement`" => assign(`blockIncrement`, evt.getNewValue)
          case "`maximum`" => assign(`maximum`, evt.getNewValue)
          case "`minimum`" => assign(`minimum`, evt.getNewValue)
          case "`model`" => assign(`model`, evt.getNewValue)
          case "`orientation`" => assign(`orientation`, evt.getNewValue)
          case "`unitIncrement`" => assign(`unitIncrement`, evt.getNewValue)
          case "`value`" => assign(`value`, evt.getNewValue)
          case "`valueIsAdjusting`" => assign(`valueIsAdjusting`, evt.getNewValue)
          case "`visibleAmount`" => assign(`visibleAmount`, evt.getNewValue)
          case _ =>
        }
      }
    })
  }
  
  override lazy val signals = new Signals {}
  
  trait EventStreams extends super.EventStreams {
    object adjustment {
      val adjustmentValueChanged = new ESource[java.awt.event.AdjustmentEvent]
    }
    outer.addAdjustmentListener(new java.awt.event.AdjustmentListener {
      def adjustmentValueChanged(evt: java.awt.event.AdjustmentEvent) {EventStreams.this.adjustment.adjustmentValueChanged.fire(evt)}
    })
  }
  
  override lazy val events = new EventStreams {}
  

}
