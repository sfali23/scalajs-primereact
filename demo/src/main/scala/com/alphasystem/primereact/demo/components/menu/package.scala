package com.alphasystem.primereact.demo.components

import com.alphasystem.primereact.component.menumodel.MenuItem
import com.alphasystem.primereact.icons.Icon
import typings.std.global.window

import scala.scalajs.js
import scala.scalajs.js.UndefOr

package object menu {

  val items: js.Array[MenuItem] = js.Array(
    new MenuItem {
      override val label: String = "Options"

      override val items: UndefOr[js.Array[MenuItem]] =
        js.Array(
          new MenuItem {
            override val label: String = "Update"
            override val icon: UndefOr[String] = Icon.Refresh.toClassName
            override def command(): Unit = println(label)
          },
          new MenuItem {
            override val label: String = "Delete"
            override val icon: UndefOr[String] = Icon.Times.toClassName
            override def command(): Unit = println(label)
          }
        )
    },
    new MenuItem {
      override val label: String = "Navigate"

      override val items: UndefOr[js.Array[MenuItem]] =
        js.Array(
          new MenuItem {
            override val label: String = "React Website"
            override val icon: UndefOr[String] = Icon.ExternalLink.toClassName
            override val url: UndefOr[String] = "https://reactjs.org/"
          },
          new MenuItem {
            override val label: String = "Router"
            override val icon: UndefOr[String] = Icon.Upload.toClassName

            override def command(): Unit = window.location.hash =
              "/#/fileupload"
          }
        )
    }
  )
}
