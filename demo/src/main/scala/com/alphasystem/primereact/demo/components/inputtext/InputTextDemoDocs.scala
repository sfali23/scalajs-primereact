package com.alphasystem.primereact.demo.components.inputtext

import com.alphasystem.primereact.component.tabview.{ TabPanel, TabView }
import com.alphasystem.primereact.demo.components.CodeHighlighter
import com.alphasystem.primereact.demo.{
  SourceCodeLink,
  importExample,
  routerLink
}
import japgolly.scalajs.react._
import japgolly.scalajs.react.feature.ReactFragment
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

object InputTextDemoDocs extends ScalaCssReactImplicits with SourceCodeLink {

  case class Backend(b: BackendScope[Unit, Unit]) {

    def render: VdomElement =
      div(cls := "content-section documentation")(
        TabView()(
          TabPanel(header = "Documentation")(
            importExample(
              "com.alphasystem.primereact.component.inputtext.InputText"
            ),
            gettingStartedExample,
            floatingLabelExample,
            h5("KeyFilter"),
            p(
              span(
                "InputText has built-in key filtering support to block certain keys, refer to "
              ),
              routerLink("keyfilter", "keyfilter"),
              span(" page for more information.")
            ),
            sourceCodeLink(
              "InputTextPage.scala",
              "inputtext/InputTextShowcase.scala"
            )
          )
        )
      )

    private def gettingStartedExample =
      ReactFragment(
        h5("Getting Started"),
        p(
          span("InputText is used as a controlled input with "),
          i("value"),
          span(" and "),
          i("onChange"),
          span(" properties.")
        ),
        CodeHighlighter()(
          """
            |final case class State(value: String) {
            |  def updateValue(newValue: String): State = copy(value = newValue)
            |}
            |
            |final case class Backend(b: BackendScope[Unit, State]) {
            |  private def updateValue1(e: ReactEventFromInput) =
            |      b.modState(_.updateValue(e.target.value))
            |      
            |  def render(state: State): VdomElement =
            |    InputText()(
            |      value := state.value,
            |      onChange ==> updateValue
            |    )
            |}
            |
            |""".stripMargin
        )
      )

    private def floatingLabelExample =
      ReactFragment(
        h5("Float Label"),
        p(
          span(
            "A floating label is implemented by wrapping the input and the label inside a container having "
          ),
          i(".p-float-label"),
          span(" style class.")
        ),
        CodeHighlighter()(
          """
            |span(cls := "p-float-label")(
            |  InputText()(
            |    id := "username",
            |    value := state.value,
            |    onChange ==> updateValue
            |  ),
            |  label(htmlFor := "username")("Username")
            |)
            |
            |""".stripMargin
        )
      )
  }

  private val component = ScalaComponent
    .builder[Unit]("InputTextDemoDocs")
    .renderBackend[Backend]
    .build

  def apply(): VdomElement = component()
}
