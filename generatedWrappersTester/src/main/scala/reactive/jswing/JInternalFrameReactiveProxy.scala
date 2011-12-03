package reactive.jswing

import reactive._

//This file was auto generated
trait JInternalFrameReactiveProxy extends JComponentReactiveProxy  {
  override def peer: javax.swing.JInternalFrame
  private[JInternalFrameReactiveProxy] lazy val outer = peer
  trait Signals extends super.Signals {
    //helper method to treat var as signals without specifying the type
    //which might arise visibility problems (e.g.: the listeners field in scala.swing.Component
    @inline private[this] def varAsSignal[T](v: Var[T]) = v: Signal[T]
    lazy val `JMenuBar` = {
      val res = Var(outer.getJMenuBar)
      res foreach (e => if (e != outer.getJMenuBar) outer.setJMenuBar(e))
      res
    }
    lazy val `UI` = {
      val res = Var(outer.getUI)
      res foreach (e => if (e != outer.getUI) outer.setUI(e))
      res
    }
    lazy val `closable` = {
      val res = Var(outer.isClosable)
      res foreach (e => if (e != outer.isClosable) outer.setClosable(e))
      res
    }
    lazy val `closed` = {
      val res = Var(outer.isClosed())
      res foreach (e => if (e != outer.isClosed()) outer.setClosed(e))
      res
    }
    lazy val `contentPane` = {
      val res = Var(outer.getContentPane)
      res foreach (e => if (e != outer.getContentPane) outer.setContentPane(e))
      res
    }
    lazy val `defaultCloseOperation` = {
      val res = Var(outer.getDefaultCloseOperation)
      res foreach (e => if (e != outer.getDefaultCloseOperation) outer.setDefaultCloseOperation(e))
      res
    }
    lazy val `desktopIcon` = {
      val res = Var(outer.getDesktopIcon)
      res foreach (e => if (e != outer.getDesktopIcon) outer.setDesktopIcon(e))
      res
    }
    lazy val `desktopPane` = varAsSignal(Var(outer.getDesktopPane))
    lazy val `focusCycleRootAncestor` = varAsSignal(Var(outer.getFocusCycleRootAncestor))
    lazy val `focusOwner` = varAsSignal(Var(outer.getFocusOwner))
    lazy val `frameIcon` = {
      val res = Var(outer.getFrameIcon)
      res foreach (e => if (e != outer.getFrameIcon) outer.setFrameIcon(e))
      res
    }
    lazy val `glassPane` = {
      val res = Var(outer.getGlassPane)
      res foreach (e => if (e != outer.getGlassPane) outer.setGlassPane(e))
      res
    }
    lazy val `icon` = {
      val res = Var(outer.isIcon())
      res foreach (e => if (e != outer.isIcon()) outer.setIcon(e))
      res
    }
    lazy val `iconifiable` = {
      val res = Var(outer.isIconifiable)
      res foreach (e => if (e != outer.isIconifiable) outer.setIconifiable(e))
      res
    }
    lazy val `internalFrameListeners` = varAsSignal(Var(outer.getInternalFrameListeners))
    lazy val `lastCursor` = varAsSignal(Var(outer.getLastCursor))
    lazy val `layer` = {
      val res = Var(outer.getLayer)
      res foreach (e => if (e != outer.getLayer) outer.setLayer(e))
      res
    }
    lazy val `layeredPane` = {
      val res = Var(outer.getLayeredPane)
      res foreach (e => if (e != outer.getLayeredPane) outer.setLayeredPane(e))
      res
    }
    lazy val `maximizable` = {
      val res = Var(outer.isMaximizable)
      res foreach (e => if (e != outer.isMaximizable) outer.setMaximizable(e))
      res
    }
    lazy val `maximum` = {
      val res = Var(outer.isMaximum())
      res foreach (e => if (e != outer.isMaximum()) outer.setMaximum(e))
      res
    }
    lazy val `menuBar` = {
      val res = Var(outer.getMenuBar)
      res foreach (e => if (e != outer.getMenuBar) outer.setMenuBar(e))
      res
    }
    lazy val `mostRecentFocusOwner` = varAsSignal(Var(outer.getMostRecentFocusOwner))
    lazy val `normalBounds` = {
      val res = Var(outer.getNormalBounds)
      res foreach (e => if (e != outer.getNormalBounds) outer.setNormalBounds(e))
      res
    }
    lazy val `resizable` = {
      val res = Var(outer.isResizable)
      res foreach (e => if (e != outer.isResizable) outer.setResizable(e))
      res
    }
    lazy val `selected` = {
      val res = Var(outer.isSelected())
      res foreach (e => if (e != outer.isSelected()) outer.setSelected(e))
      res
    }
    lazy val `title` = {
      val res = Var(outer.getTitle)
      res foreach (e => if (e != outer.getTitle) outer.setTitle(e))
      res
    }
    lazy val `warningString` = varAsSignal(Var(outer.getWarningString))
    
