package reactive.jswing

import reactive._

//This file was auto generated
trait JProgressBarReactiveProxy extends JComponentReactiveProxy  {
  override def peer: javax.swing.JProgressBar
  private[JProgressBarReactiveProxy] lazy val outer = peer
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
    lazy val `changeListeners` = varAsSignal(Var(outer.getChangeListeners))
    lazy val `indeterminate` = {
      val res = Var(outer.isIndeterminate)
      res foreach (e => if (e != outer.isIndeterminate) outer.setIndeterminate(e))
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
    lazy val `percentComplete` = varAsSignal(Var(outer.getPercentComplete))
    lazy val `string` = {
      val res = Var(outer.getString)
      res foreach (e => if (e != outer.getString) outer.setString(e))
      res
    }
    lazy val `stringPainted` = {
      val res = Var(outer.isStringPainted)
      res foreach (e => if (e != outer.isStringPainted) outer.setStringPainted(e))
      res
    }
    lazy val `value` = {
      val res = Var(outer.getValue)
      res foreach (e => if (e != outer.getValue) outer.setValue(e))
      res
    }
    
    outer.addPropertyChangeListener(new java.beans.PropertyChangeListener {
      def propertyChange(evt: java.beans.PropertyChangeEvent) {
        def assign[T](s: Signal[T], value: Any) = s match {case v: Var[_] => v.asInstanceOf[Var[T]].value = value.asInstanceOf[T]; case _ =>}
        evt.getPropertyName match {
          case "`UI`" => assign(`UI`, evt.getNewValue)
          case "`borderPainted`" => assign(`borderPainted`, evt.getNewValue)
          case "`changeListeners`" => assign(`changeListeners`, evt.getNewValue)
          case "`indeterminate`" => assign(`indeterminate`, evt.getNewValue)
          case "`maximum`" => assign(`maximum`, evt.getNewValue)
          case "`minimum`" => assign(`minimum`, evt.getNewValue)
          case "`model`" => assign(`model`, evt.getNewValue)
          case "`orientation`" => assign(`orientation`, evt.getNewValue)
          case "`percentComplete`" => assign(`percentComplete`, evt.getNewValue)
          case "`string`" => assign(`string`, evt.getNewValue)
          case "`stringPainted`" => assign(`stringPainted`, evt.getNewValue)
          case "`value`" => assign(`value`, evt.getNewValue)
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
