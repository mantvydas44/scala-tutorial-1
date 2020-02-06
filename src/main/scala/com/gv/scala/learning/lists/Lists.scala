package com.gv.scala.learning.lists

import java.util.NoSuchElementException

import scala.annotation.tailrec


object Lists {


  @tailrec
  def last[A](list: List[A]): A = list match {

    //case List.empty[A] =>
    case Nil => throw new NoSuchElementException // empty list
    case head :: Nil => head // single element list
    case _ :: tail => last(tail) //  more than one element

  }

  // Method to calculate the total number of elements in a list
  def noOfElements[Any](list: List[Any]): Int = list match {

    case Nil => 0 // If the list is empty NoSuchElementException is thrown
    case head :: tail => 1 + noOfElements(tail) // The list contains more than one element and so the method is called again recursively

  }

  // Palindrome method
  def palindrome[Int](list: List[Int]): Boolean = list match {

    case Nil => true

    case head :: Nil => true

    case list => (list.head == list.last && palindrome(list.tail.init))

  }

  /** Flattens a possibly nested list
   *
   * @param list possibly nested list, with elements of any type
   * @return a flat list, with all elements of the nested argument in the same order.
   *
   * */
  def flatten[Any](list: List[Any]): List[Any] = list match {

    case Nil => Nil
    case (h: List[Any]) :: tail => flatten(h) ::: flatten(tail)
    case h :: tail => h :: flatten(tail)

  }

  /** Packs the list into sublists of duplicate values
   *
   * @param list with elements
   * @return list with sublists of duplicate values
   *
   */
  def pack[A](list: List[A]): List[List[A]] = {

    @tailrec
    def pack2(independentList: List[A], packedList: List[List[A]], list2: List[A]): List[List[A]] = list2 match{

      case Nil => packedList

      case x :: Nil if (x != independentList.last) =>  packedList ::: List(List(x))

      case x :: Nil => packedList ::: List(independentList :+ x)

      case x :: xs if(x == xs.head) => pack2(independentList :+ x, packedList, xs )

      case head :: tail => pack2(List(), packedList ::: List(independentList :+ head), tail)

    }
    pack2(List(), List(), list)
  }
}