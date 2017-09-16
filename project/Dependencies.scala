import sbt.Keys._
import sbt._

class Dependencies(playVersion: String, projectVersion: String, scalaVersion: String = "2.12") {

  val jacksonsJava = Seq(
    "com.fasterxml.jackson.core"        % "jackson-core",
    "com.fasterxml.jackson.core"        % "jackson-annotations",
    "com.fasterxml.jackson.core"        % "jackson-databind",
    "com.fasterxml.jackson.datatype"    % "jackson-datatype-jdk8",
    "com.fasterxml.jackson.datatype"    % "jackson-datatype-jsr310",
    "com.fasterxml.jackson.dataformat"  % "jackson-dataformat-yaml",
    "com.fasterxml.jackson.dataformat"  % "jackson-dataformat-csv"
  ).map(_ % "2.9.1")

  val jacksonScala = "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.9.1"

  val jacksons = jacksonScala +: jacksonsJava

  val jsonRef     = "me.andrz.jackson"  % "jackson-json-reference-core" % "0.2.1"
  val commonsIO   = "commons-io"        % "commons-io"        % "2.5"

  val beard       =  "de.zalando"       %% "beard"            % "0.2.0"

  val play        = "com.typesafe.play" %% "play"             % playVersion % Provided
  val playRoutes  = "com.typesafe.play" %% "routes-compiler"  % playVersion % Provided
  val playClient  = "com.typesafe.play" %% "play-ahc-ws"      % playVersion % Provided
  val playIteratees = "com.typesafe.play" %% "play-iteratees" % "2.6.1"

  val testLibs = Seq(
    "org.scalacheck"  %% "scalacheck"         % "1.13.4",
    "org.scalatest"   %% "scalatest"          % "3.0.1",
    "org.specs2"      %% "specs2-scalacheck"  % "3.9.5",
    //"me.jeffmay"      %% "play-json-tests"    % "1.3.0", Not available for Play 2.6/Scala 2.12
    "ch.qos.logback"   % "logback-classic" % "1.2.3"
  ).map(_ % "test")

  val test = testLibs

  val api = Seq(play, playClient, playIteratees) ++ jacksons

  val playScalaGenerator = Seq(commonsIO, beard)

  val swaggerModel = jsonRef +: jacksons

  val swaggerParser = swaggerModel ++ Seq("org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.6")
}
