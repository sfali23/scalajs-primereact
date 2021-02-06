package com.alphasystem.axios

import scala.scalajs.js
import scala.scalajs.js.annotation._

@js.native
@JSImport("axios", JSImport.Default)
class Axios(val config: Config = Axios.defaults) extends js.Object {
  def request(config: Config): js.Promise[Response] = js.native
  def get(url: String, config: Config = null): js.Promise[Response] = js.native

  def delete(url: String, config: Config = null): js.Promise[Response] =
    js.native
  def head(url: String, config: Config = null): js.Promise[Response] = js.native

  def options(url: String, config: Config = null): js.Promise[Response] =
    js.native
  def post(url: String, config: Config = null): js.Promise[Response] = js.native
  def put(url: String, config: Config = null): js.Promise[Response] = js.native

  def patch(url: String, config: Config = null): js.Promise[Response] =
    js.native
}

@js.native
@JSImport("axios", JSImport.Namespace)
object Axios extends js.Object {
  var defaults: Config = js.native

  def create(config: Config): Axios = js.native
  def request(config: Config): js.Promise[Response] = js.native
  def get(url: String, config: Config = null): js.Promise[Response] = js.native

  def delete(url: String, config: Config = null): js.Promise[Response] =
    js.native
  def head(url: String, config: Config = null): js.Promise[Response] = js.native

  def options(url: String, config: Config = null): js.Promise[Response] =
    js.native
  def post(url: String, config: Config = null): js.Promise[Response] = js.native
  def put(url: String, config: Config = null): js.Promise[Response] = js.native

  def patch(url: String, config: Config = null): js.Promise[Response] =
    js.native
}

@js.native
trait Config extends js.Object {
  type RequestTransform = js.Function2[js.Dynamic, js.Dictionary[String], _]
  type ResponseTransform = js.Function1[js.Dynamic, _]
  type ParamsSerializer = js.Function1[js.Dictionary[js.Any], _]
  type Adapter = js.Function1[Config, js.Promise[Response]]
  type Progress = js.Function1[js.Dynamic, Unit]
  type ValidateStatus = js.Function1[Int, Boolean]

  var url: String = js.native
  var method: String = js.native
  var baseURL: String = js.native
  var transformRequest: js.Array[RequestTransform] = js.native
  var transformResponse: js.Array[ResponseTransform] = js.native
  var headers: js.Dictionary[String] = js.native
  var params: js.Dictionary[js.Any] = js.native
  var paramsSerializer: ParamsSerializer = js.native
  var data: js.Dynamic = js.native
  var timeout: Int = js.native
  var withCredentials: Boolean = js.native
  var adapter: Adapter = js.native
  var auth: Auth = js.native
  var responseType: String = js.native
  var xsrfCookieName: String = js.native
  var xsrfHeaderName: String = js.native
  var onUploadProgress: Progress = js.native
  var onDownloadProgress: Progress = js.native
  var maxContentLength: Int = js.native
  var validateStatus: ValidateStatus = js.native
  var maxRedirects: Int = js.native
  var httpAgent: HttpAgent = js.native
  var httpsAgent: HttpAgent = js.native
  var proxy: Proxy = js.native
  var cancelToken: CancelToken = js.native
}

object Config {

  def apply(headers: js.Dictionary[String]): Config = {
    val config = (new js.Object).asInstanceOf[Config]
    config.headers = headers
    config
  }
}

@js.native
@JSGlobal
class Response extends js.Object {
  val data: js.Dynamic = js.native
  val status: Int = js.native
  val statusText: String = js.native
  val headers: js.Dictionary[String] = js.native
  val config: Config = js.native
  val request: js.Any = js.native
}

@js.native
@JSGlobal
class CancelToken(val callback: js.Function1[js.Any, _]) extends js.Object {
  def source(): js.Any = js.native
}

sealed abstract class ResponseType(val value: String) {
  override def toString: String = value
}

case object ArrayBuffer extends ResponseType("arraybuffer")
case object Blob extends ResponseType("blob")
case object Document extends ResponseType("document")
case object JSON extends ResponseType("json")
case object Text extends ResponseType("text")
case object Stream extends ResponseType("stream")

@js.native
@JSGlobal
class Auth(val username: String, val password: String) extends js.Object

@js.native
@JSGlobal
class Proxy(
  val host: String,
  val port: Int,
  val auth: Auth = null)
    extends js.Object

@js.native
@JSGlobal
class HttpAgent(
  val keepAlive: Boolean = false,
  val keepAliveMsecs: Int = 1000,
  val maxSockets: Int = 1024,
  val maxFreeSockets: Int = 256)
    extends js.Object
