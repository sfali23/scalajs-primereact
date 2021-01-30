package com.alphasystem.primereact.demo.components

import io.circe.parser._
import io.circe.generic.auto._

package object `app-menu` {

  private val RawData =
    """[
      | {
      |   "name": "General",
      |   "meta": ["general"],
      |   "children": [
      |     {
      |       "name": "Get Started",
      |       "meta": ["get started"],
      |       "to": "/#/setup"
      |     },
      |     {
      |       "name": "Source Code",
      |       "meta": ["source code"],
      |       "href": "https://github.com/sfali23/scalajs-primereact"
      |     }
      |   ]
      | },
      | {
      |   "name": "Form",
      |   "meta": ["form"],
      |   "children": [
      |     {
      |       "name": "InputText",
      |       "meta": ["inputtext"],
      |       "to": "/#/inputtext"
      |     },
      |     {
      |       "name": "KeyFilter",
      |       "meta": ["keyfilter"],
      |       "to": "/#/keyfilter"
      |     }
      |   ]
      | },
      | {
      |   "name": "Button",
      |   "meta": ["button"],
      |   "children": [
      |     {
      |       "name": "Button",
      |       "meta": ["button"],
      |       "to": "/#/button"
      |     },
      |     {
      |       "name": "SplitButton",
      |       "meta": ["splitbutton"],
      |       "to": "/#/splitbutton"
      |     }
      |   ]
      | },
      | {
      |   "name": "Panel",
      |   "meta": ["panel"],
      |   "children": [
      |     {
      |       "name": "TabView",
      |       "meta": ["tabview"],
      |       "to": "/#/tabview"
      |     }
      |   ]
      | },
      | {
      |   "name": "Menu",
      |   "meta": ["menu"],
      |   "children": [
      |     {
      |       "name": "MenuModel",
      |       "meta": ["menumodel"],
      |       "to": "/#/menumodel"
      |     },
      |     {
      |       "name": "Menu",
      |       "meta": ["menu"],
      |       "to": "/#/menu"
      |     },
      |     {
      |       "name": "Menubar",
      |       "meta": ["menubar"],
      |       "to": "/#/menubar"
      |     }
      |   ]
      | }
      |]
      |""".stripMargin

  val data: List[MenuItemModel] =
    decode[List[MenuItemModel]](RawData) match {
      case Left(error) =>
        println(error.getMessage)
        Nil
      case Right(values) => values
    }
}
