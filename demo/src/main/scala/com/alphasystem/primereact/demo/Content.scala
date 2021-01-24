package com.alphasystem.primereact.demo

import com.alphasystem.primereact.demo.router.AppRouter
import japgolly.scalajs.react.{ BackendScope, ScalaComponent }
import japgolly.scalajs.react.vdom.all._

object Content {

  case class State(globalState: GlobalState = GlobalState())

  case class Backend(b: BackendScope[_, State]) {

    def render(s: State): VdomElement =
      GlobalState.ctx.provide(s.globalState) {
        div(AppRouter.router())
      }
  }

  private val component = ScalaComponent
    .builder[Unit]("content")
    .initialState(State())
    .renderBackend[Backend]
    .build

  def apply(): VdomElement = component()
}
