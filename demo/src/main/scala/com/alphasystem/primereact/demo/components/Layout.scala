package com.alphasystem.primereact.demo.components

import com.alphasystem.primereact.demo.router.AppRouter.Page
import japgolly.scalajs.react._
import japgolly.scalajs.react.component.Scala.Unmounted
import japgolly.scalajs.react.extra.router.{ Resolution, RouterCtl }
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

object Layout extends ScalaCssReactImplicits {

  case class Props(router: RouterCtl[Page], r: Resolution[Page])

  case class State()

  class Backend(t: BackendScope[Props, State]) {

    def render(props: Props, state: State): VdomElement = {
      div(cls := "layout-wrapper")(
        AppTopBar(),
        AppMenu(),
        div(cls := "layout-content")(
          props.r.render()
        ) // end of "layout-content"
      ) // end of "layout-wrapper"
    }
  } // end of class "Backend"

  private val component = ScalaComponent
    .builder[Props]("Layout")
    .initialState(State())
    .renderBackend[Backend]
    .build

  def apply(
    router: RouterCtl[Page],
    r: Resolution[Page]
  ): Unmounted[Props, State, Backend] = component(Props(router, r))
}
