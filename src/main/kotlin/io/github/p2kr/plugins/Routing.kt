package io.github.p2kr.plugins

import com.google.gson.Gson
import io.github.p2kr.utilities.MainScraper
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    val gson = Gson()
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        get("/search") {
            val query = call.request.queryParameters
            //Currently using ReadNovelFull.com
            val searchBook = MainScraper.getSearchBooksList(query);
            call.respond(searchBook)
        }
    }
}
