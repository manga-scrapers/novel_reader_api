package io.github.p2kr.utilities

import com.google.gson.Gson
import io.github.p2kr.models.SearchBook
import io.github.p2kr.scrapers.GenericScraper
import io.github.p2kr.scrapers.ReadNovelFullScraper
import io.ktor.http.*

val gson = Gson()

object MainScraper : GenericScraper {
    override fun getSearchBooksList(query: Parameters): List<SearchBook> {
        return ReadNovelFullScraper.getSearchBooksList(query);
    }
}
