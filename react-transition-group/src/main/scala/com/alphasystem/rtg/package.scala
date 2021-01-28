package com.alphasystem

import io.circe.generic.auto._
import io.circe.scalajs.convertJsonToJs
import io.circe.syntax._
import io.kinoplan.scalajs.react.bridge.JsWriter

package object rtg {

  implicit def TimeoutWriter: JsWriter[Timeout] =
    JsWriter(jw => convertJsonToJs(jw.asJson.deepDropNullValues))

  implicit def switchTransitionModeWriter: JsWriter[SwitchTransitionMode] =
    JsWriter(_.entryName)
}
