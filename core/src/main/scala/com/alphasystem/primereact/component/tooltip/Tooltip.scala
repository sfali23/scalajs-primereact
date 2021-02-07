package com.alphasystem.primereact.component.tooltip

import com.alphasystem.primereact.CallbackHandler1
import japgolly.scalajs.react.Ref.ToJsComponent
import japgolly.scalajs.react.component.Js.{ RawMounted, UnmountedMapped }
import japgolly.scalajs.react.internal.Effect.Id
import japgolly.scalajs.react.{
  Children,
  JsComponent,
  ReactEventFromInput,
  Ref
}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.{ UndefOr, native, undefined, | }

object Tooltip {

  @JSImport("primereact/tooltip", "Tooltip")
  @native
  private object RawComponent extends js.Function

  type EventCallback = js.Function1[TooltipEvent, Unit]
  type EventHandler = CallbackHandler1[TooltipEvent]

  type TooltipType =
    UnmountedMapped[Id, Props, Null, RawMounted[Props, Null], Props, Null]

  type TooltipRef =
    ToJsComponent[Props, Null, RawMounted[Props, Null]]

  @native
  trait Props extends js.Object {
    var target: UndefOr[String | js.Object | js.Any] = native
    var content: UndefOr[String] = native
    var className: UndefOr[String] = native
    var style: UndefOr[js.Object] = native
    var appendTo: UndefOr[js.Object] = native
    var position: UndefOr[String] = native
    var my: UndefOr[String] = native
    var at: UndefOr[String] = native
    var event: UndefOr[String] = native
    var showEvent: UndefOr[String] = native
    var hideEvent: UndefOr[String] = native
    var autoZIndex: UndefOr[Boolean] = native
    var baseZIndex: UndefOr[Int] = native
    var mouseTrack: UndefOr[Boolean] = native
    var mouseTrackTop: UndefOr[Int] = native
    var mouseTrackLeft: UndefOr[Int] = native
    var onBeforeShow: UndefOr[EventCallback] = native
    var onBeforeHide: UndefOr[EventCallback] = native
    var onShow: UndefOr[EventCallback] = native
    var onHide: UndefOr[EventCallback] = native
  }

  def props(
    target: UndefOr[String | js.Object | js.Any] = undefined,
    content: UndefOr[String] = undefined,
    className: UndefOr[String] = undefined,
    style: UndefOr[js.Object] = undefined,
    appendTo: UndefOr[js.Object] = undefined,
    position: UndefOr[Position] = undefined,
    my: UndefOr[String] = undefined,
    at: UndefOr[String] = undefined,
    event: UndefOr[String] = undefined,
    showEvent: UndefOr[String] = undefined,
    hideEvent: UndefOr[String] = undefined,
    autoZIndex: UndefOr[Boolean] = undefined,
    baseZIndex: UndefOr[Int] = undefined,
    mouseTrack: UndefOr[Boolean] = undefined,
    mouseTrackTop: UndefOr[Int] = undefined,
    mouseTrackLeft: UndefOr[Int] = undefined,
    onBeforeShow: UndefOr[EventHandler] = undefined,
    onBeforeHide: UndefOr[EventHandler] = undefined,
    onShow: UndefOr[EventHandler] = undefined,
    onHide: UndefOr[EventHandler] = undefined
  ): Props = {
    val props = (new js.Object).asInstanceOf[Props]
    props.target = target
    props.content = content
    props.className = className
    props.style = style
    props.appendTo = appendTo
    props.position = position.map(_.entryName)
    props.my = my
    props.at = at
    props.event = event
    props.showEvent = showEvent
    props.hideEvent = hideEvent
    props.autoZIndex = autoZIndex
    props.baseZIndex = baseZIndex
    props.mouseTrack = mouseTrack
    props.mouseTrackTop = mouseTrackTop
    props.mouseTrackLeft = mouseTrackLeft
    props.onBeforeShow = onBeforeShow.map(handler =>
      (event: TooltipEvent) => handler(event).runNow()
    )
    props.onBeforeHide = onBeforeHide.map(handler =>
      (event: TooltipEvent) => handler(event).runNow()
    )
    props.onShow =
      onShow.map(handler => (event: TooltipEvent) => handler(event).runNow())
    props.onHide =
      onHide.map(handler => (event: TooltipEvent) => handler(event).runNow())
    props
  }

  def toRef: TooltipRef = Ref.toJsComponent[Props, Null]

  private val component = JsComponent[Props, Children.None, Null](RawComponent)

  def apply(ref: TooltipRef)(props: Props): TooltipType =
    component.withRef(ref)(props)

  def apply(props: Props = Tooltip.props()): TooltipType = component(props)
}

@native
trait TooltipEvent extends js.Object {
  var originalEvent: ReactEventFromInput
  var target: js.Any
}
