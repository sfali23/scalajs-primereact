package com.alphasystem.primereact.demo.components.menu

import com.alphasystem.primereact.component.button.ButtonBuilder
import com.alphasystem.primereact.component.menu.Menu
import com.alphasystem.primereact.icons.Icon
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

object MenuShowcase extends ScalaCssReactImplicits {

  case class Backend(b: BackendScope[Unit, Unit]) {

    def render: VdomElement =
      div(cls := "content-section implementation")(
        div(cls := "card")(
          h5("Inline"),
          Menu(model = items),
          //
          h5("Overlay"),
          Menu(model = items, id = "popup_menu", popup = true),
          ButtonBuilder()
            .label("Show")
            .icon(Icon.Bars)
            .toButton(aria.controls := "popup_menu", aria.haspopup := true)
          //TODO: find out how to get the ref
        )
      )
  }

  private val component = ScalaComponent
    .builder[Unit]("MenuShowcase")
    .renderBackend[Backend]
    .build

  def apply(): VdomElement = component()
}
