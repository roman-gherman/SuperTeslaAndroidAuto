package com.supertesla.aa.cleanup

import com.supertesla.aa.core.config.AppConfig
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * Verifies AppConfig constants are correct after cleanup.
 */
class AppConfigTest {

    @Test
    fun `SERVER_PORT should be 8080`() {
        assertEquals(8080, AppConfig.SERVER_PORT)
    }

    @Test
    fun `DEFAULT_VIRTUAL_IP should be non-RFC1918 routable address`() {
        assertEquals("51.75.29.16", AppConfig.DEFAULT_VIRTUAL_IP)
    }

    @Test
    fun `SERVER_PORT_HTTP should not exist`() {
        // This test passes only when SERVER_PORT_HTTP has been removed from AppConfig.
        // We verify by checking the class has no field named SERVER_PORT_HTTP.
        val fields = AppConfig::class.java.declaredFields.map { it.name }
        assert("SERVER_PORT_HTTP" !in fields) {
            "AppConfig.SERVER_PORT_HTTP should be removed (unused constant)"
        }
    }
}
