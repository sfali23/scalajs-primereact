package com.alphasystem.primereact.demo.pages

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

object InputNumberPage extends ScalaCssReactImplicits {

  case class Backend(b: BackendScope[Unit, Unit]) {

    def render: VdomElement = {
      div("InputNumberPage")
    }
  }

  private val component = ScalaComponent
    .builder[Unit]("InputNumberPage")
    .renderBackend[Backend]
    .build

  def apply(): VdomElement = component()
}
