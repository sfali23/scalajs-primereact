package com.alphasystem.primereact.demo.components.messages

import com.alphasystem.primereact.component.tabview.{ TabPanel, TabView }
import com.alphasystem.primereact.demo.components.CodeHighlighter
import com.alphasystem.primereact.demo.{ SourceCodeLink, importExample }
import japgolly.scalajs.react._
import japgolly.scalajs.react.feature.ReactFragment
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

object MessagesDemoDocs extends ScalaCssReactImplicits with SourceCodeLink {

  case class Backend(b: BackendScope[Unit, Unit]) {

    def render: VdomElement =
      div(cls := "content-section documentation")(
        TabView()(
          TabPanel(header = "Documentation")(
            importExample(
              "com.alphasystem.primereact.component.messages.Messages",
              "com.alphasystem.primereact.component.message.Message",
              "com.alphasystem.primereact.component.message.MessageItem"
            ),
            gettingStartedExample,
            messageApiExample,
            severitiesExample,
            clearMessageExample,
            replaceMessageExample,
            closableMessageExample,
            stickyMessageExample,
            messageComponentExample,
            sourceCodeLink(
              "MessagesPage.scala",
              "messages/MessagesShowcase.scala"
            )
          )
        )
      )

    private def gettingStartedExample =
      ReactFragment(
        h5("Getting Started"),
        p(
          span(
            """A single message is specified by the Message interface in PrimeReact that defines various properties
              | such as severity, summary and detail. Messages are displayed by using the """.stripMargin
          ),
          i("show"),
          span(" method on the ref of the Messages instance.")
        ),
        p(
          "Note that for animations, messages requires react-transition-group package."
        ),
        CodeHighlighter()("""
                            |val ref = Messages.toRef
                            |
                            |Messages(ref)()
                            |
                            |val item = MessageItem(
                            |             severity = Severity.Success,
                            |             summary = "Success",
                            |             detail = "Message Content",
                            |             sticky = true
                            |           )
                            |ref.foreach(_.raw.show(item))
                            |""".stripMargin)
      )

    private def messageApiExample =
      ReactFragment(
        h5("Message API"),
        CodeHighlighter()(
          """
            |@js.native
            |trait MessageItem extends js.Object {
            |
            |  /*
            |   * Severity of the message.
            |   */
            |  val severity: UndefOr[String] = undefined
            |
            |  /*
            |   * Summary content of the message.
            |   */
            |  val summary: UndefOr[String | js.Any] = undefined
            |
            |  /*
            |   * Detail content of the message.
            |   */
            |  val detail: UndefOr[String | js.Any] = undefined
            |
            |  /*
            |   * Template of the message.
            |   */
            |  val content: UndefOr[js.Any] = undefined
            |
            |  /*
            |   * Whether the message can be closed manually using the close icon.
            |   */
            |  val closable: UndefOr[Boolean] = undefined
            |
            |  /*
            |   * When enabled, message is not removed automatically.
            |   */
            |  val sticky: UndefOr[Boolean] = undefined
            |
            |  /*
            |   * Delay in milliseconds to close the message automatically.
            |   */
            |  val life: UndefOr[Int] = undefined
            |}
            |""".stripMargin
        )
      )

    private def severitiesExample =
      ReactFragment(
        h5("Showing Messages"),
        CodeHighlighter()(
          """
            |val ref = Messages.toRef
            |
            |Messages(ref)()
            |
            |val successMessage =
            |   MessageItem(
            |     severity = Severity.Success,
            |     summary = "Success",
            |     detail = "Message Content"
            |   )
            |                     
            |val infoMessage = 
            |   MessageItem(
            |     severity = Severity.Info,
            |     summary = "Info",
            |     detail = "Message Content"
            |   )
            |                  
            |val warnMessage = 
            |   MessageItem(
            |     severity = Severity.Warn,
            |     summary = "Warning",
            |     detail = "Message Content"
            |   )
            |                  
            |val errorMessage = 
            |   MessageItem(
            |     severity = Severity.Error,
            |     summary = "Error",
            |     detail = "Message Content"
            |   )
            |
            |val multipleMessages =
            |   js.Array(
            |       successMessage, 
            |       infoMessage, 
            |       warnMessage, 
            |       errorMessage
            |   )
            |                  
            |ref.foreach(_.raw.show(successMessage))
            |ref.foreach(_.raw.show(infoMessage))
            |ref.foreach(_.raw.show(warnMessage))
            |ref.foreach(_.raw.show(errorMessage))
            |ref.foreach(_.raw.show(multipleMessages))
            |
            |""".stripMargin
        )
      )

    private def clearMessageExample =
      ReactFragment(
        h5("Clearing Messages"),
        p(i("clear()"), span("method removes all messages.")),
        CodeHighlighter()("""
                            |ref.foreach(_.raw.clear())
                            |
                            |""".stripMargin)
      )

    private def replaceMessageExample =
      ReactFragment(
        h5("Replacing Messages"),
        p(
          i("replace(newMessages)"),
          span(" method adds new messages after removing all old messages.")
        ),
        CodeHighlighter()("""
                            |ref.foreach(_.raw.replace(newMessages))
                            |
                            |""".stripMargin)
      )

    private def closableMessageExample =
      ReactFragment(
        h5("Closable"),
        p(
          span("""Messages are closable by default resulting in a close icon being displayed on top right corner. In 
                 |order to disable closable messages, set """.stripMargin),
          i("closable"),
          span(" to false.")
        ),
        CodeHighlighter()("""
                            |val message =
                            |   MessageItem(
                            |     severity = Severity.Success,
                            |     summary = "Success",
                            |     detail = "Message Content",
                            |     closable = false
                            |   )
                            |
                            |ref.foreach(_.raw.show(message))
                            |
                            |""".stripMargin)
      )

    private def stickyMessageExample =
      ReactFragment(
        h5("Sticky"),
        p(
          span(
            "Messages are cleared automatically after the timeout defined by "
          ),
          i("life"),
          span("  property which is 3 seconds by default. Use "),
          i("sticky"),
          span(" mode to make them stay until they are manually removed.")
        ),
        CodeHighlighter()("""
                            |val message1 =
                            |   MessageItem(
                            |     severity = Severity.Success,
                            |     summary = "Success",
                            |     detail = "Message Content",
                            |     sticky = true
                            |   )
                            |
                            |//sticky
                            |ref.foreach(_.raw.show(message1))
                            |
                            |val message2 =
                            |   MessageItem(
                            |     severity = Severity.Success,
                            |     summary = "Success",
                            |     detail = "Message Content",
                            |     life = 5000
                            |   )
                            |
                            |//automatically removed after 5 seconds
                            |ref.foreach(_.raw.show(message2))
                            |""".stripMargin)
      )

    private def messageComponentExample =
      ReactFragment(
        h5("Message Component"),
        p(
          span(
            """Message component is useful in cases where a single message needs to be displayed related to an 
              |element such as forms. It has two properties, """.stripMargin
          ),
          i("severity"),
          span(" and "),
          i("text"),
          span(" of the message.")
        ),
        CodeHighlighter()("""
                            |Message(
                            |   severity = Severity.Info,
                            |   text = "PrimeNG Rocks"
                            |)
                            |
                            |Message(
                            |   severity = Severity.Success,
                            |   text = "Record Saved"
                            |)
                            |
                            |Message(
                            |   severity = Severity.Warn,
                            |   text = "Are you sure?"
                            |)
                            |
                            |Message(
                            |   severity = Severity.Error,
                            |   text = "Field is required"
                            |)
                            |""".stripMargin)
      )
  }

  private val component = ScalaComponent
    .builder[Unit]("MessagesDemoDocs")
    .renderBackend[Backend]
    .build

  def apply(): VdomElement = component()
}
