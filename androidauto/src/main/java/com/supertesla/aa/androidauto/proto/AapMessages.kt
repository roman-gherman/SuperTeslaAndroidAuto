package com.supertesla.aa.androidauto.proto

import java.io.ByteArrayOutputStream
import java.nio.ByteBuffer

/**
 * AAP Control Channel Message Types (Channel 0).
 */
object MessageType {
    const val VERSION_REQUEST: Int = 1
    const val VERSION_RESPONSE: Int = 2
    const val SSL_HANDSHAKE: Int = 3
    const val AUTH_COMPLETE: Int = 4
    const val SERVICE_DISCOVERY_REQUEST: Int = 5
    const val SERVICE_DISCOVERY_RESPONSE: Int = 6
    const val CHANNEL_OPEN_REQUEST: Int = 7
    const val CHANNEL_OPEN_RESPONSE: Int = 8
    const val PING_REQUEST: Int = 11
    const val PING_RESPONSE: Int = 12
    const val NAVIGATION_FOCUS_REQUEST: Int = 13
    const val NAVIGATION_FOCUS_RESPONSE: Int = 14
    const val SHUTDOWN_REQUEST: Int = 15
    const val SHUTDOWN_RESPONSE: Int = 16
    const val VOICE_SESSION_REQUEST: Int = 17
    const val AUDIO_FOCUS_REQUEST: Int = 18
    const val AUDIO_FOCUS_RESPONSE: Int = 19
}

/**
 * AV Channel Message Types (Video/Audio channels).
 */
object AvMessageType {
    const val MEDIA_WITH_TIMESTAMP: Int = 0x0000
    const val MEDIA_INDICATION: Int = 0x0001
    const val SETUP_REQUEST: Int = 0x8000
    const val START_INDICATION: Int = 0x8001
    const val STOP_INDICATION: Int = 0x8002
    const val SETUP_RESPONSE: Int = 0x8003
    const val MEDIA_ACK: Int = 0x8004
    const val VIDEO_FOCUS_REQUEST: Int = 0x8007
    const val VIDEO_FOCUS_INDICATION: Int = 0x8008
}

/**
 * Input Channel Message Types (Channel 3).
 */
object InputMessageType {
    const val INPUT_EVENT: Int = 0x8001
    const val BINDING_REQUEST: Int = 0x8002
    const val BINDING_RESPONSE: Int = 0x8003
}

/**
 * Sensor Channel Message Types (Channel 1).
 */
object SensorMessageType {
    const val START_REQUEST: Int = 0x8001
    const val START_RESPONSE: Int = 0x8002
    const val EVENT_INDICATION: Int = 0x8003
}

/**
 * Well-known channel IDs matching the Kotlin headunit implementation.
 */
object ChannelId {
    const val CONTROL: Int = 0
    const val SENSOR: Int = 1
    const val VIDEO: Int = 2
    const val INPUT: Int = 3
    const val AUDIO_SPEECH: Int = 4
    const val AUDIO_SYSTEM: Int = 5
    const val AUDIO_MEDIA: Int = 6
    const val MIC: Int = 7
}

/**
 * Lightweight protobuf-style encoder/decoder for AAP messages.
 * AAP uses proto2 with simple fields; we encode manually to avoid the protobuf library dependency.
 */
object ProtoEncoder {

    fun writeVarint(out: ByteArrayOutputStream, value: Long) {
        var v = value
        while (v and 0x7FL.inv() != 0L) {
            out.write((v.toInt() and 0x7F) or 0x80)
            v = v ushr 7
        }
        out.write(v.toInt() and 0x7F)
    }

    fun writeTag(out: ByteArrayOutputStream, fieldNumber: Int, wireType: Int) {
        writeVarint(out, ((fieldNumber shl 3) or wireType).toLong())
    }

