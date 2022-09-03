package io.github.p2kr.scrapers

import io.github.p2kr.models.SearchBook
import io.ktor.http.*

val  BASE_URL = "https://readnovelfull.com"

object ReadNovelFullScraper : GenericScraper {
    override fun getSearchBooksList(query: Parameters): List<SearchBook> {
        val listOfSearchBook = listOf<SearchBook>()



        return listOfSearchBook
    }
}
