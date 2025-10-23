package io.vallab.movies.core.datastore.setting

import kotlinx.coroutines.flow.Flow

internal const val SETTINGS_PREFERENCES_NAME = "vallab.settings.preferences_pb"

interface SettingPreferenceDataSource {

    val isDarkTheme: Flow<Boolean>

    suspend fun updateIsDarkTheme(isDarkTheme: Boolean)

}
