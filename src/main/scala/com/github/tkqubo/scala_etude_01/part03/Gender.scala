package com.github.tkqubo.scala_etude_01.part03

sealed trait Gender

object Gender {
  case object Male extends Gender
  case object Female extends Gender
}
