package com.alphasystem.primereact.demo.components

import com.alphasystem.primereact.component.menumodel.MenuItemModelBuilder.MenuCommand
import com.alphasystem.primereact.component.menumodel.{
  MenuItem,
  MenuItemModelBuilder
}

import scala.scalajs.js

package object menubar {

  private def createMenu(label: String, icon: String): MenuItem =
    MenuItemModelBuilder()
      .label(label)
      .icon(icon)
      .toModel

  private val newMenu = MenuItemModelBuilder()
    .label("New")
    .icon("pi pi-fw pi-plus")
    .item(
      createMenu("Bookmark", "pi pi-fw pi-bookmark"),
      createMenu("Video", "pi pi-fw pi-video")
    )
    .toModel

  private val fileMenu = MenuItemModelBuilder()
    .label("File")
    .icon("pi pi-fw pi-file")
    .item(newMenu)
    .item(
      createMenu("Delete", "pi pi-fw pi-trash"),
      MenuItemModelBuilder.separator,
      createMenu("Export", "pi pi-fw pi-external-link")
    )
    .toModel

  private val editMenu = MenuItemModelBuilder()
    .label("Edit")
    .icon("pi pi-fw pi-pencil")
    .item(
      createMenu("Left", "pi pi-fw pi-align-left"),
      createMenu("Right", "pi pi-fw pi-align-right"),
      createMenu("Center", "pi pi-fw pi-align-center"),
      createMenu("Justify", "pi pi-fw pi-align-justify")
    )
    .toModel

  private val filterMenu = MenuItemModelBuilder()
    .label("Filter")
    .icon("pi pi-fw pi-filter")
    .item(createMenu("Print", "pi pi-fw pi-print"))
    .toModel

  private val searchMenu = MenuItemModelBuilder()
    .label("Search")
    .icon("pi pi-fw pi-users")
    .item(filterMenu, createMenu("List", "pi pi-fw pi-bars"))
    .toModel

  private val usersMenu = MenuItemModelBuilder()
    .label("Users")
    .icon("pi pi-fw pi-user")
    .item(
      createMenu("New", "pi pi-fw pi-user-plus"),
      createMenu("Delete", "pi pi-fw pi-user-minus"),
      searchMenu
    )
    .toModel

  private val editEventsMenu = MenuItemModelBuilder()
    .label("Edit")
    .icon("pi pi-fw pi-pencil")
    .item(
      createMenu("Save", "pi pi-fw pi-calendar-plus"),
      createMenu("Delete", "pi pi-fw pi-calendar-minus")
    )
    .toModel

  private val archiveEventsMenu = MenuItemModelBuilder()
    .label("Archive")
    .icon("pi pi-fw pi-calendar-times")
    .item(createMenu("Remove", "pi pi-fw pi-calendar-minus"))
    .toModel

  private val eventsMenu = MenuItemModelBuilder()
    .label("Events")
    .icon("pi pi-fw pi-calendar")
    .item(editEventsMenu, archiveEventsMenu)
    .toModel

  private[menubar] val items: js.Array[MenuItem] =
    js.Array(
      fileMenu,
      editMenu,
      usersMenu,
      eventsMenu,
      createMenu("Quit", "pi pi-fw pi-power-off")
    )
}
