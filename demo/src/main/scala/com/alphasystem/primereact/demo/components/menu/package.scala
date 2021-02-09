package com.alphasystem.primereact.demo.components

import com.alphasystem.primereact.component.menumodel.{
  MenuItem,
  MenuItemModelBuilder
}
import com.alphasystem.primereact.component.message.{ MessageItem, Severity }
import com.alphasystem.primereact.component.toast.Toast.ToastRef
import com.alphasystem.primereact.icons.Icon
import typings.std.global.window

import scala.scalajs.js

package object menu {

  private[menu] def createMessage(
    severity: Severity,
    summary: js.Any,
    detail: js.Any = "Message Content"
  ) =
    MessageItem(
      severity = severity,
      summary = summary,
      detail = detail
    )

  def updateMenuItem(toastRef: ToastRef): MenuItem =
    MenuItemModelBuilder()
      .label("Update")
      .icon(Icon.Refresh)
      .command(() =>
        toastRef
          .foreach(
            _.raw
              .show(createMessage(Severity.Success, "Update", "Data Updated"))
          )
          .runNow()
      )
      .toModel

  def deleteMenuItem(toastRef: ToastRef): MenuItem =
    MenuItemModelBuilder()
      .label("Delete")
      .icon(Icon.Times)
      .command(() =>
        toastRef
          .foreach(
            _.raw
              .show(
                createMessage(Severity.Warn, "Deleted", "Data Deleted")
              )
          )
          .runNow()
      )
      .toModel

  private def optionsMenuItem(toastRef: ToastRef) = MenuItemModelBuilder()
    .label("Options")
    .item(updateMenuItem(toastRef), deleteMenuItem(toastRef))
    .toModel

  val reactMenuItem: MenuItem =
    MenuItemModelBuilder()
      .label("React Website")
      .icon(Icon.ExternalLink)
      .url("https://reactjs.org/")
      .toModel

  val routerMenuItem: MenuItem =
    MenuItemModelBuilder()
      .label("Router")
      .icon(Icon.Upload)
      .command(() => window.location.hash = "/#/fileupload")
      .toModel

  private val navigateMenuItem = MenuItemModelBuilder()
    .label("Navigate")
    .item(reactMenuItem, routerMenuItem)
    .toModel

  private[menu] def items(toastRef: ToastRef) =
    js.Array(
      optionsMenuItem(toastRef),
      navigateMenuItem
    )
}
