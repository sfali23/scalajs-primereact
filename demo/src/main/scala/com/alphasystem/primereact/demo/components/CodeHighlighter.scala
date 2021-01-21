package com.alphasystem.primereact.demo.components

import com.alphasystem.primereact.demo._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import org.scalajs.dom.html
import scalacss.ScalaCssReactImplicits

object CodeHighlighter extends ScalaCssReactImplicits {

  private val ref = Ref[html.Element]

  final case class Props(lang: String)

  case class Backend(b: BackendScope[Props, Unit]) {

    private val p = Prism
    private val c = PrismCLike
    // TODO: figure out why we are getting
    //  prism-java.js:36 Uncaught TypeError: Cannot read property 'function' of undefined
    //private val j = PrismJava
    //private val s = PrismScala

    def render(
      props: Props,
      children: PropsChildren
    ): VdomElement = {
      val languageClassName = s"language-${props.lang}"
      pre(
        code(cls := languageClassName)(children).withRef(ref)
      )
    }

    def init: Callback = {
      Callback {
        try {
          Prism.highlightElement(ref)
        } catch {
          case _: Throwable => ()
        }
      }
    }
  }

  private val component = ScalaComponent
    .builder[Props]("CodeHighlighter")
    .renderBackendWithChildren[Backend]
    .componentDidMount(_.backend.init)
    .componentDidUpdate(_.backend.init)
    .build

  def apply(lang: String = "scala")(children: VdomNode*): VdomElement =
    component(Props(lang))(children: _*)
}
