package com.supertesla.aa.network.webserver

import android.content.Context
import timber.log.Timber
import java.io.File

/**
 * Launches a native AF_INET TCP proxy using Android's toybox `nc` with mkfifo pipes.
 *
 * Android 16 forces all Java sockets (including Os.socket) to IPv6 dual-stack,
 * which hotspot iptables cannot forward from external clients (like Tesla).
 * Native binaries (nc, socat) create true AF_INET sockets that ARE reachable.
 *
 * The proxy listens on publicPort (e.g. 8080) and forwards to targetPort
 * (e.g. 18080 where Ktor runs on localhost).
 *
 * Strategy: mkfifo named pipe for bidirectional nc proxy (toybox nc lacks -e flag).
 */
class NativeProxyLauncher(private val context: Context) {

    sealed class ProxyResult {
        data class Success(val tool: String) : ProxyResult()
        data class Failed(val reason: String) : ProxyResult()
    }

    private var process: Process? = null
    private var watchdogThread: Thread? = null
    private val pipeDir: File get() = File(context.cacheDir, "proxy_pipes")

    val isRunning: Boolean get() = process?.isAlive == true

    fun start(bindAddress: String, publicPort: Int, targetPort: Int): ProxyResult {
        stop() // Clean up any previous instance

        // Create pipe directory
        pipeDir.mkdirs()
        val pipePath = File(pipeDir, "proxy_pipe").absolutePath

        // Clean up old pipes
        cleanup()

        // Shell pipeline with single FIFO for bidirectional nc proxy.
        // The `|` pipe provides direction 1 (client→backend).
        // The FIFO provides direction 2 (backend→client).
        // In a pipeline, both processes fork simultaneously, so:
        //   nc-l opens FIFO for read (blocks) while nc-backend opens for write (unblocks it).
        val fifo = File(pipeDir, "backpipe").absolutePath
        val script = """
            rm -f "$fifo" 2>/dev/null
            mkfifo "$fifo" 2>/dev/null
            if [ ! -p "$fifo" ]; then
                echo "PROXY_ERROR: mkfifo failed"
                exit 1
            fi
            echo "PROXY_READY"
            while true; do
                nc -l -p $publicPort <"$fifo" | nc 127.0.0.1 $targetPort >"$fifo"
                echo "PROXY_CYCLE"
            done
        """.trimIndent()

        return try {
            val proc = ProcessBuilder("sh", "-c", script)
                .redirectErrorStream(true)
                .start()
            process = proc

            // Read first line to check if proxy started successfully
            val reader = proc.inputStream.bufferedReader()
            val firstLine = reader.readLine() ?: "PROXY_ERROR: no output"

            if (firstLine.contains("PROXY_ERROR")) {
                proc.destroyForcibly()
                process = null
                return ProxyResult.Failed(firstLine)
            }

            if (firstLine.contains("PROXY_READY")) {
                Timber.i("NativeProxy: mkfifo proxy started on $bindAddress:$publicPort → 127.0.0.1:$targetPort")

                // Start watchdog thread that monitors the process
                watchdogThread = Thread({
                    try {
                        while (proc.isAlive) {
                            val line = reader.readLine() ?: break
                            when {
                                line.contains("PROXY_CYCLE") -> Timber.d("NativeProxy: connection cycle completed")
                                line.contains("PROXY_ERROR") -> Timber.w("NativeProxy: $line")
                                else -> Timber.d("NativeProxy: $line")
                            }
                        }
                        val exit = proc.waitFor()
                        Timber.w("NativeProxy: process exited with code $exit")
                    } catch (_: InterruptedException) {
                        Timber.d("NativeProxy: watchdog interrupted")
                    }
                }, "native-proxy-watchdog").apply { isDaemon = true; start() }

                ProxyResult.Success("nc+mkfifo")
            } else {
                Timber.w("NativeProxy: unexpected first line: $firstLine")
                // Still might work, keep running
                ProxyResult.Success("nc+mkfifo (unverified)")
            }
        } catch (e: Exception) {
            Timber.e(e, "NativeProxy: failed to start")
            ProxyResult.Failed(e.message ?: "unknown error")
        }
    }

    fun stop() {
        watchdogThread?.interrupt()
        watchdogThread = null
        process?.destroyForcibly()
        process = null
        cleanup()
    }

    private fun cleanup() {
        try {
            pipeDir.listFiles()?.forEach { it.delete() }
        } catch (_: Exception) {}
    }
}
