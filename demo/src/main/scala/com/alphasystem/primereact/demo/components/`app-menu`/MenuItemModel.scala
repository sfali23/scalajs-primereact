package com.alphasystem.primereact.demo.components.`app-menu`

case class MenuItemModel(
  name: String,
  to: Option[String] = None,
  href: Option[String] = None,
  badge: Option[String] = None,
  meta: List[String] = Nil,
  children: List[MenuItemModel] = Nil)
