package com.alphasystem.primereact.demo.pages

import com.alphasystem.primereact.demo.components.menu
import com.alphasystem.primereact.demo.components.menu.{
  MenuDemoDocs,
  MenuShowcase
}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

object MenuPage extends ScalaCssReactImplicits {

  case class Backend(b: BackendScope[Unit, Unit]) {

    def render: VdomElement =
      div(
        div(cls := "content-section introduction")(
          div(cls := "feature-intro")(
            h1("Menu"),
            p(
              "Menu is a navigation/command component that supports dynamic and static positioning."
            )
          )
        ), // end of "introduction",
        MenuShowcase(),
        MenuDemoDocs()
      )
  }

  private val component = ScalaComponent
    .builder[Unit]("MenuPage")
    .renderBackend[Backend]
    .build

  def apply(): VdomElement = component()
}
