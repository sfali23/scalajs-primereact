package com.alphasystem.primereact.component.splitbutton

import com.alphasystem.primereact.component.button.Severity
import com.alphasystem.primereact.component.menumodel.MenuItem
import com.alphasystem.primereact.component.tooltip.TooltipOptions
import com.alphasystem.primereact.icons.Icon
import io.kinoplan.scalajs.react.bridge.WithPropsNoChildren

import scala.scalajs.js
import scala.scalajs.js.JSConverters._

class SplitButtonBuilder {
  private var label: Option[String] = None
  private var icon: Option[String] = None
  private var menuStyle: Option[String] = None
  private var menuClassName: Option[String] = None
  private var tabIndex: Option[String] = None
  private var buttonTemplate: Option[js.Any] = None
  private var model: List[MenuItem] = Nil
  private var classNames: List[String] = Nil
  private var tooltip: Option[String] = None
  private var tooltipOptions: Option[TooltipOptions] = None

  def label(label: String): SplitButtonBuilder = {
    this.label = Some(label)
    this
  }

  def icon(icon: Icon): SplitButtonBuilder = {
    this.icon = Some(icon.toClassName)
    this
  }

  def icon(icon: String): SplitButtonBuilder = {
    this.icon = Some(icon)
    this
  }

  def classNames(cs: String*): SplitButtonBuilder = {
    this.classNames :::= cs.toList
    this
  }

  def severity(severity: Severity): SplitButtonBuilder = {
    this.classNames :+= severity.toClassName
    this
  }

  def menuStyle(menuStyle: String): SplitButtonBuilder = {
    this.menuStyle = Some(menuStyle)
    this
  }

  def menuClassName(menuClassName: String): SplitButtonBuilder = {
    this.menuClassName = Some(menuClassName)
    this
  }

  def tabIndex(tabIndex: String): SplitButtonBuilder = {
    this.tabIndex = Some(tabIndex)
    this
  }

  def tooltip(tooltip: String): SplitButtonBuilder = {
    this.tooltip = Some(tooltip)
    this
  }

  def tooltipOptions(tooltipOptions: TooltipOptions): SplitButtonBuilder = {
    this.tooltipOptions = Some(tooltipOptions)
    this
  }

  def buttonTemplate(buttonTemplate: js.Any): SplitButtonBuilder = {
    this.buttonTemplate = Some(buttonTemplate)
    this
  }

  def model(model: List[MenuItem]): SplitButtonBuilder = {
    this.model = model
    this
  }

  private def toClassName: Option[String] =
    if (classNames.isEmpty) None else Some(classNames.mkString(" "))

  def toSplitButton: WithPropsNoChildren = {
    val model = (if (this.model.isEmpty) None else Some(this.model))
      .map(_.toJSArray)
      .orUndefined
    SplitButton(
      label = label.orUndefined,
      icon = icon.orUndefined,
      model = model,
      className = toClassName.orUndefined,
      menuStyle = menuStyle.orUndefined,
      menuClassName = menuClassName.orUndefined,
      tabIndex = tabIndex.orUndefined,
      buttonTemplate = buttonTemplate.orUndefined
    )
  }

}

object SplitButtonBuilder {
  def apply(): SplitButtonBuilder = new SplitButtonBuilder()
}
