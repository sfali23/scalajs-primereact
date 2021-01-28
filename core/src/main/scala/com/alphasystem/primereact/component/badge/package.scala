package com.alphasystem.primereact.component

import io.kinoplan.scalajs.react.bridge.JsWriter

package object badge {
  implicit def badgeTypeWriter: JsWriter[BadgeType] = JsWriter(_.entryName)
}
