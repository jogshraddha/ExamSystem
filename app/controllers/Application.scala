package controllers

import play.api.mvc._
import services.ValidationService
import scala.concurrent.ExecutionContext.Implicits.global

import scala.concurrent.Future

class Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def register = Action.async { implicit request => {
      ValidationService.validateRegistrationRequest(request)
      Future(Ok)
    }
  }
}
