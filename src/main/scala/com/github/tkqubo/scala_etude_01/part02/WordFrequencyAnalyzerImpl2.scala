package com.github.tkqubo.scala_etude_01.part02

import java.net.URL

import com.github.tkqubo.scala_etude_01.part01.{Tokenizer, WordCounterImpl, WordCounterImplFast, WordCounterImplImmutableParallel}

import scala.io.Source

// Depending on the context that you were using this,
// you might care about encodings and content-types.
// This is a deceptively simple task because the
// test is wrong, although you figure that out pretty quickly.

class WordFrequencyAnalyzerImpl2 extends WordFrequencyAnalyzer {
  override def getTopFrequentWords(text: String): Map[String, Int] = {
    val counter = new WordCounterImplImmutableParallel

    //val lines = Source.fromURL(url).getLines.toList

    counter
      .count(text.linesIterator.toList)
  }
}
