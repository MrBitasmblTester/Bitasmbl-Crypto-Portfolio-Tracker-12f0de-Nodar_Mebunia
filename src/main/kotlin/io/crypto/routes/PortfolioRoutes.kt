package io.crypto.routes

import io.ktor.server.routing.*
import io.ktor.server.auth.*
import io.ktor.server.response.*
import io.ktor.server.request.*

fun Route.portfolioRoutes() {
  authenticate {
    get("/portfolio") { call.respond(mapOf("value" to 0.0)) }
    post("/portfolio/tx") {
      val body = call.receive<Map<String,Any>>()
      call.respond(mapOf("status" to "ok"))
    }
  }
}
