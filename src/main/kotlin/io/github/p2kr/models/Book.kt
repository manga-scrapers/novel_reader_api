package io.github.p2kr.models

class Book {
    var name: String? = null
    var author: String? = null
    var thumbnailLink: String? = null
    var chaptersList: List<Chapter?>? = null
    var description: String? = null
    var rating: Float? = null
    var genres: List<String>? = null
    var bookLink: String? = null
    var status: String? = null

    //TODO: replace with datetime
    var lastChapterUpdateTime: String? = null
}
