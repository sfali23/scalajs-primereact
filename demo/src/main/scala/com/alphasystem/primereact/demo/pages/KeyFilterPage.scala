package com.alphasystem.primereact.demo.pages

import com.alphasystem.primereact.demo.components.keyfilter.{
  KeyFilterDemoDocs,
  KeyFilterShowcase
}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

object KeyFilterPage extends ScalaCssReactImplicits {

  case class Backend(b: BackendScope[Unit, Unit]) {

    def render: VdomElement = {
      div(
        div(cls := "content-section introduction")(
          div(cls := "feature-intro")(
            h1("KeyFilter"),
            p(
              "KeyFilter feature restricts user input based on a regular expression."
            )
          )
        ),
        KeyFilterShowcase(),
        KeyFilterDemoDocs()
      )
    }
  }

  private val component = ScalaComponent
    .builder[Unit]("KeyFilterPage")
    .renderBackend[Backend]
    .build

  def apply(): VdomElement = component()
}
