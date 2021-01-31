package com.alphasystem.primereact.component.menumodel

import scala.scalajs.js

abstract class MenuItem extends js.Object {
  val label: js.UndefOr[String] = js.undefined
  val icon: js.UndefOr[String] = js.undefined
  val url: js.UndefOr[String] = js.undefined
  val disabled: js.UndefOr[Boolean] = js.undefined
  val target: js.UndefOr[String] = js.undefined
  val className: js.UndefOr[String] = js.undefined
  val separator: js.UndefOr[Boolean] = js.undefined
  val style: js.UndefOr[js.Any] = js.undefined
  val template: js.UndefOr[js.Any] = js.undefined
  val items: js.UndefOr[js.Array[MenuItem]] = js.undefined
  def command(): Unit = js.undefined
}
