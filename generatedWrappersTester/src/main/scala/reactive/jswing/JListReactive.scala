package reactive.jswing

import reactive._

//This file was auto generated
trait JListReactive[E <: java.lang.Object] extends javax.swing.JList[E] with JComponentReactive {
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
    lazy val `anchorSelectionIndex` = varAsSignal(Var(outer.getAnchorSelectionIndex))
    lazy val `cellRenderer` = {
      val res = Var(outer.getCellRenderer)
      res foreach (e => if (e != outer.getCellRenderer) outer.setCellRenderer(e))
      res
    }
    lazy val `dragEnabled` = {
      val res = Var(outer.getDragEnabled)
      res foreach (e => if (e != outer.getDragEnabled) outer.setDragEnabled(e))
      res
    }
    lazy val `dropLocation` = varAsSignal(Var(outer.getDropLocation))
    lazy val `dropMode` = {
      val res = Var(outer.getDropMode)
      res foreach (e => if (e != outer.getDropMode) outer.setDropMode(e))
      res
    }
    lazy val `firstVisibleIndex` = varAsSignal(Var(outer.getFirstVisibleIndex))
    lazy val `fixedCellHeight` = {
      val res = Var(outer.getFixedCellHeight)
      res foreach (e => if (e != outer.getFixedCellHeight) outer.setFixedCellHeight(e))
      res
    }
    lazy val `fixedCellWidth` = {
      val res = Var(outer.getFixedCellWidth)
      res foreach (e => if (e != outer.getFixedCellWidth) outer.setFixedCellWidth(e))
      res
    }
    lazy val `lastVisibleIndex` = varAsSignal(Var(outer.getLastVisibleIndex))
    lazy val `layoutOrientation` = {
      val res = Var(outer.getLayoutOrientation)
      res foreach (e => if (e != outer.getLayoutOrientation) outer.setLayoutOrientation(e))
      res
    }
    lazy val `leadSelectionIndex` = varAsSignal(Var(outer.getLeadSelectionIndex))
    lazy val `listSelectionListeners` = varAsSignal(Var(outer.getListSelectionListeners))
    lazy val `maxSelectionIndex` = varAsSignal(Var(outer.getMaxSelectionIndex))
    lazy val `minSelectionIndex` = varAsSignal(Var(outer.getMinSelectionIndex))
    lazy val `model` = {
      val res = Var(outer.getModel)
      res foreach (e => if (e != outer.getModel) outer.setModel(e))
      res
    }
    lazy val `preferredScrollableViewportSize` = varAsSignal(Var(outer.getPreferredScrollableViewportSize))
    lazy val `prototypeCellValue` = {
      val res = Var(outer.getPrototypeCellValue)
      res foreach (e => if (e != outer.getPrototypeCellValue) outer.setPrototypeCellValue(e))
      res
    }
    lazy val `scrollableTracksViewportHeight` = varAsSignal(Var(outer.getScrollableTracksViewportHeight))
    lazy val `scrollableTracksViewportWidth` = varAsSignal(Var(outer.getScrollableTracksViewportWidth))
    lazy val `selectedIndex` = {
      val res = Var(outer.getSelectedIndex)
      res foreach (e => if (e != outer.getSelectedIndex) outer.setSelectedIndex(e))
      res
    }
    lazy val `selectedIndices` = {
      val res = Var(outer.getSelectedIndices)
      res foreach (e => if (e != outer.getSelectedIndices) outer.setSelectedIndices(e))
      res
    }
    lazy val `selectedValue` = varAsSignal(Var(outer.getSelectedValue))
    lazy val `selectedValues` = varAsSignal(Var(outer.getSelectedValues))
    lazy val `selectedValuesList` = varAsSignal(Var(outer.getSelectedValuesList))
    lazy val `selectionBackground` = {
      val res = Var(outer.getSelectionBackground)
      res foreach (e => if (e != outer.getSelectionBackground) outer.setSelectionBackground(e))
      res
    }
    lazy val `selectionEmpty` = varAsSignal(Var(outer.isSelectionEmpty))
    lazy val `selectionForeground` = {
      val res = Var(outer.getSelectionForeground)
      res foreach (e => if (e != outer.getSelectionForeground) outer.setSelectionForeground(e))
      res
    }
    lazy val `selectionMode` = {
      val res = Var(outer.getSelectionMode)
      res foreach (e => if (e != outer.getSelectionMode) outer.setSelectionMode(e))
      res
    }
    lazy val `selectionModel` = {
      val res = Var(outer.getSelectionModel)
      res foreach (e => if (e != outer.getSelectionModel) outer.setSelectionModel(e))
      res
    }
    lazy val `valueIsAdjusting` = {
      val res = Var(outer.getValueIsAdjusting)
      res foreach (e => if (e != outer.getValueIsAdjusting) outer.setValueIsAdjusting(e))
      res
    }
    lazy val `visibleRowCount` = {
      val res = Var(outer.getVisibleRowCount)
      res foreach (e => if (e != outer.getVisibleRowCount) outer.setVisibleRowCount(e))
      res
    }
    
