package com.alphasystem.primereact.demo.components.tabview.docs

import com.alphasystem.primereact.demo.components.CodeHighlighter
import japgolly.scalajs.react._
import japgolly.scalajs.react.feature.ReactFragment
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

object UnControlledComponentExample extends ScalaCssReactImplicits {

  case class Backend(b: BackendScope[Unit, Unit]) {

    def render: VdomElement =
      ReactFragment(
        h5("Uncontrolled Component"),
        p(
          span("""In uncontrolled mode, no additional properties are required. Initial active tab can be provided 
                 |using the """.stripMargin),
          i("activeIndex"),
          span(""" property in uncontrolled mode however it is evaluated at initial rendering and ignored in further 
                 |updates. If you programmatically need to update the active tab, prefer to use the component as 
                 |controlled.""".stripMargin),
          CodeHighlighter()(
            """
              |TabView()(
              |  TabPanel(header = "Header I")(div("Content I")),
              |  TabPanel(header = "Header II")(div("Content II")),
              |  TabPanel(header = "Header III")(div("Content III"))
              |)
              |""".stripMargin
          )
        )
      )
  }

  private val component = ScalaComponent
    .builder[Unit]("UnControlledComponentExample")
    .renderBackend[Backend]
    .build

  def apply(): VdomElement = component()
}
