package com.alphasystem.primereact.demo.pages

import com.alphasystem.primereact.demo.components.button.{
  ButtonDemoDocs,
  ButtonShowcase
}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

object ButtonPage extends ScalaCssReactImplicits {

  case class Backend(b: BackendScope[Unit, Unit]) {

    def render: VdomElement = {
      div()(
        div(cls := "content-section introduction")(
          div(cls := "feature-intro")(
            h1("Button"),
            p(
              "Button is an extension to standard input element with icons and theming."
            )
          ) // end of "feature-intro"
        ), // end of "content-section introduction"
        ButtonShowcase(),
        ButtonDemoDocs()
      ) // end of outermost div
    }
  }

  private val component = ScalaComponent
    .builder[Unit]("ButtonPage")
    .renderBackend[Backend]
    .build

  def apply(): VdomElement = component()
}
