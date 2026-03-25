package com.supertesla.aa.androidauto.channels

import com.supertesla.aa.androidauto.proto.ChannelId
import com.supertesla.aa.androidauto.proto.ProtoEncoder
import com.supertesla.aa.androidauto.proto.SensorMessageType
import com.supertesla.aa.androidauto.proto.ServiceDiscovery
import com.supertesla.aa.androidauto.protocol.AapFramer
import com.supertesla.aa.androidauto.protocol.ChannelHandler
import com.supertesla.aa.androidauto.protocol.ChannelMux
import timber.log.Timber
import java.io.ByteArrayOutputStream

/**
 * Handles sensor channel (channel 2).
 * Responds to sensor start requests and sends sensor events.
 *
 * Supported sensors:
 * - DRIVING_STATUS (13): Always UNRESTRICTED
 * - PARKING_BRAKE (7): Always engaged (parked)
 * - NIGHT_MODE (10): Forwarded from browser
 * - LOCATION (1): Forwarded from browser GPS
 */
class SensorChannelHandler(
    private val mux: ChannelMux
) : ChannelHandler {

    /** Callbacks for browser-forwarded sensor data */
    var onNightModeRequested: (() -> Unit)? = null
    var onLocationRequested: (() -> Unit)? = null

    override suspend fun onFrame(frame: AapFramer.AapFrame) {
        val msgType = frame.messageType
        val body = frame.messageBody

        when (msgType) {
            SensorMessageType.START_REQUEST -> {
                Timber.i("Sensor: received StartRequest")
                val fields = ProtoEncoder.readFields(body)
                val sensorType = fields.firstOrNull { it.fieldNumber == 1 }?.intValue ?: -1
                Timber.d("Sensor: requested sensor type = $sensorType")

                // Always send StartResponse first
                val response = ServiceDiscovery.buildSensorStartResponse(status = 0)
                mux.sendEncryptedControl(ChannelId.SENSOR, SensorMessageType.START_RESPONSE, response)
                Timber.i("Sensor: sent StartResponse OK")

                // Then send immediate data for certain sensor types
                when (sensorType) {
                    13 -> sendDrivingStatus()      // DRIVING_STATUS → UNRESTRICTED
                    7  -> sendParkingBrake(true)    // PARKING_BRAKE → always parked
                    10 -> {
                        sendNightMode(false)        // Default to day mode
                        onNightModeRequested?.invoke()
                    }
                    1  -> onLocationRequested?.invoke()    // LOCATION → browser will send GPS
                }
            }

            else -> {
                Timber.v("Sensor: unhandled msgType=0x${msgType.toString(16)}")
            }
        }
    }

    /** Send driving status = UNRESTRICTED so AA shows full UI. */
    fun sendDrivingStatus(status: Int = 0) {
        val payload = ServiceDiscovery.buildDrivingStatusEvent(status)
        mux.sendEncrypted(ChannelId.SENSOR, SensorMessageType.EVENT_INDICATION, payload)
        Timber.d("Sensor: sent DrivingStatus = $status")
    }

    /** Send parking brake status. TaaDa always sends true (parked). */
    fun sendParkingBrake(engaged: Boolean) {
        val payload = ProtoEncoder.encode {
            writeMessage(1) {
                writeVarint(1, 7) // SENSOR_PARKING_BRAKE
                writeMessage(7) {
                    writeVarint(1, if (engaged) 1L else 0L)
                }
            }
        }
        mux.sendEncrypted(ChannelId.SENSOR, SensorMessageType.EVENT_INDICATION, payload)
        Timber.d("Sensor: sent ParkingBrake = $engaged")
    }

    /** Send night mode. Forwarded from Tesla browser. */
    fun sendNightMode(isNight: Boolean) {
        val payload = ProtoEncoder.encode {
            writeMessage(1) {
                writeVarint(1, 10) // SENSOR_NIGHT_MODE
                writeMessage(3) {
                    writeVarint(1, if (isNight) 1L else 0L)
                }
            }
        }
        mux.sendEncrypted(ChannelId.SENSOR, SensorMessageType.EVENT_INDICATION, payload)
        Timber.d("Sensor: sent NightMode = $isNight")
    }

    /** Send GPS location. Forwarded from Tesla browser. */
    fun sendLocation(
        lat: Double, lon: Double, accuracy: Float,
        altitude: Double, heading: Float, speed: Float
    ) {
        val payload = ProtoEncoder.encode {
            writeMessage(1) {
                writeVarint(1, 1) // SENSOR_LOCATION
                writeMessage(2) {
                    writeVarint(1, (lat * 1e7).toLong())       // latitudeE7
                    writeVarint(2, (lon * 1e7).toLong())       // longitudeE7
                    writeVarint(3, (accuracy * 1000).toLong()) // accuracyE3
                    writeVarint(4, (altitude * 100).toLong())  // altitudeE2
                    writeVarint(5, (heading * 1e6).toLong())   // bearingE6
                    writeVarint(6, (speed * 100).toLong())     // speedE3
                }
            }
        }
        mux.sendEncrypted(ChannelId.SENSOR, SensorMessageType.EVENT_INDICATION, payload)
        Timber.d("Sensor: sent Location lat=$lat lon=$lon")
    }
}
