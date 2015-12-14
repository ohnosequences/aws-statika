Nice.scalaProject

name         := "aws-statika"
organization := "ohnosequences"
description  := "An EC2-based statika environment"

bucketSuffix := "era7.com"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "ohnosequences" %% "statika" 	       % "2.0.0-M4",
  "ohnosequences" %% "aws-scala-tools" % "0.16.0",
  "org.scalatest" %% "scalatest"       % "2.2.5" % Test
)
