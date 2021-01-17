package com.alphasystem.primereact.comoponent

import io.kinoplan.scalajs.react.bridge.JsWriter

package object button {
  implicit def iconPosWriter: JsWriter[IconPos] = JsWriter(_.entryName)

  implicit def severityWriter: JsWriter[Severity] = JsWriter(_.entryName)
}
