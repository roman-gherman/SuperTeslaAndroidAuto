package com.supertesla.aa.streaming.capture

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.hardware.display.DisplayManager
import android.hardware.display.VirtualDisplay
import android.media.MediaCodec
import android.media.MediaCodecInfo
import android.media.MediaFormat
import android.media.projection.MediaProjection
import android.media.projection.MediaProjectionManager
import android.os.Handler
import android.os.HandlerThread
import android.view.Surface
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import timber.log.Timber

/**
 * Captures the phone screen via MediaProjection and encodes it as H.264.
 * This is how Taada works - captures the Android Auto UI displayed on screen
 * and streams it to Tesla's browser.
 *
 * Flow: Screen → MediaProjection → VirtualDisplay → Surface → MediaCodec (H.264) → SharedFlow
 */
class ScreenCaptureManager(
    private val width: Int = 1280,
    private val height: Int = 720,
    private val dpi: Int = 160,
    private val fps: Int = 30,
    private val bitrate: Int = 4_000_000 // 4 Mbps
) {
    private var mediaProjection: MediaProjection? = null
    private var virtualDisplay: VirtualDisplay? = null
    private var encoder: MediaCodec? = null
    private var encoderSurface: Surface? = null
    private var running = false
    private var encoderThread: HandlerThread? = null
    private var encoderHandler: Handler? = null

    private val _videoFrames = MutableSharedFlow<ByteArray>(
        replay = 0,
        extraBufferCapacity = 30
    )
    val videoFrames: SharedFlow<ByteArray> = _videoFrames

    val isCapturing: Boolean get() = running

    /**
     * Get the intent to request screen capture permission.
     * Call this from an Activity and handle the result.
     */
    fun getPermissionIntent(context: Context): Intent {
        val projectionManager = context.getSystemService(Context.MEDIA_PROJECTION_SERVICE) as MediaProjectionManager
        return projectionManager.createScreenCaptureIntent()
    }

    /**
     * Start capturing screen with the permission result.
     * @param resultCode Activity.RESULT_OK from the permission dialog
     * @param data The intent data from the permission result
     */
    fun startCapture(context: Context, resultCode: Int, data: Intent) {
        if (running) {
            Timber.w("Already capturing")
            return
        }

        val projectionManager = context.getSystemService(Context.MEDIA_PROJECTION_SERVICE) as MediaProjectionManager
        mediaProjection = projectionManager.getMediaProjection(resultCode, data)

        if (mediaProjection == null) {
            Timber.e("Failed to get MediaProjection")
            return
        }

        mediaProjection!!.registerCallback(object : MediaProjection.Callback() {
            override fun onStop() {
                Timber.w("MediaProjection stopped")
                stopCapture()
            }
        }, null)

        setupEncoder()
        setupVirtualDisplay()
        startEncoderOutput()
        running = true

        Timber.i("Screen capture started: ${width}x${height}@${fps}fps, ${bitrate / 1000}kbps")
    }

    private fun setupEncoder() {
        val format = MediaFormat.createVideoFormat(MediaFormat.MIMETYPE_VIDEO_AVC, width, height).apply {
            setInteger(MediaFormat.KEY_COLOR_FORMAT, MediaCodecInfo.CodecCapabilities.COLOR_FormatSurface)
            setInteger(MediaFormat.KEY_BIT_RATE, bitrate)
            setInteger(MediaFormat.KEY_FRAME_RATE, fps)
            setInteger(MediaFormat.KEY_I_FRAME_INTERVAL, 2) // keyframe every 2 seconds
            setInteger(MediaFormat.KEY_PROFILE, MediaCodecInfo.CodecProfileLevel.AVCProfileBaseline)
            setInteger(MediaFormat.KEY_LEVEL, MediaCodecInfo.CodecProfileLevel.AVCLevel31)
        }

        encoder = MediaCodec.createEncoderByType(MediaFormat.MIMETYPE_VIDEO_AVC)
        encoder!!.configure(format, null, null, MediaCodec.CONFIGURE_FLAG_ENCODE)
        encoderSurface = encoder!!.createInputSurface()
        encoder!!.start()

        Timber.d("H.264 encoder configured: ${width}x${height}")
    }

    private fun setupVirtualDisplay() {
        virtualDisplay = mediaProjection!!.createVirtualDisplay(
            "SuperTeslaCapture",
            width, height, dpi,
            DisplayManager.VIRTUAL_DISPLAY_FLAG_AUTO_MIRROR,
            encoderSurface,
            null, null
        )
        Timber.d("VirtualDisplay created")
    }

    private fun startEncoderOutput() {
        encoderThread = HandlerThread("ScreenEncoder").apply { start() }
        encoderHandler = Handler(encoderThread!!.looper)

        encoderHandler!!.post {
            val bufferInfo = MediaCodec.BufferInfo()
            val codec = encoder ?: return@post

            while (running) {
                try {
                    val outputIndex = codec.dequeueOutputBuffer(bufferInfo, 10000) // 10ms timeout
                    if (outputIndex >= 0) {
                        val outputBuffer = codec.getOutputBuffer(outputIndex)
                        if (outputBuffer != null && bufferInfo.size > 0) {
                            // Skip codec config frames (SPS/PPS sent separately)
                            if (bufferInfo.flags and MediaCodec.BUFFER_FLAG_CODEC_CONFIG != 0) {
                                // This is SPS/PPS - emit it (needed by fMP4 muxer)
                                val data = ByteArray(bufferInfo.size)
                                outputBuffer.position(bufferInfo.offset)
                                outputBuffer.get(data)
                                _videoFrames.tryEmit(data)
                            } else {
                                // Regular frame data
                                val data = ByteArray(bufferInfo.size)
                                outputBuffer.position(bufferInfo.offset)
                                outputBuffer.get(data)
                                _videoFrames.tryEmit(data)
                            }
                        }
                        codec.releaseOutputBuffer(outputIndex, false)
                    }
                } catch (e: Exception) {
                    if (running) Timber.w("Encoder output error: ${e.message}")
                    break
                }
            }
            Timber.d("Encoder output loop ended")
        }
    }

    fun stopCapture() {
        running = false

        try { virtualDisplay?.release() } catch (_: Exception) {}
        virtualDisplay = null

        try { encoderSurface?.release() } catch (_: Exception) {}
        encoderSurface = null

        try {
            encoder?.stop()
            encoder?.release()
        } catch (_: Exception) {}
        encoder = null

        try { mediaProjection?.stop() } catch (_: Exception) {}
        mediaProjection = null

        encoderThread?.quitSafely()
        encoderThread = null
        encoderHandler = null

        Timber.i("Screen capture stopped")
    }

    /**
     * Request a keyframe (IDR frame) from the encoder.
     * Useful when a new browser client connects.
     */
    fun requestKeyframe() {
        try {
            val params = android.os.Bundle()
            params.putInt(MediaCodec.PARAMETER_KEY_REQUEST_SYNC_FRAME, 0)
            encoder?.setParameters(params)
        } catch (_: Exception) {}
    }
}
