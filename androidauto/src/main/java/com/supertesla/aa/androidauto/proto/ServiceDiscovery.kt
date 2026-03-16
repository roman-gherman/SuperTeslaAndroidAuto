package com.supertesla.aa.androidauto.proto

import java.io.ByteArrayOutputStream

/**
 * Builds the Service Discovery Response protobuf.
 *
 * Proto field numbers verified from TaaDa's decompiled proto classes:
 *
 * ServiceDiscoveryResponse:
 *   1=services, 2=make, 3=model, 4=year, 5=vehicle_id, 6=driver_position,
 *   7=hu_make, 8=hu_model, 9=sw_build, 10=sw_version, 11=native_media,
 *   13=session_config, 14=display_name, 15=probe, 16=conn_config, 17=hu_info
 *
 * Service:
 *   1=id, 2=sensor_source, 3=media_sink, 4=input_source, 5=media_source,
 *   6=bluetooth, 7=radio, 8=nav_status, 9=media_playback, 10=phone_status
 *
 * MediaSinkService:
 *   1=available_type, 2=audio_type, 3=audio_configs, 4=video_configs, 7=display_type
 *
 * InputSourceService:
 *   1=keycodes(repeated), 2=touchscreen
 *   Touchscreen: 1=width, 2=height, 3=type
 *
 * SensorSourceService:
 *   1=sensors(repeated)
 *   Sensor: 1=sensor_type
 *
 * MediaSourceService:
 *   1=available_type, 2=audio_config
 */
object ServiceDiscovery {

    data class HeadUnitInfo(
        val make: String = "Google",
        val model: String = "Desktop Head Unit",
        val huMake: String = "Google",
        val huModel: String = "Desktop Head Unit",
        val swBuild: String = "SWB1",
        val swVersion: String = "1.1"
    )

    data class VideoConfig(
        val width: Int = 1280,
        val height: Int = 720,
        val density: Int = 120,
        val fps: Int = 30,
        val marginWidth: Int = 0,
        val marginHeight: Int = 0
    )

    data class AudioConfig(
        val sampleRate: Int = 48000,
        val bitDepth: Int = 16,
        val channelCount: Int = 2
    )

