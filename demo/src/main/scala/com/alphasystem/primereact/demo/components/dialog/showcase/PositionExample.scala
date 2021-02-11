package com.alphasystem.primereact.demo.components.dialog.showcase

import com.alphasystem.primereact.component.button.{ ButtonBuilder, Severity }
import com.alphasystem.primereact.component.dialog.{ Dialog, Position }
import com.alphasystem.primereact.demo.components.dialog.DialogShowcase
import com.alphasystem.primereact.icons.Icon
import japgolly.scalajs.react._
import japgolly.scalajs.react.feature.ReactFragment
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

object PositionExample extends ScalaCssReactImplicits {

  final case class State(
    dialogVisibility: Boolean = false,
    displayPosition: Position = Position.Center) {

    def hide: State = copy(dialogVisibility = false)

    def updatePosition(position: Position): State =
      copy(dialogVisibility = true, displayPosition = position)
  }

  case class Backend(b: BackendScope[Unit, State]) {

    private def clickHandler(position: Position): Callback =
      b.modState(_.updatePosition(position))

    private def hideHandler: Callback = b.modState(_.hide)

    def render(state: State): VdomElement =
      ReactFragment(
        div(cls := "p-grid p-dir-col")(
          div(cls := "p-col")(
            createButton("Left", Icon.ArrowRight, Position.Left),
            createButton("Right", Icon.ArrowLeft, Position.Right)
          ),
          div(cls := "p-col")(
            createButton("Top", Icon.ArrowDown, Position.Top),
            createButton("TopLeft", Icon.ArrowDown, Position.TopLeft),
            createButton("TopRight", Icon.ArrowDown, Position.TopRight)
          ),
          div(cls := "p-col")(
            createButton("Bottom", Icon.ArrowUp, Position.Bottom),
            createButton("BottomLeft", Icon.ArrowUp, Position.BottomLeft),
            createButton("BottomRight", Icon.ArrowUp, Position.BottomRight)
          )
        ),
        Dialog(
          header = "Header",
          visible = state.dialogVisibility,
          position = state.displayPosition,
          footer = DialogShowcase.renderFooter(hideHandler),
          onHide = () => hideHandler,
          style = Style(width = "50vw")
        )(
          p(cls := "p-m-0")(
            """Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et 
              |dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip 
              |ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore 
              |eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia 
              |deserunt mollit anim id est laborum.""".stripMargin
          )
        )
      )

    private def createButton(label: String, icon: Icon, position: Position) =
      ButtonBuilder()
        .label(label)
        .icon(icon)
        .severity(Severity.Warning)
        .toButton(onClick --> clickHandler(position))
  }

  private val component = ScalaComponent
    .builder[Unit]("PositionExample")
    .initialState(State())
    .renderBackend[Backend]
    .build

  def apply(): VdomElement = component()
}
