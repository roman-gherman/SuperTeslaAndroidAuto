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
        val swBuild: String = "HUR",
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
        includeAudioSinks: Boolean = false
    ): ByteArray {
        val out = ByteArrayOutputStream()

        // HeadUnitInfo (field 17, embedded message) — TaaDa uses this, not top-level fields 2-10
        ProtoEncoder.writeEmbeddedMessage(out, 17) { hu ->
            ProtoEncoder.writeStringField(hu, 1, huInfo.make)       // make
            ProtoEncoder.writeStringField(hu, 2, huInfo.model)      // model
            ProtoEncoder.writeStringField(hu, 5, huInfo.huMake)     // head_unit_make
            ProtoEncoder.writeStringField(hu, 6, huInfo.huModel)    // head_unit_model
            ProtoEncoder.writeStringField(hu, 7, huInfo.swBuild)    // sw_build
            ProtoEncoder.writeStringField(hu, 8, huInfo.swVersion)  // sw_version
        }


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
                for (sensorType in intArrayOf(13, 10, 1, 7)) { // DRIVING_STATUS=13, NIGHT=10, LOCATION=1, PARKING_BRAKE=7
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
                ProtoEncoder.writeVarintField(sink, 1, 3)  // available_type = MEDIA_CODEC_VIDEO_H264_BP (3)
                // display_type = DISPLAY_TYPE_MAIN (0) — proto3 default, omitted
                // video_configs = field 4
                // VideoConfiguration: 1=codec_resolution(enum), 2=frame_rate(enum),
                //   3=width_margin, 4=height_margin, 5=density
                ProtoEncoder.writeEmbeddedMessage(sink, 4) { vc ->
                    // codec_resolution enum: 1=800x480, 2=1280x720, 3=1920x1080, 4=2560x1440, 5=3840x2160
                    val codecRes = when {
                        videoConfig.width <= 800 -> 1
                        videoConfig.width <= 1280 -> 2
                        videoConfig.width <= 1920 -> 3
                        videoConfig.width <= 2560 -> 4
                        else -> 5
                    }
                    ProtoEncoder.writeVarintField(vc, 1, codecRes.toLong()) // codec_resolution
                    ProtoEncoder.writeVarintField(vc, 2, 1) // frame_rate = VIDEO_FPS_24(1)
                    ProtoEncoder.writeVarintField(vc, 3, videoConfig.marginWidth.toLong())  // width_margin
                    ProtoEncoder.writeVarintField(vc, 4, videoConfig.marginHeight.toLong()) // height_margin
                    ProtoEncoder.writeVarintField(vc, 5, videoConfig.density.toLong())      // density
                }
            }
        }

        // === Service 6: MediaSinkService for SYSTEM audio (always included) ===
        // TaaDa order: 1,2,3,6,[7,5],4,9
        ProtoEncoder.writeEmbeddedMessage(out, 1) { svc ->
            ProtoEncoder.writeVarintField(svc, 1, 6)
            ProtoEncoder.writeEmbeddedMessage(svc, 3) { sink ->
                ProtoEncoder.writeVarintField(sink, 1, 1) // AUDIO_PCM
                ProtoEncoder.writeVarintField(sink, 2, 2) // audio_type = SYSTEM
                ProtoEncoder.writeEmbeddedMessage(sink, 3) { ac ->
                    ProtoEncoder.writeVarintField(ac, 1, systemAudio.sampleRate.toLong())
                    ProtoEncoder.writeVarintField(ac, 2, systemAudio.bitDepth.toLong())
                    ProtoEncoder.writeVarintField(ac, 3, systemAudio.channelCount.toLong())
                }
            }
        }

        if (includeAudioSinks) {
            // === Service 7: MediaSinkService for GUIDANCE (optional) ===
            ProtoEncoder.writeEmbeddedMessage(out, 1) { svc ->
                ProtoEncoder.writeVarintField(svc, 1, 7)
                ProtoEncoder.writeEmbeddedMessage(svc, 3) { sink ->
                    ProtoEncoder.writeVarintField(sink, 1, 1)
                    ProtoEncoder.writeVarintField(sink, 2, 1) // GUIDANCE
                    ProtoEncoder.writeEmbeddedMessage(sink, 3) { ac ->
                        ProtoEncoder.writeVarintField(ac, 1, speechAudio.sampleRate.toLong())
                        ProtoEncoder.writeVarintField(ac, 2, speechAudio.bitDepth.toLong())
                        ProtoEncoder.writeVarintField(ac, 3, speechAudio.channelCount.toLong())
                    }
                }
            }

            // === Service 5: MediaSinkService for MEDIA audio (optional) ===
            ProtoEncoder.writeEmbeddedMessage(out, 1) { svc ->
                ProtoEncoder.writeVarintField(svc, 1, 5)
                ProtoEncoder.writeEmbeddedMessage(svc, 3) { sink ->
                    ProtoEncoder.writeVarintField(sink, 1, 1)
                    ProtoEncoder.writeVarintField(sink, 2, 3) // MEDIA
                    ProtoEncoder.writeEmbeddedMessage(sink, 3) { ac ->
                        ProtoEncoder.writeVarintField(ac, 1, mediaAudio.sampleRate.toLong())
                        ProtoEncoder.writeVarintField(ac, 2, mediaAudio.bitDepth.toLong())
                        ProtoEncoder.writeVarintField(ac, 3, mediaAudio.channelCount.toLong())
                    }
                }
            }
        }

        // === Service 4: MediaSourceService for MIC (field 5 in Service proto) ===
        ProtoEncoder.writeEmbeddedMessage(out, 1) { svc ->
            ProtoEncoder.writeVarintField(svc, 1, 4) // service id = 4
            ProtoEncoder.writeEmbeddedMessage(svc, 5) { mic ->
                ProtoEncoder.writeVarintField(mic, 1, 1) // available_type = AUDIO_PCM
                // audio_config = field 2 (singular in MediaSourceService)
                ProtoEncoder.writeEmbeddedMessage(mic, 2) { ac ->
                    ProtoEncoder.writeVarintField(ac, 1, 16000) // sampling_rate
                    ProtoEncoder.writeVarintField(ac, 2, 16)    // number_of_bits
                    ProtoEncoder.writeVarintField(ac, 3, 1)     // number_of_channels
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
        // status field 1: Config.Status enum.
        // TaaDa sends STATUS_READY = 2. AA requires this value to proceed
        // to START_INDICATION. Without status=2, AA never sends START_INDICATION
        // and video never starts. Tested: status=0 → no START_INDICATION,
        // status=2 → AA sends START_INDICATION and video frames flow.
        ProtoEncoder.writeVarintField(out, 1, 2) // STATUS_READY = 2
        ProtoEncoder.writeVarintField(out, 2, maxUnacked.toLong()) // max_unacked = 1
        ProtoEncoder.writeVarintField(out, 3, configIndex.toLong()) // configuration_indices
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
        // SensorBatch proto: field 13 = driving_status_data (repeated DrivingStatusData)
        // DrivingStatusData: field 1 = status (int32)
        // TaaDa: SensorBatch.newBuilder().addDrivingStatusData(DrivingStatusData.newBuilder().setStatus(0))
        val out = ByteArrayOutputStream()
        ProtoEncoder.writeEmbeddedMessage(out, 13) { ds ->
            ProtoEncoder.writeVarintField(ds, 1, status.toLong())
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
