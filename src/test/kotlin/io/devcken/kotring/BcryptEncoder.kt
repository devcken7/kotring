package io.devcken.kotring

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

fun main() {
    val encoder = BCryptPasswordEncoder()
    val encoded = encoder.encode("password")

    println(encoded)
}