    outer.addPropertyChangeListener(new java.beans.PropertyChangeListener {
      def propertyChange(evt: java.beans.PropertyChangeEvent) {
        def assign[T](s: Signal[T], value: Any) = s match {case v: Var[_] => v.asInstanceOf[Var[T]].value = value.asInstanceOf[T]; case _ =>}
        evt.getPropertyName match {
          case "`JMenuBar`" => assign(`JMenuBar`, evt.getNewValue)
          case "`UI`" => assign(`UI`, evt.getNewValue)
          case "`closable`" => assign(`closable`, evt.getNewValue)
          case "`closed`" => assign(`closed`, evt.getNewValue)
          case "`contentPane`" => assign(`contentPane`, evt.getNewValue)
          case "`defaultCloseOperation`" => assign(`defaultCloseOperation`, evt.getNewValue)
          case "`desktopIcon`" => assign(`desktopIcon`, evt.getNewValue)
          case "`desktopPane`" => assign(`desktopPane`, evt.getNewValue)
          case "`focusCycleRootAncestor`" => assign(`focusCycleRootAncestor`, evt.getNewValue)
          case "`focusOwner`" => assign(`focusOwner`, evt.getNewValue)
          case "`frameIcon`" => assign(`frameIcon`, evt.getNewValue)
          case "`glassPane`" => assign(`glassPane`, evt.getNewValue)
          case "`icon`" => assign(`icon`, evt.getNewValue)
          case "`iconifiable`" => assign(`iconifiable`, evt.getNewValue)
          case "`internalFrameListeners`" => assign(`internalFrameListeners`, evt.getNewValue)
          case "`lastCursor`" => assign(`lastCursor`, evt.getNewValue)
          case "`layer`" => assign(`layer`, evt.getNewValue)
          case "`layeredPane`" => assign(`layeredPane`, evt.getNewValue)
          case "`maximizable`" => assign(`maximizable`, evt.getNewValue)
          case "`maximum`" => assign(`maximum`, evt.getNewValue)
          case "`menuBar`" => assign(`menuBar`, evt.getNewValue)
          case "`mostRecentFocusOwner`" => assign(`mostRecentFocusOwner`, evt.getNewValue)
          case "`normalBounds`" => assign(`normalBounds`, evt.getNewValue)
          case "`resizable`" => assign(`resizable`, evt.getNewValue)
          case "`selected`" => assign(`selected`, evt.getNewValue)
          case "`title`" => assign(`title`, evt.getNewValue)
          case "`warningString`" => assign(`warningString`, evt.getNewValue)
          case _ =>
        }
      }
    })
  }
  
  override lazy val signals = new Signals {}
  
  trait EventStreams extends super.EventStreams {
    object internalFrame {
      val internalFrameClosed = new ESource[javax.swing.event.InternalFrameEvent]
      val internalFrameIconified = new ESource[javax.swing.event.InternalFrameEvent]
      val internalFrameDeiconified = new ESource[javax.swing.event.InternalFrameEvent]
      val internalFrameActivated = new ESource[javax.swing.event.InternalFrameEvent]
      val internalFrameDeactivated = new ESource[javax.swing.event.InternalFrameEvent]
      val internalFrameOpened = new ESource[javax.swing.event.InternalFrameEvent]
      val internalFrameClosing = new ESource[javax.swing.event.InternalFrameEvent]
    }
    outer.addInternalFrameListener(new javax.swing.event.InternalFrameListener {
      def internalFrameClosed(evt: javax.swing.event.InternalFrameEvent) {EventStreams.this.internalFrame.internalFrameClosed.fire(evt)}
      def internalFrameIconified(evt: javax.swing.event.InternalFrameEvent) {EventStreams.this.internalFrame.internalFrameIconified.fire(evt)}
      def internalFrameDeiconified(evt: javax.swing.event.InternalFrameEvent) {EventStreams.this.internalFrame.internalFrameDeiconified.fire(evt)}
      def internalFrameActivated(evt: javax.swing.event.InternalFrameEvent) {EventStreams.this.internalFrame.internalFrameActivated.fire(evt)}
      def internalFrameDeactivated(evt: javax.swing.event.InternalFrameEvent) {EventStreams.this.internalFrame.internalFrameDeactivated.fire(evt)}
      def internalFrameOpened(evt: javax.swing.event.InternalFrameEvent) {EventStreams.this.internalFrame.internalFrameOpened.fire(evt)}
      def internalFrameClosing(evt: javax.swing.event.InternalFrameEvent) {EventStreams.this.internalFrame.internalFrameClosing.fire(evt)}
    })
  }
  
  override lazy val events = new EventStreams {}
  

}
