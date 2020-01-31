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

  // Method to calculate the total number of elements in a list
  def noOfElements[Any](list: List[Any]) : Int = list match{

    case Nil => throw new NoSuchElementException // If the list is empty NoSuchElementException is thrown
    case head :: Nil => 1 // If the list contains only one element then the total number is 1
    case _ :: tail => list.length // If the list contains more than one element, the number of elements is retrieved
  }

}
