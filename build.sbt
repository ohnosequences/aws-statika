name         := "aws-statika"
organization := "ohnosequences"
description  := "An EC2-based statika environment"

bucketSuffix := "era7.com"

crossScalaVersions := Seq("2.11.11", "2.12.3")
scalaVersion  := crossScalaVersions.value.last

libraryDependencies ++= Seq(
  "ohnosequences" %% "statika" 	       % "3.0.0",
  "ohnosequences" %% "aws-scala-tools" % "0.19.0",
  "org.scalatest" %% "scalatest"       % "3.0.4" % Test
)
