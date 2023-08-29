object conversionHelpers {

  def listToString(listOfStrings: List[String]): String = {
    if (listOfStrings.isEmpty) return ""

    val stringBuilder = new StringBuilder()
    listOfStrings.foreach((string: String) => stringBuilder.append(string + ", "))
    val string = stringBuilder.toString()
    string.substring(0, string.length - 2) // should get rid of ', '
  }
}
