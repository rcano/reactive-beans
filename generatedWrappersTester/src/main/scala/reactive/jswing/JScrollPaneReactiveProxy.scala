package reactive.jswing

import reactive._

//This file was auto generated
trait JScrollPaneReactiveProxy extends JComponentReactiveProxy  {
  override def peer: javax.swing.JScrollPane
  private[JScrollPaneReactiveProxy] lazy val outer = peer
  trait Signals extends super.Signals {
    //helper method to treat var as signals without specifying the type
    //which might arise visibility problems (e.g.: the listeners field in scala.swing.Component
    @inline private[this] def varAsSignal[T](v: Var[T]) = v: Signal[T]
    lazy val `UI` = {
      val res = Var(outer.getUI)
      res foreach (e => if (e != outer.getUI) outer.setUI(e))
      res
    }
    lazy val `columnHeader` = {
      val res = Var(outer.getColumnHeader)
      res foreach (e => if (e != outer.getColumnHeader) outer.setColumnHeader(e))
      res
    }
    lazy val `horizontalScrollBar` = {
      val res = Var(outer.getHorizontalScrollBar)
      res foreach (e => if (e != outer.getHorizontalScrollBar) outer.setHorizontalScrollBar(e))
      res
    }
    lazy val `horizontalScrollBarPolicy` = {
      val res = Var(outer.getHorizontalScrollBarPolicy)
      res foreach (e => if (e != outer.getHorizontalScrollBarPolicy) outer.setHorizontalScrollBarPolicy(e))
      res
    }
    lazy val `rowHeader` = {
      val res = Var(outer.getRowHeader)
      res foreach (e => if (e != outer.getRowHeader) outer.setRowHeader(e))
      res
    }
    lazy val `verticalScrollBar` = {
      val res = Var(outer.getVerticalScrollBar)
      res foreach (e => if (e != outer.getVerticalScrollBar) outer.setVerticalScrollBar(e))
      res
    }
    lazy val `verticalScrollBarPolicy` = {
      val res = Var(outer.getVerticalScrollBarPolicy)
      res foreach (e => if (e != outer.getVerticalScrollBarPolicy) outer.setVerticalScrollBarPolicy(e))
      res
    }
    lazy val `viewport` = {
      val res = Var(outer.getViewport)
      res foreach (e => if (e != outer.getViewport) outer.setViewport(e))
      res
    }
    lazy val `viewportBorder` = {
      val res = Var(outer.getViewportBorder)
      res foreach (e => if (e != outer.getViewportBorder) outer.setViewportBorder(e))
      res
    }
    lazy val `viewportBorderBounds` = varAsSignal(Var(outer.getViewportBorderBounds))
    lazy val `wheelScrollingEnabled` = {
      val res = Var(outer.isWheelScrollingEnabled)
      res foreach (e => if (e != outer.isWheelScrollingEnabled) outer.setWheelScrollingEnabled(e))
      res
    }
    
    outer.addPropertyChangeListener(new java.beans.PropertyChangeListener {
      def propertyChange(evt: java.beans.PropertyChangeEvent) {
        def assign[T](s: Signal[T], value: Any) = s match {case v: Var[_] => v.asInstanceOf[Var[T]].value = value.asInstanceOf[T]; case _ =>}
        evt.getPropertyName match {
          case "`UI`" => assign(`UI`, evt.getNewValue)
          case "`columnHeader`" => assign(`columnHeader`, evt.getNewValue)
          case "`horizontalScrollBar`" => assign(`horizontalScrollBar`, evt.getNewValue)
          case "`horizontalScrollBarPolicy`" => assign(`horizontalScrollBarPolicy`, evt.getNewValue)
          case "`rowHeader`" => assign(`rowHeader`, evt.getNewValue)
          case "`verticalScrollBar`" => assign(`verticalScrollBar`, evt.getNewValue)
          case "`verticalScrollBarPolicy`" => assign(`verticalScrollBarPolicy`, evt.getNewValue)
          case "`viewport`" => assign(`viewport`, evt.getNewValue)
          case "`viewportBorder`" => assign(`viewportBorder`, evt.getNewValue)
          case "`viewportBorderBounds`" => assign(`viewportBorderBounds`, evt.getNewValue)
          case "`wheelScrollingEnabled`" => assign(`wheelScrollingEnabled`, evt.getNewValue)
          case _ =>
        }
      }
    })
  }
  
  override lazy val signals = new Signals {}
  
  

}
