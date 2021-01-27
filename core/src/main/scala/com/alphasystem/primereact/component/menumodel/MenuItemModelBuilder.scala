package com.alphasystem.primereact.component.menumodel

import com.alphasystem.primereact.icons.Icon

import scala.scalajs.js
import scala.scalajs.js.JSConverters._
import scala.scalajs.js.UndefOr

class MenuItemModelBuilder(menuLabel: String) {
  private var _icon: Option[String] = None
  private var _url: Option[String] = None
  private var _disabled: Option[Boolean] = None
  private var _target: Option[String] = None
  private var _className: Option[String] = None
  private var _separator: Option[Boolean] = None
  private var _style: Option[js.Any] = None
  private var _template: Option[js.Any] = None
  private var _items: Option[js.Array[MenuItem]] = None
  private var _command: Option[js.Function] = None

  def icon(icon: Icon): MenuItemModelBuilder = {
    this._icon = Some(icon.toClassName)
    this
  }

  def icon(icon: String): MenuItemModelBuilder = {
    this._icon = Some(icon)
    this
  }

  def url(url: String): MenuItemModelBuilder = {
    this._url = Some(url)
    this
  }

  def disabled(disabled: Boolean): MenuItemModelBuilder = {
    this._disabled = Some(disabled)
    this
  }

  def target(target: String): MenuItemModelBuilder = {
    this._target = Some(target)
    this
  }

  def className(className: String): MenuItemModelBuilder = {
    this._className = Some(className)
    this
  }

  def separator(separator: Boolean): MenuItemModelBuilder = {
    this._separator = Some(separator)
    this
  }

  def style(style: js.Any): MenuItemModelBuilder = {
    this._style = Some(style)
    this
  }

  def template(template: js.Any): MenuItemModelBuilder = {
    this._template = Some(template)
    this
  }

  def items(items: js.Array[MenuItem]): MenuItemModelBuilder = {
    this._items = Some(items)
    this
  }

  def command(command: js.Function): MenuItemModelBuilder = {
    this._command = Some(command)
    this
  }

  def toModel: MenuItem = {
    new MenuItem {
      override val label: String = menuLabel
      override val icon: UndefOr[String] = _icon.orUndefined
      override val url: UndefOr[String] = _url.orUndefined
      override val disabled: UndefOr[Boolean] = _disabled.orUndefined
      override val target: UndefOr[String] = _target.orUndefined
      override val className: UndefOr[String] = _className.orUndefined
      override val separator: UndefOr[Boolean] = _separator.orUndefined
      override val style: UndefOr[js.Any] = _style.orUndefined
      override val template: UndefOr[js.Any] = _template.orUndefined
      override val items: UndefOr[js.Array[MenuItem]] = _items.orUndefined
      override def command(): Unit = _command.orUndefined
    }
  }
}

object MenuItemModelBuilder {

  def apply(menuLabel: String): MenuItemModelBuilder =
    new MenuItemModelBuilder(menuLabel)
}
