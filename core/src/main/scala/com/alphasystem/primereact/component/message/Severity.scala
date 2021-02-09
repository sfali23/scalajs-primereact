package com.alphasystem.primereact.component.message

import enumeratum.EnumEntry.Lowercase
import enumeratum.{ Enum, EnumEntry }

sealed trait Severity extends EnumEntry with Lowercase

object Severity extends Enum[Severity] {
  override def values: IndexedSeq[Severity] = findValues

  final case object Success extends Severity

  final case object Info extends Severity

  final case object Warn extends Severity

  final case object Error extends Severity

}
