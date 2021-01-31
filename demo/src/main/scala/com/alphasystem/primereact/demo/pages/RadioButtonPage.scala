package com.alphasystem.primereact.demo.pages

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

object RadioButtonPage extends ScalaCssReactImplicits {

  case class Backend(b: BackendScope[Unit, Unit]) {

    def render: VdomElement = {
      div("RadioButtonPage")
    }
  }

  private val component = ScalaComponent
    .builder[Unit]("RadioButtonPage")
    .renderBackend[Backend]
    .build

  def apply(): VdomElement = component()
}
