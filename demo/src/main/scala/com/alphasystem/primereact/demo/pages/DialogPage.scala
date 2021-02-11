package com.alphasystem.primereact.demo.pages

import com.alphasystem.primereact.demo.components.dialog.{
  DialogDemoDocs,
  DialogShowcase
}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

object DialogPage extends ScalaCssReactImplicits {

  case class Backend(b: BackendScope[Unit, Unit]) {

    def render: VdomElement =
      div(
        div(cls := "content-section introduction toast-demo")(
          div(cls := "feature-intro")(
            h1("Dialog"),
            p("Dialog is a container to display content in an overlay window.")
          )
        ),
        DialogShowcase(),
        DialogDemoDocs()
      )
  }

  private val component = ScalaComponent
    .builder[Unit]("DialogPage")
    .renderBackend[Backend]
    .build

  def apply(): VdomElement = component()
}
