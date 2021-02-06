package com.alphasystem.primereact.demo

import com.alphasystem.primereact.ExternalCss
import com.alphasystem.primereact.demo.css.DemoStyles
import org.scalajs.dom._

object App {

  def main(args: Array[String]): Unit = {
    import com.alphasystem.primereact.css._

    val primeReactCss: ExternalCss = PrimeReactCss
    val primeIconCss: ExternalCss = PrimeIconCss
    val primeFlexCss: ExternalCss = PrimeFlexCss
    val prismjs = PrismJs
    val prismCss = PrismCss
    val prismCoy: ExternalCss = PrismCoy
    val appCss: ExternalCss = AppCss

    AppCSS.load(DemoStyles)
    Content().renderIntoDOM(document.getElementById("root"))
  }
}
