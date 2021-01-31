package com.alphasystem.primereact.demo.pages

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

object CheckboxPage extends ScalaCssReactImplicits {

  case class Backend(b: BackendScope[Unit, Unit]) {

    def render: VdomElement = {
      div("Checkbox")
    }
  }

  private val component = ScalaComponent
    .builder[Unit]("Checkbox")
    .renderBackend[Backend]
    .build

  def apply(): VdomElement = component()
}
