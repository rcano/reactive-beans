import sbt._, Keys._

object Build extends sbt.Build {
  lazy val reactivebeans = Project("reactivebeans", file(".")) settings(generateWrappersSettings)
  lazy val generatedWrappersTester = Project("generatedWrappersTester", file("generatedWrappersTester"))


  val generateWrappers = TaskKey[Unit]("generate-wrappers", "Generates wrappers into the test project")
  val generateWrappersSettings = generateWrappers <<= (fullClasspath in Compile, mainClass in Compile, runner in run, streams) map {(cp, mc, runner, s) =>
    if (mc.isEmpty) throw new IllegalStateException("No main-class defined")
    s.log.info("Class path is: " + (cp map (_.data)))
    runner.run(mc.get, cp map (_.data), Seq("-pn", "reactive.jswing",
      "-bd", "generatedWrappersTester/src/main/scala/reactive/jswing",
      "--bean-fixes", "defaultbeanfixes.*", "javax.swing.*"), s.log)
    runner.run(mc.get, cp map (_.data), Seq("-pn", "reactive.sswing",
      "-bd", "generatedWrappersTester/src/main/scala/reactive/sswing",
      "--bean-fixes", "defaultbeanfixes.*", "scala.swing.*"), s.log)
  }
}
