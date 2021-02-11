package com.alphasystem.primereact.component.dialog

import com.alphasystem.primereact.{ CallbackHandler0, CallbackHandler1 }
import japgolly.scalajs.react.component.Js.{ RawMounted, UnmountedWithRawType }
import japgolly.scalajs.react.vdom.VdomNode
import japgolly.scalajs.react.{ Children, JsComponent, ReactEventFromInput }

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.{ UndefOr, native, undefined, | }

object Dialog {

  type EventCallback = js.Function0[Unit]
  type EventHandler = CallbackHandler0
  type MaximizeEventCallback = js.Function1[MaximizeEvent, Unit]
  type MaximizeEventHandler = CallbackHandler1[MaximizeEvent]
  type DialogType = UnmountedWithRawType[Props, Null, RawMounted[Props, Null]]

  @JSImport("primereact/dialog", "Dialog")
  @native
  private object RawComponent extends js.Function

  @native
  trait Props extends js.Object {
    var id: UndefOr[String] = native
    var header: UndefOr[String | js.Any] = native
    var footer: UndefOr[String | js.Any] = native
    var visible: UndefOr[Boolean] = native
    var position: UndefOr[String] = native
    var modal: UndefOr[Boolean] = native
    var contentStyle: UndefOr[js.Object] = native
    var contentClassName: UndefOr[String] = native
    var closeOnEscape: UndefOr[Boolean] = native
    var dismissableMask: UndefOr[Boolean] = native
    var rtl: UndefOr[Boolean] = native
    var closable: UndefOr[Boolean] = native
    var style: UndefOr[js.Object] = native
    var className: UndefOr[String] = native
    var maskClassName: UndefOr[String] = native
    var showHeader: UndefOr[Boolean] = native
    var appendTo: UndefOr[js.Object] = native
    var baseZIndex: UndefOr[Int] = native
    var maximizable: UndefOr[Boolean] = native
    var blockScroll: UndefOr[Boolean] = native
    var icons: UndefOr[js.Any] = native
    var ariaCloseIconLabel: UndefOr[String] = native
    var focusOnShow: UndefOr[Boolean] = native
    var maximized: UndefOr[Boolean] = native
    var onHide: EventCallback = native
    var onShow: UndefOr[EventCallback] = native
    var onMaximize: UndefOr[MaximizeEventCallback] = native
  }

  private def props(
    id: UndefOr[String] = undefined,
    header: UndefOr[String | js.Any] = undefined,
    footer: UndefOr[String | js.Any] = undefined,
    visible: UndefOr[Boolean] = undefined,
    position: UndefOr[Position] = undefined,
    modal: UndefOr[Boolean] = undefined,
    contentStyle: UndefOr[js.Object] = undefined,
    contentClassName: UndefOr[String] = undefined,
    closeOnEscape: UndefOr[Boolean] = undefined,
    dismissableMask: UndefOr[Boolean] = undefined,
    rtl: UndefOr[Boolean] = undefined,
    closable: UndefOr[Boolean] = undefined,
    style: UndefOr[js.Object] = undefined,
    className: UndefOr[String] = undefined,
    maskClassName: UndefOr[String] = undefined,
    showHeader: UndefOr[Boolean] = undefined,
    appendTo: UndefOr[js.Object] = undefined,
    baseZIndex: UndefOr[Int] = undefined,
    maximizable: UndefOr[Boolean] = undefined,
    blockScroll: UndefOr[Boolean] = undefined,
    icons: UndefOr[js.Any] = undefined,
    ariaCloseIconLabel: UndefOr[String] = undefined,
    focusOnShow: UndefOr[Boolean] = undefined,
    maximized: UndefOr[Boolean] = undefined,
    onHide: EventHandler,
    onShow: UndefOr[EventHandler] = undefined,
    onMaximize: UndefOr[MaximizeEventHandler] = undefined
  ): Props = {
    val props = (new js.Object).asInstanceOf[Props]
    props.id = id
    props.header = header
    props.footer = footer
    props.visible = visible
    props.position = position.map(_.entryName)
    props.modal = modal
    props.contentStyle = contentStyle
    props.contentClassName = contentClassName
    props.closeOnEscape = closeOnEscape
    props.dismissableMask = dismissableMask
    props.rtl = rtl
    props.closable = closable
    props.style = style
    props.className = className
    props.maskClassName = maskClassName
    props.showHeader = showHeader
    props.appendTo = appendTo
    props.baseZIndex = baseZIndex
    props.maximizable = maximizable
    props.blockScroll = blockScroll
    props.icons = icons
    props.ariaCloseIconLabel = ariaCloseIconLabel
    props.focusOnShow = focusOnShow
    props.maximized = maximized
    props.onHide = () => onHide().runNow()
    props.onShow = onShow.map(handler => () => handler().runNow())
    props.onMaximize = onMaximize.map(handler =>
      (event: MaximizeEvent) => handler(event).runNow()
    )
    props
  }

  private val component =
    JsComponent[Props, Children.Varargs, Null](RawComponent)

  def apply(
    id: UndefOr[String] = undefined,
    header: UndefOr[String | js.Any] = undefined,
    footer: UndefOr[String | js.Any] = undefined,
    visible: UndefOr[Boolean] = undefined,
    position: UndefOr[Position] = undefined,
    modal: UndefOr[Boolean] = undefined,
    contentStyle: UndefOr[js.Object] = undefined,
    contentClassName: UndefOr[String] = undefined,
    closeOnEscape: UndefOr[Boolean] = undefined,
    dismissableMask: UndefOr[Boolean] = undefined,
    rtl: UndefOr[Boolean] = undefined,
    closable: UndefOr[Boolean] = undefined,
    style: UndefOr[js.Object] = undefined,
    className: UndefOr[String] = undefined,
    maskClassName: UndefOr[String] = undefined,
    showHeader: UndefOr[Boolean] = undefined,
    appendTo: UndefOr[js.Object] = undefined,
    baseZIndex: UndefOr[Int] = undefined,
    maximizable: UndefOr[Boolean] = undefined,
    blockScroll: UndefOr[Boolean] = undefined,
    icons: UndefOr[js.Any] = undefined,
    ariaCloseIconLabel: UndefOr[String] = undefined,
    focusOnShow: UndefOr[Boolean] = undefined,
    maximized: UndefOr[Boolean] = undefined,
    onHide: EventHandler,
    onShow: UndefOr[EventHandler] = undefined,
    onMaximize: UndefOr[MaximizeEventHandler] = undefined
  )(children: VdomNode*
  ): DialogType =
    component(
      props(
        id,
        header,
        footer,
        visible,
        position,
        modal,
        contentStyle,
        contentClassName,
        closeOnEscape,
        dismissableMask,
        rtl,
        closable,
        style,
        className,
        maskClassName,
        showHeader,
        appendTo,
        baseZIndex,
        maximizable,
        blockScroll,
        icons,
        ariaCloseIconLabel,
        focusOnShow,
        maximized,
        onHide,
        onShow,
        onMaximize
      )
    )(children: _*)
}

@native
trait MaximizeEvent extends js.Object {
  var originalEvent: ReactEventFromInput
  var maximized: Boolean
}
