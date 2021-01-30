package com.alphasystem.primereact.demo.components.keyfilter

import com.alphasystem.primereact.component.inputtext.InputText
import com.alphasystem.primereact.component.keyfilter.KeyFilter
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

import scala.scalajs.js.RegExp

object KeyFilterShowcase extends ScalaCssReactImplicits {

  case class Backend(b: BackendScope[Unit, Unit]) {

    def render: VdomElement =
      div(cls := "content-section implementation")(
        div(cls := "card")(
          div(cls := "p-grid p-fluid")(
            div(cls := "p-field p-col-12 p-md-3")(
              label(htmlFor := "integer")("Integers"),
              InputText(keyfilter = KeyFilter.Integer)(id := "integer")
            ),
            div(cls := "p-field p-col-12 p-md-3")(
              label(htmlFor := "numbers")("Numbers"),
              InputText(keyfilter = KeyFilter.Number)(id := "numbers")
            ),
            div(cls := "p-field p-col-12 p-md-3")(
              label(htmlFor := "money")("Money"),
              InputText(keyfilter = KeyFilter.Money)(id := "money")
            ),
            div(cls := "p-field p-col-12 p-md-3")(
              label(htmlFor := "hex")("Hex"),
              InputText(keyfilter = KeyFilter.Hexadecimal)(id := "hex")
            ),
            div(cls := "p-field p-col-12 p-md-3")(
              label(htmlFor := "alpha")("Alphabetic"),
              InputText(keyfilter = KeyFilter.Alphabetic)(id := "alpha")
            ),
            div(cls := "p-field p-col-12 p-md-3")(
              label(htmlFor := "alphanum")("Alphanumberic"),
              InputText(keyfilter = KeyFilter.Alphanumeric)(id := "alphanum")
            ),
            div(cls := "p-field p-col-12 p-md-3")(
              label(htmlFor := "block")("Block < > * !"),
              InputText(keyfilter = new RegExp("^[^<>*!]+$"))(id := "block")
            ),
            div(cls := "p-field p-col-12 p-md-3")(
              label(htmlFor := "spaceblock")("Block space key"),
              InputText(keyfilter = new RegExp("[^\\s]"))(
                id := "spaceblock"
              )
            )
          )
        )
      )
  }

  private val component = ScalaComponent
    .builder[Unit]("KeyFilterShowcase")
    .renderBackend[Backend]
    .build

  def apply(): VdomElement = component()
}
