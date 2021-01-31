package com.alphasystem.primereact.demo.components.menubar

import com.alphasystem.primereact.component.inputtext.InputText
import com.alphasystem.primereact.component.menubar.Menubar
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

object MenubarShowcase extends ScalaCssReactImplicits {

  case class Backend(b: BackendScope[Unit, Unit]) {

    def render: VdomElement = {
      def onErrorHandler(event: ReactEventFromInput) = Callback {
        event.target.src =
          "https://www.primefaces.org/wp-content/uploads/2020/05/placeholder.png"
      }

      val start = img(
        alt := "logo",
        src := "./assets/images/logo.png",
        height := "40px",
        cls := "p-mr-2",
        onError ==> onErrorHandler
      )
      val end = InputText()(placeholder := "Search", `type` := "text")
      div(cls := "content-section implementation")(
        div(cls := "card")(
          Menubar(model = items, start = start, end = end)
        )
      )
    }

  }

  private val component = ScalaComponent
    .builder[Unit]("MenubarShowcase")
    .renderBackend[Backend]
    .build

  def apply(): VdomElement = component()
}
