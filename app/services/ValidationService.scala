package services

import java.util.Locale

import controllers.RegisterRequest
import play.api.data.validation.{ValidationResult, Constraints}
import play.api.libs.json.{JsError, JsSuccess}
import play.api.mvc.{Request, AnyContent}
import utils.Logging

object ValidationService extends Logging{
  def validateRegistrationRequest(request: Request[AnyContent]) = {
    request.contentType.map(_.toLowerCase(Locale.ENGLISH)) match {
      case Some("application/json") => {
        val bodyJson = request.body.asJson.get
        bodyJson.validate[RegisterRequest] match {
          case s: JsSuccess[RegisterRequest] => {
            Constraints
            Constraints.emailAddress(s.get.email) match {
              case res: ValidationResult => logger.info("Valid email address")
              case _ => throw new Exception
            }
          }
          case e: JsError => {
            throw new Exception
          }
        }
      }
    }
  }
}
