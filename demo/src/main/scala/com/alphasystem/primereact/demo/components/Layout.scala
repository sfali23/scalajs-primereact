package com.alphasystem.primereact.demo.components

import com.alphasystem.primereact.demo.GlobalState
import com.alphasystem.primereact.demo.router.AppRouter.Page
import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.router.{ Resolution, RouterCtl }
import japgolly.scalajs.react.vdom.all._
import org.scalajs.dom.document
import scalacss.ScalaCssReactImplicits

object Layout extends ScalaCssReactImplicits {

  case class Props(router: RouterCtl[Page], r: Resolution[Page])

  case class State(
    theme: String = "saga-blue",
    inputStyle: String = "outlined",
    darkTheme: Boolean = false,
    themeCategory: Option[String] = None) {

    def updateTheme(
      theme: String,
      darkTheme: Boolean,
      themeCategory: Option[String]
    ): State =
      copy(theme = theme, darkTheme = darkTheme, themeCategory = themeCategory)
  }

  class Backend(b: BackendScope[Props, State]) {

    private val reg1 = "^(md-|mdc-)".r
    private val reg2 = "^(bootstrap)".r

    private def getThemCategory(text: String) = {
      if (reg1.findFirstIn(text).isDefined) Some("material")
      else if (reg2.findFirstIn(text).isDefined) Some("bootstrap")
      else None
    }

    private def onThemeChange(event: ThemeChangeEvent): Unit = {
      val themeElement = document.getElementById("theme-link")
      val theme = event.theme
      val themeCategory = getThemCategory(theme)

      b.state
        .map { state =>
          themeElement.setAttribute(
            "href",
            themeElement.getAttribute("href").replace(state.theme, theme)
          )
        }
        .flatMap { _ =>
          b.modState(_.updateTheme(theme, event.darkTheme, themeCategory))
        }
        .flatMap { _ =>
          Callback { event.originalEvent.preventDefault() }
        }
        .runNow()
    }

    private def getClassNames(state: State) = {
      var classNames = List("layout-wrapper")
      val themeCategory = state.themeCategory
      if (themeCategory.isDefined) {
        classNames :+= s"theme-${themeCategory.get}"
      }
      classNames.mkString(" ")
    }

    def render(props: Props, state: State): VdomElement = {
      val ctx = GlobalState
        .ctx
        .provide(GlobalState(state.theme, state.inputStyle, state.darkTheme))

      div(cls := getClassNames(state))(
        AppTopBar(state.theme, state.darkTheme, onThemeChange),
        AppMenu(),
        ctx(
          div(cls := "layout-content")(
            props.r.render()
          ) // end of "layout-content"
        )
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
  ): VdomElement = component(Props(router, r))
}

case class ThemeChangeEvent(
  originalEvent: ReactEventFromInput,
  theme: String,
  darkTheme: Boolean)
