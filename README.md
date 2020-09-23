# Scala Étude

## About

- This repository contains some small tasks to evaluate your Scala skill.
- You have to implement some classes to make `sbt test` pass. 
- No framework nor library knowledge is required to solve them
    - Except a bit of understanding of [json4s](https://github.com/json4s/json4s) and [ScalaTest](http://www.scalatest.org/)
    - Even without it, you can go through anyway

## Tasks

### 1 Word Counter

You have to implement a service class with a method that:

- takes a list of Strings (`List[String]`)
- returns a word-occurrence map (`Map[String, Int]`)
- ignoring word cases

For example,

```scala
import com.github.tkqubo.scala_etude_01.part01._
val counter = new WordCounterImpl()
counter.count(List("a test  this", "This was a", "THIS")) ==
   Map("a" -> 2, "test" -> 1, "this" -> 3, "was" -> 1)
```
  
Interface is defined as a trait [`WordCounter`](https://github.com/tkqubo/scala-etude-01/blob/master/src/main/scala/com/github/tkqubo/scala_etude_01/part01/WordCounter.scala).
All you need is to write implementation of [`WordCounterImpl`](https://github.com/tkqubo/scala-etude-01/blob/master/src/main/scala/com/github/tkqubo/scala_etude_01/part01/WordCounterImpl.scala)
 and make [`WordCounterImplTest`](https://github.com/tkqubo/scala-etude-01/blob/master/src/test/scala/com/github/tkqubo/scala_etude_01/part01/WordCounterImplTest.scala) pass.

### 2 Word frequency analyzer

You have to implement a service class with a method which:

- takes a file location (`URL`) and limit (`Int`)
- returns a word frequency ranking (`List[(String, Int)]`)
- in descending order of frequency
- but only top N words where N is specified by "limit"

For example,

```scala
import java.net.URL
import com.github.tkqubo.scala_etude_01.part02._
val analyzer = new WordFrequencyAnalyzerImpl()
// Say we have a file "foo.txt"
analyzer.getTopFrequentWords(new URL("file:///some/file/foo.txt"), 3) ==
    List("the" -> 548, "a" -> "391", "of" -> 324)
```

Interface is defined as a trait [`WordFrequencyAnalyzer`](https://github.com/tkqubo/scala-etude-01/blob/master/src/main/scala/com/github/tkqubo/scala_etude_01/part02/WordFrequencyAnalyzer.scala).
All you need is to write implementation of [`WordFrequencyAnalyzerImpl`](https://github.com/tkqubo/scala-etude-01/blob/master/src/main/scala/com/github/tkqubo/scala_etude_01/part02/WordFrequencyAnalyzerImpl.scala)
 and make [`WordFrequencyAnalyzerImplTest`](https://github.com/tkqubo/scala-etude-01/blob/master/src/test/scala/com/github/tkqubo/scala_etude_01/part02/WordFrequencyAnalyzerImplTest.scala) pass.

### 3 User profile summarizer

See [Random User Generator](https://randomuser.me/).
After understanding the usage of the API, you have to create a service class with a method which:

- takes the API endpoint or a file which contains a JSON payload with the similar API data structure
- returns a list of "summarized" version of the user information (`List[UserSummary]`)
    - `UserSummary#username` is a concatenation of the first name and the last name, both being capitalized

For example,

```scala
import java.net.URL
import com.github.tkqubo.scala_etude_01.part03._
val service = new UserSummaryServiceImpl()

// Say we have a file "foo.json"
service.summarize(new URL("file:///some/file/foo.json")) ==
    List(UserSummary("Paul Simon", "some@example.com", "US", Gender.Male, new URL("http://thumbnail.jpg")))

service.summarize(new URL("https://randomuser.me/api/?results=1")) ==
    List(UserSummary("Paul Simon", "some@example.com", "US", Gender.Male, new URL("http://thumbnail.jpg")))
```    

Interface is defined as a trait [`UserSummaryService`](https://github.com/tkqubo/scala-etude-01/blob/master/src/main/scala/com/github/tkqubo/scala_etude_01/part03/UserSummaryService.scala).
All you need is to write implementation of [`UserSummaryServiceImpl`](https://github.com/tkqubo/scala-etude-01/blob/master/src/main/scala/com/github/tkqubo/scala_etude_01/part03/UserSummaryServiceImpl.scala),
 make [`UserSummarySummaryServiceImplTest`](https://github.com/tkqubo/scala-etude-01/blob/master/src/test/scala/com/github/tkqubo/scala_etude_01/part03/UserSummarySummaryServiceImplTest.scala) pass,
 and run [`UserSummarySummaryServiceImplTest`](https://github.com/tkqubo/scala-etude-01/blob/master/src/test/scala/com/github/tkqubo/scala_etude_01/part03/UserSummarySummaryServiceImplTest.scala#L126-L130) successfully.
