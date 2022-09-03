package io.github.p2kr

import io.github.p2kr.plugins.configureHTTP
import io.github.p2kr.plugins.configureRouting
import io.github.p2kr.plugins.configureSecurity
import io.github.p2kr.plugins.configureSerialization
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    System.setProperty(
        "webdriver.chrome.driver",
        "C:/Users/KIIT/Documents/IdeaProjects/novel_reader_api/src/main/resources/chromedriver.exe"
    )
    System.setProperty(
        "webdriver.gecko.driver",
        "C:/Users/KIIT/Documents/IdeaProjects/novel_reader_api/src/main/resources/geckodriver.exe"
    )
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureHTTP()
        configureSecurity()
        configureSerialization()
        configureRouting()
    }.start(wait = true)
}
