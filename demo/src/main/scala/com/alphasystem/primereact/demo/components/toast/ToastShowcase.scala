package com.alphasystem.primereact.demo.components.toast

import com.alphasystem.primereact.ExternalCss
import com.alphasystem.primereact.component.button.{
  ButtonBuilder,
  Severity => ButtonSeverity
}
import com.alphasystem.primereact.component.toast.{
  Position,
  Severity,
  Toast,
  ToastMessage
}
import com.alphasystem.primereact.css.CommonStyles
import com.alphasystem.primereact.icons.Icon
import japgolly.scalajs.react._
import japgolly.scalajs.react.feature.ReactFragment
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

object ToastShowcase extends ScalaCssReactImplicits {

  @js.native
  @JSImport(
    "../../../../src/main/resources/assets/app/ToastDemo.css",
    JSImport.Namespace
  )
  private object ToastDemoCss extends ExternalCss

  private val css = ToastDemoCss

  case class Backend(b: BackendScope[Unit, Unit]) {

    private val toast = Toast.toRef
    private val toastTL = Toast.toRef
    private val toastBL = Toast.toRef
    private val toastBR = Toast.toRef
    private val toastBC = Toast.toRef
    private val toastTC = Toast.toRef

    private def createMessage(
      severity: Severity,
      summary: js.Any,
      detail: js.Any = "Message Content",
      sticky: Boolean = false
    ) =
      ToastMessage(
        severity = severity,
        summary = summary,
        detail = detail,
        sticky = sticky,
        life = 3000
      )

    private def showSuccess =
      toast.foreach(
        _.raw.show(createMessage(Severity.Success, "Success Message"))
      )

    private def showInfo =
      toast.foreach(_.raw.show(createMessage(Severity.Info, "Info Message")))

    private def showWarn =
      toast.foreach(_.raw.show(createMessage(Severity.Warn, "Warn Message")))

    private def showError =
      toast.foreach(_.raw.show(createMessage(Severity.Error, "Error Message")))

    private def showTopLeft =
      toastTL.foreach(_.raw.show(createMessage(Severity.Info, "Info Message")))

    private def showBottomLeft =
      toastBL.foreach(_.raw.show(createMessage(Severity.Warn, "Warn Message")))

    private def showBottomRight =
      toastBR.foreach(
        _.raw.show(createMessage(Severity.Success, "Success Message"))
      )

    private def showTopCenter =
      toastTC.foreach(
        _.raw.show(createMessage(Severity.Error, "Error Message"))
      )

    private def showMultiple = {
      val messages = js.Array(
        createMessage(Severity.Info, "Message 1", "Message 1 Content"),
        createMessage(Severity.Info, "Message 2", "Message 2 Content"),
        createMessage(Severity.Info, "Message 3", "Message 3 Content")
      )
      toast.foreach(_.raw.show(messages))
    }

    private def showSticky = {
      val summary = div(fontWeight.bolder)("Sticky Message")
      val detail = div(fontStyle.italic, fontSize := "20px")("Message Content")
      toast.foreach(
        _.raw.show(
          createMessage(
            severity = Severity.Info,
            summary = summary.rawElement,
            detail = detail.rawElement,
            sticky = true
          )
        )
      )
    }

    private def clear = toast.foreach(_.raw.clear())

    private def displaySeverities =
      ReactFragment(
        h5("Severities"),
        ButtonBuilder()
          .label("Success")
          .severity(ButtonSeverity.Success)
          .toButton(onClick --> showSuccess),
        ButtonBuilder()
          .label("Info")
          .severity(ButtonSeverity.Info)
          .toButton(onClick --> showInfo),
        ButtonBuilder()
          .label("Warn")
          .severity(ButtonSeverity.Warning)
          .toButton(onClick --> showWarn),
        ButtonBuilder()
          .label("Error")
          .severity(ButtonSeverity.Danger)
          .toButton(onClick --> showError)
      )

    private def displayPositions =
      ReactFragment(
        h5("Positions"),
        ButtonBuilder()
          .label("Top Left")
          .classNames("p-mr-2")
          .toButton(onClick --> showTopLeft),
        ButtonBuilder()
          .label("Bottom Left")
          .severity(ButtonSeverity.Warning)
          .toButton(onClick --> showBottomLeft),
        ButtonBuilder()
          .label("Bottom Right")
          .severity(ButtonSeverity.Success)
          .toButton(onClick --> showBottomRight),
        ButtonBuilder()
          .label("Top Center")
          .severity(ButtonSeverity.Danger)
          .toButton(onClick --> showTopCenter)
      )

    private def displayOptions =
      ReactFragment(
        h5("Options"),
        ButtonBuilder()
          .label("Multiple")
          .severity(ButtonSeverity.Warning)
          .toButton(onClick --> showMultiple),
        ButtonBuilder()
          .label("Sticky")
          .toButton(onClick --> showSticky)
      )

    private def displayClear =
      ReactFragment(
        h5("Clear"),
        ButtonBuilder()
          .label("Clear")
          .toButton(onClick --> clear)
      )

    private def showConfirm = {
      val content =
        div(cls := "p-flex p-flex-column", flex := "1")(
          div(cls := "p-text-center")(
            i(cls := Icon.ExclamationTriangle.toClassName)(
              CommonStyles.size(3)
            ),
            h4("Are you sure?"),
            p("Confirm to proceed")
          ),
          div(cls := "p-grid p-fluid")(
            div(cls := "p-col-6")(
              ButtonBuilder()
                .label("Yes")
                .severity(ButtonSeverity.Success)
                .toButton(`type` := "button")
            ),
            div(cls := "p-col-6")(
              ButtonBuilder()
                .label("No")
                .severity(ButtonSeverity.Secondary)
                .toButton(`type` := "button")
            )
          )
        )

      toastBC.foreach(
        _.raw.show(
          ToastMessage(
            severity = Severity.Warn,
            content = content.rawElement
          )
        )
      )
    }

    private def displayCustom =
      ReactFragment(
        h5("Custom"),
        ButtonBuilder()
          .label("Confirm")
          .toButton(onClick --> showConfirm)
      )

    def render: VdomElement = {
      div(cls := "content-section implementation")(
        Toast(toast)(Toast.props()),
        Toast(toastTL)(
          Toast.props(position = Position.TopLeft)
        ),
        Toast(toastBL)(
          Toast.props(position = Position.BottomLeft)
        ),
        Toast(toastBR)(
          Toast.props(position = Position.BottomRight)
        ),
        Toast(toastBC)(
          Toast.props(position = Position.BottomCenter)
        ),
        Toast(toastTC)(
          Toast.props(position = Position.TopCenter)
        ),
        div(cls := "card toast-demo")(
          displaySeverities,
          displayPositions,
          displayOptions,
          displayClear,
          displayCustom
        )
      )
    }
  }

  private val component = ScalaComponent
    .builder[Unit]("ToastShowcase")
    .renderBackend[Backend]
    .build

  def apply(): VdomElement = component()
}
