package com.alexitc

import chrome.Manifest
import org.scalajs.jsdependencies.sbtplugin.JSDependenciesPlugin
import org.scalajs.jsdependencies.sbtplugin.JSDependenciesPlugin.autoImport._
import org.scalajs.sbtplugin.ScalaJSPlugin
import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._
import sbt.Keys._
import sbt._

object ChromeSbtPlugin extends AutoPlugin {

  override def requires: Plugins = ScalaJSPlugin && JSDependenciesPlugin

  object autoImport {

    val chromeUnpackedOpt = TaskKey[File]("chromeUnpackedOpt")
    val chromeUnpackedFast = TaskKey[File]("chromeUnpackedFast")
    val chromePackage = TaskKey[File]("chromePackage")
    val chromeGenerateManifest = TaskKey[File]("chromeGenerateManifest")
    val chromeManifest = TaskKey[Manifest]("chromeManifest")
    val fullOptJsLib = TaskKey[Attributed[File]]("fullOptJsLib")
    val fastOptJsLib = TaskKey[Attributed[File]]("fastOptJsLib")

    private val chromeDir = "chrome"

    lazy val baseSettings: Seq[Def.Setting[_]] = Seq(
      fastOptJsLib := (Compile / fastOptJS).value,
      chromeUnpackedFast := {
        Chrome.buildUnpackedDirectory(target.value / chromeDir / "unpacked-fast")(
          (Compile / chromeGenerateManifest).value,
          fastOptJsLib.value.data,
          (Compile / packageJSDependencies).value,
          (Compile / resourceDirectories).value
        )
      },
      fullOptJsLib := (Compile / fullOptJS).value,
      chromeUnpackedOpt := {
        Chrome.buildUnpackedDirectory(target.value / chromeDir / "unpacked-opt")(
          (Compile / chromeGenerateManifest).value,
          fullOptJsLib.value.data,
          (Compile / packageMinifiedJSDependencies).value,
          (Compile / resourceDirectories).value
        )
      },
      chromePackage := {
        val out = target.value / chromeDir
        val chromeAppDir = chromeUnpackedOpt.value
        val zipFile = new File(out, s"${name.value}.zip")
        val excludeFileNames = Set(
          ".DS_Store"
        )
        val fileFilter = AllPassFilter - new SimpleFilter(excludeFileNames.contains)
        IO.zip(Path.selectSubpaths(chromeAppDir, fileFilter), zipFile, None)
        zipFile
      },
      chromeGenerateManifest := {
        Chrome.generateManifest(target.value / chromeDir / "generated_manifest.json")(
          (Compile / chromeManifest).value
        )
      }
    )

  }

  import autoImport._

  override val projectSettings = baseSettings

}
