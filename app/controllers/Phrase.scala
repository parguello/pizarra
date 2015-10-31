package controllers

import play.api.Routes
import play.api.cache._
import play.api.libs.functional.syntax._
import play.api.libs.json.Reads._
import play.api.libs.json._
import play.api.mvc._

import models._

class Phrase(val cache: CacheApi) extends Controller with Logging {

  // def authUser() = HasToken(parse.empty) { token => userId => implicit request =>
  //   Ok(Json.toJson(User.findOneById(userId)))
  // }

  case class Dictionary(spanish: String, english: String)


 implicit val DictionaryFromJson = (
      (__ \ "spanish").read[String] ~ 
      (__ \ "english").read[String]
    ) (
      (spanish, english) => Dictionary(spanish, english)
    )


  def submit() = Action(parse.json) { implicit request =>
    request.body.validate[Dictionary].fold(
      errors => {
        BadRequest(Json.obj("status" -> "KO", "message" -> JsError.toJson(errors)))
      },
      dictionary => {
        log.info("adding entry to dictionary")
        Ok(Json.obj("myresponse" -> "successssssss"))
      }
    )
  }

}
