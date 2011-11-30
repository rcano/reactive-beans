name := "Generated Reactive Wrappers tester"

organization := "org.reactivebeans"


libraryDependencies <++= scalaVersion {sv => Seq(
  "org.scala-lang" % "scala-swing" % sv
)}
