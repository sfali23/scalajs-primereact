package com.alphasystem.primereact.demo.components.dialog

import com.alphasystem.primereact.component.tabview.{ TabPanel, TabView }
import com.alphasystem.primereact.demo.components.CodeHighlighter
import com.alphasystem.primereact.demo.{ SourceCodeLink, importExample }
import japgolly.scalajs.react._
import japgolly.scalajs.react.feature.ReactFragment
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

object DialogDemoDocs extends ScalaCssReactImplicits with SourceCodeLink {

  case class Backend(b: BackendScope[Unit, Unit]) {

    def render: VdomElement =
      div(cls := "content-section documentation")(
        TabView()(
          TabPanel(header = "Documentation")(
            importExample(
              "com.alphasystem.primereact.component.dialog.Dialog"
            ),
            gettingStartedExample,
            headerFooterExample,
            sourceCodeLink("DialogPage.scala", "dialog/DialogShowcase.scala")
          )
        )
      )

    private def gettingStartedExample =
      ReactFragment(
        h5("Getting Started"),
        p(
          span("Dialog is used as a container and visibility is managed with "),
          i("visible"),
          span(" property where "),
          i("onHide"),
          span(" event is required to update the visibility state.")
        ),
        CodeHighlighter()("""
                            |ButtonBuilder()
                            |   .label("Show")
                            |   .icon(Icon.ExternalLink)
                            |   .toButton(onClick --> clickHandler)
                            |   
                            |Dialog(
                            |   header = "Header",
                            |   visible = state.dialogVisibility,
                            |   onHide = () => hideHandler
                            |)(p("Dialog content"))
                            |
                            |""".stripMargin)
      )

    private def headerFooterExample =
      ReactFragment(
        h5("Header and Footer"),
        p(
          """Header and Footer sections are defined using properties with the same name that accept simple strings or 
            |JSX for custom content. In addition """.stripMargin,
          i("icons"),
          span(" property enables adding more icons at the header section.")
        ),
        CodeHighlighter()(
          """
            |def renderFooter(hideHandler: Callback): React.Element =
            |    div(
            |      ButtonBuilder()
            |        .label("No")
            |        .icon(Icon.Times)
            |        .text
            |        .toButton(onClick --> hideHandler),
            |      ButtonBuilder()
            |        .label("Yes")
            |        .icon(Icon.Check)
            |        .toButton(
            |          autoFocus := true,
            |          onClick --> hideHandler
            |        )
            |    ).rawElement
            |    
            |def icon =
            |      button(cls := "p-dialog-titlebar-icon p-link")(
            |        span(cls := "pi pi-search")
            |      ).rawElement
            |      
            |Dialog(
            |   header = "Header",
            |   footer = renderFooter(hideHandler)
            |   visible = state.dialogVisibility,
            |   icons = icon,
            |   onHide = () => hideHandler
            |)(p("Dialog content"))
            |""".stripMargin
        )
      )
  }

  private val component = ScalaComponent
    .builder[Unit]("DialogDemoDocs")
    .renderBackend[Backend]
    .build

  def apply(): VdomElement = component()
}
