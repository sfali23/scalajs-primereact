package com.alphasystem.primereact.component.message

import enumeratum.EnumEntry.Hyphencase
import enumeratum.{ Enum, EnumEntry }

sealed trait Position extends EnumEntry with Hyphencase

object Position extends Enum[Position] {
  override def values: IndexedSeq[Position] = findValues

  final case object TopRight extends Position

  final case object TopLeft extends Position

  final case object TopCenter extends Position

  final case object BottomRight extends Position

  final case object BottomLeft extends Position

  final case object BottomCenter extends Position
}
