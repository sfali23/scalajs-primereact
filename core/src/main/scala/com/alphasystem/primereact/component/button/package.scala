package com.alphasystem.primereact.component

import com.payalabs.scalajs.react.bridge.JsWriter

package object button {
  implicit def iconPosWriter: JsWriter[IconPos] = JsWriter(_.entryName)

  implicit def severityWriter: JsWriter[Severity] = JsWriter(_.entryName)
}
