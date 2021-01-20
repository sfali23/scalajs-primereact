package com.alphasystem.primereact.component.menu

import com.alphasystem.primereact.icons.Icon

case class MenuItemModel(
  label: String,
  icon: Option[String] = None,
  items: Option[List[MenuItemModel]] = None)

object MenuItemModel {

  def apply(
    label: String,
    icon: Option[Icon],
    items: List[MenuItemModel]
  ): MenuItemModel = MenuItemModel(
    label = label,
    icon = icon.map(_.toClassName),
    items = items match {
      case Nil => None
      case _   => Some(items)
    }
  )
}
