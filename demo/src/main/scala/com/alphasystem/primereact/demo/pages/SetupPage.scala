package com.alphasystem.primereact.demo.pages

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

object SetupPage extends ScalaCssReactImplicits {

  case class Props()

  case class State()

  case class Backend(b: BackendScope[Props, State]) {

    def render(props: Props, state: State): VdomElement = {
      div()(
        h1("Setup page")
      )
    }
  }

  private val component = ScalaComponent
    .builder[Props]("SetupPage")
    .initialState(State())
    .renderBackend[Backend]
    .build

  def apply(): VdomElement = component(Props())
}
