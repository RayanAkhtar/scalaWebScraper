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
      case 1 => println("Now going to see user profile") // todo implement first
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

    //todo have code here to create a file


  }

}
