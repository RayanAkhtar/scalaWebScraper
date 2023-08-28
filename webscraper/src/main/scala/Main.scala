object Main {
  def main(args: Array[String]): Unit = {
    println(
      """
        |Hi, Welcome to my web scraper:
        |   1. Profile settings
        |   2. Update job applications
        |   3. Search for new jobs
        |   4. Continue off job past search
        |   5. Quit
        |""".stripMargin)
    val choice = generalHelpers.takeNumberRange(1, 5)

    choice match {
      case 1 => println("Now going to profile settings") // todo implement first
      case 2 => println("Now going to job applications") // todo implement
      case 3 => println("Now going to find new jobs") // todo implement
      case 4 => println("Now going to continue off the past job search") // todo implement
      case 5 => System.exit(0);
      case _ => println("Something went wrong here")
    }


  }


}