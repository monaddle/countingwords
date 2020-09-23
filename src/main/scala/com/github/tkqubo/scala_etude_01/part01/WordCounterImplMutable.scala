package com.github.tkqubo.scala_etude_01.part01

class WordCounterImplMutable extends WordCounter {

  // This is a a middle ground between the `Fast` implementation
  // and the `Immutable` implementation. It's not a pure function
  // because it instantiates and mutates an instance of `collections.mutable.Map`.
  // However, the function doesn't mutate state elsewhere,
  // so the function itself represent a pure interface.
  // The functional purist in me dislikes this on principle,
  // but the rest of me recognizes that this kind of compromise is
  // represents pragmatic Scala at its best.

  override def count(lines: List[String]): Map[String, Int] = {
    val mutable = collection.mutable.Map.empty[String, Int].withDefaultValue(0)

    lines
      .flatMap(Tokenizer.tokenize)
      .foreach { word =>
        mutable.update(word, mutable(word) + 1)
      }
    mutable.toMap
  }
}
