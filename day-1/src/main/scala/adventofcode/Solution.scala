package adventofcode

import adventofcode.Bracket.{Close, Open}

object Solution extends App {

  val input = io.Source.stdin.mkString
  val brackets = Bracket.fromString(input)
  val floor = computeFloor(brackets)
  val basementInstructionIndex = findBasementInstructionIndex(brackets)

  println(s"Santa is on floor: $floor")
  basementInstructionIndex.foreach(f => println(s"Santa will arrive at the basement by instruction: $f"))

  def computeFloor(instructions: List[Bracket]): Int =
    accumulateFloorAndInstructionIndex(instructions)
      .toList
      .last
      ._1

  def findBasementInstructionIndex(instructions: List[Bracket]): Option[Int] =
    accumulateFloorAndInstructionIndex(instructions)
      .find { case (currentFloor, _) => currentFloor == -1 }
      .map(_._2)

  private def accumulateFloorAndInstructionIndex(instructions: List[Bracket]): Stream[(Int, Int)] =
    instructions
      .toStream
      .scanLeft((0, 0)) { case ((currentFloor, index), instruction) =>
        instruction match {
          case Open => (currentFloor + 1, index + 1)
          case Close => (currentFloor - 1, index + 1)
        }
      }
}
