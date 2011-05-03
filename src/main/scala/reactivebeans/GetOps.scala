package reactivebeans

import scala.util.parsing.combinator.Parsers
import scala.util.parsing.input.NoPosition

object GetOps extends Parsers {
  type Elem = String
  
  class Reader(seq: Seq[Elem]) extends Input {
    def atEnd = seq.isEmpty
    def first = seq.head
    val pos = NoPosition
    def rest = new Reader(seq.tail)
  }
  
//  private var optionsHardFail = false
  def parse(options: Seq[String], validOptions: Option*): ParseResult[List[Option#Instance]~List[ArgumentOp.Instance]] = {
    val validOptionsParser = validOptions.reduceLeft[Parser[ValidInput#Instance]](_ | _)
    val parser = options indexOf "--" match {
      case -1 =>
//        optionsHardFail = false
        rep(validOptionsParser)~rep(ArgumentOp)
      case i =>
//        optionsHardFail = true
        val parts = options splitAt i
        repN(parts._1.length, validOptionsParser)~("--"~>rep(ArgumentOp))
    }
    parser(new Reader(options)).asInstanceOf[ParseResult[List[Option#Instance]~List[ArgumentOp.Instance]]] //the lazy way
  }

  sealed trait ValidInput {
    def descr: String
    trait Instance {
      val op = ValidInput.this
    }
  }
  sealed abstract class Option(shortForm: String, longForm: String) extends Parser[ValidInput#Instance] with ValidInput {
    def descr = shortForm + " " + longForm
    def apply(input: Input): ParseResult[ValidInput#Instance] = {
      if (input.atEnd) return Failure("no more input", input)
      val text = input.first
      val continue = (text.startsWith("--") && text.drop(2).matches(longForm)) || 
      (text.startsWith("-") && text.drop(1).matches(shortForm))
      if (continue) {
        val rest = input.rest
        this match {
          case paramOp: ParamOp => Success(paramOp.Instance(rest.first), rest.rest)
          case toggleOp: ToggleOp => Success(toggleOp.Instance, rest)
        }
      } else {
        Failure(text + " is not a valid option", input)
      }
    }
  }
  final case class ParamOp(shortForm: String, longForm: String) extends Option(shortForm, longForm) {
    case class Instance(value: String) extends super.Instance {
      override def toString = "ParamOp(" + longForm + "=" + value + ")"
    }
  }
  final case class ToggleOp(shortForm: String, longForm: String) extends Option(shortForm, longForm) {
    case object Instance extends super.Instance {
      override def toString = "ToggleOp(" + longForm + ")"
    }
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
