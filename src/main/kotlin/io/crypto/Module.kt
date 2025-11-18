package io.crypto

import io.ktor.server.application.*
import io.ktor.server.routing.*
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.crypto.db.DatabaseFactory
import io.crypto.routes.*

fun Application.module() {
  DatabaseFactory.init()
  val client = HttpClient(CIO)
  routing {
    authRoutes()
    portfolioRoutes()
  }
}
