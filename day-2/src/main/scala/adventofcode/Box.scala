package adventofcode

case class Box(length: Int, width: Int, height: Int) {

  val faces: Seq[Int] =
    Seq(length * width, width * height, height * length)

  val dimensions: Seq[Int] =
    Seq(length, width, height)

  val surfaceArea: Int =
    faces.map(_ * 2).sum

  val volume: Int =
    length * width * height
}

object Box {

  private val Pattern = """^(\d+)x(\d+)x(\d+)$""".r

  def apply(s: String): Option[Box] = s.trim match {
    case Pattern(length, width, height) =>
      Some(Box(length.toInt, width.toInt, height.toInt))
    case _ =>
      None
  }

  def fromStrings(ss: List[String]): List[Box] =
    ss.flatMap(s => apply(s))
}
