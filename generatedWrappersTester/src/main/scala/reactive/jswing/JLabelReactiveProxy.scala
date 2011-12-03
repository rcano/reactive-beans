package reactive.jswing

import reactive._

//This file was auto generated
trait JLabelReactiveProxy extends JComponentReactiveProxy  {
  override def peer: javax.swing.JLabel
  private[JLabelReactiveProxy] lazy val outer = peer
  trait Signals extends super.Signals {
    lazy val `UI` = {
      val res = Var(outer.getUI)
      res foreach (e => if (e != outer.getUI) outer.setUI(e))
      res
    }
    lazy val `disabledIcon` = {
      val res = Var(outer.getDisabledIcon)
      res foreach (e => if (e != outer.getDisabledIcon) outer.setDisabledIcon(e))
      res
    }
    lazy val `displayedMnemonic` = {
      val res = Var(outer.getDisplayedMnemonic)
      res foreach (e => if (e != outer.getDisplayedMnemonic) outer.setDisplayedMnemonic(e))
      res
    }
    lazy val `displayedMnemonicIndex` = {
      val res = Var(outer.getDisplayedMnemonicIndex)
      res foreach (e => if (e != outer.getDisplayedMnemonicIndex) outer.setDisplayedMnemonicIndex(e))
      res
    }
    lazy val `horizontalAlignment` = {
      val res = Var(outer.getHorizontalAlignment)
      res foreach (e => if (e != outer.getHorizontalAlignment) outer.setHorizontalAlignment(e))
      res
    }
    lazy val `horizontalTextPosition` = {
      val res = Var(outer.getHorizontalTextPosition)
      res foreach (e => if (e != outer.getHorizontalTextPosition) outer.setHorizontalTextPosition(e))
      res
    }
    lazy val `icon` = {
      val res = Var(outer.getIcon)
      res foreach (e => if (e != outer.getIcon) outer.setIcon(e))
      res
    }
    lazy val `iconTextGap` = {
      val res = Var(outer.getIconTextGap)
      res foreach (e => if (e != outer.getIconTextGap) outer.setIconTextGap(e))
      res
    }
    lazy val `labelFor` = {
      val res = Var(outer.getLabelFor)
      res foreach (e => if (e != outer.getLabelFor) outer.setLabelFor(e))
      res
    }
    lazy val `text` = {
      val res = Var(outer.getText)
      res foreach (e => if (e != outer.getText) outer.setText(e))
      res
    }
    lazy val `verticalAlignment` = {
      val res = Var(outer.getVerticalAlignment)
      res foreach (e => if (e != outer.getVerticalAlignment) outer.setVerticalAlignment(e))
      res
    }
    lazy val `verticalTextPosition` = {
      val res = Var(outer.getVerticalTextPosition)
      res foreach (e => if (e != outer.getVerticalTextPosition) outer.setVerticalTextPosition(e))
      res
    }
    
    outer.addPropertyChangeListener(new java.beans.PropertyChangeListener {
      def propertyChange(evt: java.beans.PropertyChangeEvent) {
        def assign[T](s: Signal[T], value: Any) = s match {case v: Var[_] => v.asInstanceOf[Var[T]].value = value.asInstanceOf[T]; case _ =>}
        evt.getPropertyName match {
          case "`UI`" => assign(`UI`, evt.getNewValue)
          case "`disabledIcon`" => assign(`disabledIcon`, evt.getNewValue)
          case "`displayedMnemonic`" => assign(`displayedMnemonic`, evt.getNewValue)
          case "`displayedMnemonicIndex`" => assign(`displayedMnemonicIndex`, evt.getNewValue)
          case "`horizontalAlignment`" => assign(`horizontalAlignment`, evt.getNewValue)
          case "`horizontalTextPosition`" => assign(`horizontalTextPosition`, evt.getNewValue)
          case "`icon`" => assign(`icon`, evt.getNewValue)
          case "`iconTextGap`" => assign(`iconTextGap`, evt.getNewValue)
          case "`labelFor`" => assign(`labelFor`, evt.getNewValue)
          case "`text`" => assign(`text`, evt.getNewValue)
          case "`verticalAlignment`" => assign(`verticalAlignment`, evt.getNewValue)
          case "`verticalTextPosition`" => assign(`verticalTextPosition`, evt.getNewValue)
          case _ =>
        }
      }
    })
  }
  
  override lazy val signals = new Signals {}
  
  

}
