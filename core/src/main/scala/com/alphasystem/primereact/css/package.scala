package com.alphasystem.primereact

import scalacss.defaults.Exports
import scalacss.internal.mutable.Settings

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

package object css {

  val CssSettings: Exports with Settings = scalacss.devOrProdDefaults

  trait ExternalCss extends js.Object

  @js.native
  @JSImport("primereact/resources/primereact.min.css", JSImport.Namespace)
  object PrimeReactCss extends ExternalCss

  @js.native
  @JSImport("primeicons/primeicons.css", JSImport.Namespace)
  object PrimeIconCss extends ExternalCss

  @js.native
  @JSImport("primeflex/primeflex.css", JSImport.Namespace)
  object PrimeFlexCss extends ExternalCss

  @js.native
  @JSImport(
    "primereact/resources/themes/saga-green/theme.css",
    JSImport.Namespace
  )
  object SagaGreenTheme extends ExternalCss
}
