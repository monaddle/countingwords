package com.github.tkqubo.scala_etude_01.part03

import java.net.URL

import com.github.tkqubo.scala_etude_01.part03.Gender.{Female, Male}
import org.json4s._
import cats.implicits._
import cats.syntax.either._
case class UserSummary(
  username: String,
  email: String,
  nationality: String,
  gender: Gender,
  thumbnail: URL
)

object UserSummary {
  import DefaultReaders._
  implicit def reads: Reader[Either[String, UserSummary]] = new Reader[Either[String, UserSummary]] {

    override def read(value: JValue): Either[String, UserSummary] = {
      // This is an okay but not great implementation. It's
      // computationally a little wasteful with the "getAs"
      // returning an option and then converting that to an Either.
      // Also using this many monads and for comprehensions in a parser
      // (which is ideally very fast) doesn't scream "best practices".
      // It would also be nice if it didn't short-circuit on the first issue
      // with the JSON - it would be better if it tried each field
      // and then returned a list of all of the issues at once
      // to make it easier to debug. It doesn't look like json4s
      // really supports that, although I'm not super familiar with
      // the library.

      // Ideally there'd be a much more general and DRY way to construct arbitrary parsers
      // that also let you know when there were parse issues, and certainly
      // other libraries (e.g. PlayJSON) seem to go a lot farther.



      val userSummary = for {
        gender <- (value \ "gender").getAs[String].toRight("No gender found").right
        fname <- (value \ "name" \ "first" ).getAs[String].toRight("No first name found.").right
        lname <- (value \ "name" \ "last" ).getAs[String].toRight("No last name found.").right
        email <- (value \ "email").getAs[String].toRight("No email found.").right
        nationality <- (value \ "nat").getAs[String].toRight("No nationality found.").right
        thumbnail <- (value \ "picture" \ "thumbnail").getAs[String].toRight("No thumbnail found.").right
      } yield {
        val g = if(gender == "male") Male else Female

        UserSummary(
          s"${fname.capitalize} ${lname.capitalize}",
          email,
          nationality,
          g,
          new URL(thumbnail))
      }


      userSummary.leftMap(_ + s" in ${value.toString}")
    }
  }
}