    fun buildResponse(
        huInfo: HeadUnitInfo = HeadUnitInfo(),
        videoConfig: VideoConfig = VideoConfig(),
        mediaAudio: AudioConfig = AudioConfig(sampleRate = 48000, channelCount = 2),
        speechAudio: AudioConfig = AudioConfig(sampleRate = 16000, bitDepth = 16, channelCount = 1),
        systemAudio: AudioConfig = AudioConfig(sampleRate = 16000, bitDepth = 16, channelCount = 1),
        includeAudioSinks: Boolean = true
    ): ByteArray {
        val out = ByteArrayOutputStream()

        // Top-level fields
        ProtoEncoder.writeStringField(out, 2, huInfo.make)         // make
        ProtoEncoder.writeStringField(out, 3, huInfo.model)        // model
        ProtoEncoder.writeStringField(out, 4, "2024")              // year
        ProtoEncoder.writeStringField(out, 5, "SUPERTESLA001")     // vehicle_id
        ProtoEncoder.writeVarintField(out, 6, 1)                   // driver_position=LEFT
        ProtoEncoder.writeStringField(out, 7, huInfo.huMake)       // hu_make
        ProtoEncoder.writeStringField(out, 8, huInfo.huModel)      // hu_model
        ProtoEncoder.writeStringField(out, 9, huInfo.swBuild)      // sw_build
        ProtoEncoder.writeStringField(out, 10, huInfo.swVersion)   // sw_version
        ProtoEncoder.writeVarintField(out, 11, 0)                  // native_media=false

        // === Service 1: InputSourceService (field 4 in Service proto) ===
        ProtoEncoder.writeEmbeddedMessage(out, 1) { svc ->
            ProtoEncoder.writeVarintField(svc, 1, 1) // service id = 1
            // InputSourceService = Service field 4
            ProtoEncoder.writeEmbeddedMessage(svc, 4) { input ->
                // keycodes_supported = field 1 (repeated varint)
                val keycodes = intArrayOf(1, 2, 3, 4, 5, 6, 19, 20, 21, 22, 23, 84, 85, 87, 88)
                for (kc in keycodes) {
                    ProtoEncoder.writeVarintField(input, 1, kc.toLong())
                }
                // touchscreen = field 2
                ProtoEncoder.writeEmbeddedMessage(input, 2) { ts ->
                    ProtoEncoder.writeVarintField(ts, 1, videoConfig.width.toLong())  // width
                    ProtoEncoder.writeVarintField(ts, 2, videoConfig.height.toLong()) // height
                    ProtoEncoder.writeVarintField(ts, 3, 1)                           // type=CAPACITIVE
                }
            }
        }

        // === Service 2: SensorSourceService (field 2 in Service proto) ===
        ProtoEncoder.writeEmbeddedMessage(out, 1) { svc ->
            ProtoEncoder.writeVarintField(svc, 1, 2) // service id = 2
            // SensorSourceService = Service field 2
            ProtoEncoder.writeEmbeddedMessage(svc, 2) { sensor ->
                // sensors = field 1 (repeated embedded Sensor)
                for (sensorType in intArrayOf(11, 10, 1, 12)) { // DRIVING_STATUS, NIGHT, LOCATION, PARKING_BRAKE
                    ProtoEncoder.writeEmbeddedMessage(sensor, 1) { s ->
                        ProtoEncoder.writeVarintField(s, 1, sensorType.toLong()) // sensor_type
                    }
                }
            }
        }

        // === Service 3: MediaSinkService for VIDEO (field 3 in Service proto) ===
        ProtoEncoder.writeEmbeddedMessage(out, 1) { svc ->
            ProtoEncoder.writeVarintField(svc, 1, 3) // service id = 3
            // MediaSinkService = Service field 3
            ProtoEncoder.writeEmbeddedMessage(svc, 3) { sink ->
                ProtoEncoder.writeVarintField(sink, 1, 6)  // available_type = VIDEO_H264_BP (6)
                ProtoEncoder.writeVarintField(sink, 7, 1)  // display_type = MAIN (1)
                // video_configs = field 4
                ProtoEncoder.writeEmbeddedMessage(sink, 4) { vc ->
                    ProtoEncoder.writeVarintField(vc, 1, 1) // codec_resolution
                    ProtoEncoder.writeVarintField(vc, 2, videoConfig.width.toLong())
                    ProtoEncoder.writeVarintField(vc, 3, videoConfig.height.toLong())
                    ProtoEncoder.writeVarintField(vc, 4, videoConfig.fps.toLong())
                    ProtoEncoder.writeVarintField(vc, 5, videoConfig.density.toLong())
                    ProtoEncoder.writeVarintField(vc, 6, videoConfig.marginWidth.toLong())
                    ProtoEncoder.writeVarintField(vc, 7, videoConfig.marginHeight.toLong())
                }
            }
        }

        // === Service 4: MediaSourceService for MIC (field 5 in Service proto) ===
        ProtoEncoder.writeEmbeddedMessage(out, 1) { svc ->
            ProtoEncoder.writeVarintField(svc, 1, 4) // service id = 4
            // MediaSourceService = Service field 5
            ProtoEncoder.writeEmbeddedMessage(svc, 5) { mic ->
                ProtoEncoder.writeVarintField(mic, 1, 1) // available_type = AUDIO_PCM (1)
                // audio_config = field 2
                ProtoEncoder.writeEmbeddedMessage(mic, 2) { ac ->
                    ProtoEncoder.writeVarintField(ac, 1, 16000) // sample_rate
                    ProtoEncoder.writeVarintField(ac, 2, 16)    // bit_depth
                    ProtoEncoder.writeVarintField(ac, 3, 1)     // channels (mono)
                }
            }
        }

        if (includeAudioSinks) {
            // === Service 5: MediaSinkService for MEDIA audio (field 3 in Service) ===
            ProtoEncoder.writeEmbeddedMessage(out, 1) { svc ->
                ProtoEncoder.writeVarintField(svc, 1, 5)
                ProtoEncoder.writeEmbeddedMessage(svc, 3) { sink ->
                    ProtoEncoder.writeVarintField(sink, 1, 1) // AUDIO_PCM
                    ProtoEncoder.writeVarintField(sink, 2, 3) // audio_type = MEDIA
                    // audio_configs = field 3
                    ProtoEncoder.writeEmbeddedMessage(sink, 3) { ac ->
                        ProtoEncoder.writeVarintField(ac, 1, mediaAudio.sampleRate.toLong())
                        ProtoEncoder.writeVarintField(ac, 2, mediaAudio.bitDepth.toLong())
                        ProtoEncoder.writeVarintField(ac, 3, mediaAudio.channelCount.toLong())
                    }
                }
            }

            // === Service 6: MediaSinkService for SYSTEM audio ===
            ProtoEncoder.writeEmbeddedMessage(out, 1) { svc ->
                ProtoEncoder.writeVarintField(svc, 1, 6)
                ProtoEncoder.writeEmbeddedMessage(svc, 3) { sink ->
                    ProtoEncoder.writeVarintField(sink, 1, 1)
                    ProtoEncoder.writeVarintField(sink, 2, 2) // audio_type = SYSTEM
                    ProtoEncoder.writeEmbeddedMessage(sink, 3) { ac ->
                        ProtoEncoder.writeVarintField(ac, 1, systemAudio.sampleRate.toLong())
                        ProtoEncoder.writeVarintField(ac, 2, systemAudio.bitDepth.toLong())
                        ProtoEncoder.writeVarintField(ac, 3, systemAudio.channelCount.toLong())
                    }
                }
            }

            // === Service 7: MediaSinkService for GUIDANCE/SPEECH ===
            ProtoEncoder.writeEmbeddedMessage(out, 1) { svc ->
                ProtoEncoder.writeVarintField(svc, 1, 7)
                ProtoEncoder.writeEmbeddedMessage(svc, 3) { sink ->
                    ProtoEncoder.writeVarintField(sink, 1, 1)
                    ProtoEncoder.writeVarintField(sink, 2, 1) // audio_type = GUIDANCE
                    ProtoEncoder.writeEmbeddedMessage(sink, 3) { ac ->
                        ProtoEncoder.writeVarintField(ac, 1, speechAudio.sampleRate.toLong())
                        ProtoEncoder.writeVarintField(ac, 2, speechAudio.bitDepth.toLong())
                        ProtoEncoder.writeVarintField(ac, 3, speechAudio.channelCount.toLong())
                    }
                }
            }
        }

        // === Service 9: MediaPlaybackService (field 9 in Service proto) ===
        ProtoEncoder.writeEmbeddedMessage(out, 1) { svc ->
            ProtoEncoder.writeVarintField(svc, 1, 9)
            ProtoEncoder.writeEmbeddedMessage(svc, 9) { /* empty */ }
        }

        return out.toByteArray()
    }

