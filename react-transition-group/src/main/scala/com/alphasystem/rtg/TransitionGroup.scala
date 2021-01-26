package com.alphasystem.rtg

import com.payalabs.scalajs.react.bridge.{ ReactBridgeComponent, WithProps }

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.{ UndefOr, undefined }

object TransitionGroup extends ReactBridgeComponent {

  @JSImport("react-transition-group", "SwitchTransition")
  @js.native
  private object RawComponent extends js.Function

  override protected lazy val componentValue: js.Function = RawComponent

  def apply(
    component: UndefOr[js.Any] = undefined,
    appear: UndefOr[Boolean] = undefined,
    enter: UndefOr[Boolean] = undefined,
    exit: UndefOr[Boolean] = undefined,
    childFactory: UndefOr[js.Function1[js.Any, js.Any]] = undefined
  ): WithProps = auto
}
