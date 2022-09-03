package io.github.p2kr.models

import com.google.gson.annotations.SerializedName

class SearchBook {
    var name: String? = null

    @SerializedName("book_link")
    var bookLink: String? = null

    @SerializedName("thumbnail_link")
    var thumbnailLink: String? = null

    @SerializedName("latest_chapter_info")
    var latestChapterInfo: String? = null
    var author: String? = null
}
