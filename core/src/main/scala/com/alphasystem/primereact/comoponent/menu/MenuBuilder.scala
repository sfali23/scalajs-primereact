package com.alphasystem.primereact.comoponent.menu

import com.alphasystem.primereact.comoponent.Menu
import io.kinoplan.scalajs.react.bridge.WithProps
import org.scalajs.dom.html

import scala.scalajs.js.JSConverters._

case class MenuBuilder(
  id: Option[String] = None,
  model: Option[Seq[MenuItemModel]] = None,
  popup: Option[Boolean] = None,
  style: Option[String] = None,
  className: Option[String] = None,
  baseZIndex: Option[Int] = None,
  autoZIndex: Option[Boolean] = None,
  appendTo: Option[html.Element] = None) {

  def toMenu: WithProps = Menu(
    id = id.orUndefined,
    model = model.map(toJsJson).orUndefined,
    popup = popup.orUndefined,
    style = style.orUndefined,
    className = className.orUndefined,
    baseZIndex = baseZIndex.orUndefined,
    autoZIndex = autoZIndex.orUndefined,
    appendTo = appendTo.orUndefined
  )
}
