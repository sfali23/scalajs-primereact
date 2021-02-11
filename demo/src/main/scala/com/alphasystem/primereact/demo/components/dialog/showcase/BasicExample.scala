package com.alphasystem.primereact.demo.components.dialog.showcase

import com.alphasystem.primereact.component.button.ButtonBuilder
import com.alphasystem.primereact.component.dialog.Dialog
import com.alphasystem.primereact.demo.components.dialog.DialogShowcase
import com.alphasystem.primereact.icons.Icon
import japgolly.scalajs.react._
import japgolly.scalajs.react.feature.ReactFragment
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

object BasicExample extends ScalaCssReactImplicits {

  final case class Props(modal: Boolean)

  final case class State(dialogVisibility: Boolean = false) {

    def show: State = copy(dialogVisibility = true)

    def hide: State = copy(dialogVisibility = false)
  }

  case class Backend(b: BackendScope[Props, State]) {

    private def clickHandler(): Callback = b.modState(_.show)

    private def hideHandler: Callback = b.modState(_.hide)

    def render(props: Props, state: State): VdomElement =
      ReactFragment(
        ButtonBuilder()
          .label("Show")
          .icon(Icon.ExternalLink)
          .toButton(onClick --> clickHandler),
        Dialog(
          header = "Header",
          visible = state.dialogVisibility,
          footer = DialogShowcase.renderFooter(hideHandler),
          onHide = () => hideHandler,
          icons = icon,
          modal = props.modal,
          style = Style("50vw")
        )(
          p(
            """Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et 
              |dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip 
              |ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore 
              |eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui 
              |officia deserunt mollit anim id est laborum""".stripMargin
          )
        )
      )

    private def icon =
      button(cls := "p-dialog-titlebar-icon p-link")(
        span(cls := "pi pi-search")
      ).rawElement
  }

  private val component = ScalaComponent
    .builder[Props]("BasicExample")
    .initialState(State())
    .renderBackend[Backend]
    .build

  def apply(modal: Boolean = true): VdomElement = component(Props(modal))
}
