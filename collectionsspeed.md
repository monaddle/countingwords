# Comparing Collections Performance in Scala
###### In this post I profile 7 implementations of a function to count the frequency of words from an arbitrary text file.

 Recently I had a take-home interview assignment where I was supposed to implement a function to count the frequency of words in a piece of text. Because I was writing code to try to impress other people, I ended up engaging with the dizzying number of how ways there are to implement something that in Scala. They weren't impressed enough to give me the job, but it did leave me tolerably interesting fodder for a blog post: it got me inspired to write a number of reasonable implementations and see, in practice, what kind of speed differences you can squeeze out of different approaches.

So let's say the problem is this: we want to know the frequency of words are in some arbitrary text file on the internet. We want some implementations of a function like this:

```scala
type UrlString = String

def getWordFrequency: UrlString => Map[String, Int] = { url =>
  ???
}
```

Conceptually this can be broken down into two tasks:

1. Tokenizing the text into words
2. counting the frequency of each word



### Implementation 1 - fully naive

Our first implementation is a naive approach: We 

1. map over the list and run each line through a tokenizer yielding an `Array` of words, then
2. count each word by running foldLeft over this list and collecting their frequency in a `Map[String, Int]`.

```scala
// Shared tokenizer function
def tokenize(text: String): Array[String] = {
text
  .toLowerCase
  .replaceAll("[^\\p{L}]", " ")
  .split("\\s")
  .filterNot(_ == "")
}

// Naive implementation:
def getWordFrequency(lines: List[String]): Map[String, Int] = {
lines
  .flatMap(tokenize)
  .foldLeft(Map.empty[String, Int].withDefaultValue(0)) {
    case (counts, word) => counts.updated(word, counts(word) + 1)
  }
}
```



### Implementation 2 - `parArray`
First, let's just use `.par` to perform the tokenizing in parallel:

```scala
def count(lines: List[String]): Map[String, Int] = {
lines
  .toParArray
  .flatMap(tokenize)
  .foldLeft(Map.empty[String, Int].withDefaultValue(0)) {
    case (counts, word) => counts.updated(word, counts(word) + 1)
  }
}
```

We manage to increase the speed here, but it's an unsatisfying  speed up because we're just throwing more computational cycles at it, when it would be much better to reduce the number of computations necessary.


### Implementation 3 - `mutable.Map`
Let's change the way we're doing the counting. Instead of using an immutable map to collect the counts, let's use a mutable map:

```scala
def count(lines: List[String]): Map[String, Int] = {
    val mutable = collection.mutable.Map.empty[String, Int].withDefaultValue(0)
    
    lines
      .flatMap(tokenize)
      .foreach { word =>
        mutable.update(word, mutable(word) + 1)
      }
    mutable.toMap
}
```

This yields a comparable speed up to the `parArray`. We could, of course, combine them:

### Implementation 4 - `parArray` and `mutable.Map`
```scala
def count(lines: List[String]): Map[String, Int] = {
    val mutable = collection.mutable.Map.empty[String, Int].withDefaultValue(0)
    
    lines
      .toParArray
      .flatMap(tokenize)
      .foreach { word =>
        mutable.update(word, mutable(word) + 1)
      }
    mutable.toMap
}
```
