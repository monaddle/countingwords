package com.github.tkqubo.scala_etude_01.part02

import java.net.URL

import org.scalatest.FunSpec

class WordFrequencyAnalyzerImplTest extends FunSpec {

  describe("WordAnalyzerImpl") {
    it("should return a word frequency ranking for Les Miserables") {

      import java.io._
      val pw = new PrintWriter(new File("results.txt" ))

      // Given
      val url = "https://www.gutenberg.org/files/135/135-0.txt"
      val target = new WordFrequencyAnalyzerImpl
      val text = io.Source.fromURL(url).mkString
      pw.write(s"impl1 time ${Timer.getAverageTime(new WordFrequencyAnalyzerImpl getTopFrequentWords text)} ns\n")
      pw.write(s"impl2 time ${Timer.getAverageTime(new WordFrequencyAnalyzerImpl2 getTopFrequentWords text)} ns\n")
      pw.write(s"impl3 time ${Timer.getAverageTime(new WordFrequencyAnalyzerImpl3 getTopFrequentWords text)} ns\n")
      pw.write(s"impl4 time ${Timer.getAverageTime(new WordFrequencyAnalyzerImpl4 getTopFrequentWords text)} ns\n")
      pw.write(s"impl4 time ${Timer.getAverageTime(new WordFrequencyAnalyzerImpl5 getTopFrequentWords text)} ns\n")
      pw.close()
    }
  }
}
