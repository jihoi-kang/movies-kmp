package io.vallab.movies.core.network.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetGenresResponse(
    @SerialName("genres")
    val genres: List<Genre> = emptyList(),
) {
    @Serializable
    data class Genre(
        @SerialName("id")
        val id: Int,
        @SerialName("name")
        val name: String,
    )
}
