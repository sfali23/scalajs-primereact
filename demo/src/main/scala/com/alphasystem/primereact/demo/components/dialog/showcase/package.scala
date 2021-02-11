package com.alphasystem.primereact.demo.components.dialog

import scala.scalajs.js
import scala.scalajs.js.{ UndefOr, undefined }

package object showcase {

  @js.native
  trait Style extends js.Object {
    var width: UndefOr[String] = js.native
    var fontSize: UndefOr[String] = js.native
  }

  object Style {

    def apply(
      width: UndefOr[String] = undefined,
      fontSize: UndefOr[String] = undefined
    ): Style = {
      val style = (new js.Object).asInstanceOf[Style]
      style.width = width
      style.fontSize = fontSize
      style
    }
  }
}
