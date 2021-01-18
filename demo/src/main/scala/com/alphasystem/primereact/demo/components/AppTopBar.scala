package com.alphasystem.primereact.demo.components

import com.alphasystem.primereact.demo.css.DemoStyles
import com.alphasystem.primereact.icons.Icon
import japgolly.scalajs.react.component.Scala.Unmounted
import japgolly.scalajs.react.{ BackendScope, ScalaComponent }
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

object AppTopBar extends ScalaCssReactImplicits {

  case class Props()

  case class State()

  case class Backend(b: BackendScope[Props, State]) {

    def render(props: Props, state: State): VdomElement = {
      div(cls := "layout-topbar")(
        button(
          cls := "p-link menu-button",
          aria.haspopup := true,
          aria.label := "Menu"
        )(i(cls := Icon.Bars.toClassName)),
        div(
          DemoStyles.imageRow,
          a(cls := "logo", href := "/")(
            DemoStyles.imageColumn,
            img(
              alt := "PrimeReact logo",
              src := "./assets/images/primereact-logo-dark.png",
              width := "80"
            )
          ),
          a(cls := "logo", href := "/")(
            DemoStyles.imageColumn,
            img(
              alt := "Scalajs logo",
              src := "./assets/images/scala-js-site-logo.svg",
              width := "80"
            )
          )
        )
      )
    }
  }

  private val component = ScalaComponent
    .builder[Props]("AppTopBar")
    .initialState(State())
    .renderBackend[Backend]
    .build

  def apply(): Unmounted[Props, State, Backend] = component(Props())
}
