package com.alphasystem.primereact.component.menubar

import io.kinoplan.scalajs.react.bridge.{
  ReactBridgeComponent,
  WithPropsNoChildren
}
import japgolly.scalajs.react.vdom.VdomElement

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

object Menubar extends ReactBridgeComponent {

  @JSImport("primereact/menubar", "Menubar")
  @js.native
  private object RawComponent extends js.Function

  override protected lazy val componentValue: js.Function = RawComponent

  def apply(
    id: js.UndefOr[String] = js.undefined,
    model: js.UndefOr[js.Any] = js.undefined,
    style: js.UndefOr[String] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    start: js.UndefOr[VdomElement] = js.undefined,
    end: js.UndefOr[VdomElement] = js.undefined
  ): WithPropsNoChildren = autoNoChildren
}
