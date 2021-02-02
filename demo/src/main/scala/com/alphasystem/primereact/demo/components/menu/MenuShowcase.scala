package com.alphasystem.primereact.demo.components.menu

import com.alphasystem.primereact.component.button.ButtonBuilder
import com.alphasystem.primereact.component.menu.Menu
import com.alphasystem.primereact.component.toast.{ Position, Toast }
import com.alphasystem.primereact.icons.Icon
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

object MenuShowcase extends ScalaCssReactImplicits {

  case class Backend(b: BackendScope[Unit, Unit]) {

    private val toastRef = Toast.toRef
    private lazy val menuItems = items(toastRef)

    def render: VdomElement = {
      div(cls := "content-section implementation")(
        Toast().withRef(toastRef)(Toast.props(position = Position.TopCenter)),
        div(cls := "card")(
          h5("Inline"),
          Menu(model = menuItems),
          //
          h5("Overlay"),
          Menu(model = menuItems, id = "popup_menu", popup = true),
          ButtonBuilder()
            .label("Show")
            .icon(Icon.Bars)
            .toButton(aria.controls := "popup_menu", aria.haspopup := true)
          //TODO: find out how to get the ref
        )
      )
    }

  }

  private val component = ScalaComponent
    .builder[Unit]("MenuShowcase")
    .renderBackend[Backend]
    .build

  def apply(): VdomElement = component()
}
