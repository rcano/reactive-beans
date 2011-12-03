package reactive.jswing

import reactive._

//This file was auto generated
trait JTreeReactive extends javax.swing.JTree with JComponentReactive {
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
    lazy val `anchorSelectionPath` = {
      val res = Var(outer.getAnchorSelectionPath)
      res foreach (e => if (e != outer.getAnchorSelectionPath) outer.setAnchorSelectionPath(e))
      res
    }
    lazy val `cellEditor` = {
      val res = Var(outer.getCellEditor)
      res foreach (e => if (e != outer.getCellEditor) outer.setCellEditor(e))
      res
    }
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
    lazy val `editable` = {
      val res = Var(outer.isEditable)
      res foreach (e => if (e != outer.isEditable) outer.setEditable(e))
      res
    }
    lazy val `editing` = varAsSignal(Var(outer.isEditing))
    lazy val `editingPath` = varAsSignal(Var(outer.getEditingPath))
    lazy val `expandsSelectedPaths` = {
      val res = Var(outer.getExpandsSelectedPaths)
      res foreach (e => if (e != outer.getExpandsSelectedPaths) outer.setExpandsSelectedPaths(e))
      res
    }
    lazy val `fixedRowHeight` = varAsSignal(Var(outer.isFixedRowHeight))
    lazy val `invokesStopCellEditing` = {
      val res = Var(outer.getInvokesStopCellEditing)
      res foreach (e => if (e != outer.getInvokesStopCellEditing) outer.setInvokesStopCellEditing(e))
      res
    }
    lazy val `largeModel` = {
      val res = Var(outer.isLargeModel)
      res foreach (e => if (e != outer.isLargeModel) outer.setLargeModel(e))
      res
    }
    lazy val `lastSelectedPathComponent` = varAsSignal(Var(outer.getLastSelectedPathComponent))
    lazy val `leadSelectionPath` = {
      val res = Var(outer.getLeadSelectionPath)
      res foreach (e => if (e != outer.getLeadSelectionPath) outer.setLeadSelectionPath(e))
      res
    }
    lazy val `leadSelectionRow` = varAsSignal(Var(outer.getLeadSelectionRow))
    lazy val `maxSelectionRow` = varAsSignal(Var(outer.getMaxSelectionRow))
    lazy val `minSelectionRow` = varAsSignal(Var(outer.getMinSelectionRow))
    lazy val `model` = {
      val res = Var(outer.getModel)
      res foreach (e => if (e != outer.getModel) outer.setModel(e))
      res
    }
    lazy val `preferredScrollableViewportSize` = varAsSignal(Var(outer.getPreferredScrollableViewportSize))
    lazy val `rootVisible` = {
      val res = Var(outer.isRootVisible)
      res foreach (e => if (e != outer.isRootVisible) outer.setRootVisible(e))
      res
    }
    lazy val `rowCount` = varAsSignal(Var(outer.getRowCount))
    lazy val `rowHeight` = {
      val res = Var(outer.getRowHeight)
      res foreach (e => if (e != outer.getRowHeight) outer.setRowHeight(e))
      res
    }
    lazy val `scrollableTracksViewportHeight` = varAsSignal(Var(outer.getScrollableTracksViewportHeight))
    lazy val `scrollableTracksViewportWidth` = varAsSignal(Var(outer.getScrollableTracksViewportWidth))
    lazy val `scrollsOnExpand` = {
      val res = Var(outer.getScrollsOnExpand)
      res foreach (e => if (e != outer.getScrollsOnExpand) outer.setScrollsOnExpand(e))
      res
    }
    lazy val `selectionCount` = varAsSignal(Var(outer.getSelectionCount))
    lazy val `selectionEmpty` = varAsSignal(Var(outer.isSelectionEmpty))
    lazy val `selectionModel` = {
      val res = Var(outer.getSelectionModel)
      res foreach (e => if (e != outer.getSelectionModel) outer.setSelectionModel(e))
      res
    }
    lazy val `selectionPath` = {
      val res = Var(outer.getSelectionPath)
      res foreach (e => if (e != outer.getSelectionPath) outer.setSelectionPath(e))
      res
    }
    lazy val `selectionPaths` = {
      val res = Var(outer.getSelectionPaths)
      res foreach (e => if (e != outer.getSelectionPaths) outer.setSelectionPaths(e))
      res
    }
    lazy val `selectionRows` = {
      val res = Var(outer.getSelectionRows)
      res foreach (e => if (e != outer.getSelectionRows) outer.setSelectionRows(e))
      res
    }
    lazy val `showsRootHandles` = {
      val res = Var(outer.getShowsRootHandles)
      res foreach (e => if (e != outer.getShowsRootHandles) outer.setShowsRootHandles(e))
      res
    }
    lazy val `toggleClickCount` = {
      val res = Var(outer.getToggleClickCount)
      res foreach (e => if (e != outer.getToggleClickCount) outer.setToggleClickCount(e))
      res
    }
    lazy val `treeExpansionListeners` = varAsSignal(Var(outer.getTreeExpansionListeners))
    lazy val `treeSelectionListeners` = varAsSignal(Var(outer.getTreeSelectionListeners))
    lazy val `treeWillExpandListeners` = varAsSignal(Var(outer.getTreeWillExpandListeners))
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
          case "`anchorSelectionPath`" => assign(`anchorSelectionPath`, evt.getNewValue)
          case "`cellEditor`" => assign(`cellEditor`, evt.getNewValue)
          case "`cellRenderer`" => assign(`cellRenderer`, evt.getNewValue)
          case "`dragEnabled`" => assign(`dragEnabled`, evt.getNewValue)
          case "`dropLocation`" => assign(`dropLocation`, evt.getNewValue)
          case "`dropMode`" => assign(`dropMode`, evt.getNewValue)
          case "`editable`" => assign(`editable`, evt.getNewValue)
          case "`editing`" => assign(`editing`, evt.getNewValue)
          case "`editingPath`" => assign(`editingPath`, evt.getNewValue)
          case "`expandsSelectedPaths`" => assign(`expandsSelectedPaths`, evt.getNewValue)
          case "`fixedRowHeight`" => assign(`fixedRowHeight`, evt.getNewValue)
          case "`invokesStopCellEditing`" => assign(`invokesStopCellEditing`, evt.getNewValue)
          case "`largeModel`" => assign(`largeModel`, evt.getNewValue)
          case "`lastSelectedPathComponent`" => assign(`lastSelectedPathComponent`, evt.getNewValue)
          case "`leadSelectionPath`" => assign(`leadSelectionPath`, evt.getNewValue)
          case "`leadSelectionRow`" => assign(`leadSelectionRow`, evt.getNewValue)
          case "`maxSelectionRow`" => assign(`maxSelectionRow`, evt.getNewValue)
          case "`minSelectionRow`" => assign(`minSelectionRow`, evt.getNewValue)
          case "`model`" => assign(`model`, evt.getNewValue)
          case "`preferredScrollableViewportSize`" => assign(`preferredScrollableViewportSize`, evt.getNewValue)
          case "`rootVisible`" => assign(`rootVisible`, evt.getNewValue)
          case "`rowCount`" => assign(`rowCount`, evt.getNewValue)
          case "`rowHeight`" => assign(`rowHeight`, evt.getNewValue)
          case "`scrollableTracksViewportHeight`" => assign(`scrollableTracksViewportHeight`, evt.getNewValue)
          case "`scrollableTracksViewportWidth`" => assign(`scrollableTracksViewportWidth`, evt.getNewValue)
          case "`scrollsOnExpand`" => assign(`scrollsOnExpand`, evt.getNewValue)
          case "`selectionCount`" => assign(`selectionCount`, evt.getNewValue)
          case "`selectionEmpty`" => assign(`selectionEmpty`, evt.getNewValue)
          case "`selectionModel`" => assign(`selectionModel`, evt.getNewValue)
          case "`selectionPath`" => assign(`selectionPath`, evt.getNewValue)
          case "`selectionPaths`" => assign(`selectionPaths`, evt.getNewValue)
          case "`selectionRows`" => assign(`selectionRows`, evt.getNewValue)
          case "`showsRootHandles`" => assign(`showsRootHandles`, evt.getNewValue)
          case "`toggleClickCount`" => assign(`toggleClickCount`, evt.getNewValue)
          case "`treeExpansionListeners`" => assign(`treeExpansionListeners`, evt.getNewValue)
          case "`treeSelectionListeners`" => assign(`treeSelectionListeners`, evt.getNewValue)
          case "`treeWillExpandListeners`" => assign(`treeWillExpandListeners`, evt.getNewValue)
          case "`visibleRowCount`" => assign(`visibleRowCount`, evt.getNewValue)
          case _ =>
        }
      }
    })
  }
  
  override lazy val signals = new Signals {}
  
  trait EventStreams extends super.EventStreams {
    object treeWillExpand {
      val treeWillExpand = new ESource[javax.swing.event.TreeExpansionEvent]
      val treeWillCollapse = new ESource[javax.swing.event.TreeExpansionEvent]
    }
    outer.addTreeWillExpandListener(new javax.swing.event.TreeWillExpandListener {
      def treeWillExpand(evt: javax.swing.event.TreeExpansionEvent) {EventStreams.this.treeWillExpand.treeWillExpand.fire(evt)}
      def treeWillCollapse(evt: javax.swing.event.TreeExpansionEvent) {EventStreams.this.treeWillExpand.treeWillCollapse.fire(evt)}
    })
    object treeExpansion {
      val treeExpanded = new ESource[javax.swing.event.TreeExpansionEvent]
      val treeCollapsed = new ESource[javax.swing.event.TreeExpansionEvent]
    }
    outer.addTreeExpansionListener(new javax.swing.event.TreeExpansionListener {
      def treeExpanded(evt: javax.swing.event.TreeExpansionEvent) {EventStreams.this.treeExpansion.treeExpanded.fire(evt)}
      def treeCollapsed(evt: javax.swing.event.TreeExpansionEvent) {EventStreams.this.treeExpansion.treeCollapsed.fire(evt)}
    })
    object treeSelection {
      val valueChanged = new ESource[javax.swing.event.TreeSelectionEvent]
    }
    outer.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener {
      def valueChanged(evt: javax.swing.event.TreeSelectionEvent) {EventStreams.this.treeSelection.valueChanged.fire(evt)}
    })
  }
  
  override lazy val events = new EventStreams {}
  

}
