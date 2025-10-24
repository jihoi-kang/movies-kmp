package io.vallab.movies.feature.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import io.vallab.movies.core.navigation.Route

fun NavGraphBuilder.homeNavGraph(onClickDetail: (Int) -> Unit) {
    composable<Route.Home> {
        HomeScreen(onClickDetail = onClickDetail)
    }
}
