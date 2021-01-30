package com.alphasystem.primereact.demo.components.keyfilter

import com.alphasystem.primereact.component.tabview.{ TabPanel, TabView }
import com.alphasystem.primereact.demo.components.CodeHighlighter
import com.alphasystem.primereact.demo.{ SourceCodeLink, importExample }
import japgolly.scalajs.react._
import japgolly.scalajs.react.feature.ReactFragment
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

object KeyFilterDemoDocs extends ScalaCssReactImplicits with SourceCodeLink {

  case class Backend(b: BackendScope[Unit, Unit]) {

    def render: VdomElement =
      div(cls := "content-section documentation")(
        TabView()(
          TabPanel(header = "Documentation")(
            importExample(
              "com.alphasystem.primereact.component.menu.Menu",
              "com.alphasystem.primereact.component.keyfilter.KeyFilter"
            ),
            gettingStartedExample,
            builtinFilterExample,
            customFilterExample,
            sourceCodeLink(
              "KeyFilterPage.scala",
              "keyfilter/KeyFilterShowcase.scala"
            )
          )
        )
      )

    private def gettingStartedExample =
      ReactFragment(
        h5("Getting Started"),
        p(
          span(
            "KeyFilter property is integrated in input components such as InputText using the "
          ),
          i("keyfilter"),
          span(""" property. The value of the filter can either a built-in regular expression or a custom one. 
                 |Following input only accepts integers.""".stripMargin)
        ),
        CodeHighlighter()("InputText(keyfilter = KeyFilter.Integer)")
      )

    private def builtinFilterExample =
      ReactFragment(
        h5("Built-in Filters"),
        p("Commonly used cases have their own built-in shortcuts."),
        CodeHighlighter()(
          """
            |KeyFilter.PositiveInteger
            |KeyFilter.Integer
            |KeyFilter.PositiveNumber
            |KeyFilter.Number
            |KeyFilter.Hexadecimal
            |KeyFilter.Email
            |KeyFilter.Alphabetic
            |KeyFilter.Alphanumeric
            |""".stripMargin
        )
      )

    private def customFilterExample =
      ReactFragment(
        h5("Custom Filter"),
        p("""A custom filter is enabled by binding a regular expression, an example that blocks special characters
            | would be;""".stripMargin),
        CodeHighlighter()("InputText(keyfilter = new RegExp(\"^[^<>*!]+$\"))")
      )
  }

  private val component = ScalaComponent
    .builder[Unit]("KeyFilterDemoDocs")
    .renderBackend[Backend]
    .build

  def apply(): VdomElement = component()
}
