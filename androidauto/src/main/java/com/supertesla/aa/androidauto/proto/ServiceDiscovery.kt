package com.supertesla.aa.androidauto.proto

import java.io.ByteArrayOutputStream

/**
 * Builds the Service Discovery Response protobuf that describes
 * this head unit's capabilities to the Android Auto phone app.
 */
object ServiceDiscovery {

    data class HeadUnitInfo(
        val make: String = "SuperTesla",
        val model: String = "Virtual HU",
        val year: String = "2024",
        val vehicleId: String = "SUPERTESLA001",
        val huMake: String = "SuperTesla",
        val huModel: String = "AA Bridge",
        val swBuild: String = "1",
        val swVersion: String = "0.1.0"
    )

    data class VideoConfig(
        val width: Int = 1280,
        val height: Int = 720,
        val density: Int = 160,
        val fps: Int = 30
    )

    data class AudioConfig(
        val sampleRate: Int = 48000,
        val bitDepth: Int = 16,
        val channelCount: Int = 2
    )

    /**
     * Build the full Service Discovery Response payload.
     */
    fun buildResponse(
        huInfo: HeadUnitInfo = HeadUnitInfo(),
        videoConfig: VideoConfig = VideoConfig(),
        mediaAudio: AudioConfig = AudioConfig(sampleRate = 48000, channelCount = 2),
        speechAudio: AudioConfig = AudioConfig(sampleRate = 16000, bitDepth = 16, channelCount = 1),
        systemAudio: AudioConfig = AudioConfig(sampleRate = 16000, bitDepth = 16, channelCount = 1)
    ): ByteArray {
        val out = ByteArrayOutputStream()

        // Field 4: head_unit_name
        ProtoEncoder.writeStringField(out, 4, huInfo.make)
        // Field 5: car_model
        ProtoEncoder.writeStringField(out, 5, huInfo.model)
        // Field 6: car_year
        ProtoEncoder.writeStringField(out, 6, huInfo.year)
        // Field 7: car_serial
        ProtoEncoder.writeStringField(out, 7, huInfo.vehicleId)
        // Field 10: left_hand_drive
        ProtoEncoder.writeVarintField(out, 10, 1)
        // Field 11: headunit_manufacturer
        ProtoEncoder.writeStringField(out, 11, huInfo.huMake)
        // Field 12: headunit_model
        ProtoEncoder.writeStringField(out, 12, huInfo.huModel)
        // Field 13: sw_build
        ProtoEncoder.writeStringField(out, 13, huInfo.swBuild)
        // Field 14: sw_version
        ProtoEncoder.writeStringField(out, 14, huInfo.swVersion)
        // Field 17: can_play_native_media_during_vr
        ProtoEncoder.writeVarintField(out, 17, 0)

        // Services
        // Service: Sensor source (channel 1)
        ProtoEncoder.writeEmbeddedMessage(out, 1) { svc ->
            ProtoEncoder.writeVarintField(svc, 1, ChannelId.SENSOR.toLong())
            // sensor_source_service (field 2)
            ProtoEncoder.writeEmbeddedMessage(svc, 2) { sensor ->
                // supported sensors: DRIVING_STATUS=11, NIGHT_DATA=10, LOCATION=1
                ProtoEncoder.writeEmbeddedMessage(sensor, 1) { s -> ProtoEncoder.writeVarintField(s, 1, 11) }
                ProtoEncoder.writeEmbeddedMessage(sensor, 1) { s -> ProtoEncoder.writeVarintField(s, 1, 10) }
                ProtoEncoder.writeEmbeddedMessage(sensor, 1) { s -> ProtoEncoder.writeVarintField(s, 1, 1) }
            }
        }

        // Service: Video sink (channel 2)
        ProtoEncoder.writeEmbeddedMessage(out, 1) { svc ->
            ProtoEncoder.writeVarintField(svc, 1, ChannelId.VIDEO.toLong())
            // media_sink_service (field 4)
            ProtoEncoder.writeEmbeddedMessage(svc, 4) { sink ->
                ProtoEncoder.writeVarintField(sink, 1, 3) // available_type = VIDEO
                // video_configs (field 2)
                ProtoEncoder.writeEmbeddedMessage(sink, 2) { vc ->
                    ProtoEncoder.writeVarintField(vc, 1, 1) // codec_resolution = 1
                    ProtoEncoder.writeVarintField(vc, 2, videoConfig.width.toLong())
                    ProtoEncoder.writeVarintField(vc, 3, videoConfig.height.toLong())
                    ProtoEncoder.writeVarintField(vc, 4, videoConfig.fps.toLong())
                    ProtoEncoder.writeVarintField(vc, 5, videoConfig.density.toLong())
                }
            }
        }

        // Service: Input source (channel 3)
        ProtoEncoder.writeEmbeddedMessage(out, 1) { svc ->
            ProtoEncoder.writeVarintField(svc, 1, ChannelId.INPUT.toLong())
            // input_source_service (field 3)
            ProtoEncoder.writeEmbeddedMessage(svc, 3) { input ->
                // touchscreen (field 1)
                ProtoEncoder.writeEmbeddedMessage(input, 1) { ts ->
                    ProtoEncoder.writeVarintField(ts, 1, videoConfig.width.toLong())
                    ProtoEncoder.writeVarintField(ts, 2, videoConfig.height.toLong())
                }
            }
        }

        // Service: Audio speech sink (channel 4)
        ProtoEncoder.writeEmbeddedMessage(out, 1) { svc ->
            ProtoEncoder.writeVarintField(svc, 1, ChannelId.AUDIO_SPEECH.toLong())
            ProtoEncoder.writeEmbeddedMessage(svc, 4) { sink ->
                ProtoEncoder.writeVarintField(sink, 1, 1) // available_type = AUDIO
                ProtoEncoder.writeVarintField(sink, 3, 1) // audio_type = SPEECH
                ProtoEncoder.writeEmbeddedMessage(sink, 2) { ac ->
                    ProtoEncoder.writeVarintField(ac, 1, speechAudio.sampleRate.toLong())
                    ProtoEncoder.writeVarintField(ac, 2, speechAudio.bitDepth.toLong())
                    ProtoEncoder.writeVarintField(ac, 3, speechAudio.channelCount.toLong())
                }
            }
        }

        // Service: Audio system sink (channel 5)
        ProtoEncoder.writeEmbeddedMessage(out, 1) { svc ->
            ProtoEncoder.writeVarintField(svc, 1, ChannelId.AUDIO_SYSTEM.toLong())
            ProtoEncoder.writeEmbeddedMessage(svc, 4) { sink ->
                ProtoEncoder.writeVarintField(sink, 1, 1)
                ProtoEncoder.writeVarintField(sink, 3, 2) // audio_type = SYSTEM
                ProtoEncoder.writeEmbeddedMessage(sink, 2) { ac ->
                    ProtoEncoder.writeVarintField(ac, 1, systemAudio.sampleRate.toLong())
                    ProtoEncoder.writeVarintField(ac, 2, systemAudio.bitDepth.toLong())
                    ProtoEncoder.writeVarintField(ac, 3, systemAudio.channelCount.toLong())
                }
            }
        }

        // Service: Audio media sink (channel 6)
        ProtoEncoder.writeEmbeddedMessage(out, 1) { svc ->
            ProtoEncoder.writeVarintField(svc, 1, ChannelId.AUDIO_MEDIA.toLong())
            ProtoEncoder.writeEmbeddedMessage(svc, 4) { sink ->
                ProtoEncoder.writeVarintField(sink, 1, 1)
                ProtoEncoder.writeVarintField(sink, 3, 3) // audio_type = MEDIA
                ProtoEncoder.writeEmbeddedMessage(sink, 2) { ac ->
                    ProtoEncoder.writeVarintField(ac, 1, mediaAudio.sampleRate.toLong())
                    ProtoEncoder.writeVarintField(ac, 2, mediaAudio.bitDepth.toLong())
                    ProtoEncoder.writeVarintField(ac, 3, mediaAudio.channelCount.toLong())
                }
            }
        }

        // Service: Mic input source (channel 7)
        ProtoEncoder.writeEmbeddedMessage(out, 1) { svc ->
            ProtoEncoder.writeVarintField(svc, 1, ChannelId.MIC.toLong())
            ProtoEncoder.writeEmbeddedMessage(svc, 5) { mic ->
                ProtoEncoder.writeEmbeddedMessage(mic, 1) { ac ->
                    ProtoEncoder.writeVarintField(ac, 1, 16000)
                    ProtoEncoder.writeVarintField(ac, 2, 16)
                    ProtoEncoder.writeVarintField(ac, 3, 1)
                }
            }
        }

        return out.toByteArray()
    }

