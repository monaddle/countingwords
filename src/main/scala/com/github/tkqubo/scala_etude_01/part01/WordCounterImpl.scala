package com.github.tkqubo.scala_etude_01.part01

class WordCounterImpl extends WordCounter {

  // I've done five different implementations of this, in an
  // effort to illustrate how I reason about implementation trade-offs.
  // I don't usually implement every task fives ways, scout's honor.
  //
  // This is the first implementation I wrote, and I like it
  // in particular because it's purely functional, relatively fast
  // and eminently readable. It certainly isn't the most
  // efficient implementation (both the "Mutable" and "Fast"
  // implementations have better performance properties),
  // but it faithfully illustrates the style/approach to which I tend to default.

  override def count(lines: List[String]): Map[String, Int] = {
    lines
      .flatMap(Tokenizer.tokenize)
      .foldRight(Map.empty[String, Int].withDefaultValue(0)) {
        case (word, counts) => counts.updated(word, counts(word) + 1)
      }
  }
}





