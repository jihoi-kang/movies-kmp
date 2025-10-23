package io.vallab.movies.core.network.response

import kotlinx.serialization.Serializable

@Serializable
data class GetVideosResponse(
    val id: Int,
    val videos: List<Video> = emptyList(),
) {
    @Serializable
    data class Video(
        val id: String,
        val name: String,
        val site: String,
        val key: String,
        val size: Int,
        val type: String,
    )
}
