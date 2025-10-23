package io.vallab.movies.core.network

import org.koin.core.module.Module
import org.koin.dsl.module

internal actual val httpClientProviderModule: Module = module {
    single { HttpClientProvider() }
}
