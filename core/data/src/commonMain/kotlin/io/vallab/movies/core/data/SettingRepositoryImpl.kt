package io.vallab.movies.core.data

import io.vallab.movies.core.datastore.setting.SettingPreferenceDataSource
import kotlinx.coroutines.flow.Flow

class SettingRepositoryImpl(
    private val dataStore: SettingPreferenceDataSource,
) : SettingRepository {

    override fun isDarkTheme(): Flow<Boolean> = dataStore.isDarkTheme

    override suspend fun updateIsDarkTheme(isDarkTheme: Boolean) {
        dataStore.updateIsDarkTheme(isDarkTheme)
    }

}
