package com.alphasystem.primereact.demo

import com.alphasystem.primereact.css.ExternalCss
import com.alphasystem.primereact.demo.css.DemoStyles
import org.scalajs.dom._
import com.alphasystem.primereact.demo.router.AppRouter

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

object App {

  def main(args: Array[String]): Unit = {
    import com.alphasystem.primereact.css._

    val theme: ExternalCss = SagaGreenTheme
    val primeReactCss: ExternalCss = PrimeReactCss
    val primeIconCss: ExternalCss = PrimeIconCss
    val primeFlexCss: ExternalCss = PrimeFlexCss
    val appCss: ExternalCss = AppCss

    AppCSS.load(DemoStyles)
    AppRouter.router().renderIntoDOM(document.getElementById("root"))
  }
}
