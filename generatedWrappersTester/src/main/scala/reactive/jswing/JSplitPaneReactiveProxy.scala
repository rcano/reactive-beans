package reactive.jswing

import reactive._

//This file was auto generated
trait JSplitPaneReactiveProxy extends JComponentReactiveProxy  {
  override def peer: javax.swing.JSplitPane
  private[JSplitPaneReactiveProxy] lazy val outer = peer
  trait Signals extends super.Signals {
    //helper method to treat var as signals without specifying the type
    //which might arise visibility problems (e.g.: the listeners field in scala.swing.Component
    @inline private[this] def varAsSignal[T](v: Var[T]) = v: Signal[T]
    lazy val `UI` = {
      val res = Var(outer.getUI)
      res foreach (e => if (e != outer.getUI) outer.setUI(e))
      res
    }
    lazy val `bottomComponent` = {
      val res = Var(outer.getBottomComponent)
      res foreach (e => if (e != outer.getBottomComponent) outer.setBottomComponent(e))
      res
    }
    lazy val `continuousLayout` = {
      val res = Var(outer.isContinuousLayout)
      res foreach (e => if (e != outer.isContinuousLayout) outer.setContinuousLayout(e))
      res
    }
    lazy val `dividerLocation` = {
      val res = Var(outer.getDividerLocation)
      res foreach (e => if (e != outer.getDividerLocation) outer.setDividerLocation(e))
      res
    }
    lazy val `dividerSize` = {
      val res = Var(outer.getDividerSize)
      res foreach (e => if (e != outer.getDividerSize) outer.setDividerSize(e))
      res
    }
    lazy val `lastDividerLocation` = {
      val res = Var(outer.getLastDividerLocation)
      res foreach (e => if (e != outer.getLastDividerLocation) outer.setLastDividerLocation(e))
      res
    }
    lazy val `leftComponent` = {
      val res = Var(outer.getLeftComponent)
      res foreach (e => if (e != outer.getLeftComponent) outer.setLeftComponent(e))
      res
    }
    lazy val `maximumDividerLocation` = varAsSignal(Var(outer.getMaximumDividerLocation))
    lazy val `minimumDividerLocation` = varAsSignal(Var(outer.getMinimumDividerLocation))
    lazy val `oneTouchExpandable` = {
      val res = Var(outer.isOneTouchExpandable)
      res foreach (e => if (e != outer.isOneTouchExpandable) outer.setOneTouchExpandable(e))
      res
    }
    lazy val `orientation` = {
      val res = Var(outer.getOrientation)
      res foreach (e => if (e != outer.getOrientation) outer.setOrientation(e))
      res
    }
    lazy val `resizeWeight` = {
      val res = Var(outer.getResizeWeight)
      res foreach (e => if (e != outer.getResizeWeight) outer.setResizeWeight(e))
      res
    }
    lazy val `rightComponent` = {
      val res = Var(outer.getRightComponent)
      res foreach (e => if (e != outer.getRightComponent) outer.setRightComponent(e))
      res
    }
    lazy val `topComponent` = {
      val res = Var(outer.getTopComponent)
      res foreach (e => if (e != outer.getTopComponent) outer.setTopComponent(e))
      res
    }
    
    outer.addPropertyChangeListener(new java.beans.PropertyChangeListener {
      def propertyChange(evt: java.beans.PropertyChangeEvent) {
        def assign[T](s: Signal[T], value: Any) = s match {case v: Var[_] => v.asInstanceOf[Var[T]].value = value.asInstanceOf[T]; case _ =>}
        evt.getPropertyName match {
          case "`UI`" => assign(`UI`, evt.getNewValue)
          case "`bottomComponent`" => assign(`bottomComponent`, evt.getNewValue)
          case "`continuousLayout`" => assign(`continuousLayout`, evt.getNewValue)
          case "`dividerLocation`" => assign(`dividerLocation`, evt.getNewValue)
          case "`dividerSize`" => assign(`dividerSize`, evt.getNewValue)
          case "`lastDividerLocation`" => assign(`lastDividerLocation`, evt.getNewValue)
          case "`leftComponent`" => assign(`leftComponent`, evt.getNewValue)
          case "`maximumDividerLocation`" => assign(`maximumDividerLocation`, evt.getNewValue)
          case "`minimumDividerLocation`" => assign(`minimumDividerLocation`, evt.getNewValue)
          case "`oneTouchExpandable`" => assign(`oneTouchExpandable`, evt.getNewValue)
          case "`orientation`" => assign(`orientation`, evt.getNewValue)
          case "`resizeWeight`" => assign(`resizeWeight`, evt.getNewValue)
          case "`rightComponent`" => assign(`rightComponent`, evt.getNewValue)
          case "`topComponent`" => assign(`topComponent`, evt.getNewValue)
          case _ =>
        }
      }
    })
  }
  
  override lazy val signals = new Signals {}
  
  

}
