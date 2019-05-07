package io.devcken.kotring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotringApplication

fun main(args: Array<String>) {
    runApplication<KotringApplication>(*args)
}
