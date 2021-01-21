package com.alphasystem.primereact

import com.alphasystem.primereact.css.ExternalCss
import japgolly.scalajs.react.Ref.Simple
import org.scalajs.dom.html.Element

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

package object demo {

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
