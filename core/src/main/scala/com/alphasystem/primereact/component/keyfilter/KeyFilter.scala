package com.alphasystem.primereact.component.keyfilter

import enumeratum.{ CirceEnum, Enum, EnumEntry }

sealed abstract class KeyFilter(override val entryName: String)
    extends EnumEntry

object KeyFilter extends Enum[KeyFilter] with CirceEnum[KeyFilter] {
  override def values: IndexedSeq[KeyFilter] = findValues

  final case object PositiveInteger extends KeyFilter("pint")

  final case object Integer extends KeyFilter("int")

  final case object PositiveNumber extends KeyFilter("pnum")

  final case object Number extends KeyFilter("num")

  final case object Money extends KeyFilter("money")

  final case object Hexadecimal extends KeyFilter("hex")

  final case object Email extends KeyFilter("email")

  final case object Alphabetic extends KeyFilter("alpha")

  final case object Alphanumeric extends KeyFilter("alphanum")
}
