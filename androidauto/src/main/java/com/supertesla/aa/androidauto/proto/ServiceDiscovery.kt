package com.supertesla.aa.androidauto.proto

import java.io.ByteArrayOutputStream

/**
 * Builds the Service Discovery Response protobuf that describes
 * this head unit's capabilities to the Android Auto phone app.
 *
 * Service IDs must match TaaDa's exactly:
 *   1 = InputSourceService (touchscreen)
 *   2 = SensorSourceService
 *   3 = MediaSinkService (video H.264)
 *   4 = MediaSourceService (microphone)
 *   5 = MediaSinkService (media audio) — optional
 *   6 = MediaSinkService (system audio) — optional
 *   7 = MediaSinkService (guidance audio) — optional
 *   9 = MediaPlaybackStatusService
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

    /**
     * Build the full Service Discovery Response payload matching TaaDa's format.
     */
    fun buildResponse(
        huInfo: HeadUnitInfo = HeadUnitInfo(),
        videoConfig: VideoConfig = VideoConfig(),
        mediaAudio: AudioConfig = AudioConfig(sampleRate = 48000, channelCount = 2),
        speechAudio: AudioConfig = AudioConfig(sampleRate = 16000, bitDepth = 16, channelCount = 1),
        systemAudio: AudioConfig = AudioConfig(sampleRate = 16000, bitDepth = 16, channelCount = 1),
        includeAudioSinks: Boolean = true
    ): ByteArray {
        val out = ByteArrayOutputStream()

        // HeadUnitInfo (field 9, embedded message)
        ProtoEncoder.writeEmbeddedMessage(out, 9) { hu ->
            ProtoEncoder.writeStringField(hu, 1, huInfo.make)       // make
            ProtoEncoder.writeStringField(hu, 2, huInfo.model)      // model
            ProtoEncoder.writeStringField(hu, 3, huInfo.huMake)     // hu_make
            ProtoEncoder.writeStringField(hu, 4, huInfo.huModel)    // hu_model
            ProtoEncoder.writeStringField(hu, 5, huInfo.swBuild)    // sw_build
            ProtoEncoder.writeStringField(hu, 6, huInfo.swVersion)  // sw_version
        }

        // Driver position: LEFT = 1 (field 10)
        ProtoEncoder.writeVarintField(out, 10, 1)

        // === Service 1: InputSourceService (touchscreen + keycodes) ===
        ProtoEncoder.writeEmbeddedMessage(out, 1) { svc ->
            ProtoEncoder.writeVarintField(svc, 1, 1) // service_id = 1
            ProtoEncoder.writeEmbeddedMessage(svc, 3) { input ->
                // Touchscreen config (field 1)
                ProtoEncoder.writeEmbeddedMessage(input, 1) { ts ->
                    ProtoEncoder.writeVarintField(ts, 1, videoConfig.width.toLong())
                    ProtoEncoder.writeVarintField(ts, 2, videoConfig.height.toLong())
                    ProtoEncoder.writeVarintField(ts, 3, 1) // type = CAPACITIVE
                }
                // Keycodes (field 2, repeated varint)
                val keycodes = intArrayOf(1, 2, 3, 4, 5, 6, 19, 20, 21, 22, 23, 84, 85, 87, 88)
                for (kc in keycodes) {
                    ProtoEncoder.writeVarintField(input, 2, kc.toLong())
                }
            }
        }

        // === Service 2: SensorSourceService ===
        ProtoEncoder.writeEmbeddedMessage(out, 1) { svc ->
            ProtoEncoder.writeVarintField(svc, 1, 2) // service_id = 2
            ProtoEncoder.writeEmbeddedMessage(svc, 2) { sensor ->
                // Supported sensors (field 1, repeated embedded)
                ProtoEncoder.writeEmbeddedMessage(sensor, 1) { s ->
                    ProtoEncoder.writeVarintField(s, 1, 11) // DRIVING_STATUS
                }
                ProtoEncoder.writeEmbeddedMessage(sensor, 1) { s ->
                    ProtoEncoder.writeVarintField(s, 1, 10) // NIGHT_MODE
                }
                ProtoEncoder.writeEmbeddedMessage(sensor, 1) { s ->
                    ProtoEncoder.writeVarintField(s, 1, 1)  // LOCATION
                }
                ProtoEncoder.writeEmbeddedMessage(sensor, 1) { s ->
                    ProtoEncoder.writeVarintField(s, 1, 12) // PARKING_BRAKE
                }
            }
        }

        // === Service 3: MediaSinkService (VIDEO H.264) ===
        ProtoEncoder.writeEmbeddedMessage(out, 1) { svc ->
            ProtoEncoder.writeVarintField(svc, 1, 3) // service_id = 3
            ProtoEncoder.writeEmbeddedMessage(svc, 4) { sink ->
                ProtoEncoder.writeVarintField(sink, 1, 6) // available_type = VIDEO_H264_BP (6)
                ProtoEncoder.writeVarintField(sink, 5, 1) // display_type = MAIN (1)
                // Video config (field 2)
                ProtoEncoder.writeEmbeddedMessage(sink, 2) { vc ->
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

        // === Service 4: MediaSourceService (MIC input) ===
        ProtoEncoder.writeEmbeddedMessage(out, 1) { svc ->
            ProtoEncoder.writeVarintField(svc, 1, 4) // service_id = 4
            ProtoEncoder.writeEmbeddedMessage(svc, 5) { mic ->
                ProtoEncoder.writeVarintField(mic, 2, 1) // available_type = AUDIO_PCM (1)
                ProtoEncoder.writeEmbeddedMessage(mic, 1) { ac ->
                    ProtoEncoder.writeVarintField(ac, 1, 16000) // sample_rate
                    ProtoEncoder.writeVarintField(ac, 2, 16)    // bit_depth
                    ProtoEncoder.writeVarintField(ac, 3, 1)     // channels (mono)
                }
            }
        }

        if (includeAudioSinks) {
            // === Service 5: MediaSinkService (MEDIA audio) ===
            ProtoEncoder.writeEmbeddedMessage(out, 1) { svc ->
                ProtoEncoder.writeVarintField(svc, 1, 5) // service_id = 5
                ProtoEncoder.writeEmbeddedMessage(svc, 4) { sink ->
                    ProtoEncoder.writeVarintField(sink, 1, 1) // available_type = AUDIO_PCM (1)
                    ProtoEncoder.writeVarintField(sink, 3, 3) // audio_type = MEDIA (3)
                    ProtoEncoder.writeEmbeddedMessage(sink, 2) { ac ->
                        ProtoEncoder.writeVarintField(ac, 1, mediaAudio.sampleRate.toLong())
                        ProtoEncoder.writeVarintField(ac, 2, mediaAudio.bitDepth.toLong())
                        ProtoEncoder.writeVarintField(ac, 3, mediaAudio.channelCount.toLong())
                    }
                }
            }

            // === Service 6: MediaSinkService (SYSTEM audio) ===
            ProtoEncoder.writeEmbeddedMessage(out, 1) { svc ->
                ProtoEncoder.writeVarintField(svc, 1, 6) // service_id = 6
                ProtoEncoder.writeEmbeddedMessage(svc, 4) { sink ->
                    ProtoEncoder.writeVarintField(sink, 1, 1) // available_type = AUDIO_PCM
                    ProtoEncoder.writeVarintField(sink, 3, 2) // audio_type = SYSTEM (2)
                    ProtoEncoder.writeEmbeddedMessage(sink, 2) { ac ->
                        ProtoEncoder.writeVarintField(ac, 1, systemAudio.sampleRate.toLong())
                        ProtoEncoder.writeVarintField(ac, 2, systemAudio.bitDepth.toLong())
                        ProtoEncoder.writeVarintField(ac, 3, systemAudio.channelCount.toLong())
                    }
                }
            }

            // === Service 7: MediaSinkService (GUIDANCE/SPEECH audio) ===
            ProtoEncoder.writeEmbeddedMessage(out, 1) { svc ->
                ProtoEncoder.writeVarintField(svc, 1, 7) // service_id = 7
                ProtoEncoder.writeEmbeddedMessage(svc, 4) { sink ->
                    ProtoEncoder.writeVarintField(sink, 1, 1) // available_type = AUDIO_PCM
                    ProtoEncoder.writeVarintField(sink, 3, 1) // audio_type = GUIDANCE/SPEECH (1)
                    ProtoEncoder.writeEmbeddedMessage(sink, 2) { ac ->
                        ProtoEncoder.writeVarintField(ac, 1, speechAudio.sampleRate.toLong())
                        ProtoEncoder.writeVarintField(ac, 2, speechAudio.bitDepth.toLong())
                        ProtoEncoder.writeVarintField(ac, 3, speechAudio.channelCount.toLong())
                    }
                }
            }
        }

        // === Service 9: MediaPlaybackStatusService (empty, just marker) ===
        ProtoEncoder.writeEmbeddedMessage(out, 1) { svc ->
            ProtoEncoder.writeVarintField(svc, 1, 9) // service_id = 9
            // MediaPlaybackStatusService (field 8, empty)
            ProtoEncoder.writeEmbeddedMessage(svc, 8) { /* empty */ }
        }

        return out.toByteArray()
    }

    fun buildMediaSetupResponse(configIndex: Int = 0, maxUnacked: Int = 1): ByteArray {
        val out = ByteArrayOutputStream()
        ProtoEncoder.writeVarintField(out, 1, 2) // status = HEADUNIT
        ProtoEncoder.writeVarintField(out, 2, maxUnacked.toLong())
        ProtoEncoder.writeVarintField(out, 3, configIndex.toLong())
        return out.toByteArray()
    }

    fun buildAuthComplete(status: Int = 0): ByteArray {
        val out = ByteArrayOutputStream()
        ProtoEncoder.writeVarintField(out, 1, status.toLong())
        return out.toByteArray()
    }

    fun buildSensorStartResponse(status: Int = 0): ByteArray {
        val out = ByteArrayOutputStream()
        ProtoEncoder.writeVarintField(out, 1, status.toLong())
        return out.toByteArray()
    }

    fun buildChannelOpenResponse(status: Int = 0): ByteArray {
        val out = ByteArrayOutputStream()
        ProtoEncoder.writeVarintField(out, 1, status.toLong())
        return out.toByteArray()
    }

    fun buildPingResponse(timestamp: Long): ByteArray {
        val out = ByteArrayOutputStream()
        ProtoEncoder.writeVarintField(out, 1, timestamp)
        return out.toByteArray()
    }

    fun buildDrivingStatusEvent(status: Int = 0): ByteArray {
        val out = ByteArrayOutputStream()
        ProtoEncoder.writeEmbeddedMessage(out, 1) { event ->
            ProtoEncoder.writeVarintField(event, 1, 11) // DRIVING_STATUS sensor type
            ProtoEncoder.writeEmbeddedMessage(event, 4) { ds ->
                ProtoEncoder.writeVarintField(ds, 1, status.toLong()) // 0 = UNRESTRICTED
            }
        }
        return out.toByteArray()
    }

    fun buildInputBindingResponse(status: Int = 0): ByteArray {
        val out = ByteArrayOutputStream()
        ProtoEncoder.writeVarintField(out, 1, status.toLong())
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
