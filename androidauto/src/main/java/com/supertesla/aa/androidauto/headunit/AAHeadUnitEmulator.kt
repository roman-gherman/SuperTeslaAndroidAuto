package com.supertesla.aa.androidauto.headunit

import com.supertesla.aa.androidauto.channels.AudioChannelHandler
import com.supertesla.aa.androidauto.channels.ControlChannelHandler
import com.supertesla.aa.androidauto.channels.InputChannelHandler
import com.supertesla.aa.androidauto.channels.SensorChannelHandler
import com.supertesla.aa.androidauto.channels.VideoChannelHandler
import com.supertesla.aa.androidauto.proto.AvMessageType
import com.supertesla.aa.androidauto.proto.ChannelId
import com.supertesla.aa.androidauto.proto.MessageType
import com.supertesla.aa.androidauto.proto.ServiceDiscovery
import com.supertesla.aa.androidauto.protocol.AapCrypto
import com.supertesla.aa.androidauto.protocol.AapFramer
import com.supertesla.aa.androidauto.protocol.ChannelMux
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import java.io.IOException
import java.net.Socket

/**
 * Android Auto Head Unit Emulator.
 *
 * Connects to the AA Head Unit Server running on the phone (localhost:5277),
 * performs the AAP handshake, and manages all channels.
 *
 * Flow:
 * 1. TCP connect to localhost:5277
 * 2. Version exchange (unencrypted)
 * 3. TLS handshake via SSL_HANDSHAKE messages
 * 4. Auth complete
 * 5. Service discovery (phone asks, we respond with capabilities)
 * 6. Channel open (phone opens video, audio, input, sensor channels)
 * 7. Media streaming begins
 */
