package io.vallab.movies.core.data

import org.koin.dsl.module

val coreDataSettingModule = module {
    single<SettingRepository> { SettingRepositoryImpl(get()) }
}
