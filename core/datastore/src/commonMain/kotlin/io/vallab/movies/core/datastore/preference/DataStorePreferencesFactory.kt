package io.vallab.movies.core.datastore.preference

import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import io.vallab.movies.core.datastore.PathProvider

class DataStorePreferencesFactory(
    private val pathProvider: PathProvider,
) {

    fun create(fileName: String): DataStorePreferences {
        val dataStore = PreferenceDataStoreFactory.createWithPath { pathProvider.getPath(fileName) }
        return DataStorePreferences(dataStore)
    }
}
