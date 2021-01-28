package com.alphasystem.primereact

import io.kinoplan.scalajs.react.bridge.JsWriter

package object icons {
  implicit def IconPoWriter: JsWriter[Icon] = JsWriter(_.toClassName)
}
