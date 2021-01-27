package com.alphasystem.primereact

import japgolly.scalajs.react.Ref.Simple
import japgolly.scalajs.react.vdom.all._
import org.scalajs.dom.html.Element
import scalacss.ScalaCssReactImplicits

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

package object demo {

  val SourceCodeLinkPrefix: String =
    "https://github.com/sfali23/scalajs-primereact/blob/main/demo/src/main/scala/com/alphasystem/primereact/demo"

  trait SourceCodeLink {
    this: ScalaCssReactImplicits =>

    protected def sourceCodeLink(
      mainCode: String,
      showcaseCode: String
    ): VdomElement =
      div(
        "Source code can be found ",
        a(
          href := s"${SourceCodeLinkPrefix}/pages/$mainCode",
          target := "_blank",
          rel := "noopener noreferrer"
        )("here"),
        " and ",
        a(
          href := s"${SourceCodeLinkPrefix}/components/$showcaseCode",
          target := "_blank",
          rel := "noopener noreferrer"
        )("here"),
        "."
      )
  }

  def routerLink(linkName: String, routerLink: String): VdomElement =
    a(href := s"/#/$routerLink")(linkName)

  @js.native
  @JSImport(
    "../../../../src/main/resources/assets/app/App.css",
    JSImport.Namespace
  )
  object AppCss extends ExternalCss

  @js.native
  @JSImport(
    "../../../../src/main/resources/assets/app/ButtonDemo.css",
    JSImport.Namespace
  )
  object ButtonDemoCss extends ExternalCss

  @js.native
  @JSImport(
    "../../../../src/main/resources/assets/app/TabViewDemo.css",
    JSImport.Namespace
  )
  object TabViewDemoCss extends ExternalCss

  @js.native
  @JSImport("prismjs", JSImport.Namespace)
  object PrismJs extends js.Object

  @js.native
  @JSImport("prismjs/components/prism-core", JSImport.Default)
  object Prism extends js.Object {
    def highlightElement(code: Simple[Element]): js.Any = js.native
  }

  @js.native
  @JSImport("prismjs/components/prism-clike", JSImport.Namespace)
  object PrismCLike extends js.Object

  @js.native
  @JSImport("prismjs/components/prism-java", JSImport.Namespace)
  object PrismJava extends js.Object

  @js.native
  @JSImport("prismjs/components/prism-scala", JSImport.Namespace)
  object PrismScala extends js.Object

  @js.native
  @JSImport(
    "../../../../src/main/resources/assets/app/prism.css",
    JSImport.Default
  )
  object PrismCss extends ExternalCss

  @js.native
  @JSImport("prismjs/themes/prism-coy.css", JSImport.Default)
  object PrismCoy extends ExternalCss
}
