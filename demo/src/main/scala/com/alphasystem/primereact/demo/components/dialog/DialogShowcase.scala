package com.alphasystem.primereact.demo.components.dialog

import com.alphasystem.primereact.ExternalCss
import com.alphasystem.primereact.component.button.ButtonBuilder
import com.alphasystem.primereact.demo.components.dialog.showcase._
import com.alphasystem.primereact.icons.Icon
import japgolly.scalajs.react._
import japgolly.scalajs.react.raw.React
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

object DialogShowcase extends ScalaCssReactImplicits {

  @js.native
  @JSImport(
    "../../../../src/main/resources/assets/app/DialogDemo.css",
    JSImport.Namespace
  )
  object DialogCss extends ExternalCss

  case class Backend(b: BackendScope[Unit, Unit]) {

    private val css = DialogCss

    def render: VdomElement =
      div(cls := "content-section implementation dialog-demo")(
        div(cls := "card")(
          h5("Basic"),
          BasicExample(),
          LongContentExample(),
          h5("Without Modal"),
          BasicExample(false),
          h5("Confirmation"),
          ConfirmationExample(),
          h5("Maximizable"),
          MaximizableExample(),
          h5("Position"),
          PositionExample()
        )
      )
  }

  def renderFooter(hideHandler: Callback): React.Element =
    div(
      ButtonBuilder()
        .label("No")
        .icon(Icon.Times)
        .text
        .toButton(onClick --> hideHandler),
      ButtonBuilder()
        .label("Yes")
        .icon(Icon.Check)
        .toButton(
          autoFocus := true,
          onClick --> hideHandler
        )
    ).rawElement

  private val component = ScalaComponent
    .builder[Unit]("DialogShowcase")
    .renderBackend[Backend]
    .build

  def apply(): VdomElement = component()
}
