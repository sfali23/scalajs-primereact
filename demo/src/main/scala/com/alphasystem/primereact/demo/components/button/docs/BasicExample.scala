package com.alphasystem.primereact.demo.components.button.docs

import com.alphasystem.primereact.demo.components.CodeHighlighter
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

object BasicExample extends ScalaCssReactImplicits {

  case class Backend(b: BackendScope[Unit, Unit]) {

    def render: VdomElement = {
      CodeHighlighter()("""import com.alphasystem.primereact.component
                          |
                          |Button(
                          |  label = "Save",
                          |  icon = "pi pi-check"
                          |)
                          |""".stripMargin)
    }

  }

  private val component = ScalaComponent
    .builder[Unit]("BasicExample")
    .renderBackend[Backend]
    .build

  def apply(): VdomElement = component()
}
