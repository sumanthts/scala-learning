package org.scala.learning

class Animal
class Dog extends Animal

/**
  * A type parameter T of a generic class can be made covariant by using the annotation +T.
  * For some class Printer[+T], making T covariant which implies that for two types A and B
  * where A is a supertype of B, class Printer[A] is a supertype of Printer[B].
  * This allows us to make very useful and intuitive subtyping relationships using generics.
  * @tparam T
  */
class Printer[+T]

/**
  * https://blog.knoldus.com/back2basics-demystifying-variance/
  */
object CoVarianceExampleRun {

  /**
    * Now, the printAnimals method takes Printer[Animal] as an input, so,
    * if Printer knows how to print an animal then
    * it should also know how to print a dog as a dog is itself an animal,
    * making Printer class covariant class allows us to do so.
    * @param animal
    */
  def printAnimals(animal: Printer[Animal]): Unit = {
    println("prints animal")
  }

  def main(args: Array[String]): Unit = {
    printAnimals(new Printer[Animal])
    printAnimals(new Printer[Dog])
  }
}
