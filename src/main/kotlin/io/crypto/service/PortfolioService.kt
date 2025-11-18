package io.crypto.service

class PortfolioService {
  fun recordTransaction(portfolioId: String, symbol: String, amount: Double) {
    // persist transaction via Exposed in real implementation
  }
  fun calculateValue(): Double { return 0.0 }
}
