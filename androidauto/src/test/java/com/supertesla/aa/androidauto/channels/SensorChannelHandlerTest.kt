package com.supertesla.aa.androidauto.channels

import com.supertesla.aa.androidauto.proto.ChannelId
import com.supertesla.aa.androidauto.proto.ProtoEncoder
import com.supertesla.aa.androidauto.proto.SensorMessageType
import com.supertesla.aa.androidauto.protocol.AapFramer
import com.supertesla.aa.androidauto.protocol.ChannelMux
import io.mockk.*
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class SensorChannelHandlerTest {

    private lateinit var mux: ChannelMux
    private lateinit var handler: SensorChannelHandler

    @BeforeEach
    fun setUp() {
        mux = mockk(relaxed = true)
        handler = SensorChannelHandler(mux)
    }

    // ===== START_REQUEST always sends StartResponse =====

    @Test
    fun `START_REQUEST sends StartResponse on control channel`() = runTest {
        val body = ProtoEncoder.encode { writeVarint(1, 13) } // DRIVING_STATUS
        handler.onFrame(buildSensorFrame(SensorMessageType.START_REQUEST, body))

        verify {
            mux.sendEncryptedControl(ChannelId.SENSOR, SensorMessageType.START_RESPONSE, any())
        }
    }

    // ===== DRIVING_STATUS (sensorType 13) =====

    @Test
    fun `sensorType 13 triggers sendDrivingStatus`() = runTest {
        val body = ProtoEncoder.encode { writeVarint(1, 13) }
        handler.onFrame(buildSensorFrame(SensorMessageType.START_REQUEST, body))

        verify {
            mux.sendEncrypted(ChannelId.SENSOR, SensorMessageType.EVENT_INDICATION, any())
        }
    }

    @Test
    fun `sendDrivingStatus encodes sensor type 13 with UNRESTRICTED`() {
        handler.sendDrivingStatus(0)

        val slot = slot<ByteArray>()
        verify { mux.sendEncrypted(ChannelId.SENSOR, SensorMessageType.EVENT_INDICATION, capture(slot)) }

        val outer = ProtoEncoder.readFields(slot.captured)
        val event = ProtoEncoder.readFields(outer[0].bytesValue!!)
        val sType = event.first { it.fieldNumber == 1 }.intValue
        assertEquals(13, sType, "Sensor type should be DRIVING_STATUS (13)")
    }

    // ===== PARKING_BRAKE (sensorType 7) =====

    @Test
    fun `sensorType 7 triggers sendParkingBrake`() = runTest {
        val body = ProtoEncoder.encode { writeVarint(1, 7) }
        handler.onFrame(buildSensorFrame(SensorMessageType.START_REQUEST, body))

        // Should send two messages: StartResponse + ParkingBrake event
        verify(atLeast = 1) {
            mux.sendEncrypted(ChannelId.SENSOR, SensorMessageType.EVENT_INDICATION, any())
        }
    }

    @Test
    fun `sendParkingBrake encodes sensor type 7 with engaged=true`() {
        handler.sendParkingBrake(true)

        val slot = slot<ByteArray>()
        verify { mux.sendEncrypted(ChannelId.SENSOR, SensorMessageType.EVENT_INDICATION, capture(slot)) }

        val outer = ProtoEncoder.readFields(slot.captured)
        val event = ProtoEncoder.readFields(outer[0].bytesValue!!)
        val sType = event.first { it.fieldNumber == 1 }.intValue
        assertEquals(7, sType, "Sensor type should be PARKING_BRAKE (7)")
    }

    // ===== NIGHT_MODE (sensorType 10) =====

    @Test
    fun `sendNightMode encodes sensor type 10`() {
        handler.sendNightMode(true)

        val slot = slot<ByteArray>()
        verify { mux.sendEncrypted(ChannelId.SENSOR, SensorMessageType.EVENT_INDICATION, capture(slot)) }

        val outer = ProtoEncoder.readFields(slot.captured)
        val event = ProtoEncoder.readFields(outer[0].bytesValue!!)
        val sType = event.first { it.fieldNumber == 1 }.intValue
        assertEquals(10, sType, "Sensor type should be NIGHT_MODE (10)")
    }

    // ===== LOCATION (sensorType 1) =====

    @Test
    fun `sendLocation encodes lat lon with E7 scaling`() {
        handler.sendLocation(lat = 51.5, lon = -0.1, accuracy = 10f, altitude = 100.0, heading = 90f, speed = 30f)

        val slot = slot<ByteArray>()
        verify { mux.sendEncrypted(ChannelId.SENSOR, SensorMessageType.EVENT_INDICATION, capture(slot)) }

        val outer = ProtoEncoder.readFields(slot.captured)
        val event = ProtoEncoder.readFields(outer[0].bytesValue!!)
        val sType = event.first { it.fieldNumber == 1 }.intValue
        assertEquals(1, sType, "Sensor type should be LOCATION (1)")

        val locationMsg = event.first { it.fieldNumber == 2 }
        val locFields = ProtoEncoder.readFields(locationMsg.bytesValue!!)

        val latE7 = locFields.first { it.fieldNumber == 1 }.varintValue
        val lonE7 = locFields.first { it.fieldNumber == 2 }.varintValue
        assertEquals(515000000L, latE7, "lat * 1e7")
        assertEquals(-1000000L, lonE7, "lon * 1e7")
    }

    // ===== Unknown sensor type =====

    @Test
    fun `unknown sensorType does not send event`() = runTest {
        val body = ProtoEncoder.encode { writeVarint(1, 999) }
        handler.onFrame(buildSensorFrame(SensorMessageType.START_REQUEST, body))

        // Should only send StartResponse, not EVENT_INDICATION
        verify(exactly = 0) {
            mux.sendEncrypted(ChannelId.SENSOR, SensorMessageType.EVENT_INDICATION, any())
        }
    }

    // ===== Helper =====

    private fun buildSensorFrame(messageType: Int, body: ByteArray): AapFramer.AapFrame {
        val msgTypeHi = (messageType shr 8).toByte()
        val msgTypeLo = (messageType and 0xFF).toByte()
        val payload = byteArrayOf(msgTypeHi, msgTypeLo) + body
        return AapFramer.AapFrame(
            channel = ChannelId.SENSOR,
            flags = AapFramer.FLAG_BULK,
            payload = payload
        )
    }
}
