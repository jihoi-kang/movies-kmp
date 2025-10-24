package io.vallab.movies.core.navigation

import kotlinx.serialization.Serializable

sealed interface Route {
    @Serializable
    data object Home : Route
    @Serializable
    data object Setting : Route
    @Serializable
    data class Detail(val movieId: Int) : Route
}
