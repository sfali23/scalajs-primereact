package com.alphasystem.rtg

import enumeratum.{ CirceEnum, Enum, EnumEntry }

sealed abstract class SwitchTransitionMode(override val entryName: String)
    extends EnumEntry

object SwitchTransitionMode
    extends Enum[SwitchTransitionMode]
    with CirceEnum[SwitchTransitionMode] {
  override def values: IndexedSeq[SwitchTransitionMode] = findValues

  final case object OutIn extends SwitchTransitionMode("out-in")

  final case object InOut extends SwitchTransitionMode("in-out")
}
