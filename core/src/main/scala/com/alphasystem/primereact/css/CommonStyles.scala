package com.alphasystem.primereact.css

import CssSettings._

import scala.language.postfixOps

object CommonStyles extends StyleSheet.Inline {
  import dsl._

  val size: Int => StyleA = styleF.int(1 to 5)(i => styleS(fontSize(i em)))
}
