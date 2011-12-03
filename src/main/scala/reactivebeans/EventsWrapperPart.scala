package reactivebeans
import java.beans.MethodDescriptor

class EventsWrapperPart(wrapper: Generator.Wrapper,
                        instance: String,
                        predicate: String,
                        hasDeps: Boolean,
                        p: Generator.Printer,
                        isProxy: Boolean) extends WrapperPart(wrapper, instance, predicate, hasDeps, p, isProxy) {
  def write() {
    p.println("trait EventStreams" + (if (hasDeps) " extends super.EventStreams" else "") + " {")

    val callOnInstance = instance + "."
    p.inBlock {
      if (!hasDeps) p.println("class ESource[T] extends EventSource[T]")

      for (event <- wrapper.streams) {
        //create the object containing the streams
        val eventSetDescriptor = event.eventSetDescriptor
        val descriptors = eventSetDescriptor.getListenerMethodDescriptors
        def writeEventSource(descr: MethodDescriptor) {
          p.println("val " + descr.getName + " = new ESource[" + descr.getMethod.getParameterTypes()(0).getName + "]")
        }
        var prefix = "EventStreams.this."
        prefix = "EventStreams.this." + event.name + "."
        p.println("object " + event.name + " {")
        for (descriptor <- descriptors) {
          p inBlock writeEventSource(descriptor)
        }
        p.println("}")

        //register the listener
        p.println(callOnInstance + eventSetDescriptor.getAddListenerMethod.getName + "(new " + eventSetDescriptor.getListenerType.getName + " {")
        p.inBlock {
          for (descr <- descriptors) {
            p.print("def " + descr.getName + "(evt: " + descr.getMethod.getParameterTypes()(0).getName + ") {")
            p.printlnNP(prefix + descr.getName + ".fire(evt)}")
          }
        }; p.println("})")
      }
    }; p.println("}")
    p.println()

    //define the field events
    p.println((if (hasDeps) "override " else "") + "lazy val events = new EventStreams {}")

  }
}