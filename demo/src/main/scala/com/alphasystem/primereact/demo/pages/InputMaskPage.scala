package com.alphasystem.primereact.demo.pages

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

object InputMaskPage extends ScalaCssReactImplicits {

  case class Backend(b: BackendScope[Unit, Unit]) {

    def render: VdomElement = {
      div("InputMaskPage")
    }
  }

  private val component = ScalaComponent
    .builder[Unit]("InputMaskPage")
    .renderBackend[Backend]
    .build

  def apply(): VdomElement = component()
}
