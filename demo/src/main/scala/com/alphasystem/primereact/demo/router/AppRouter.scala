package com.alphasystem.primereact.demo.router

import com.alphasystem.primereact.demo.components.Layout
import com.alphasystem.primereact.demo.pages.{
  ButtonPage,
  HomePage,
  SetupPage,
  TabViewPage
}
import japgolly.scalajs.react.extra.router._
import japgolly.scalajs.react.vdom.all._

object AppRouter {
  sealed trait Page

  case object HomeRoute extends Page
  case object SetupRoute extends Page
  case object ButtonRoute extends Page
  case object TabViewRoute extends Page

  val routerConfig: RouterWithPropsConfig[Page, Unit] = RouterConfigDsl[Page]
    .buildConfig { dsl =>
      import dsl._

      (emptyRule
        | staticRoute("/", HomeRoute) ~> renderR(_ => HomePage())
        | staticRoute("/#/setup", SetupRoute) ~> renderR(_ => SetupPage())
        | staticRoute("/#/button", ButtonRoute) ~> renderR(_ => ButtonPage())
        | staticRoute("/#/tabview", TabViewRoute) ~> renderR(_ =>
          TabViewPage()
        ))
        .notFound(redirectToPage(HomeRoute)(SetRouteVia.HistoryReplace))
    }
    .renderWith(layout)

  private def layout(c: RouterCtl[Page], r: Resolution[Page]): VdomElement =
    Layout(c, r)

  private val baseUrl = BaseUrl.fromWindowOrigin

  val router: Router[Page] = Router(baseUrl, routerConfig)
}
