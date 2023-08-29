import java.io.{File, PrintWriter}
import scala.io.Source

object fileHandlingHelpers {

  /**
   * Deleted a file based on the provided path
   *
   * @param path The path to the file
   * @param option Setting this to forced will forcefully delete the file without asking for permission via the console
   */
  def deleteFile(path: String, option: String = ""): Unit = {

    if (option != "forced") {
      println("Are you sure that you want to do this?")
      val confirmation = userInputHelpers.takeYesOrNo()
      if (!confirmation) return
    }

    new File(path).delete()
  }

  /**
   * Prints the contents of a file onto the scala console
   *
   * @param path The path to the file
   * @param typeOfPrint The way you want it print, currently there is only a numbered option, but may change later
   */
  def printFile(path: String, typeOfPrint: String = ""): Unit = {
    val fileSource = Source.fromFile(path)
    val fileReader = fileSource.getLines()
    var count = 1
    while (fileReader.hasNext) {
      if (typeOfPrint == "numbered") {
        print(s"$count) ")
        count += 1
      }
      println(fileReader.next())
    }
    println()
    fileSource.close()
  }

  /**
   * Gets the number of lines for a given file if it exists on the path
   *
   * @param path The path to the file
   * @return The number of lines in that file
   */
  def getNumberOfLines(path: String): Int = {
    val sourceFile = Source.fromFile(path)
    try {
      sourceFile.getLines().size
    } finally {
      sourceFile.close()
    }
  }

  /**
   * Gets a given line from a file
   *
   * @param path The path to the file
   * @param lineNumber The line number you wish to get
   * @return The line data at position 'lineNumber' in the file specified by 'path'
   */
  def getLine(path: String, lineNumber: Int): String = {
    val sourceFile = Source.fromFile(path)
    val lineToReturn = sourceFile.getLines().toList(lineNumber - 1)
    sourceFile.close()
    lineToReturn
  }

  /**
   * Updated the file specified by 'path', changing the line at 'lineToChange' to 'updatedLine'
   *
   * @param path The path to the file
   * @param lineToChange The line number to change
   * @param updatedLine The new value of that line
   */
  def updateLine(path: String, lineToChange: Int, updatedLine: String): Unit = {
    val sourceFile = Source.fromFile(path)
    val prevVal = getLine(path, lineToChange)
    val newLines = sourceFile.getLines().map((line: String) => if (line.contains(prevVal)) updatedLine else line)
    deleteFile(path, "forced")
    createFile(path, newLines)
  }

  /**
   * Creates a file at the path specified by 'path' and writes 'newLines' to that path
   *
   * @param path The path to create the file in
   * @param newLines The lines to write to that file
   */
  def createFile(path: String, newLines: Iterator[Any]): Unit = {
    val sourceFile = new File(path)
    val fileWriter = new PrintWriter(sourceFile)

    while (newLines.hasNext) {
      fileWriter.write(newLines.next().toString + "\n")
    }
    fileWriter.close()

  }

}
