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
import java.io.InputStream
import java.io.OutputStream
import java.net.ServerSocket
import java.net.Socket

/**
 * Android Auto Head Unit Emulator — Server Mode.
 *
 * Listens on port 5288 for Android Auto (Gearhead) to connect,
 * performs the TaaDa-style handshake, and manages all channels.
 *
 * Flow:
 * 1. Listen on ServerSocket(5288)
 * 2. Accept connection from AA
 * 3. Send CAR_HELLO, receive PHONE_HELLO, send CLEARTEXT
 * 4. TLS handshake via SSL_HANDSHAKE messages
 * 5. Auth complete
 * 6. Service discovery (phone asks, we respond with capabilities)
 * 7. Channel open (phone opens video, audio, input, sensor channels)
 * 8. Media streaming begins
 */
class AAHeadUnitEmulator(
    private val config: HeadUnitConfig = HeadUnitConfig(),
    private val context: android.content.Context? = null
) {
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private var serverSocket: ServerSocket? = null
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
        data object Listening : State()
        data object Connecting : State()
        data object Handshake : State()
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
     * Listen for AA connection on port 5288 and perform the full handshake.
     * This blocks until AA connects and handshake completes (or fails).
     */
    suspend fun listenAndConnect() = withContext(Dispatchers.IO) {
        try {
            // 1. Create ServerSocket and wait for AA to connect
            setState(State.Listening)
            Timber.i("AA-EMU: ========== LISTENING on port ${config.port} ==========")

            serverSocket = ServerSocket(config.port).apply {
                reuseAddress = true
                soTimeout = 0  // block indefinitely waiting for connection
            }
            Timber.i("AA-EMU: ServerSocket created, waiting for accept()...")

            val clientSocket = serverSocket!!.accept()
            Timber.i("AA-EMU: ========== CONNECTION ACCEPTED from ${clientSocket.remoteSocketAddress} ==========")

            // Close server socket — we only accept one connection
            try { serverSocket?.close() } catch (_: Exception) {}
            serverSocket = null

            // 2. Configure socket (TaaDa settings)
            setState(State.Connecting)
            configureSocket(clientSocket)
            socket = clientSocket
            Timber.i("AA-EMU: Socket configured")

            val input = clientSocket.getInputStream()
            val output = clientSocket.getOutputStream()
            val framer = AapFramer()
            val crypto = AapCrypto()

            // 3. TaaDa-style handshake: CAR_HELLO → PHONE_HELLO
            Timber.i("AA-EMU: Starting car handshake...")
            setState(State.Handshake)
            performCarHandshake(input, output)
            Timber.i("AA-EMU: Car handshake done!")

            // 4. TLS handshake (BEFORE cleartext — TaaDa order)
            Timber.i("AA-EMU: Starting TLS handshake...")
            setState(State.SslHandshake)
            performTlsHandshake(framer, crypto, input, output)
            Timber.i("AA-EMU: TLS handshake done!")

            // 5. Send AuthComplete as RAW AAP frame (not encrypted).
            //    This is TaaDa's CLEARTEXT_DATA {0,3,0,4,0,4,8,0} which is
            //    an AAP frame with AuthComplete(status=0). It's sent in cleartext
            //    on the socket right after TLS completes, before encrypted messaging begins.
            Timber.i("AA-EMU: Sending AuthComplete (cleartext AAP frame)...")
            output.write(HeadUnitConfig.CLEARTEXT_MSG)
            output.flush()
            Timber.i("AA-EMU: AuthComplete sent (cleartext)")

            // 6. Create channel mux for encrypted messaging
            val channelMux = ChannelMux(framer, crypto, input, output)
            mux = channelMux
            setState(State.Connected)

            setupChannelHandlers(channelMux)

            // 7. Start read loop (blocks until disconnect)
            readLoopJob = scope.launch {
                channelMux.readLoop()
            }

            setState(State.Streaming)
            Timber.i("AAEmulator fully connected and streaming")

        } catch (e: CancellationException) {
            throw e
        } catch (e: java.io.IOException) {
            Timber.w(e, "AAEmulator connection lost (IO error)")
            setState(State.Error("Connection lost: ${e.message}"))
            // Don't rethrow IO exceptions — AA disconnecting is expected during development
        } catch (e: Exception) {
            Timber.e(e, "AAEmulator connection failed")
            setState(State.Error(e.message ?: "Connection failed"))
        }
    }

    /**
     * Configure socket with TaaDa's exact settings for low-latency streaming.
     */
    private fun configureSocket(socket: Socket) {
        socket.tcpNoDelay = true                          // Disable Nagle's algorithm
        socket.soTimeout = config.socketTimeoutMs         // 10s read timeout
        socket.keepAlive = true                           // TCP keepalive
        socket.reuseAddress = true                        // Allow quick restart
        socket.trafficClass = 16                          // IPTOS_LOWDELAY
        socket.receiveBufferSize = config.socketBufferSize // 1MB
        socket.sendBufferSize = config.socketBufferSize    // 1MB
        Timber.d("Socket configured: tcpNoDelay=true, timeout=${config.socketTimeoutMs}ms, buffers=${config.socketBufferSize}")
    }

    /**
     * TaaDa-style handshake:
     * 1. Send CAR_HELLO bytes
     * 2. Read PHONE_HELLO (with timeout)
     * 3. Send CLEARTEXT bytes
     */
    private fun performCarHandshake(input: InputStream, output: OutputStream) {
        // Step 1: Send CAR_HELLO
        Timber.i("HANDSHAKE: Step 1 — Sending CAR_HELLO: ${HeadUnitConfig.CAR_HELLO.joinToString(",") { (it.toInt() and 0xFF).toString() }}")
        output.write(HeadUnitConfig.CAR_HELLO)
        output.flush()

        // Step 2: Read PHONE_HELLO (timeout already set on socket)
        Timber.i("HANDSHAKE: Step 2 — Reading PHONE_HELLO...")
        val headerBuf = ByteArray(4)
        readExactly(input, headerBuf, 4)
        Timber.i("HANDSHAKE: PHONE_HELLO header bytes: ${headerBuf.joinToString(",") { (it.toInt() and 0xFF).toString() }}")

        val channel = headerBuf[0].toInt() and 0xFF
        val flags = headerBuf[1].toInt() and 0xFF
        val payloadLen = ((headerBuf[2].toInt() and 0xFF) shl 8) or (headerBuf[3].toInt() and 0xFF)

        Timber.i("HANDSHAKE: PHONE_HELLO parsed: ch=$channel flags=0x${flags.toString(16)} payloadLen=$payloadLen")

        if (payloadLen > 0 && payloadLen <= HeadUnitConfig.MAX_PAYLOAD_SIZE) {
            val payload = ByteArray(payloadLen)
            readExactly(input, payload, payloadLen)
            Timber.i("HANDSHAKE: PHONE_HELLO payload (${payload.size} bytes): ${payload.take(32).joinToString(",") { (it.toInt() and 0xFF).toString() }}${if (payload.size > 32) "..." else ""}")
        } else {
            Timber.w("HANDSHAKE: PHONE_HELLO payload len suspicious: $payloadLen")
        }

        Timber.i("HANDSHAKE: Car handshake complete (CLEARTEXT will be sent after TLS)")
    }

    /**
     * TLS handshake inside AAP SSL_HANDSHAKE messages.
     * 2+ rounds of wrap/unwrap via SSLEngine.
     */
    private fun performTlsHandshake(
        framer: AapFramer,
        crypto: AapCrypto,
        input: InputStream,
        output: OutputStream
    ) {
        Timber.i("TLS: Initializing SSLEngine...")
        crypto.init(context)
        Timber.i("TLS: SSLEngine initialized, beginning handshake")

        // TaaDa wraps SSL handshake data with a 6-byte header:
        // {0x00, 0x03, (len+2)_hi, (len+2)_lo, 0x00, 0x03} + SSL data
        // This is NOT the standard AAP writeFrame which adds a 2-byte msgType prefix.

        fun sendSslData(data: ByteArray) {
            val frameLen = data.size + 2
            val frame = ByteArray(6 + data.size)
            frame[0] = 0x00
            frame[1] = 0x03
            frame[2] = (frameLen shr 8).toByte()
            frame[3] = (frameLen and 0xFF).toByte()
            frame[4] = 0x00
            frame[5] = 0x03
            System.arraycopy(data, 0, frame, 6, data.size)
            synchronized(output) {
                output.write(frame)
                output.flush()
            }
            Timber.i("TLS: Sent ${data.size} bytes wrapped in 6-byte header (total ${frame.size})")
        }

        fun readSslData(): ByteArray {
            // Read 4-byte header
            val hdr = ByteArray(4)
            readExactly(input, hdr, 4)
            val ch = hdr[0].toInt() and 0xFF
            val flags = hdr[1].toInt() and 0xFF
            val payloadLen = ((hdr[2].toInt() and 0xFF) shl 8) or (hdr[3].toInt() and 0xFF)
            Timber.i("TLS: Read frame header: ch=$ch flags=0x${flags.toString(16)} payloadLen=$payloadLen")

            if (payloadLen <= 0 || payloadLen > HeadUnitConfig.MAX_PAYLOAD_SIZE) {
                throw IOException("TLS: Invalid frame payload length: $payloadLen")
            }

            val payload = ByteArray(payloadLen)
            readExactly(input, payload, payloadLen)

            // The payload starts with 2-byte sub-header {0x00, 0x03} — strip it
            // to get the raw SSL data
            return if (payloadLen >= 2 && payload[0] == 0x00.toByte() && payload[1] == 0x03.toByte()) {
                Timber.i("TLS: Stripped 2-byte sub-header, SSL data: ${payloadLen - 2} bytes")
                payload.copyOfRange(2, payloadLen)
            } else {
                // Might be standard AAP frame with msgType — strip 2-byte msgType
                Timber.i("TLS: Payload starts with ${(payload[0].toInt() and 0xFF)},${(payload[1].toInt() and 0xFF)} — treating as raw SSL data after 2-byte prefix")
                payload.copyOfRange(2, payloadLen)
            }
        }

        // Round 1: produce ClientHello and send
        val clientHello = crypto.beginHandshake()
        Timber.i("TLS: ClientHello produced: ${clientHello.size} bytes")
        if (clientHello.isNotEmpty()) {
            sendSslData(clientHello)
        } else {
            Timber.w("TLS: ClientHello was empty!")
        }

        // Read ServerHello response
        Timber.i("TLS: Reading ServerHello...")
        val serverHelloData = readSslData()
        Timber.i("TLS: ServerHello received: ${serverHelloData.size} bytes")

        // Process ServerHello and produce Round 2
        Timber.i("TLS: Processing ServerHello data...")
        val round2 = crypto.processHandshakeData(serverHelloData)
        Timber.i("TLS: Round 2 produced: ${round2.size} bytes, handshakeComplete=${crypto.isHandshakeComplete}")
        if (round2.isNotEmpty()) {
            sendSslData(round2)
        }

        if (crypto.isHandshakeComplete) {
            Timber.i("TLS: ===== HANDSHAKE COMPLETED AFTER ROUND 2 =====")
            return
        }

        // Read final handshake response (ChangeCipherSpec + Finished)
        Timber.i("TLS: Reading final handshake data...")
        val serverFinishedData = readSslData()
        Timber.i("TLS: Final handshake received: ${serverFinishedData.size} bytes")

        val extra = crypto.processHandshakeData(serverFinishedData)
        Timber.i("TLS: Extra data after Finished: ${extra.size} bytes, handshakeComplete=${crypto.isHandshakeComplete}")
        if (extra.isNotEmpty()) {
            sendSslData(extra)
        }

        if (crypto.isHandshakeComplete) {
            Timber.i("TLS: ===== HANDSHAKE COMPLETED SUCCESSFULLY =====")
        } else {
            Timber.e("TLS: !!!!! HANDSHAKE NOT COMPLETE !!!!!")
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
            ),
            includeAudioSinks = false  // Match TaaDa default (useBT=true skips 5,7)
        )

        // Control channel
        val controlHandler = ControlChannelHandler(
            mux = channelMux,
            serviceDiscoveryPayload = serviceDiscoveryPayload,
            onChannelOpened = { channelId ->
                Timber.i("Channel $channelId opened")
                if (channelId == ChannelId.SENSOR) {
                    sensorHandler?.sendDrivingStatus()
                }
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
     * Send a heartbeat PingRequest to keep the AA connection alive.
     * Should be called every 2000ms from the TransporterService.
     */
    fun sendHeartbeat() {
        try {
            val timestamp = System.currentTimeMillis()
            // PingRequest protobuf: field 1 (varint) = timestamp
            val payload = com.supertesla.aa.androidauto.proto.ProtoEncoder.encode {
                writeVarint(1, timestamp)
            }
            mux?.sendEncrypted(ChannelId.CONTROL, MessageType.PING_REQUEST, payload)
        } catch (e: Exception) {
            Timber.w(e, "Failed to send heartbeat")
        }
    }

    /**
     * Send video focus notification to AA.
     * @param projected true = send video (PROJECTED mode), false = stop video (NATIVE mode)
     * @param unsolicited true = keyframe request
     */
    fun sendVideoFocus(projected: Boolean, unsolicited: Boolean = false) {
        try {
            val payload = com.supertesla.aa.androidauto.proto.ProtoEncoder.encode {
                // field 1: mode (1=PROJECTED, 2=NATIVE)
                writeVarint(1, if (projected) 1L else 2L)
                // field 2: unsolicited
                if (unsolicited) writeVarint(2, 1L)
            }
            mux?.sendEncrypted(ChannelId.CONTROL, MessageType.VIDEO_FOCUS_NOTIFICATION, payload)
            Timber.d("Sent VideoFocus: projected=$projected, unsolicited=$unsolicited")
        } catch (e: Exception) {
            Timber.w(e, "Failed to send video focus")
        }
    }

    /**
     * Close the listening server socket (used when cancelling before AA connects).
     */
    fun cancelListening() {
        try { serverSocket?.close() } catch (_: Exception) {}
        serverSocket = null
    }

    /**
     * Disconnect from the AA server.
     */
    fun disconnect() {
        Timber.i("Disconnecting AAEmulator...")
        readLoopJob?.cancel()
        readLoopJob = null

        try {
            mux?.sendEncrypted(ChannelId.CONTROL, MessageType.SHUTDOWN_REQUEST, ByteArray(0))
        } catch (_: Exception) {}

        try { serverSocket?.close() } catch (_: Exception) {}
        serverSocket = null

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

    private fun readExactly(input: InputStream, buf: ByteArray, count: Int) {
        var offset = 0
        while (offset < count) {
            val read = input.read(buf, offset, count - offset)
            if (read == -1) throw IOException("Unexpected EOF (expected $count bytes, got $offset)")
            offset += read
        }
    }
}
