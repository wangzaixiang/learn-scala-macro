import sbt._
import Keys._

object MyBuild extends Build {

	lazy val commonSettings = Seq(
		scalaVersion := "2.11.4",
		organization := "wangzaixiang",
		version := "1.0"
	)

	val root = (project in file("."))
		.aggregate(demo_macro_impl, demo_macro_test)
		.settings(
			run <<= run in Compile in demo_macro_test
		)

	lazy val demo_macro_impl = (project in file("demo_macro_impl"))
		.settings(commonSettings:_*)
		.settings(
			libraryDependencies += "org.scala-lang" % "scala-reflect" % "2.11.4"
		)


	lazy val demo_macro_test = (project in file("demo_macro_test"))
		.settings(commonSettings:_*)
		.dependsOn(demo_macro_impl)

}
