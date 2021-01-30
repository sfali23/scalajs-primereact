package com.alphasystem.primereact.component

import io.kinoplan.scalajs.react.bridge.JsWriter

package object keyfilter {
  implicit def keyFilterWriter: JsWriter[KeyFilter] = JsWriter(_.entryName)
}
