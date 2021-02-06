package com.alphasystem.primereact.demo.pages

import com.alphasystem.primereact.demo.components.autocomplete.{
  AutoCompleteDemoDocs,
  AutoCompleteShowcase
}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

object AutoCompletePage extends ScalaCssReactImplicits {

  case class Backend(b: BackendScope[Unit, Unit]) {

    def render: VdomElement =
      div()(
        div(cls := "content-section introduction")(
          div(cls := "feature-intro")(
            h1("AutoComplete"),
            p(
              "AutoComplete is an input component that provides real-time suggestions when being typed."
            )
          )
        ),
        AutoCompleteShowcase(),
        AutoCompleteDemoDocs()
      )
  }

  private val component = ScalaComponent
    .builder[Unit]("AutoCompletePage")
    .renderBackend[Backend]
    .build

  def apply(): VdomElement = component()
}
