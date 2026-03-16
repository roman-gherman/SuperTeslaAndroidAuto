package com.supertesla.aa.streaming.capture

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
import android.os.Looper
import android.util.Log
import android.view.Surface
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow

/**
 * Captures the phone screen via MediaProjection and encodes it as H.264.
 */
class ScreenCaptureManager(
    private val width: Int = 1280,
    private val height: Int = 720,
    private val dpi: Int = 160,
    private val fps: Int = 30,
    private val bitrate: Int = 4_000_000
) {
    private var mediaProjection: MediaProjection? = null
    private var virtualDisplay: VirtualDisplay? = null
    private var encoder: MediaCodec? = null
    private var encoderSurface: Surface? = null
    @Volatile
    private var running = false
    private var encoderThread: HandlerThread? = null

    private val _videoFrames = MutableSharedFlow<ByteArray>(
        replay = 0,
        extraBufferCapacity = 30
    )
    val videoFrames: SharedFlow<ByteArray> = _videoFrames

    val isCapturing: Boolean get() = running

    companion object {
        private const val TAG = "SuperTeslaCapture"
    }

    fun getPermissionIntent(context: Context): Intent {
        val mgr = context.getSystemService(Context.MEDIA_PROJECTION_SERVICE) as MediaProjectionManager
        return mgr.createScreenCaptureIntent()
    }

    fun startCapture(context: Context, resultCode: Int, data: Intent) {
        if (running) {
            Log.w(TAG, "Already capturing")
            return
        }

        Log.i(TAG, "startCapture: getting MediaProjection...")
        val mgr = context.getSystemService(Context.MEDIA_PROJECTION_SERVICE) as MediaProjectionManager

        try {
            mediaProjection = mgr.getMediaProjection(resultCode, data)
        } catch (e: Exception) {
            Log.e(TAG, "getMediaProjection failed: ${e.message}", e)
            return
        }

        if (mediaProjection == null) {
            Log.e(TAG, "MediaProjection is null - permission denied or invalid token")
            return
        }

        Log.i(TAG, "MediaProjection obtained successfully")

        val mainHandler = Handler(Looper.getMainLooper())
        mediaProjection!!.registerCallback(object : MediaProjection.Callback() {
            override fun onStop() {
                Log.w(TAG, "MediaProjection stopped by system")
                stopCapture()
            }
        }, mainHandler)

        try {
            setupEncoder()
            setupVirtualDisplay()
            running = true  // Set BEFORE starting encoder thread to avoid race
            startEncoderOutput()
            Log.i(TAG, "Screen capture STARTED: ${width}x${height}@${fps}fps")
        } catch (e: Exception) {
            Log.e(TAG, "Failed to start capture: ${e.message}", e)
            stopCapture()
        }
    }

    private fun setupEncoder() {
        val format = MediaFormat.createVideoFormat(MediaFormat.MIMETYPE_VIDEO_AVC, width, height).apply {
            setInteger(MediaFormat.KEY_COLOR_FORMAT, MediaCodecInfo.CodecCapabilities.COLOR_FormatSurface)
            setInteger(MediaFormat.KEY_BIT_RATE, bitrate)
            setInteger(MediaFormat.KEY_FRAME_RATE, fps)
            setInteger(MediaFormat.KEY_I_FRAME_INTERVAL, 2)
        }

        encoder = MediaCodec.createEncoderByType(MediaFormat.MIMETYPE_VIDEO_AVC)
        encoder!!.configure(format, null, null, MediaCodec.CONFIGURE_FLAG_ENCODE)
        encoderSurface = encoder!!.createInputSurface()
        encoder!!.start()
        Log.i(TAG, "Encoder started")
    }

    private fun setupVirtualDisplay() {
        virtualDisplay = mediaProjection!!.createVirtualDisplay(
            "SuperTeslaCapture",
            width, height, dpi,
            DisplayManager.VIRTUAL_DISPLAY_FLAG_AUTO_MIRROR,
            encoderSurface,
            object : VirtualDisplay.Callback() {
                override fun onPaused() { Log.d(TAG, "VirtualDisplay paused") }
                override fun onResumed() { Log.d(TAG, "VirtualDisplay resumed") }
                override fun onStopped() { Log.d(TAG, "VirtualDisplay stopped") }
            },
            Handler(Looper.getMainLooper())
        )
        Log.i(TAG, "VirtualDisplay created: ${width}x${height}")
    }

    private fun startEncoderOutput() {
        encoderThread = HandlerThread("ScreenEncoder").apply { start() }
        val handler = Handler(encoderThread!!.looper)

        handler.post {
            val bufferInfo = MediaCodec.BufferInfo()
            val codec = encoder ?: return@post
            var frameCount = 0L

            Log.i(TAG, "Encoder output loop started")

            while (running) {
                try {
                    val index = codec.dequeueOutputBuffer(bufferInfo, 10000)
                    if (index >= 0) {
                        val buf = codec.getOutputBuffer(index)
                        if (buf != null && bufferInfo.size > 0) {
                            val data = ByteArray(bufferInfo.size)
                            buf.position(bufferInfo.offset)
                            buf.get(data)

                            val emitted = _videoFrames.tryEmit(data)
                            frameCount++

                            if (frameCount == 1L) {
                                Log.i(TAG, "First frame emitted! size=${data.size} flags=${bufferInfo.flags}")
                            }
                            if (frameCount % 100 == 0L) {
                                Log.d(TAG, "Frames: $frameCount, last size=${data.size}, emitted=$emitted")
                            }
                        }
                        codec.releaseOutputBuffer(index, false)
                    } else if (index == MediaCodec.INFO_OUTPUT_FORMAT_CHANGED) {
                        Log.i(TAG, "Encoder output format changed: ${codec.outputFormat}")
                    }
                } catch (e: Exception) {
                    if (running) Log.w(TAG, "Encoder error: ${e.message}")
                    break
                }
            }
            Log.i(TAG, "Encoder output loop ended, total frames: $frameCount")
        }
    }

    fun stopCapture() {
        Log.i(TAG, "Stopping capture...")
        running = false

        try { virtualDisplay?.release() } catch (_: Exception) {}
        virtualDisplay = null

        try { encoderSurface?.release() } catch (_: Exception) {}
        encoderSurface = null

        try { encoder?.stop(); encoder?.release() } catch (_: Exception) {}
        encoder = null

        try { mediaProjection?.stop() } catch (_: Exception) {}
        mediaProjection = null

        encoderThread?.quitSafely()
        encoderThread = null

        Log.i(TAG, "Capture stopped")
    }

    fun requestKeyframe() {
        try {
            val params = android.os.Bundle()
            params.putInt(MediaCodec.PARAMETER_KEY_REQUEST_SYNC_FRAME, 0)
            encoder?.setParameters(params)
        } catch (_: Exception) {}
    }
}
