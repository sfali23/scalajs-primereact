package com.alphasystem.primereact.demo.pages

import com.alphasystem.primereact.demo.components.inputtext.{
  InputTextDemoDocs,
  InputTextShowcase
}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

object InputTextPage extends ScalaCssReactImplicits {

  case class Backend(b: BackendScope[Unit, Unit]) {

    def render: VdomElement =
      div(
        div(cls := "content-section introduction")(
          div(cls := "feature-intro")(
            h1("InputText"),
            p(
              "InputText is an extension to standard input element with theming and keyfiltering."
            )
          )
        ),
        InputTextShowcase(),
        InputTextDemoDocs()
      )
  }

  private val component = ScalaComponent
    .builder[Unit]("InputTextPage")
    .renderBackend[Backend]
    .build

  def apply(): VdomElement = component()
}
