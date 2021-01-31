package com.alphasystem.rtg

import io.kinoplan.scalajs.react.bridge.{ ReactBridgeComponent, WithProps }
import org.scalajs.dom.html

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.{ UndefOr, undefined, | }

object CSSTransition extends ReactBridgeComponent {

  @JSImport("react-transition-group", "CSSTransition")
  @js.native
  private object RawComponent extends js.Function

  override protected lazy val componentValue: js.Function = RawComponent

  def apply(
    nodeRef: UndefOr[html.Element] = undefined,
    classNames: UndefOr[String] = undefined,
    in: UndefOr[Boolean] = undefined,
    mountOnEnter: UndefOr[Boolean] = undefined,
    unmountOnExit: UndefOr[Boolean] = undefined,
    appear: UndefOr[Boolean] = undefined,
    enter: UndefOr[Boolean] = undefined,
    exit: UndefOr[Boolean] = undefined,
    timeout: UndefOr[Int | Timeout] = undefined,
    addEndListener: UndefOr[js.Function] = undefined,
    onEnter: UndefOr[(UndefOr[html.Element], UndefOr[Boolean]) => Unit] =
      undefined,
    onEntering: UndefOr[(UndefOr[html.Element], UndefOr[Boolean]) => Unit] =
      undefined,
    onEntered: UndefOr[(UndefOr[html.Element], UndefOr[Boolean]) => Unit] =
      undefined,
    onExit: UndefOr[UndefOr[html.Element] => Unit] = undefined,
    onExiting: UndefOr[UndefOr[html.Element] => Unit] = undefined,
    onExited: UndefOr[UndefOr[html.Element] => Unit] = undefined
  ): WithProps = auto
}
