package reactive.jswing

import reactive._

//This file was auto generated
trait JOptionPaneReactiveProxy extends JComponentReactiveProxy  {
  override def peer: javax.swing.JOptionPane
  private[JOptionPaneReactiveProxy] lazy val outer = peer
  trait Signals extends super.Signals {
    //helper method to treat var as signals without specifying the type
    //which might arise visibility problems (e.g.: the listeners field in scala.swing.Component
    @inline private[this] def varAsSignal[T](v: Var[T]) = v: Signal[T]
    lazy val `UI` = {
      val res = Var(outer.getUI)
      res foreach (e => if (e != outer.getUI) outer.setUI(e))
      res
    }
    lazy val `icon` = {
      val res = Var(outer.getIcon)
      res foreach (e => if (e != outer.getIcon) outer.setIcon(e))
      res
    }
    lazy val `initialSelectionValue` = {
      val res = Var(outer.getInitialSelectionValue)
      res foreach (e => if (e != outer.getInitialSelectionValue) outer.setInitialSelectionValue(e))
      res
    }
    lazy val `initialValue` = {
      val res = Var(outer.getInitialValue)
      res foreach (e => if (e != outer.getInitialValue) outer.setInitialValue(e))
      res
    }
    lazy val `inputValue` = {
      val res = Var(outer.getInputValue)
      res foreach (e => if (e != outer.getInputValue) outer.setInputValue(e))
      res
    }
    lazy val `maxCharactersPerLineCount` = varAsSignal(Var(outer.getMaxCharactersPerLineCount))
    lazy val `message` = {
      val res = Var(outer.getMessage)
      res foreach (e => if (e != outer.getMessage) outer.setMessage(e))
      res
    }
    lazy val `messageType` = {
      val res = Var(outer.getMessageType)
      res foreach (e => if (e != outer.getMessageType) outer.setMessageType(e))
      res
    }
    lazy val `optionType` = {
      val res = Var(outer.getOptionType)
      res foreach (e => if (e != outer.getOptionType) outer.setOptionType(e))
      res
    }
    lazy val `options` = {
      val res = Var(outer.getOptions)
      res foreach (e => if (e != outer.getOptions) outer.setOptions(e))
      res
    }
    lazy val `selectionValues` = {
      val res = Var(outer.getSelectionValues)
      res foreach (e => if (e != outer.getSelectionValues) outer.setSelectionValues(e))
      res
    }
    lazy val `value` = {
      val res = Var(outer.getValue)
      res foreach (e => if (e != outer.getValue) outer.setValue(e))
      res
    }
    lazy val `wantsInput` = {
      val res = Var(outer.getWantsInput)
      res foreach (e => if (e != outer.getWantsInput) outer.setWantsInput(e))
      res
    }
    
    outer.addPropertyChangeListener(new java.beans.PropertyChangeListener {
      def propertyChange(evt: java.beans.PropertyChangeEvent) {
        def assign[T](s: Signal[T], value: Any) = s match {case v: Var[_] => v.asInstanceOf[Var[T]].value = value.asInstanceOf[T]; case _ =>}
        evt.getPropertyName match {
          case "`UI`" => assign(`UI`, evt.getNewValue)
          case "`icon`" => assign(`icon`, evt.getNewValue)
          case "`initialSelectionValue`" => assign(`initialSelectionValue`, evt.getNewValue)
          case "`initialValue`" => assign(`initialValue`, evt.getNewValue)
          case "`inputValue`" => assign(`inputValue`, evt.getNewValue)
          case "`maxCharactersPerLineCount`" => assign(`maxCharactersPerLineCount`, evt.getNewValue)
          case "`message`" => assign(`message`, evt.getNewValue)
          case "`messageType`" => assign(`messageType`, evt.getNewValue)
          case "`optionType`" => assign(`optionType`, evt.getNewValue)
          case "`options`" => assign(`options`, evt.getNewValue)
          case "`selectionValues`" => assign(`selectionValues`, evt.getNewValue)
          case "`value`" => assign(`value`, evt.getNewValue)
          case "`wantsInput`" => assign(`wantsInput`, evt.getNewValue)
          case _ =>
        }
      }
    })
  }
  
  override lazy val signals = new Signals {}
  
  

}
