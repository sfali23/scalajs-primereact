package com.alphasystem.primereact.demo.pages

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

object SliderPage extends ScalaCssReactImplicits {

  case class Backend(b: BackendScope[Unit, Unit]) {

    def render: VdomElement = {
      div("SliderPage")
    }
  }

  private val component = ScalaComponent
    .builder[Unit]("SliderPage")
    .renderBackend[Backend]
    .build

  def apply(): VdomElement = component()
}
