package com.alphasystem.primereact.demo.pages

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

object AutoCompletePage extends ScalaCssReactImplicits {

  case class Backend(b: BackendScope[Unit, Unit]) {

    def render: VdomElement = {
      div("AutoCompletePage")
    }
  }

  private val component = ScalaComponent
    .builder[Unit]("AutoCompletePage")
    .renderBackend[Backend]
    .build

  def apply(): VdomElement = component()
}
