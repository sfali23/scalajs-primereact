package com.alphasystem.primereact.demo.components.menu

import com.alphasystem.primereact.component.tabview.{ TabPanel, TabView }
import com.alphasystem.primereact.demo.components.CodeHighlighter
import com.alphasystem.primereact.demo.{
  SourceCodeLink,
  importExample,
  routerLink
}
import japgolly.scalajs.react._
import japgolly.scalajs.react.feature.ReactFragment
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

object MenuDemoDocs extends ScalaCssReactImplicits with SourceCodeLink {

  case class Backend(b: BackendScope[Unit, Unit]) {

    def render: VdomElement = {
      div(cls := "content-section documentation")(
        TabView()(
          TabPanel(header = "Documentation")(
            importExample("com.alphasystem.primereact.component.menu.Menu"),
            h5("MenuModel API"),
            p(
              span(
                "Menu uses the common menumodel api to define its items, visit "
              ),
              routerLink("MenuModel API", "menumodel"),
              span(" for details.")
            ),
            gettingStartedExample,
            subMenuExample,
            sourceCodeLink("MenuPage.scala", "menu/MenuShowcase.scala")
          )
        )
      )
    }

    private def gettingStartedExample =
      ReactFragment(
        h5("Getting Started"),
        p("Menu requires a collection of menuitems as its model."),
        CodeHighlighter()(
          """
            |Menu(model = items)
            |""".stripMargin
        ),
        CodeHighlighter()(
          """
            |val items = js.Array(
            |  MenuItemModelBuilder()
            |    .label("New")
            |    .icon(Icon.Plus)
            |    .toModel,
            |  MenuItemModelBuilder()
            |    .label("Delete")
            |    .icon(Icon.Trash)
            |    .toModel,
            |)
            |""".stripMargin
        )
      )

    private def subMenuExample =
      ReactFragment(
        h5("SubMenus"),
        p("Menu supports one level of nesting via subitems of an item."),
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
  }

  private val component = ScalaComponent
    .builder[Unit]("MenuDemoDocs")
    .renderBackend[Backend]
    .build

  def apply(): VdomElement = component()
}
