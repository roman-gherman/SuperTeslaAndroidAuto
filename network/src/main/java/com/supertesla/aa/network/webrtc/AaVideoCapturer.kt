package com.supertesla.aa.network.webrtc

import org.webrtc.*
import timber.log.Timber
import java.nio.ByteBuffer

/**
 * Custom VideoCapturer that feeds decoded video frames from Android Auto
 * into the WebRTC video pipeline.
 *
 * Frames are fed externally via [feedFrame] when AA delivers decoded video.
 * WebRTC then handles encoding (H.264/VP8) and transmission.
 */
class AaVideoCapturer : VideoCapturer {

    private var capturerObserver: CapturerObserver? = null
    private var surfaceTextureHelper: SurfaceTextureHelper? = null
    private var disposed = false

    override fun initialize(
        surfaceTextureHelper: SurfaceTextureHelper,
        context: android.content.Context,
        observer: CapturerObserver
    ) {
        this.surfaceTextureHelper = surfaceTextureHelper
        this.capturerObserver = observer
        Timber.d("AaVideoCapturer initialized")
    }

    override fun startCapture(width: Int, height: Int, framerate: Int) {
        Timber.d("AaVideoCapturer startCapture: ${width}x${height}@${framerate}")
    }

    override fun stopCapture() {
        Timber.d("AaVideoCapturer stopCapture")
    }

    override fun changeCaptureFormat(width: Int, height: Int, framerate: Int) {
        Timber.d("AaVideoCapturer changeCaptureFormat: ${width}x${height}@${framerate}")
    }

    override fun dispose() {
        disposed = true
        surfaceTextureHelper?.dispose()
        Timber.d("AaVideoCapturer disposed")
    }

    override fun isScreencast(): Boolean = true

    /**
     * Feed a raw NV21/I420 frame from the AA video decoder.
     * Called from the streaming pipeline when a decoded frame is available.
     */
    fun feedFrame(width: Int, height: Int, nv21Data: ByteArray, timestampNs: Long) {
        if (disposed) return
        val observer = capturerObserver ?: return

        try {
            val buffer = NV21Buffer(nv21Data, width, height, null)
            val frame = VideoFrame(buffer, 0, timestampNs)
            observer.onFrameCaptured(frame)
            frame.release()
        } catch (e: Exception) {
            Timber.v("feedFrame error: ${e.message}")
        }
    }
}
