name := "Generated Reactive Wrappers tester"

organization := "org.reactivebeans"

resolvers += "Sonatype snapshots" at "http://oss.sonatype.org/content/repositories/snapshots"

libraryDependencies <++= scalaVersion {sv => Seq(
  "org.scala-lang" % "scala-swing" % sv,
  "cc.co.scala-reactive" %% "reactive-core" % "0.2-SNAPSHOT"
)}

