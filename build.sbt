name := "99Problems"

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies += "org.scalatest" % "scalatest_2.12" % "3.0.5" % "test"

commands += Command.command("cls") { state =>
  print("\033c")
  state
}