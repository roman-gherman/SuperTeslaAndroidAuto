package com.supertesla.aa.network.webrtc

import android.hardware.display.DisplayManager
import android.hardware.display.VirtualDisplay
import android.media.projection.MediaProjection
import android.view.Surface
import org.webrtc.*
import timber.log.Timber

/**
 * Custom VideoCapturer that captures the screen via a shared MediaProjection
 * and feeds frames into WebRTC's native encoding pipeline.
 *
 * Uses a second VirtualDisplay (from the same MediaProjection as ScreenCaptureManager)
 * rendering into WebRTC's SurfaceTextureHelper. The SurfaceTextureHelper automatically
 * converts SurfaceTexture frames into VideoFrames for the WebRTC encoder.
 *
 * This avoids double-encoding: screen → VirtualDisplay → SurfaceTexture → WebRTC HW encoder → network.
 */
class AaVideoCapturer : VideoCapturer {

    private var surfaceTextureHelper: SurfaceTextureHelper? = null
    private var capturerObserver: CapturerObserver? = null
    private var virtualDisplay: VirtualDisplay? = null
    private var mediaProjection: MediaProjection? = null
    private var disposed = false

    private var captureWidth = 0
    private var captureHeight = 0
    private var started = false

    override fun initialize(
        surfaceTextureHelper: SurfaceTextureHelper,
        context: android.content.Context,
        observer: CapturerObserver
    ) {
        this.surfaceTextureHelper = surfaceTextureHelper
        this.capturerObserver = observer
        Timber.d("AaVideoCapturer initialized")
    }

    fun setMediaProjection(projection: MediaProjection) {
        this.mediaProjection = projection
        Timber.i("AaVideoCapturer: MediaProjection stored (not creating VirtualDisplay)")
    }

    override fun startCapture(width: Int, height: Int, framerate: Int) {
        Timber.d("AaVideoCapturer startCapture: ${width}x${height}@${framerate}")
        captureWidth = width
        captureHeight = height
        started = true

        // NOTE: VirtualDisplay creation disabled for now.
        // Creating a second VirtualDisplay from the same MediaProjection causes
        // some devices (Oppo/OnePlus) to revoke the first one, killing the fMP4 encoder.
        // WebRTC will gracefully fail and browser falls back to MSE/fMP4 path.
        // TODO: Re-enable once we switch to a single-capture architecture.
        Timber.i("AaVideoCapturer: WebRTC capture deferred (using MSE/fMP4 path)")
        capturerObserver?.onCapturerStarted(true)
    }

    private fun createVirtualDisplay() {
        val mp = mediaProjection ?: return
        val sth = surfaceTextureHelper ?: return
        val w = if (captureWidth > 0) captureWidth else 1280
        val h = if (captureHeight > 0) captureHeight else 720

        val surface = Surface(sth.surfaceTexture)
        virtualDisplay = mp.createVirtualDisplay(
            "SuperTeslaWebRTC",
            w, h, 160,
            DisplayManager.VIRTUAL_DISPLAY_FLAG_AUTO_MIRROR,
            surface,
            null,
            null
        )
        capturerObserver?.onCapturerStarted(true)
        Timber.i("AaVideoCapturer: VirtualDisplay created (${w}x${h})")
    }

    override fun stopCapture() {
        Timber.d("AaVideoCapturer stopCapture")
        started = false
        virtualDisplay?.release()
        virtualDisplay = null
        surfaceTextureHelper?.stopListening()
        capturerObserver?.onCapturerStopped()
    }

    override fun changeCaptureFormat(width: Int, height: Int, framerate: Int) {
        Timber.d("AaVideoCapturer changeCaptureFormat: ${width}x${height}@${framerate}")
        captureWidth = width
        captureHeight = height
        // Recreate VirtualDisplay with new size
        if (started && mediaProjection != null) {
            virtualDisplay?.release()
            virtualDisplay = null
            createVirtualDisplay()
        }
    }

    override fun dispose() {
        disposed = true
        virtualDisplay?.release()
        virtualDisplay = null
        surfaceTextureHelper?.dispose()
        Timber.d("AaVideoCapturer disposed")
    }

    override fun isScreencast(): Boolean = true
}