    /**
     * Build the media config response (setup response) for a video/audio channel.
     */
    fun buildMediaSetupResponse(configIndex: Int = 0, maxUnacked: Int = 1): ByteArray {
        val out = ByteArrayOutputStream()
        ProtoEncoder.writeVarintField(out, 1, 2) // status = HEADUNIT
        ProtoEncoder.writeVarintField(out, 2, maxUnacked.toLong())
        ProtoEncoder.writeVarintField(out, 3, configIndex.toLong())
        return out.toByteArray()
    }

    /**
     * Build auth complete message payload.
     */
    fun buildAuthComplete(status: Int = 0): ByteArray {
        val out = ByteArrayOutputStream()
        ProtoEncoder.writeVarintField(out, 1, status.toLong())
        return out.toByteArray()
    }

    /**
     * Build sensor start response payload.
     */
    fun buildSensorStartResponse(status: Int = 0): ByteArray {
        val out = ByteArrayOutputStream()
        ProtoEncoder.writeVarintField(out, 1, status.toLong())
        return out.toByteArray()
    }

    /**
     * Build channel open response payload.
     */
    fun buildChannelOpenResponse(status: Int = 0): ByteArray {
        val out = ByteArrayOutputStream()
        ProtoEncoder.writeVarintField(out, 1, status.toLong())
        return out.toByteArray()
    }

