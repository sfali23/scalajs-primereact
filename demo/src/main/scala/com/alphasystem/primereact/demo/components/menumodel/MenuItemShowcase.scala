package com.alphasystem.primereact.demo.components.menumodel

import com.alphasystem.primereact.demo.components.CodeHighlighter
import japgolly.scalajs.react.vdom.all._
import japgolly.scalajs.react.{ BackendScope, ScalaComponent }
import scalacss.ScalaCssReactImplicits

object MenuItemShowcase extends ScalaCssReactImplicits {

  case class Backend(b: BackendScope[Unit, Unit]) {

    def render: VdomElement = {
      div()(
        div(cls := "content-section introduction")(
          div(cls := "feature-intro")(
            h1("MenuModel API"),
            p(
              "PrimeReact menus components share a common api to specify the menuitems and submenus."
            )
          )
        ),
        div(cls := "content-section documentation")(
          h3("MenuItem"),
          p("""Core of the API is the MenuItem class that defines various options such as the label, icon and children
              | of an item in a menu.""".stripMargin),
          CodeHighlighter()(
            """
              |package com.alphasystem.primereact.component.menumodel
              |
              |import scala.scalajs.js
              |
              |abstract class MenuItem extends js.Object {
              |  val label: js.UndefOr[String] = js.undefined
              |  val icon: js.UndefOr[String] = js.undefined
              |  val url: js.UndefOr[String] = js.undefined
              |  val disabled: js.UndefOr[Boolean] = js.undefined
              |  val target: js.UndefOr[String] = js.undefined
              |  val className: js.UndefOr[String] = js.undefined
              |  val separator: js.UndefOr[Boolean] = js.undefined
              |  val style: js.UndefOr[js.Any] = js.undefined
              |  val template: js.UndefOr[js.Any] = js.undefined
              |  val items: js.UndefOr[js.Array[MenuItem]] = js.undefined
              |  def command(): Unit = js.undefined
              |}
              |""".stripMargin
          ),
          h5("Builder API"),
          p(
            span("In order to facilitate the constructing of "),
            code("MenuItem"),
            span(" a "),
            code("MenuItemModelBuilder"),
            span(" is provided, following illustrate how to use "),
            code("MenuItemModelBuilder"),
            span(" to build "),
            code("MenuItem"),
            span(".")
          ),
          CodeHighlighter()(
            """
              |import com.alphasystem.primereact.component.menumodel.MenuItemModelBuilder
              |
              |private val updateMenuItem = MenuItemModelBuilder()
              |    .label("Update")
              |    .icon(Icon.Refresh)
              |    .command(() => println("Update"))
              |    .toModel
              |
              |  private val deleteMenuItem = MenuItemModelBuilder()
              |    .label("Delete")
              |    .icon(Icon.Times)
              |    .command(() => println("Delete"))
              |    .toModel
              |
              |  private val optionsMenuItem = MenuItemModelBuilder()
              |    .label("Options")
              |    .item(updateMenuItem, deleteMenuItem)
              |    .toModel
              |
              |  private val reactMenuItem = MenuItemModelBuilder()
              |    .label("React Website")
              |    .icon(Icon.ExternalLink)
              |    .url("https://reactjs.org/")
              |    .toModel
              |
              |  private val routerMenuItem = MenuItemModelBuilder()
              |    .label("Router")
              |    .icon(Icon.Upload)
              |    .command(() => window.location.hash = "/#/fileupload")
              |    .toModel
              |
              |  private val navigateMenuItem = MenuItemModelBuilder()
              |    .label("Navigate")
              |    .item(reactMenuItem, routerMenuItem)
              |    .toModel
              |
              |  val items =
              |    js.Array(
              |      optionsMenuItem,
              |      navigateMenuItem
              |    )
              |""".stripMargin
          )
        )
      )
    }
  }

  private val component = ScalaComponent
    .builder[Unit]("MenuItemShowcase")
    .renderBackend[Backend]
    .build

  def apply(): VdomElement = component()
}
