import sbt._
import Keys._
import org.portablescala.sbtplatformdeps.PlatformDepsPlugin.autoImport._

object Dependencies {

  // Scala dependencies
  private val IoKinoplan = "io.kinoplan"
  private val OrgScalaJs = "org.scala-js"
  private val OrgTypelevel = "org.typelevel"
  private val ScalaJsReact = "com.github.japgolly.scalajs-react"
  private val ScalaCss = "com.github.japgolly.scalacss"
  private val IoCirce = "io.circe"
  private val ComBeachape = "com.beachape"

  // NPM dependencies versions
  private val ReactVersion = "17.0.1"
  private val ReactTransitionGroupVersion = "4.4.1"
  private val ClassnamesVersion = "2.2.6"
  private val TypeReactVersion = "17.0.0"
  private val PrimeReactVersion = "5.0.2"
  private val PrimeIconVersion = "4.1.0"
  private val PrimeFlexVersion = "2.0.0"
  private val CssLoaderVersion = "5.0.1"
  private val StyleLoaderVersion = "2.0.0"
  private val UrlLoaderVersion = "4.1.1"
  private val FileLoaderVersion = "6.2.0"
  private val CopyWebpackPluginVersion = "7.0.0"
  /*private val SassLoaderVersion = "10.1.1"
  private val NodeSassVersion = "5.0.0"
  private val HtmlLoaderVersion = "1.3.2"
  private val ScriptLoaderVersion = "0.7.2"
  private val htmlWebpackPluginVersion = "4.5.1"*/

  // Scala dependencies versions
  private val ScalajsReactBridgeVersion = "0.2.1"
  private val ScalaJsVersion = "1.1.0"
  private val ScalaJsReactVersion = "1.7.7"
  private val CatsCoreVersion = "2.1.1"
  private val ScalaCssVersion = "0.6.1"
  private val CirceVersion = "0.13.0"
  private val EnumeratumVersion = "1.6.1"

  val Core = Seq(
    libraryDependencies ++= Seq(
      OrgScalaJs   %%% "scalajs-dom"          % ScalaJsVersion,
      OrgTypelevel %%% "cats-core"            % CatsCoreVersion,
      ScalaJsReact %%% "core"                 % ScalaJsReactVersion,
      ScalaJsReact %%% "extra"                % ScalaJsReactVersion,
      IoKinoplan   %%% "scalajs-react-bridge" % ScalajsReactBridgeVersion,
      ScalaCss     %%% "core"                 % ScalaCssVersion,
      ScalaCss     %%% "ext-react"            % ScalaCssVersion,
      IoCirce      %%% "circe-core"           % CirceVersion,
      IoCirce      %%% "circe-generic"        % CirceVersion,
      IoCirce      %%% "circe-parser"         % CirceVersion,
      ComBeachape  %%% "enumeratum"           % EnumeratumVersion,
      ComBeachape  %%% "enumeratum-circe"     % EnumeratumVersion
    )
  )

  val Demo = Seq(
    libraryDependencies ++= Seq(
      OrgScalaJs   %%% "scalajs-dom"          % ScalaJsVersion,
      OrgTypelevel %%% "cats-core"            % CatsCoreVersion,
      ScalaJsReact %%% "core"                 % ScalaJsReactVersion,
      ScalaJsReact %%% "extra"                % ScalaJsReactVersion,
      IoKinoplan   %%% "scalajs-react-bridge" % ScalajsReactBridgeVersion,
      ScalaCss     %%% "core"                 % ScalaCssVersion,
      ScalaCss     %%% "ext-react"            % ScalaCssVersion
    )
  )

  private val React = Seq(
    "react"                  -> ReactVersion,
    "react-dom"              -> ReactVersion,
    "react-transition-group" -> ReactTransitionGroupVersion,
    "classnames"             -> ClassnamesVersion
  )

  private val Loaders: Seq[(String, String)] = Seq(
    "css-loader"          -> CssLoaderVersion,
    "style-loader"        -> StyleLoaderVersion,
    "url-loader"          -> UrlLoaderVersion,
    "file-loader"         -> FileLoaderVersion,
    "copy-webpack-plugin" -> CopyWebpackPluginVersion
    //"sass-loader"         -> SassLoaderVersion,
    //"html-loader"         -> HtmlLoaderVersion,
    //"script-loader"       -> ScriptLoaderVersion,
    //"html-webpack-plugin" -> htmlWebpackPluginVersion
  )

  private val ReactTypescript = Seq(
    "@types/react"     -> TypeReactVersion,
    "@types/react-dom" -> TypeReactVersion
  )

  private val PrimeReact = Seq(
    "primereact" -> PrimeReactVersion,
    "primeicons" -> PrimeIconVersion,
    "primeflex"  -> PrimeFlexVersion
  )

  val CoreNpm: Seq[(String, String)] = React ++ PrimeReact

  val DemoNpm: Seq[(String, String)] = CoreNpm

  val DevDependencies: Seq[(String, String)] = Loaders ++ ReactTypescript
}
