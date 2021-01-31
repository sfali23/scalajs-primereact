package com.alphasystem.primereact.demo.pages

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

object DropdownPage extends ScalaCssReactImplicits {

  case class Backend(b: BackendScope[Unit, Unit]) {

    def render: VdomElement = {
      div("DropdownPage")
    }
  }

  private val component = ScalaComponent
    .builder[Unit]("DropdownPage")
    .renderBackend[Backend]
    .build

  def apply(): VdomElement = component()
}
