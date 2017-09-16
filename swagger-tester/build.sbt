import de.zalando.play.apifirst.sbt.ApiFirstCore
import de.zalando.play.generator.sbt.ApiFirstPlayScalaCodeGenerator
import de.zalando.play.swagger.sbt.ApiFirstSwaggerParser
import play.sbt.PlayScala


name.:=("""test""")

version.:=("0.2")

scalaVersion := "2.12.3"

javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

lazy val root = (project in file("."))
  .enablePlugins(PlayScala, ApiFirstCore, ApiFirstPlayScalaCodeGenerator, ApiFirstSwaggerParser)

// The swagger plugin automatically adds a dependency on this, but we make it an
// explicit project ref, so that when we change it, we get the updates without
// having to publish it again
lazy val swaggerApi = ProjectRef(Path.fileProperty("user.dir").getParentFile, "api")

lazy val swaggerPlugin = ProjectRef(Path.fileProperty("user.dir").getParentFile, "plugin")


libraryDependencies ++= Seq(
  specs2 % Test,
  "org.scalacheck"          %% "scalacheck"         % "1.13.4" % Test,
  "org.specs2"              %% "specs2-scalacheck"  % "3.9.5" % Test,
  //"me.jeffmay"      %% "play-json-tests"    % "1.3.0", Not available for Play 2.6/Scala 2.12
  "org.scalatestplus.play"  %% "scalatestplus-play" %  "3.1.2" % Test
)

resolvers ++= Seq(
  "zalando-bintray"  at "https://dl.bintray.com/zalando/maven",
  "scalaz-bintray"   at "http://dl.bintray.com/scalaz/releases",
  "jeffmay" at "https://dl.bintray.com/jeffmay/maven",
  Resolver.bintrayRepo("zalando", "sbt-plugins")
)

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator

apiFirstParsers := Seq(ApiFirstSwaggerParser.swaggerSpec2Ast.value).flatten

playScalaAutogenerateTests := false

