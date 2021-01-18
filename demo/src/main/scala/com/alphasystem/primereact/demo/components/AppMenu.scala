package com.alphasystem.primereact.demo.components

import com.alphasystem.primereact.demo.components.`app-menu`._
import com.alphasystem.primereact.demo.css.DemoStyles
import japgolly.scalajs.react.Ref.Simple
import japgolly.scalajs.react.component.Scala.Unmounted
import japgolly.scalajs.react.feature.ReactFragment
import japgolly.scalajs.react.vdom.all._
import japgolly.scalajs.react.{
  BackendScope,
  CallbackTo,
  ReactEventFromHtml,
  Ref,
  ScalaComponent
}
import org.scalajs.dom.html.Anchor
import scalacss.ScalaCssReactImplicits

object AppMenu extends ScalaCssReactImplicits {

  case class Props()

  case class State(ref: Option[Simple[Anchor]] = None) {

    def doNothing(): State = {
      this
    }
  }

  case class Backend(b: BackendScope[Props, State]) {

    private def renderLink(
      item: MenuItemModel
    ): VdomElement = {
      val badgeContent =
        item.badge match {
          case Some(value) =>
            var classNames =
              List(
                "layout-menu-badge",
                "p-tag",
                "p-tag-rounded",
                "p-ml-2",
                "p-text-uppercase",
                value,
                if (value == "new") "p-tag-success" else "p-tag-info"
              ).mkString(" ")
            span(cls := classNames)(value)
          case None => span()
        }

      val content = ReactFragment(item.name, badgeContent)

      val resultLink =
        if (item.href.isDefined) {
          a(
            role := "menuitem",
            href := item.href.get,
            target := "_blank",
            rel := "noopener noreferrer"
          )(content)
        } else if (item.to.isEmpty) {
          button(cls := "p-link")(content, onClick ==> toggleSubmenu(item.name))
        } else {
          a(role := "menuitem", href := item.to.get)(content)
        }
      resultLink
    }

    private def renderCategorySubmenuItems(
      item: MenuItemModel,
      submenuKey: String
    ): VdomElement = {
      val listItems =
        item.children.zipWithIndex.map { case (model, index) =>
          li(role := "menuitem", key := s"menuitem_${submenuKey}_$index")(
            renderLink(model)
          )
        }
      div(cls := "p-toggleable-content")(
        ul(role := "menu")(
          listItems: _*
        )
      )
    }

    private def renderCategoryItem(
      item: MenuItemModel,
      menuitemIndex: Long
    ) = {
      item.children.zipWithIndex.map { case (model, index) =>
        val submenuKey = s"${menuitemIndex}_$index"
        val link = renderLink(model)
        val submenus =
          if (model.children.nonEmpty)
            renderCategorySubmenuItems(model, submenuKey)
          else span("")
        ReactFragment.withKey(s"menuitem_$submenuKey")(link, submenus)
      }
    }

    private def renderCategoryItems = {
      `app-menu`.data.zipWithIndex.map { case (model, index) =>
        val categoryItem = renderCategoryItem(model, index)
        ReactFragment.withKey(s"category_$index")(
          div(cls := "menu-category")(model.name),
          div(cls := "menu-items")(categoryItem: _*)
        )
      }
    }

    private def toggleSubmenu(
      itemName: String
    )(event: ReactEventFromHtml
    ): CallbackTo[Unit] = {
      //TODO:
      println(s">>>> $itemName")
      event.preventDefault()
      b.modState(_.doNothing())
    }

    def render(props: Props, state: State): VdomElement = {
      div(cls := "layout-sidebar", role := "navigation")(
        div(cls := "layout-menu", role := "menubar")(
          renderCategoryItems: _*
        )
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
