import sbt._, Keys._

object Build extends sbt.Build {
  lazy val reactivebeans = Project("reactivebeans", file(".")) settings(
    wrappersSettings(generateJWrappers, "reactive.jswing", "reactive/jswing", "javax.swing.*"),
    wrappersSettings(generateSWrappers, "reactive.sswing", "reactive/sswing", "scala.swing.*")
  )
  lazy val generatedWrappersTester = Project("generatedWrappersTester", file("generatedWrappersTester"))


  val generateJWrappers = TaskKey[Unit]("generate-jswing-wrappers", "Generates wrappers for javax.swing into the test project")
  val generateSWrappers = TaskKey[Unit]("generate-sswing-wrappers", "Generates wrappers for scala.swing into the test project")

  def wrappersSettings(key: TaskKey[Unit], pck: String, bd: String, pattern: String) =
    key <<= (fullClasspath in Compile, mainClass in Compile, runner in run, streams) map {(cp, mc, runner, s) =>
      if (mc.isEmpty) throw new IllegalStateException("No main-class defined")
      s.log.info("Class path is: " + (cp map (_.data)))
      runner.run(mc.get, cp map (_.data), Seq("-pn", pck, "-bd",
        "generatedWrappersTester/src/main/scala/" + bd,
        "--bean-fixes", "defaultbeanfixes.*", pattern), s.log)
    }
}
