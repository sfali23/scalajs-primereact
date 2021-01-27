package com.alphasystem.primereact.demo.components

package object `app-menu` {

  private val generalMenuData = List(
    MenuItemModel(
      name = "General",
      meta = List("general"),
      children = List(
        MenuItemModel(
          name = "Get Started",
          to = Some("/#/setup"),
          meta = List("get started")
        ),
        MenuItemModel(
          name = "Source Code",
          href = Some("https://github.com/sfali23/scalajs-primereact"),
          meta = List("source code")
        )
      )
    )
  )

  private val buttonMenuData = List(
    MenuItemModel(
      name = "Button",
      meta = List("button"),
      children = List(
        MenuItemModel(
          name = "Button",
          meta = List("button"),
          to = Some("/#/button")
        ),
        MenuItemModel(
          name = "SplitButton",
          meta = List("splitbutton"),
          to = Some("/#/splitbutton")
        )
      )
    )
  )

  private val panelMenuData = List(
    MenuItemModel(
      name = "Panel",
      meta = List("panel"),
      children = List(
        MenuItemModel(
          name = "TabView",
          meta = List("tabview"),
          to = Some("/#/tabview")
        )
      )
    )
  )

  private val menuMenuData = List(
    MenuItemModel(
      name = "Menu",
      meta = List("menu"),
      children = List(
        MenuItemModel(
          name = "MenuModel",
          meta = List("menumodel"),
          to = Some("/#/menumodel")
        ),
        MenuItemModel(
          name = "Menu",
          meta = List("menu"),
          to = Some("/#/menu")
        ),
        MenuItemModel(
          name = "Menubar",
          meta = List("menubar"),
          to = Some("/#/menubar")
        )
      )
    )
  )

  val data: List[MenuItemModel] = generalMenuData ++ buttonMenuData ++
    panelMenuData ++ menuMenuData
}
