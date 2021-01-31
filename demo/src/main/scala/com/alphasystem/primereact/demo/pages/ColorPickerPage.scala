package com.alphasystem.primereact.demo.pages

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

object ColorPickerPage extends ScalaCssReactImplicits {

  case class Backend(b: BackendScope[Unit, Unit]) {

    def render: VdomElement = {
      div("ColorPicker")
    }
  }

  private val component = ScalaComponent
    .builder[Unit]("ColorPicker")
    .renderBackend[Backend]
    .build

  def apply(): VdomElement = component()
}
