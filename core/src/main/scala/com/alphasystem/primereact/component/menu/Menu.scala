package com.alphasystem.primereact.component.menu

import com.payalabs.scalajs.react.bridge.{ ReactBridgeComponent, WithProps }
import org.scalajs.dom.html

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

object Menu extends ReactBridgeComponent {

  @JSImport("primereact/menu", "Menu")
  @js.native
  private object RawComponent extends js.Function

  override protected lazy val componentValue: js.Function = RawComponent

  def apply(
    id: js.UndefOr[String] = js.undefined,
    model: js.UndefOr[js.Any] = js.undefined,
    popup: js.UndefOr[Boolean] = js.undefined,
    style: js.UndefOr[String] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    baseZIndex: js.UndefOr[Int] = js.undefined,
    autoZIndex: js.UndefOr[Boolean] = js.undefined,
    appendTo: js.UndefOr[html.Element] = js.undefined
  ): WithProps = auto
}
