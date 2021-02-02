package com.alphasystem.primereact.demo.components.`app-menu`

import scala.scalajs.js

@js.native
trait MenuItemModel extends js.Object {
  val name: String
  val to: js.UndefOr[String] = js.undefined
  val href: js.UndefOr[String] = js.undefined
  val badge: js.UndefOr[String] = js.undefined
  val meta: js.UndefOr[js.Array[String]] = js.undefined
  val children: js.UndefOr[js.Array[MenuItemModel]] = js.undefined
}
