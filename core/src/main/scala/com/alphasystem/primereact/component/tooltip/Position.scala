package com.alphasystem.primereact.component.tooltip

import enumeratum.EnumEntry.Lowercase
import enumeratum.{ Enum, EnumEntry }

sealed trait Position extends EnumEntry with Lowercase

object Position extends Enum[Position] {
  override def values: IndexedSeq[Position] = findValues

  final case object Right extends Position

  final case object Left extends Position

  final case object Top extends Position

  final case object Bottom extends Position

}
