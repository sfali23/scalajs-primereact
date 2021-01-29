package com.alphasystem.primereact.demo.components.inputtext

import com.alphasystem.primereact.component.inputtext.InputText
import com.alphasystem.primereact.icons.Icon
import japgolly.scalajs.react._
import japgolly.scalajs.react.feature.ReactFragment
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

object InputTextShowcase extends ScalaCssReactImplicits {

  type Props = Unit

  final case class State(
    value1: String = "",
    value2: String = "",
    value3: String = "",
    value4: String = "",
    value5: String = "") {

    def updateValue1(newValue: String): State = copy(value1 = newValue)

    def updateValue2(newValue: String): State = copy(value2 = newValue)

    def updateValue3(newValue: String): State = copy(value3 = newValue)

    def updateValue4(newValue: String): State = copy(value4 = newValue)
  }

  final case class Backend(b: BackendScope[Props, State]) {

    def render(state: State): VdomElement =
      div(cls := "content-section implementation")(
        div(cls := "card")(
          basicExample(state),
          floatingLabelExample(state),
          leftIconExample(state),
          rightIconExample(state),
          helpExample,
          invalidExample,
          disabledExample(state),
          sizeExample
        )
      )

    private def updateValue1(e: ReactEventFromInput) =
      b.modState(_.updateValue1(e.target.value))

    private def updateValue2(e: ReactEventFromInput) =
      b.modState(_.updateValue2(e.target.value))

    private def updateValue3(e: ReactEventFromInput) =
      b.modState(_.updateValue3(e.target.value))

    private def updateValue4(e: ReactEventFromInput) =
      b.modState(_.updateValue4(e.target.value))

    private def basicExample(state: State) =
      ReactFragment(
        h5("Basic"),
        InputText()(
          value := state.value1,
          onChange ==> updateValue1
        ),
        span(cls := "p-ml-2")(state.value1)
      )

    private def floatingLabelExample(state: State) =
      ReactFragment(
        h5("Floating Label"),
        span(cls := "p-float-label")(
          InputText()(
            id := "username",
            value := state.value2,
            onChange ==> updateValue2
          ),
          label(htmlFor := "username")("Username"),
          span(cls := "p-ml-2")(state.value2)
        )
      )

    private def leftIconExample(state: State) =
      ReactFragment(
        h5("Left Icon"),
        span(cls := "p-input-icon-left")(
          i(cls := Icon.Search.toClassName),
          InputText()(
            placeholder := "Search",
            value := state.value3,
            onChange ==> updateValue3
          ),
          span(cls := "p-ml-2")(state.value3)
        )
      )

    private def rightIconExample(state: State) =
      ReactFragment(
        h5("Right Icon"),
        span(cls := "p-input-icon-right")(
          i(cls := "pi pi-spin pi-spinner"),
          InputText()(
            value := state.value4,
            onChange ==> updateValue4
          ),
          span(cls := "p-ml-2")(state.value3)
        )
      )

    private def helpExample =
      ReactFragment(
        h5("Help Text"),
        span(cls := "p-field")(
          label(htmlFor := "username1", cls := "p-d-block")("Username"),
          InputText()(
            id := "username1",
            aria.describedBy := "username1-help",
            cls := "p-d-block"
          ),
          small(id := "username1-help", cls := "p-d-block")(
            "Enter your username to reset your password."
          )
        )
      )

    private def invalidExample =
      ReactFragment(
        h5("Invalid"),
        span(cls := "p-field")(
          label(htmlFor := "username2", cls := "p-d-block")("Username"),
          InputText()(
            id := "username2",
            aria.describedBy := "username2-help",
            cls := "p-d-block"
          ),
          small(id := "username2-help", cls := "p-error p-d-block")(
            "Username is not available."
          )
        )
      )

    private def disabledExample(state: State) =
      ReactFragment(
        h5("Disabled"),
        InputText()(
          value := state.value5,
          disabled := true
        )
      )

    private def sizeExample =
      ReactFragment(
        h5("Sizes"),
        div(cls := "sizes")(
          InputText()(
            `type` := "text",
            cls := "p-inputtext-sm p-d-block p-mb-2",
            placeholder := "Small"
          ),
          InputText()(
            `type` := "text",
            cls := "p-d-block p-mb-2",
            placeholder := "Normal"
          ),
          InputText()(
            `type` := "text",
            cls := "p-inputtext-lg p-d-block p-mb-2",
            placeholder := "Large"
          )
        )
      )
  }

  private val component = ScalaComponent
    .builder[Props]("InputTextDemoShowcase")
    .initialState(State())
    .renderBackend[Backend]
    .build

  def apply(): VdomElement = component()
}
