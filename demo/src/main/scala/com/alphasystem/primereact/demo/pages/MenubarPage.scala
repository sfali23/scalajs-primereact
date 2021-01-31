package com.alphasystem.primereact.demo.pages

import com.alphasystem.primereact.demo.components.menubar.{
  MenubarDemoDocs,
  MenubarShowcase
}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

object MenubarPage extends ScalaCssReactImplicits {

  case class Backend(b: BackendScope[Unit, Unit]) {

    def render: VdomElement = {
      div(
        div(cls := "content-section introduction")(
          div(cls := "feature-intro")(
            h1("Menubar"),
            p(
              "Menubar is a horizontal menu component."
            )
          )
        ), // end of "introduction",
        MenubarShowcase(),
        MenubarDemoDocs()
      )
    }
  }

  private val component = ScalaComponent
    .builder[Unit]("MenubarPage")
    .renderBackend[Backend]
    .build

  def apply(): VdomElement = component()
}
