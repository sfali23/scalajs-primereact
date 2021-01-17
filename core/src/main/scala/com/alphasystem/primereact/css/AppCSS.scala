package com.alphasystem.primereact.css

import scalacss.internal.mutable.GlobalRegistry

object AppCSS {

  import CssSettings._

  def load(styleSheets: StyleSheet.Inline*): Unit = {
    val ss = CommonStyles +: styleSheets
    GlobalRegistry.register(ss: _*)
    GlobalRegistry.onRegistration(_.addToDocument())
  }
}
