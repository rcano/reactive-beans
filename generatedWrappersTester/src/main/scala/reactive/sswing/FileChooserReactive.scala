package reactive.sswing

import reactive._

//This file was auto generated
trait FileChooserReactive extends scala.swing.FileChooser with Observing {
  outer =>
  trait Signals {
    //helper method to treat var as signals without specifying the type
    //which might arise visibility problems (e.g.: the listeners field in scala.swing.Component
    @inline private[this] def varAsSignal[T](v: Var[T]) = v: Signal[T]
    lazy val `accessory` = {
      val res = Var(outer.accessory)
      res foreach (e => if (e != outer.accessory) outer.accessory_=(e))
      res
    }
    lazy val `controlButtonsAreShown` = {
      val res = Var(outer.controlButtonsAreShown)
      res foreach (e => if (e != outer.controlButtonsAreShown) outer.controlButtonsAreShown_=(e))
      res
    }
    lazy val `fileFilter` = {
      val res = Var(outer.fileFilter)
      res foreach (e => if (e != outer.fileFilter) outer.fileFilter_=(e))
      res
    }
    lazy val `fileHidingEnabled` = {
      val res = Var(outer.fileHidingEnabled)
      res foreach (e => if (e != outer.fileHidingEnabled) outer.fileHidingEnabled_=(e))
      res
    }
    lazy val `fileSelectionMode` = {
      val res = Var(outer.fileSelectionMode)
      res foreach (e => if (e != outer.fileSelectionMode) outer.fileSelectionMode_=(e))
      res
    }
    lazy val `multiSelectionEnabled` = {
      val res = Var(outer.multiSelectionEnabled)
      res foreach (e => if (e != outer.multiSelectionEnabled) outer.multiSelectionEnabled_=(e))
      res
    }
    lazy val `peer` = varAsSignal(Var(outer.peer))
    lazy val `selectedFile` = {
      val res = Var(outer.selectedFile)
      res foreach (e => if (e != outer.selectedFile) outer.selectedFile_=(e))
      res
    }
    lazy val `selectedFiles` = {
      val res = Var(outer.selectedFiles)
      res foreach (e => if (e != outer.selectedFiles) outer.selectedFiles_=(e:_*))
      res
    }
    lazy val `title` = {
      val res = Var(outer.title)
      res foreach (e => if (e != outer.title) outer.title_=(e))
      res
    }
    
  }
  
  lazy val signals = new Signals {}
  
  

}
