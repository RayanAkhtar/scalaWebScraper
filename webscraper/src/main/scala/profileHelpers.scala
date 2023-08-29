import java.io.{File, PrintWriter}

object profileHelpers {

  def createUserFile(): Unit = {
    def writeYesOrNo(): String = if (userInputHelpers.takeYesOrNo()) "yes" else "no"

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



}
