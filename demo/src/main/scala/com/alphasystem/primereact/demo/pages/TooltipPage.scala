package com.alphasystem.primereact.demo.pages

import com.alphasystem.primereact.demo.components.tooltip.{
  TooltipDemoDocs,
  TooltipShowcase
}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

object TooltipPage extends ScalaCssReactImplicits {

  case class Backend(b: BackendScope[Unit, Unit]) {

    def render: VdomElement =
      div(
        div(cls := "content-section introduction toast-demo")(
          div(cls := "feature-intro")(
            h1("Tooltip"),
            p(
              "Tooltip functionality is integrated within various PrimeReact components."
            )
          )
        ),
        TooltipShowcase(),
        TooltipDemoDocs()
      )
  }

  private val component = ScalaComponent
    .builder[Unit]("TooltipPage")
    .renderBackend[Backend]
    .build

  def apply(): VdomElement = component()
}
