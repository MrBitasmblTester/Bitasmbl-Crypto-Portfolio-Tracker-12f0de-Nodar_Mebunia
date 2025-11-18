package io.crypto.auth

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm

object JwtConfig {
  private val secret = "CHANGE_ME_SECRET"
  private val algorithm = Algorithm.HMAC256(secret)
  fun makeToken(id: String) = JWT.create().withClaim("id", id).sign(algorithm)
}
