package reactivebeans
package defaultbeanfixes

import javax.swing.text.JTextComponent
import javax.swing.{JComboBox, JList, JTree, JSlider, JSpinner}

class JTextComponentBeanFix extends BeanFix {
  def isDefinedAt(w: (Generator.Wrapper, Generator.Printer)) = classOf[JTextComponent] == w._1.peer
  def apply(w: (Generator.Wrapper, Generator.Printer)) {
    val (wrapper, p) = w
    p.println("//Fix for text property")
    p.println("getDocument().addDocumentListener (new javax.swing.event.DocumentListener {")
    p.inBlock {
      p.println("def update() = {val newValue = getText(); if (signals.text.now != newValue) signals.text() = newValue}")
      p.println("def changedUpdate(e: javax.swing.event.DocumentEvent) = update()")
      p.println("def insertUpdate(e: javax.swing.event.DocumentEvent) = update()")
      p.println("def removeUpdate(e: javax.swing.event.DocumentEvent) = update()")
    }; p.println("})")
  }
}

class JComboBoxBeanFix extends BeanFix {
  def isDefinedAt(w: (Generator.Wrapper, Generator.Printer)) = classOf[JComboBox] == w._1.peer
  def apply(w: (Generator.Wrapper, Generator.Printer)) {
    val (wrapper, p) = w
    p.println("//Fix for the properties related to items")
    p.println("events.item.itemStateChanged foreach {e =>"); p.inBlock {
      p.println("signals.selectedItem() = getSelectedItem()")
      p.println("signals.selectedIndex() = getSelectedIndex()")
    }; p.println("}")
  }
}
class JListBeanFix extends BeanFix {
  def isDefinedAt(w: (Generator.Wrapper, Generator.Printer)) = classOf[JList] == w._1.peer
  def apply(w: (Generator.Wrapper, Generator.Printer)) {
    val (wrapper, p) = w
    p.println("//Fix for the properties related to indices")
    p.println("events.listSelection.valueChanged foreach {e =>"); p.inBlock {
      p.println("signals.selectedIndex() = getSelectedIndex()")
      p.println("signals.selectedIndices() = getSelectedIndices()")
    }; p.println("}")
  }
}
class JTreeBeanFix extends BeanFix {
  def isDefinedAt(w: (Generator.Wrapper, Generator.Printer)) = classOf[JTree] == w._1.peer
  def apply(w: (Generator.Wrapper, Generator.Printer)) {
    val (wrapper, p) = w
    p.println("//Fix for the properties related to paths")
    p.println("events.treeSelection.valueChanged foreach {e =>"); p.inBlock {
      p.println("signals.selectionPath() = getSelectionPath()")
      p.println("signals.selectionPaths() = getSelectionPaths()")
    }; p.println("}")
  }
}
class JSliderAndJSpinnerBeanFix extends BeanFix {
  def isDefinedAt(w: (Generator.Wrapper, Generator.Printer)) = classOf[JSlider] == w._1.peer || classOf[JSpinner] == w._1.peer
  def apply(w: (Generator.Wrapper, Generator.Printer)) {
    val (wrapper, p) = w
    p.println("//Fix for value property")
    p.println("events.change.stateChanged foreach {e =>"); p.inBlock {
      p.println("signals.value() = getValue()")
    }; p.println("}")
  }
}
