package com.alphasystem.primereact.component.dialog

import enumeratum.EnumEntry.Hyphencase
import enumeratum.{ Enum, EnumEntry }

sealed trait Position extends EnumEntry with Hyphencase

object Position extends Enum[Position] {
  override def values: IndexedSeq[Position] = findValues

  final case object Center extends Position

  final case object Top extends Position

  final case object Bottom extends Position

  final case object Left extends Position

  final case object Right extends Position

  final case object TopLeft extends Position

  final case object TopRight extends Position

  final case object BottomLeft extends Position

  final case object BottomRight extends Position

}
