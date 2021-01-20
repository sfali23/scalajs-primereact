package com.alphasystem.primereact.demo.components.button.docs

import com.alphasystem.primereact.demo.css.DemoStyles
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

object BasicExample extends ScalaCssReactImplicits {

  case class Backend(b: BackendScope[Unit, Unit]) {

    def render: VdomElement =
      div(DemoStyles.codeHighlight)(
        table(
          tbody(
            tr(
              td(
                pre(
                  DemoStyles.codeHighlightPre,
                  "1\n",
                  "2\n",
                  "3\n",
                  "4\n",
                  "5\n",
                  "6\n"
                )
              ),
              td(
                pre(
                  DemoStyles.codeHighlightPre,
                  span(DemoStyles.codeHighlightKeyword, "import"),
                  span(" "),
                  span(
                    DemoStyles.codeHighlightCodeSnippet,
                    "com.alphasystem.primereact.component\n\n"
                  ),
                  span(DemoStyles.codeHighlightCodeSnippet, "Button"),
                  span("(\n"),
                  span("  label = "),
                  span(DemoStyles.codeHighlightVariable2, "\"Save\""),
                  span(",\n"),
                  span("  icon = "),
                  span(DemoStyles.codeHighlightVariable2, "\"pi pi-check\"\n"),
                  span(")")
                )
              )
            )
          )
        )
      )
  }

  private val component = ScalaComponent
    .builder[Unit]("BasicExample")
    .renderBackend[Backend]
    .build

  def apply(): VdomElement = component()
}
