package io.vallab.movies.core.datastore

import io.vallab.movies.core.datastore.preference.DataStorePreferencesFactory
import io.vallab.movies.core.datastore.preference.LocalPreferences
import io.vallab.movies.core.datastore.setting.SETTINGS_PREFERENCES_NAME
import io.vallab.movies.core.datastore.setting.SettingPreferenceDataSource
import io.vallab.movies.core.datastore.setting.SettingPreferenceDataSourceImpl
import org.koin.core.module.Module
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module

internal expect val pathProviderModule: Module

private val coreDatastoreCoreModule = module {
    single { DataStorePreferencesFactory(get()) }
    factory<LocalPreferences> { (fileName: String) ->
        get<DataStorePreferencesFactory>().create(fileName)
    }
}

private val dataStoreModule = module {
    single<SettingPreferenceDataSource> {
        SettingPreferenceDataSourceImpl(get<LocalPreferences> { parametersOf(SETTINGS_PREFERENCES_NAME) })
    }
}

val coreDatastoreCoreModules: List<Module> = listOf(
    coreDatastoreCoreModule,
    pathProviderModule,
    dataStoreModule,
)
