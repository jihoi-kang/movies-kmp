package io.vallab.movies.core.network.api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.vallab.movies.core.network.response.GetGenresResponse
import io.vallab.movies.core.network.response.GetMoviesResponse
import io.vallab.movies.core.network.response.GetVideosResponse

class MovieApi(
    private val client: HttpClient,
) {

    suspend fun getMovies(
        sortBy: String,
        page: Int,
        today: String,
    ): GetMoviesResponse {
        return client.get("/3/discover/movie") {
            url {
                parameters.append("sort_by", sortBy)
                parameters.append("page", page.toString())
                parameters.append("release_date.lte", today)
            }
        }
            .body<GetMoviesResponse>()
    }

    suspend fun getGenres(): GetGenresResponse {
        return client.get("/3/genre/movie/list")
            .body<GetGenresResponse>()
    }

    suspend fun getVideos(movieId: Int): GetVideosResponse {
        return client.get("/3/movie/${movieId}/videos")
            .body<GetVideosResponse>()
    }

}
