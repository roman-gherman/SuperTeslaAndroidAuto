package com.supertesla.aa.streaming.video

import java.io.ByteArrayOutputStream

/**
 * Minimal ISO BMFF (fragmented MP4) muxer for H.264 video.
 * Produces fMP4 segments playable via MediaSource Extensions (MSE) in browsers.
 *
 * Two types of output:
 * 1. Init segment (ftyp + moov) - sent once, contains SPS/PPS in avcC
 * 2. Media segments (moof + mdat) - sent per frame, contains H.264 data in AVCC format
 */
class FragmentedMp4Muxer(
    private val width: Int,
    private val height: Int,
    private val frameRate: Int = 30,
    private val timescale: Int = 90000
) {
    private var sequenceNumber = 1
    private var baseDecodeTime = 0L
    private val frameDuration = timescale / frameRate

    data class VideoFrame(
        val avccData: ByteArray, // NAL units in AVCC format (length-prefixed)
        val isKeyframe: Boolean,
        val duration: Int = 0,
        val compositionTimeOffset: Int = 0
    ) {
        override fun equals(other: Any?) = this === other
        override fun hashCode() = avccData.contentHashCode()
    }

    /**
     * Create the init segment (ftyp + moov) from SPS and PPS.
     * Must be sent to the browser before any media segments.
     */
    fun createInitSegment(sps: ByteArray, pps: ByteArray): ByteArray {
        val out = ByteArrayOutputStream(512)
        writeFtyp(out)
        writeMoov(out, sps, pps)
        return out.toByteArray()
    }

    /**
     * Create a media segment (moof + mdat) for one or more video frames.
     */
    fun createMediaSegment(frames: List<VideoFrame>): ByteArray {
        val out = ByteArrayOutputStream(4096)
        val seq = sequenceNumber++

        // Calculate total data size
        val totalDataSize = frames.sumOf { it.avccData.size }

        // Build moof content first to know its size for data_offset fixup
        val moofContent = ByteArrayOutputStream()
        writeMfhd(moofContent, seq)
        writeTraf(moofContent, frames, totalDataSize)
        val moofContentBytes = moofContent.toByteArray()
        val moofBoxSize = 8 + moofContentBytes.size // 8 = box header (size + type)

        // data_offset = bytes from moof start to mdat payload start
        // = moof_box_size + 8 (mdat box header)
        val dataOffset = moofBoxSize + 8

        // Fix up the data_offset in the trun box.
        // trun data_offset is at a known position within moofContent:
        //   mfhd box = 8 + 8 = 16 bytes
        //   traf box header = 8 bytes
        //   tfhd box = 8 + 8 = 16 bytes
        //   tfdt box = 8 + 12 = 20 bytes
        //   trun box header = 8 bytes
        //   trun version+flags = 4 bytes
        //   trun sample_count = 4 bytes
        //   -> data_offset is at offset: 16 + 8 + 16 + 20 + 8 + 4 + 4 = 76
        val dataOffsetPos = 76
        moofContentBytes[dataOffsetPos] = ((dataOffset shr 24) and 0xFF).toByte()
        moofContentBytes[dataOffsetPos + 1] = ((dataOffset shr 16) and 0xFF).toByte()
        moofContentBytes[dataOffsetPos + 2] = ((dataOffset shr 8) and 0xFF).toByte()
        moofContentBytes[dataOffsetPos + 3] = (dataOffset and 0xFF).toByte()

        writeBox(out, "moof", moofContentBytes)

        // mdat
        val mdatContent = ByteArrayOutputStream(totalDataSize)
        for (frame in frames) {
            mdatContent.write(frame.avccData)
        }
        writeBox(out, "mdat", mdatContent.toByteArray())

        return out.toByteArray()
    }

    fun reset() {
        sequenceNumber = 1
        baseDecodeTime = 0
    }

    // ---- Box writers ----

    private fun writeFtyp(out: ByteArrayOutputStream) {
        val content = ByteArrayOutputStream()
        content.writeAscii("isom")       // major_brand
        content.writeUInt32(0x200)       // minor_version
        content.writeAscii("isom")       // compatible_brands
        content.writeAscii("iso2")
        content.writeAscii("avc1")
        content.writeAscii("mp41")
        writeBox(out, "ftyp", content.toByteArray())
    }

    private fun writeMoov(out: ByteArrayOutputStream, sps: ByteArray, pps: ByteArray) {
        val content = ByteArrayOutputStream()
        writeMvhd(content)
        writeTrak(content, sps, pps)
        writeMvex(content)
        writeBox(out, "moov", content.toByteArray())
    }

    private fun writeMvhd(out: ByteArrayOutputStream) {
        val content = ByteArrayOutputStream()
        content.writeUInt32(0)           // version + flags
        content.writeUInt32(0)           // creation_time
        content.writeUInt32(0)           // modification_time
        content.writeUInt32(timescale)   // timescale
        content.writeUInt32(0)           // duration
        content.writeUInt32(0x00010000)  // rate = 1.0
        content.writeUInt16(0x0100)      // volume = 1.0
        content.write(ByteArray(10))     // reserved
        // matrix (identity 3x3)
        content.writeUInt32(0x00010000); content.writeUInt32(0); content.writeUInt32(0)
        content.writeUInt32(0); content.writeUInt32(0x00010000); content.writeUInt32(0)
        content.writeUInt32(0); content.writeUInt32(0); content.writeUInt32(0x40000000)
        content.write(ByteArray(24))     // pre_defined
        content.writeUInt32(2)           // next_track_ID
        writeBox(out, "mvhd", content.toByteArray())
    }

    private fun writeTrak(out: ByteArrayOutputStream, sps: ByteArray, pps: ByteArray) {
        val content = ByteArrayOutputStream()
        writeTkhd(content)
        writeMdia(content, sps, pps)
        writeBox(out, "trak", content.toByteArray())
    }

    private fun writeTkhd(out: ByteArrayOutputStream) {
        val content = ByteArrayOutputStream()
        content.writeUInt32(0x00000003)  // version=0, flags=3 (track_enabled | track_in_movie)
        content.writeUInt32(0)           // creation_time
        content.writeUInt32(0)           // modification_time
        content.writeUInt32(1)           // track_ID
        content.writeUInt32(0)           // reserved
        content.writeUInt32(0)           // duration
        content.write(ByteArray(8))      // reserved
        content.writeUInt16(0)           // layer
        content.writeUInt16(0)           // alternate_group
        content.writeUInt16(0)           // volume (0 for video)
        content.writeUInt16(0)           // reserved
        // matrix (identity)
        content.writeUInt32(0x00010000); content.writeUInt32(0); content.writeUInt32(0)
        content.writeUInt32(0); content.writeUInt32(0x00010000); content.writeUInt32(0)
        content.writeUInt32(0); content.writeUInt32(0); content.writeUInt32(0x40000000)
        content.writeUInt32(width shl 16)  // width (fixed-point 16.16)
        content.writeUInt32(height shl 16) // height (fixed-point 16.16)
        writeBox(out, "tkhd", content.toByteArray())
    }

    private fun writeMdia(out: ByteArrayOutputStream, sps: ByteArray, pps: ByteArray) {
        val content = ByteArrayOutputStream()
        writeMdhd(content)
        writeHdlr(content)
        writeMinf(content, sps, pps)
        writeBox(out, "mdia", content.toByteArray())
    }

    private fun writeMdhd(out: ByteArrayOutputStream) {
        val content = ByteArrayOutputStream()
        content.writeUInt32(0)           // version + flags
        content.writeUInt32(0)           // creation_time
        content.writeUInt32(0)           // modification_time
        content.writeUInt32(timescale)   // timescale
        content.writeUInt32(0)           // duration
        content.writeUInt16(0x55C4)      // language (undetermined)
        content.writeUInt16(0)           // pre_defined
        writeBox(out, "mdhd", content.toByteArray())
    }

    private fun writeHdlr(out: ByteArrayOutputStream) {
        val content = ByteArrayOutputStream()
        content.writeUInt32(0)           // version + flags
        content.writeUInt32(0)           // pre_defined
        content.writeAscii("vide")       // handler_type
        content.write(ByteArray(12))     // reserved
        content.write("VideoHandler\u0000".toByteArray()) // name
        writeBox(out, "hdlr", content.toByteArray())
    }

    private fun writeMinf(out: ByteArrayOutputStream, sps: ByteArray, pps: ByteArray) {
        val content = ByteArrayOutputStream()
        writeVmhd(content)
        writeDinf(content)
        writeStbl(content, sps, pps)
        writeBox(out, "minf", content.toByteArray())
    }

    private fun writeVmhd(out: ByteArrayOutputStream) {
        val content = ByteArrayOutputStream()
        content.writeUInt32(1)           // version=0, flags=1
        content.writeUInt16(0)           // graphicsmode
        content.writeUInt16(0)           // opcolor[0]
        content.writeUInt16(0)           // opcolor[1]
        content.writeUInt16(0)           // opcolor[2]
        writeBox(out, "vmhd", content.toByteArray())
    }

    private fun writeDinf(out: ByteArrayOutputStream) {
        val content = ByteArrayOutputStream()
        // dref box
        val drefContent = ByteArrayOutputStream()
        drefContent.writeUInt32(0)       // version + flags
        drefContent.writeUInt32(1)       // entry_count
        // url entry (self-contained)
        val urlContent = ByteArrayOutputStream()
        urlContent.writeUInt32(1)        // version=0, flags=1 (self-contained)
        writeBox(drefContent, "url ", urlContent.toByteArray())
        writeBox(content, "dref", drefContent.toByteArray())
        writeBox(out, "dinf", content.toByteArray())
    }

    private fun writeStbl(out: ByteArrayOutputStream, sps: ByteArray, pps: ByteArray) {
        val content = ByteArrayOutputStream()
        writeStsd(content, sps, pps)
        writeEmptyStts(content)
        writeEmptyStsc(content)
        writeEmptyStsz(content)
        writeEmptyStco(content)
        writeBox(out, "stbl", content.toByteArray())
    }

    private fun writeStsd(out: ByteArrayOutputStream, sps: ByteArray, pps: ByteArray) {
        val content = ByteArrayOutputStream()
        content.writeUInt32(0)           // version + flags
        content.writeUInt32(1)           // entry_count
        writeAvc1(content, sps, pps)
        writeBox(out, "stsd", content.toByteArray())
    }

    private fun writeAvc1(out: ByteArrayOutputStream, sps: ByteArray, pps: ByteArray) {
        val content = ByteArrayOutputStream()
        content.write(ByteArray(6))      // reserved
        content.writeUInt16(1)           // data_reference_index
        content.write(ByteArray(16))     // pre_defined + reserved
        content.writeUInt16(width)       // width
        content.writeUInt16(height)      // height
        content.writeUInt32(0x00480000)  // horiz_resolution (72 dpi)
        content.writeUInt32(0x00480000)  // vert_resolution (72 dpi)
        content.writeUInt32(0)           // reserved
        content.writeUInt16(1)           // frame_count
        content.write(ByteArray(32))     // compressor_name
        content.writeUInt16(0x0018)      // depth = 24
        content.writeInt16(-1)           // pre_defined = -1
        writeAvcC(content, sps, pps)
        writeBox(out, "avc1", content.toByteArray())
    }

    private fun writeAvcC(out: ByteArrayOutputStream, sps: ByteArray, pps: ByteArray) {
        val content = ByteArrayOutputStream()
        content.write(1)                 // configurationVersion
        content.write(sps[1].toInt())    // AVCProfileIndication
        content.write(sps[2].toInt())    // profile_compatibility
        content.write(sps[3].toInt())    // AVCLevelIndication
        content.write(0xFF)              // lengthSizeMinusOne=3 (4 bytes) | reserved
        content.write(0xE1)              // numOfSequenceParameterSets=1 | reserved
        content.writeUInt16(sps.size)    // SPS length
        content.write(sps)               // SPS data
        content.write(1)                 // numOfPictureParameterSets
        content.writeUInt16(pps.size)    // PPS length
        content.write(pps)               // PPS data
        writeBox(out, "avcC", content.toByteArray())
    }

    private fun writeEmptyStts(out: ByteArrayOutputStream) {
        val content = ByteArrayOutputStream()
        content.writeUInt32(0); content.writeUInt32(0)
        writeBox(out, "stts", content.toByteArray())
    }

    private fun writeEmptyStsc(out: ByteArrayOutputStream) {
        val content = ByteArrayOutputStream()
        content.writeUInt32(0); content.writeUInt32(0)
        writeBox(out, "stsc", content.toByteArray())
    }

    private fun writeEmptyStsz(out: ByteArrayOutputStream) {
        val content = ByteArrayOutputStream()
        content.writeUInt32(0); content.writeUInt32(0); content.writeUInt32(0)
        writeBox(out, "stsz", content.toByteArray())
    }

    private fun writeEmptyStco(out: ByteArrayOutputStream) {
        val content = ByteArrayOutputStream()
        content.writeUInt32(0); content.writeUInt32(0)
        writeBox(out, "stco", content.toByteArray())
    }

    private fun writeMvex(out: ByteArrayOutputStream) {
        val content = ByteArrayOutputStream()
        writeTrex(content)
        writeBox(out, "mvex", content.toByteArray())
    }

    private fun writeTrex(out: ByteArrayOutputStream) {
        val content = ByteArrayOutputStream()
        content.writeUInt32(0)           // version + flags
        content.writeUInt32(1)           // track_ID
        content.writeUInt32(1)           // default_sample_description_index
        content.writeUInt32(0)           // default_sample_duration
        content.writeUInt32(0)           // default_sample_size
        content.writeUInt32(0)           // default_sample_flags
        writeBox(out, "trex", content.toByteArray())
    }

    // ---- Media segment boxes ----

    private fun writeMfhd(out: ByteArrayOutputStream, sequenceNumber: Int) {
        val content = ByteArrayOutputStream()
        content.writeUInt32(0)           // version + flags
        content.writeUInt32(sequenceNumber)
        writeBox(out, "mfhd", content.toByteArray())
    }

    private fun writeTraf(out: ByteArrayOutputStream, frames: List<VideoFrame>, totalDataSize: Int) {
        val content = ByteArrayOutputStream()
        writeTfhd(content)
        writeTfdt(content)
        writeTrun(content, frames, totalDataSize)
        writeBox(out, "traf", content.toByteArray())
    }

    private fun writeTfhd(out: ByteArrayOutputStream) {
        val content = ByteArrayOutputStream()
        content.writeUInt32(0x020000)    // version=0, flags=default-base-is-moof
        content.writeUInt32(1)           // track_ID
        writeBox(out, "tfhd", content.toByteArray())
    }

    private fun writeTfdt(out: ByteArrayOutputStream) {
        val content = ByteArrayOutputStream()
        content.writeUInt32(0x01000000.toInt()) // version=1, flags=0
        content.writeLong(baseDecodeTime)       // baseMediaDecodeTime (64-bit)
        writeBox(out, "tfdt", content.toByteArray())
    }

    private fun writeTrun(out: ByteArrayOutputStream, frames: List<VideoFrame>, totalDataSize: Int) {
        val content = ByteArrayOutputStream()
        // flags: data-offset-present(0x1) | first-sample-flags-present(0x4) |
        //        sample-duration-present(0x100) | sample-size-present(0x200)
        val flags = 0x000305  // data-offset + first-sample-flags + sample-duration + sample-size
        content.writeUInt32(flags)               // version=0, flags
        content.writeUInt32(frames.size)         // sample_count

        // data_offset: placeholder, fixed up in createMediaSegment() after moof size is known
        content.writeUInt32(0)                   // data_offset (patched by createMediaSegment)

        // first sample flags (keyframe vs non-keyframe)
        if (frames.isNotEmpty() && frames[0].isKeyframe) {
            content.writeUInt32(0x02000000)      // depends_on_nothing (sync sample)
        } else {
            content.writeUInt32(0x01010000)      // depends_on_other (non-sync)
        }

        // Per-sample entries
        for (frame in frames) {
            val dur = if (frame.duration > 0) frame.duration else frameDuration
            content.writeUInt32(dur)             // sample_duration
            content.writeUInt32(frame.avccData.size) // sample_size
        }

        baseDecodeTime += frames.sumOf {
            (if (it.duration > 0) it.duration else frameDuration).toLong()
        }

        writeBox(out, "trun", content.toByteArray())
    }

    // ---- Utility ----

    private fun writeBox(out: ByteArrayOutputStream, type: String, content: ByteArray) {
        val size = 8 + content.size
        out.writeUInt32(size)
        out.writeAscii(type)
        out.write(content)
    }
}

// Extension functions for ByteArrayOutputStream
private fun ByteArrayOutputStream.writeUInt32(value: Int) {
    write((value shr 24) and 0xFF)
    write((value shr 16) and 0xFF)
    write((value shr 8) and 0xFF)
    write(value and 0xFF)
}

private fun ByteArrayOutputStream.writeUInt16(value: Int) {
    write((value shr 8) and 0xFF)
    write(value and 0xFF)
}

private fun ByteArrayOutputStream.writeInt16(value: Int) {
    write((value shr 8) and 0xFF)
    write(value and 0xFF)
}

private fun ByteArrayOutputStream.writeLong(value: Long) {
    write(((value shr 56) and 0xFF).toInt())
    write(((value shr 48) and 0xFF).toInt())
    write(((value shr 40) and 0xFF).toInt())
    write(((value shr 32) and 0xFF).toInt())
    write(((value shr 24) and 0xFF).toInt())
    write(((value shr 16) and 0xFF).toInt())
    write(((value shr 8) and 0xFF).toInt())
    write((value and 0xFF).toInt())
}

private fun ByteArrayOutputStream.writeAscii(s: String) {
    write(s.toByteArray(Charsets.US_ASCII))
}
