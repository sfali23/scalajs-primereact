package com.alphasystem.primereact.demo.components.button

import com.alphasystem.primereact.component.tabview.{ TabPanel, TabView }
import com.alphasystem.primereact.demo.{ SourceCodeLink, SourceCodeLinkPrefix }
import com.alphasystem.primereact.demo.components.button.docs.{
  BasicExample,
  ButtonSeverityExample
}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

object ButtonDemoDocs extends ScalaCssReactImplicits with SourceCodeLink {

  case class Backend(b: BackendScope[Unit, Unit]) {

    def render: VdomElement = {
      div(cls := "content-section documentation")(
        TabView()(
          TabPanel(header = "Documentation")(
            BasicExample(),
            ButtonSeverityExample(),
            sourceCodeLink(
              "ButtonPage.scala",
              "button/ButtonShowcase.scala"
            )
          )
        )
      ) // end of "content-section documentation"
    }
  }

  private val component = ScalaComponent
    .builder[Unit]("ButtonDemoDocs")
    .renderBackend[Backend]
    .build

  def apply(): VdomElement = component()
}
