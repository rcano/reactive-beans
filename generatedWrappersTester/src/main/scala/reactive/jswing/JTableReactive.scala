package reactive.jswing

import reactive._

//This file was auto generated
trait JTableReactive extends javax.swing.JTable with JComponentReactive {
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
    lazy val `autoCreateColumnsFromModel` = {
      val res = Var(outer.getAutoCreateColumnsFromModel)
      res foreach (e => if (e != outer.getAutoCreateColumnsFromModel) outer.setAutoCreateColumnsFromModel(e))
      res
    }
    lazy val `autoCreateRowSorter` = {
      val res = Var(outer.getAutoCreateRowSorter)
      res foreach (e => if (e != outer.getAutoCreateRowSorter) outer.setAutoCreateRowSorter(e))
      res
    }
    lazy val `autoResizeMode` = {
      val res = Var(outer.getAutoResizeMode)
      res foreach (e => if (e != outer.getAutoResizeMode) outer.setAutoResizeMode(e))
      res
    }
    lazy val `cellEditor` = {
      val res = Var(outer.getCellEditor)
      res foreach (e => if (e != outer.getCellEditor) outer.setCellEditor(e))
      res
    }
    lazy val `cellSelectionEnabled` = {
      val res = Var(outer.getCellSelectionEnabled)
      res foreach (e => if (e != outer.getCellSelectionEnabled) outer.setCellSelectionEnabled(e))
      res
    }
    lazy val `columnCount` = varAsSignal(Var(outer.getColumnCount))
    lazy val `columnModel` = {
      val res = Var(outer.getColumnModel)
      res foreach (e => if (e != outer.getColumnModel) outer.setColumnModel(e))
      res
    }
    lazy val `columnSelectionAllowed` = {
      val res = Var(outer.getColumnSelectionAllowed)
      res foreach (e => if (e != outer.getColumnSelectionAllowed) outer.setColumnSelectionAllowed(e))
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
    lazy val `editing` = varAsSignal(Var(outer.isEditing))
    lazy val `editingColumn` = {
      val res = Var(outer.getEditingColumn)
      res foreach (e => if (e != outer.getEditingColumn) outer.setEditingColumn(e))
      res
    }
    lazy val `editingRow` = {
      val res = Var(outer.getEditingRow)
      res foreach (e => if (e != outer.getEditingRow) outer.setEditingRow(e))
      res
    }
    lazy val `editorComponent` = varAsSignal(Var(outer.getEditorComponent))
    lazy val `fillsViewportHeight` = {
      val res = Var(outer.getFillsViewportHeight)
      res foreach (e => if (e != outer.getFillsViewportHeight) outer.setFillsViewportHeight(e))
      res
    }
    lazy val `gridColor` = {
      val res = Var(outer.getGridColor)
      res foreach (e => if (e != outer.getGridColor) outer.setGridColor(e))
      res
    }
    lazy val `intercellSpacing` = {
      val res = Var(outer.getIntercellSpacing)
      res foreach (e => if (e != outer.getIntercellSpacing) outer.setIntercellSpacing(e))
      res
    }
    lazy val `model` = {
      val res = Var(outer.getModel)
      res foreach (e => if (e != outer.getModel) outer.setModel(e))
      res
    }
    lazy val `preferredScrollableViewportSize` = {
      val res = Var(outer.getPreferredScrollableViewportSize)
      res foreach (e => if (e != outer.getPreferredScrollableViewportSize) outer.setPreferredScrollableViewportSize(e))
      res
    }
    lazy val `rowCount` = varAsSignal(Var(outer.getRowCount))
    lazy val `rowMargin` = {
      val res = Var(outer.getRowMargin)
      res foreach (e => if (e != outer.getRowMargin) outer.setRowMargin(e))
      res
    }
    lazy val `rowSelectionAllowed` = {
      val res = Var(outer.getRowSelectionAllowed)
      res foreach (e => if (e != outer.getRowSelectionAllowed) outer.setRowSelectionAllowed(e))
      res
    }
    lazy val `rowSorter` = {
      val res = Var(outer.getRowSorter)
      res foreach (e => if (e != outer.getRowSorter) outer.setRowSorter(e))
      res
    }
    lazy val `scrollableTracksViewportHeight` = varAsSignal(Var(outer.getScrollableTracksViewportHeight))
    lazy val `scrollableTracksViewportWidth` = varAsSignal(Var(outer.getScrollableTracksViewportWidth))
    lazy val `selectedColumn` = varAsSignal(Var(outer.getSelectedColumn))
    lazy val `selectedColumnCount` = varAsSignal(Var(outer.getSelectedColumnCount))
    lazy val `selectedColumns` = varAsSignal(Var(outer.getSelectedColumns))
    lazy val `selectedRow` = varAsSignal(Var(outer.getSelectedRow))
    lazy val `selectedRowCount` = varAsSignal(Var(outer.getSelectedRowCount))
    lazy val `selectedRows` = varAsSignal(Var(outer.getSelectedRows))
    lazy val `selectionBackground` = {
      val res = Var(outer.getSelectionBackground)
      res foreach (e => if (e != outer.getSelectionBackground) outer.setSelectionBackground(e))
      res
    }
    lazy val `selectionForeground` = {
      val res = Var(outer.getSelectionForeground)
      res foreach (e => if (e != outer.getSelectionForeground) outer.setSelectionForeground(e))
      res
    }
    lazy val `selectionModel` = {
      val res = Var(outer.getSelectionModel)
      res foreach (e => if (e != outer.getSelectionModel) outer.setSelectionModel(e))
      res
    }
    lazy val `showHorizontalLines` = {
      val res = Var(outer.getShowHorizontalLines)
      res foreach (e => if (e != outer.getShowHorizontalLines) outer.setShowHorizontalLines(e))
      res
    }
    lazy val `showVerticalLines` = {
      val res = Var(outer.getShowVerticalLines)
      res foreach (e => if (e != outer.getShowVerticalLines) outer.setShowVerticalLines(e))
      res
    }
    lazy val `surrendersFocusOnKeystroke` = {
      val res = Var(outer.getSurrendersFocusOnKeystroke)
      res foreach (e => if (e != outer.getSurrendersFocusOnKeystroke) outer.setSurrendersFocusOnKeystroke(e))
      res
    }
    lazy val `tableHeader` = {
      val res = Var(outer.getTableHeader)
      res foreach (e => if (e != outer.getTableHeader) outer.setTableHeader(e))
      res
    }
    lazy val `updateSelectionOnSort` = {
      val res = Var(outer.getUpdateSelectionOnSort)
      res foreach (e => if (e != outer.getUpdateSelectionOnSort) outer.setUpdateSelectionOnSort(e))
      res
    }
    
    outer.addPropertyChangeListener(new java.beans.PropertyChangeListener {
      def propertyChange(evt: java.beans.PropertyChangeEvent) {
        def assign[T](s: Signal[T], value: Any) = s match {case v: Var[_] => v.asInstanceOf[Var[T]].value = value.asInstanceOf[T]; case _ =>}
        evt.getPropertyName match {
          case "`UI`" => assign(`UI`, evt.getNewValue)
          case "`autoCreateColumnsFromModel`" => assign(`autoCreateColumnsFromModel`, evt.getNewValue)
          case "`autoCreateRowSorter`" => assign(`autoCreateRowSorter`, evt.getNewValue)
          case "`autoResizeMode`" => assign(`autoResizeMode`, evt.getNewValue)
          case "`cellEditor`" => assign(`cellEditor`, evt.getNewValue)
          case "`cellSelectionEnabled`" => assign(`cellSelectionEnabled`, evt.getNewValue)
          case "`columnCount`" => assign(`columnCount`, evt.getNewValue)
          case "`columnModel`" => assign(`columnModel`, evt.getNewValue)
          case "`columnSelectionAllowed`" => assign(`columnSelectionAllowed`, evt.getNewValue)
          case "`dragEnabled`" => assign(`dragEnabled`, evt.getNewValue)
          case "`dropLocation`" => assign(`dropLocation`, evt.getNewValue)
          case "`dropMode`" => assign(`dropMode`, evt.getNewValue)
          case "`editing`" => assign(`editing`, evt.getNewValue)
          case "`editingColumn`" => assign(`editingColumn`, evt.getNewValue)
          case "`editingRow`" => assign(`editingRow`, evt.getNewValue)
          case "`editorComponent`" => assign(`editorComponent`, evt.getNewValue)
          case "`fillsViewportHeight`" => assign(`fillsViewportHeight`, evt.getNewValue)
          case "`gridColor`" => assign(`gridColor`, evt.getNewValue)
          case "`intercellSpacing`" => assign(`intercellSpacing`, evt.getNewValue)
          case "`model`" => assign(`model`, evt.getNewValue)
          case "`preferredScrollableViewportSize`" => assign(`preferredScrollableViewportSize`, evt.getNewValue)
          case "`rowCount`" => assign(`rowCount`, evt.getNewValue)
          case "`rowMargin`" => assign(`rowMargin`, evt.getNewValue)
          case "`rowSelectionAllowed`" => assign(`rowSelectionAllowed`, evt.getNewValue)
          case "`rowSorter`" => assign(`rowSorter`, evt.getNewValue)
          case "`scrollableTracksViewportHeight`" => assign(`scrollableTracksViewportHeight`, evt.getNewValue)
          case "`scrollableTracksViewportWidth`" => assign(`scrollableTracksViewportWidth`, evt.getNewValue)
          case "`selectedColumn`" => assign(`selectedColumn`, evt.getNewValue)
          case "`selectedColumnCount`" => assign(`selectedColumnCount`, evt.getNewValue)
          case "`selectedColumns`" => assign(`selectedColumns`, evt.getNewValue)
          case "`selectedRow`" => assign(`selectedRow`, evt.getNewValue)
          case "`selectedRowCount`" => assign(`selectedRowCount`, evt.getNewValue)
          case "`selectedRows`" => assign(`selectedRows`, evt.getNewValue)
          case "`selectionBackground`" => assign(`selectionBackground`, evt.getNewValue)
          case "`selectionForeground`" => assign(`selectionForeground`, evt.getNewValue)
          case "`selectionModel`" => assign(`selectionModel`, evt.getNewValue)
          case "`showHorizontalLines`" => assign(`showHorizontalLines`, evt.getNewValue)
          case "`showVerticalLines`" => assign(`showVerticalLines`, evt.getNewValue)
          case "`surrendersFocusOnKeystroke`" => assign(`surrendersFocusOnKeystroke`, evt.getNewValue)
          case "`tableHeader`" => assign(`tableHeader`, evt.getNewValue)
          case "`updateSelectionOnSort`" => assign(`updateSelectionOnSort`, evt.getNewValue)
          case _ =>
        }
      }
    })
  }
  
  override lazy val signals = new Signals {}
  
  

}
