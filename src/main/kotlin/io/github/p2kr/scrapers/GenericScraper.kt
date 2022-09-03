package io.github.p2kr.scrapers

import io.github.p2kr.models.SearchBook
import io.ktor.http.*

interface GenericScraper {
    fun getSearchBooksList(query: Parameters): List<SearchBook>
}
