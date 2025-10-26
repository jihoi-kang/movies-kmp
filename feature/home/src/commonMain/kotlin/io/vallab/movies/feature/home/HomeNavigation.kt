package io.vallab.movies.feature.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import io.vallab.movies.core.navigation.MainTabRoute

fun NavGraphBuilder.homeNavGraph(onClickDetail: (Int) -> Unit) {
    composable<MainTabRoute.Home> {
        HomeScreen(onClickDetail = onClickDetail)
    }
}
