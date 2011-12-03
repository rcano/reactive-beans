package reactive.jswing

import reactive._

//This file was auto generated
trait UIDefaultsReactiveProxy extends Observing {
  def peer: javax.swing.UIDefaults
  private[UIDefaultsReactiveProxy] lazy val outer = peer
  trait Signals {
    //helper method to treat var as signals without specifying the type
    //which might arise visibility problems (e.g.: the listeners field in scala.swing.Component
    @inline private[this] def varAsSignal[T](v: Var[T]) = v: Signal[T]
    lazy val `defaultLocale` = {
      val res = Var(outer.getDefaultLocale)
      res foreach (e => if (e != outer.getDefaultLocale) outer.setDefaultLocale(e))
      res
    }
    lazy val `propertyChangeListeners` = varAsSignal(Var(outer.getPropertyChangeListeners))
    
    outer.addPropertyChangeListener(new java.beans.PropertyChangeListener {
      def propertyChange(evt: java.beans.PropertyChangeEvent) {
        def assign[T](s: Signal[T], value: Any) = s match {case v: Var[_] => v.asInstanceOf[Var[T]].value = value.asInstanceOf[T]; case _ =>}
        evt.getPropertyName match {
          case "`defaultLocale`" => assign(`defaultLocale`, evt.getNewValue)
          case "`propertyChangeListeners`" => assign(`propertyChangeListeners`, evt.getNewValue)
          case _ =>
        }
      }
    })
  }
  
  lazy val signals = new Signals {}
  
  trait EventStreams {
    class ESource[T] extends EventSource[T]
    object propertyChange {
      val propertyChange = new ESource[java.beans.PropertyChangeEvent]
    }
    outer.addPropertyChangeListener(new java.beans.PropertyChangeListener {
      def propertyChange(evt: java.beans.PropertyChangeEvent) {EventStreams.this.propertyChange.propertyChange.fire(evt)}
    })
  }
  
  lazy val events = new EventStreams {}
  

}
