package com.github.tkqubo.scala_etude_01.part01

import scala.collection.parallel.CollectionConverters._
class WordCounterImplImmutableParallel extends WordCounter {

  // This takes the same wall clock time as WordCounterImplMutable, with
  // the downside of requiring more CPU time. If I needed speed
  // I'd just move to the WordCounterImplMutable implementation.
  override def count(lines: List[String]): Map[String, Int] = {
    lines
      .par
      .flatMap(Tokenizer.tokenize)
      .foldLeft(Map.empty[String, Int].withDefaultValue(0)) {
        case (counts, word) => counts.updated(word, counts(word) + 1)
      }
  }
}

