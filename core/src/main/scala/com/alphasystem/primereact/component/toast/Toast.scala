package com.alphasystem.primereact.component.toast

import japgolly.scalajs.react.Ref.ToJsComponent
import japgolly.scalajs.react.component.Js.{ ComponentMapped, RawMounted }
import japgolly.scalajs.react.internal.Effect.Id
import japgolly.scalajs.react.{ Children, CtorType, JsComponent, Ref }

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.{ UndefOr, undefined }

object Toast {

  @JSImport("primereact/toast", "Toast")
  @js.native
  object RawComponent extends js.Function

  type MessageCallback = js.Function1[ToastMessage, Unit]

  @js.native
  trait Props extends js.Object {
    var id: UndefOr[String] = js.native
    var position: UndefOr[String] = js.native
    var className: UndefOr[String] = js.native
    var style: UndefOr[String] = js.native
    var baseZIndex: UndefOr[Int] = js.native
    var onRemove: UndefOr[MessageCallback] = js.native
    var onClick: UndefOr[MessageCallback] = js.native
  }

  @js.native
  trait JsMethods extends js.Object {
    def show(message: js.Array[ToastMessage]): Unit = js.native
    def show(message: ToastMessage): Unit = js.native
    def clear(): Unit = js.native
  }

  def props(
    id: UndefOr[String] = undefined,
    position: UndefOr[Position] = undefined,
    className: UndefOr[String] = undefined,
    style: UndefOr[String] = undefined,
    baseZIndex: UndefOr[Int] = undefined,
    onRemove: UndefOr[MessageCallback] = undefined,
    onClick: UndefOr[MessageCallback] = undefined
  ): Props = {
    val props = (new js.Object).asInstanceOf[Props]
    props.id = id
    props.position = position.map(_.entryName)
    props.className = className
    props.style = style
    props.baseZIndex = baseZIndex
    props.onRemove = onRemove
    props.onClick = onClick
    props
  }

  private[toast] val component =
    JsComponent[Props, Children.None, Null](RawComponent)
      .addFacade[JsMethods]

  type ToastRef =
    ToJsComponent[Props, Null, RawMounted[Props, Null] with JsMethods]

  def toRef: ToastRef = Ref
    .toJsComponentWithMountedFacade[Props, Null, JsMethods]

  type ToastType = ComponentMapped[
    Id,
    Props,
    Null,
    CtorType.Props,
    RawMounted[Props, Null] with JsMethods,
    Props,
    Null,
    CtorType.Props
  ]

  def apply(): ToastType = component
}
