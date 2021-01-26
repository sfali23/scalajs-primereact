package com.alphasystem.primereact.demo.components.tabview

import com.alphasystem.primereact.component.button.ButtonBuilder
import com.alphasystem.primereact.component.tabview.{
  TabChangeEvent,
  TabPanel,
  TabView
}
import com.alphasystem.primereact.demo.TabViewDemoCss
import com.alphasystem.primereact.icons.Icon
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import org.scalajs.dom.html.Paragraph
import scalacss.ScalaCssReactImplicits

object TabViewShowcase extends ScalaCssReactImplicits {

  private val css = TabViewDemoCss

  final case class State(activeIndex: Int = 1) {
    def updateActiveIndex(newValue: Int): State = copy(activeIndex = newValue)
  }

  case class Backend(b: BackendScope[Unit, State]) {

    private def updateActiveIndex(newValue: Int) =
      b.modState(_.updateActiveIndex(newValue))

    private def onTabChange(e: TabChangeEvent): Unit =
      updateActiveIndex(e.index).runNow()

    def render(state: State): VdomElement = {
      div(cls := "content-section implementation tabview-demo")(
        defaultExample,
        programmaticExample(state),
        disabledExample,
        customHeaderExample
      ) // end of "content-section implementation tabview-demo"
    }

    private val example1: VdomTagOf[Paragraph] = p(
      """Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut 
        |labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris 
        |nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit 
        |esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in 
        |culpa qui officia deserunt mollit anim id est laborum.""".stripMargin
    )

    private val example2: VdomTagOf[Paragraph] = p(
      """Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, 
        |totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae 
        |dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, 
        |sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Consectetur, adipisci 
        |velit, sed quia non numquam eius modi.""".stripMargin
    )

    private val example3: VdomTagOf[Paragraph] = p(
      """At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum 
        |deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non 
        |provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum 
        |fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis
        | est eligendi optio cumque nihil impedit quo minus.""".stripMargin
    )

    private def defaultExample =
      div(cls := "card")(
        h5("Default"),
        TabView()(
          TabPanel(header = "Header I")(example1),
          TabPanel(header = "Header II")(example2),
          TabPanel(header = "Header III")(example3)
        )
      )

    private def programmaticExample(state: State) =
      div(cls := "card")(
        h5("Programmatic"),
        div(cls := "p-pt-2 p-pb-4")(
          ButtonBuilder()
            .label("Activate 1st")
            .text
            .toButton(onClick --> updateActiveIndex(0)),
          ButtonBuilder()
            .label("Activate 2nd")
            .text
            .toButton(onClick --> updateActiveIndex(1)),
          ButtonBuilder()
            .label("Activate 3rd")
            .text
            .toButton(onClick --> updateActiveIndex(2))
        ),
        TabView(
          activeIndex = state.activeIndex,
          onTabChange = (e: TabChangeEvent) => onTabChange(e)
        )(
          TabPanel(header = "Header I")(example1),
          TabPanel(header = "Header II")(example2),
          TabPanel(header = "Header III")(example3)
        )
      )

    private def disabledExample =
      div(cls := "card")(
        h5("Default"),
        TabView()(
          TabPanel(header = "Header I")(example1),
          TabPanel(header = "Header II")(example2),
          TabPanel(header = "Header III")(example3),
          TabPanel(header = "Header IV", disabled = true)
        )
      )

    private def customHeaderExample =
      div(cls := "card")(
        h5("Custom Headers"),
        TabView(className = "tabview-custom")(
          TabPanel(header = "Header I", leftIcon = Icon.Calendar.toClassName)(
            example1
          ),
          TabPanel(header = "Header II", rightIcon = Icon.User.toClassName)(
            example2
          ),
          TabPanel(
            header = "Header III",
            leftIcon = Icon.Search.toClassName,
            rightIcon = Icon.Cog.toClassName
          )(example3)
        )
      )
  }

  private val component = ScalaComponent
    .builder[Unit]("TabViewShowcase")
    .initialState(State())
    .renderBackend[Backend]
    .build

  def apply(): VdomElement = component()
}
