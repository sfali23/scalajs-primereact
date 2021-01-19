package com.alphasystem.primereact.comoponent.button

import enumeratum.{ CirceEnum, Enum, EnumEntry }

sealed abstract class ButtonSize(override val entryName: String)
    extends EnumEntry {
  val toClassName = s"p-button-$entryName"
}

object ButtonSize extends Enum[ButtonSize] with CirceEnum[ButtonSize] {
  override def values: IndexedSeq[ButtonSize] = findValues

  final case object Small extends ButtonSize("sm")

  final case object Large extends ButtonSize("lg")
}
