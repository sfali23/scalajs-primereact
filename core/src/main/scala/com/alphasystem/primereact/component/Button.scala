package com.alphasystem.primereact.component

import com.alphasystem.primereact.component.button.IconPos
import io.kinoplan.scalajs.react.bridge.{ ReactBridgeComponent, WithProps }

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

object Button extends ReactBridgeComponent {

  @JSImport("primereact/button", "Button")
  @js.native
  private object RawComponent extends js.Function

  override protected lazy val componentValue: js.Function = RawComponent

  def apply(
    label: js.UndefOr[String] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    icon: js.UndefOr[String] = js.undefined,
    iconPos: js.UndefOr[IconPos] = js.undefined,
    badge: js.UndefOr[String] = js.undefined,
    badgeClassName: js.UndefOr[String] = js.undefined,
    tooltip: js.UndefOr[js.Any] = js.undefined,
    tooltipOptions: js.UndefOr[js.Object] = js.undefined
  ): WithProps = auto
}
