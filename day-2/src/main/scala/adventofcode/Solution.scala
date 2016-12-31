package adventofcode

object Solution extends App {

  val input = io.Source.stdin.getLines().toList
  val boxes = Box.fromStrings(input)

  val totalWrappingPaper =
    boxes
      .map(box => box.surfaceArea + box.faces.min)
      .sum

  val totalRibbon = (for {
    box    <- boxes
    ribbon = box.dimensions.sorted.take(2).map(_ * 2).sum
    bow    = box.volume
  } yield ribbon + bow).sum

  println(s"The Elves should order: $totalWrappingPaper square feet of wrapping paper.")
  println(s"The Elves should order: $totalRibbon feet of ribbon.")
}
