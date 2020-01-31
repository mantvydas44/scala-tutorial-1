package com.gv.scala.learning.lists

import org.scalatest.wordspec.AnyWordSpec

class ListsTest extends AnyWordSpec {
  "A list" when {
    "contains a single element" should {
      "return its element as the last element" in {

        assertResult('b')(Lists.last('b' :: Nil))

      }


    }
    "not empty" should {

      "yield the last element as requested" in {

        assertResult(5)(Lists.last(List(1, 2, 3, 4, 5)))
        assertResult("b")(Lists.last(List("a", "b")))

      }

    }

    "empty" should {

      "throw a NoSuchElementException when the last element is requested" in {

        assertThrows[NoSuchElementException](Lists.last(List()))

      }

    }
  }

  "A list" when {
    "contains a single element" should {
      "return a total of 1 element only" in {

        assertResult(1)(Lists.noOfElements(List('b')))

      }


    }
    "contains more than one element" should {
      "return the total number of elements in list" in {

        assertResult(3)(Lists.noOfElements(List('a', 'b', 'c' )))

      }


    }

    "completely empty" should {

      "throw a NoSuchElementException when the last element is requested" in {

        assertThrows[NoSuchElementException](Lists.noOfElements(List()))

      }

    }




  }
}
