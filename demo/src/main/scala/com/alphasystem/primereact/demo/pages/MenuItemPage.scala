package com.alphasystem.primereact.demo.pages

import com.alphasystem.primereact.demo.components.menumodel.MenuItemShowcase
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

object MenuItemPage extends ScalaCssReactImplicits {

  case class Backend(b: BackendScope[Unit, Unit]) {

    def render: VdomElement = MenuItemShowcase()
  }

  private val component = ScalaComponent
    .builder[Unit]("MenuItemModelPage")
    .renderBackend[Backend]
    .build

  def apply(): VdomElement = component()
}
