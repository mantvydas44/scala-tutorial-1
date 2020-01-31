package com.gv.scala.learning.lists

import org.scalatest.wordspec.AnyWordSpec

class ListsTest extends AnyWordSpec {
    "A list" when{

      "empty" should{

        "yield the last element as requested" in {

          assertResult(5)(Lists.last(List(1, 2, 3, 4, 5)))
          assertResult("a")(Lists.last(List("a", "b")))
        }

      }

    }
}
