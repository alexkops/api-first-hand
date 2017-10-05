resolvers += Resolver.sonatypeRepo("releases")
resolvers += Resolver.sonatypeRepo("snapshots")

addSbtPlugin("com.eed3si9n"      % "sbt-buildinfo" % "0.7.0")
addSbtPlugin("org.scoverage"     % "sbt-scoverage" % "1.5.1")
addSbtPlugin("org.foundweekends" % "sbt-bintray"   % "0.5.1")

addSbtPlugin("org.scalariform"  % "sbt-scalariform"         % "1.8.0")
addSbtPlugin("org.wartremover"  % "sbt-wartremover"         % "2.2.0")
addSbtPlugin("org.scalastyle"   %% "scalastyle-sbt-plugin"  % "1.0.0")

libraryDependencies += { "org.scala-sbt" %% "scripted-plugin" % sbtVersion.value }