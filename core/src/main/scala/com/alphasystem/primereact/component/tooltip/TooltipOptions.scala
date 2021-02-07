package com.alphasystem.primereact.component.tooltip

import scala.scalajs.js
import scala.scalajs.js.{ UndefOr, undefined }

@js.native
trait TooltipOptions extends js.Object {
  var position: UndefOr[String] = undefined
  var event: UndefOr[String] = undefined
  var hideDelay: UndefOr[Int] = undefined
  var showDelay: UndefOr[Int] = undefined
  var className: UndefOr[String] = undefined
  var showEvent: UndefOr[String] = undefined
  var hideEvent: UndefOr[String] = undefined
  var autoZIndex: UndefOr[Boolean] = undefined
  var baseZIndex: UndefOr[Int] = undefined
  var mouseTrack: UndefOr[Boolean] = undefined
  var mouseTrackTop: UndefOr[Int] = undefined
  var mouseTrackLeft: UndefOr[Int] = undefined
}

object TooltipOptions {

  def apply(
    position: UndefOr[Position] = undefined,
    event: UndefOr[String] = undefined,
    hideDelay: UndefOr[Int] = undefined,
    showDelay: UndefOr[Int] = undefined,
    className: UndefOr[String] = undefined,
    showEvent: UndefOr[String] = undefined,
    hideEvent: UndefOr[String] = undefined,
    autoZIndex: UndefOr[Boolean] = undefined,
    baseZIndex: UndefOr[Int] = undefined,
    mouseTrack: UndefOr[Boolean] = undefined,
    mouseTrackTop: UndefOr[Int] = undefined,
    mouseTrackLeft: UndefOr[Int] = undefined
  ): TooltipOptions = {
    val tooltipOption = (new js.Object).asInstanceOf[TooltipOptions]
    tooltipOption.position = position.map(_.entryName)
    tooltipOption.event = event
    tooltipOption.hideDelay = hideDelay
    tooltipOption.showDelay = showDelay
    tooltipOption.className = className
    tooltipOption.showEvent = showEvent
    tooltipOption.hideEvent = hideEvent
    tooltipOption.autoZIndex = autoZIndex
    tooltipOption.baseZIndex = baseZIndex
    tooltipOption.mouseTrack = mouseTrack
    tooltipOption.mouseTrackTop = mouseTrackTop
    tooltipOption.mouseTrackLeft = mouseTrackLeft
    tooltipOption
  }
}
