package com.supertesla.aa.network.webrtc

import android.content.Context
import com.supertesla.aa.network.websocket.TouchInputRelay
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.suspendCancellableCoroutine
import org.webrtc.*
import timber.log.Timber
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

/**
 * Manages WebRTC PeerConnection lifecycle, signaling, and media tracks.
 * Provides the lowest-latency streaming path for video and audio.
 */
class WebRtcManager(private val context: Context) {

    private var factory: PeerConnectionFactory? = null
    private var peerConnection: PeerConnection? = null
    private var eglBase: EglBase? = null
    private var videoSource: VideoSource? = null
    private var videoTrack: VideoTrack? = null
    private var audioSource: AudioSource? = null
    private var audioTrack: AudioTrack? = null
    private var dataChannel: DataChannel? = null

    private val localIceCandidates = mutableListOf<IceCandidate>()
    private var touchRelay: TouchInputRelay? = null
    private var videoCapturer: AaVideoCapturer? = null

    val isInitialized: Boolean get() = factory != null
    val isConnected: Boolean get() = peerConnection?.connectionState() == PeerConnection.PeerConnectionState.CONNECTED

    fun initialize() {
        Timber.i("Initializing WebRTC")

        eglBase = EglBase.create()

        PeerConnectionFactory.initialize(
            PeerConnectionFactory.InitializationOptions.builder(context)
                .setFieldTrials("WebRTC-H264HighProfile/Enabled/")
                .setEnableInternalTracer(false)
                .createInitializationOptions()
        )

        val encoderFactory = DefaultVideoEncoderFactory(
            eglBase!!.eglBaseContext, true, true
        )
        val decoderFactory = DefaultVideoDecoderFactory(eglBase!!.eglBaseContext)

        factory = PeerConnectionFactory.builder()
            .setVideoEncoderFactory(encoderFactory)
            .setVideoDecoderFactory(decoderFactory)
            .setOptions(PeerConnectionFactory.Options())
            .createPeerConnectionFactory()

        Timber.i("WebRTC initialized successfully")
    }

    fun setTouchRelay(relay: TouchInputRelay) {
        touchRelay = relay
    }

    /**
     * Create a PeerConnection with video and audio tracks ready for an offer.
     */
    fun createPeerConnection(): PeerConnection? {
        val f = factory ?: return null

        val iceServers = listOf<PeerConnection.IceServer>() // Local network, no STUN needed
        val rtcConfig = PeerConnection.RTCConfiguration(iceServers).apply {
            sdpSemantics = PeerConnection.SdpSemantics.UNIFIED_PLAN
            continualGatheringPolicy = PeerConnection.ContinualGatheringPolicy.GATHER_ONCE
        }

        localIceCandidates.clear()

        val observer = object : PeerConnection.Observer {
            override fun onIceCandidate(candidate: IceCandidate) {
                localIceCandidates.add(candidate)
                Timber.d("ICE candidate: ${candidate.sdpMid}")
            }
            override fun onIceCandidatesRemoved(candidates: Array<out IceCandidate>?) {}
            override fun onSignalingChange(state: PeerConnection.SignalingState?) {
                Timber.d("Signaling state: $state")
            }
            override fun onIceConnectionChange(state: PeerConnection.IceConnectionState?) {
                Timber.i("ICE connection state: $state")
            }
            override fun onConnectionChange(state: PeerConnection.PeerConnectionState?) {
                Timber.i("Connection state: $state")
            }
            override fun onIceGatheringChange(state: PeerConnection.IceGatheringState?) {
                Timber.d("ICE gathering state: $state")
            }
            override fun onAddStream(stream: MediaStream?) {}
            override fun onRemoveStream(stream: MediaStream?) {}
            override fun onDataChannel(dc: DataChannel) {
                Timber.i("Remote data channel opened: ${dc.label()}")
                handleDataChannel(dc)
            }
            override fun onRenegotiationNeeded() {
                Timber.d("Renegotiation needed")
            }
            override fun onAddTrack(receiver: RtpReceiver?, streams: Array<out MediaStream>?) {}
            override fun onIceConnectionReceivingChange(receiving: Boolean) {}
            override fun onSelectedCandidatePairChanged(event: CandidatePairChangeEvent?) {}
            override fun onTrack(transceiver: RtpTransceiver?) {}
        }

        peerConnection = f.createPeerConnection(rtcConfig, observer)

        // Add video track
        setupVideoTrack(f)

        // Add audio track
        setupAudioTrack(f)

        // Create data channel for touch events
        setupDataChannel()

        return peerConnection
    }

    private fun setupVideoTrack(factory: PeerConnectionFactory) {
        videoCapturer = AaVideoCapturer()
        videoSource = factory.createVideoSource(videoCapturer!!.isScreencast)
        videoCapturer!!.initialize(
            SurfaceTextureHelper.create("AaVideoCapture", eglBase!!.eglBaseContext),
            context,
            videoSource!!.capturerObserver
        )

        videoTrack = factory.createVideoTrack("aa-video-0", videoSource)
        videoTrack?.setEnabled(true)
        peerConnection?.addTrack(videoTrack, listOf("aa-stream"))
        Timber.d("Video track added")
    }

