package com.supertesla.aa.androidauto.channels

import com.supertesla.aa.androidauto.proto.ChannelId
import com.supertesla.aa.androidauto.proto.ProtoEncoder
import com.supertesla.aa.androidauto.proto.SensorMessageType
import com.supertesla.aa.androidauto.proto.ServiceDiscovery
import com.supertesla.aa.androidauto.protocol.AapFramer
import com.supertesla.aa.androidauto.protocol.ChannelHandler
import com.supertesla.aa.androidauto.protocol.ChannelMux
import timber.log.Timber

/**
 * Handles sensor channel (channel 1).
 * Responds to sensor start requests and sends driving status events.
 */
class SensorChannelHandler(
    private val mux: ChannelMux
) : ChannelHandler {

    override suspend fun onFrame(frame: AapFramer.AapFrame) {
        val msgType = frame.messageType
        val body = frame.messageBody

        when (msgType) {
            SensorMessageType.START_REQUEST -> {
                Timber.i("Sensor: received StartRequest")
                val fields = ProtoEncoder.readFields(body)
                val sensorType = fields.firstOrNull { it.fieldNumber == 1 }?.intValue ?: -1
                Timber.d("Sensor: requested sensor type = $sensorType")

                val response = ServiceDiscovery.buildSensorStartResponse(status = 0)
                mux.sendEncryptedControl(ChannelId.SENSOR, SensorMessageType.START_RESPONSE, response)
                Timber.i("Sensor: sent StartResponse OK")

                // If driving status requested, immediately send UNRESTRICTED
                if (sensorType == 11) {
                    sendDrivingStatus()
                }
            }

            else -> {
                Timber.v("Sensor: unhandled msgType=0x${msgType.toString(16)}")
            }
        }
    }

    /**
     * Send driving status = UNRESTRICTED so AA shows full UI.
     */
    fun sendDrivingStatus(status: Int = 0) {
        val payload = ServiceDiscovery.buildDrivingStatusEvent(status)
        mux.sendEncrypted(ChannelId.SENSOR, SensorMessageType.EVENT_INDICATION, payload)
        Timber.d("Sensor: sent DrivingStatus = $status (UNRESTRICTED)")
    }
}
