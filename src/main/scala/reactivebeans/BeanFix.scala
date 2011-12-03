package reactivebeans

abstract class BeanFix(wrapper: Generator.Wrapper,
                       instance: String,
                       predicate: String,
                       hasDeps: Boolean,
                       p: Generator.Printer,
                       isProxy: Boolean) extends WrapperPart(wrapper, instance, predicate, hasDeps, p, isProxy) {
  def isDefinedAt(c: Class[_]): Boolean
}
