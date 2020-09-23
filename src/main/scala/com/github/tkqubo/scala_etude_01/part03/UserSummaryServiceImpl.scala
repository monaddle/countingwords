package com.github.tkqubo.scala_etude_01.part03
import java.net.URL

import org.json4s._
import org.json4s.native.JsonMethods

import scala.io.{Codec, Source}



class UserSummaryServiceImpl extends UserSummaryService {
  import DefaultReaders._
  override def summarize(url: URL): Seq[UserSummary] = {
    val content = Source
      .fromURL(url)
      .mkString

    val results = (JsonMethods.parse(content) \ "results").as[Seq[Either[String, UserSummary]]]

    val issues = results.collect { case Left(error) => error}

    if(issues.nonEmpty) {
      issues.foreach(println)
    }

    results.collect { case Right(summary) => summary}
  }
}

