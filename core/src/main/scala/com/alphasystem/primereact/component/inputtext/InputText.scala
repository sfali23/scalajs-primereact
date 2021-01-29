package com.alphasystem.primereact.component.inputtext

import io.kinoplan.scalajs.react.bridge.{
  ReactBridgeComponent,
  WithPropsNoChildren
}

import scala.scalajs.js
import scala.scalajs.js.{ UndefOr, undefined }
import scala.scalajs.js.annotation.JSImport

object InputText extends ReactBridgeComponent {

  @JSImport("primereact/inputtext", "InputText")
  @js.native
  private object RawComponent extends js.Function

  override protected lazy val componentValue: js.Function = RawComponent

  def apply(
    keyfilter: UndefOr[js.Any] = undefined,
    validateOnly: UndefOr[Boolean] = undefined,
    tooltip: UndefOr[js.Any] = undefined,
    tooltipOptions: UndefOr[js.Object] = undefined
  ): WithPropsNoChildren = autoNoChildren
}
