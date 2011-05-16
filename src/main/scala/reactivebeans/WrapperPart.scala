package reactivebeans

abstract class WrapperPart(protected val wrapper: Generator.Wrapper,
                           protected val instance: String,
                           protected val predicate: String,
                           protected val hasDeps: Boolean,
                           protected val p: Generator.Printer) {

  def write()
}