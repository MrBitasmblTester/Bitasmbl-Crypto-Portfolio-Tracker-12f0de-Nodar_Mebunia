package io.crypto.db

import org.jetbrains.exposed.sql.Database
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource

object DatabaseFactory {
  fun init(jdbcUrl: String = "jdbc:postgresql://localhost:5432/crypto") {
    val config = HikariConfig().apply { this.jdbcUrl = jdbcUrl; username = "postgres"; password = "postgres" }
    Database.connect(HikariDataSource(config))
  }
}
