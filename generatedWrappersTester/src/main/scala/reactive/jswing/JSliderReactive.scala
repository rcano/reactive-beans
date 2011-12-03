package reactive.jswing

import reactive._

//This file was auto generated
trait JSliderReactive extends javax.swing.JSlider with JComponentReactive {
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
    lazy val `changeListeners` = varAsSignal(Var(outer.getChangeListeners))
    lazy val `extent` = {
      val res = Var(outer.getExtent)
      res foreach (e => if (e != outer.getExtent) outer.setExtent(e))
      res
    }
    lazy val `inverted` = {
      val res = Var(outer.getInverted)
      res foreach (e => if (e != outer.getInverted) outer.setInverted(e))
      res
    }
    lazy val `labelTable` = {
      val res = Var(outer.getLabelTable)
      res foreach (e => if (e != outer.getLabelTable) outer.setLabelTable(e))
      res
    }
    lazy val `majorTickSpacing` = {
      val res = Var(outer.getMajorTickSpacing)
      res foreach (e => if (e != outer.getMajorTickSpacing) outer.setMajorTickSpacing(e))
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
    lazy val `minorTickSpacing` = {
      val res = Var(outer.getMinorTickSpacing)
      res foreach (e => if (e != outer.getMinorTickSpacing) outer.setMinorTickSpacing(e))
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
    lazy val `paintLabels` = {
      val res = Var(outer.getPaintLabels)
      res foreach (e => if (e != outer.getPaintLabels) outer.setPaintLabels(e))
      res
    }
    lazy val `paintTicks` = {
      val res = Var(outer.getPaintTicks)
      res foreach (e => if (e != outer.getPaintTicks) outer.setPaintTicks(e))
      res
    }
    lazy val `paintTrack` = {
      val res = Var(outer.getPaintTrack)
      res foreach (e => if (e != outer.getPaintTrack) outer.setPaintTrack(e))
      res
    }
    lazy val `snapToTicks` = {
      val res = Var(outer.getSnapToTicks)
      res foreach (e => if (e != outer.getSnapToTicks) outer.setSnapToTicks(e))
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
    
    outer.addPropertyChangeListener(new java.beans.PropertyChangeListener {
      def propertyChange(evt: java.beans.PropertyChangeEvent) {
        def assign[T](s: Signal[T], value: Any) = s match {case v: Var[_] => v.asInstanceOf[Var[T]].value = value.asInstanceOf[T]; case _ =>}
        evt.getPropertyName match {
          case "`UI`" => assign(`UI`, evt.getNewValue)
          case "`changeListeners`" => assign(`changeListeners`, evt.getNewValue)
          case "`extent`" => assign(`extent`, evt.getNewValue)
          case "`inverted`" => assign(`inverted`, evt.getNewValue)
          case "`labelTable`" => assign(`labelTable`, evt.getNewValue)
          case "`majorTickSpacing`" => assign(`majorTickSpacing`, evt.getNewValue)
          case "`maximum`" => assign(`maximum`, evt.getNewValue)
          case "`minimum`" => assign(`minimum`, evt.getNewValue)
          case "`minorTickSpacing`" => assign(`minorTickSpacing`, evt.getNewValue)
          case "`model`" => assign(`model`, evt.getNewValue)
          case "`orientation`" => assign(`orientation`, evt.getNewValue)
          case "`paintLabels`" => assign(`paintLabels`, evt.getNewValue)
          case "`paintTicks`" => assign(`paintTicks`, evt.getNewValue)
          case "`paintTrack`" => assign(`paintTrack`, evt.getNewValue)
          case "`snapToTicks`" => assign(`snapToTicks`, evt.getNewValue)
          case "`value`" => assign(`value`, evt.getNewValue)
          case "`valueIsAdjusting`" => assign(`valueIsAdjusting`, evt.getNewValue)
          case _ =>
        }
      }
    })
  }
  
  override lazy val signals = new Signals {}
  
  trait EventStreams extends super.EventStreams {
    object change {
      val stateChanged = new ESource[javax.swing.event.ChangeEvent]
    }
    outer.addChangeListener(new javax.swing.event.ChangeListener {
      def stateChanged(evt: javax.swing.event.ChangeEvent) {EventStreams.this.change.stateChanged.fire(evt)}
    })
  }
  
  override lazy val events = new EventStreams {}
  

}
