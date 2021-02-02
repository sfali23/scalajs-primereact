package com.alphasystem.primereact.demo.components.toast

import com.alphasystem.primereact.component.tabview.{ TabPanel, TabView }
import com.alphasystem.primereact.demo.components.CodeHighlighter
import com.alphasystem.primereact.demo.{ SourceCodeLink, importExample }
import japgolly.scalajs.react._
import japgolly.scalajs.react.feature.ReactFragment
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

object ToastDemoDocs extends ScalaCssReactImplicits with SourceCodeLink {

  case class Backend(b: BackendScope[Unit, Unit]) {

    def render: VdomElement =
      div(cls := "content-section documentation")(
        TabView()(
          TabPanel(header = "Documentation")(
            importExample(
              "com.alphasystem.primereact.component.toast.Toast",
              "com.alphasystem.primereact.component.toast.ToastMessage"
            ),
            gettingStartedExample,
            customizationExample,
            sourceCodeLink("ToastPage.scala", "toast/ToastShowcase.scala")
          )
        )
      )

    private def gettingStartedExample =
      ReactFragment(
        h5("Getting Started"),
        p(
          span(
            """A single message is represented by the Message interface in PrimeReact that defines various 
              |properties such as severity, summary and detail. Messages are displayed by using the """.stripMargin
          ),
          i("show"),
          span(" method on the ref of the Toast instance.")
        ),
        p(
          "Note that for animations, toast requires react-transition-group package."
        ),
        CodeHighlighter()("""val toast = Toast.toRef
                            |Toast().withRef(toast)(Toast.props())
                            |""".stripMargin),
        CodeHighlighter()(
          """ val message = ToastMessage(
            |                   severity = Some(Severity.Info),
            |                   summary = Some("Info Message"),
            |                   detail = Some("Message Content")
            |               )
            |toast.foreach(_.raw.show(message))               
            |""".stripMargin
        )
      )

    private def customizationExample =
      ReactFragment(
        h5("Customization"),
        CodeHighlighter()(
          """val toast = Toast.toRef
            |Toast().withRef(toast)(Toast.props(position = Position.TopLeft))
            |
            |val summary = div(fontWeight.bolder)("Sticky Message")
            |val detail = div(fontStyle.italic, fontSize := "20px")("Message Content")
            |
            |val message = ToastMessage(
            |                   severity = Some(Severity.Info),
            |                   summary = Some(summary),
            |                   detail = Some(detail),
            |                   sticky = Some(true),
            |                   life = Some(5000)
            |               )
            |""".stripMargin
        )
      )
  }

  private val component = ScalaComponent
    .builder[Unit]("ToastDemoDocs")
    .renderBackend[Backend]
    .build

  def apply(): VdomElement = component()
}
