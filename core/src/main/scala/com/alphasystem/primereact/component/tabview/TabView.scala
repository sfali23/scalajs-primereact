package com.alphasystem.primereact.component.tabview

import io.kinoplan.scalajs.react.bridge.{ ReactBridgeComponent, WithProps }

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

object TabView extends ReactBridgeComponent {

  @JSImport("primereact/tabview", "TabView")
  @js.native
  private object RawComponent extends js.Function

  override protected lazy val componentValue: js.Function = RawComponent

  def apply(
    id: js.UndefOr[String] = js.undefined,
    activeIndex: js.UndefOr[Int] = js.undefined,
    style: js.UndefOr[js.Object] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    renderActiveOnly: js.UndefOr[Boolean] = js.undefined,
    onTabChange: js.UndefOr[TabChangeEvent => Unit] = js.undefined
  ): WithProps = auto
}
