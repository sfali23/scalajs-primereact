package com.alphasystem.primereact.component.menu

import com.alphasystem.primereact.Handler1
import com.payalabs.scalajs.react.bridge.{
  ReactBridgeComponent,
  WithPropsNoChildren
}
import japgolly.scalajs.react.raw.SyntheticEvent
import org.scalajs.dom.{ Event, html }

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
    appendTo: js.UndefOr[html.Element] = js.undefined,
    onShow: js.UndefOr[Handler1[Event, Unit]] = js.undefined,
    onHide: js.UndefOr[Handler1[Event, Unit]] = js.undefined,
    toggle: js.UndefOr[Handler1[SyntheticEvent[html.Input], Unit]] =
      js.undefined,
    show: js.UndefOr[Handler1[SyntheticEvent[html.Input], Unit]] = js.undefined,
    hide: js.UndefOr[Handler1[SyntheticEvent[html.Input], Unit]] = js.undefined
  ): WithPropsNoChildren = autoNoChildren
}
