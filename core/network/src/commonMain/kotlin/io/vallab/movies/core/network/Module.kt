package io.vallab.movies.core.network

import io.vallab.movies.core.network.api.MovieApi
import org.koin.core.module.Module
import org.koin.dsl.module

internal expect val httpClientProviderModule: Module

private val coreNetworkModule = module {
    single { VallabNetworkFactory(get()).create() }
    single { MovieApi(get()) }
}

val coreNetworkModules: List<Module> = listOf(
    httpClientProviderModule,
    coreNetworkModule,
)
