object Settings {

  object Version {
    val Scala213Version = "2.13.4"
    val Scala212Version = "2.12.12"
    val Webpack = "4.41.5"
    val WebpackDev = "3.10.2"
    val WebpackCli = "3.3.10"
  }

  val JavacOptions = Seq(
    "-source",
    "1.8",
    "-target",
    "1.8",
    "-Xlint"
  )

  val stIgnore = List(
    "react-dom",
    "react-transition-group",
    "primeicons",
    "primeflex",
    "classnames"
  )

}
