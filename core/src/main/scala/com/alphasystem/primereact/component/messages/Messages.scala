package com.alphasystem.primereact.component.messages

import com.alphasystem.primereact.component.message._
import japgolly.scalajs.react.Ref.ToJsComponent
import japgolly.scalajs.react.component.Js.{ RawMounted, UnmountedMapped }
import japgolly.scalajs.react.internal.Effect.Id
import japgolly.scalajs.react.{ Children, JsComponent, Ref }

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.{ UndefOr, undefined }

object Messages {

  @JSImport("primereact/messages", "Messages")
  @js.native
  object RawComponent extends js.Function

  type MessagesRef =
    ToJsComponent[Props, Null, RawMounted[Props, Null] with JsMethods]

  type MessagesType = UnmountedMapped[
    Id,
    Props,
    Null,
    RawMounted[Props, Null] with JsMethods,
    Props,
    Null
  ]

  @js.native
  trait Props extends js.Object {
    var id: UndefOr[String] = js.native
    var className: UndefOr[String] = js.native
    var style: UndefOr[js.Any] = js.native
    var onRemove: UndefOr[MessageCallback] = js.native
    var onClick: UndefOr[MessageCallback] = js.native
  }

  @js.native
  trait JsMethods extends js.Object {
    def show(message: js.Array[MessageItem]): Unit = js.native
    def show(message: MessageItem): Unit = js.native
    def replace(message: MessageItem): Unit = js.native
    def clear(): Unit = js.native
  }

  private def props(
    id: UndefOr[String] = undefined,
    className: UndefOr[String] = undefined,
    style: UndefOr[js.Any] = undefined,
    onRemove: UndefOr[MessageHandler] = undefined,
    onClick: UndefOr[MessageHandler] = undefined
  ): Props = {
    val props = (new js.Object).asInstanceOf[Props]
    props.id = id
    props.className = className
    props.style = style
    props.onRemove = onRemove.map(handler =>
      (message: MessageItem) => handler(message).runNow()
    )
    props.onClick = onClick.map(handler =>
      (message: MessageItem) => handler(message).runNow()
    )
    props
  }

  private val component = JsComponent[Props, Children.None, Null](RawComponent)
    .addFacade[JsMethods]

  def toRef: MessagesRef = Ref
    .toJsComponentWithMountedFacade[Props, Null, JsMethods]

  def apply(
    ref: MessagesRef
  )(id: UndefOr[String] = undefined,
    className: UndefOr[String] = undefined,
    style: UndefOr[js.Any] = undefined,
    onRemove: UndefOr[MessageHandler] = undefined,
    onClick: UndefOr[MessageHandler] = undefined
  ): MessagesType =
    component.withRef(ref)(props(id, className, style, onRemove, onClick))
}
