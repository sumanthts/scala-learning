package org.scala.learning

class OptionMonadExample {
  def parseInt(str: String): Option[Int] =
    scala.util.Try(str.toInt).toOption

  def divide(a: Int, b: Int): Option[Int] =
    if(b == 0) None else Some(a / b)

  def stringDivideBy(aStr: String, bStr: String): Option[Int] =
    parseInt(aStr).flatMap { aNum =>
      parseInt(bStr).flatMap { bNum =>
        divide(aNum, bNum)
      }
    }
}

object MonadExampleRun {
  def main(args: Array[String]): Unit = {
    val obj = new OptionMonadExample
    println(obj.stringDivideBy("95","5"))
    println(obj.stringDivideBy("25.5","3"))
  }
}
