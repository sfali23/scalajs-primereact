package com.alphasystem.primereact.demo.components.dialog.showcase

import com.alphasystem.primereact.component.button.ButtonBuilder
import com.alphasystem.primereact.component.dialog.Dialog
import com.alphasystem.primereact.demo.components.dialog.DialogShowcase
import com.alphasystem.primereact.icons.Icon
import japgolly.scalajs.react._
import japgolly.scalajs.react.feature.ReactFragment
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

object ConfirmationExample extends ScalaCssReactImplicits {

  final case class State(dialogVisibility: Boolean = false) {

    def show: State = copy(dialogVisibility = true)

    def hide: State = copy(dialogVisibility = false)
  }

  case class Backend(b: BackendScope[Unit, State]) {

    private def clickHandler(): Callback = b.modState(_.show)

    private def hideHandler: Callback = b.modState(_.hide)

    def render(state: State): VdomElement =
      ReactFragment(
        ButtonBuilder()
          .label("Confirm")
          .icon(Icon.ExternalLink)
          .toButton(onClick --> clickHandler),
        Dialog(
          header = "Confirmation",
          visible = state.dialogVisibility,
          footer = DialogShowcase.renderFooter(hideHandler),
          onHide = () => hideHandler,
          style = Style(width = "350px")
        )(
          div(cls := "confirmation-content")(
            i(
              cls := "pi pi-exclamation-triangle p-mr-3",
              style := Style(fontSize = "2rem")
            ),
            span("Are you sure you want to proceed?")
          )
        )
      )
  }

  private val component = ScalaComponent
    .builder[Unit]("ConfirmationExample")
    .initialState(State())
    .renderBackend[Backend]
    .build

  def apply(): VdomElement = component()
}
