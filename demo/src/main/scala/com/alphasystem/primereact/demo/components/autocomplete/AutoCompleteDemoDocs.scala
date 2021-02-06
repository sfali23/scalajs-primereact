package com.alphasystem.primereact.demo.components.autocomplete

import com.alphasystem.axios.Axios
import com.alphasystem.primereact.component.tabview.{ TabPanel, TabView }
import com.alphasystem.primereact.demo.components.CodeHighlighter
import com.alphasystem.primereact.demo.{ SourceCodeLink, importExample }
import japgolly.scalajs.react._
import japgolly.scalajs.react.feature.ReactFragment
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits
import scala.scalajs.js.JSConverters._

import scala.concurrent.ExecutionContext.Implicits.global

object AutoCompleteDemoDocs extends ScalaCssReactImplicits with SourceCodeLink {

  final case class State(gettingStartedExample: Option[String] = None)

  case class Backend(b: BackendScope[Unit, State]) {

    def render(state: State): VdomElement =
      div(cls := "content-section documentation")(
        TabView()(
          TabPanel(header = "Documentation")(
            importExample(
              "com.alphasystem.primereact.component.autocomplete.AutoComplete"
            ),
            gettingStartedExample(state),
            dropDownExample,
            multipleExample,
            objectsExample,
            templatingExample,
            sourceCodeLink(
              "AutoCompletePage.scala",
              "autocomplete/AutoCompleteShowcase.scala"
            )
          )
        )
      )

    private def gettingStartedExample(state: State) =
      ReactFragment(
        h5("Getting Started"),
        p(
          span("AutoComplete is used as a controlled component with "),
          i("value"),
          span(" and "),
          i("onChange"),
          span(" properties. In addition, the component requires a list of "),
          i("suggestions"),
          span(" and "),
          i("completeMethod"),
          span(" to query the results.")
        ),
        CodeHighlighter()(
          """
            |AutoComplete()(
            |   AutoComplete.props(
            |      suggestions = state.filteredCountries,
            |      value = state.selectedCountry1.orUndefined,
            |      completeMethod = (event: QueryEvent) => searchCountry(event, state),
            |      onChange = (event: ValueEvent) =>
            |         b.modState(
            |           _.updateSelectedCountry1(event.value.asInstanceOf[String])
            |         )
            |     )
            |   )
            |""".stripMargin
        ),
        CodeHighlighter()(state.gettingStartedExample.orUndefined)
      )

    private def dropDownExample =
      ReactFragment(
        h5("Dropdown"),
        p(
          span("Enabling "),
          i("dropdown"),
          span(
            """
              | property displays a button next to the input field where click behavior of the button is defined using 
              | dropdownMode property that takes "blank" or "current" as possible values. "blank" is the default mode 
              | to send a query with an empty string whereas "current" setting sends a query with the current value of 
              | the input.
              |""".stripMargin
          )
        ),
        CodeHighlighter()(
          """
            |AutoComplete()(
            |   AutoComplete.props(
            |      dropdown = true,
            |      suggestions = state.filteredCountries,
            |      value = state.selectedCountry1.orUndefined,
            |      completeMethod = (event: QueryEvent) => searchCountry(event, state),
            |      onChange = (event: ValueEvent) =>
            |         b.modState(
            |           _.updateSelectedCountry1(event.value.asInstanceOf[String])
            |         )
            |     )
            |   )
            |""".stripMargin
        )
      )

    private def multipleExample =
      ReactFragment(
        h5("Multiple Mode"),
        p(
          span("Multiple mode is enabled using "),
          i("multiple"),
          span(
            """
              | property used to select more than one value from the autocomplete. In this case, value reference should
              |  be an array.
              |""".stripMargin
          )
        ),
        CodeHighlighter()(
          """
            |AutoComplete()(
            |   AutoComplete.props(
            |      multiple = true,
            |      suggestions = state.filteredCountries,
            |      value = state.selectedCountry1.orUndefined,
            |      completeMethod = (event: QueryEvent) => searchCountry(event, state),
            |      onChange = (event: ValueEvent) =>
            |         b.modState(
            |           _.updateSelectedCountry1(event.value.asInstanceOf[String])
            |         )
            |     )
            |   )
            |""".stripMargin
        )
      )

    private def objectsExample =
      ReactFragment(
        h5("Objects"),
        p(
          span("AutoComplete can also work with objects using the "),
          i("field"),
          span(
            """
              | property that defines the label to display as a suggestion. The value passed to the model would still 
              | be the object instance of a suggestion. Here is an example with a Country object that has name and code
              |  fields such as:
              |""".stripMargin
          )
        ),
        CodeHighlighter()("""
                            |@js.native
                            |trait Country extends js.Object {
                            |  val name: String
                            |  val code: String
                            |}
                            |""".stripMargin),
        CodeHighlighter()(
          """
            |AutoComplete()(
            |   AutoComplete.props(
            |      field = "name",
            |      suggestions = state.filteredCountries,
            |      value = state.selectedCountry1.orUndefined,
            |      completeMethod = (event: QueryEvent) => searchCountry(event, state),
            |      onChange = (event: ValueEvent) =>
            |         b.modState(
            |           _.updateSelectedCountry1(event.value.asInstanceOf[Country])
            |         )
            |     )
            |   )
            |""".stripMargin
        )
      )

    private def templatingExample =
      ReactFragment(
        h5("Templating"),
        p(
          span("Custom content can be displayed using "),
          i("itemTemplate"),
          span(
            """
              | property that references a function or JSXElement or string which gets the suggestion option and 
              | returns an element. Similarly
              |""".stripMargin
          ),
          i("selectedItemTemplate"),
          span(
            " property is available to customize the chips in multiple mode using the same approach."
          )
        ),
        CodeHighlighter()(
          """
            |private def itemTemplate(item: js.Object): React.Element = {
            | div("")
            |}
            |""".stripMargin
        ),
        CodeHighlighter()(
          """
            |AutoComplete()(
            |   AutoComplete.props(
            |      suggestions = state.filteredCountries,
            |      value = state.selectedCountry1.orUndefined,
            |      itemTemplate = itemTemplate(_),
            |      completeMethod = (event: QueryEvent) => searchCountry(event, state),
            |      onChange = (event: ValueEvent) =>
            |         b.modState(
            |           _.updateSelectedCountry1(event.value.asInstanceOf[String])
            |         )
            |     )
            |   )
            |""".stripMargin
        )
      )

    def init: Callback = Callback {
      Axios
        .get("./assets/data/examples/autocomplete/GettingStartedExample.scala")
        .toFuture
        .map { response =>
          val str = response.data.asInstanceOf[String]
          b.modState(_.copy(gettingStartedExample = Some(str))).runNow()
        }
    }
  }

  private val component = ScalaComponent
    .builder[Unit]("AutoCompleteDemoDocs")
    .initialState(State())
    .renderBackend[Backend]
    .componentDidMount(_.backend.init)
    .componentDidUpdate(_.backend.init)
    .build

  def apply(): VdomElement = component()
}
