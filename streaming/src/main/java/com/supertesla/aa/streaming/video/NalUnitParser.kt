package com.supertesla.aa.streaming.video

/**
 * Parses H.264 Annex B byte streams into individual NAL units.
 * Handles both 3-byte (0x000001) and 4-byte (0x00000001) start codes.
 */
class NalUnitParser {

    enum class NalType(val value: Int) {
        SLICE_NON_IDR(1),
        SLICE_PARTITION_A(2),
        SLICE_PARTITION_B(3),
        SLICE_PARTITION_C(4),
        SLICE_IDR(5),
        SEI(6),
        SPS(7),
        PPS(8),
        AUD(9),
        END_SEQUENCE(10),
        END_STREAM(11),
        FILLER(12),
        UNKNOWN(-1);

        val isKeyframe: Boolean get() = this == SLICE_IDR
        val isSlice: Boolean get() = this == SLICE_IDR || this == SLICE_NON_IDR

        companion object {
            fun fromByte(b: Byte): NalType {
                val typeVal = b.toInt() and 0x1F
                return entries.firstOrNull { it.value == typeVal } ?: UNKNOWN
            }
        }
    }

    data class NalUnit(
        val type: NalType,
        val data: ByteArray,
        val startCodeSize: Int
    ) {
        /** NAL unit data without the start code prefix */
        val dataWithoutStartCode: ByteArray
            get() = data.copyOfRange(startCodeSize, data.size)

        val isKeyframe: Boolean get() = type.isKeyframe

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other !is NalUnit) return false
            return type == other.type && data.contentEquals(other.data)
        }
        override fun hashCode(): Int = data.contentHashCode()
    }

    /** Cached SPS/PPS for decoder initialization and fMP4 init segment */
    var cachedSps: ByteArray? = null
        private set
    var cachedPps: ByteArray? = null
        private set

    val hasSpsAndPps: Boolean
        get() = cachedSps != null && cachedPps != null

    /**
     * Parse an Annex B byte stream into a list of NAL units.
     */
    fun parse(stream: ByteArray): List<NalUnit> {
        val units = mutableListOf<NalUnit>()
        val positions = findStartCodes(stream)

        for (i in positions.indices) {
            val start = positions[i].first
            val startCodeLen = positions[i].second
            val end = if (i + 1 < positions.size) positions[i + 1].first else stream.size

            val nalData = stream.copyOfRange(start, end)
            val nalByte = stream[start + startCodeLen]
            val type = NalType.fromByte(nalByte)

            val unit = NalUnit(type, nalData, startCodeLen)
            cacheSpsOrPps(unit)
            units.add(unit)
        }

        return units
    }

    /**
     * Feed a chunk and get NAL units via callback.
     * Each chunk from AA typically contains one or more complete NAL units.
     */
    fun feed(chunk: ByteArray, onNalUnit: (NalUnit) -> Unit) {
        val units = parse(chunk)
        for (unit in units) {
            onNalUnit(unit)
        }
    }

    private fun cacheSpsOrPps(unit: NalUnit) {
        when (unit.type) {
            NalType.SPS -> cachedSps = unit.dataWithoutStartCode
            NalType.PPS -> cachedPps = unit.dataWithoutStartCode
            else -> {}
        }
    }

    /**
     * Find all start code positions in the byte array.
     * Returns list of (position, startCodeLength) pairs.
     */
    private fun findStartCodes(data: ByteArray): List<Pair<Int, Int>> {
        val positions = mutableListOf<Pair<Int, Int>>()
        var i = 0
        while (i < data.size - 3) {
            if (data[i] == 0.toByte() && data[i + 1] == 0.toByte()) {
                if (i + 3 < data.size && data[i + 2] == 0.toByte() && data[i + 3] == 1.toByte()) {
                    positions.add(Pair(i, 4))
                    i += 4
                    continue
                }
                if (data[i + 2] == 1.toByte()) {
                    positions.add(Pair(i, 3))
                    i += 3
                    continue
                }
            }
            i++
        }
        return positions
    }

    companion object {
        /**
         * Convert an Annex B NAL unit to AVCC format (4-byte length prefix).
         * Strips the start code and prepends the NAL unit length as big-endian uint32.
         */
        fun annexBToAvcc(nalUnit: NalUnit): ByteArray {
            val nalBody = nalUnit.dataWithoutStartCode
            val avcc = ByteArray(4 + nalBody.size)
            val len = nalBody.size
            avcc[0] = (len shr 24).toByte()
            avcc[1] = (len shr 16).toByte()
            avcc[2] = (len shr 8).toByte()
            avcc[3] = (len and 0xFF).toByte()
            System.arraycopy(nalBody, 0, avcc, 4, nalBody.size)
            return avcc
        }

        /**
         * Convert raw NAL body bytes (no start code) to AVCC format.
         */
        fun rawToAvcc(nalBody: ByteArray): ByteArray {
            val avcc = ByteArray(4 + nalBody.size)
            val len = nalBody.size
            avcc[0] = (len shr 24).toByte()
            avcc[1] = (len shr 16).toByte()
            avcc[2] = (len shr 8).toByte()
            avcc[3] = (len and 0xFF).toByte()
            System.arraycopy(nalBody, 0, avcc, 4, nalBody.size)
            return avcc
        }
    }
}
