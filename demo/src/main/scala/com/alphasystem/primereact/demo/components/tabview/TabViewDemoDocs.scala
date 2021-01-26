package com.alphasystem.primereact.demo.components.tabview

import com.alphasystem.primereact.component.tabview.{ TabPanel, TabView }
import com.alphasystem.primereact.demo.components.tabview.docs.{
  ControlledComponentExample,
  ImportExample,
  UnControlledComponentExample
}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

object TabViewDemoDocs extends ScalaCssReactImplicits {

  case class Backend(b: BackendScope[Unit, Unit]) {

    def render: VdomElement = {
      div(cls := "content-section documentation")(
        TabView()(docs)
      )
    }

    private def docs =
      TabPanel(header = "Documentation")(
        ImportExample(),
        h5("Getting Started"),
        p("""Tabview element consists of one or more TabPanel elements and can either be used as a Controlled or
            | Uncontrolled component""".stripMargin),
        ControlledComponentExample(),
        UnControlledComponentExample()
      )
  }

  private val component = ScalaComponent
    .builder[Unit]("TabViewDocs")
    .renderBackend[Backend]
    .build

  def apply(): VdomElement = component()
}
