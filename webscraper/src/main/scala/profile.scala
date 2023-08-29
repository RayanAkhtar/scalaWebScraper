import java.io.File

object profile {

  /**
   * A menu for CRUD operations for a user profile
   */
  def menu(): Unit = {
    while (true) {
      checkForProfileCreation()

      val fileExists = new File(globals.profilePath).exists()
      if (!fileExists) return

      println(
      """
        | 1. See user profile
        | 2. Edit user profile
        | 3. Delete user profile
        | 4. Return to main menu
        |""".stripMargin)
      val choice = userInputHelpers.takeNumberRange(1, 4)

      choice match {
        case 1 =>
          println("\n")
          checkUserProfile()
        case 2 =>
          editUserProfile()
        case 3 =>
          println("\n")
          fileHandlingHelpers.deleteFile(globals.profilePath)
          println("Profile has been deleted, please enter a value to return to the main menu: ")
          scala.io.StdIn.readLine()
          return
        case 4 =>
          return
        case _ => println("Something went wrong here")
      }
    }
  }


  /**
   * A method that checks if a user currently has a profile.txt file in the userFiles folder
   */
  private def checkForProfileCreation(): Unit = {
    val fileExists = new File(globals.profilePath).exists()
    if (fileExists) return

    println("You have not created a file yet, would you like to create one now?")
    val response = userInputHelpers.takeYesOrNo()
    if (!response) return

    profileHelpers.createUserFile()
  }

  // Option 1

  /**
   * A method that shows the user their profile
   */
  private def checkUserProfile(): Unit = {
    fileHandlingHelpers.printFile(globals.profilePath)
    println("Please enter a value to go back to the main menu: ")
    scala.io.StdIn.readLine()
  }

  /**
   * A method that allows the user to edit their profile
   */
  private def editUserProfile(): Unit = {
    println()
    fileHandlingHelpers.printFile(globals.profilePath, "numbered")
    println("Enter the number of the line you wish to edit: ")
    val numberOfLines = fileHandlingHelpers.getNumberOfLines(globals.profilePath)
    val lineToChange = userInputHelpers.takeNumberRange(1, numberOfLines)

    val lineData = fileHandlingHelpers.getLine(globals.profilePath, lineToChange)
    profileHelpers.updateProfileLine(lineToChange, lineData)
  }

}
