package reactivebeans
package defaultbeanfixes

import javax.swing.text.JTextComponent
import javax.swing.{ JComboBox, JList, JTree, JSlider, JSpinner }

class JTextComponentBeanFix(wrapper: Generator.Wrapper,
                            instance: String,
                            predicate: String,
                            hasDeps: Boolean,
                            p: Generator.Printer) extends BeanFix(wrapper, instance, predicate, hasDeps, p) {
  def isDefinedAt(w: Class[_]) = classOf[JTextComponent] == w
  def write() {
    p.println("//Fix for text property")
    p.println(instance + ".getDocument().addDocumentListener (new javax.swing.event.DocumentListener {")
    p.inBlock {
      p.println("def update() = {val newValue = " + instance + ".getText(); if (signals.text.now != newValue) signals.text() = newValue}")
      p.println("def changedUpdate(e: javax.swing.event.DocumentEvent) = update()")
      p.println("def insertUpdate(e: javax.swing.event.DocumentEvent) = update()")
      p.println("def removeUpdate(e: javax.swing.event.DocumentEvent) = update()")
    }; p.println("})")
  }
}

class JComboBoxBeanFix(wrapper: Generator.Wrapper,
                       instance: String,
                       predicate: String,
                       hasDeps: Boolean,
                       p: Generator.Printer) extends BeanFix(wrapper, instance, predicate, hasDeps, p) {
  def isDefinedAt(w: Class[_]) = classOf[JComboBox] == w
  def write() {
    p.println("//Fix for the properties related to items")
    p.println("events.item.itemStateChanged foreach {e =>"); p.inBlock {
      p.println("signals.selectedItem() = " + instance + ".getSelectedItem()")
      p.println("signals.selectedIndex() = " + instance + ".getSelectedIndex()")
    }; p.println("}")
  }
}
class JListBeanFix(wrapper: Generator.Wrapper,
                   instance: String,
                   predicate: String,
                   hasDeps: Boolean,
                   p: Generator.Printer) extends BeanFix(wrapper, instance, predicate, hasDeps, p) {
  def isDefinedAt(w: Class[_]) = classOf[JList] == w
  def write() {
    p.println("//Fix for the properties related to indices")
    p.println("events.listSelection.valueChanged foreach {e =>"); p.inBlock {
      p.println("signals.selectedIndex() = " + instance + ".getSelectedIndex()")
      p.println("signals.selectedIndices() = " + instance + ".getSelectedIndices()")
    }; p.println("}")
  }
}
class JTreeBeanFix(wrapper: Generator.Wrapper,
                   instance: String,
                   predicate: String,
                   hasDeps: Boolean,
                   p: Generator.Printer) extends BeanFix(wrapper, instance, predicate, hasDeps, p) {
  def isDefinedAt(w: Class[_]) = classOf[JTree] == w
  def write() {
    p.println("//Fix for the properties related to paths")
    p.println("events.treeSelection.valueChanged foreach {e =>"); p.inBlock {
      p.println("signals.selectionPath() = " + instance + ".getSelectionPath()")
      p.println("signals.selectionPaths() = " + instance + ".getSelectionPaths()")
    }; p.println("}")
  }
}
class JSliderAndJSpinnerBeanFix(wrapper: Generator.Wrapper,
                                instance: String,
                                predicate: String,
                                hasDeps: Boolean,
                                p: Generator.Printer) extends BeanFix(wrapper, instance, predicate, hasDeps, p) {
  def isDefinedAt(w: Class[_]) = classOf[JSlider] == w || classOf[JSpinner] == w
  def write() {
    p.println("//Fix for value property")
    p.println("events.change.stateChanged foreach {e =>"); p.inBlock {
      p.println("signals.value() = " + instance + ".getValue()")
    }; p.println("}")
  }
}
