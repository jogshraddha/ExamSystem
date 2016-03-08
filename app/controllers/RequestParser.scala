package controllers

import play.api.libs.json.{JsObject, JsPath, Reads, JsValue}
import play.api.libs.functional.syntax._

/**
  * Created by synerzip on 8/3/16.
  */
case class RegisterRequest(firstname: String, lastname: String, email :String)
object RegisterRequest {
  implicit val registerRequestReads: Reads[RegisterRequest] = (
    (JsPath \ "firstname").read[String] and
      (JsPath \ "lastname").read[String] and
      (JsPath \ "email").read[String]
    )(RegisterRequest.apply _)
}