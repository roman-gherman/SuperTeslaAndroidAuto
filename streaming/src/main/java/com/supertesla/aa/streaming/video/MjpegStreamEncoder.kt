package com.supertesla.aa.streaming.video

import android.graphics.ImageFormat
import android.graphics.Rect
import android.graphics.YuvImage
import android.media.MediaCodec
import android.media.MediaFormat
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import java.io.ByteArrayOutputStream

/**
 * MJPEG fallback encoder: decodes H.264 via MediaCodec, encodes each frame as JPEG.
 * Used when the browser doesn't support MSE/H.264.
 */
class MjpegStreamEncoder(
    private val width: Int,
    private val height: Int,
    private val quality: Int = 60,
    private val maxFps: Int = 20
) {
    private var decoder: MediaCodec? = null
    private val nalParser = NalUnitParser()
    private var configured = false
    private val frameInterval = 1000L / maxFps

    /**
     * Start producing JPEG frames from an H.264 video flow.
     * Each emitted ByteArray is a complete JPEG image.
     */
    fun start(videoFlow: Flow<ByteArray>): Flow<ByteArray> = flow {
        var lastFrameTime = 0L

        try {
            videoFlow.collect { rawH264 ->
                val now = System.currentTimeMillis()
                if (now - lastFrameTime < frameInterval) return@collect

                // Collect JPEG results from NAL parsing (can't emit inside non-suspend lambda)
                val jpegResults = mutableListOf<ByteArray>()
                nalParser.feed(rawH264) { nalUnit ->
                    when (nalUnit.type) {
                        NalUnitParser.NalType.SPS, NalUnitParser.NalType.PPS -> {
                            if (!configured && nalParser.hasSpsAndPps) {
                                configureDecoder()
                            }
                        }
                        NalUnitParser.NalType.SLICE_IDR, NalUnitParser.NalType.SLICE_NON_IDR -> {
                            if (!configured && nalParser.hasSpsAndPps) {
                                configureDecoder()
                            }
                            if (configured) {
                                val jpeg = decodeAndEncode(nalUnit)
                                if (jpeg != null) {
                                    jpegResults.add(jpeg)
                                }
                            }
                        }
                        else -> {}
                    }
                }
                // Emit collected JPEGs
                for (jpeg in jpegResults) {
                    lastFrameTime = System.currentTimeMillis()
                    emit(jpeg)
                }
            }
        } finally {
            releaseDecoder()
        }
    }

    private fun configureDecoder() {
        try {
            val sps = nalParser.cachedSps ?: return
            val pps = nalParser.cachedPps ?: return

            val format = MediaFormat.createVideoFormat(MediaFormat.MIMETYPE_VIDEO_AVC, width, height)
            format.setByteBuffer("csd-0", java.nio.ByteBuffer.wrap(sps))
            format.setByteBuffer("csd-1", java.nio.ByteBuffer.wrap(pps))
            format.setInteger(MediaFormat.KEY_COLOR_FORMAT,
                android.media.MediaCodecInfo.CodecCapabilities.COLOR_FormatYUV420Flexible)

            decoder = MediaCodec.createDecoderByType(MediaFormat.MIMETYPE_VIDEO_AVC)
            decoder?.configure(format, null, null, 0)
            decoder?.start()
            configured = true
            Timber.i("MJPEG decoder configured: ${width}x${height}")
        } catch (e: Exception) {
            Timber.e(e, "Failed to configure MJPEG decoder")
            configured = false
        }
    }

    private fun decodeAndEncode(nalUnit: NalUnitParser.NalUnit): ByteArray? {
        val codec = decoder ?: return null

        try {
            // Feed NAL unit to decoder
            val inputIndex = codec.dequeueInputBuffer(10000) // 10ms timeout
            if (inputIndex >= 0) {
                val inputBuffer = codec.getInputBuffer(inputIndex) ?: return null
                val nalData = nalUnit.dataWithoutStartCode
                inputBuffer.clear()
                inputBuffer.put(nalData)
                codec.queueInputBuffer(inputIndex, 0, nalData.size, 0, 0)
            }

            // Get decoded output
            val info = MediaCodec.BufferInfo()
            val outputIndex = codec.dequeueOutputBuffer(info, 10000)
            if (outputIndex >= 0) {
                val outputBuffer = codec.getOutputBuffer(outputIndex)
                if (outputBuffer != null && info.size > 0) {
                    val yuvData = ByteArray(info.size)
                    outputBuffer.get(yuvData)
                    codec.releaseOutputBuffer(outputIndex, false)

                    // Convert YUV to JPEG
                    return yuvToJpeg(yuvData, width, height, quality)
                }
                codec.releaseOutputBuffer(outputIndex, false)
            }
        } catch (e: Exception) {
            Timber.w("MJPEG decode/encode error: ${e.message}")
        }

        return null
    }

    private fun yuvToJpeg(yuvData: ByteArray, width: Int, height: Int, quality: Int): ByteArray {
        val yuvImage = YuvImage(yuvData, ImageFormat.NV21, width, height, null)
        val out = ByteArrayOutputStream()
        yuvImage.compressToJpeg(Rect(0, 0, width, height), quality, out)
        return out.toByteArray()
    }

    private fun releaseDecoder() {
        try {
            decoder?.stop()
            decoder?.release()
        } catch (_: Exception) {}
        decoder = null
        configured = false
    }

    fun stop() {
        releaseDecoder()
    }
}
