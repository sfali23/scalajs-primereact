package com.alphasystem.primereact.component.external.rtg

import io.circe.generic.auto._
import io.circe.scalajs.convertJsonToJs
import io.circe.syntax._
import io.kinoplan.scalajs.react.bridge.{
  JsWriter,
  ReactBridgeComponent,
  WithProps
}
import org.scalajs.dom.html

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.{ UndefOr, undefined, | }

object CSSTransition extends ReactBridgeComponent {

  case class Timeout(
    appear: Option[Int] = None,
    enter: Option[Int] = None,
    exit: Option[Int] = None)

  private implicit def TimeoutWriter: JsWriter[Timeout] =
    JsWriter(jw => convertJsonToJs(jw.asJson.deepDropNullValues))

  @JSImport("react-transition-group", "CSSTransition")
  @js.native
  private object RawComponent extends js.Function

  override protected lazy val componentValue: js.Function = RawComponent

  def apply(
    classNames: UndefOr[String] = undefined,
    in: UndefOr[Boolean] = undefined,
    mountOnEnter: UndefOr[Boolean] = undefined,
    unmountOnExit: UndefOr[Boolean] = undefined,
    appear: UndefOr[Boolean] = undefined,
    enter: UndefOr[Boolean] = undefined,
    exit: UndefOr[Boolean] = undefined,
    timeout: UndefOr[Int | Timeout] = undefined,
    addEndListener: UndefOr[js.Function] = undefined,
    onEnter: UndefOr[js.Function] = undefined,
    onEntering: UndefOr[js.Function] = undefined,
    onEntered: UndefOr[js.Function] = undefined,
    onExit: UndefOr[js.Function] = undefined,
    onExiting: UndefOr[js.Function] = undefined,
    onExited: UndefOr[js.Function] = undefined
  ): WithProps = auto
}
