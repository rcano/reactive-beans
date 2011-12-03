package reactive.jswing

import reactive._

//This file was auto generated
trait JTextAreaReactiveProxy extends JTextComponentReactiveProxy  {
  override def peer: javax.swing.JTextArea
  private[JTextAreaReactiveProxy] lazy val outer = peer
  trait Signals extends super.Signals {
    //helper method to treat var as signals without specifying the type
    //which might arise visibility problems (e.g.: the listeners field in scala.swing.Component
    @inline private[this] def varAsSignal[T](v: Var[T]) = v: Signal[T]
    lazy val `columns` = {
      val res = Var(outer.getColumns)
      res foreach (e => if (e != outer.getColumns) outer.setColumns(e))
      res
    }
    lazy val `lineCount` = varAsSignal(Var(outer.getLineCount))
    lazy val `lineWrap` = {
      val res = Var(outer.getLineWrap)
      res foreach (e => if (e != outer.getLineWrap) outer.setLineWrap(e))
      res
    }
    lazy val `rows` = {
      val res = Var(outer.getRows)
      res foreach (e => if (e != outer.getRows) outer.setRows(e))
      res
    }
    lazy val `tabSize` = {
      val res = Var(outer.getTabSize)
      res foreach (e => if (e != outer.getTabSize) outer.setTabSize(e))
      res
    }
    lazy val `wrapStyleWord` = {
      val res = Var(outer.getWrapStyleWord)
      res foreach (e => if (e != outer.getWrapStyleWord) outer.setWrapStyleWord(e))
      res
    }
    
    outer.addPropertyChangeListener(new java.beans.PropertyChangeListener {
      def propertyChange(evt: java.beans.PropertyChangeEvent) {
        def assign[T](s: Signal[T], value: Any) = s match {case v: Var[_] => v.asInstanceOf[Var[T]].value = value.asInstanceOf[T]; case _ =>}
        evt.getPropertyName match {
          case "`columns`" => assign(`columns`, evt.getNewValue)
          case "`lineCount`" => assign(`lineCount`, evt.getNewValue)
          case "`lineWrap`" => assign(`lineWrap`, evt.getNewValue)
          case "`rows`" => assign(`rows`, evt.getNewValue)
          case "`tabSize`" => assign(`tabSize`, evt.getNewValue)
          case "`wrapStyleWord`" => assign(`wrapStyleWord`, evt.getNewValue)
          case _ =>
        }
      }
    })
  }
  
  override lazy val signals = new Signals {}
  
  

}
