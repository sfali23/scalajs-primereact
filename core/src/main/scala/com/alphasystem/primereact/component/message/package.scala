package com.alphasystem.primereact.component

import com.alphasystem.primereact.CallbackHandler1

import scala.scalajs.js

package object message {
  type MessageCallback = js.Function1[MessageItem, Unit]
  type MessageHandler = CallbackHandler1[MessageItem]
}
