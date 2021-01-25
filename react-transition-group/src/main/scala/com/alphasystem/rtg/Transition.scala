package com.alphasystem.rtg

import io.kinoplan.scalajs.react.bridge.{ ReactBridgeComponent, WithProps }
import org.scalajs.dom.html

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.{ UndefOr, undefined, | }

object Transition extends ReactBridgeComponent {

  @JSImport("react-transition-group", "Transition")
  @js.native
  private object RawComponent extends js.Function

  override protected lazy val componentValue: js.Function = RawComponent

  def apply(
    nodeRef: UndefOr[html.Element] = undefined,
    in: UndefOr[Boolean] = undefined,
    mountOnEnter: UndefOr[Boolean] = undefined,
    unmountOnExit: UndefOr[Boolean] = undefined,
    appear: UndefOr[Boolean] = undefined,
    enter: UndefOr[Boolean] = undefined,
    exit: UndefOr[Boolean] = undefined,
    timeout: UndefOr[Int | Timeout] = undefined,
    addEndListener: UndefOr[js.Function] = undefined,
    onEnter: UndefOr[js.Function2[UndefOr[html.Element], UndefOr[Boolean], _]] =
      undefined,
    onEntering: UndefOr[
      js.Function2[UndefOr[html.Element], UndefOr[Boolean], _]
    ] = undefined,
    onEntered: UndefOr[
      js.Function2[UndefOr[html.Element], UndefOr[Boolean], _]
    ],
    onExit: UndefOr[js.Function1[UndefOr[html.Element], _]] = undefined,
    onExiting: UndefOr[js.Function1[UndefOr[html.Element], _]] = undefined,
    onExited: UndefOr[js.Function1[UndefOr[html.Element], _]] = undefined
  ): WithProps = auto
}
