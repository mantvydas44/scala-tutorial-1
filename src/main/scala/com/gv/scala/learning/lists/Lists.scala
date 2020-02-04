package com.gv.scala.learning.lists

import java.util.NoSuchElementException

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

    case Nil => 0// If the list is empty NoSuchElementException is thrown
    case head :: tail => 1 + noOfElements(tail) // The list contains more than one element and so the method is called again recursively
  }

  // Palindrome method
  def palindrome[Int](list: List[Int]) : Boolean = list match {

    case Nil => true

    case head :: Nil => true

    case list => (list.head == list.last && palindrome(list.tail.init))

  }

 def flatten[Any](list: List[Any]): List[Any] = list match{

   case Nil => Nil
   case (h:List[Any])::tail => flatten(h):::flatten(tail)
   case h::tail => h::flatten(tail)

    }




}