package com.alphasystem.primereact.demo.components

import com.alphasystem.primereact.component.menumodel.MenuItemModelBuilder
import com.alphasystem.primereact.icons.Icon
import typings.std.global.window

import scala.scalajs.js

package object menu {

  private val updateMenuItem = MenuItemModelBuilder()
    .label("Update")
    .icon(Icon.Refresh)
    .command(() => println("Update"))
    .toModel

  private val deleteMenuItem = MenuItemModelBuilder()
    .label("Delete")
    .icon(Icon.Times)
    .command(() => println("Delete"))
    .toModel

  private val optionsMenuItem = MenuItemModelBuilder()
    .label("Options")
    .item(updateMenuItem, deleteMenuItem)
    .toModel

  private val reactMenuItem = MenuItemModelBuilder()
    .label("React Website")
    .icon(Icon.ExternalLink)
    .url("https://reactjs.org/")
    .toModel

  private val routerMenuItem = MenuItemModelBuilder()
    .label("Router")
    .icon(Icon.Upload)
    .command(() => window.location.hash = "/#/fileupload")
    .toModel

  private val navigateMenuItem = MenuItemModelBuilder()
    .label("Navigate")
    .item(reactMenuItem, routerMenuItem)
    .toModel

  private[menu] val items =
    js.Array(
      optionsMenuItem,
      navigateMenuItem
    )
}
