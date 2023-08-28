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
    var choice = -1
    while (true) {
      println(s"Please enter a number between $lowerBound and $upperBound:")

      val tryChoice = Try(scala.io.StdIn.readInt())
      choice = tryChoice match {
        case Success(value) => value
        case Failure(_) =>
          println("Please only enter an integer")
          -1
      }
      if (choice >= lowerBound && choice <= upperBound) return choice
    }
    choice
  }

  /**
   * Gets a response from the user when asking for a yes/no question
   *
   * @return returns whether the user said yes or no to the decision
   */
  def takeYesOrNo(): Boolean = {
    while (true) {
      println("Please enter [Y]es or [N]o: ")
      val tryChoice = Try(scala.io.StdIn.readLine().trim)

      val choice = tryChoice match {
        case Success(value) => if (value.nonEmpty) value.charAt(0) else 'z'
        case Failure(_) => 'z'
      }

      if (choice == 'y') return true
      else if (choice == 'n') return false
    }
    false
  }

}
