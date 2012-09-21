import sbt.Defaults._

sbtPlugin := true

name := "play-plugins-dust"

version := "1.4-2012.08.15.c4c3576-v3"

organization := "com.typesafe"

resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies += "play" % "sbt-plugin" % "2012.08.15.c4c3576"

libraryDependencies += "commons-io" % "commons-io" % "2.2"

publishMavenStyle := false

credentials += Credentials(Path.userHome / ".sbt" / ".licredentials")

resolvers += {
  val artifactory = "http://artifactory.corp.linkedin.com:8081/artifactory/"
  val sandbox = Resolver.url("Artifactory sandbox", url(artifactory + "ext-sandbox"))(
                    Patterns(Seq("[organization]/[module]/[revision]/[module]-[revision].ivy"),
                             Seq("[organisation]/[module]/[revision]/[artifact]-[revision](-[classifier]).[ext]"),
                             isMavenCompatible=true))
  sandbox
}

publishTo := {
  val artifactory = "http://artifactory.corp.linkedin.com:8081/artifactory/"
  val sandbox = Resolver.url("Artifactory sandbox publish", url(artifactory + "ext-sandbox"))(
                    Patterns(Seq("[organization]/[module]/[revision]/[module]-[revision].ivy"),
                             Seq("[organisation]/[module]/[revision]/[artifact]-[revision](-[classifier]).[ext]"),
                             isMavenCompatible=true))
  Some(sandbox)
}
