package io.vallab.movies

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import io.vallab.movies.core.data.coreDataSettingModule
import io.vallab.movies.core.datastore.coreDatastoreCoreModules
import io.vallab.movies.core.designsystem.theme.VallabTheme
import io.vallab.movies.core.network.coreNetworkModules
import movies.composeapp.generated.resources.NotoSans
import movies.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.Font
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.KoinApplication
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

@Composable
internal fun App(
    viewModel: AppViewModel = koinViewModel(),
    onDarkThemeChange: ((Boolean) -> Unit)? = null,
    fontFamily: FontFamily = FontFamily(Font(resource = Res.font.NotoSans)),
) {
    val isDarkTheme by viewModel.isDarkTheme.collectAsStateWithLifecycle()

    LaunchedEffect(isDarkTheme) {
        onDarkThemeChange?.invoke(isDarkTheme)
    }

    VallabTheme(
        darkTheme = isDarkTheme,
        fontFamily = fontFamily,
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
                .background(VallabTheme.colorScheme.background),
        )
    }
}

internal val appModule = module {
    // core: datastore
    includes(coreDatastoreCoreModules)

    // core: data
    includes(coreDataSettingModule)

    // core: network
    includes(coreNetworkModules)

    viewModelOf(::AppViewModel)
}

internal fun vallabAppDeclaration(
    additionalDeclaration: KoinApplication.() -> Unit = {},
): KoinAppDeclaration = {
    modules(appModule)
    additionalDeclaration()
}
