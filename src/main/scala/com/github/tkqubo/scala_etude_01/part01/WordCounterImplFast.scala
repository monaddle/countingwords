package com.github.tkqubo.scala_etude_01.part01

class WordCounterImplFast extends WordCounter {

  // This intends to be a fast implementation with minimal assignment.
  // It only loops through the text once, character by character,
  // and accumulates the count in a mutable hashmap.

  override def count(lines: List[String]): Map[String, Int] = {
    val counts = collection.mutable.Map.empty[String, Int].withDefaultValue(0)
    val ignoreChars = Set(' ', '\t', '\r', '\n')
    var wordBuilder = new StringBuilder()

    lines.foreach { line =>
      var prevWasWhitespace = false

      line.foreach { c =>
        if (ignoreChars.contains(c)) {
          if (!prevWasWhitespace) {
            val wordAsString = wordBuilder.mkString
            counts.update(wordAsString, counts(wordAsString) + 1)
            wordBuilder = new StringBuilder()
            prevWasWhitespace = true
          }
          // else silently discard this character
        }
        else {
          wordBuilder.append(c.toLower)
          prevWasWhitespace = false
        }
      }
      if(wordBuilder.nonEmpty) {
        val wordAsString = wordBuilder.mkString
        counts.update(wordAsString, counts(wordAsString) + 1)
        wordBuilder = new StringBuilder()
      }
    }
    counts.toMap
  }
}
