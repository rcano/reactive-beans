package reactive.jswing

import reactive._

//This file was auto generated
trait JTextComponentReactiveProxy extends JComponentReactiveProxy  {
  override def peer: javax.swing.text.JTextComponent
  private[JTextComponentReactiveProxy] lazy val outer = peer
  trait Signals extends super.Signals {
    //helper method to treat var as signals without specifying the type
    //which might arise visibility problems (e.g.: the listeners field in scala.swing.Component
    @inline private[this] def varAsSignal[T](v: Var[T]) = v: Signal[T]
    lazy val `UI` = {
      val res = Var(outer.getUI)
      res foreach (e => if (e != outer.getUI) outer.setUI(e))
      res
    }
    lazy val `actions` = varAsSignal(Var(outer.getActions))
    lazy val `caret` = {
      val res = Var(outer.getCaret)
      res foreach (e => if (e != outer.getCaret) outer.setCaret(e))
      res
    }
    lazy val `caretColor` = {
      val res = Var(outer.getCaretColor)
      res foreach (e => if (e != outer.getCaretColor) outer.setCaretColor(e))
      res
    }
    lazy val `caretListeners` = varAsSignal(Var(outer.getCaretListeners))
    lazy val `caretPosition` = {
      val res = Var(outer.getCaretPosition)
      res foreach (e => if (e != outer.getCaretPosition) outer.setCaretPosition(e))
      res
    }
    lazy val `disabledTextColor` = {
      val res = Var(outer.getDisabledTextColor)
      res foreach (e => if (e != outer.getDisabledTextColor) outer.setDisabledTextColor(e))
      res
    }
    lazy val `document` = {
      val res = Var(outer.getDocument)
      res foreach (e => if (e != outer.getDocument) outer.setDocument(e))
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
    lazy val `focusAccelerator` = {
      val res = Var(outer.getFocusAccelerator)
      res foreach (e => if (e != outer.getFocusAccelerator) outer.setFocusAccelerator(e))
      res
    }
    lazy val `highlighter` = {
      val res = Var(outer.getHighlighter)
      res foreach (e => if (e != outer.getHighlighter) outer.setHighlighter(e))
      res
    }
    lazy val `inputMethodRequests` = varAsSignal(Var(outer.getInputMethodRequests))
    lazy val `keymap` = {
      val res = Var(outer.getKeymap)
      res foreach (e => if (e != outer.getKeymap) outer.setKeymap(e))
      res
    }
    lazy val `margin` = {
      val res = Var(outer.getMargin)
      res foreach (e => if (e != outer.getMargin) outer.setMargin(e))
      res
    }
    lazy val `navigationFilter` = {
      val res = Var(outer.getNavigationFilter)
      res foreach (e => if (e != outer.getNavigationFilter) outer.setNavigationFilter(e))
      res
    }
    lazy val `preferredScrollableViewportSize` = varAsSignal(Var(outer.getPreferredScrollableViewportSize))
    lazy val `scrollableTracksViewportHeight` = varAsSignal(Var(outer.getScrollableTracksViewportHeight))
    lazy val `scrollableTracksViewportWidth` = varAsSignal(Var(outer.getScrollableTracksViewportWidth))
    lazy val `selectedText` = varAsSignal(Var(outer.getSelectedText))
    lazy val `selectedTextColor` = {
      val res = Var(outer.getSelectedTextColor)
      res foreach (e => if (e != outer.getSelectedTextColor) outer.setSelectedTextColor(e))
      res
    }
    lazy val `selectionColor` = {
      val res = Var(outer.getSelectionColor)
      res foreach (e => if (e != outer.getSelectionColor) outer.setSelectionColor(e))
      res
    }
    lazy val `selectionEnd` = {
      val res = Var(outer.getSelectionEnd)
      res foreach (e => if (e != outer.getSelectionEnd) outer.setSelectionEnd(e))
      res
    }
    lazy val `selectionStart` = {
      val res = Var(outer.getSelectionStart)
      res foreach (e => if (e != outer.getSelectionStart) outer.setSelectionStart(e))
      res
    }
    lazy val `text` = {
      val res = Var(outer.getText)
      res foreach (e => if (e != outer.getText) outer.setText(e))
      res
    }
    
    outer.addPropertyChangeListener(new java.beans.PropertyChangeListener {
      def propertyChange(evt: java.beans.PropertyChangeEvent) {
        def assign[T](s: Signal[T], value: Any) = s match {case v: Var[_] => v.asInstanceOf[Var[T]].value = value.asInstanceOf[T]; case _ =>}
        evt.getPropertyName match {
          case "`UI`" => assign(`UI`, evt.getNewValue)
          case "`actions`" => assign(`actions`, evt.getNewValue)
          case "`caret`" => assign(`caret`, evt.getNewValue)
          case "`caretColor`" => assign(`caretColor`, evt.getNewValue)
          case "`caretListeners`" => assign(`caretListeners`, evt.getNewValue)
          case "`caretPosition`" => assign(`caretPosition`, evt.getNewValue)
          case "`disabledTextColor`" => assign(`disabledTextColor`, evt.getNewValue)
          case "`document`" => assign(`document`, evt.getNewValue)
          case "`dragEnabled`" => assign(`dragEnabled`, evt.getNewValue)
          case "`dropLocation`" => assign(`dropLocation`, evt.getNewValue)
          case "`dropMode`" => assign(`dropMode`, evt.getNewValue)
          case "`editable`" => assign(`editable`, evt.getNewValue)
          case "`focusAccelerator`" => assign(`focusAccelerator`, evt.getNewValue)
          case "`highlighter`" => assign(`highlighter`, evt.getNewValue)
          case "`inputMethodRequests`" => assign(`inputMethodRequests`, evt.getNewValue)
          case "`keymap`" => assign(`keymap`, evt.getNewValue)
          case "`margin`" => assign(`margin`, evt.getNewValue)
          case "`navigationFilter`" => assign(`navigationFilter`, evt.getNewValue)
          case "`preferredScrollableViewportSize`" => assign(`preferredScrollableViewportSize`, evt.getNewValue)
          case "`scrollableTracksViewportHeight`" => assign(`scrollableTracksViewportHeight`, evt.getNewValue)
          case "`scrollableTracksViewportWidth`" => assign(`scrollableTracksViewportWidth`, evt.getNewValue)
          case "`selectedText`" => assign(`selectedText`, evt.getNewValue)
          case "`selectedTextColor`" => assign(`selectedTextColor`, evt.getNewValue)
          case "`selectionColor`" => assign(`selectionColor`, evt.getNewValue)
          case "`selectionEnd`" => assign(`selectionEnd`, evt.getNewValue)
          case "`selectionStart`" => assign(`selectionStart`, evt.getNewValue)
          case "`text`" => assign(`text`, evt.getNewValue)
          case _ =>
        }
      }
    })
  }
  
  override lazy val signals = new Signals {}
  
  trait EventStreams extends super.EventStreams {
    object caret {
      val caretUpdate = new ESource[javax.swing.event.CaretEvent]
    }
    outer.addCaretListener(new javax.swing.event.CaretListener {
      def caretUpdate(evt: javax.swing.event.CaretEvent) {EventStreams.this.caret.caretUpdate.fire(evt)}
    })
  }
  
  override lazy val events = new EventStreams {}
  

}
