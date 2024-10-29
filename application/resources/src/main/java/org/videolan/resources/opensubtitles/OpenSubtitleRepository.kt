package org.videolan.resources.opensubtitles

class OpenSubtitleRepository(private val openSubtitleService: IOpenSubtitleService) {

    /*
    Multiple query functions are created based on below rules:
        1) Tags are valid only with imdbid
        2) We should use moviehash and moviebytesize together
        3) precedence: (movieBytesize and moviehash) > imdbid > name
    */


    suspend fun queryWithHash(
        movieByteSize: Long,
        movieHash: String?,
        languageIds: List<String>?,
        hearingImpaired: Boolean
    ): OpenSubV1 {
        val actualLanguageIds =
            languageIds?.toSet()?.run { if (contains("") || isEmpty()) setOf("") else this }
                ?: setOf("")
        return openSubtitleService.query(
            movieHash = movieHash ?: "",
            languageId = actualLanguageIds.sorted().joinToString(","),
            hearingImpaired = if (hearingImpaired) "only" else "include"
        )
    }

    suspend fun queryWithName(name: String, episode: Int?, season: Int?, languageIds: List<String>?, hearingImpaired: Boolean): OpenSubV1 {
        val actualEpisode = episode ?: 0
        val actualSeason = season ?: 0
        val actualLanguageIds = languageIds?.toSet()?.run { if (contains("") || isEmpty()) setOf("") else this } ?: setOf("")
        return openSubtitleService.query(
            name = name,
            episode = actualEpisode,
            season = actualSeason,
            languageId = actualLanguageIds.sorted().joinToString(","),
            hearingImpaired = if (hearingImpaired) "only" else "include"
        )

    }

    suspend fun getDownloadLink(fileId: Long): DownloadLink {
        val query =  openSubtitleService.queryDownloadUrl(DownloadLinkBody(fileId))
        return query.body() ?: throw Exception("No body")
    }

    companion object {
        // To ensure the instance can be overridden in tests.
        var instance = lazy { OpenSubtitleRepository(OpenSubtitleClient.instance) }
        fun getInstance() = instance.value
    }
}
