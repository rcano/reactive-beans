package reactivebeans

import scala.util.parsing.combinator.Parsers

/**
 * Parsing combinator implementatino of a GetOps.
 */
object GetOps extends Parsers {
  type Elem = String
  
  class Reader(seq: Seq[Elem]) extends Input {
    private[GetOps] object Position extends util.parsing.input.Position {
      val line = 0
      val column = 0
      def lineContents = first
    }
    val pos = Position
    def atEnd = seq.isEmpty
    def first = seq.head
    def rest = new Reader(seq.drop(1))
  }
  
  def parse(options: Seq[String], validOptions: CmdOp*): ParseResult[List[CmdOp#Instance]~List[ArgumentOp.Instance]] = {
    val validOptionsParser = validOptions.reduceLeft[Parser[ValidInput#Instance]](_ | _)
    (options indexOf "--" match {
        case -1 =>
          rep(validOptionsParser)~rep(ArgumentOp) apply new Reader(options)
        case i =>
          val parts = options splitAt i
          rep(validOptionsParser)(new Reader(parts._1)) match {
            case s@Success(res, rest) => 
              if (rest.atEnd) {
//              println("Sub result: " + s)
                (success(res)~rep(ArgumentOp)).apply(new Reader(parts._2.tail))
              } else Error(lastNoSuccess.msg, rest)
            case r@NoSuccess(res, rest) => r
          }
      }).asInstanceOf[ParseResult[List[CmdOp#Instance]~List[ArgumentOp.Instance]]]
  }

  sealed trait ValidInput {
    def descr: String
    trait Instance {
      val input = ValidInput.this
      
      override def equals(that: Any) = {
        println("wejfsldkfjldskfjsñlitjñsdlkjglkj")
        that.asInstanceOf[AnyRef].getClass == getClass && (that match {
            case vi: ValidInput#Instance => vi.input == input
            case _ => false
          })
      }
    }
    abstract class InstanceCompanion[T <: Instance : ClassManifest, Res] {
      def value(t: T): Res
      def unapply(i: ValidInput#Instance) = {
        if (i.getClass == classManifest[T].erasure && i.input == ValidInput.this) Some(value(i.asInstanceOf[T]))
        else None
      }
    }
  }
  sealed abstract class CmdOp(shortForm: String, longForm: String) extends Parser[ValidInput#Instance] with ValidInput {
    def descr = shortForm + " " + longForm
    def apply(input: Input): ParseResult[ValidInput#Instance] = {
      if (input.atEnd) return Failure("no more input", input)
      val text = input.first
      
      val continue = (text.startsWith("--") && text.drop(2).matches(longForm)) || 
      (text.startsWith("-") && text.drop(1).matches(shortForm))
      
      if (continue) process(input.rest)
      else Failure(text + " is not a valid option", input)
    }
    def process(input: Input): ParseResult[ValidInput#Instance]
  }
  final case class ParamOp(shortForm: String,
                           longForm: String,
                           inputValidator: String => Option[String] = s => None) extends CmdOp(shortForm, longForm) {
    class Instance(val value: String) extends super.Instance {
      override def toString = "ParamOp(" + longForm + "=" + value + ")"
    }
    object Instance extends InstanceCompanion[Instance, String] {
      def value(i: Instance) = i.value
    }
    def process(input: Input) = {
      if (input.atEnd) error("Value expected for param " + longForm)
      else {
        val value = input.first
        inputValidator(value) match {
          case Some(errMsg) => error("Wrong argument for option " + longForm + ": " + errMsg)
          case None => Success(new Instance(value), input.rest)
        }
      }
    }
  }
  final case class ToggleOp(shortForm: String, longForm: String) extends CmdOp(shortForm, longForm) {
    case object Instance extends InstanceCompanion[Instance, Unit] with super.Instance {
      def value(i: Instance): Unit = {}
      override def toString = "ToggleOp(" + longForm + ")"
    }
    def process(input: Input) = Success(Instance, input)
  }
  final object ArgumentOp extends Parser[ValidInput#Instance] with ValidInput {
    def descr = "Arg"
    case class Instance(value: String) extends super.Instance
    def apply(input: Input) = {
      if (input.atEnd) Failure("no more input", input)
      else Success(Instance(input.first), input.rest)
    }
  }
}
