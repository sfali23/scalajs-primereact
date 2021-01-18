package com.alphasystem.primereact.demo.components

package object `app-menu` {

  private val generalMenuData = List(
    MenuItemModel(
      name = "General",
      meta = List("general"),
      children = List(
        MenuItemModel(
          name = "Get Started",
          to = Some("/#setup"),
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
          to = Some("/#button")
        ),
        MenuItemModel(
          name = "SplitButton",
          meta = List("splitbutton"),
          to = Some("/#splitbutton")
        )
      )
    )
  )

  val data: List[MenuItemModel] = generalMenuData ++ buttonMenuData
}
