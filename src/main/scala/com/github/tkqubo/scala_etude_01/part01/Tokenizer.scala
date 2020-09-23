package com.github.tkqubo.scala_etude_01.part01

object Tokenizer {
  def tokenize(text: String): Array[String] = {
    text
      .toLowerCase
      .replaceAll("[^\\p{L}]", " ")
      .split("\\s")
      .filterNot(_ == "")
  }
}
