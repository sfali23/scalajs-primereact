package com.alphasystem

import scala.scalajs.js

package object primereact {

  type Handler0[R] = () => R

  type Handler1[P1, R] = P1 => R

  type Handler2[P1, P2, R] = (P1, P2) => R

  trait ExternalCss extends js.Object
}
