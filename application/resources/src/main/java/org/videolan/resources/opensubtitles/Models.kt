package org.videolan.resources.opensubtitles
import com.squareup.moshi.Json

data class QueryParameters(
        @field:Json(name = "query") val query: String,
        @field:Json(name = "episode") val episode: String,
        @field:Json(name = "season") val season: String
)

data class OpenSubV1(
        @field:Json(name = "data")
        val `data`: List<Data>,
        @field:Json(name = "page")
        val page: Int,
        @field:Json(name = "per_page")
        val perPage: Int,
        @field:Json(name = "total_count")
        val totalCount: Int,
        @field:Json(name = "total_pages")
        val totalPages: Int
)

data class Data(
        @field:Json(name = "attributes")
        val attributes: Attributes,
        @field:Json(name = "id")
        val id: String,
        @field:Json(name = "type")
        val type: String
)

data class Attributes(
        @field:Json(name = "ai_translated")
        val aiTranslated: Boolean,
        @field:Json(name = "comments")
        val comments: String,
        @field:Json(name = "download_count")
        val downloadCount: Long,
        @field:Json(name = "feature_details")
        val featureDetails: FeatureDetails,
        @field:Json(name = "files")
        val files: List<File>,
        @field:Json(name = "foreign_parts_only")
        val foreignPartsOnly: Boolean,
        @field:Json(name = "fps")
        val fps: Double,
        @field:Json(name = "from_trusted")
        val fromTrusted: Boolean,
        @field:Json(name = "hd")
        val hd: Boolean,
        @field:Json(name = "hearing_impaired")
        val hearingImpaired: Boolean,
        @field:Json(name = "language")
        val language: String,
        @field:Json(name = "legacy_subtitle_id")
        val legacySubtitleId: Int,
        @field:Json(name = "legacy_uploader_id")
        val legacyUploaderId: Int,
        @field:Json(name = "machine_translated")
        val machineTranslated: Boolean,
        @field:Json(name = "moviehash_match")
        val moviehashMatch: Boolean,
        @field:Json(name = "nb_cd")
        val nbCd: Int,
        @field:Json(name = "new_download_count")
        val newDownloadCount: Int,
        @field:Json(name = "ratings")
        val ratings: Int,
        @field:Json(name = "related_links")
        val relatedLinks: List<RelatedLink>,
        @field:Json(name = "release")
        val release: String,
        @field:Json(name = "slug")
        val slug: String,
        @field:Json(name = "subtitle_id")
        val subtitleId: String,
        @field:Json(name = "upload_date")
        val uploadDate: String,
        @field:Json(name = "uploader")
        val uploader: Uploader,
        @field:Json(name = "url")
        val url: String,
        @field:Json(name = "votes")
        val votes: Int
)

data class FeatureDetails(
        @field:Json(name = "episode_number")
        val episodeNumber: Int,
        @field:Json(name = "feature_id")
        val featureId: Int,
        @field:Json(name = "feature_type")
        val featureType: String,
        @field:Json(name = "imdb_id")
        val imdbId: Int,
        @field:Json(name = "movie_name")
        val movieName: String,
        @field:Json(name = "parent_feature_id")
        val parentFeatureId: Int,
        @field:Json(name = "parent_imdb_id")
        val parentImdbId: Int,
        @field:Json(name = "parent_title")
        val parentTitle: String,
        @field:Json(name = "parent_tmdb_id")
        val parentTmdbId: Int,
        @field:Json(name = "season_number")
        val seasonNumber: Int,
        @field:Json(name = "title")
        val title: String,
        @field:Json(name = "tmdb_id")
        val tmdbId: Int? = null,
        @field:Json(name = "year")
        val year: Int
)

data class File(
        @field:Json(name = "cd_number")
        val cdNumber: Int,
        @field:Json(name = "file_id")
        val fileId: Int,
        @field:Json(name = "file_name")
        val fileName: String
)

data class RelatedLink(
        @field:Json(name = "img_url")
        val imgUrl: String,
        @field:Json(name = "label")
        val label: String,
        @field:Json(name = "url")
        val url: String
)

data class Uploader(
        @field:Json(name = "name")
        val name: String,
        @field:Json(name = "rank")
        val rank: String,
        @field:Json(name = "uploader_id")
        val uploaderId: Int? = null
)

