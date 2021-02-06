package com.alphasystem.primereact.demo.data

import scala.scalajs.js

@js.native
trait Country extends js.Object {
  val name: String
  val code: String
}

@js.native
trait Countries extends js.Object {
  val data: js.Array[Country]
}
