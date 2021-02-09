package com.alphasystem.primereact.demo.components.splitbutton

import com.alphasystem.primereact._
import com.alphasystem.primereact.component.button.Severity
import com.alphasystem.primereact.component.message
import com.alphasystem.primereact.component.message.MessageItem
import com.alphasystem.primereact.component.splitbutton.SplitButtonBuilder
import com.alphasystem.primereact.component.toast.Toast
import com.alphasystem.primereact.demo.components.menu._
import com.alphasystem.primereact.icons.Icon
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

object SplitButtonShowcase extends ScalaCssReactImplicits {

  case class Backend(b: BackendScope[Unit, Unit]) {

    private val toastRef = Toast.toRef

    private lazy val items = List(
      updateMenuItem(toastRef),
      deleteMenuItem(toastRef),
      reactMenuItem,
      routerMenuItem
    )

    private def save = toastRef.foreach(
      _.raw.show(
        MessageItem(
          severity = message.Severity.Success,
          summary = "Success".toJsAny,
          detail = "Data Saved".toJsAny
        )
      )
    )

    private def splitButton =
      SplitButtonBuilder()
        .label("Save")
        .icon(Icon.Plus)
        .model(items)
        .classNames("p-mr-2")

    def render: VdomElement =
      div(cls := "content-section implementation")(
        Toast(toastRef)(Toast.props()),
        div(cls := "card")(
          h5("Basic"),
          splitButton.toSplitButton(onClick --> save),
          //
          h5("Severities"),
          splitButton.toSplitButton(onClick --> save),
          splitButton
            .severity(Severity.Secondary)
            .toSplitButton(onClick --> save),
          splitButton
            .severity(Severity.Success)
            .toSplitButton(onClick --> save),
          splitButton
            .severity(Severity.Info)
            .toSplitButton(onClick --> save),
          splitButton
            .severity(Severity.Warning)
            .toSplitButton(onClick --> save),
          splitButton
            .severity(Severity.Help)
            .toSplitButton(onClick --> save),
          splitButton
            .severity(Severity.Danger)
            .toSplitButton(onClick --> save)
        )
      )
  }

  private val component = ScalaComponent
    .builder[Unit]("SplitButtonShowcase")
    .renderBackend[Backend]
    .build

  def apply(): VdomElement = component()
}
