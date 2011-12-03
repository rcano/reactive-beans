package reactive.jswing

import reactive._

//This file was auto generated
trait AbstractButtonReactive extends javax.swing.AbstractButton with JComponentReactive {
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
    lazy val `action` = {
      val res = Var(outer.getAction)
      res foreach (e => if (e != outer.getAction) outer.setAction(e))
      res
    }
    lazy val `actionCommand` = {
      val res = Var(outer.getActionCommand)
      res foreach (e => if (e != outer.getActionCommand) outer.setActionCommand(e))
      res
    }
    lazy val `actionListeners` = varAsSignal(Var(outer.getActionListeners))
    lazy val `borderPainted` = {
      val res = Var(outer.isBorderPainted)
      res foreach (e => if (e != outer.isBorderPainted) outer.setBorderPainted(e))
      res
    }
    lazy val `changeListeners` = varAsSignal(Var(outer.getChangeListeners))
    lazy val `contentAreaFilled` = {
      val res = Var(outer.isContentAreaFilled)
      res foreach (e => if (e != outer.isContentAreaFilled) outer.setContentAreaFilled(e))
      res
    }
    lazy val `disabledIcon` = {
      val res = Var(outer.getDisabledIcon)
      res foreach (e => if (e != outer.getDisabledIcon) outer.setDisabledIcon(e))
      res
    }
    lazy val `disabledSelectedIcon` = {
      val res = Var(outer.getDisabledSelectedIcon)
      res foreach (e => if (e != outer.getDisabledSelectedIcon) outer.setDisabledSelectedIcon(e))
      res
    }
    lazy val `displayedMnemonicIndex` = {
      val res = Var(outer.getDisplayedMnemonicIndex)
      res foreach (e => if (e != outer.getDisplayedMnemonicIndex) outer.setDisplayedMnemonicIndex(e))
      res
    }
    lazy val `focusPainted` = {
      val res = Var(outer.isFocusPainted)
      res foreach (e => if (e != outer.isFocusPainted) outer.setFocusPainted(e))
      res
    }
    lazy val `hideActionText` = {
      val res = Var(outer.getHideActionText)
      res foreach (e => if (e != outer.getHideActionText) outer.setHideActionText(e))
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
    lazy val `itemListeners` = varAsSignal(Var(outer.getItemListeners))
    lazy val `label` = {
      val res = Var(outer.getLabel)
      res foreach (e => if (e != outer.getLabel) outer.setLabel(e))
      res
    }
    lazy val `margin` = {
      val res = Var(outer.getMargin)
      res foreach (e => if (e != outer.getMargin) outer.setMargin(e))
      res
    }
    lazy val `mnemonic` = {
      val res = Var(outer.getMnemonic)
      res foreach (e => if (e != outer.getMnemonic) outer.setMnemonic(e))
      res
    }
    lazy val `model` = {
      val res = Var(outer.getModel)
      res foreach (e => if (e != outer.getModel) outer.setModel(e))
      res
    }
    lazy val `multiClickThreshhold` = {
      val res = Var(outer.getMultiClickThreshhold)
      res foreach (e => if (e != outer.getMultiClickThreshhold) outer.setMultiClickThreshhold(e))
      res
    }
    lazy val `pressedIcon` = {
      val res = Var(outer.getPressedIcon)
      res foreach (e => if (e != outer.getPressedIcon) outer.setPressedIcon(e))
      res
    }
    lazy val `rolloverEnabled` = {
      val res = Var(outer.isRolloverEnabled)
      res foreach (e => if (e != outer.isRolloverEnabled) outer.setRolloverEnabled(e))
      res
    }
    lazy val `rolloverIcon` = {
      val res = Var(outer.getRolloverIcon)
      res foreach (e => if (e != outer.getRolloverIcon) outer.setRolloverIcon(e))
      res
    }
    lazy val `rolloverSelectedIcon` = {
      val res = Var(outer.getRolloverSelectedIcon)
      res foreach (e => if (e != outer.getRolloverSelectedIcon) outer.setRolloverSelectedIcon(e))
      res
    }
    lazy val `selected` = {
      val res = Var(outer.isSelected)
      res foreach (e => if (e != outer.isSelected) outer.setSelected(e))
      res
    }
    lazy val `selectedIcon` = {
      val res = Var(outer.getSelectedIcon)
      res foreach (e => if (e != outer.getSelectedIcon) outer.setSelectedIcon(e))
      res
    }
    lazy val `selectedObjects` = varAsSignal(Var(outer.getSelectedObjects))
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
          case "`action`" => assign(`action`, evt.getNewValue)
          case "`actionCommand`" => assign(`actionCommand`, evt.getNewValue)
          case "`actionListeners`" => assign(`actionListeners`, evt.getNewValue)
          case "`borderPainted`" => assign(`borderPainted`, evt.getNewValue)
          case "`changeListeners`" => assign(`changeListeners`, evt.getNewValue)
          case "`contentAreaFilled`" => assign(`contentAreaFilled`, evt.getNewValue)
          case "`disabledIcon`" => assign(`disabledIcon`, evt.getNewValue)
          case "`disabledSelectedIcon`" => assign(`disabledSelectedIcon`, evt.getNewValue)
          case "`displayedMnemonicIndex`" => assign(`displayedMnemonicIndex`, evt.getNewValue)
          case "`focusPainted`" => assign(`focusPainted`, evt.getNewValue)
          case "`hideActionText`" => assign(`hideActionText`, evt.getNewValue)
          case "`horizontalAlignment`" => assign(`horizontalAlignment`, evt.getNewValue)
          case "`horizontalTextPosition`" => assign(`horizontalTextPosition`, evt.getNewValue)
          case "`icon`" => assign(`icon`, evt.getNewValue)
          case "`iconTextGap`" => assign(`iconTextGap`, evt.getNewValue)
          case "`itemListeners`" => assign(`itemListeners`, evt.getNewValue)
          case "`label`" => assign(`label`, evt.getNewValue)
          case "`margin`" => assign(`margin`, evt.getNewValue)
          case "`mnemonic`" => assign(`mnemonic`, evt.getNewValue)
          case "`model`" => assign(`model`, evt.getNewValue)
          case "`multiClickThreshhold`" => assign(`multiClickThreshhold`, evt.getNewValue)
          case "`pressedIcon`" => assign(`pressedIcon`, evt.getNewValue)
          case "`rolloverEnabled`" => assign(`rolloverEnabled`, evt.getNewValue)
          case "`rolloverIcon`" => assign(`rolloverIcon`, evt.getNewValue)
          case "`rolloverSelectedIcon`" => assign(`rolloverSelectedIcon`, evt.getNewValue)
          case "`selected`" => assign(`selected`, evt.getNewValue)
          case "`selectedIcon`" => assign(`selectedIcon`, evt.getNewValue)
          case "`selectedObjects`" => assign(`selectedObjects`, evt.getNewValue)
          case "`text`" => assign(`text`, evt.getNewValue)
          case "`verticalAlignment`" => assign(`verticalAlignment`, evt.getNewValue)
          case "`verticalTextPosition`" => assign(`verticalTextPosition`, evt.getNewValue)
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
    object item {
      val itemStateChanged = new ESource[java.awt.event.ItemEvent]
    }
    outer.addItemListener(new java.awt.event.ItemListener {
      def itemStateChanged(evt: java.awt.event.ItemEvent) {EventStreams.this.item.itemStateChanged.fire(evt)}
    })
    object action {
      val actionPerformed = new ESource[java.awt.event.ActionEvent]
    }
    outer.addActionListener(new java.awt.event.ActionListener {
      def actionPerformed(evt: java.awt.event.ActionEvent) {EventStreams.this.action.actionPerformed.fire(evt)}
    })
  }
  
  override lazy val events = new EventStreams {}
  

}
