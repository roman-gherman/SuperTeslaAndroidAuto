package com.supertesla.aa.network.relay

import android.content.Context
import android.content.SharedPreferences
import timber.log.Timber
import java.net.HttpURLConnection
import java.net.URL
import java.security.SecureRandom

/**
 * Manages the relay room ID and session key.
 * Generates a permanent room code on first launch, stores in SharedPreferences.
 * Registers with the relay server and generates pairing codes.
 */
class RoomManager(private val context: Context) {

    private val prefs: SharedPreferences =
        context.getSharedPreferences("relay_prefs", Context.MODE_PRIVATE)

    val roomId: String get() = prefs.getString(PREF_ROOM_ID, null) ?: generateAndStore()
    val sessionKey: String get() = prefs.getString(PREF_SESSION_KEY, null) ?: generateAndStore().let { prefs.getString(PREF_SESSION_KEY, "")!! }

    private fun generateAndStore(): String {
        val room = generateRoomId()
        val key = generateSessionKey()
        prefs.edit()
            .putString(PREF_ROOM_ID, room)
            .putString(PREF_SESSION_KEY, key)
            .apply()
        Timber.i("RoomManager: generated room=$room")
        return room
    }

    /**
     * Register room with relay server. Call on first launch or when relay URL changes.
     * Returns true if registration succeeded.
     */
    fun registerWithRelay(relayApiUrl: String): Boolean {
        return try {
            val url = URL("$relayApiUrl/api/register")
            val conn = url.openConnection() as HttpURLConnection
            conn.requestMethod = "POST"
            conn.setRequestProperty("Content-Type", "application/json")
            conn.connectTimeout = 5000
            conn.readTimeout = 5000
            conn.doOutput = true
            conn.outputStream.write("""{"room":"$roomId","phoneKey":"$sessionKey"}""".toByteArray())
            val code = conn.responseCode
            conn.disconnect()
            if (code == 200) {
                Timber.i("RoomManager: registered room $roomId with relay")
                true
            } else {
                Timber.w("RoomManager: registration failed (HTTP $code)")
                false
            }
        } catch (e: Exception) {
            Timber.w(e, "RoomManager: registration failed")
            false
        }
    }

    /**
     * Generate a 4-digit pairing code via the relay. Returns the code or null.
     */
    fun createPairingCode(relayApiUrl: String): String? {
        return try {
            val url = URL("$relayApiUrl/api/pair/create")
            val conn = url.openConnection() as HttpURLConnection
            conn.requestMethod = "POST"
            conn.setRequestProperty("Content-Type", "application/json")
            conn.connectTimeout = 5000
            conn.readTimeout = 5000
            conn.doOutput = true
            conn.outputStream.write("""{"room":"$roomId","phoneKey":"$sessionKey"}""".toByteArray())
            val response = conn.inputStream.bufferedReader().readText()
            conn.disconnect()
            val code = org.json.JSONObject(response).getString("code")
            Timber.i("RoomManager: pairing code=$code for room=$roomId")
            code
        } catch (e: Exception) {
            Timber.w(e, "RoomManager: failed to create pairing code")
            null
        }
    }

    fun getPlayerUrl(playerBaseUrl: String): String {
        return "$playerBaseUrl/$roomId"
    }

    companion object {
        private const val PREF_ROOM_ID = "relay_room_id"
        private const val PREF_SESSION_KEY = "relay_session_key"

        private val random = SecureRandom()

        /** Generate a 4-char base36 room ID (a-z, 0-9 = 1.7M combinations) */
        fun generateRoomId(): String {
            val chars = "abcdefghijklmnopqrstuvwxyz0123456789"
            return (1..4).map { chars[random.nextInt(chars.length)] }.joinToString("")
        }

        /** Generate a 32-char hex session key (128-bit) */
        fun generateSessionKey(): String {
            val bytes = ByteArray(16)
            random.nextBytes(bytes)
            return bytes.joinToString("") { "%02x".format(it) }
        }
    }
}
