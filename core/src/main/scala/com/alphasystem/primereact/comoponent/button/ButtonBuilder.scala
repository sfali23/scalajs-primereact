package com.alphasystem.primereact.comoponent.button

import com.alphasystem.primereact.comoponent.Button
import com.alphasystem.primereact.comoponent.badge.BadgeType
import com.alphasystem.primereact.icons.Icon
import io.kinoplan.scalajs.react.bridge.WithProps

import scala.scalajs.js.JSConverters._

case class ButtonBuilder(
  label: Option[String] = None,
  icon: Option[Either[String, Icon]] = None,
  iconPos: Option[IconPos] = None,
  severity: Option[Severity] = None,
  size: Option[ButtonSize] = None,
  link: Boolean = false,
  raised: Boolean = false,
  rounded: Boolean = false,
  outlined: Boolean = false,
  text: Boolean = false,
  badge: Option[String] = None,
  badgeType: Option[BadgeType] = None) {

  private def toClassName: Option[String] = {
    var classNames: List[String] = Nil
    severity.map(_.toClassName).foreach(classNames :+= _)
    size.map(_.toClassName).foreach(classNames :+= _)
    if (link) classNames :+= "p-button-link"
    if (raised) classNames :+= "p-button-raised"
    if (rounded) classNames :+= "p-button-rounded"
    if (outlined) classNames :+= "p-button-outlined"
    if (text) classNames :+= "p-button-text"
    if (classNames.isEmpty) None else Some(classNames.mkString(" "))
  }

  private def toIconClass: Option[String] =
    icon match {
      case Some(value) =>
        value match {
          case Left(value)  => Some(value)
          case Right(value) => Some(value.toClassName)
        }
      case None => None
    }

  def toButton: WithProps = {
    Button(
      label = label.orUndefined,
      className = toClassName.orUndefined,
      icon = toIconClass.orUndefined,
      iconPos = iconPos.orUndefined,
      badge = badge.orUndefined,
      badgeClassName = badgeType.map(_.toClassName).orUndefined
    )
  }
}
