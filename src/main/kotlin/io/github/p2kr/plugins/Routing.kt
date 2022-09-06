package io.github.p2kr.plugins

import io.github.p2kr.utilities.MainScraper
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        get("/search") {
            val query = call.request.queryParameters
            //Currently using ReadNovelFull.com
            try {
                val searchBook = MainScraper.getSearchBooksList(query)
                call.respond(searchBook)
            } catch (e: Exception) {
                call.respond(HttpStatusCode.InternalServerError, e.message!!)
            }
        }
        post("/getBook") {
            val query = call.request.queryParameters
            try {
                val book = MainScraper.getBook(query)
                call.respond(book)
            } catch (e: Exception) {
                call.respond(HttpStatusCode.InternalServerError, e.message!!)
            }
        }
    }
}
