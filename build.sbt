name := "scala-etude-01"

version := "0.1"

scalaVersion := "2.13.3"

val json4s = "3.5.5"
val scalaTest = "3.0.8"

libraryDependencies ++= Seq(
  "org.json4s" %% "json4s-native" % json4s,
  "org.scalatest" %% "scalatest" % scalaTest % Test,
)

// https://mvnrepository.com/artifact/org.typelevel/cats-core
libraryDependencies += "org.typelevel" %% "cats-core" % "2.0.0"

libraryDependencies += "org.scala-lang.modules" %% "scala-parallel-collections" % "0.2.0"