    /**
     * Build ping response payload.
     */
    fun buildPingResponse(timestamp: Long): ByteArray {
        val out = ByteArrayOutputStream()
        ProtoEncoder.writeVarintField(out, 1, timestamp)
        return out.toByteArray()
    }

    /**
     * Build driving status sensor event (UNRESTRICTED).
     */
    fun buildDrivingStatusEvent(status: Int = 0): ByteArray {
        val out = ByteArrayOutputStream()
        // sensor event with driving_status
        ProtoEncoder.writeEmbeddedMessage(out, 1) { event ->
            ProtoEncoder.writeVarintField(event, 1, 11) // DRIVING_STATUS sensor type
            ProtoEncoder.writeEmbeddedMessage(event, 4) { ds ->
                ProtoEncoder.writeVarintField(ds, 1, status.toLong()) // 0 = UNRESTRICTED
            }
        }
        return out.toByteArray()
    }

    /**
     * Build input binding response.
     */
    fun buildInputBindingResponse(status: Int = 0): ByteArray {
        val out = ByteArrayOutputStream()
        ProtoEncoder.writeVarintField(out, 1, status.toLong())
        return out.toByteArray()
    }

    /**
     * Build audio focus response.
     */
    fun buildAudioFocusResponse(focusType: Int = 1): ByteArray {
        val out = ByteArrayOutputStream()
        ProtoEncoder.writeVarintField(out, 1, focusType.toLong())
        return out.toByteArray()
    }

    /**
     * Build video focus indication.
     */
    fun buildVideoFocusIndication(mode: Int = 1, unsolicited: Boolean = true): ByteArray {
        val out = ByteArrayOutputStream()
        ProtoEncoder.writeVarintField(out, 1, mode.toLong()) // FOCUSED = 1
        ProtoEncoder.writeVarintField(out, 2, if (unsolicited) 1L else 0L)
        return out.toByteArray()
    }

    /**
     * Build navigation focus response.
     */
    fun buildNavFocusResponse(focusType: Int = 2): ByteArray {
        val out = ByteArrayOutputStream()
        ProtoEncoder.writeVarintField(out, 1, focusType.toLong())
        return out.toByteArray()
    }
}
