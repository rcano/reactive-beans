package reactive.jswing

import reactive._

//This file was auto generated
trait JComboBoxReactiveProxy[E <: java.lang.Object] extends JComponentReactiveProxy  {
  override def peer: javax.swing.JComboBox[E]
  private[JComboBoxReactiveProxy] lazy val outer = peer
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
    lazy val `editable` = {
      val res = Var(outer.isEditable())
      res foreach (e => if (e != outer.isEditable()) outer.setEditable(e))
      res
    }
    lazy val `editor` = {
      val res = Var(outer.getEditor)
      res foreach (e => if (e != outer.getEditor) outer.setEditor(e))
      res
    }
    lazy val `itemCount` = varAsSignal(Var(outer.getItemCount))
    lazy val `itemListeners` = varAsSignal(Var(outer.getItemListeners))
    lazy val `keySelectionManager` = {
      val res = Var(outer.getKeySelectionManager)
      res foreach (e => if (e != outer.getKeySelectionManager) outer.setKeySelectionManager(e))
      res
    }
    lazy val `lightWeightPopupEnabled` = {
      val res = Var(outer.isLightWeightPopupEnabled)
      res foreach (e => if (e != outer.isLightWeightPopupEnabled) outer.setLightWeightPopupEnabled(e))
      res
    }
    lazy val `maximumRowCount` = {
      val res = Var(outer.getMaximumRowCount)
      res foreach (e => if (e != outer.getMaximumRowCount) outer.setMaximumRowCount(e))
      res
    }
    lazy val `model` = {
      val res = Var(outer.getModel)
      res foreach (e => if (e != outer.getModel) outer.setModel(e))
      res
    }
    lazy val `popupMenuListeners` = varAsSignal(Var(outer.getPopupMenuListeners))
    lazy val `popupVisible` = {
      val res = Var(outer.isPopupVisible)
      res foreach (e => if (e != outer.isPopupVisible) outer.setPopupVisible(e))
      res
    }
    lazy val `prototypeDisplayValue` = {
      val res = Var(outer.getPrototypeDisplayValue)
      res foreach (e => if (e != outer.getPrototypeDisplayValue) outer.setPrototypeDisplayValue(e))
      res
    }
    lazy val `renderer` = {
      val res = Var(outer.getRenderer)
      res foreach (e => if (e != outer.getRenderer) outer.setRenderer(e))
      res
    }
    lazy val `selectedIndex` = {
      val res = Var(outer.getSelectedIndex)
      res foreach (e => if (e != outer.getSelectedIndex) outer.setSelectedIndex(e))
      res
    }
    lazy val `selectedItem` = {
      val res = Var(outer.getSelectedItem)
      res foreach (e => if (e != outer.getSelectedItem) outer.setSelectedItem(e))
      res
    }
    lazy val `selectedObjects` = varAsSignal(Var(outer.getSelectedObjects))
    
    outer.addPropertyChangeListener(new java.beans.PropertyChangeListener {
      def propertyChange(evt: java.beans.PropertyChangeEvent) {
        def assign[T](s: Signal[T], value: Any) = s match {case v: Var[_] => v.asInstanceOf[Var[T]].value = value.asInstanceOf[T]; case _ =>}
        evt.getPropertyName match {
          case "`UI`" => assign(`UI`, evt.getNewValue)
          case "`action`" => assign(`action`, evt.getNewValue)
          case "`actionCommand`" => assign(`actionCommand`, evt.getNewValue)
          case "`actionListeners`" => assign(`actionListeners`, evt.getNewValue)
          case "`editable`" => assign(`editable`, evt.getNewValue)
          case "`editor`" => assign(`editor`, evt.getNewValue)
          case "`itemCount`" => assign(`itemCount`, evt.getNewValue)
          case "`itemListeners`" => assign(`itemListeners`, evt.getNewValue)
          case "`keySelectionManager`" => assign(`keySelectionManager`, evt.getNewValue)
          case "`lightWeightPopupEnabled`" => assign(`lightWeightPopupEnabled`, evt.getNewValue)
          case "`maximumRowCount`" => assign(`maximumRowCount`, evt.getNewValue)
          case "`model`" => assign(`model`, evt.getNewValue)
          case "`popupMenuListeners`" => assign(`popupMenuListeners`, evt.getNewValue)
          case "`popupVisible`" => assign(`popupVisible`, evt.getNewValue)
          case "`prototypeDisplayValue`" => assign(`prototypeDisplayValue`, evt.getNewValue)
          case "`renderer`" => assign(`renderer`, evt.getNewValue)
          case "`selectedIndex`" => assign(`selectedIndex`, evt.getNewValue)
          case "`selectedItem`" => assign(`selectedItem`, evt.getNewValue)
          case "`selectedObjects`" => assign(`selectedObjects`, evt.getNewValue)
          case _ =>
        }
      }
    })
  }
  
  override lazy val signals = new Signals {}
  
  trait EventStreams extends super.EventStreams {
    object popupMenu {
      val popupMenuWillBecomeVisible = new ESource[javax.swing.event.PopupMenuEvent]
      val popupMenuWillBecomeInvisible = new ESource[javax.swing.event.PopupMenuEvent]
      val popupMenuCanceled = new ESource[javax.swing.event.PopupMenuEvent]
    }
    outer.addPopupMenuListener(new javax.swing.event.PopupMenuListener {
      def popupMenuWillBecomeVisible(evt: javax.swing.event.PopupMenuEvent) {EventStreams.this.popupMenu.popupMenuWillBecomeVisible.fire(evt)}
      def popupMenuWillBecomeInvisible(evt: javax.swing.event.PopupMenuEvent) {EventStreams.this.popupMenu.popupMenuWillBecomeInvisible.fire(evt)}
      def popupMenuCanceled(evt: javax.swing.event.PopupMenuEvent) {EventStreams.this.popupMenu.popupMenuCanceled.fire(evt)}
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
