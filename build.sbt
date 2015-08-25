Nice.scalaProject

name         := "aws-statika"
organization := "ohnosequences"
description  := "An EC2-based statika environment"

bucketSuffix := "era7.com"

scalaVersion := "2.11.7"
crossScalaVersions := Seq("2.10.5", scalaVersion.value)


libraryDependencies ++= Seq(
  "ohnosequences" %% "statika" 	       % "2.0.0-new-instructions-SNAPSHOT",
  "ohnosequences" %% "aws-scala-tools" % "0.13.2",
  "org.scalatest" %% "scalatest"       % "2.2.5"     % Test
)

dependencyOverrides += "org.scala-lang.modules" %% "scala-xml" % "1.0.4"
