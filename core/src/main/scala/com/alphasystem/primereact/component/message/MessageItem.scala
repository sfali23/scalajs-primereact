package com.alphasystem.primereact.component.message

import scala.scalajs.js
import scala.scalajs.js.JSConverters._
import scala.scalajs.js.{ UndefOr, undefined, | }

@js.native
trait MessageItem extends js.Object {

  /*
   * Severity of the message.
   */
  val severity: UndefOr[String] = undefined

  /*
   * Summary content of the message.
   */
  val summary: UndefOr[String | js.Any] = undefined

  /*
   * Detail content of the message.
   */
  val detail: UndefOr[String | js.Any] = undefined

  /*
   * Template of the message.
   */
  val content: UndefOr[js.Any] = undefined

  /*
   * Whether the message can be closed manually using the close icon.
   */
  val closable: UndefOr[Boolean] = undefined

  /*
   * When enabled, message is not removed automatically.
   */
  val sticky: UndefOr[Boolean] = undefined

  /*
   * Delay in milliseconds to close the message automatically.
   */
  val life: UndefOr[Int] = undefined
}

object MessageItem {

  def apply(
    severity: UndefOr[Severity] = undefined,
    summary: UndefOr[String | js.Any] = undefined,
    detail: UndefOr[String | js.Any] = undefined,
    content: UndefOr[js.Any] = undefined,
    closable: UndefOr[Boolean] = undefined,
    sticky: UndefOr[Boolean] = undefined,
    life: UndefOr[Int] = undefined
  ): MessageItem = {
    val o: Map[String, Any] = Map(
      "severity" -> severity.map(_.entryName),
      "summary"  -> summary,
      "detail"   -> detail,
      "content"  -> content,
      "closable" -> closable,
      "sticky"   -> sticky,
      "life"     -> life
    )
    o.toJSDictionary.asInstanceOf[js.Object].asInstanceOf[MessageItem]
  }

}
