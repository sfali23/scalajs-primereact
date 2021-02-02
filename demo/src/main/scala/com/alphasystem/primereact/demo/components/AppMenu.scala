package com.alphasystem.primereact.demo.components

import com.alphasystem.axios.Axios
import com.alphasystem.primereact.demo.components.`app-menu`.MenuItemModel
import com.alphasystem.rtg.{ CSSTransition, Timeout }
import japgolly.scalajs.react.feature.ReactFragment
import japgolly.scalajs.react.vdom.all._
import japgolly.scalajs.react.{
  BackendScope,
  Callback,
  CallbackTo,
  ReactEventFromHtml,
  ScalaComponent
}
import scalacss.ScalaCssReactImplicits

import scala.concurrent.ExecutionContext.Implicits.global
import scala.scalajs.js

object AppMenu extends ScalaCssReactImplicits {

  type Props = Unit

  case class State(
    menu: js.Array[MenuItemModel] = js.Array(),
    activeSubmenus: Map[String, Boolean] = Map.empty) {

    def updateMenu(menu: js.Array[MenuItemModel]): State =
      copy(menu = menu)

    def toggleActiveSubMenu(name: String): State = {
      val currentValue = this.activeSubmenus.getOrElse(name, false)
      val activeSubmenus = this.activeSubmenus + (name -> !currentValue)
      copy(activeSubmenus = activeSubmenus)
    }

    def isSubmenuActive(name: String): Boolean =
      activeSubmenus.getOrElse(name, false)

    def doNothing(): State = {
      this
    }
  }

  case class Backend(b: BackendScope[Props, State]) {

    private def renderLink(
      item: MenuItemModel
    ): VdomElement = {
      val badgeContent =
        if (item.badge.isDefined) {
          val value = item.badge.get
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
        } else span()

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
        item
          .children
          .getOrElse(js.Array())
          .zipWithIndex
          .map { case (model, index) =>
            li(role := "menuitem", key := s"menuitem_${submenuKey}_$index")(
              renderLink(model)
            )
          }
          .toList

      CSSTransition(
        classNames = "p-toggleable-content",
        in = isSubmenuActive(item.name),
        timeout = Timeout(enter = Some(100), exit = Some(450)),
        unmountOnExit = true
      )(
        div(cls := "p-toggleable-content")(
          ul(role := "menu")(
            listItems: _*
          )
        )
      )
    }

    private def renderCategoryItem(
      item: MenuItemModel,
      menuitemIndex: Long
    ) = {
      item
        .children
        .getOrElse(js.Array())
        .zipWithIndex
        .map { case (model, index) =>
          val submenuKey = s"${menuitemIndex}_$index"
          val link = renderLink(model)
          val submenus =
            if (model.children.nonEmpty)
              renderCategorySubmenuItems(model, submenuKey)
            else span("")
          ReactFragment.withKey(s"menuitem_$submenuKey")(link, submenus)
        }
        .toList
    }

    private def renderCategoryItems = {
      b.state
        .map(_.menu)
        .map {
          _.zipWithIndex.map { case (model, index) =>
            val categoryItem = renderCategoryItem(model, index)
            ReactFragment.withKey(s"category_$index")(
              div(cls := "menu-category")(model.name),
              div(cls := "menu-items")(categoryItem: _*)
            )
          }
        }
        .runNow()
        .toList
    }

    private def toggleSubmenu(
      itemName: String
    )(event: ReactEventFromHtml
    ): CallbackTo[Unit] = {
      b.modState(_.toggleActiveSubMenu(itemName)) >> Callback {
        event.preventDefault()
      }
    }

    private def isSubmenuActive(name: String) =
      b.state.map(_.isSubmenuActive(name)).runNow()

    def render(state: State): VdomElement = {
      div(cls := "layout-sidebar", role := "navigation")(
        div(cls := "layout-menu", role := "menubar")(
          renderCategoryItems: _*
        )
      )
    }

    def init(): Callback = Callback {
      Axios
        .get("./assets/data/menu.json")
        .toFuture
        .map { response =>
          val data = response.data.asInstanceOf[js.Array[MenuItemModel]]
          b.modState(_.updateMenu(data)).runNow()
        }
    }
  }

  private val component = ScalaComponent
    .builder[Props]("AppMenu")
    .initialState(State())
    .renderBackend[Backend]
    .componentDidMount(_.backend.init())
    .componentDidUpdate(_.backend.init())
    .build

  def apply(): VdomElement = component()
}