    outer.addPropertyChangeListener(new java.beans.PropertyChangeListener {
      def propertyChange(evt: java.beans.PropertyChangeEvent) {
        def assign[T](s: Signal[T], value: Any) = s match {case v: Var[_] => v.asInstanceOf[Var[T]].value = value.asInstanceOf[T]; case _ =>}
        evt.getPropertyName match {
          case "`UI`" => assign(`UI`, evt.getNewValue)
          case "`anchorSelectionIndex`" => assign(`anchorSelectionIndex`, evt.getNewValue)
          case "`cellRenderer`" => assign(`cellRenderer`, evt.getNewValue)
          case "`dragEnabled`" => assign(`dragEnabled`, evt.getNewValue)
          case "`dropLocation`" => assign(`dropLocation`, evt.getNewValue)
          case "`dropMode`" => assign(`dropMode`, evt.getNewValue)
          case "`firstVisibleIndex`" => assign(`firstVisibleIndex`, evt.getNewValue)
          case "`fixedCellHeight`" => assign(`fixedCellHeight`, evt.getNewValue)
          case "`fixedCellWidth`" => assign(`fixedCellWidth`, evt.getNewValue)
          case "`lastVisibleIndex`" => assign(`lastVisibleIndex`, evt.getNewValue)
          case "`layoutOrientation`" => assign(`layoutOrientation`, evt.getNewValue)
          case "`leadSelectionIndex`" => assign(`leadSelectionIndex`, evt.getNewValue)
          case "`listSelectionListeners`" => assign(`listSelectionListeners`, evt.getNewValue)
          case "`maxSelectionIndex`" => assign(`maxSelectionIndex`, evt.getNewValue)
          case "`minSelectionIndex`" => assign(`minSelectionIndex`, evt.getNewValue)
          case "`model`" => assign(`model`, evt.getNewValue)
          case "`preferredScrollableViewportSize`" => assign(`preferredScrollableViewportSize`, evt.getNewValue)
          case "`prototypeCellValue`" => assign(`prototypeCellValue`, evt.getNewValue)
          case "`scrollableTracksViewportHeight`" => assign(`scrollableTracksViewportHeight`, evt.getNewValue)
          case "`scrollableTracksViewportWidth`" => assign(`scrollableTracksViewportWidth`, evt.getNewValue)
          case "`selectedIndex`" => assign(`selectedIndex`, evt.getNewValue)
          case "`selectedIndices`" => assign(`selectedIndices`, evt.getNewValue)
          case "`selectedValue`" => assign(`selectedValue`, evt.getNewValue)
          case "`selectedValues`" => assign(`selectedValues`, evt.getNewValue)
          case "`selectedValuesList`" => assign(`selectedValuesList`, evt.getNewValue)
          case "`selectionBackground`" => assign(`selectionBackground`, evt.getNewValue)
          case "`selectionEmpty`" => assign(`selectionEmpty`, evt.getNewValue)
          case "`selectionForeground`" => assign(`selectionForeground`, evt.getNewValue)
          case "`selectionMode`" => assign(`selectionMode`, evt.getNewValue)
          case "`selectionModel`" => assign(`selectionModel`, evt.getNewValue)
          case "`valueIsAdjusting`" => assign(`valueIsAdjusting`, evt.getNewValue)
          case "`visibleRowCount`" => assign(`visibleRowCount`, evt.getNewValue)
          case _ =>
        }
      }
    })
  }
  
  override lazy val signals = new Signals {}
  
  trait EventStreams extends super.EventStreams {
    object listSelection {
      val valueChanged = new ESource[javax.swing.event.ListSelectionEvent]
    }
    outer.addListSelectionListener(new javax.swing.event.ListSelectionListener {
      def valueChanged(evt: javax.swing.event.ListSelectionEvent) {EventStreams.this.listSelection.valueChanged.fire(evt)}
    })
  }
  
  override lazy val events = new EventStreams {}
  

}
