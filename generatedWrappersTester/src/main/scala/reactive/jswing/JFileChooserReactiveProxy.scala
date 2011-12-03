package reactive.jswing

import reactive._

//This file was auto generated
trait JFileChooserReactiveProxy extends JComponentReactiveProxy  {
  override def peer: javax.swing.JFileChooser
  private[JFileChooserReactiveProxy] lazy val outer = peer
  trait Signals extends super.Signals {
    //helper method to treat var as signals without specifying the type
    //which might arise visibility problems (e.g.: the listeners field in scala.swing.Component
    @inline private[this] def varAsSignal[T](v: Var[T]) = v: Signal[T]
    lazy val `UI` = varAsSignal(Var(outer.getUI))
    lazy val `acceptAllFileFilter` = varAsSignal(Var(outer.getAcceptAllFileFilter))
    lazy val `acceptAllFileFilterUsed` = {
      val res = Var(outer.isAcceptAllFileFilterUsed)
      res foreach (e => if (e != outer.isAcceptAllFileFilterUsed) outer.setAcceptAllFileFilterUsed(e))
      res
    }
    lazy val `accessory` = {
      val res = Var(outer.getAccessory)
      res foreach (e => if (e != outer.getAccessory) outer.setAccessory(e))
      res
    }
    lazy val `actionListeners` = varAsSignal(Var(outer.getActionListeners))
    lazy val `approveButtonMnemonic` = {
      val res = Var(outer.getApproveButtonMnemonic)
      res foreach (e => if (e != outer.getApproveButtonMnemonic) outer.setApproveButtonMnemonic(e))
      res
    }
    lazy val `approveButtonText` = {
      val res = Var(outer.getApproveButtonText)
      res foreach (e => if (e != outer.getApproveButtonText) outer.setApproveButtonText(e))
      res
    }
    lazy val `approveButtonToolTipText` = {
      val res = Var(outer.getApproveButtonToolTipText)
      res foreach (e => if (e != outer.getApproveButtonToolTipText) outer.setApproveButtonToolTipText(e))
      res
    }
    lazy val `choosableFileFilters` = varAsSignal(Var(outer.getChoosableFileFilters))
    lazy val `controlButtonsAreShown` = {
      val res = Var(outer.getControlButtonsAreShown)
      res foreach (e => if (e != outer.getControlButtonsAreShown) outer.setControlButtonsAreShown(e))
      res
    }
    lazy val `currentDirectory` = {
      val res = Var(outer.getCurrentDirectory)
      res foreach (e => if (e != outer.getCurrentDirectory) outer.setCurrentDirectory(e))
      res
    }
    lazy val `dialogTitle` = {
      val res = Var(outer.getDialogTitle)
      res foreach (e => if (e != outer.getDialogTitle) outer.setDialogTitle(e))
      res
    }
    lazy val `dialogType` = {
      val res = Var(outer.getDialogType)
      res foreach (e => if (e != outer.getDialogType) outer.setDialogType(e))
      res
    }
    lazy val `directorySelectionEnabled` = varAsSignal(Var(outer.isDirectorySelectionEnabled))
    lazy val `dragEnabled` = {
      val res = Var(outer.getDragEnabled)
      res foreach (e => if (e != outer.getDragEnabled) outer.setDragEnabled(e))
      res
    }
    lazy val `fileFilter` = {
      val res = Var(outer.getFileFilter)
      res foreach (e => if (e != outer.getFileFilter) outer.setFileFilter(e))
      res
    }
    lazy val `fileHidingEnabled` = {
      val res = Var(outer.isFileHidingEnabled)
      res foreach (e => if (e != outer.isFileHidingEnabled) outer.setFileHidingEnabled(e))
      res
    }
    lazy val `fileSelectionEnabled` = varAsSignal(Var(outer.isFileSelectionEnabled))
    lazy val `fileSelectionMode` = {
      val res = Var(outer.getFileSelectionMode)
      res foreach (e => if (e != outer.getFileSelectionMode) outer.setFileSelectionMode(e))
      res
    }
    lazy val `fileSystemView` = {
      val res = Var(outer.getFileSystemView)
      res foreach (e => if (e != outer.getFileSystemView) outer.setFileSystemView(e))
      res
    }
    lazy val `fileView` = {
      val res = Var(outer.getFileView)
      res foreach (e => if (e != outer.getFileView) outer.setFileView(e))
      res
    }
    lazy val `multiSelectionEnabled` = {
      val res = Var(outer.isMultiSelectionEnabled)
      res foreach (e => if (e != outer.isMultiSelectionEnabled) outer.setMultiSelectionEnabled(e))
      res
    }
    lazy val `selectedFile` = {
      val res = Var(outer.getSelectedFile)
      res foreach (e => if (e != outer.getSelectedFile) outer.setSelectedFile(e))
      res
    }
    lazy val `selectedFiles` = {
      val res = Var(outer.getSelectedFiles)
      res foreach (e => if (e != outer.getSelectedFiles) outer.setSelectedFiles(e))
      res
    }
    
