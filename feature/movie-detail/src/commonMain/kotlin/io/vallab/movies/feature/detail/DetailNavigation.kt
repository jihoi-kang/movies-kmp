package io.vallab.movies.feature.detail

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import io.vallab.movies.core.navigation.Route

fun NavGraphBuilder.detailNavGraph() {
    composable<Route.Detail> { navBackStackEntry ->
        val movieId = navBackStackEntry.toRoute<Route.Detail>().movieId
        DetailScreen(movieId = movieId)
    }
}
