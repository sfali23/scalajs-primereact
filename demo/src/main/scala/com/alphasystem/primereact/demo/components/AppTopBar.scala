package com.alphasystem.primereact.demo.components

import com.alphasystem.primereact.demo.css.DemoStyles
import com.alphasystem.primereact.icons.Icon
import com.alphasystem.rtg.{ CSSTransition, Timeout }
import japgolly.scalajs.react.extra.OnUnmount
import japgolly.scalajs.react.vdom.all._
import japgolly.scalajs.react.{
  BackendScope,
  Callback,
  CallbackTo,
  ReactEventFromInput,
  Ref,
  ScalaComponent
}
import org.scalajs.dom.{ document, html }
import scalacss.ScalaCssReactImplicits

import scala.scalajs.js

object AppTopBar extends ScalaCssReactImplicits {

  private val themeLogoMap = Map(
    "bootstrap4-light-blue"   -> "bootstrap4-light-blue.svg",
    "bootstrap4-light-purple" -> "bootstrap4-light-purple.svg",
    "bootstrap4-dark-blue"    -> "bootstrap4-dark-blue.svg",
    "bootstrap4-dark-purple"  -> "bootstrap4-dark-purple.svg",
    "md-light-indigo"         -> "md-light-indigo.svg",
    "md-light-deeppurple"     -> "md-light-deeppurple.svg",
    "md-dark-indigo"          -> "md-dark-indigo.svg",
    "md-dark-deeppurple"      -> "md-dark-deeppurple.svg",
    "mdc-light-indigo"        -> "md-light-indigo.svg",
    "mdc-light-deeppurple"    -> "md-light-deeppurple.svg",
    "mdc-dark-indigo"         -> "md-dark-indigo.svg",
    "mdc-dark-deeppurple"     -> "md-dark-deeppurple.svg",
    "saga-blue"               -> "saga-blue.png",
    "saga-green"              -> "saga-green.png",
    "saga-orange"             -> "saga-orange.png",
    "saga-purple"             -> "saga-purple.png",
    "vela-blue"               -> "vela-blue.png",
    "vela-green"              -> "vela-green.png",
    "vela-orange"             -> "vela-orange.png",
    "vela-purple"             -> "vela-purple.png",
    "arya-blue"               -> "arya-blue.png",
    "arya-green"              -> "arya-green.png",
    "arya-orange"             -> "arya-orange.png",
    "arya-purple"             -> "arya-purple.png",
    "nova"                    -> "nova.png",
    "nova-alt"                -> "nova-alt.png",
    "nova-accent"             -> "nova-accent.png",
    "luna-blue"               -> "luna-blue.png",
    "luna-green"              -> "luna-green.png",
    "luna-pink"               -> "luna-pink.png",
    "luna-amber"              -> "luna-amber.png",
    "rhea"                    -> "rhea.png",
    "fluent-light"            -> "fluent-light.png",
    "soho-light"              -> "soho-light.png",
    "soho-dark"               -> "soho-dark.png",
    "viva-light"              -> "viva-light.svg",
    "viva-dark"               -> "viva-dark.svg",
    "mira"                    -> "mira.jpg",
    "nano"                    -> "nano.jpg"
  )

  case class Props(
    theme: String,
    darkTheme: Boolean,
    onThemeChange: js.Function1[ThemeChangeEvent, _])

  case class State(activeMenuIndex: Int = -1) {

    def toggleMenu(index: Int): State = copy(activeMenuIndex = index)
  }

