package com.alphasystem.primereact.demo.pages

import com.alphasystem.primereact.demo.components.toast.{
  ToastDemoDocs,
  ToastShowcase
}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

object ToastPage extends ScalaCssReactImplicits {

  case class Backend(b: BackendScope[Unit, Unit]) {

    def render: VdomElement =
      div(
        div(cls := "content-section introduction toast-demo")(
          div(cls := "feature-intro")(
            h1("Toast"),
            p("Toast is used to display messages in an overlay.")
          )
        ),
        ToastShowcase(),
        ToastDemoDocs()
      )
  }

  private val component = ScalaComponent
    .builder[Unit]("ToastPage")
    .renderBackend[Backend]
    .build

  def apply(): VdomElement = component()
}
