package com.alphasystem.primereact

import com.alphasystem.primereact.css.ExternalCss

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

package object demo {

  @js.native
  @JSImport(
    "../../../../src/main/resources/assets/app/App.css",
    JSImport.Namespace
  )
  object AppCss extends ExternalCss

  @js.native
  @JSImport(
    "../../../../src/main/resources/assets/app/ButtonDemo.css",
    JSImport.Namespace
  )
  object ButtonDemoCss extends ExternalCss
}