  case class Backend(b: BackendScope[Props, State]) extends OnUnmount {

    private val topbarMenu = Ref[html.UList]

    //format: off
    private var outsideClickListener: Option[js.Function1[ReactEventFromInput, _]] = None
    
    private def toggleMenu(index: Int)
                          (event: ReactEventFromInput) = {
      b.modState(_.toggleMenu(index)) >> CallbackTo{event.preventDefault()}
    }
    

    private def isOutsideTopbarMenuClicked(event: ReactEventFromInput) = 
      topbarMenu
        .get
        .map { r =>
          !(r.isSameNode(event.target) || r.contains(event.target))
        }

    private def onThemeChange(theme: String, dark: Boolean)
                             (event: ReactEventFromInput) =
      b.props.map(p => p.onThemeChange(ThemeChangeEvent(event, theme, dark))) >> 
          b.modState(_.toggleMenu(-1))
    // format: on

    private def bindOutsideClickListener(): Unit = {
      if (outsideClickListener.isEmpty) {
        val event = (e: ReactEventFromInput) => {
          isOutsideTopbarMenuClicked(e)
            .map { v =>
              if (v) {
                b.modState(_.toggleMenu(-1)).runNow()
                true
              } else false
            }
            .getOrElse(false)
            .runNow()
        }
        outsideClickListener = Some(event)

        document
          .addEventListener(
            "click",
            outsideClickListener.get
          )
      }
    }

    def unbindOutsideClickListener(): Callback = Callback {
      if (outsideClickListener.isDefined) {
        document.removeEventListener("click", outsideClickListener.get)
        outsideClickListener = None
      }
    }

    private def onMenuEnter(): Unit = bindOutsideClickListener()

    private def themeLink(name: String, theme: String, dark: Boolean = false) =
      li(role := "none")(
        button(
          `type` := "button",
          cls := "p-link",
          role := "menuitem"
        )(
          onClick ==> onThemeChange(theme, dark),
          img(
            alt := name,
            src := s"./assets/images/themes/${themeLogoMap(theme)}"
          ),
          span(name)
        )
      )

    def render(props: Props, state: State): VdomElement = {
      val logoType = if (props.darkTheme) "" else "-dark"
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
              src := s"./assets/images/primereact-logo$logoType.png",
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
        ), // end of "logos"
        div(cls := "app-theme")(
          img(
            alt := props.theme,
            src := s"./assets/images/themes/${themeLogoMap(props.theme)}"
          )
        ), // end of theme logo div
        ul(cls := "topbar-menu p-unselectable-text", role := "menubar")(
          li(role := "none")(
            a(
              href := "/#/setup",
              role := "menuitem",
              cls := "topbar-root-link",
              aria.haspopup := false
            )("Get Started")
          ),
          li(role := "none", cls := "topbar-submenu")(
            button(
              `type` := "button",
              id := "themes",
              role := "menuitem",
              aria.haspopup := true,
              aria.expanded := state.activeMenuIndex == 0,
              cls := "p-link"
            )("Themes")(onClick ==> toggleMenu(0)),
            CSSTransition(
              classNames = "p-connected-overlay",
              in = state.activeMenuIndex == 0,
              unmountOnExit = true,
              onEntered = onMenuEnter(),
              timeout = Timeout(enter = Some(120), exit = Some(100))
            )(
              ul(role := "menu", aria.label := "Themes")(
                li(cls := "topbar-submenu-header", role := "none")("BOOTSTRAP"),
                themeLink("Blue Light", "bootstrap4-light-blue"),
                themeLink("Purple Light", "bootstrap4-light-purple"),
                themeLink("Blue Dark", "bootstrap4-dark-blue", dark = true),
                themeLink("Purple Dark", "bootstrap4-dark-purple", dark = true),
                //
                li(cls := "topbar-submenu-header", role := "none")(
                  "MATERIAL DESIGN"
                ),
                themeLink("Indigo Light", "md-light-indigo"),
                themeLink("Deep Purple Light", "md-light-deeppurple"),
                themeLink("Indigo Dark", "md-dark-indigo", dark = true),
                themeLink(
                  "Deep Purple Dark",
                  "md-dark-deeppurple",
                  dark = true
                ),
                //
                li(cls := "topbar-submenu-header", role := "none")(
                  "MATERIAL DESIGN COMPACT"
                ),
                themeLink("Indigo Light", "mdc-light-indigo"),
                themeLink("Deep Purple Light", "mdc-light-deeppurple"),
                themeLink("Indigo Dark", "mdc-dark-indigo", dark = true),
                themeLink(
                  "Deep Purple Dark",
                  "mdc-dark-deeppurple",
                  dark = true
                ),
                //
                li(cls := "topbar-submenu-header", role := "none")("FLUENT UI"),
                themeLink("Fluent Light", "fluent-light"),
                //
                li(cls := "topbar-submenu-header", role := "none")("PRIMEONE"),
                themeLink("Saga Blue", "saga-blue"),
                themeLink("Saga Green", "saga-green"),
                themeLink("Saga Orange", "saga-orange"),
                themeLink("Saga Purple", "saga-purple"),
                themeLink("Vela Blue", "vela-blue", dark = true),
                themeLink("Vela Green", "vela-green", dark = true),
                themeLink("Vela Orange", "vela-orange", dark = true),
                themeLink("Vela Purple", "vela-purple", dark = true),
                themeLink("Arya Blue", "arya-blue", dark = true),
                themeLink("Arya Green", "arya-green", dark = true),
                themeLink("Arya Orange", "arya-orange", dark = true),
                themeLink("Arya Purple", "arya-purple", dark = true),
                //
                li(cls := "topbar-submenu-header", role := "none")("PREMIUM"),
                themeLink("Soho Light", "soho-light"),
                themeLink("Soho Dark", "soho-dark", dark = true),
                themeLink("Viva Light", "viva-light"),
                themeLink("Viva Dark", "viva-dark", dark = true),
                themeLink("Mira", "mira"),
                themeLink("Nano", "nano"),
                //
                li(cls := "topbar-submenu-header", role := "none")("LEGACY"),
                themeLink("Nova", "nova"),
                themeLink("Nova Alt", "nova-alt"),
                themeLink("Nova Accent", "nova-accent"),
                themeLink("Luna Amber", "luna-amber", dark = true),
                themeLink("Luna Blue", "luna-blue", dark = true),
                themeLink("Luna Green", "luna-green", dark = true),
                themeLink("Luna Pink", "luna-pink", dark = true),
                themeLink("Rhea", "rhea")
              ) // end "Themes" submenu
            ) // end of CSSTransition
          ) // end of li "topbar-submenu"
        ).withRef(topbarMenu) // end of menus
      ) // end of top div
    }
  }

  private val component = ScalaComponent
    .builder[Props]("AppTopBar")
    .initialState(State())
    .renderBackend[Backend]
    .componentWillUnmount(_.backend.unbindOutsideClickListener())
    .build

  def apply(
    theme: String,
    darkTheme: Boolean,
    onThemeChange: js.Function1[ThemeChangeEvent, _]
  ): VdomElement = component(
    Props(theme, darkTheme, onThemeChange)
  )
}
