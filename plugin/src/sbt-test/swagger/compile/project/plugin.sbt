//Needs https://github.com/playframework/playframework/pull/7830
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.6.5", "0.13", "2.10")

addSbtPlugin("de.zalando" % "sbt-api-first-hand" % sys.props("project.version"))
