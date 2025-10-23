package io.vallab.movies.core.data

import kotlinx.coroutines.flow.Flow

interface SettingRepository {

    fun isDarkTheme(): Flow<Boolean>

    suspend fun updateIsDarkTheme(isDarkTheme: Boolean)
}

