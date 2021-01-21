lazy val `scalajs-primereact` = project
  .in(file("."))
  .aggregate(core, demo)

inThisBuild(
  List(
    organization := "com.alphasystem",
    licenses := Seq("MIT" -> url("http://opensource.org/licenses/MIT"))
  )
)

lazy val core = project
  .in(file("core"))
  .configure(commonProfile)
  .settings(
    name := "scalajs-primereact-core",
    skip in publish := true,
    skip in publishLocal := true,
    skip in publishArtifact := true,
    Keys.`package` := file(""),
    Dependencies.Core,
    npmDependencies in Compile ++= Dependencies.CoreNpm,
    npmResolutions in Compile ++= (npmDependencies in Compile).value.toMap
  )
  .enablePlugins(ScalaJSPlugin, ScalaJSBundlerPlugin)

lazy val demo = project
  .in(file("demo"))
  .dependsOn(core)
  .configure(commonProfile)
  .settings(
    scalaJSUseMainModuleInitializer := true,
    scalaJSLinkerConfig ~= {
      _.withModuleKind(ModuleKind.CommonJSModule)
    },
    stIgnore ++= Dependencies.stIgnore,
    jsEnv := new org.scalajs.jsenv.nodejs.NodeJSEnv(),
    scalaJSLinkerConfig ~= (_.withSourceMap(false)),
    webpackDevServerExtraArgs := Seq("--inline"),
    npmDependencies in Compile ++= Dependencies.DemoNpm,
    npmDevDependencies in Compile ++= Dependencies.DevDependencies,
    npmResolutions in Compile ++= (npmDependencies in Compile).value.toMap,
    webpackConfigFile in fastOptJS := Some(
      baseDirectory.value / "dev.webpack.config.js"
    ),
    skip in publish := true
  )
  .enablePlugins(ScalablyTypedConverterPlugin)

lazy val commonProfile: Project => Project =
  _.settings(
    crossScalaVersions := Seq(
      Settings.Version.Scala212Version,
      Settings.Version.Scala213Version
    ),
    scalaVersion := Settings.Version.Scala213Version,
    description := "scalajs-react facade for primereact",
    version in webpack := Settings.Version.Webpack,
    version in startWebpackDevServer := Settings.Version.WebpackDev,
    webpackCliVersion := Settings.Version.WebpackCli,
    webpackDevServerPort := 4500,
    Global / onChangedBuildSource := IgnoreSourceChanges,
    javacOptions ++= Settings.JavacOptions,
    scalacOptions ~= (_.filterNot(
      Set(
        "-Wdead-code",
        "-Wunused:params",
        "-Ywarn-dead-code",
        "-Ywarn-unused:params",
        "-Ywarn-unused:patvars",
        "-Wunused:explicits"
      )
    ))
  )
