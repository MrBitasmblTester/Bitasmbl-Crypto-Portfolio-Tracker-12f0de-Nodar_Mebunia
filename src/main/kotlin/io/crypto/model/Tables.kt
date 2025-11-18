package io.crypto.model

import org.jetbrains.exposed.sql.Table

object Users : Table("users") { val id = uuid("id").primaryKey(); val email = varchar("email",255) }
object Portfolios : Table("portfolios") { val id = uuid("id").primaryKey(); val userId = uuid("user_id").references(Users.id) }
object Transactions : Table("transactions") { val id = uuid("id").primaryKey(); val portfolioId = uuid("portfolio_id").references(Portfolios.id); val symbol = varchar("symbol",64); val amount = double("amount") }
