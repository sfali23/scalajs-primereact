package com.alphasystem.primereact.component.tabview

import japgolly.scalajs.react.ReactEventFromInput

import scala.scalajs.js

abstract class TabChangeEvent extends js.Object {
  val originalEvent: ReactEventFromInput
  val index: Int
}
