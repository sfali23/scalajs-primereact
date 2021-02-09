package com.alphasystem.primereact.demo.pages

import com.alphasystem.primereact.demo.components.messages.{
  MessagesDemoDocs,
  MessagesShowcase
}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

object MessagesPage extends ScalaCssReactImplicits {

  case class Backend(b: BackendScope[Unit, Unit]) {

    def render: VdomElement =
      div(
        div(cls := "content-section introduction toast-demo")(
          div(cls := "feature-intro")(
            h1("Messages"),
            p(
              "Messages is used to display inline messages with various severities."
            )
          )
        ),
        MessagesShowcase(),
        MessagesDemoDocs()
      )
  }

  private val component = ScalaComponent
    .builder[Unit]("MessagesPage")
    .renderBackend[Backend]
    .build

  def apply(): VdomElement = component()
}
