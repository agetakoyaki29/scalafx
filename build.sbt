
lazy val root = (project in file("."))
  .settings(fxmlSettings: _*)
  .settings(
    organization := "com.github.agetakoyaki29",
    name := "scalafx",
    version := "1.0",
    scalaVersion := "2.11.8",

    libraryDependencies += scalactic,
    libraryDependencies += scalatest,

    logBuffered in Test := false
  )

// ---- settings ----
lazy val fxmlSettings = Seq(
    unmanagedJars in Compile += {
        val ps = new sys.SystemProperties
        val jh = ps("java.home")
        Attributed.blank(file(jh) / "lib/ext/jfxrt.jar")
    }
)

// ---- lib ----
lazy val scalactic = "org.scalactic" %% "scalactic" % "2.2.5"
lazy val scalatest = "org.scalatest" %% "scalatest" % "2.2.5" % "test"
