package com.alphasystem.primereact.component.button

import com.alphasystem.primereact.component.badge.BadgeType
import com.alphasystem.primereact.component.tooltip.TooltipOptions
import com.alphasystem.primereact.icons.Icon
import io.kinoplan.scalajs.react.bridge.WithPropsNoChildren

import scala.scalajs.js.JSConverters._

class ButtonBuilder {
  private var label: Option[String] = None
  private var icon: Option[String] = None
  private var iconPos: Option[IconPos] = None
  private var classNames: List[String] = Nil
  private var badge: Option[String] = None
  private var badgeType: Option[BadgeType] = None
  private var tooltip: Option[String] = None
  private var tooltipOptions: Option[TooltipOptions] = None

  def label(label: String): ButtonBuilder = {
    this.label = Some(label)
    this
  }

  def icon(icon: Icon): ButtonBuilder = {
    this.icon = Some(icon.toClassName)
    this
  }

  def icon(icon: String): ButtonBuilder = {
    this.icon = Some(icon)
    this
  }

  def iconPos(iconPos: IconPos): ButtonBuilder = {
    this.iconPos = Some(iconPos)
    this
  }

  def badge(badge: String): ButtonBuilder = {
    this.badge = Some(badge)
    this
  }

  def badgeType(badgeType: BadgeType): ButtonBuilder = {
    this.badgeType = Some(badgeType)
    this
  }

  def classNames(cs: String*): ButtonBuilder = {
    this.classNames :+= cs.mkString(" ")
    this
  }

  def severity(severity: Severity): ButtonBuilder = {
    this.classNames :+= severity.toClassName
    this
  }

  def size(size: ButtonSize): ButtonBuilder = {
    this.classNames :+= size.toClassName
    this
  }

  def link: ButtonBuilder = {
    this.classNames :+= "p-button-link"
    this
  }

  def raised: ButtonBuilder = {
    this.classNames :+= "p-button-raised"
    this
  }

  def rounded: ButtonBuilder = {
    this.classNames :+= "p-button-rounded"
    this
  }

  def outlined: ButtonBuilder = {
    this.classNames :+= "p-button-outlined"
    this
  }

  def text: ButtonBuilder = {
    this.classNames :+= "p-button-text"
    this
  }

  def tooltip(tooltip: String): ButtonBuilder = {
    this.tooltip = Some(tooltip)
    this
  }

  def tooltipOptions(tooltipOptions: TooltipOptions): ButtonBuilder = {
    this.tooltipOptions = Some(tooltipOptions)
    this
  }

  private def toClassName: Option[String] =
    if (classNames.isEmpty) None else Some(classNames.mkString(" "))

  def toButton: WithPropsNoChildren =
    Button(
      label = label.orUndefined,
      className = toClassName.orUndefined,
      icon = icon.orUndefined,
      iconPos = iconPos.orUndefined,
      badge = badge.orUndefined,
      badgeClassName = badgeType.map(_.toClassName).orUndefined,
      tooltip = tooltip.orUndefined,
      tooltipOptions = tooltipOptions.orUndefined
    )
}

object ButtonBuilder {
  def apply(): ButtonBuilder = new ButtonBuilder()
}
