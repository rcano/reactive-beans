/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reactivebeans

class Getops(ops: Op*) {
  def parse(options: Seq[String]): String Either (Seq[Op], Seq[String]) = {
    var it = options
    var res: Seq[Op] = Vector.empty
    for (op <- ops) {
      val tmp = op.parse(it)
      if (tmp != it) { //op found
        if (op.parse(tmp) != tmp) return Left("Option " + op + " was found twice")
        res :+= op
        it = tmp
      }
    }
    Right(res, it)
  }
}
sealed abstract class Op(val shortForm: String, val longForm: String, val descr: String) {
  /**
   * Implementation of parse should return a the original sequence less options
   * represented by this Op
   */
  def parse(options: Seq[String]): Seq[String]
  var value: String =  _
}
/**
 * Represents ops of the form -op
 */
case class ParamOp(override val shortForm: String,
                   override val longForm: String,
                   override val descr: String) extends Op(shortForm, longForm, descr) {
  def parse(options: Seq[String]) = {
    var index = options indexOf shortForm
    if (index == -1) index = options indexOf longForm
    
    index match {
      case -1 => options
      case i =>
        value = options(i + 1)
        val splitted = options.splitAt(i)
        splitted._1 ++ splitted._2.drop(2) //take out op and value
    }
  }
}
/**
 * Represents ops of the form -op
 */
case class ToggleOp(override val shortForm: String,
                    override val longForm: String,
                    override val descr: String) extends Op(shortForm, longForm, descr) {
  def parse(options: Seq[String]) = {
    var index = options indexOf shortForm
    if (index == -1) index = options indexOf longForm
    
    index match {
      case -1 => options
      case i =>
        value = options(i + 1)
        val splitted = options.splitAt(i)
        splitted._1 ++ splitted._2.drop(1) //take out op
    }
  }
}
/**
 * End of options represented by --
 */
case object EndOp extends Op("--", "--", "End of options") {
  def parse(options: Seq[String]) = {
    options indexOf "--" match {
      case -1 => options
      case i => options.splitAt(i)._2
    }
  }
}
