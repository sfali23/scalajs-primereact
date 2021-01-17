package com.alphasystem.primereact.comoponent

import io.circe.generic.auto._
import io.circe.syntax._
import io.circe.scalajs._

import scala.scalajs.js

package object menu {

  def toJsJson(menuItems: Seq[MenuItemModel]): js.Any =
    convertJsonToJs(menuItems.asJson.deepDropNullValues)
}
