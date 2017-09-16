import de.zalando.play.apifirst.sbt.ApiFirstCore
import de.zalando.play.generator.sbt.ApiFirstPlayScalaCodeGenerator
import de.zalando.play.swagger.sbt._
import play.sbt.PlayScala

lazy val root = (project in file(".")).enablePlugins(PlayScala, ApiFirstCore, ApiFirstPlayScalaCodeGenerator, ApiFirstSwaggerParser)

scalaVersion := sys.props.get("scala.version").getOrElse("2.12.3")

libraryDependencies ++= Seq(
  specs2,
  "org.scalacheck" %% "scalacheck" % "1.13.4",
  "org.specs2" %% "specs2-scalacheck" % "3.9.5",
  //"me.jeffmay"      %% "play-json-tests"    % "1.3.0", Not available for Play 2.6/Scala 2.12
  "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2"
).map(_ % "test")

apiFirstParsers := Seq(ApiFirstSwaggerParser.swaggerSpec2Ast.value).flatten

playScalaAutogenerateTests := true

logLevel := sbt.Level.Warn

crossPaths := false