package com.alphasystem.primereact.component.toast

import com.alphasystem.primereact.component.message._
import japgolly.scalajs.react.Ref.ToJsComponent
import japgolly.scalajs.react.component.Js.{ RawMounted, UnmountedMapped }
import japgolly.scalajs.react.internal.Effect.Id
import japgolly.scalajs.react.{ Callback, Children, JsComponent, Ref }

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.{ UndefOr, undefined }

object Toast {

  @JSImport("primereact/toast", "Toast")
  @js.native
  object RawComponent extends js.Function

  type ToastRef =
    ToJsComponent[Props, State, RawMounted[Props, State] with JsMethods]

  type ToastType = UnmountedMapped[
    Id,
    Props,
    State,
    RawMounted[Props, State] with JsMethods,
    Props,
    State
  ]

  @js.native
  trait Props extends js.Object {
    var id: UndefOr[String] = js.native
    var position: UndefOr[String] = js.native
    var className: UndefOr[String] = js.native
    var style: UndefOr[String] = js.native
    var baseZIndex: UndefOr[Int] = js.native
    var onRemove: MessageCallback = js.native
    var onClick: MessageCallback = js.native
  }

  @js.native
  trait State extends js.Object {
    var messages: js.Array[MessageItem]
  }

  @js.native
  trait JsMethods extends js.Object {
    def show(message: js.Array[MessageItem]): Unit = js.native
    def show(message: MessageItem): Unit = js.native
    def clear(): Unit = js.native
  }

  def props(
    id: UndefOr[String] = undefined,
    position: UndefOr[Position] = undefined,
    className: UndefOr[String] = undefined,
    style: UndefOr[String] = undefined,
    baseZIndex: UndefOr[Int] = undefined,
    onRemove: MessageHandler = _ => Callback.empty,
    onClick: MessageHandler = _ => Callback.empty
  ): Props = {
    val props = (new js.Object).asInstanceOf[Props]
    props.id = id
    props.position = position.map(_.entryName)
    props.className = className
    props.style = style
    props.baseZIndex = baseZIndex
    props.onRemove = (message: MessageItem) => onRemove(message).runNow()
    props.onClick = (message: MessageItem) => onClick(message).runNow()
    props
  }

  private[toast] val component =
    JsComponent[Props, Children.None, State](RawComponent)
      .addFacade[JsMethods]

  def toRef: ToastRef = Ref
    .toJsComponentWithMountedFacade[Props, State, JsMethods]

  def apply(ref: ToastRef)(props: Props): ToastType =
    component.withRef(ref)(props)
}
