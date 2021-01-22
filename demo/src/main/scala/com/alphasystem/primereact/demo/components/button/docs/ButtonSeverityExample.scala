package com.alphasystem.primereact.demo.components.button.docs

import com.alphasystem.primereact.demo.components.CodeHighlighter
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

object ButtonSeverityExample extends ScalaCssReactImplicits {

  case class Backend(b: BackendScope[Unit, Unit]) {

    def render: VdomElement = {
      val codeHighlight =
        CodeHighlighter()(
          """
            |import com.alphasystem.primereact.component.button
            |
            |ButtonBuilder().label("Primary").toButton
            |ButtonBuilder().label("Secondary").severity(Severity.Secondary).toButton
            |ButtonBuilder().label("Success").severity(Severity.Success).toButton
            |ButtonBuilder().label("Info").severity(Severity.Info).toButton
            |ButtonBuilder().label("Warning").severity(Severity.Warning).toButton
            |ButtonBuilder().label("Help").severity(Severity.Help).toButton
            |ButtonBuilder().label("Danger").severity(Severity.Danger).toButton
            |
            |""".stripMargin
        )
      div(
        h5("Severity"),
        div("Different color options are available as severity levels."),
        div(
          "Severity is defined in ",
          code("com.alphasystem.primereact.component.button.Severity"),
          "."
        ),
        codeHighlight
      )
    }
  }

  private val component = ScalaComponent
    .builder[Unit]("ButtonSeverityExample")
    .renderBackend[Backend]
    .build

  def apply(): VdomElement = component()
}
