package de.zalando.play.controllers

import javax.inject.Inject

import play.api.Application

import scala.concurrent.ExecutionContext

/**
 * @since 12.05.2016.
 */
class Contexts @Inject() (app: Option[Application], ec: ExecutionContext) {
  implicit val tokenChecking: ExecutionContext = app map { app =>
    app.actorSystem.dispatchers.lookup("akka.actor.play-api-first-oauth-token-checker")
  } getOrElse { ec }
}
