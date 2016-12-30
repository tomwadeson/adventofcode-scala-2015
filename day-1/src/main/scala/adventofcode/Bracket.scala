package adventofcode

sealed trait Bracket

object Bracket {

  case object Open extends Bracket

  case object Close extends Bracket

  def apply(char: Char): Option[Bracket] = char match {
    case '(' => Some(Open)
    case ')' => Some(Close)
    case _ => None
  }

  def fromString(str: String): List[Bracket] =
    str.flatMap(apply).toList
}
