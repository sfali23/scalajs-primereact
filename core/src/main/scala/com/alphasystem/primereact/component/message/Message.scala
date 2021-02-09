package com.alphasystem.primereact.component.message

import japgolly.scalajs.react.{ Children, JsComponent, Ref }
import japgolly.scalajs.react.Ref.ToJsComponent
import japgolly.scalajs.react.component.Js.{ RawMounted, UnmountedMapped }
import japgolly.scalajs.react.internal.Effect.Id

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.{ UndefOr, undefined }

object Message {

  @JSImport("primereact/message", "Message")
  @js.native
  object RawComponent extends js.Function

  type MessageRef = ToJsComponent[Props, Null, RawMounted[Props, Null]]

  type MessageType =
    UnmountedMapped[Id, Props, Null, RawMounted[Props, Null], Props, Null]

  @js.native
  trait Props extends js.Object {
    var id: UndefOr[String] = js.native
    var className: UndefOr[String] = js.native
    var style: UndefOr[js.Any] = js.native
    var severity: UndefOr[String] = js.native
    var text: UndefOr[String] = js.native
    var content: UndefOr[js.Any] = js.native
  }

  def props(
    id: UndefOr[String] = undefined,
    className: UndefOr[String] = undefined,
    style: UndefOr[js.Any] = undefined,
    severity: UndefOr[Severity] = undefined,
    text: UndefOr[String] = undefined,
    content: UndefOr[js.Any] = undefined
  ): Props = {
    val props = (new js.Object).asInstanceOf[Props]
    props.id = id
    props.className = className
    props.style = style
    props.severity = severity.map(_.entryName)
    props.text = text
    props.content = content
    props
  }

  def toRef: MessageRef = Ref.toJsComponent[Props, Null]

  private val component = JsComponent[Props, Children.None, Null](RawComponent)

  def apply(ref: MessageRef)(props: Props): MessageType =
    component.withRef(ref)(props)

  def apply(
    id: UndefOr[String] = undefined,
    className: UndefOr[String] = undefined,
    style: UndefOr[js.Any] = undefined,
    severity: UndefOr[Severity] = undefined,
    text: UndefOr[String] = undefined,
    content: UndefOr[js.Any] = undefined
  ): MessageType = component(
    props(id, className, style, severity, text, content)
  )
}
