package com.alphasystem.primereact.demo.components.tabview.docs

import com.alphasystem.primereact.demo.components.CodeHighlighter
import japgolly.scalajs.react._
import japgolly.scalajs.react.feature.ReactFragment
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

object ControlledComponentExample extends ScalaCssReactImplicits {

  case class Backend(b: BackendScope[Unit, Unit]) {

    def render: VdomElement =
      ReactFragment(
        h5("Controlled Component"),
        p(
          span("In controlled mode, "),
          i("activeIndex"),
          span(" and "),
          i("onTabChange"),
          span(" properties need to be defined to control the state.")
        ),
        CodeHighlighter()(
          """
            |final case class State(activeIndex: Int = 1) {
            |  def updateActiveIndex(newValue: Int): State = copy(activeIndex = newValue)
            |}
            |
            |TabView(
            |  activeIndex = state.activeIndex,
            |  onTabChange = (e: TabChangeEvent) =>
            |    // "b" is of type BackendScope[Unit, State]
            |    b.modState(_.updateActiveIndex(e.index)).runNow()
            |)(
            |  TabPanel(header = "Header I")(div("Content I")),
            |  TabPanel(header = "Header II")(div("Content II")),
            |  TabPanel(header = "Header III")(div("Content III"))
            |)
            |""".stripMargin
        )
      )
  }

  private val component = ScalaComponent
    .builder[Unit]("ControlledComponentExample")
    .renderBackend[Backend]
    .build

  def apply(): VdomElement = component()
}
