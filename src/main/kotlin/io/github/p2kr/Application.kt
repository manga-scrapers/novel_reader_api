package io.github.p2kr

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.github.p2kr.plugins.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureHTTP()
        configureSecurity()
        configureSerialization()
        configureRouting()
    }.start(wait = true)
}