    private fun setupAudioTrack(factory: PeerConnectionFactory) {
        val constraints = MediaConstraints().apply {
            mandatory.add(MediaConstraints.KeyValuePair("googAutoGainControl", "false"))
            mandatory.add(MediaConstraints.KeyValuePair("googNoiseSuppression", "false"))
            mandatory.add(MediaConstraints.KeyValuePair("googHighpassFilter", "false"))
            mandatory.add(MediaConstraints.KeyValuePair("googEchoCancellation", "false"))
        }
        audioSource = factory.createAudioSource(constraints)
        audioTrack = factory.createAudioTrack("aa-audio-0", audioSource)
        audioTrack?.setEnabled(true)
        peerConnection?.addTrack(audioTrack, listOf("aa-stream"))
        Timber.d("Audio track added")
    }

    private fun setupDataChannel() {
        val init = DataChannel.Init().apply {
            ordered = true
            maxRetransmitTimeMs = 100
        }
        dataChannel = peerConnection?.createDataChannel("touch", init)
        dataChannel?.let { handleDataChannel(it) }
        Timber.d("Data channel created")
    }

    private fun handleDataChannel(dc: DataChannel) {
        dc.registerObserver(object : DataChannel.Observer {
            override fun onBufferedAmountChange(previousAmount: Long) {}
            override fun onStateChange() {
                Timber.d("DataChannel state: ${dc.state()}")
            }
            override fun onMessage(buffer: DataChannel.Buffer) {
                if (!buffer.binary) {
                    val data = ByteArray(buffer.data.remaining())
                    buffer.data.get(data)
                    val json = String(data, Charsets.UTF_8)
                    touchRelay?.handleMessage(json)
                }
            }
        })
    }

    /**
     * Handle an SDP offer from the browser and return our answer.
     */
    suspend fun handleOffer(offerSdp: String): String {
        val pc = peerConnection ?: createPeerConnection()
            ?: throw IllegalStateException("Failed to create PeerConnection")

        // Set remote description (browser's offer)
        suspendCancellableCoroutine { cont ->
            pc.setRemoteDescription(object : SdpObserver {
                override fun onCreateSuccess(sdp: SessionDescription?) {}
                override fun onSetSuccess() { cont.resume(Unit) }
                override fun onCreateFailure(error: String?) { cont.resumeWithException(Exception(error)) }
                override fun onSetFailure(error: String?) { cont.resumeWithException(Exception(error)) }
            }, SessionDescription(SessionDescription.Type.OFFER, offerSdp))
        }

        // Create answer
        val answer = suspendCancellableCoroutine<SessionDescription> { cont ->
            pc.createAnswer(object : SdpObserver {
                override fun onCreateSuccess(sdp: SessionDescription) { cont.resume(sdp) }
                override fun onSetSuccess() {}
                override fun onCreateFailure(error: String?) { cont.resumeWithException(Exception(error)) }
                override fun onSetFailure(error: String?) { cont.resumeWithException(Exception(error)) }
            }, MediaConstraints())
        }

        // Set local description
        suspendCancellableCoroutine { cont ->
            pc.setLocalDescription(object : SdpObserver {
                override fun onCreateSuccess(sdp: SessionDescription?) {}
                override fun onSetSuccess() { cont.resume(Unit) }
                override fun onCreateFailure(error: String?) { cont.resumeWithException(Exception(error)) }
                override fun onSetFailure(error: String?) { cont.resumeWithException(Exception(error)) }
            }, answer)
        }

        Timber.i("WebRTC answer created")
        return answer.description
    }

    fun addIceCandidate(sdpMid: String, sdpMLineIndex: Int, candidate: String) {
        peerConnection?.addIceCandidate(IceCandidate(sdpMid, sdpMLineIndex, candidate))
    }

    fun getLocalIceCandidates(): List<IceCandidateInfo> {
        return localIceCandidates.map {
            IceCandidateInfo(it.sdp, it.sdpMid, it.sdpMLineIndex)
        }
    }

    /** Feed a video frame from the AA emulator */
    fun feedVideoFrame(width: Int, height: Int, data: ByteArray, timestampNs: Long) {
        videoCapturer?.feedFrame(width, height, data, timestampNs)
    }

    fun shutdown() {
        Timber.i("Shutting down WebRTC")
        dataChannel?.close()
        dataChannel = null
        videoTrack?.dispose()
        audioTrack?.dispose()
        videoSource?.dispose()
        audioSource?.dispose()
        videoCapturer?.dispose()
        peerConnection?.close()
        peerConnection = null
        factory?.dispose()
        factory = null
        eglBase?.release()
        eglBase = null
    }

    data class IceCandidateInfo(
        val candidate: String,
        val sdpMid: String,
        val sdpMLineIndex: Int
    )
}
