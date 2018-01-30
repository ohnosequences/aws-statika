name         := "aws-statika"
organization := "ohnosequences"
description  := "An EC2-based statika environment"

bucketSuffix := "era7.com"

crossScalaVersions := Seq("2.11.12", "2.12.4")
scalaVersion  := crossScalaVersions.value.last

libraryDependencies ++= Seq(
  "ohnosequences" %% "statika" 	       % "3.0.0",
  "ohnosequences" %% "aws-scala-tools" % "0.21.0",
  "org.scalatest" %% "scalatest"       % "3.0.4" % Test
)
