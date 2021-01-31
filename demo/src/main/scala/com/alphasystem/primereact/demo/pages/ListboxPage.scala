package com.alphasystem.primereact.demo.pages

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

object ListboxPage extends ScalaCssReactImplicits {

  case class Backend(b: BackendScope[Unit, Unit]) {

    def render: VdomElement = {
      div("Listbox")
    }
  }

  private val component = ScalaComponent
    .builder[Unit]("Listbox")
    .renderBackend[Backend]
    .build

  def apply(): VdomElement = component()
}
