package com.alphasystem.primereact.component.autocomplete

import com.alphasystem.primereact._
import japgolly.scalajs.react.component.Js.Component
import japgolly.scalajs.react.raw.React.DomElement
import japgolly.scalajs.react.{
  Children,
  CtorType,
  JsComponent,
  ReactEventFromInput
}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.{ UndefOr, native, undefined, | }

object AutoComplete {

  type QueryEventCallback = js.Function1[QueryEvent, Unit]
  type QueryEventHandler = CallbackHandler1[QueryEvent]

  type ValueEventCallback = js.Function1[ValueEvent, Unit]
  type ValueEventHandler = CallbackHandler1[ValueEvent]

  type EventCallback = js.Function1[ReactEventFromInput, Unit]
  type EventHandler = CallbackHandler1[ReactEventFromInput]

  @JSImport("primereact/autocomplete", "AutoComplete")
  @js.native
  private object RawComponent extends js.Function

  @js.native
  trait Props extends js.Object {
    var id: UndefOr[String] = native
    var value: UndefOr[String | js.Any] = native
    var name: UndefOr[String] = native
    var `type`: UndefOr[String] = native
    var suggestions: UndefOr[js.Any] = native
    var field: UndefOr[String | js.Any] = native
    var scrollHeight: UndefOr[String] = native
    var dropdown: UndefOr[Boolean] = native
    var dropdownMode: UndefOr[String] = native
    var multiple: UndefOr[Boolean] = native
    var minLength: UndefOr[Int] = native
    var delay: UndefOr[Int] = native
    var style: UndefOr[String] = native
    var className: UndefOr[String] = native
    var inputId: UndefOr[String] = native
    var inputStyle: UndefOr[String] = native
    var inputClassName: UndefOr[String] = native
    var panelStyle: UndefOr[String] = native
    var panelClassName: UndefOr[String] = native
    var placeholder: UndefOr[String] = native
    var readonly: UndefOr[Boolean] = native
    var disabled: UndefOr[Boolean] = native
    var maxlength: UndefOr[Int] = native
    var size: UndefOr[Int] = native
    var appendTo: UndefOr[DomElement] = native
    var tabindex: UndefOr[Int] = native
    var autoFocus: UndefOr[Boolean] = native
    var tooltip: UndefOr[js.Any] = native
    var tooltipOptions: UndefOr[js.Any] = native
    var ariaLabelledBy: UndefOr[String] = native
    var itemTemplate: UndefOr[js.Function1[js.Object, js.Any]] = native
    var selectedItemTemplate: UndefOr[js.Function1[js.Object, js.Any]] = native
    var completeMethod: UndefOr[QueryEventCallback] = native
    var onChange: UndefOr[ValueEventCallback] = native
    var onFocus: UndefOr[EventCallback] = native
    var onBlur: UndefOr[EventCallback] = native
    var onSelect: UndefOr[ValueEventCallback] = native
    var onUnselect: UndefOr[ValueEventCallback] = native
    var onDropdownClick: UndefOr[QueryEventCallback] = native
    var onClick: UndefOr[EventCallback] = native
    var onDblClick: UndefOr[EventCallback] = native
    var onMouseDown: UndefOr[EventCallback] = native
    var onKeyUp: UndefOr[EventCallback] = native
    var onKeyPress: UndefOr[EventCallback] = native
    var onContextMenu: UndefOr[EventCallback] = native
    var onClear: UndefOr[EventCallback] = native
  }

