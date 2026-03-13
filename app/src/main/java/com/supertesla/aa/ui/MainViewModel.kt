package com.supertesla.aa.ui

import androidx.lifecycle.ViewModel
import com.supertesla.aa.core.model.AppState
import com.supertesla.aa.core.model.AppStateManager
import com.supertesla.aa.core.model.HotspotState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val appStateManager: AppStateManager
) : ViewModel() {

    val appState: StateFlow<AppState> = appStateManager.state
    val hotspotState: StateFlow<HotspotState> = appStateManager.hotspotState
}
