package io.vallab.movies.feature.main.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import io.vallab.movies.core.navigation.Route
import io.vallab.movies.feature.detail.detailNavGraph
import io.vallab.movies.feature.home.homeNavGraph
import io.vallab.movies.feature.setting.settingNavGraph

@Composable
fun MainNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    NavHost(
        modifier = modifier.fillMaxSize(),
        navController = navController,
        startDestination = Route.Home,
    ) {
        homeNavGraph(
            onClickDetail = { movieId -> navController.navigate(Route.Detail(movieId)) }
        )
        settingNavGraph()
        detailNavGraph()
    }
}
