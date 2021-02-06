package com.alphasystem.primereact.demo.components.autocomplete

import com.alphasystem.axios.Axios
import com.alphasystem.primereact.ExternalCss
import com.alphasystem.primereact.component.autocomplete.{
  AutoComplete,
  QueryEvent,
  ValueEvent
}
import com.alphasystem.primereact.demo.FlagsCss
import com.alphasystem.primereact.demo.data.{ Countries, Country }
import japgolly.scalajs.react._
import japgolly.scalajs.react.feature.ReactFragment
import japgolly.scalajs.react.raw.React
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits

import scala.concurrent.ExecutionContext.Implicits.global
import scala.scalajs.js
import scala.scalajs.js.JSConverters._

object AutoCompleteShowcase extends ScalaCssReactImplicits {

  type Props = Unit

  final case class State(
    countries: js.Array[Country] = js.Array(),
    selectedCountry1: Option[Country] = None,
    selectedCountry2: Option[Country] = None,
    selectedCountries: js.Array[Country] = js.Array(),
    filteredCountries: js.Array[Country] = js.Array()) {

    def updateCountries(values: js.Array[Country]): State =
      copy(countries = values)

    def updateFilteredCountries(values: js.Array[Country]): State =
      copy(filteredCountries = values)

    def updateSelectedCountry1(value: Country): State =
      copy(selectedCountry1 = Some(value))

    def updateSelectedCountry2(value: Country): State =
      copy(selectedCountry2 = Some(value))

    def updateSelectedCountries(values: js.Array[Country]): State =
      copy(selectedCountries = values)
  }

  case class Backend(b: BackendScope[Props, State]) {

    val flagsCss: ExternalCss = FlagsCss

    def render(state: State): VdomElement = {
      div(cls := "content-section implementation")(
        div(cls := "card")(
          basicExample(state),
          advanceExample(state),
          multipleExample(state)
        )
      )
    }

    private def searchCountry(
      state: State
    )(event: QueryEvent
    ): CallbackTo[Props] = {
      val query = event.query.toLowerCase
      var filteredCountries = state.countries
      if (Option(query).isDefined && query.trim.nonEmpty) {
        filteredCountries = filteredCountries.filter { country =>
          country.name.toLowerCase.startsWith(query)
        }
      }
      b.modState(_.updateFilteredCountries(filteredCountries))
    }

    private def updateSelectedCountry1(event: ValueEvent): CallbackTo[Props] =
      b.modState(
        _.updateSelectedCountry1(event.value.asInstanceOf[Country])
      )

    private def updateSelectedCountry2(event: ValueEvent): CallbackTo[Props] =
      b.modState(
        _.updateSelectedCountry2(event.value.asInstanceOf[Country])
      )

    private def updateSelectedCountries(event: ValueEvent): CallbackTo[Props] =
      b.modState(
        _.updateSelectedCountries(
          event.value.asInstanceOf[js.Array[Country]]
        )
      )

    private def onErrorHandler(event: ReactEventFromInput) = Callback {
      event.target.src =
        "https://www.primefaces.org/wp-content/uploads/2020/05/placeholder.png"
    }

    private def itemTemplate(item: js.Object): React.Element = {
      val country = item.asInstanceOf[Country]
      div(cls := "country-item")(
        img(
          alt := country.name,
          src := "./assets/images/flag_placeholder.png",
          onError ==> onErrorHandler,
          cls := s"flag flag-${country.code.toLowerCase}"
        ),
        div(country.name)
      ).rawElement
    }

    private def basicExample(state: State) =
      ReactFragment(
        h5("AutoComplete"),
        AutoComplete()(
          AutoComplete.props(
            suggestions = state.filteredCountries,
            field = "name",
            value = state.selectedCountry1.orUndefined,
            completeMethod = searchCountry(state)(_),
            onChange = updateSelectedCountry1(_)
          )
        )
      )

    private def advanceExample(state: State) =
      ReactFragment(
        h5("Dropdown and Templating"),
        AutoComplete()(
          AutoComplete.props(
            suggestions = state.filteredCountries,
            field = "name",
            value = state.selectedCountry2.orUndefined,
            completeMethod = searchCountry(state)(_),
            onChange = updateSelectedCountry2(_),
            dropdown = true,
            itemTemplate = itemTemplate(_)
          )
        )
      )

    private def multipleExample(state: State) =
      ReactFragment(
        h5("Multiple"),
        span(cls := "p-fluid")(
          AutoComplete()(
            AutoComplete.props(
              suggestions = state.filteredCountries,
              field = "name",
              value = state.selectedCountries,
              multiple = true,
              completeMethod = searchCountry(state)(_),
              onChange = updateSelectedCountries(_)
            )
          )
        )
      )

    def init: Callback = Callback {
      Axios
        .get("./assets/data/countries.json")
        .toFuture
        .map { response =>
          val countries = response.data.asInstanceOf[Countries]
          b.modState(_.updateCountries(countries.data)).runNow()
        }
    }
  }

  private val component = ScalaComponent
    .builder[Props]("AutoCompleteShowcase")
    .initialState(State())
    .renderBackend[Backend]
    .componentDidMount(_.backend.init)
    .build

  def apply(): VdomElement = component()
}
