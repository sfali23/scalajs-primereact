package com.alphasystem.primereact.demo.router

import com.alphasystem.primereact.demo.components.Layout
import com.alphasystem.primereact.demo.pages.HomePage
import japgolly.scalajs.react.extra.router._
import japgolly.scalajs.react.vdom.all._

object AppRouter {
  sealed trait Page

  case object HomeRoute extends Page

  val routerConfig: RouterWithPropsConfig[Page, Unit] = RouterConfigDsl[Page]
    .buildConfig { dsl =>
      import dsl._

      (emptyRule
        | staticRoute("/", HomeRoute) ~> renderR(_ => HomePage()))
        .notFound(redirectToPage(HomeRoute)(SetRouteVia.HistoryReplace))
    }
    .renderWith(layout)

  private def layout(c: RouterCtl[Page], r: Resolution[Page]): VdomElement =
    Layout(c, r)

  private val baseUrl = BaseUrl.fromWindowOrigin

  val router: Router[Page] = Router(baseUrl, routerConfig)
}