class AAHeadUnitEmulator(
    private val config: HeadUnitConfig = HeadUnitConfig()
) {
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private var socket: Socket? = null
    private var readLoopJob: Job? = null
    private var mux: ChannelMux? = null

    // Channel handlers (accessible for wiring to UI/streaming)
    var videoHandler: VideoChannelHandler? = null
        private set
    var audioSpeechHandler: AudioChannelHandler? = null
        private set
    var audioSystemHandler: AudioChannelHandler? = null
        private set
    var audioMediaHandler: AudioChannelHandler? = null
        private set
    var inputHandler: InputChannelHandler? = null
        private set
    var sensorHandler: SensorChannelHandler? = null
        private set

    sealed class State {
        data object Disconnected : State()
        data object Connecting : State()
        data object VersionExchange : State()
        data object SslHandshake : State()
        data object Connected : State()
        data object Streaming : State()
        data class Error(val message: String) : State()
    }

    private var _state: State = State.Disconnected
    val state: State get() = _state
    var onStateChanged: ((State) -> Unit)? = null

    private fun setState(newState: State) {
        _state = newState
        Timber.i("AAEmulator state: ${newState::class.simpleName}")
        onStateChanged?.invoke(newState)
    }

    /**
     * Connect to the AA head unit server and start the protocol handshake.
     */
    suspend fun connect() = withContext(Dispatchers.IO) {
        try {
            setState(State.Connecting)

            // 1. TCP connect
            Timber.i("Connecting to ${config.host}:${config.port}...")
            socket = Socket(config.host, config.port).apply {
                tcpNoDelay = true
                soTimeout = 0  // blocking reads
            }
            Timber.i("TCP connected to ${config.host}:${config.port}")

            val input = socket!!.getInputStream()
            val output = socket!!.getOutputStream()
            val framer = AapFramer()
            val crypto = AapCrypto()

            // 2. Version exchange
            setState(State.VersionExchange)
            performVersionExchange(framer, input, output)

            // 3. TLS handshake
            setState(State.SslHandshake)
            performTlsHandshake(framer, crypto, input, output)

            // 4. Auth complete
            val authPayload = ServiceDiscovery.buildAuthComplete(status = 0)
            framer.writeFrame(output, ChannelId.CONTROL, AapFramer.FLAG_BULK, MessageType.AUTH_COMPLETE, authPayload)
            Timber.i("Sent AuthComplete")

            // 5. Create channel mux and register handlers
            val channelMux = ChannelMux(framer, crypto, input, output)
            mux = channelMux
            setState(State.Connected)

            setupChannelHandlers(channelMux)

            // 6. Start read loop (blocks until disconnect)
            readLoopJob = scope.launch {
                channelMux.readLoop()
            }

            setState(State.Streaming)
            Timber.i("AAEmulator fully connected and streaming")

        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            Timber.e(e, "AAEmulator connection failed")
            setState(State.Error(e.message ?: "Connection failed"))
            throw e
        }
    }

    /**
     * Step 2: Version exchange.
     * HU sends VersionRequest, reads VersionResponse.
     */
    private fun performVersionExchange(
        framer: AapFramer,
        input: java.io.InputStream,
        output: java.io.OutputStream
    ) {
        // Send: version major=1, minor=1
        val versionPayload = byteArrayOf(0x00, 0x01, 0x00, 0x01)
        framer.writeFrame(output, ChannelId.CONTROL, AapFramer.FLAG_BULK, MessageType.VERSION_REQUEST, versionPayload)
        Timber.d("Sent VersionRequest (1.1)")

        // Read response
        val response = framer.readFrame(input)
        if (response.messageType != MessageType.VERSION_RESPONSE) {
            throw IOException("Expected VersionResponse (type=2), got type=${response.messageType}")
        }

        val body = response.messageBody
        if (body.size >= 6) {
            val major = ((body[0].toInt() and 0xFF) shl 8) or (body[1].toInt() and 0xFF)
            val minor = ((body[2].toInt() and 0xFF) shl 8) or (body[3].toInt() and 0xFF)
            val status = ((body[4].toInt() and 0xFF) shl 8) or (body[5].toInt() and 0xFF)
            Timber.i("VersionResponse: $major.$minor, status=0x${status.toString(16)}")
            if (status == 0xFFFF) {
                throw IOException("Version mismatch reported by AA server")
            }
        } else {
            Timber.w("VersionResponse too short: ${body.size} bytes")
        }
    }

    /**
     * Step 3: TLS handshake inside AAP SSL_HANDSHAKE messages.
     * 2 rounds of wrap/unwrap via SSLEngine.
     */
    private fun performTlsHandshake(
        framer: AapFramer,
        crypto: AapCrypto,
        input: java.io.InputStream,
        output: java.io.OutputStream
    ) {
        crypto.init()

        // Round 1: produce ClientHello and send
        val clientHello = crypto.beginHandshake()
        if (clientHello.isNotEmpty()) {
            framer.writeFrame(output, ChannelId.CONTROL, AapFramer.FLAG_BULK, MessageType.SSL_HANDSHAKE, clientHello)
            Timber.d("Sent SSL ClientHello (${clientHello.size} bytes)")
        }

        // Read ServerHello response
        val serverHello = framer.readFrame(input)
        if (serverHello.messageType != MessageType.SSL_HANDSHAKE) {
            throw IOException("Expected SSL_HANDSHAKE (type=3), got type=${serverHello.messageType}")
        }
        Timber.d("Received SSL ServerHello (${serverHello.messageBody.size} bytes)")

        // Process ServerHello and produce Round 2
        val round2 = crypto.processHandshakeData(serverHello.messageBody)
        if (round2.isNotEmpty()) {
            framer.writeFrame(output, ChannelId.CONTROL, AapFramer.FLAG_BULK, MessageType.SSL_HANDSHAKE, round2)
            Timber.d("Sent SSL Round 2 (${round2.size} bytes)")
        }

        // Read final handshake response (ChangeCipherSpec + Finished)
        val serverFinished = framer.readFrame(input)
        if (serverFinished.messageType == MessageType.SSL_HANDSHAKE) {
            Timber.d("Received SSL Finished (${serverFinished.messageBody.size} bytes)")
            val extra = crypto.processHandshakeData(serverFinished.messageBody)
            if (extra.isNotEmpty()) {
                framer.writeFrame(output, ChannelId.CONTROL, AapFramer.FLAG_BULK, MessageType.SSL_HANDSHAKE, extra)
            }
        }

        if (crypto.isHandshakeComplete) {
            Timber.i("TLS handshake completed successfully")
        } else {
            Timber.w("TLS handshake may not be fully complete (status: ${crypto.isHandshakeComplete})")
        }
    }

    /**
     * Set up all channel handlers and register them with the mux.
     */
    private fun setupChannelHandlers(channelMux: ChannelMux) {
        val serviceDiscoveryPayload = ServiceDiscovery.buildResponse(
            videoConfig = ServiceDiscovery.VideoConfig(
                width = config.videoWidth,
                height = config.videoHeight,
                density = config.videoDensity,
                fps = config.videoFps
            ),
            mediaAudio = ServiceDiscovery.AudioConfig(
                sampleRate = config.audioSampleRate,
                bitDepth = config.audioBitDepth,
                channelCount = config.audioChannels
            )
        )

        // Control channel
        val controlHandler = ControlChannelHandler(
            mux = channelMux,
            serviceDiscoveryPayload = serviceDiscoveryPayload,
            onChannelOpened = { channelId ->
                Timber.i("Channel $channelId opened")
                // After sensor channel opens, send driving status
                if (channelId == ChannelId.SENSOR) {
                    sensorHandler?.sendDrivingStatus()
                }
                // After video channel opens, send video focus
                if (channelId == ChannelId.VIDEO) {
                    val focusPayload = ServiceDiscovery.buildVideoFocusIndication()
                    channelMux.sendEncrypted(ChannelId.VIDEO, AvMessageType.VIDEO_FOCUS_INDICATION, focusPayload)
                }
            },
            onShutdown = { disconnect() }
        )
        channelMux.registerHandler(ChannelId.CONTROL, controlHandler)

        // Video channel
        videoHandler = VideoChannelHandler(channelMux)
        channelMux.registerHandler(ChannelId.VIDEO, videoHandler!!)

        // Input channel
        inputHandler = InputChannelHandler(channelMux, config.videoWidth, config.videoHeight)
        channelMux.registerHandler(ChannelId.INPUT, inputHandler!!)

        // Sensor channel
        sensorHandler = SensorChannelHandler(channelMux)
        channelMux.registerHandler(ChannelId.SENSOR, sensorHandler!!)

        // Audio channels
        audioSpeechHandler = AudioChannelHandler(ChannelId.AUDIO_SPEECH, "Speech", channelMux)
        channelMux.registerHandler(ChannelId.AUDIO_SPEECH, audioSpeechHandler!!)

        audioSystemHandler = AudioChannelHandler(ChannelId.AUDIO_SYSTEM, "System", channelMux)
        channelMux.registerHandler(ChannelId.AUDIO_SYSTEM, audioSystemHandler!!)

        audioMediaHandler = AudioChannelHandler(ChannelId.AUDIO_MEDIA, "Media", channelMux)
        channelMux.registerHandler(ChannelId.AUDIO_MEDIA, audioMediaHandler!!)
    }

    /**
     * Disconnect from the AA server.
     */
    fun disconnect() {
        Timber.i("Disconnecting AAEmulator...")
        readLoopJob?.cancel()
        readLoopJob = null

        try {
            // Try sending shutdown
            mux?.sendEncrypted(ChannelId.CONTROL, MessageType.SHUTDOWN_REQUEST, ByteArray(0))
        } catch (_: Exception) {}

        try { socket?.close() } catch (_: Exception) {}
        socket = null
        mux = null
        videoHandler = null
        inputHandler = null
        sensorHandler = null
        audioSpeechHandler = null
        audioSystemHandler = null
        audioMediaHandler = null

        setState(State.Disconnected)
    }

    fun destroy() {
        disconnect()
        scope.cancel()
    }
}
