package reactivebeans
package defaultbeanfixes

import javax.swing.text.JTextComponent

class JTextComponentBeanFix extends BeanFix {
  def isDefinedAt(w: (Generator.Wrapper, Generator.Printer)) = classOf[JTextComponent] == w._1.peer
  def apply(w: (Generator.Wrapper, Generator.Printer)) {
    val (wrapper, p) = w
    p.println("//Fix for text property")
    p.println("getDocument().addDocumentListener (new javax.swing.event.DocumentListener {")
    p.inBlock {
      p.println("def update() = {val newValue = getText(); if (signals.text.now != newValue) signals.text() = newValue}")
      p.println("def changeUpdate(e: javax.swing.event.DocumentEvent) = update()")
      p.println("def insertUpdate(e: javax.swing.event.DocumentEvent) = update()")
      p.println("def removeUpdate(e: javax.swing.event.DocumentEvent) = update()")
    }; p.println("})")
  }
}