    outer.addPropertyChangeListener(new java.beans.PropertyChangeListener {
      def propertyChange(evt: java.beans.PropertyChangeEvent) {
        def assign[T](s: Signal[T], value: Any) = s match {case v: Var[_] => v.asInstanceOf[Var[T]].value = value.asInstanceOf[T]; case _ =>}
        evt.getPropertyName match {
          case "`UI`" => assign(`UI`, evt.getNewValue)
          case "`acceptAllFileFilter`" => assign(`acceptAllFileFilter`, evt.getNewValue)
          case "`acceptAllFileFilterUsed`" => assign(`acceptAllFileFilterUsed`, evt.getNewValue)
          case "`accessory`" => assign(`accessory`, evt.getNewValue)
          case "`actionListeners`" => assign(`actionListeners`, evt.getNewValue)
          case "`approveButtonMnemonic`" => assign(`approveButtonMnemonic`, evt.getNewValue)
          case "`approveButtonText`" => assign(`approveButtonText`, evt.getNewValue)
          case "`approveButtonToolTipText`" => assign(`approveButtonToolTipText`, evt.getNewValue)
          case "`choosableFileFilters`" => assign(`choosableFileFilters`, evt.getNewValue)
          case "`controlButtonsAreShown`" => assign(`controlButtonsAreShown`, evt.getNewValue)
          case "`currentDirectory`" => assign(`currentDirectory`, evt.getNewValue)
          case "`dialogTitle`" => assign(`dialogTitle`, evt.getNewValue)
          case "`dialogType`" => assign(`dialogType`, evt.getNewValue)
          case "`directorySelectionEnabled`" => assign(`directorySelectionEnabled`, evt.getNewValue)
          case "`dragEnabled`" => assign(`dragEnabled`, evt.getNewValue)
          case "`fileFilter`" => assign(`fileFilter`, evt.getNewValue)
          case "`fileHidingEnabled`" => assign(`fileHidingEnabled`, evt.getNewValue)
          case "`fileSelectionEnabled`" => assign(`fileSelectionEnabled`, evt.getNewValue)
          case "`fileSelectionMode`" => assign(`fileSelectionMode`, evt.getNewValue)
          case "`fileSystemView`" => assign(`fileSystemView`, evt.getNewValue)
          case "`fileView`" => assign(`fileView`, evt.getNewValue)
          case "`multiSelectionEnabled`" => assign(`multiSelectionEnabled`, evt.getNewValue)
          case "`selectedFile`" => assign(`selectedFile`, evt.getNewValue)
          case "`selectedFiles`" => assign(`selectedFiles`, evt.getNewValue)
          case _ =>
        }
      }
    })
  }
  
  override lazy val signals = new Signals {}
  
  trait EventStreams extends super.EventStreams {
    object action {
      val actionPerformed = new ESource[java.awt.event.ActionEvent]
    }
    outer.addActionListener(new java.awt.event.ActionListener {
      def actionPerformed(evt: java.awt.event.ActionEvent) {EventStreams.this.action.actionPerformed.fire(evt)}
    })
  }
  
  override lazy val events = new EventStreams {}
  

}
