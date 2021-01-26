package com.alphasystem.primereact.demo.components.tabview.docs

import com.alphasystem.primereact.demo.components.CodeHighlighter
import japgolly.scalajs.react._
import japgolly.scalajs.react.feature.ReactFragment
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

object ImportExample extends ScalaCssReactImplicits {

  case class Backend(b: BackendScope[Unit, Unit]) {

    def render: VdomElement =
      ReactFragment(
        h5("Import"),
        CodeHighlighter()(
          """import com.alphasystem.primereact.component.tabview.{ TabPanel, TabView }"""
        )
      )
  }

  private val component = ScalaComponent
    .builder[Unit]("ImportExample")
    .renderBackend[Backend]
    .build

  def apply(): VdomElement = component()
}
