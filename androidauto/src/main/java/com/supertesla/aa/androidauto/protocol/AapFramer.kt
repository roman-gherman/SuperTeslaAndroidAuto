package com.supertesla.aa.androidauto.protocol

import timber.log.Timber
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

/**
 * AAP Frame format:
 * Byte 0:   Channel ID (uint8)
 * Byte 1:   Flags (bitfield)
 * Bytes 2-3: Payload length (uint16 big-endian)
 * [If FIRST frame: Bytes 4-7: Total message length (uint32 big-endian)]
 * Remaining: Payload data
 *
 * Flags bitfield:
 *   Bits 0-1: Frame type (FIRST=0x01, LAST=0x02, BULK=0x03=FIRST|LAST, MIDDLE=0x00)
 *   Bit 2:    Message type (SPECIFIC=0x00, CONTROL=0x04)
 *   Bit 3:    Encryption (PLAIN=0x00, ENCRYPTED=0x08)
 */
class AapFramer {

    companion object {
        const val FLAG_FIRST = 0x01
        const val FLAG_LAST = 0x02
        const val FLAG_BULK = 0x03   // FIRST | LAST
        const val FLAG_CONTROL = 0x04
        const val FLAG_ENCRYPTED = 0x08

        const val MAX_FRAME_PAYLOAD = 16384
        const val HEADER_SIZE = 4
    }

    data class AapFrame(
        val channel: Int,
        val flags: Int,
        val payload: ByteArray,
        val totalLength: Int = 0
    ) {
        val isFirst: Boolean get() = flags and FLAG_FIRST != 0
        val isLast: Boolean get() = flags and FLAG_LAST != 0
        val isBulk: Boolean get() = (flags and FLAG_BULK) == FLAG_BULK
        val isEncrypted: Boolean get() = flags and FLAG_ENCRYPTED != 0
        val isControl: Boolean get() = flags and FLAG_CONTROL != 0

        /**
         * Extract the 2-byte message type ID from start of payload.
         * Only valid for FIRST or BULK frames — MIDDLE/LAST frames don't have a message type prefix.
         */
        val messageType: Int
            get() = if (isFirst && payload.size >= 2) {
                ((payload[0].toInt() and 0xFF) shl 8) or (payload[1].toInt() and 0xFF)
            } else 0

        /**
         * Get message body (payload after the 2-byte message type ID).
         * For MIDDLE/LAST frames, the entire payload is body data (no message type prefix).
         */
        val messageBody: ByteArray
            get() = if (isFirst && payload.size > 2) payload.copyOfRange(2, payload.size)
                    else if (!isFirst) payload
                    else ByteArray(0)

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other !is AapFrame) return false
            return channel == other.channel && flags == other.flags && payload.contentEquals(other.payload)
        }

        override fun hashCode(): Int {
            var result = channel
            result = 31 * result + flags
            result = 31 * result + payload.contentHashCode()
            return result
        }

        override fun toString(): String =
            "AapFrame(ch=$channel, flags=0x${flags.toString(16)}, " +
                    "msgType=0x${messageType.toString(16)}, payloadSize=${payload.size})"
    }

    /**
     * Read a single AAP frame from the input stream.
     *
     * For FIRST frames (flags & 0x01 != 0, but not BULK), the wire format has
     * 4 extra bytes (total message length) that are NOT included in the declared
     * payload length. TaaDa's MessageHandler.readData() adds +4 to the read
     * length for flags == 0x01 or 0x09 (FIRST or FIRST|ENCRYPTED).
     *
     * @throws IOException on read error or EOF
     */
    fun readFrame(input: InputStream): AapFrame {
        val header = readExactly(input, HEADER_SIZE)

        val channel = header[0].toInt() and 0xFF
        val flags = header[1].toInt() and 0xFF
        val payloadLength = ((header[2].toInt() and 0xFF) shl 8) or (header[3].toInt() and 0xFF)
        Timber.d("FRAME-READ: header=[${header.joinToString(",") { (it.toInt() and 0xFF).toString() }}] ch=$channel flags=0x${flags.toString(16)} payloadLen=$payloadLength")

        if (payloadLength > MAX_FRAME_PAYLOAD) {
            throw IOException("Frame payload too large: $payloadLength bytes (max $MAX_FRAME_PAYLOAD)")
        }

        val isFirst = flags and FLAG_FIRST != 0
        val isLast = flags and FLAG_LAST != 0

        // FIRST-only frames (not BULK): read payloadLength + 4 extra bytes for total message length
        if (isFirst && !isLast) {
            val readLen = payloadLength + 4
            val rawPayload = readExactly(input, readLen)
            val totalLength = ((rawPayload[0].toInt() and 0xFF) shl 24) or
                    ((rawPayload[1].toInt() and 0xFF) shl 16) or
                    ((rawPayload[2].toInt() and 0xFF) shl 8) or
                    (rawPayload[3].toInt() and 0xFF)
            val payload = rawPayload.copyOfRange(4, rawPayload.size)
            return AapFrame(channel, flags, payload, totalLength)
        }

        val payload = if (payloadLength > 0) readExactly(input, payloadLength) else ByteArray(0)
        return AapFrame(channel, flags, payload, 0)
    }

    /**
     * Write a complete (BULK) frame to the output stream.
     * For messages that fit in a single frame.
     */
    fun writeFrame(output: OutputStream, channel: Int, flags: Int, messageType: Int, data: ByteArray) {
        val payloadSize = 2 + data.size  // 2 bytes for message type + data
        val frame = ByteArray(HEADER_SIZE + payloadSize)
        frame[0] = channel.toByte()
        frame[1] = flags.toByte()
        frame[2] = (payloadSize shr 8).toByte()
        frame[3] = (payloadSize and 0xFF).toByte()
        frame[4] = (messageType shr 8).toByte()
        frame[5] = (messageType and 0xFF).toByte()
        System.arraycopy(data, 0, frame, 6, data.size)

        synchronized(output) {
            output.write(frame)
            output.flush()
        }
    }

    /**
     * Write raw bytes as a frame (no message type prepended).
     */
    fun writeRawFrame(output: OutputStream, channel: Int, flags: Int, payload: ByteArray) {
        val frame = ByteArray(HEADER_SIZE + payload.size)
        frame[0] = channel.toByte()
        frame[1] = flags.toByte()
        frame[2] = (payload.size shr 8).toByte()
        frame[3] = (payload.size and 0xFF).toByte()
        System.arraycopy(payload, 0, frame, HEADER_SIZE, payload.size)

        synchronized(output) {
            output.write(frame)
            output.flush()
        }
    }

    private fun readExactly(input: InputStream, count: Int): ByteArray {
        val buf = ByteArray(count)
        var offset = 0
        while (offset < count) {
            val read = input.read(buf, offset, count - offset)
            if (read == -1) throw IOException("Unexpected EOF (expected $count bytes, got $offset)")
            offset += read
        }
        return buf
    }
}
