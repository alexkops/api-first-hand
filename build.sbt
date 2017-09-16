import sbt._

val PlayVersion = "2.7.+"
//val PlayVersion = "2.7.0-2017-09-08-66cd842-SNAPSHOT"
val ScalaVersion = "2.12.3"
val ProjectVersion = "0.3"

val deps = new Dependencies(PlayVersion, ProjectVersion)

javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

lazy val common = (project in file("common"))
  .settings(commonSettings: _*)
  .settings(
    name := "api-first-hand-common",
    libraryDependencies ++= deps.jacksonsJava ++ deps.test
  )

// This is the API project, it gets added to the runtime dependencies of any
// project using play-swagger
lazy val api = (project in file("api"))
  .settings(commonSettings: _*)
  .settings(
    name := "api-first-hand-api",
    libraryDependencies ++= deps.api ++ deps.test
  )

lazy val swaggerModel = (project in file("swagger-model"))
  .settings(commonSettings: _*)
  .settings(
    name := "swagger-model",
    libraryDependencies ++= deps.swaggerModel ++ deps.test
  )

lazy val apiFirstCore = (project in file("api-first-core"))
  .settings(commonSettings: _*)
  .settings(
    name := "api-first-core",
    libraryDependencies ++= deps.test
  )

lazy val swaggerParser = (project in file("swagger-parser"))
  .settings(commonSettings: _*)
  .settings(
    name := "swagger-parser",
    libraryDependencies ++= deps.swaggerParser ++ deps.test
  )
  .dependsOn(swaggerModel, apiFirstCore)

lazy val playScalaGenerator = (project in file("play-scala-generator"))
  .settings(commonSettings: _*)
  .settings(
    name := "play-scala-generator",
    libraryDependencies ++= deps.playScalaGenerator ++ deps.test
  )
  .dependsOn(apiFirstCore)

// This is the sbt plugin
lazy val plugin = (project in file("plugin"))
  .enablePlugins(BuildInfoPlugin)
  .settings(commonSettings: _*)
  //.settings(scriptedSettings: _*)
  .settings(
    libraryDependencies ++= deps.test,
    name := "sbt-api-first-hand",
    sbtPlugin := true,
    //Needs https://github.com/playframework/playframework/pull/7830
    addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.6.5", "0.13", "2.10"),

    buildInfoKeys := Seq[BuildInfoKey](name, version, scalaVersion, sbtVersion),
    scriptedLaunchOpts := {
      scriptedLaunchOpts.value ++
        Seq(
          "-Dproject.version=" + version.value,
          "-Dscala.version=" + ScalaVersion,
          "-Xmx1024M",
          "-XX:ReservedCodeCacheSize=256M"
        )
    },
    scriptedDependencies := {
      val ap = (publishLocal in api).value
      val a = (publishLocal in swaggerModel).value
      val b = (publishLocal in common).value
      val c = (publishLocal in apiFirstCore).value
      val d = (publishLocal in swaggerParser).value
      val e = (publishLocal in playScalaGenerator).value
      val f = publishLocal.value
    },
    scriptedBufferLog := false,
    logLevel := Level.Warn,
    coverageExcludedPackages := "<empty>;de\\.zalando\\.play\\.apifirst\\.sbt\\.ApiFirstCore"
  )
  .dependsOn(common, apiFirstCore, playScalaGenerator, swaggerParser, swaggerModel)

lazy val root = (project in file("."))
  // Use sbt-doge cross building since we have different projects with different scala versions
  .settings(commonSettings: _*)
  .settings(
    name := "api-first-hand-root",
    aggregate in update := false
  )
  .aggregate(common, swaggerModel, api, swaggerParser, apiFirstCore, playScalaGenerator, plugin)

def commonSettings: Seq[Setting[_]] = Seq(
  scalaVersion := ScalaVersion,
  ivyLoggingLevel := UpdateLogging.DownloadOnly,
  version := ProjectVersion,
  sbtPlugin := false,
  buildInfoPackage := "de.zalando",
  organization := "de.zalando",
  fork in(Test, run) := true,
  autoScalaLibrary := true,
  resolvers ++= Seq(
    Resolver.bintrayRepo("zalando", "sbt-plugins"),
    "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases",
    "zalando-maven" at "https://dl.bintray.com/zalando/maven",
    "jeffmay" at "https://dl.bintray.com/jeffmay/maven",
    Resolver.sonatypeRepo("snapshots")
  ),
  licenses +=("MIT", url("http://opensource.org/licenses/MIT")),
  publishMavenStyle := false,
  bintrayRepository  := "sbt-plugins",
  bintrayOrganization  := Some("zalando"),
  scalacOptions ++= Seq(
    "-deprecation",
    "-encoding", "UTF-8", // yes, this is 2 args
    "-feature",
    "-unchecked",
    "-Ywarn-numeric-widen",
    "-Ywarn-value-discard",
    //    "-Xfatal-warnings",
    //    "-Xlint",
    "-Yno-adapted-args",
    "-Xfuture"
  ),
  scalastyleFailOnError := false,
  coverageEnabled := false,
  excludeFilter in scalariformFormat := (excludeFilter in scalariformFormat).value || dontFormatTestModels
) ++ Lint.all ++ scalariformSettings(false)

// https://github.com/sbt/sbt-scalariform#advanced-configuration for more options.

val dontFormatTestModels = new sbt.FileFilter {
  def accept(f: File) = ".*/model/.*".r.pattern.matcher(f.getAbsolutePath).matches
}

coverageMinimum := 80

coverageFailOnMinimum := false

coverageHighlighting := false
