package com.github.tkqubo.scala_etude_01.part01

object WordCounterImplMonoidal {

  trait Monoid[A] {
    def combine(a: A, b: A): A
    def zero: A
  }


  object Monoid {
    implicit def apply[A](implicit m: Monoid[A]): Monoid[A] = m


    implicit def mapMonoid[K]: Monoid[Map[K, Int]] = new Monoid[Map[K, Int]] {
      override def combine(a: Map[K, Int], b: Map[K, Int]): Map[K, Int] = {
        a.foldLeft(b.withDefaultValue[Int](0)) { case (carry, (k, v)) =>

          carry.updated(k, carry(k)+ v)
        }
      }
      override def zero: Map[K, Int] = Map.empty[K, Int]
    }

  }
}

// This categorically should not be done with anything
// that doesn't require a lot of computation. This is
// very slow because of all of the extra assignment
// that is incurred by the implicits, as well as by the strategy
// of accumulating each single value in a map and then adding
// them together. A tuple and a map is created for every single
// occurence of a word.

// It's not clear to me there's ever a situation in which
// this is the best implementation, but it's still worth
// consideration because for map reduce to be correct
// Instead of adding integers together here, we could
// be recombining e.g. individual pages of a document that
// we've OCR'd and done physical document analysis on.
// Those pages would need to be monoidal, even we
// weren't using the Monoid typeclass.

class WordCounterImplMonoidal extends WordCounter {
  import WordCounterImplMonoidal._
  override def count(lines: List[String]): Map[String, Int] = {
    val mapMonoid2 = implicitly[Monoid[Map[String, Int]]]

    lines
      .flatMap { line =>
        Tokenizer.tokenize(line)
          .map { word => Map(word -> 1) }
      }
      .reduce(mapMonoid2.combine)
  }
}