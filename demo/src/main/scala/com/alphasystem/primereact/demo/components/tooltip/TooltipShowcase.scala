package com.alphasystem.primereact.demo.components.tooltip

import com.alphasystem.primereact.component.button.ButtonBuilder
import com.alphasystem.primereact.component.inputtext.InputText
import com.alphasystem.primereact.component.tooltip.{
  Position,
  Tooltip,
  TooltipOptions
}
import com.alphasystem.primereact.icons.Icon
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

object TooltipShowcase extends ScalaCssReactImplicits {

  final case class State(saveBtnTooltipText: String = "Click to proceed")

  case class Backend(b: BackendScope[Unit, State]) {

    private def onErrorHandler(event: ReactEventFromInput) = Callback {
      event.target.src =
        "https://www.primefaces.org/wp-content/uploads/2020/05/placeholder.png"
    }

    private val dataPrTooltip = VdomAttr("data-pr-tooltip")

    def render(state: State): VdomElement =
      div(cls := "content-section implementation")(
        div(cls := "card")(
          h5("Positions"),
          div(cls := "p-grid p-fluid")(
            div(cls := "p-col-12 p-md-3")(
              InputText(tooltip = "Enter your username")(
                `type` := "text",
                placeholder := "Right"
              )
            ),
            div(cls := "p-col-12 p-md-3")(
              InputText(
                tooltip = "Enter your username",
                tooltipOptions = TooltipOptions(position = Position.Top)
              )(
                `type` := "text",
                placeholder := "Top"
              )
            ),
            div(cls := "p-col-12 p-md-3")(
              InputText(
                tooltip = "Enter your username",
                tooltipOptions = TooltipOptions(position = Position.Bottom)
              )(
                `type` := "text",
                placeholder := "Bottom"
              )
            ),
            div(cls := "p-col-12 p-md-3")(
              InputText(
                tooltip = "Enter your username",
                tooltipOptions = TooltipOptions(position = Position.Left)
              )(
                `type` := "text",
                placeholder := "Left"
              )
            )
          ),
          h5("Focus and Blur"),
          InputText(
            tooltip = "Enter your username",
            tooltipOptions = TooltipOptions(event = "focus")
          )(
            `type` := "text",
            placeholder := "Focus"
          ),
          h5("Button"),
          ButtonBuilder()
            .label("Save")
            .icon(Icon.Check)
            .tooltip(state.saveBtnTooltipText)
            .toButton(
              onClick --> b.modState(_.copy(saveBtnTooltipText = "Completed"))
            ),
          h5("MouseTrack"),
          div(cls := "p-d-flex p-ai-center")(
            ButtonBuilder()
              .label("Save")
              .icon(Icon.Check)
              .tooltip("Save")
              .tooltipOptions(
                TooltipOptions(
                  position = Position.Bottom,
                  mouseTrack = true,
                  mouseTrackTop = 15
                )
              )
              .toButton(`type` := "button"),
            Tooltip(
              Tooltip
                .props(
                  target = ".logo",
                  mouseTrack = true,
                  mouseTrackLeft = 10
                )
            ),
            img(
              cls := "logo p-ml-2",
              alt := "logo",
              src := "./assets/images/logo.png",
              height := "80px",
              onError ==> onErrorHandler,
              dataPrTooltip := "PrimeReact-Logo"
            ),
            div(
              cls := "logo",
              dataPrTooltip := "This is a div element with same class name as image",
              width := "50px",
              height := "50px",
              border := "1px solid black",
              textAlign.center
            )(
              "div"
            )
          )
        )
      )
  }

  private val component = ScalaComponent
    .builder[Unit]("TooltipShowcase")
    .initialState(State())
    .renderBackend[Backend]
    .build

  def apply(): VdomElement = component()
}
