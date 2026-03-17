package com.supertesla.aa.network.dns

import timber.log.Timber
import java.net.HttpURLConnection
import java.net.URL

/**
 * Updates DuckDNS A record to point to the phone's hotspot IP.
 * This makes supertesla.duckdns.org resolve to the phone's local IP
 * so Tesla's browser can reach the web server via a domain name.
 *
 * Call [update] when the hotspot IP is detected.
 */
object DuckDnsUpdater {

    private const val DUCKDNS_URL = "https://www.duckdns.org/update"

    /**
     * Update DuckDNS record.
     * @param domain subdomain only, e.g. "supertesla" (not "supertesla.duckdns.org")
     * @param token DuckDNS API token
     * @param ip IP address to set (phone's hotspot gateway IP)
     * @return true if update succeeded
     */
    fun update(domain: String, token: String, ip: String): Boolean {
        return try {
            val url = URL("$DUCKDNS_URL?domains=$domain&token=$token&ip=$ip")
            val conn = url.openConnection() as HttpURLConnection
            conn.connectTimeout = 5000
            conn.readTimeout = 5000
            conn.requestMethod = "GET"

            val response = conn.inputStream.bufferedReader().readText().trim()
            conn.disconnect()

            val success = response == "OK"
            if (success) {
                Timber.i("DuckDNS updated: $domain.duckdns.org -> $ip")
            } else {
                Timber.w("DuckDNS update failed: response='$response'")
            }
            success
        } catch (e: Exception) {
            Timber.e(e, "DuckDNS update failed for $domain -> $ip")
            false
        }
    }
}
