import scala.collection.mutable.ListBuffer
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
   * Tested on integers and characters
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


  /**
   * Gets a number from the user
   * Tested for numbers and strings
   *
   * @param message The message you wish to send to the user beforehand
   * @return The number that the user entered
   */
  def takeNumber(message: String): Int = {
    var choice = -1

    while (choice < 0) {
      println(message)
      val tryChoice = Try(scala.io.StdIn.readInt())

      choice = tryChoice match {
        case Success(value) => value
        case Failure(_) =>
          println("Please only enter numbers")
          -1
      }

    }
    choice
  }


  /**
   * Gets a string from the user, trimming off trailing and leading whitespace
   * Tested on string that contain and don't contain whitespace
   *
   * @param message The message you wish to display to the user before getting the string from the user
   * @return The string that the user enters
   */
  def takeStringValue(message: String): String = {
    var choice = ""
    while (choice.isEmpty) {
      println(message)
      val tryChoice = Try(scala.io.StdIn.readLine().trim)
      choice = tryChoice match {
        case Success(value) => value
        case Failure(_) =>
          println("Please enter a valid string")
          ""
      }
    }
    choice
  }


  /**
   * Gets multiple non-empty strings from the user, trimming leading and trailing whitespace
   * Tested on strings that have and don't have leading and trailing whitespace
   *
   * @param message The message to send to the user before asking for a list of strings
   * @return The list of strings to return to the user
   */
  def takeMultipleStrings(message: String): List[String] = {
    val stringList = new ListBuffer[String]()
    var valid = false
    var choice = ""
    println(message)
    println("Leave this input blank when you are finished")

    while (!valid) {
      val tryChoice = Try(scala.io.StdIn.readLine().trim)
      choice = tryChoice match {
        case Success(value) => value
        case Failure(_) =>
          println("Please enter a valid string")
          ""
      }

      if (choice != "") {
        stringList.append(choice)
        println("Please enter another value, or leave empty to finish")
      } else {
        valid = true
      }

    }
    stringList.toList
  }

}
