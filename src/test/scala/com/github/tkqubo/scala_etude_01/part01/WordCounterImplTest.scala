package com.github.tkqubo.scala_etude_01.part01

import org.scalatest._

class WordCounterImplTest extends FunSpec {
  describe("WordCounterImpl") {
    it("should count fruits") {
      // Given
      val words = List("apple banana", "orange   apple mango", "kiwi papaya orange", "mango orange muscat apple")
      val target = new WordCounterImpl
      val expected = Map(
        "banana" -> 1,
        "muscat" -> 1,
        "orange" -> 3,
        "mango" -> 2,
        "apple" -> 3,
        "kiwi" -> 1,
        "papaya" -> 1
      )

      // When
      val actual = target.count(words)
      // Then
      assert(actual === expected)
    }

  }
}
