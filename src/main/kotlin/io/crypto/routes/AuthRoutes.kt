package io.crypto.routes

import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.request.*
import io.crypto.auth.JwtConfig
import io.crypto.service.UserService

fun Route.authRoutes() {
  val users = UserService()
  post("/login") {
    val creds = call.receive<Map<String,String>>()
    val id = users.validate(creds["email"]?:"", creds["password"]?:"")
    if (id!=null) call.respond(mapOf("token" to JwtConfig.makeToken(id))) else call.respond(mapOf("error" to "invalid"))
  }
}
