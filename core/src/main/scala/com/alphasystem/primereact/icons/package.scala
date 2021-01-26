package com.alphasystem.primereact

import com.payalabs.scalajs.react.bridge.JsWriter

package object icons {
  implicit def IconPoWriter: JsWriter[Icon] = JsWriter(_.toClassName)
}
