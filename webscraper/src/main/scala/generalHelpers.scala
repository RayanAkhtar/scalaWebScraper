import scala.util.{Failure, Success, Try}

object generalHelpers extends App {

  /**
   * Gets an integer value between two integer numbers
   * Tested on integers, letters and floats
   *
   * @param lowerBound The lower bound of the range
   * @param upperBound The upper bound of the range
   * @return Returns the number once an appropriate value has been entered
   */
  def takeNumberRange(lowerBound: Int, upperBound: Int): Int = {
    var valid = false
    var choice = -1
    while (!valid) {
      println(s"Please enter a number between $lowerBound and $upperBound:")

      val tryChoice = Try(scala.io.StdIn.readInt())
      choice = tryChoice match {
        case Success(value) => value
        case Failure(_) =>
          println("Please only enter an integer")
          -1
      }
      valid = choice >= lowerBound && choice <= upperBound

    }
    choice
  }


}
