package com.alphasystem.primereact.demo.components.splitbutton

import com.alphasystem.primereact.component.tabview.{ TabPanel, TabView }
import com.alphasystem.primereact.demo.components.CodeHighlighter
import com.alphasystem.primereact.demo.{ importExample, routerLink }
import japgolly.scalajs.react._
import japgolly.scalajs.react.feature.ReactFragment
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

object SplitButtonDemoDocs extends ScalaCssReactImplicits {

  case class Backend(b: BackendScope[Unit, Unit]) {

    def render: VdomElement =
      div(cls := "content-section documentation")(
        TabView()(
          TabPanel(header = "Documentation")(
            importExample(
              "com.alphasystem.primereact.component.splitbutton.SplitButton",
              "com.alphasystem.primereact.component.splitbutton.SplitButtonBuilder"
            ),
            gettingStartedExample,
            h5("MenuModel API"),
            p(
              span(
                "SplitButton uses the common MenuModel API to define the items, visit "
              ),
              routerLink("MenuModel API", "menumodel"),
              span(" for details.")
            ),
            severityExample
          )
        )
      )

    private def gettingStartedExample =
      ReactFragment(
        h5("Getting Started"),
        p(
          span(
            "SplitButton has a default command button and a collection of additional options defined by the"
          ),
          i("model"),
          span(" property.")
        ),
        CodeHighlighter()(
          """
            |SplitButtonBuilder()
            |   .label("Save")
            |   .icon(Icon.Plus)
            |   .model(items)
            |   .classNames("p-mr-2")
            |   .toSplitButton(onClick --> Callback { println("Hello World") })
            |""".stripMargin
        )
      )

    private def severityExample =
      ReactFragment(
        h5("Severity"),
        p("Different color options are available as severity levels."),
        CodeHighlighter()("""
                            |SplitButtonBuilder()
                            |   .label("Primary")
                            |   .toSplitButton()
                            |   
                            |SplitButtonBuilder()
                            |   .label("Secondary")
                            |   .severity(Severity.Secondary)
                            |   .toSplitButton()
                            |   
                            |SplitButtonBuilder()
                            |   .label("Success")
                            |   .severity(Severity.Success)
                            |   .toSplitButton()
                            |   
                            |SplitButtonBuilder()
                            |   .label("Info")
                            |   .severity(Severity.Info)
                            |   .toSplitButton()
                            |   
                            |SplitButtonBuilder()
                            |   .label("Warning")
                            |   .severity(Severity.Warning)
                            |   .toSplitButton()
                            |
                            |SplitButtonBuilder()
                            |   .label("Danger")
                            |   .severity(Severity.Danger)
                            |   .toSplitButton()
                            |""".stripMargin)
      )
  }

  private val component = ScalaComponent
    .builder[Unit]("SplitButtonDemoDocs")
    .renderBackend[Backend]
    .build

  def apply(): VdomElement = component()
}
