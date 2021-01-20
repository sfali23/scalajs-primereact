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

  // code highlight styles
  val codeHighlight: StyleA = style(
    background := c"#FDFDFD",
    overflow.auto,
    width.auto,
    border(solid, c"#495057"),
    borderWidth(0.1 em, 0.1 em, 0.1 em, 0.8 em),
    padding(0.2 em, 0.6 em)
  )

  val codeHighlightPre: StyleA = style(
    margin.`0`,
    lineHeight(125 %%)
  )

  val codeHighlightKeyword: StyleA = style(
    color(c"#008000"),
    fontWeight.bold
  )

  val codeHighlightCodeSnippet: StyleA = style(
    color(c"#0000FF"),
    fontWeight.bold
  )

  val codeHighlightVariable1: StyleA = style(
    color(c"#666666")
  )

  val codeHighlightVariable2: StyleA = style(
    color(c"#BA2121")
  )
}
