import java.io.{File, PrintWriter}


object profileHelpers {

  private def writeYesOrNo(): String = if (userInputHelpers.takeYesOrNo()) "yes" else "no"


  private val fieldNameQuestionType: Map[String, String] = Map(
    ("City", "string"),
    ("Year of Study", "int-range"),
    ("Interested in", "multi-string"),
    ("Search terms", "multi-string"),
    ("Entry Level Only", "boolean"),
    ("Part-time", "boolean"),
    ("Full-time", "boolean"),
    ("Internships", "boolean"),
    ("Placements", "boolean"),
    ("Minimum Salary", "int")
  ) // question type will be treated similarly to an enum

  /**
   * A method to create a new user file, this is called whenever the profile menu notices that the user doesn't have a profile
   */
  def createUserFile(): Unit = {

    val userProfile = new File(globals.profilePath)
    val fileWriter = new PrintWriter(userProfile)

    // 1. users city
    fileWriter.write("City: " + userInputHelpers.takeStringValue("Please enter your City:") + "\n")

    // 2. University year
    println("Please enter your current year of university")
    fileWriter.write("Year of Study: " + userInputHelpers.takeNumberRange(1, 4) + "\n")

    // 3. Fields of work (stored as a list to help find all kinds of jobs)
    val fieldOfWork = userInputHelpers.takeMultipleStrings("Please enter the fields of work you are interested in:")
    fileWriter.write("Interested in: " + conversionHelpers.listToString(fieldOfWork) + "\n")

    // Also other search terms that may help find relevant jobs that may be under different names
    val descriptions = userInputHelpers.takeMultipleStrings("Please enter some terms that you would like to see in the job description and skills required:")
    fileWriter.write("Search terms: " + conversionHelpers.listToString(descriptions) + "\n")


    // 4. Entry or non-entry level
    println("Are you only looking for entry level jobs?")
    fileWriter.write("Entry Level Only: " + writeYesOrNo() + "\n")

    // 5. Hours to look for (ft, pt, internship, placement, remote)
    println("Are you looking for part-time work?")
    fileWriter.write("Part-time: " + writeYesOrNo() + "\n")

    println("Are you looking for full-time work?")
    fileWriter.write("Full-time: " + writeYesOrNo() + "\n")

    // 6. looking for internships and placements
    println("Are you looking for internships?")
    fileWriter.write("Internships: " + writeYesOrNo() + "\n")

    println("Are you looking for Placements?")
    fileWriter.write("Placements: " + writeYesOrNo() + "\n")

    // 6. lower bound of salary
    fileWriter.write("Minimum Salary: " + userInputHelpers.takeNumber("Please enter the lowest salary you are looking for: ") + "\n")
    fileWriter.close()

  }

  /**
   * Updates a given line in a user's profile
   *
   * @param lineToChange The line number that you wish to change
   * @param lineData The new value that you want for that line
   */
  def updateProfileLine(lineToChange: Int, lineData: String): Unit = {
    val indexToSplit = lineData.indexOf(':')
    val fieldName = lineData.substring(0, indexToSplit)
    val maybeQuestionType = fieldNameQuestionType.get(fieldName)
    val questionType = maybeQuestionType.get
    val updatedValue = getUpdatedValue(questionType)
    fileHandlingHelpers.updateLine(globals.profilePath, lineToChange, s"$fieldName: $updatedValue")
    println("The file has been updated, enter any value to exit")
    scala.io.StdIn.readLine()
  }


  /**
   * Asks the new user to enter a new value for the question type provided
   *
   * @param questionType The question to ask the user
   * @return The value that the user enters for that question
   */
  private def getUpdatedValue(questionType: String): String = {
    questionType match {
      case "string" => userInputHelpers.takeStringValue("Please enter a new value: ")
      case "int-range" => userInputHelpers.takeNumberRange(1, 4).toString
      case "int" => userInputHelpers.takeNumber("Please enter a new number: ").toString
      case "multi-string" => conversionHelpers.listToString(userInputHelpers.takeMultipleStrings("Please enter a new set of values: "))
      case "boolean" => writeYesOrNo()
    }
  }



}
