package com.gv.scala.learning.lists

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Any
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

    "contains more than one element" should {
      "return the total number of elements in list" in {

        assertResult(3)(Lists.noOfElements(List('a', 'b', 'c' )))

      }


    }

    "completely empty" should {

      "show total as 0" in {

        assertResult(0)(Lists.noOfElements(List()))

      }

    }
  }

  "Palindrome list" when{

    "contains nothing " should{

      "be true if empty" in{

        assertResult(true)(Lists.palindrome(Nil))
      }


    }

    "contains a single element" should{

      "return true" in {

        assertResult(true)(Lists.palindrome(List(1)))


      }

    }

    "contains many elements but the list is not palindrome" should{


      "return false" in {

        assertResult(false)(Lists.palindrome(List(1,2,3,4)))

      }

    }

    "contains elements and is palindrome" should{

      "return true" in{
        assertResult(true)(Lists.palindrome(List(1,2,3,4,3,2,1)))
        assertResult(false)(Lists.palindrome(List(1,2,3,4,3,7,1)))

      }
    }


  }

 "Flatten list" when{

   "the list is flattened into two" should{

     "return a result of a single list of any type" in {


       assertResult(List(1,2,3,4,5,6))(Lists.flatten(List(List(1), 2, List(3, 4, 5, 6))))

     }

   }
   "the list is empty" should{

     "should return nil" in{

       assertResult(Nil)(Lists.flatten(List()))
     }

   }

 }

  "A list of symbols" when {
    "full" should {
      "return a packed list" in {
        assertResult(
          List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))
        )(
          Lists.pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
        )
      }
    }
    "empty" should {
      "return an empty list" in {
        assert(Lists.pack(List()).isEmpty)
      }
    }
  }
}


