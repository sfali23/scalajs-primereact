package com.alphasystem.primereact.component.inputtext

import com.alphasystem.primereact.component.keyfilter.KeyFilter
import com.alphasystem.primereact.component.tooltip.TooltipOptions
import io.kinoplan.scalajs.react.bridge.{
  ReactBridgeComponent,
  WithPropsNoChildren
}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.{ RegExp, UndefOr, undefined, | }

object InputText extends ReactBridgeComponent {

  @JSImport("primereact/inputtext", "InputText")
  @js.native
  private object RawComponent extends js.Function

  override protected lazy val componentValue: js.Function = RawComponent

  def apply(
    keyfilter: UndefOr[KeyFilter | RegExp] = undefined,
    validateOnly: UndefOr[Boolean] = undefined,
    tooltip: UndefOr[String | js.Any] = undefined,
    tooltipOptions: UndefOr[TooltipOptions] = undefined
  ): WithPropsNoChildren = autoNoChildren
}
