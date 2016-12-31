lazy val commonSettings = Seq(
  organization := "com.tomwadeson",
  version := "0.1.0",
  scalaVersion := "2.12.1"
)

lazy val commonDependencies = Seq(
  "org.scalatest" %% "scalatest" % "3.0.1" % Test
)

lazy val day1 = (project in file("day-1")).
  settings(commonSettings: _*).
  settings(libraryDependencies ++= commonDependencies)

lazy val day2 = (project in file("day-2")).
  settings(commonSettings: _*).
  settings(libraryDependencies ++= commonDependencies)

lazy val day3 = (project in file("day-3")).
  settings(commonSettings: _*).
  settings(libraryDependencies ++= commonDependencies)

lazy val day4 = (project in file("day-4")).
  settings(commonSettings: _*).
  settings(libraryDependencies ++= commonDependencies).
  settings(libraryDependencies ++= Seq("commons-codec" % "commons-codec" % "1.10"))