    fun buildMediaSetupResponse(configIndex: Int = 0, maxUnacked: Int = 1): ByteArray {
        val out = ByteArrayOutputStream()
        ProtoEncoder.writeVarintField(out, 1, 2)
        ProtoEncoder.writeVarintField(out, 2, maxUnacked.toLong())
        ProtoEncoder.writeVarintField(out, 3, configIndex.toLong())
        return out.toByteArray()
    }

    fun buildAuthComplete(status: Int = 0): ByteArray {
        val out = ByteArrayOutputStream()
        ProtoEncoder.writeVarintField(out, 1, status.toLong())
        return out.toByteArray()
    }

    fun buildSensorStartResponse(status: Int = 0) = buildAuthComplete(status)
    fun buildChannelOpenResponse(status: Int = 0) = buildAuthComplete(status)
    fun buildInputBindingResponse(status: Int = 0) = buildAuthComplete(status)

    fun buildPingResponse(timestamp: Long): ByteArray {
        val out = ByteArrayOutputStream()
        ProtoEncoder.writeVarintField(out, 1, timestamp)
        return out.toByteArray()
    }

    fun buildDrivingStatusEvent(status: Int = 0): ByteArray {
        val out = ByteArrayOutputStream()
        ProtoEncoder.writeEmbeddedMessage(out, 1) { event ->
            ProtoEncoder.writeVarintField(event, 1, 11)
            ProtoEncoder.writeEmbeddedMessage(event, 4) { ds ->
                ProtoEncoder.writeVarintField(ds, 1, status.toLong())
            }
        }
        return out.toByteArray()
    }

    fun buildAudioFocusResponse(focusType: Int = 1): ByteArray {
        val out = ByteArrayOutputStream()
        ProtoEncoder.writeVarintField(out, 1, focusType.toLong())
        return out.toByteArray()
    }

    fun buildVideoFocusIndication(mode: Int = 1, unsolicited: Boolean = true): ByteArray {
        val out = ByteArrayOutputStream()
        ProtoEncoder.writeVarintField(out, 1, mode.toLong())
        ProtoEncoder.writeVarintField(out, 2, if (unsolicited) 1L else 0L)
        return out.toByteArray()
    }

    fun buildNavFocusResponse(focusType: Int = 2): ByteArray {
        val out = ByteArrayOutputStream()
        ProtoEncoder.writeVarintField(out, 1, focusType.toLong())
        return out.toByteArray()
    }
}
