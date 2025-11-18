package io.crypto.model

data class User(val id: String, val email: String)
data class Portfolio(val id: String, val userId: String)
data class Transaction(val id: String, val portfolioId: String, val symbol: String, val amount: Double)
