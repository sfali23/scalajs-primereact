import sbt._
import Keys._
import org.portablescala.sbtplatformdeps.PlatformDepsPlugin.autoImport._

object Settings {

  object Version {
    val Scala213Version = "2.13.4"
    val Scala212Version = "2.12.12"
    val Webpack = "4.41.5"
    val WebpackDev = "3.10.2"
    val WebpackCli = "3.3.10"
  }

  private object ScalaModule {
    val ScalaJs = "org.scala-js"
    val ScalaJsReact = "com.github.japgolly.scalajs-react"
    val Kinoplan = "io.kinoplan"
    val Typelevel = "org.typelevel"
    val ScalaCss = "com.github.japgolly.scalacss"
    val Circe = "io.circe"
    val Beachape = "com.beachape"
  }

  // Scala dependencies versions
  private object ScalaVersion {
    val ScalaJs = "1.1.0"
    val ScalajsReactBridge = "0.2.1"
    val ScalaJsReact = "1.7.7"
    val CatsCore = "2.1.1"
    val ScalaCss = "0.6.1"
    val Circe = "0.13.0"
    val Enumeratum = "1.6.1"
  }

  private object NpmModule {
    val ReactDom = "react-dom"
    val React = "react"
    val ReactTransitionGroup = "react-transition-group"
    val ClassNames = "classnames"
    val PrimeReact = "primereact"
    val PrimeIcons = "primeicons"
    val PrimeFlex = "primeflex"
    val Prismjs = "prismjs"
    val CssLoader = "css-loader"
    val StyleLoader = "style-loader"
    val UrlLoader = "url-loader"
    val FileLoader = "file-loader"
    val Axios = "axios"
  }

  // NPM dependencies versions
  private object NpmVersion {
    val React = "17.0.1"
    val ReactTransition = "4.4.1"
    val Classnames = "2.2.6"
    val TypeReact = "17.0.0"
    val PrimeReact = "5.0.2"
    val PrimeIcon = "4.1.0"
    val PrimeFlex = "2.0.0"
    val CssLoader = "5.0.1"
    val StyleLoader = "2.0.0"
    val UrlLoader = "4.1.1"
    val FileLoader = "6.2.0"
    val Prismjs = "1.23.0"
    val Axios = "0.21.1"
  }

  private val ScalaJsDependencies: Seq[Setting[Seq[ModuleID]]] = Seq(
    libraryDependencies ++= Seq(
      ScalaModule.ScalaJs %%% "scalajs-dom" % ScalaVersion.ScalaJs
    )
  )

  private val ReactDependencies: Seq[Setting[Seq[ModuleID]]] = Seq(
    libraryDependencies ++= Seq(
      ScalaModule.ScalaJs      %%% "scalajs-dom"          % ScalaVersion.ScalaJs,
      ScalaModule.ScalaJsReact %%% "core"                 % ScalaVersion.ScalaJsReact,
      ScalaModule.ScalaJsReact %%% "extra"                % ScalaVersion.ScalaJsReact,
      ScalaModule.Kinoplan     %%% "scalajs-react-bridge" % ScalaVersion.ScalajsReactBridge
    )
  )

  private val CommonDependencies: Seq[Setting[Seq[ModuleID]]] =
    ScalaJsDependencies ++ ReactDependencies

  private val JsonDependencies: Seq[Setting[Seq[ModuleID]]] = Seq(
    libraryDependencies ++= Seq(
      ScalaModule.Circe %%% "circe-core"    % ScalaVersion.Circe,
      ScalaModule.Circe %%% "circe-generic" % ScalaVersion.Circe,
      ScalaModule.Circe %%% "circe-parser"  % ScalaVersion.Circe
    )
  )

  private val EnumDependencies: Seq[Setting[Seq[ModuleID]]] = Seq(
    libraryDependencies ++= Seq(
      ScalaModule.Beachape %%% "enumeratum"       % ScalaVersion.Enumeratum,
      ScalaModule.Beachape %%% "enumeratum-circe" % ScalaVersion.Enumeratum
    )
  )

  val CoreDependencies: Seq[Def.Setting[Seq[ModuleID]]] =
    CommonDependencies ++ JsonDependencies ++ EnumDependencies ++ Seq(
      libraryDependencies ++= Seq(
        ScalaModule.Typelevel %%% "cats-core" % ScalaVersion.CatsCore,
        ScalaModule.ScalaCss  %%% "core"      % ScalaVersion.ScalaCss,
        ScalaModule.ScalaCss  %%% "ext-react" % ScalaVersion.ScalaCss
      )
    )

  val ReactTransitionGroupDependencies: Seq[Def.Setting[Seq[ModuleID]]] =
    CommonDependencies ++ JsonDependencies ++ EnumDependencies

  val AxiosDependencies: Seq[Def.Setting[Seq[ModuleID]]] = ScalaJsDependencies

  val DemoDependencies: Seq[Setting[Seq[ModuleID]]] = Seq(
    libraryDependencies ++= Seq(
    )
  )

  private val ReactPackages = Seq(
    NpmModule.React    -> NpmVersion.React,
    NpmModule.ReactDom -> NpmVersion.React
  )

  val ReactTransitionGroupPackages = Seq(
    NpmModule.ReactTransitionGroup -> NpmVersion.ReactTransition
  )

  val AxiosPackages = Seq(
    NpmModule.Axios -> NpmVersion.Axios
  )

  private val SupportPackages = Seq(
    NpmModule.ClassNames -> NpmVersion.Classnames
  )

  private val LoadersPackages = Seq(
    NpmModule.CssLoader   -> NpmVersion.CssLoader,
    NpmModule.StyleLoader -> NpmVersion.StyleLoader,
    NpmModule.UrlLoader   -> NpmVersion.UrlLoader,
    NpmModule.FileLoader  -> NpmVersion.FileLoader
  )

  private val ReactTypescriptPackages = Seq(
    s"@types/${NpmModule.React}"    -> NpmVersion.TypeReact,
    s"@types/${NpmModule.ReactDom}" -> NpmVersion.TypeReact
  )

  private val PrimeReactPackages = Seq(
    NpmModule.PrimeReact -> NpmVersion.PrimeReact,
    NpmModule.PrimeIcons -> NpmVersion.PrimeIcon,
    NpmModule.PrimeFlex  -> NpmVersion.PrimeFlex
  )

  val CoreNpmPackages: Seq[(String, String)] =
    ReactPackages ++ ReactTransitionGroupPackages ++ SupportPackages ++ PrimeReactPackages

  val DemoNpmPackages: Seq[(String, String)] = Seq(
    NpmModule.Prismjs -> NpmVersion.Prismjs
  ) ++ CoreNpmPackages ++ AxiosPackages

  val NpmDevPackages: Seq[(String, String)] =
    LoadersPackages ++ ReactTypescriptPackages

  val stIgnore = List(
    NpmModule.ReactDom,
    NpmModule.ReactTransitionGroup,
    NpmModule.PrimeIcons,
    NpmModule.PrimeFlex,
    NpmModule.ClassNames,
    NpmModule.Prismjs
  )

  val JavacOptions = Seq(
    "-source",
    "1.8",
    "-target",
    "1.8",
    "-Xlint"
  )

}
