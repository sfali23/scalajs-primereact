package com.alphasystem.primereact.comoponent.badge

import enumeratum.EnumEntry.Lowercase
import enumeratum.{ CirceEnum, Enum, EnumEntry }

sealed trait BadgeType extends EnumEntry with Lowercase {
  val toClassName = s"p-badge-$entryName"
}

object BadgeType extends Enum[BadgeType] with CirceEnum[BadgeType] {
  override def values: IndexedSeq[BadgeType] = findValues

  final case object Secondary extends BadgeType

  final case object Success extends BadgeType

  final case object Info extends BadgeType

  final case object Warning extends BadgeType

  final case object Danger extends BadgeType
}
