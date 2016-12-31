package adventofcode

object Solution extends App {

  val secret = "ckczppom"

  val adventCoin1 = mine("00000")
  println(s"AdventCoin 1: $adventCoin1")

  val adventCoin2 = mine("000000")
  println(s"AdventCoin 2: $adventCoin2")

  def mine(s: String): (String, Int) =
    Stream
      .from(0)
      .map(n => (Md5.md5(secret + n), n))
      .find(_._1.startsWith(s))
      .get
}

object Md5 {

  import java.security.MessageDigest
  import org.apache.commons.codec.binary.Hex.encodeHexString

  private val digest = MessageDigest.getInstance("MD5")

  def md5(s: String): String =
    encodeHexString(digest.digest(s.getBytes))
}
