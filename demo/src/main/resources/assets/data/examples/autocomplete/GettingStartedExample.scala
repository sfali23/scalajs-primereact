package com.alphasystem.primereact.demo.components.autocomplete.docs

import com.alphasystem.primereact.component.autocomplete.{
  AutoComplete,
  QueryEvent,
  ValueEvent
}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

import scala.scalajs.js
import scala.scalajs.js.JSConverters._

object GettingStartedExample extends ScalaCssReactImplicits {

  type Props = Unit

  final case class State(
    countries: js.Array[String],
    filteredCountries: js.Array[String] = js.Array(),
    selectedCountry: Option[String] = None) {

    def updateSelectedCountry(value: String): State =
      copy(selectedCountry = Some(value))

    def updateFilteredCountries(values: js.Array[String]): State =
      copy(filteredCountries = values)
  }

  case class Backend(b: BackendScope[Props, State]) {

    private def searchCountry(
      state: State
    )(event: QueryEvent
    ): CallbackTo[Props] = {
      val query = event.query.toLowerCase
      var filteredCountries = state.countries
      if (Option(query).isDefined && query.trim.nonEmpty) {
        filteredCountries = filteredCountries.filter { country =>
          country.toLowerCase.startsWith(query)
        }
      }
      b.modState(_.updateFilteredCountries(filteredCountries))
    }

    private def updateSelectedCountry(event: ValueEvent): CallbackTo[Props] =
      b.modState(
        _.updateSelectedCountry(event.value.asInstanceOf[String])
      )

    def render(state: State): VdomElement =
      AutoComplete()(
        AutoComplete.props(
          value = state.selectedCountry.orUndefined,
          suggestions = state.filteredCountries,
          completeMethod = searchCountry(state)(_),
          onChange = updateSelectedCountry(_)
        )
      )
  }

  private val component = ScalaComponent
    .builder[Props]("GettingStartedExample")
    .initialState(
      State(
        js.Array(
          "Country-1",
          "Country-2",
          "Country-3",
          "Country-4",
          "Country-5"
        )
      )
    )
    .renderBackend[Backend]
    .build

  def apply(): VdomElement = component()
}
