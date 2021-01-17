package com.alphasystem.primereact.comoponent.button

import enumeratum.EnumEntry.Lowercase
import enumeratum.{ CirceEnum, Enum, EnumEntry }

sealed trait Severity extends EnumEntry with Lowercase {
  val toClassName = s"p-button-$entryName"
}

object Severity extends Enum[Severity] with CirceEnum[Severity] {
  override def values: IndexedSeq[Severity] = findValues

  final case object Secondary extends Severity

  final case object Success extends Severity

  final case object Info extends Severity

  final case object Warning extends Severity

  final case object Help extends Severity

  final case object Danger extends Severity
}
