package com.gv.scala.learning.lists

import scala.annotation.tailrec

object Lists {


  @tailrec
  def last[A](list: List[A]): A = list match {

    //case List.empty[A] =>
    case Nil => throw new NoSuchElementException // empty list
    case head :: Nil => head // single element list
    case _ :: tail =>  last(tail) //  more than one element

  }

}