    fun writeVarintField(out: ByteArrayOutputStream, fieldNumber: Int, value: Long) {
        writeTag(out, fieldNumber, 0) // wire type 0 = varint
        writeVarint(out, value)
    }

    fun writeStringField(out: ByteArrayOutputStream, fieldNumber: Int, value: String) {
        writeTag(out, fieldNumber, 2) // wire type 2 = length-delimited
        val bytes = value.toByteArray(Charsets.UTF_8)
        writeVarint(out, bytes.size.toLong())
        out.write(bytes)
    }

    fun writeBytesField(out: ByteArrayOutputStream, fieldNumber: Int, value: ByteArray) {
        writeTag(out, fieldNumber, 2)
        writeVarint(out, value.size.toLong())
        out.write(value)
    }

    fun writeEmbeddedMessage(out: ByteArrayOutputStream, fieldNumber: Int, messageBuilder: (ByteArrayOutputStream) -> Unit) {
        val inner = ByteArrayOutputStream()
        messageBuilder(inner)
        val bytes = inner.toByteArray()
        writeTag(out, fieldNumber, 2)
        writeVarint(out, bytes.size.toLong())
        out.write(bytes)
    }

    fun readVarint(buf: ByteBuffer): Long {
        var result = 0L
        var shift = 0
        while (buf.hasRemaining()) {
            val b = buf.get().toInt() and 0xFF
            result = result or ((b.toLong() and 0x7F) shl shift)
            if (b and 0x80 == 0) return result
            shift += 7
            if (shift >= 64) throw IllegalStateException("Varint too long")
        }
        throw IllegalStateException("Truncated varint")
    }

    /**
     * Simple field reader: returns list of (fieldNumber, wireType, value).
     * value is Long for varint, ByteArray for length-delimited.
     */
    fun readFields(data: ByteArray, offset: Int = 0, length: Int = data.size - offset): List<ProtoField> {
        val fields = mutableListOf<ProtoField>()
        val buf = ByteBuffer.wrap(data, offset, length)
        while (buf.hasRemaining()) {
            val tag = readVarint(buf)
            val fieldNumber = (tag shr 3).toInt()
            val wireType = (tag and 0x07).toInt()
            when (wireType) {
                0 -> { // varint
                    val value = readVarint(buf)
                    fields.add(ProtoField(fieldNumber, wireType, varintValue = value))
                }
                2 -> { // length-delimited
                    val len = readVarint(buf).toInt()
                    val bytes = ByteArray(len)
                    buf.get(bytes)
                    fields.add(ProtoField(fieldNumber, wireType, bytesValue = bytes))
                }
                1 -> { // 64-bit fixed
                    val value = buf.long
                    fields.add(ProtoField(fieldNumber, wireType, varintValue = value))
                }
                5 -> { // 32-bit fixed
                    val value = buf.int.toLong()
                    fields.add(ProtoField(fieldNumber, wireType, varintValue = value))
                }
                else -> throw IllegalStateException("Unsupported wire type: $wireType")
            }
        }
        return fields
    }

    data class ProtoField(
        val fieldNumber: Int,
        val wireType: Int,
        val varintValue: Long = 0,
        val bytesValue: ByteArray? = null
    ) {
        val intValue: Int get() = varintValue.toInt()
        val stringValue: String get() = bytesValue?.toString(Charsets.UTF_8) ?: ""

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other !is ProtoField) return false
            return fieldNumber == other.fieldNumber && wireType == other.wireType &&
                    varintValue == other.varintValue && bytesValue.contentEquals(other.bytesValue)
        }

        override fun hashCode(): Int {
            var result = fieldNumber
            result = 31 * result + wireType
            result = 31 * result + varintValue.hashCode()
            result = 31 * result + (bytesValue?.contentHashCode() ?: 0)
            return result
        }
    }
}

private fun ByteArray?.contentEquals(other: ByteArray?): Boolean {
    if (this === other) return true
    if (this == null || other == null) return this == other
    return this.contentEquals(other)
}
