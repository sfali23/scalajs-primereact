package com.alphasystem.rtg

import io.kinoplan.scalajs.react.bridge.{ ReactBridgeComponent, WithProps }

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.{ UndefOr, undefined }

object SwitchTransition extends ReactBridgeComponent {

  @JSImport("react-transition-group", "SwitchTransition")
  @js.native
  private object RawComponent extends js.Function

  override protected lazy val componentValue: js.Function = RawComponent

  def apply(mode: UndefOr[SwitchTransitionMode] = undefined): WithProps = auto
}
