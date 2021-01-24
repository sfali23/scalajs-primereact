package com.alphasystem.primereact.demo

import japgolly.scalajs.react.React
import japgolly.scalajs.react.React.Context

case class GlobalState(
  theme: String = "",
  inputStyle: String = "",
  darkTheme: Boolean = false)

object GlobalState {
  val ctx: Context[GlobalState] = React.createContext(GlobalState())
}
