package com.alphasystem.primereact.component.splitbutton

import io.kinoplan.scalajs.react.bridge.{
  ReactBridgeComponent,
  WithPropsNoChildren
}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.{ UndefOr, undefined }

object SplitButton extends ReactBridgeComponent {

  @JSImport("primereact/splitbutton", "SplitButton")
  @js.native
  private object RawComponent extends js.Function

  override protected lazy val componentValue: js.Function = RawComponent

  def apply(
    label: UndefOr[String] = undefined,
    icon: UndefOr[String] = js.undefined,
    model: UndefOr[js.Any] = undefined,
    className: UndefOr[String] = undefined,
    menuStyle: UndefOr[String] = undefined,
    menuClassName: UndefOr[String] = undefined,
    tabIndex: UndefOr[String] = undefined,
    appendTo: UndefOr[js.Any] = undefined,
    tooltip: UndefOr[js.Any] = undefined,
    tooltipOptions: UndefOr[js.Object] = undefined,
    buttonTemplate: UndefOr[js.Any] = undefined
  ): WithPropsNoChildren = autoNoChildren
}
