package com.alphasystem.primereact.demo.components.menu

import com.alphasystem.primereact.component.tabview.{ TabPanel, TabView }
import com.alphasystem.primereact.demo.components.CodeHighlighter
import com.alphasystem.primereact.demo.{ importExample, routerLink }
import japgolly.scalajs.react._
import japgolly.scalajs.react.feature.ReactFragment
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

object MenuDemoDocs extends ScalaCssReactImplicits {

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
            subMenuExample
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
            |  new MenuItem {
            |    override val label: String = "New"
            |    override val icon: UndefOr[String] = Icon.Plus.toClassName
            |  },
            |  new MenuItem {
            |    override val label: String = "Delete"
            |    override val icon: UndefOr[String] = Icon.Trash.toClassName
            |  }
            |)
            |""".stripMargin
        )
      )

    private def subMenuExample =
      ReactFragment(
        h5("SubMenus"),
        p("Menu supports one level of nesting via subitems of an item."),
        CodeHighlighter()(s"""
                             |val items: js.Array[MenuItem] = js.Array(
                             |    new MenuItem {
                             |      override val label: String = "Options"
                             |
                             |      override val items: UndefOr[js.Array[MenuItem]] =
                             |        js.Array(
                             |          new MenuItem {
                             |            override val label: String = "Update"
                             |            override val icon: UndefOr[String] = Icon.Refresh.toClassName
                             |            override def command(): Unit = println(label)
                             |          },
                             |          new MenuItem {
                             |            override val label: String = "Delete"
                             |            override val icon: UndefOr[String] = Icon.Times.toClassName
                             |            override def command(): Unit = println(label)
                             |          }
                             |        )
                             |    },
                             |    new MenuItem {
                             |      override val label: String = "Navigate"
                             |
                             |      override val items: UndefOr[js.Array[MenuItem]] =
                             |        js.Array(
                             |          new MenuItem {
                             |            override val label: String = "React Website"
                             |            override val icon: UndefOr[String] = Icon.ExternalLink.toClassName
                             |            override val url: UndefOr[String] = "https://reactjs.org/"
                             |          },
                             |          new MenuItem {
                             |            override val label: String = "Router"
                             |            override val icon: UndefOr[String] = Icon.Upload.toClassName
                             |
                             |            override def command(): Unit = window.location.hash =
                             |              "/#/fileupload"
                             |          }
                             |        )
                             |    }
                             |  )
                             |""".stripMargin)
      )
  }

  private val component = ScalaComponent
    .builder[Unit]("MenuDemoDocs")
    .renderBackend[Backend]
    .build

  def apply(): VdomElement = component()
}
