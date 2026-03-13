package com.supertesla.aa.network.dns

import timber.log.Timber
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress
import java.nio.ByteBuffer

/**
 * Lightweight DNS server that runs on the phone's hotspot interface.
 * Resolves our custom hostname to the VPN virtual IP,
 * and forwards all other queries to an upstream DNS server.
 *
 * When Tesla connects to the phone's hotspot, the phone is the DHCP-assigned
 * DNS server. This intercepts DNS queries from Tesla and resolves our domain locally.
 */
class LocalDnsServer(
    private val hostname: String = DEFAULT_HOSTNAME,
    private val virtualIp: String = "240.3.3.3",
    private val bindAddress: String = "0.0.0.0",
    private val port: Int = 53,
    private val upstreamDns: String = "8.8.8.8"
) {
    private var socket: DatagramSocket? = null
    private var running = false
    private var thread: Thread? = null

    val isRunning: Boolean get() = running

    fun start() {
        if (running) return

        thread = Thread({
            try {
                socket = DatagramSocket(port, InetAddress.getByName(bindAddress))
                socket!!.reuseAddress = true
                running = true
                Timber.i("DNS server started on $bindAddress:$port (resolving $hostname -> $virtualIp)")

                val buffer = ByteArray(512)
                while (running) {
                    val packet = DatagramPacket(buffer, buffer.size)
                    try {
                        socket!!.receive(packet)
                        handleQuery(packet)
                    } catch (e: Exception) {
                        if (running) Timber.v("DNS receive error: ${e.message}")
                    }
                }
            } catch (e: Exception) {
                Timber.w(e, "DNS server failed to start on port $port")
            }
        }, "LocalDnsServer").apply {
            isDaemon = true
            start()
        }
    }

    fun stop() {
        running = false
        try { socket?.close() } catch (_: Exception) {}
        socket = null
        thread = null
        Timber.i("DNS server stopped")
    }

    private fun handleQuery(packet: DatagramPacket) {
        val data = packet.data.copyOfRange(0, packet.length)

        // Parse the queried domain name from the DNS query
        val queriedName = extractQueryName(data)

        if (queriedName != null && matchesHostname(queriedName)) {
            // Respond with our virtual IP
            Timber.d("DNS: $queriedName -> $virtualIp (local)")
            val response = buildDnsResponse(data, virtualIp)
            val responsePacket = DatagramPacket(
                response, response.size, packet.address, packet.port
            )
            socket?.send(responsePacket)
        } else {
            // Forward to upstream DNS
            forwardToUpstream(data, packet)
        }
    }

    private fun matchesHostname(name: String): Boolean {
        val lower = name.lowercase()
        return lower == hostname || lower == "$hostname."
    }

    /**
     * Extract the queried domain name from a DNS query packet.
     * DNS name format: [len][label][len][label]...[0]
     */
    private fun extractQueryName(data: ByteArray): String? {
        if (data.size < 12) return null // DNS header is 12 bytes

        // Questions start at offset 12
        var offset = 12
        val parts = mutableListOf<String>()

        while (offset < data.size) {
            val len = data[offset].toInt() and 0xFF
            if (len == 0) break
            if (offset + 1 + len > data.size) return null

            parts.add(String(data, offset + 1, len, Charsets.US_ASCII))
            offset += 1 + len
        }

        return if (parts.isNotEmpty()) parts.joinToString(".") else null
    }

    /**
     * Build a DNS response with an A record pointing to our IP.
     */
    private fun buildDnsResponse(query: ByteArray, ip: String): ByteArray {
        val buf = ByteBuffer.allocate(512)

        // Copy transaction ID from query
        buf.put(query[0])
        buf.put(query[1])

        // Flags: response, authoritative, no recursion
        buf.put(0x81.toByte()) // QR=1, Opcode=0, AA=1, TC=0, RD=1
        buf.put(0x80.toByte()) // RA=1, RCODE=0

        // Questions: 1, Answers: 1, Authority: 0, Additional: 0
        buf.putShort(1)
        buf.putShort(1)
        buf.putShort(0)
        buf.putShort(0)

        // Copy the question section from the query
        var qEnd = 12
        while (qEnd < query.size && query[qEnd].toInt() != 0) {
            qEnd += 1 + (query[qEnd].toInt() and 0xFF)
        }
        qEnd += 5 // null terminator + QTYPE(2) + QCLASS(2)
        if (qEnd > query.size) qEnd = query.size

        buf.put(query, 12, qEnd - 12)

        // Answer section: pointer to name in question, A record, IN class
        buf.putShort(0xC00C.toShort()) // Name pointer to offset 12
        buf.putShort(1)                // Type: A
        buf.putShort(1)                // Class: IN
        buf.putInt(60)                 // TTL: 60 seconds
        buf.putShort(4)                // Data length: 4 bytes (IPv4)

        // IP address bytes
        val ipParts = ip.split(".")
        for (part in ipParts) {
            buf.put(part.toInt().toByte())
        }

        buf.flip()
        val response = ByteArray(buf.remaining())
        buf.get(response)
        return response
    }

    /**
     * Forward a DNS query to the upstream DNS server and relay the response.
     */
    private fun forwardToUpstream(query: ByteArray, originalPacket: DatagramPacket) {
        try {
            val upstreamSocket = DatagramSocket()
            upstreamSocket.soTimeout = 3000

            val upstreamAddr = InetAddress.getByName(upstreamDns)
            val forwardPacket = DatagramPacket(query, query.size, upstreamAddr, 53)
            upstreamSocket.send(forwardPacket)

            val responseBuffer = ByteArray(512)
            val responsePacket = DatagramPacket(responseBuffer, responseBuffer.size)
            upstreamSocket.receive(responsePacket)
            upstreamSocket.close()

            // Relay response back to the original client
            val relayPacket = DatagramPacket(
                responsePacket.data, responsePacket.length,
                originalPacket.address, originalPacket.port
            )
            socket?.send(relayPacket)
        } catch (e: Exception) {
            Timber.v("DNS forward failed: ${e.message}")
        }
    }

    companion object {
        const val DEFAULT_HOSTNAME = "super.taa"
    }
}
