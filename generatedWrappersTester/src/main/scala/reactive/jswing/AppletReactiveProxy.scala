package reactive.jswing

import reactive._

//This file was auto generated
trait AppletReactiveProxy extends ContainerReactiveProxy  {
  override def peer: java.applet.Applet
  private[AppletReactiveProxy] lazy val outer = peer
  trait Signals extends super.Signals {
    //helper method to treat var as signals without specifying the type
    //which might arise visibility problems (e.g.: the listeners field in scala.swing.Component
    @inline private[this] def varAsSignal[T](v: Var[T]) = v: Signal[T]
    lazy val `accessibleContext` = varAsSignal(Var(outer.getAccessibleContext))
    lazy val `active` = varAsSignal(Var(outer.isActive))
    lazy val `appletContext` = varAsSignal(Var(outer.getAppletContext))
    lazy val `appletInfo` = varAsSignal(Var(outer.getAppletInfo))
    lazy val `codeBase` = varAsSignal(Var(outer.getCodeBase))
    lazy val `documentBase` = varAsSignal(Var(outer.getDocumentBase))
    lazy val `locale` = varAsSignal(Var(outer.getLocale))
    lazy val `parameterInfo` = varAsSignal(Var(outer.getParameterInfo))
    
    outer.addPropertyChangeListener(new java.beans.PropertyChangeListener {
      def propertyChange(evt: java.beans.PropertyChangeEvent) {
        def assign[T](s: Signal[T], value: Any) = s match {case v: Var[_] => v.asInstanceOf[Var[T]].value = value.asInstanceOf[T]; case _ =>}
        evt.getPropertyName match {
          case "`accessibleContext`" => assign(`accessibleContext`, evt.getNewValue)
          case "`active`" => assign(`active`, evt.getNewValue)
          case "`appletContext`" => assign(`appletContext`, evt.getNewValue)
          case "`appletInfo`" => assign(`appletInfo`, evt.getNewValue)
          case "`codeBase`" => assign(`codeBase`, evt.getNewValue)
          case "`documentBase`" => assign(`documentBase`, evt.getNewValue)
          case "`locale`" => assign(`locale`, evt.getNewValue)
          case "`parameterInfo`" => assign(`parameterInfo`, evt.getNewValue)
          case _ =>
        }
      }
    })
  }
  
  override lazy val signals = new Signals {}
  
  

}
