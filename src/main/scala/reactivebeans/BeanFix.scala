package reactivebeans

abstract class BeanFix(wrapper: Generator.Wrapper,
                       instance: String,
                       predicate: String,
                       hasDeps: Boolean,
                       p: Generator.Printer) extends WrapperPart(wrapper, instance, predicate, hasDeps, p) {
  def isDefinedAt(c: Class[_]): Boolean
}
