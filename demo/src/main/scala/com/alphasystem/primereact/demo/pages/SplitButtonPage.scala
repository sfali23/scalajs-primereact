package com.alphasystem.primereact.demo.pages

import com.alphasystem.primereact.demo.components.splitbutton.{
  SplitButtonDemoDocs,
  SplitButtonShowcase
}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

object SplitButtonPage extends ScalaCssReactImplicits {

  case class Backend(b: BackendScope[Unit, Unit]) {

    def render: VdomElement = {
      div()(
        div(cls := "content-section introduction")(
          div(cls := "feature-intro")(
            h1("SplitButton"),
            p(
              "SplitButton groups a set of commands in an overlay with a default command."
            )
          ) // end of "feature-intro"
        ), // end of "content-section introduction"
        SplitButtonShowcase(),
        SplitButtonDemoDocs()
      ) // end of outermost div
    }
  }

  private val component = ScalaComponent
    .builder[Unit]("SplitButtonPage")
    .renderBackend[Backend]
    .build

  def apply(): VdomElement = component()
}
