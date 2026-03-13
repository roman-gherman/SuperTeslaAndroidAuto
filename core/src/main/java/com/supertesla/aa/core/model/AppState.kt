package com.supertesla.aa.core.model

sealed class AppState {
    data object Idle : AppState()
    data object StartingHotspot : AppState()
    data class HotspotReady(val ssid: String) : AppState()
    data object StartingVpn : AppState()
    data class VpnReady(val virtualIp: String) : AppState()
    data object StartingServer : AppState()
    data class ServerRunning(val url: String) : AppState()
    data object ConnectingAA : AppState()
    data object Streaming : AppState()
    data class Error(val message: String, val recoverable: Boolean = true) : AppState()

    val isRunning: Boolean
        get() = this !is Idle && this !is Error
}

sealed class HotspotState {
    data object Unknown : HotspotState()
    data object Disabled : HotspotState()
    data object Enabled : HotspotState()
    data class ClientConnected(val clients: List<ConnectedClient>) : HotspotState()
}

data class ConnectedClient(
    val ipAddress: String,
    val macAddress: String
)
