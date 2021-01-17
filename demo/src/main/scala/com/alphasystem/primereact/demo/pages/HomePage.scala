package com.alphasystem.primereact.demo.pages

import japgolly.scalajs.react._
import japgolly.scalajs.react.component.Scala.Unmounted
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

object HomePage extends ScalaCssReactImplicits {

  case class Props()

  case class State()

  case class Backend(b: BackendScope[Props, State]) {

    def render(props: Props, state: State): VdomElement = {
      div(cls := "home")(
        h1("Welcome to Demo")
      )
    }
  }

  private val component = ScalaComponent
    .builder[Props]("HomePage")
    .initialState(State())
    .renderBackend[Backend]
    .build

  def apply(): Unmounted[Props, State, Backend] = component(Props())
}
