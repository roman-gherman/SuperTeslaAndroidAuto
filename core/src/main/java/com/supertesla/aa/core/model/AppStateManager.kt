package com.supertesla.aa.core.model

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import timber.log.Timber

class AppStateManager {

    private val _state = MutableStateFlow<AppState>(AppState.Idle)
    val state: StateFlow<AppState> = _state.asStateFlow()

    private val _hotspotState = MutableStateFlow<HotspotState>(HotspotState.Unknown)
    val hotspotState: StateFlow<HotspotState> = _hotspotState.asStateFlow()

    fun transition(newState: AppState) {
        val current = _state.value
        Timber.d("State transition: ${current::class.simpleName} -> ${newState::class.simpleName}")
        _state.value = newState
    }

    fun updateHotspotState(newState: HotspotState) {
        _hotspotState.value = newState
    }

    fun reset() {
        _state.value = AppState.Idle
        _hotspotState.value = HotspotState.Unknown
    }
}
