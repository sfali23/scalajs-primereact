package com.alphasystem.primereact.component.tabview

import io.kinoplan.scalajs.react.bridge.{ ReactBridgeComponent, WithProps }

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

object TabPanel extends ReactBridgeComponent {

  @JSImport("primereact/tabview", "TabPanel")
  @js.native
  private object RawComponent extends js.Function

  override protected lazy val componentValue: js.Function = RawComponent

  def apply(
    header: js.UndefOr[String | js.Object] = js.undefined,
    leftIcon: js.UndefOr[String] = js.undefined,
    rightIcon: js.UndefOr[String] = js.undefined,
    disabled: js.UndefOr[Boolean] = js.undefined,
    headerClassName: js.UndefOr[String] = js.undefined,
    contentStyle: js.UndefOr[js.Object] = js.undefined,
    contentClassName: js.UndefOr[String] = js.undefined
  ): WithProps = auto
}