  def props(
    id: UndefOr[String] = undefined,
    value: UndefOr[String | js.Any] = undefined,
    name: UndefOr[String] = undefined,
    `type`: UndefOr[String] = undefined,
    suggestions: UndefOr[js.Any] = undefined,
    field: UndefOr[String | js.Any] = undefined,
    scrollHeight: UndefOr[String] = undefined,
    dropdown: UndefOr[Boolean] = undefined,
    dropdownMode: UndefOr[String] = undefined,
    multiple: UndefOr[Boolean] = undefined,
    minLength: UndefOr[Int] = undefined,
    delay: UndefOr[Int] = undefined,
    style: UndefOr[String] = undefined,
    className: UndefOr[String] = undefined,
    inputId: UndefOr[String] = undefined,
    inputStyle: UndefOr[String] = undefined,
    inputClassName: UndefOr[String] = undefined,
    panelStyle: UndefOr[String] = undefined,
    panelClassName: UndefOr[String] = undefined,
    placeholder: UndefOr[String] = undefined,
    readonly: UndefOr[Boolean] = undefined,
    disabled: UndefOr[Boolean] = undefined,
    maxlength: UndefOr[Int] = undefined,
    size: UndefOr[Int] = undefined,
    appendTo: UndefOr[DomElement] = undefined,
    tabindex: UndefOr[Int] = undefined,
    autoFocus: UndefOr[Boolean] = undefined,
    tooltip: UndefOr[js.Any] = undefined,
    tooltipOptions: UndefOr[js.Any] = undefined,
    ariaLabelledBy: UndefOr[String] = undefined,
    itemTemplate: UndefOr[Handler1[js.Object, js.Any]] = undefined,
    selectedItemTemplate: UndefOr[Handler1[js.Object, js.Any]] = undefined,
    completeMethod: UndefOr[QueryEventHandler] = undefined,
    onChange: UndefOr[ValueEventHandler] = undefined,
    onFocus: UndefOr[EventHandler] = undefined,
    onBlur: UndefOr[EventHandler] = undefined,
    onSelect: UndefOr[ValueEventHandler] = undefined,
    onUnselect: UndefOr[ValueEventHandler] = undefined,
    onDropdownClick: UndefOr[QueryEventHandler] = undefined,
    onClick: UndefOr[EventHandler] = undefined,
    onDblClick: UndefOr[EventHandler] = undefined,
    onMouseDown: UndefOr[EventHandler] = undefined,
    onKeyUp: UndefOr[EventHandler] = undefined,
    onKeyPress: UndefOr[EventHandler] = undefined,
    onContextMenu: UndefOr[EventHandler] = undefined,
    onClear: UndefOr[EventHandler] = undefined
  ): Props = {
    val props = (new js.Object).asInstanceOf[Props]
    props.id = id
    props.value = value
    props.name = name
    props.`type` = `type`
    props.suggestions = suggestions
    props.field = field
    props.scrollHeight = scrollHeight
    props.dropdown = dropdown
    props.dropdownMode = dropdownMode
    props.multiple = multiple
    props.minLength = minLength
    props.delay = delay
    props.style = style
    props.className = className
    props.inputId = inputId
    props.inputStyle = inputStyle
    props.inputClassName = inputClassName
    props.panelClassName = panelClassName
    props.panelStyle = panelStyle
    props.placeholder = placeholder
    props.readonly = readonly
    props.disabled = disabled
    props.maxlength = maxlength
    props.size = size
    props.appendTo = appendTo
    props.tabindex = tabindex
    props.autoFocus = autoFocus
    props.tooltip = tooltip
    props.tooltipOptions = tooltipOptions
    props.ariaLabelledBy = ariaLabelledBy
    props.itemTemplate =
      itemTemplate.map(handler => (item: js.Object) => handler(item))
    props.selectedItemTemplate =
      selectedItemTemplate.map(handler => (item: js.Object) => handler(item))
    props.completeMethod =
      completeMethod.map(handler => (e: QueryEvent) => handler(e).runNow())
    props.onChange =
      onChange.map(handler => (e: ValueEvent) => handler(e).runNow())
    props.onFocus = onFocus.map(handler =>
      (event: ReactEventFromInput) => handler(event).runNow()
    )
    props.onBlur = onBlur.map(handler =>
      (event: ReactEventFromInput) => handler(event).runNow()
    )
    props.onSelect =
      onSelect.map(handler => (e: ValueEvent) => handler(e).runNow())
    props.onUnselect =
      onUnselect.map(handler => (e: ValueEvent) => handler(e).runNow())
    props.onDropdownClick =
      onDropdownClick.map(handler => (e: QueryEvent) => handler(e).runNow())
    props.onClick = onClick.map(handler =>
      (event: ReactEventFromInput) => handler(event).runNow()
    )
    props.onDblClick = onDblClick.map(handler =>
      (event: ReactEventFromInput) => handler(event).runNow()
    )
    props.onMouseDown = onMouseDown.map(handler =>
      (event: ReactEventFromInput) => handler(event).runNow()
    )
    props.onKeyUp = onKeyUp
      .map(handler => (event: ReactEventFromInput) => handler(event).runNow())
    props.onKeyPress = onKeyPress.map(handler =>
      (event: ReactEventFromInput) => handler(event).runNow()
    )
    props.onContextMenu = onContextMenu.map(handler =>
      (event: ReactEventFromInput) => handler(event).runNow()
    )
    props.onClear = onClear.map(handler =>
      (event: ReactEventFromInput) => handler(event).runNow()
    )
    props
  }

  type AutoCompleteType = Component[Props, Null, CtorType.Props]

  private val component = JsComponent[Props, Children.None, Null](RawComponent)

  def apply(): AutoCompleteType = component
}

@js.native
trait QueryEvent extends js.Object {
  val originalEvent: ReactEventFromInput
  val query: String
}

@js.native
trait ValueEvent extends js.Object {
  val originalEvent: ReactEventFromInput
  val value: js.Any
}
