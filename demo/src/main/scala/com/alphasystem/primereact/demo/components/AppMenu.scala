package com.alphasystem.primereact.demo.components

import japgolly.scalajs.react.component.Scala.Unmounted
import japgolly.scalajs.react.{ BackendScope, ScalaComponent }
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

object AppMenu extends ScalaCssReactImplicits {

  case class Props()

  case class State()

  case class Backend(b: BackendScope[Props, State]) {

    def render(props: Props, state: State): VdomElement = {
      div(cls := "layout-sidebar", role := "navigation")(
        h3("This is menu")
      )
    }
  }

  private val component = ScalaComponent
    .builder[Props]("AppMenu")
    .initialState(State())
    .renderBackend[Backend]
    .build

  def apply(): Unmounted[Props, State, Backend] = component(Props())
}
