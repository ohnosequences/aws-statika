Nice.scalaProject

name         := "aws-statika"
organization := "ohnosequences"
description  := "An EC2-based statika environment"

bucketSuffix := "era7.com"

libraryDependencies ++= Seq(
  "ohnosequences" %% "statika" 	       % "2.0.0-M1",
  "ohnosequences" %% "aws-scala-tools" % "0.12.0",
  "org.scalatest" %% "scalatest"       % "2.2.4"     % Test
)
