package io.vallab.movies.core.navigation

import kotlinx.serialization.Serializable

sealed interface Route {
    @Serializable
    data class Detail(val movieId: Int) : Route
}

sealed interface MainTabRoute : Route {
    @Serializable
    data object Home : MainTabRoute

    @Serializable
    data object Setting : MainTabRoute
}
