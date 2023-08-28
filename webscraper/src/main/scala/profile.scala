import java.io.File

class profile {

  def main(args: Array[String]): Unit = {

    checkForProfileCreation()

    println(
      """
        | 1. See user profile
        | 2. Edit user profile
        | 3. Delete user profile
        | 4. Return to main menu
        |""".stripMargin)
    val choice = generalHelpers.takeNumberRange(1, 4)

    choice match {
      case 1 => println("Now going to see user profile") // todo implement
      case 2 => println("Now going edit user profile") // todo implement
      case 3 => println("Now going to delete user profile") // todo implement
      case 4 => return // redundant return but better off clarifying
      case _ => println("Something went wrong here")
    }
  }


  private def checkForProfileCreation(): Unit = {
    val file = new File("/../userFiles/profile.txt").exists()
    if (file) return

    println("You have not created a file yet, would you like to create one now?")
    val response = generalHelpers.takeYesOrNo()
    if (!response) return

    createUserFile()
  }


  def createUserFile(): Unit = {
    // 1. users city
    val city = generalHelpers.takeStringValue("Please enter your City:")

    // 2. University year
    val uniYear = generalHelpers.takeNumberRange(1, 4)

    // 3. Fields of work (stored as a list to help find all kinds of jobs)
    val fieldOfWork = generalHelpers.takeMultipleStrings("Please enter the fields of work you are interested in:")

    // 4. Entry or non-entry level
    println("Are you only looking for entry level jobs?")
    val isEntryLevel = generalHelpers.takeYesOrNo()

    // 5. Hours to look for (ft, pt, internship, placement, remote)
    println("Are you looking for full-time work?")
    val isFullTime = generalHelpers.takeYesOrNo()

    // 6. looking for internships or placements
    println("Are you looking for internships and placements?")
    val takesInternships = generalHelpers.takeYesOrNo()

    // 6. lower bound of salary
    val minSalary = generalHelpers.takeNumber("Please enter the lowest salary you are looking for: ")

  }

}
