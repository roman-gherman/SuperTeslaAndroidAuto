package com.supertesla.aa.network.webserver

import io.ktor.websocket.DefaultWebSocketSession
import io.ktor.websocket.Frame
import kotlinx.coroutines.flow.Flow
import timber.log.Timber
import java.io.ByteArrayOutputStream
import java.util.concurrent.ConcurrentHashMap

/**
 * Streams encoded audio (AAC) to connected WebSocket clients as separate
 * binary messages. The browser decodes using Web Audio API or AudioContext.
 *
 * Audio is sent as binary WebSocket frames with a 1-byte header:
 *   Byte 0: 0x01 = audio data, 0x02 = audio config (AudioSpecificConfig)
 *   Remaining: raw AAC frame data
 */
class AudioStreamHandler {

    private val clients = ConcurrentHashMap<String, DefaultWebSocketSession>()
    private var audioSpecificConfig: ByteArray? = null

    fun setAudioConfig(config: ByteArray) {
        audioSpecificConfig = config
    }

    suspend fun sendAudioFrame(aacData: ByteArray) {
        if (clients.isEmpty()) return

        // Prefix with audio marker byte
        val frame = ByteArray(1 + aacData.size)
        frame[0] = 0x01 // audio data marker
        System.arraycopy(aacData, 0, frame, 1, aacData.size)

        val deadClients = mutableListOf<String>()
        for ((id, session) in clients) {
            try {
                session.send(Frame.Binary(true, frame))
            } catch (e: Exception) {
                deadClients.add(id)
            }
        }
        deadClients.forEach { clients.remove(it) }
    }

    fun addClient(id: String, session: DefaultWebSocketSession) {
        clients[id] = session
        Timber.d("Audio client added: $id (total: ${clients.size})")
    }

    fun removeClient(id: String) {
        clients.remove(id)
        Timber.d("Audio client removed: $id (total: ${clients.size})")
    }

    val connectedClients: Int get() = clients.size
}
