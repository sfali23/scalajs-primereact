package com.alphasystem.primereact.demo.components.button.docs

import com.alphasystem.primereact.demo.components.CodeHighlighter
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

object BasicExample extends ScalaCssReactImplicits {

  case class Backend(b: BackendScope[Unit, Unit]) {

    def render: VdomElement = {
      val codeHighlightInitial =
        CodeHighlighter()("""import com.alphasystem.primereact.component.button
                            |
                            |Button(
                            |  label = "Save",
                            |  icon = "pi pi-check"
                            |)
                            |
                            |""".stripMargin)
      val codeHighlightFinal =
        CodeHighlighter()("""import com.alphasystem.primereact.component.button
                            |import com.alphasystem.primereact.icons.Icon
                            |
                            |ButtonBuilder()
                            |  .label("Save")
                            |  .icon(Icon.Check)
                            |  .toButton
                            |  
                            |""".stripMargin)
      div(
        h5("Getting Started"),
        div(
          span("Button is created using "),
          code("Button"),
          span(" component.")
        ),
        codeHighlightInitial,
        div(
          span("Inorder to make "),
          code("Button"),
          span(" creation easier a "),
          code("ButtonBuilder"),
          span(" class introduced.")
        ),
        codeHighlightFinal
      )
    }
  }

  private val component = ScalaComponent
    .builder[Unit]("BasicExample")
    .renderBackend[Backend]
    .build

  def apply(): VdomElement = component()
}
