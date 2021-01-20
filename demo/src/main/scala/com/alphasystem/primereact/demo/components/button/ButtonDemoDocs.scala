package com.alphasystem.primereact.demo.components.button

import com.alphasystem.primereact.demo.components.button.docs.BasicExample
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

object ButtonDemoDocs extends ScalaCssReactImplicits {

  private val sourceCodeLink =
    "https://github.com/sfali23/scalajs-primereact/blob/main/demo/src/main/scala/com/alphasystem/primereact/demo/pages/ButtonPage.scala"

  case class Backend(b: BackendScope[Unit, Unit]) {

    def render: VdomElement = {
      div(cls := "content-section documentation")(
        h2("Documentation"),
        h5("Getting Started"),
        BasicExample(),
        div(
          "Source code can be found ",
          a(
            href := sourceCodeLink,
            target := "_blank",
            rel := "noopener noreferrer"
          )("here"),
          "."
        )
      ) // end of "content-section documentation"
    }
  }

  private val component = ScalaComponent
    .builder[Unit]("ButtonDemoDocs")
    .renderBackend[Backend]
    .build

  def apply(): VdomElement = component()
}
