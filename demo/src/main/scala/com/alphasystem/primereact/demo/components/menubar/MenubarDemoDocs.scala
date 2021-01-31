package com.alphasystem.primereact.demo.components.menubar

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

object MenubarDemoDocs extends ScalaCssReactImplicits with SourceCodeLink {

  case class Backend(b: BackendScope[Unit, Unit]) {

    def render: VdomElement =
      div(cls := "content-section documentation")(
        TabView()(
          TabPanel(header = "Documentation")(
            importExample(
              "com.alphasystem.primereact.component.menubar.Menubar"
            ),
            h5("MenuModel API"),
            p(
              span(
                "Menubar uses the common menu item api to define its items, visit "
              ),
              routerLink("MenuModel API", "menumodel"),
              span(" for details.")
            ),
            gettingStartedExample,
            customContentExample,
            sourceCodeLink("MenubarPage.scala", "menubar/MenubarShowcase.scala")
          )
        )
      )

    private def gettingStartedExample: VdomElement =
      ReactFragment(
        h5("Getting Started"),
        p("Menubar requires nested menuitems as its model."),
        CodeHighlighter()("""
                            |Menubar(model = items)
                            |""".stripMargin)
      )

    private def customContentExample: VdomElement =
      ReactFragment(
        h5("Custom Content"),
        p(
          "The menubar can display custom content by using the \"start\" and \"end\" properties."
        ),
        CodeHighlighter()(
          """
            |val start = InputText()(placeholder := "Search", `type` := "text")
            |val end = ButtonBuilder().label("Logout").icon(Icon.PowerOff).toButton()
            |Menubar(model = items, start = start, end = end)
            |""".stripMargin
        )
      )
  }

  private val component = ScalaComponent
    .builder[Unit]("MenubarDemoDocs")
    .renderBackend[Backend]
    .build

  def apply(): VdomElement = component()
}
