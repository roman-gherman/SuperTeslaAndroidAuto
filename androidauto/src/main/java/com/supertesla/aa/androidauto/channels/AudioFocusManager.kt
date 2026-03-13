package com.supertesla.aa.androidauto.channels

import timber.log.Timber

/**
 * Manages audio focus state across AA audio streams.
 * Tracks which streams are active and handles focus transitions.
 *
 * Priority: CALL > NAVIGATION > MEDIA > SYSTEM
 */
class AudioFocusManager {

    enum class AudioStreamType {
        MEDIA,
        NAVIGATION,
        CALL,
        SYSTEM
    }

    enum class FocusState {
        NONE,       // No focus
        GAIN,       // Full focus
        LOSS,       // Lost focus
        DUCK        // Ducked (lower volume)
    }

    data class StreamState(
        val type: AudioStreamType,
        var focus: FocusState = FocusState.NONE,
        var active: Boolean = false,
        var volume: Float = 1.0f
    )

    private val streams = mutableMapOf(
        AudioStreamType.MEDIA to StreamState(AudioStreamType.MEDIA),
        AudioStreamType.NAVIGATION to StreamState(AudioStreamType.NAVIGATION),
        AudioStreamType.CALL to StreamState(AudioStreamType.CALL),
        AudioStreamType.SYSTEM to StreamState(AudioStreamType.SYSTEM)
    )

    var onVolumeChange: ((AudioStreamType, Float) -> Unit)? = null

    /**
     * Handle an audio focus request from AA.
     * Returns the focus type to grant (1=gain, 2=gain_transient, 3=gain_transient_may_duck).
     */
    fun handleFocusRequest(requestType: Int, streamType: AudioStreamType = AudioStreamType.MEDIA): Int {
        Timber.d("AudioFocus: request type=$requestType for $streamType")

        when (streamType) {
            AudioStreamType.CALL -> {
                // Call gets full focus, everything else stops
                streams[AudioStreamType.MEDIA]?.apply { focus = FocusState.LOSS; volume = 0f }
                streams[AudioStreamType.NAVIGATION]?.apply { focus = FocusState.LOSS; volume = 0f }
                streams[AudioStreamType.CALL]?.apply { focus = FocusState.GAIN; volume = 1.0f; active = true }
                notifyVolumeChanges()
            }
            AudioStreamType.NAVIGATION -> {
                // Nav voice ducks media
                streams[AudioStreamType.MEDIA]?.apply { focus = FocusState.DUCK; volume = 0.3f }
                streams[AudioStreamType.NAVIGATION]?.apply { focus = FocusState.GAIN; volume = 1.0f; active = true }
                notifyVolumeChanges()
            }
            AudioStreamType.MEDIA -> {
                streams[AudioStreamType.MEDIA]?.apply { focus = FocusState.GAIN; volume = 1.0f; active = true }
                notifyVolumeChanges()
            }
            AudioStreamType.SYSTEM -> {
                // System sounds duck media slightly
                streams[AudioStreamType.MEDIA]?.apply {
                    if (focus == FocusState.GAIN) { focus = FocusState.DUCK; volume = 0.6f }
                }
                streams[AudioStreamType.SYSTEM]?.apply { focus = FocusState.GAIN; volume = 1.0f; active = true }
                notifyVolumeChanges()
            }
        }

        return 1 // AUDIOFOCUS_GAIN
    }

    /**
     * Handle audio focus abandon (stream done).
     */
    fun handleFocusAbandon(streamType: AudioStreamType) {
        Timber.d("AudioFocus: abandon for $streamType")
        streams[streamType]?.apply { focus = FocusState.NONE; active = false; volume = 0f }

        // Restore media if nav/call ended
        if (streamType == AudioStreamType.NAVIGATION || streamType == AudioStreamType.CALL) {
            streams[AudioStreamType.MEDIA]?.apply {
                if (active) { focus = FocusState.GAIN; volume = 1.0f }
            }
        }

        notifyVolumeChanges()
    }

    fun getVolume(streamType: AudioStreamType): Float {
        return streams[streamType]?.volume ?: 0f
    }

    fun isActive(streamType: AudioStreamType): Boolean {
        return streams[streamType]?.active ?: false
    }

    private fun notifyVolumeChanges() {
        for ((type, state) in streams) {
            onVolumeChange?.invoke(type, state.volume)
        }
    }
}
