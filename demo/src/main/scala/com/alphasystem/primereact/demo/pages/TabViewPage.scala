package com.alphasystem.primereact.demo.pages

import com.alphasystem.primereact.demo.components.tabview.{
  TabViewDemoDocs,
  TabViewShowcase
}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

object TabViewPage extends ScalaCssReactImplicits {

  case class Backend(b: BackendScope[_, _]) {

    def render: VdomElement = {
      div()(
        div(cls := "content-section introduction")(
          div(cls := "feature-intro")(
            h1("TabView"),
            p(
              "TabView is a container component to group content with tabs."
            )
          ) // end of "feature-intro"
        ), // end of "content-section introduction"
        TabViewShowcase(),
        TabViewDemoDocs()
      ) // end of outermost div
    }
  }

  private val component = ScalaComponent
    .builder[Unit]("TabViewPage")
    .renderBackend[Backend]
    .build

  def apply(): VdomElement = component()
}
