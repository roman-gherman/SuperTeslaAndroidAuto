package com.supertesla.aa.androidauto.proto

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream

class ProtoEncoderTest {

    @Test
    fun `writeVarint encodes 0 as single byte`() {
        val out = ByteArrayOutputStream()
        ProtoEncoder.writeVarint(out, 0)
        assertArrayEquals(byteArrayOf(0), out.toByteArray())
    }

    @Test
    fun `writeVarint encodes 150 as two bytes`() {
        val out = ByteArrayOutputStream()
        ProtoEncoder.writeVarint(out, 150)
        // 150 = 0x96 = 10010110 → [10010110, 00000001] = [0x96, 0x01]
        assertArrayEquals(byteArrayOf(0x96.toByte(), 0x01), out.toByteArray())
    }

    @Test
    fun `writeVarintField produces tag plus value`() {
        val out = ByteArrayOutputStream()
        ProtoEncoder.writeVarintField(out, 1, 42)
        val fields = ProtoEncoder.readFields(out.toByteArray())
        assertEquals(1, fields.size)
        assertEquals(1, fields[0].fieldNumber)
        assertEquals(0, fields[0].wireType) // varint
        assertEquals(42L, fields[0].varintValue)
    }

    @Test
    fun `writeStringField roundtrips correctly`() {
        val out = ByteArrayOutputStream()
        ProtoEncoder.writeStringField(out, 3, "hello")
        val fields = ProtoEncoder.readFields(out.toByteArray())
        assertEquals(1, fields.size)
        assertEquals(3, fields[0].fieldNumber)
        assertEquals("hello", fields[0].stringValue)
    }

    @Test
    fun `writeEmbeddedMessage produces nested fields`() {
        val data = ProtoEncoder.encode {
            writeMessage(1) {
                writeVarint(2, 99)
            }
        }
        val outer = ProtoEncoder.readFields(data)
        assertEquals(1, outer.size)
        assertEquals(1, outer[0].fieldNumber)
        assertNotNull(outer[0].bytesValue)

        val inner = ProtoEncoder.readFields(outer[0].bytesValue!!)
        assertEquals(1, inner.size)
        assertEquals(2, inner[0].fieldNumber)
        assertEquals(99L, inner[0].varintValue)
    }

    @Test
    fun `readFields handles multiple fields`() {
        val data = ProtoEncoder.encode {
            writeVarint(1, 10)
            writeVarint(2, 20)
            writeString(3, "test")
        }
        val fields = ProtoEncoder.readFields(data)
        assertEquals(3, fields.size)
        assertEquals(10L, fields[0].varintValue)
        assertEquals(20L, fields[1].varintValue)
        assertEquals("test", fields[2].stringValue)
    }

    @Test
    fun `readFields with empty input returns empty list`() {
        val fields = ProtoEncoder.readFields(byteArrayOf())
        assertTrue(fields.isEmpty())
    }

    @Test
    fun `DSL encode matches manual encode`() {
        val dsl = ProtoEncoder.encode {
            writeVarint(1, 42)
            writeString(2, "hi")
        }
        val manual = ByteArrayOutputStream().apply {
            ProtoEncoder.writeVarintField(this, 1, 42)
            ProtoEncoder.writeStringField(this, 2, "hi")
        }.toByteArray()
        assertArrayEquals(manual, dsl)
    }
}
