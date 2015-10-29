package controllers

import models._
import play.api.Routes
import play.api.cache._
import play.api.libs.functional.syntax._
import play.api.libs.json.Reads._
import play.api.libs.json._
import play.api.mvc._

class Phrase(val cache: CacheApi) extends Controller with Logging {

  // def authUser() = HasToken(parse.empty) { token => userId => implicit request =>
  //   Ok(Json.toJson(User.findOneById(userId)))
  // }

  case class Dictionary(entry: String, password: String)


 implicit val DictionaryFromJson = (
    (__ \ "entry").read[String](minLength[String](5)) ~
      (__ \ "password").read[String](minLength[String](8))
    )((entry, password) => Dictionary(entry, password))


  def submit() = Action(parse.json) { implicit request =>
    request.body.validate[Dictionary].fold(
      errors => {
        BadRequest(Json.obj("status" -> "KO", "message" -> JsError.toJson(errors)))
      },
      dictionary => {
        log.info("adding entry to dictionary")
        Ok(Json.obj("myresponse" -> "sssss"))
      }
    )
  }

}
