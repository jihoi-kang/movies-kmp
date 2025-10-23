package io.vallab.movies.core.datastore

import org.koin.dsl.module

internal actual val pathProviderModule = module {
    single { PathProvider(get()) }
}
