package org.scala.learning

/**
  * Class to showcase the feature of Option Functor
  * Option returns None or Some value. i.e. the container may or may not contain a value.
  *
  * Identity law: When map is called on a Functor with identity function,
  * you get the Functor back
  * Functor[X].map(x => identity(x)) == Functor[X] (or)
  * Functor[X].map(identity) == Functor[X]
  * def identity[A](x: A): A = x
  *
  * Associative law: Let f and g be functions we want to apply on the value contained in functor.
  * Then, calling map with f and then map with g is equivalent to
  * calling map with g composed with f (g after f or g(f(x)))
  * Functor[X].map(f).map(g) == Functor[X].map(x => g(f(x))
  * def map[A, B](fa: F[A])(f: A => B): F[B]ex
  */
class OptionFunctorExample {
  /**
    * Add an Int value to an Option Functor of Int and then multiply it by another number
    * without using map
    * @param x Option Functor
    * @param y Int
    * @param m Int
    * @return
    */
  def transformOptionWOMap(x:Option[Int],
                           y:Int, m:Int): Option[Int] = {
    val res = if(x.isDefined) Some((x.get + y) * m)
    else None
    res
  }

  /**
    * Add an Int value to an Option Functor of Int and then multiply it by another number
    * using map
    * @param x Option Functor
    * @param y Int
    * @param m Int
    * @return
    */
  def transformOptionUsingMap(x:Option[Int],
                              y:Int, m:Int): Option[Int] = {
    val res = x.map(a => (a + y) * m)
    //or with the help of associative law
    val res1 = x.map(_ + y).map(_ * m)
    println(s"transform output applying function f before function g: $res1")
    println(s"functor identity output: ${x.map(identity)}")
    res
  }
}

object FunctorExampleRun {
  def main(args: Array[String]): Unit = {
    val obj = new OptionFunctorExample
    println(s"transform Option without using map: ${obj.transformOptionWOMap(Some(5), 2, 2)}")
    println(s"transform Option using map: ${obj.transformOptionUsingMap(Some(5), 2, 2)}")
  }
}

