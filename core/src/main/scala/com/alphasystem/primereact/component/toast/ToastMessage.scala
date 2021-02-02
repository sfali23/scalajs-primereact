package com.alphasystem.primereact.component.toast

import scala.scalajs.js
import scala.scalajs.js.JSConverters._
import scala.scalajs.js.{ UndefOr, undefined }

@js.native
trait ToastMessage extends js.Object {
  val severity: UndefOr[String] = undefined
  val summary: UndefOr[js.Any] = undefined
  val detail: UndefOr[js.Any] = undefined
  val content: UndefOr[js.Any] = undefined
  val closable: UndefOr[Boolean] = undefined
  val sticky: UndefOr[Boolean] = undefined
  val life: UndefOr[Int] = undefined
}

object ToastMessage {

  def apply(
    severity: Option[Severity] = None,
    summary: Option[js.Any] = None,
    detail: Option[js.Any] = None,
    content: Option[js.Any] = None,
    closable: Option[Boolean] = None,
    sticky: Option[Boolean] = None,
    life: Option[Int] = None
  ): ToastMessage = {
    val o: Map[String, Any] = Map(
      "severity" -> severity.map(_.entryName).orUndefined,
      "summary"  -> summary.orUndefined,
      "detail"   -> detail.orUndefined,
      "content"  -> content.orUndefined,
      "closable" -> closable.orUndefined,
      "sticky"   -> sticky.orUndefined,
      "life"     -> life.orUndefined
    )
    o.toJSDictionary.asInstanceOf[js.Object].asInstanceOf[ToastMessage]
  }

}
