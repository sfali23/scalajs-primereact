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
              |import com.alphasystem.primereact.component.menumodel.MenuItem
              |
              |val items = js.Array(
              |      new MenuItem {
              |        override val label: String = "Options"
              |
              |        override val items: UndefOr[js.Array[MenuItem]] =
              |          js.Array(
              |            new MenuItem {
              |              override val label: String = "Update"
              |              override val icon: UndefOr[String] = Icon.Refresh.toClassName
              |              override def command(): Unit = println(label)
              |            },
              |            new MenuItem {
              |              override val label: String = "Delete"
              |              override val icon: UndefOr[String] = Icon.Times.toClassName
              |              override def command(): Unit = println(label)
              |            }
              |          )
              |      },
              |      new MenuItem {
              |        override val label: String = "Navigate"
              |
              |        override val items: UndefOr[js.Array[MenuItem]] =
              |          js.Array(
              |            new MenuItem {
              |              override val label: String = "React Website"
              |              override val icon: UndefOr[String] = Icon.ExternalLink.toClassName
              |              override val url: UndefOr[String] = "https://reactjs.org/"
              |            },
              |            new MenuItem {
              |              override val label: String = "Router"
              |              override val icon: UndefOr[String] = Icon.Upload.toClassName
              |
              |              override def command(): Unit = window.location.hash =
              |                "/#/fileupload"
              |            }
              |          )
              |      }
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
