package com.alphasystem

import japgolly.scalajs.react.Callback

import scala.scalajs.js

package object primereact {

  type Handler0[R] = () => R

  type CallbackHandler0 = Handler0[Callback]

  type Handler1[P1, R] = P1 => R

  type CallbackHandler1[P1] = Handler1[P1, Callback]

  type Handler2[P1, P2, R] = (P1, P2) => R

  type CallbackHandler2[P1, P2] = Handler2[P1, P2, Callback]

  trait ExternalCss extends js.Object
}
