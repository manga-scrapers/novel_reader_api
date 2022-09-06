package io.github.p2kr.scrapers

import io.github.p2kr.models.Book
import io.github.p2kr.models.Chapter
import io.github.p2kr.models.SearchBook
import io.ktor.http.*

interface GenericScraper {
    fun getSearchBooksList(query: Parameters): List<SearchBook>
    fun getBook(query: Parameters): Book
    fun getChapter(query: Parameters): Chapter
}
