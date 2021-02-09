package com.alphasystem.primereact.demo.components.messages

import com.alphasystem.primereact.component.button.{
  ButtonBuilder,
  Severity => ButtonSeverity
}
import com.alphasystem.primereact.component.inputtext.InputText
import com.alphasystem.primereact.component.message.{
  Message,
  MessageItem,
  Severity
}
import com.alphasystem.primereact.component.messages.Messages
import japgolly.scalajs.react._
import japgolly.scalajs.react.feature.ReactFragment
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

import scala.scalajs.js

object MessagesShowcase extends ScalaCssReactImplicits {

  case class Backend(b: BackendScope[Unit, Unit]) {

    private val msgRef1 = Messages.toRef
    private val msgRef2 = Messages.toRef
    private val msgRef3 = Messages.toRef

    def render: VdomElement =
      div(cls := "content-section implementation")(
        div(cls := "card")(
          severitiesExample,
          dynamicContentExample,
          staticContentExample,
          inlineMessagesExample,
          validationMessagesExample,
          formLayoutExample
        )
      )

    private def severitiesExample =
      ReactFragment(
        h5("Severities"),
        Messages(msgRef1)()
      )

    private def dynamicContentExample =
      ReactFragment(
        h5("Dynamic"),
        ButtonBuilder()
          .label("Show")
          .classNames("p-mr-2")
          .toButton(`type` := "button", onClick --> addMessages()),
        ButtonBuilder()
          .label("Clear")
          .severity(ButtonSeverity.Secondary)
          .toButton(`type` := "button", onClick --> clearMessages()),
        Messages(msgRef2)()
      )

    private def staticContentExample =
      ReactFragment(
        h5("Static Content"),
        Messages(msgRef3)()
      )

    private def inlineMessagesExample =
      ReactFragment(
        h5("Inline Message"),
        p(
          "Message component is used to display inline messages mostly within forms."
        ),
        div(cls := "p-grid")(
          div(cls := "p-col-12 p-md-3")(
            Message(
              severity = Severity.Info,
              text = "Message Content"
            )
          ),
          div(cls := "p-col-12 p-md-3")(
            Message(
              severity = Severity.Success,
              text = "Message Content"
            )
          ),
          div(cls := "p-col-12 p-md-3")(
            Message(
              severity = Severity.Warn,
              text = "Message Content"
            )
          ),
          div(cls := "p-col-12 p-md-3")(
            Message(
              severity = Severity.Error,
              text = "Message Content"
            )
          )
        )
      )

    private def validationMessagesExample =
      ReactFragment(
        h5("Validation Message"),
        div(cls := "p-formgroup-inline p-mb-2")(
          label(htmlFor := "username1", cls := "p-sr-only")("Username"),
          InputText()(
            id := "username1",
            placeholder := "Username",
            cls := "p-invalid p-mr-2"
          ),
          Message(
            severity = Severity.Error,
            text = "Username is required"
          )
        ),
        div(cls := "p-formgroup-inline")(
          label(htmlFor := "email", cls := "p-sr-only")("Email"),
          InputText()(
            id := "email",
            placeholder := "Email",
            cls := "p-invalid p-mr-2"
          ),
          Message(severity = Severity.Error)
        )
      )

    private def formLayoutExample =
      ReactFragment(
        h5("Form Layout"),
        div(cls := "p-field p-fluid")(
          label(htmlFor := "username2")("Username"),
          InputText()(
            id := "username2",
            placeholder := "Username",
            cls := "p-invalid p-mr-2"
          ),
          small(id := "username-help", cls := "p-error")(
            "Username is not available."
          )
        )
      )

    private val items: js.Array[MessageItem] = js.Array(
      MessageItem(
        severity = Severity.Success,
        summary = "Success",
        detail = "Message Content",
        sticky = true
      ),
      MessageItem(
        severity = Severity.Info,
        summary = "Info",
        detail = "Message Content",
        sticky = true
      ),
      MessageItem(
        severity = Severity.Warn,
        summary = "Warning",
        detail = "Message Content",
        sticky = true
      ),
      MessageItem(
        severity = Severity.Error,
        summary = "Error",
        detail = "Message Content",
        sticky = true
      )
    )

    private def addMessages() = msgRef2.foreach(_.raw.show(items))

    private def clearMessages() = msgRef2.foreach(_.raw.clear())

    def init(): Callback = {
      def onErrorHandler(event: ReactEventFromInput) = Callback {
        event.target.src =
          "https://www.primefaces.org/wp-content/uploads/2020/05/placeholder.png"
      }
      val content =
        ReactFragment(
          img(
            alt := "logo",
            src := "./assets/images/logo.png",
            width := "32px",
            onError ==> onErrorHandler
          ),
          div(cls := "p-ml-2")("Always bet on Prime.")
        ).rawElement

      msgRef1.foreach(_.raw.show(items)) >> msgRef3.foreach(
        _.raw.show(
          MessageItem(
            severity = Severity.Info,
            sticky = true,
            content = content
          )
        )
      )
    }
  }

  private val component = ScalaComponent
    .builder[Unit]("MessagesShowcase")
    .renderBackend[Backend]
    .componentDidMount(_.backend.init())
    .componentDidUpdate(_.backend.init())
    .build

  def apply(): VdomElement = component()
}
