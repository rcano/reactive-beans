name := "Reactive Beans"

organization := "org.reactivebeans"

version := "1.1"

libraryDependencies <++= scalaVersion {sv => Seq(
  "org.scala-lang" % "scala-swing" % sv,
  "org.scala-lang" % "scalap" % sv
)}

fork := true
