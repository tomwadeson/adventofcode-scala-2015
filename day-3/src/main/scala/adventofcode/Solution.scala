package adventofcode

import adventofcode.Direction._

object Solution extends App {

  val input = io.Source.stdin.mkString
  val directions = Direction.fromString(input)

  // Part 1: Pre Robo-Santa
  val visited = housesVisitedByFollowingDirections(directions).size
  println(s"Santa visited $visited unique houses.")

  // Part 2: With Robo-Santa
  val santasDirections = directions.zipWithIndex.filter(_._2 % 2 == 0).map(_._1)
  val visitedBySanta = housesVisitedByFollowingDirections(santasDirections)

  val roboSantasDirections = directions.zipWithIndex.filter(_._2 % 2 == 1).map(_._1)
  val visitedByRoboSanta = housesVisitedByFollowingDirections(roboSantasDirections)

  val visitedBySantaAndRoboSanta = (visitedBySanta union visitedByRoboSanta).size
  println(s"Together, Santa and Robo-Santa visted $visitedBySantaAndRoboSanta unique houess.")

  def housesVisitedByFollowingDirections(ds: List[Direction]): Set[Location] = {
    val startLocation = Location(0, 0)
    ds
      .foldLeft((Set(startLocation), startLocation)) {
        case ((visited, location), direction) =>
          val nextLocation = location.follow(direction)
          (visited + nextLocation, nextLocation)
      }
      ._1
  }
}

case class Location(x: Int, y: Int) {
  def follow(d: Direction): Location = d match {
    case Up => copy(y = y + 1)
    case Down => copy(y = y - 1)
    case Left => copy(x = x - 1)
    case Right => copy(x = x + 1)
  }
}

sealed trait Direction

object Direction {

  case object Up extends Direction

  case object Down extends Direction

  case object Left extends Direction

  case object Right extends Direction

  def apply(c: Char): Option[Direction] = c match {
    case '^' => Some(Up)
    case 'v' => Some(Down)
    case '<' => Some(Left)
    case '>' => Some(Right)
    case _ => None
  }

  def fromString(s: String): List[Direction] =
    s.flatMap(apply).toList
}
