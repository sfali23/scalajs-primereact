package com.alphasystem.primereact.component.button

import enumeratum.EnumEntry.Lowercase
import enumeratum.{ CirceEnum, Enum, EnumEntry }

sealed trait IconPos extends EnumEntry with Lowercase

object IconPos extends Enum[IconPos] with CirceEnum[IconPos] {
  override def values: IndexedSeq[IconPos] = findValues

  final case object Right extends IconPos

  final case object Left extends IconPos
}
