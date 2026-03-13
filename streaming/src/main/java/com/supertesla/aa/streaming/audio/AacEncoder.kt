package com.supertesla.aa.streaming.audio

import android.media.MediaCodec
import android.media.MediaCodecInfo
import android.media.MediaFormat
import timber.log.Timber
import java.nio.ByteBuffer
import java.util.concurrent.LinkedBlockingQueue

/**
 * Encodes raw PCM audio to AAC-LC using hardware MediaCodec.
 * Produces AAC frames suitable for muxing into fMP4 or direct WebSocket streaming.
 */
class AacEncoder(
    private val sampleRate: Int = 48000,
    private val channelCount: Int = 2,
    private val bitRate: Int = 128_000
) {
    private var codec: MediaCodec? = null
    private val pcmQueue = LinkedBlockingQueue<PcmChunk>(64)
    private var running = false
    private var presentationTimeUs = 0L

    /** AudioSpecificConfig bytes extracted from the encoder - needed for fMP4 esds box */
    var audioSpecificConfig: ByteArray? = null
        private set

    var onEncodedFrame: ((EncodedAudioFrame) -> Unit)? = null

    data class EncodedAudioFrame(
        val data: ByteArray,
        val timestamp: Long,
        val isConfig: Boolean
    ) {
        override fun equals(other: Any?) = this === other
        override fun hashCode() = data.contentHashCode()
    }

    private data class PcmChunk(val data: ByteArray, val timestamp: Long)

    fun start() {
        if (running) return

        val format = MediaFormat.createAudioFormat(
            MediaFormat.MIMETYPE_AUDIO_AAC,
            sampleRate,
            channelCount
        ).apply {
            setInteger(MediaFormat.KEY_BIT_RATE, bitRate)
            setInteger(MediaFormat.KEY_AAC_PROFILE, MediaCodecInfo.CodecProfileLevel.AACObjectLC)
            setInteger(MediaFormat.KEY_MAX_INPUT_SIZE, 16384)
        }

        try {
            codec = MediaCodec.createEncoderByType(MediaFormat.MIMETYPE_AUDIO_AAC)
            codec!!.configure(format, null, null, MediaCodec.CONFIGURE_FLAG_ENCODE)
            codec!!.start()
            running = true
            Timber.i("AAC encoder started: ${sampleRate}Hz, ${channelCount}ch, ${bitRate / 1000}kbps")

            // Start encoding thread
            Thread({ encodingLoop() }, "AacEncoder").apply {
                isDaemon = true
                start()
            }
        } catch (e: Exception) {
            Timber.e(e, "Failed to start AAC encoder")
            release()
        }
    }

    /**
     * Feed raw PCM data for encoding.
     * PCM format: 16-bit signed little-endian, interleaved channels.
     */
    fun feedPcm(pcmData: ByteArray, timestamp: Long) {
        if (!running) return
        // Drop if queue is full (backpressure)
        if (!pcmQueue.offer(PcmChunk(pcmData, timestamp))) {
            Timber.v("AAC encoder: PCM queue full, dropping frame")
        }
    }

    private fun encodingLoop() {
        val mc = codec ?: return

        try {
            while (running) {
                // Feed input
                val chunk = pcmQueue.poll(50, java.util.concurrent.TimeUnit.MILLISECONDS)
                if (chunk != null) {
                    val inputIndex = mc.dequeueInputBuffer(10000)
                    if (inputIndex >= 0) {
                        val inputBuffer = mc.getInputBuffer(inputIndex) ?: continue
                        inputBuffer.clear()
                        val bytesToWrite = minOf(chunk.data.size, inputBuffer.remaining())
                        inputBuffer.put(chunk.data, 0, bytesToWrite)
                        mc.queueInputBuffer(inputIndex, 0, bytesToWrite, presentationTimeUs, 0)
                        // Advance timestamp based on sample count
                        val sampleCount = bytesToWrite / (2 * channelCount) // 16-bit = 2 bytes per sample
                        presentationTimeUs += (sampleCount * 1_000_000L) / sampleRate
                    }
                }

                // Drain output
                val info = MediaCodec.BufferInfo()
                while (true) {
                    val outputIndex = mc.dequeueOutputBuffer(info, 0)
                    if (outputIndex < 0) break

                    val outputBuffer = mc.getOutputBuffer(outputIndex)
                    if (outputBuffer != null && info.size > 0) {
                        val isConfig = info.flags and MediaCodec.BUFFER_FLAG_CODEC_CONFIG != 0

                        val data = ByteArray(info.size)
                        outputBuffer.position(info.offset)
                        outputBuffer.get(data)

                        if (isConfig) {
                            audioSpecificConfig = data.clone()
                            Timber.d("AAC AudioSpecificConfig: ${data.size} bytes")
                        }

                        onEncodedFrame?.invoke(
                            EncodedAudioFrame(data, info.presentationTimeUs, isConfig)
                        )
                    }
                    mc.releaseOutputBuffer(outputIndex, false)
                }
            }
        } catch (e: InterruptedException) {
            // Normal shutdown
        } catch (e: Exception) {
            Timber.w(e, "AAC encoding loop error")
        }

        Timber.d("AAC encoding loop ended")
    }

    fun stop() {
        running = false
        pcmQueue.clear()
    }

    fun release() {
        stop()
        try {
            codec?.stop()
            codec?.release()
        } catch (_: Exception) {}
        codec = null
    }
}
