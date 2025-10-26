package io.vallab.movies.feature.main.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import io.vallab.movies.core.navigation.Route
import io.vallab.movies.feature.detail.detailNavGraph
import io.vallab.movies.feature.home.homeNavGraph
import io.vallab.movies.feature.main.Navigator
import io.vallab.movies.feature.main.route
import io.vallab.movies.feature.setting.settingNavGraph

@Composable
fun MainNavHost(
    modifier: Modifier = Modifier,
    navigator: Navigator,
) {
    NavHost(
        modifier = modifier.fillMaxSize(),
        navController = navigator.navController,
        startDestination = navigator.initTab.route(),
    ) {
        homeNavGraph(
            onClickDetail = { movieId -> navigator.navigate(Route.Detail(movieId)) },
        )
        settingNavGraph()
        detailNavGraph()
    }
}
