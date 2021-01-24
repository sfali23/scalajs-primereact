package com.alphasystem.primereact.demo.css

import com.alphasystem.primereact.css.CssSettings._

import scala.language.postfixOps

object DemoStyles extends StyleSheet.Inline {

  import dsl._

  val imageRow: StyleA = style(
    boxSizing.borderBox,
    &.after(
      clear.both,
      display.table
    )
  )

  val imageColumn: StyleA = style(
    float.left,
    width(50 %%),
    padding(5 px)
  )
}
