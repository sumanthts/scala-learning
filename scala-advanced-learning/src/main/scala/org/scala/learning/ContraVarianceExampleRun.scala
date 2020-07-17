package org.scala.learning

/**
  * A type parameter T of a generic class can be made contravariant by using the annotation -T.
  * For some class Printer[-T], making T contravariant implies that for two types A and B
  * where A is a subtype of B, class Printer[A] is a supertype of Printer[B].
  * @tparam A
  */
class Printer1[-A]

object ContraVarianceExampleRun {
  /**
    * Now, the printAnimals method takes Printer[Dog] as an input, so,
    * if Printer knows how to print a dog then it can also know how to print an animal,
    * making Printer class contravariant allows us to do so.
    * @param animal
    */
  def printAnimals(animal: Printer1[Dog]): Unit = {
    println("prints animal")
  }

  def main(args: Array[String]): Unit = {
    printAnimals(new Printer1[Dog])
    printAnimals(new Printer1[Animal])
  }
}
