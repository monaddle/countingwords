package com.github.tkqubo.scala_etude_01.part02

import java.net.URL

trait WordFrequencyAnalyzer {
  def getTopFrequentWords(text: String): Map[String, Int]
}


