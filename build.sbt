Nice.scalaProject

name := "aws-statika"
organization := "ohnosequences"
description := "aws-statika project"

bucketSuffix := "era7.com"

libraryDependencies ++= Seq(
  "ohnosequences" %% "statika" % "2.0.0-SNAPSHOT",
  "ohnosequences" %% "aws-scala-tools" % "0.12.0",
  "org.scalatest" %% "scalatest" % "2.2.4" % Test
)
