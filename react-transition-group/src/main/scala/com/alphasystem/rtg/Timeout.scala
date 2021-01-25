package com.alphasystem.rtg

case class Timeout(
  appear: Option[Int] = None,
  enter: Option[Int] = None,
  exit: Option[Int] = None)
