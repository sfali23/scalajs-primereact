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
    severity: UndefOr[Severity] = undefined,
    summary: UndefOr[js.Any] = undefined,
    detail: UndefOr[js.Any] = undefined,
    content: UndefOr[js.Any] = undefined,
    closable: UndefOr[Boolean] = undefined,
    sticky: UndefOr[Boolean] = undefined,
    life: UndefOr[Int] = undefined
  ): ToastMessage = {
    val o: Map[String, Any] = Map(
      "severity" -> severity.map(_.entryName),
      "summary"  -> summary,
      "detail"   -> detail,
      "content"  -> content,
      "closable" -> closable,
      "sticky"   -> sticky,
      "life"     -> life
    )
    o.toJSDictionary.asInstanceOf[js.Object].asInstanceOf[ToastMessage]
  }

}
