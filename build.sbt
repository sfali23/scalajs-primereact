lazy val `scalajs-primereact` = project
  .in(file("."))
  .aggregate(core, `react-transition-group`, `scalajs-axios`, demo)

inThisBuild(
  List(
    organization := "com.alphasystem"
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
    Settings.CoreDependencies,
    npmDependencies in Compile ++= Settings.CoreNpmPackages,
    npmResolutions in Compile ++= (npmDependencies in Compile).value.toMap
  )
  .enablePlugins(ScalaJSBundlerPlugin)

lazy val `react-transition-group` = project
  .in(file("react-transition-group"))
  .configure(commonProfile)
  .enablePlugins(ScalaJSBundlerPlugin)
  .settings(
    scalaJSUseMainModuleInitializer := false,
    Settings.ReactTransitionGroupDependencies,
    npmDependencies in Compile ++= Settings.ReactTransitionGroupPackages,
    npmResolutions in Compile ++= (npmDependencies in Compile).value.toMap
  )

lazy val `scalajs-axios` = project
  .in(file("scalajs-axios"))
  .configure(commonProfile)
  .enablePlugins(ScalaJSBundlerPlugin)
  .settings(
    scalaJSUseMainModuleInitializer := false,
    Settings.AxiosDependencies,
    npmDependencies in Compile ++= Settings.AxiosPackages,
    npmResolutions in Compile ++= (npmDependencies in Compile).value.toMap
  )

lazy val demo = project
  .in(file("demo"))
  .dependsOn(core, `react-transition-group`, `scalajs-axios`)
  .configure(commonProfile)
  .settings(
    scalaJSUseMainModuleInitializer := true,
    scalaJSLinkerConfig ~= {
      _.withModuleKind(ModuleKind.CommonJSModule)
    },
    stIgnore ++= Settings.stIgnore,
    jsEnv := new org.scalajs.jsenv.nodejs.NodeJSEnv(),
    scalaJSLinkerConfig ~= (_.withSourceMap(false)),
    webpackDevServerExtraArgs := Seq("--inline"),
    npmDependencies in Compile ++= Settings.DemoNpmPackages,
    npmDevDependencies in Compile ++= Settings.NpmDevPackages,
    npmResolutions in Compile ++= (npmDependencies in Compile).value.toMap,
    version in webpack := Settings.Version.Webpack,
    version in startWebpackDevServer := Settings.Version.WebpackDev,
    webpackCliVersion := Settings.Version.WebpackCli,
    webpackDevServerPort := 4500,
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
