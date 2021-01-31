package com.alphasystem.primereact.demo.pages

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

object MultiSelectPage extends ScalaCssReactImplicits {

  case class Backend(b: BackendScope[Unit, Unit]) {

    def render: VdomElement = {
      div("MultiSelectPage")
    }
  }

  private val component = ScalaComponent
    .builder[Unit]("MultiSelectPage")
    .renderBackend[Backend]
    .build

  def apply(): VdomElement = component()
}
