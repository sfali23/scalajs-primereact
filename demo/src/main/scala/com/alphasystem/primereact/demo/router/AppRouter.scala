package com.alphasystem.primereact.demo.router

import com.alphasystem.primereact.demo.components.Layout
import com.alphasystem.primereact.demo.pages._
import japgolly.scalajs.react.extra.router._
import japgolly.scalajs.react.vdom.all._

object AppRouter {
  sealed trait Page

  case object HomeRoute extends Page
  case object SetupRoute extends Page
  case object ButtonRoute extends Page
  case object TabViewRoute extends Page
  case object MenuItemModelRoute extends Page
  case object MenuRoute extends Page
  case object MenubarRoute extends Page
  case object InputTextRoute extends Page
  case object KeyFilterRoute extends Page
  case object AutoCompleteRoute extends Page
  case object CalendarRoute extends Page
  case object CheckboxRoute extends Page
  case object ChipsRoute extends Page
  case object ColorPickerRoute extends Page
  case object DropdownRoute extends Page
  case object EditorRoute extends Page
  case object InputGroupRoute extends Page
  case object InputMaskRoute extends Page
  case object InputNumberRoute extends Page
  case object InputSwitchRoute extends Page
  case object FloatLabelRoute extends Page
  case object InputTextareaRoute extends Page
  case object ListboxRoute extends Page
  case object MultiSelectRoute extends Page
  case object PasswordRoute extends Page
  case object RadioButtonRoute extends Page
  case object RatingRoute extends Page
  case object SelectButtonRoute extends Page
  case object SliderRoute extends Page
  case object TriStateCheckboxRoute extends Page
  case object ToggleButtonRoute extends Page
  case object ToastRouter extends Page
  case object SplitButtonRoute extends Page

  val routerConfig: RouterWithPropsConfig[Page, Unit] = RouterConfigDsl[Page]
    .buildConfig { dsl =>
      import dsl._

      (emptyRule
        | staticRoute("/", HomeRoute) ~> renderR(_ => HomePage())
        | staticRoute("/#/setup", SetupRoute) ~> renderR(_ => SetupPage())
        | staticRoute("/#/button", ButtonRoute) ~> renderR(_ => ButtonPage())
        | staticRoute("/#/tabview", TabViewRoute) ~> renderR(_ => TabViewPage())
        | staticRoute("/#/menumodel", MenuItemModelRoute) ~> renderR(_ =>
          MenuItemPage()
        )
        | staticRoute("/#/menu", MenuRoute) ~> renderR(_ => MenuPage())
        | staticRoute("/#/menubar", MenubarRoute) ~> renderR(_ => MenubarPage())
        | staticRoute("/#/inputtext", InputTextRoute) ~> renderR(_ =>
          InputTextPage()
        )
        | staticRoute("/#/keyfilter", KeyFilterRoute) ~> renderR(_ =>
          KeyFilterPage()
        )
        | staticRoute("/#/autocomplete", AutoCompleteRoute) ~> renderR(_ =>
          AutoCompletePage()
        )
        | staticRoute("/#/calendar", CalendarRoute) ~> renderR(_ =>
          CalendarPage()
        )
        | staticRoute("/#/checkbox", CheckboxRoute) ~> renderR(_ =>
          CheckboxPage()
        )
        | staticRoute("/#/chips", ChipsRoute) ~> renderR(_ => ChipsPage())
        | staticRoute("/#/colorpicker", ColorPickerRoute) ~> renderR(_ =>
          ColorPickerPage()
        )
        | staticRoute("/#/dropdown", DropdownRoute) ~> renderR(_ =>
          DropdownPage()
        )
        | staticRoute("/#/editor", EditorRoute) ~> renderR(_ => EditorPage())
        | staticRoute("/#/inputgroup", InputGroupRoute) ~> renderR(_ =>
          InputGroupPage()
        )
        | staticRoute("/#/inputmask", InputMaskRoute) ~> renderR(_ =>
          InputMaskPage()
        )
        | staticRoute("/#/inputnumber", InputNumberRoute) ~> renderR(_ =>
          InputNumberPage()
        )
        | staticRoute("/#/inputswitch", InputSwitchRoute) ~> renderR(_ =>
          InputSwitchPage()
        )
        | staticRoute("/#/floatlabel", FloatLabelRoute) ~> renderR(_ =>
          FloatLabelPage()
        )
        | staticRoute("/#/inputtextarea", InputTextareaRoute) ~> renderR(_ =>
          InputTextareaPage()
        )
        | staticRoute("/#/listbox", ListboxRoute) ~> renderR(_ => ListboxPage())
        | staticRoute("/#/multiselect", MultiSelectRoute) ~> renderR(_ =>
          MultiSelectPage()
        )
        | staticRoute("/#/password", PasswordRoute) ~> renderR(_ =>
          PasswordPage()
        )
        | staticRoute("/#/radiobutton", RadioButtonRoute) ~> renderR(_ =>
          RadioButtonPage()
        )
        | staticRoute("/#/rating", RatingRoute) ~> renderR(_ => RatingPage())
        | staticRoute("/#/selectbutton", SelectButtonRoute) ~> renderR(_ =>
          SelectButtonPage()
        )
        | staticRoute("/#/slider", SliderRoute) ~> renderR(_ => SliderPage())
        | staticRoute("/#/tristatecheckbox", TriStateCheckboxRoute) ~> renderR(
          _ => TriStateCheckboxPage()
        )
        | staticRoute("/#/togglebutton", ToggleButtonRoute) ~> renderR(_ =>
          ToggleButtonPage()
        )
        | staticRoute("/#/toast", ToastRouter) ~> renderR(_ => ToastPage())
        | staticRoute("/#/splitbutton", SplitButtonRoute) ~> renderR(_ =>
          SplitButtonPage()
        ))
        .notFound(redirectToPage(HomeRoute)(SetRouteVia.HistoryReplace))
    }
    .renderWith(layout)

  private def layout(c: RouterCtl[Page], r: Resolution[Page]): VdomElement =
    Layout(c, r)

  private val baseUrl = BaseUrl.fromWindowOrigin

  val router: Router[Page] = Router(baseUrl, routerConfig)
}
