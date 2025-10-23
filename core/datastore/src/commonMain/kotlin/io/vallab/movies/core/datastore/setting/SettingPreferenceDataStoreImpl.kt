package io.vallab.movies.core.datastore.setting

import io.vallab.movies.core.datastore.preference.LocalPreferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class SettingPreferenceDataSourceImpl(
    private val localPreferences: LocalPreferences,
) : SettingPreferenceDataSource {

    override val isDarkTheme: Flow<Boolean> = localPreferences.getBoolean(KEY_IS_DARK_THEME)
        .map { it ?: false }

    override suspend fun updateIsDarkTheme(isDarkTheme: Boolean) {
        localPreferences.setBoolean(KEY_IS_DARK_THEME, isDarkTheme)
    }

    companion object {
        private const val KEY_IS_DARK_THEME = "IS_DARK_THEME"
    }
}
