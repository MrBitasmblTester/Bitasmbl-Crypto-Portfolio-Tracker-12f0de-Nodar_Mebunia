package io.crypto.service

import io.ktor.client.*
import io.ktor.client.request.*

class CryptoService(private val client: HttpClient) {
  suspend fun price(id: String): Double {
    val url = "https://api.coingecko.com/api/v3/simple/price?ids=$id&vs_currencies=usd"
    val resp: Map<String, Map<String, Double>> = client.get(url)
    return resp[id]?.get("usd") ?: 0.0
  }
}
