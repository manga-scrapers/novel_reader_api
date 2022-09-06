package io.github.p2kr.utilities

import com.google.gson.Gson
import io.github.p2kr.models.Book
import io.github.p2kr.models.Chapter
import io.github.p2kr.models.SearchBook
import io.github.p2kr.scrapers.GenericScraper
import io.github.p2kr.scrapers.ReadNovelFullScraper
import io.ktor.http.*

object MainScraper : GenericScraper {
    override fun getSearchBooksList(query: Parameters): List<SearchBook> {
        return ReadNovelFullScraper.getSearchBooksList(query);
    }

    override fun getBook(query: Parameters): Book {
        return ReadNovelFullScraper.getBook(query)
    }

    override fun getChapter(query: Parameters): Chapter {
        return ReadNovelFullScraper.getChapter(query)
    }
}
