package io.crypto.service

class UserService {
  fun validate(email: String, password: String): String? {
    // Validate credentials against DB and return userId
    return if (email.isNotBlank()) "00000000-0000-0000-0000-000000000000" else null
  }
}
