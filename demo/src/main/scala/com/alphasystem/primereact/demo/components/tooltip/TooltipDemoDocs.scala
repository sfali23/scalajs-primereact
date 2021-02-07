package com.alphasystem.primereact.demo.components.tooltip

import com.alphasystem.primereact.component.tabview.{ TabPanel, TabView }
import com.alphasystem.primereact.demo.components.CodeHighlighter
import com.alphasystem.primereact.demo.{ SourceCodeLink, importExample }
import japgolly.scalajs.react._
import japgolly.scalajs.react.feature.ReactFragment
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

object TooltipDemoDocs extends ScalaCssReactImplicits with SourceCodeLink {

  case class Backend(b: BackendScope[Unit, Unit]) {

    def render: VdomElement =
      div(cls := "content-section documentation")(
        TabView()(
          TabPanel(header = "Documentation")(
            importExample(
              "com.alphasystem.primereact.component.tooltip.Tooltip",
              "com.alphasystem.primereact.component.tooltip.TooltipOptions"
            ),
            gettingStartedExample,
            positionExample,
            eventsExample,
            delayExample,
            globalTooltipExample,
            sourceCodeLink("TooltipPage.scala", "toast/TooltipShowcase.scala")
          )
        )
      )

    private def gettingStartedExample =
      ReactFragment(
        p(
          span("""Tooltip functionality is integrated within the the components that have support such as inputtext or 
                 |buttons. Content is defined with the """.stripMargin),
          i("tooltip"),
          span(" property.")
        ),
        CodeHighlighter()("""
                            |InputText(tooltip = "Enter your username")(
                            |   `type` := "text",
                            |   placeholder := "Right"
                            |)
                            |
                            |ButtonBuilder()
                            |   .label("Save")
                            |   .icon(Icon.Check)
                            |   .tooltip("Click to proceed")
                            |   .toButton()
                            |""".stripMargin)
      )

    private def positionExample =
      ReactFragment(
        h5("Position"),
        p(
          span(
            """There are four choices to position the tooltip, default value is "right" and alternatives are "top",
              | "bottom", "left". Position is specified using """.stripMargin
          ),
          i("tooltipOptions"),
          span(" property.")
        ),
        CodeHighlighter()(
          """
            |InputText(tooltip = "Enter your username")(
            |   `type` := "text",
            |   placeholder := "Left",
            |   tooltipOptions = TooltipOptions(position = Position.Left)
            |)
            |""".stripMargin
        )
      )

    private def eventsExample =
      ReactFragment(
        h5("Events"),
        p(
          """Tooltip gets displayed on hover event of its target by default, other option is the focus event to display
            | and blur to hide.""".stripMargin
        ),
        CodeHighlighter()(
          """
            |InputText(tooltip = "Enter your username")(
            |   `type` := "text",
            |   placeholder := "Right",
            |   tooltipOptions = TooltipOptions(event = "focus")
            |)
            |""".stripMargin
        )
      )

    private def delayExample =
      ReactFragment(
        h5("Delay"),
        p(
          span(
            "Tooltip is displayed or hidden instantly by default however you may add delays using ",
            i("showDelay"),
            span(" and "),
            i("hideDelay"),
            span(
              "properties which accept a number value in terms of milliseconds."
            )
          )
        ),
        CodeHighlighter()(
          """
            |InputText(tooltip = "Enter your username")(
            |   `type` := "text",
            |   placeholder := "Right",
            |   tooltipOptions = TooltipOptions(showDelay = 1000, hideDelay = 300)
            |)
            |""".stripMargin
        )
      )

    private def globalTooltipExample =
      ReactFragment(
        h5("Global Tooltip"),
        p(
          """It is used to bind the same properties to more than one element. Each element can have its 
            |own """.stripMargin,
          i("data-pr-{options}"),
          span(
            " properties. In this way, options can be customized among themselves. Using the "
          ),
          i("data-pr-tooltip"),
          span("""property on any element, the text to be displayed in the tooltip is determined. The target property 
                 |is required for the global tooltip. It can be a selector, DOM element or selector array.
                 |""".stripMargin)
        ),
        CodeHighlighter()(
          """
            |val dataPrTooltip = VdomAttr("data-pr-tooltip")
            |
            |Tooltip(
            |   Tooltip
            |     .props(
            |       target = ".customClassName",
            |       mouseTrack = true,
            |       mouseTrackLeft = 10
            |)
            |
            |img(
            |   cls := "customClassName p-ml-2",
            |   alt := "logo",
            |   src := "./assets/images/logo.png",
            |   height := "80px",
            |   dataPrTooltip := "PrimeReact-Logo"
            |)
            |
            |div(
            |   cls := "customClassName",
            |   dataPrTooltip := "This is a div element",
            |   width := "50px",
            |   height := "50px",
            |   border := "1px solid black",
            |)
            |""".stripMargin
        )
      )
  }

  private val component = ScalaComponent
    .builder[Unit]("TooltipDemoDocs")
    .renderBackend[Backend]
    .build

  def apply(): VdomElement = component()
}
