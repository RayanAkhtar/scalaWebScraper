import java.io.File
import scala.io.Source

object fileHandlingHelpers {
  // todo test
  def deleteFile(path: String): Unit = {
    println("Are you sure that you want to do this?")
    val confirmation = userInputHelpers.takeYesOrNo()
    if (!confirmation) return
    new File(path).delete()
    println("Profile has been deleted, please enter a value to return to the main menu: ")
  }

  def printFile(path: String): Unit = {
    val fileSource = Source.fromFile(path)
    val fileReader = fileSource.getLines()
    while (fileReader.hasNext) {
      println(fileReader.next())
    }
    fileSource.close()
  }
}
