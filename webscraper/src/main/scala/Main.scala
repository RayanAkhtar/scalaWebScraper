object Main {
  def main(args: Array[String]): Unit = {
    while (true) {
      println(
      """
        |Hi, Welcome to my web scraper:
        |   1. Profile settings (currently doing)
        |   2. Update job applications (todo)
        |   3. Search for new jobs (todo)
        |   4. Continue off job past search (todo)
        |   5. Quit
        |""".stripMargin)
      val choice = userInputHelpers.takeNumberRange(1, 5)

      choice match {
        case 1 =>
          println("Now going to profile settings")
          profile.menu()
          // todo implementing
        case 2 => println("Now going to job applications") // todo implement
        case 3 => println("Now going to find new jobs") // todo implement
        case 4 => println("Now going to continue off the past job search") // todo implement
        case 5 => System.exit(0);
        case _ => println("Something went wrong here")
      }
    }
  }


}