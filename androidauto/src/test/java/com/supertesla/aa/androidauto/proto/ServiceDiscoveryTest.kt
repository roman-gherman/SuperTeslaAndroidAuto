package com.supertesla.aa.androidauto.proto

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ServiceDiscoveryTest {

    // ========== buildMediaSetupResponse ==========

    @Test
    fun `buildMediaSetupResponse field 1 status should be 0 (STATUS_OK)`() {
        // CRITICAL BUG: current code writes 2 instead of 0
        val data = ServiceDiscovery.buildMediaSetupResponse(configIndex = 0, maxUnacked = 1)
        val fields = ProtoEncoder.readFields(data)
        val statusField = fields.first { it.fieldNumber == 1 }
        assertEquals(0L, statusField.varintValue, "Field 1 should be STATUS_OK (0), not 2")
    }

    @Test
    fun `buildMediaSetupResponse includes maxUnacked field`() {
        val data = ServiceDiscovery.buildMediaSetupResponse(maxUnacked = 1)
        val fields = ProtoEncoder.readFields(data)
        val maxUnacked = fields.first { it.fieldNumber == 2 }
        assertEquals(1L, maxUnacked.varintValue)
    }

    @Test
    fun `buildMediaSetupResponse includes configIndex field`() {
        val data = ServiceDiscovery.buildMediaSetupResponse(configIndex = 0)
        val fields = ProtoEncoder.readFields(data)
        val configIdx = fields.first { it.fieldNumber == 3 }
        assertEquals(0L, configIdx.varintValue)
    }

    // ========== ServiceDiscovery Response Shape ==========

    @Test
    fun `buildResponse default includes 6 services`() {
        // Default (includeAudioSinks=false): services 1,2,3,6,4,9
        val data = ServiceDiscovery.buildResponse()
        val services = ProtoEncoder.readFields(data).filter { it.fieldNumber == 1 }
        assertEquals(6, services.size, "Default SD should have 6 services (1,2,3,6,4,9)")
    }

    @Test
    fun `buildResponse with audio sinks includes 8 services`() {
        // includeAudioSinks=true: services 1,2,3,6,7,5,4,9
        val data = ServiceDiscovery.buildResponse(includeAudioSinks = true)
        val services = ProtoEncoder.readFields(data).filter { it.fieldNumber == 1 }
        assertEquals(8, services.size, "SD with audio sinks should have 8 services")
    }

    @Test
    fun `buildResponse service IDs match expected order`() {
        val data = ServiceDiscovery.buildResponse()
        val services = ProtoEncoder.readFields(data).filter { it.fieldNumber == 1 }
        val serviceIds = services.map { svc ->
            val svcFields = ProtoEncoder.readFields(svc.bytesValue!!)
            svcFields.first { it.fieldNumber == 1 }.intValue
        }
        assertEquals(listOf(1, 2, 3, 6, 4, 9), serviceIds, "Service IDs should be [1,2,3,6,4,9]")
    }

    @Test
    fun `buildResponse with audio sinks has correct service IDs`() {
        val data = ServiceDiscovery.buildResponse(includeAudioSinks = true)
        val services = ProtoEncoder.readFields(data).filter { it.fieldNumber == 1 }
        val serviceIds = services.map { svc ->
            val svcFields = ProtoEncoder.readFields(svc.bytesValue!!)
            svcFields.first { it.fieldNumber == 1 }.intValue
        }
        assertEquals(listOf(1, 2, 3, 6, 7, 5, 4, 9), serviceIds)
    }

    @Test
    fun `buildResponse includes HeadUnitInfo in field 17`() {
        val data = ServiceDiscovery.buildResponse()
        val huInfo = ProtoEncoder.readFields(data).firstOrNull { it.fieldNumber == 17 }
        assertNotNull(huInfo, "Field 17 (HeadUnitInfo) should be present")
        val huFields = ProtoEncoder.readFields(huInfo!!.bytesValue!!)
        val make = huFields.first { it.fieldNumber == 1 }.stringValue
        assertEquals("Google", make)
    }

    @Test
    fun `buildResponse sensor service declares 4 sensor types`() {
        val data = ServiceDiscovery.buildResponse()
        val services = ProtoEncoder.readFields(data).filter { it.fieldNumber == 1 }
        // Service 2 is the second service
        val svc2Fields = ProtoEncoder.readFields(services[1].bytesValue!!)
        val sensorSource = svc2Fields.first { it.fieldNumber == 2 } // SensorSourceService
        val sensorFields = ProtoEncoder.readFields(sensorSource.bytesValue!!)
        val sensors = sensorFields.filter { it.fieldNumber == 1 } // repeated Sensor
        assertEquals(4, sensors.size, "Should declare 4 sensors: DRIVING_STATUS, NIGHT, LOCATION, PARKING_BRAKE")

        val sensorTypes = sensors.map { s ->
            ProtoEncoder.readFields(s.bytesValue!!).first { it.fieldNumber == 1 }.intValue
        }
        assertEquals(listOf(13, 10, 1, 7), sensorTypes)
    }

    @Test
    fun `buildResponse video service has H264 BP codec`() {
        val data = ServiceDiscovery.buildResponse()
        val services = ProtoEncoder.readFields(data).filter { it.fieldNumber == 1 }
        // Service 3 is the third service
        val svc3Fields = ProtoEncoder.readFields(services[2].bytesValue!!)
        val mediaSink = svc3Fields.first { it.fieldNumber == 3 } // MediaSinkService
        val sinkFields = ProtoEncoder.readFields(mediaSink.bytesValue!!)
        val availableType = sinkFields.first { it.fieldNumber == 1 }.intValue
        assertEquals(3, availableType, "Video codec should be H264_BP (3)")
    }

    // ========== Helper builders ==========

    @Test
    fun `buildPingResponse echoes timestamp`() {
        val data = ServiceDiscovery.buildPingResponse(123456789L)
        val fields = ProtoEncoder.readFields(data)
        assertEquals(123456789L, fields.first { it.fieldNumber == 1 }.varintValue)
    }

    @Test
    fun `buildAudioFocusResponse with GAIN returns 1`() {
        val data = ServiceDiscovery.buildAudioFocusResponse(1)
        val fields = ProtoEncoder.readFields(data)
        assertEquals(1L, fields.first { it.fieldNumber == 1 }.varintValue)
    }

    @Test
    fun `buildVideoFocusIndication with mode PROJECTED and unsolicited`() {
        val data = ServiceDiscovery.buildVideoFocusIndication(mode = 1, unsolicited = true)
        val fields = ProtoEncoder.readFields(data)
        assertEquals(1L, fields.first { it.fieldNumber == 1 }.varintValue) // PROJECTED
        assertEquals(1L, fields.first { it.fieldNumber == 2 }.varintValue) // unsolicited=true
    }

    @Test
    fun `buildDrivingStatusEvent wraps status in nested message`() {
        val data = ServiceDiscovery.buildDrivingStatusEvent(0)
        val outer = ProtoEncoder.readFields(data)
        assertEquals(1, outer.size)
        assertEquals(1, outer[0].fieldNumber) // event wrapper

        val event = ProtoEncoder.readFields(outer[0].bytesValue!!)
        val sensorType = event.first { it.fieldNumber == 1 }.intValue
        assertEquals(13, sensorType, "Sensor type should be DRIVING_STATUS (13)")

        val drivingStatus = event.first { it.fieldNumber == 4 }
        val dsFields = ProtoEncoder.readFields(drivingStatus.bytesValue!!)
        assertEquals(0L, dsFields.first { it.fieldNumber == 1 }.varintValue, "Status should be UNRESTRICTED (0)")
    }

    @Test
    fun `buildResponse is deterministic`() {
        val a = ServiceDiscovery.buildResponse()
        val b = ServiceDiscovery.buildResponse()
        assertArrayEquals(a, b, "Same inputs should produce identical bytes")
    }
}
