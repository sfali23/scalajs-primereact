package com.alphasystem.primereact.demo.pages

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

object InputGroupPage extends ScalaCssReactImplicits {

  case class Backend(b: BackendScope[Unit, Unit]) {

    def render: VdomElement = {
      div("InputGroupPage")
    }
  }

  private val component = ScalaComponent
    .builder[Unit]("InputGroupPage")
    .renderBackend[Backend]
    .build

  def apply(): VdomElement = component()
}
