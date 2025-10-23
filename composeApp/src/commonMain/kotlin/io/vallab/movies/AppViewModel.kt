package io.vallab.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.vallab.movies.core.data.SettingRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

internal class AppViewModel(
    settingRepository: SettingRepository,
) : ViewModel() {

    val isDarkTheme = settingRepository
        .isDarkTheme()
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            false,
        )

}
