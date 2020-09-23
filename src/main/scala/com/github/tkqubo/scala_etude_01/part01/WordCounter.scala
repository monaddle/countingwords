package com.github.tkqubo.scala_etude_01.part01

trait WordCounter {
  def count(lines: List[String]): Map[String, Int]
}
