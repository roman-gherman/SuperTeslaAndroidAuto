package com.supertesla.aa

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        System.setProperty("java.net.preferIPv4Stack", "true")
        // Always plant Timber debug tree
        Timber.plant(Timber.DebugTree())
        Log.i("SuperTeslaAA", "App initialized, Timber planted")

        // Quick network diagnostic — runs once at startup to detect Android 16 UID restrictions
        Thread {
            val tag = "NET-TEST"
            Log.i(tag, "=== Network Diagnostic ===")
            Log.i(tag, "UID: ${android.os.Process.myUid()}, PID: ${android.os.Process.myPid()}")
            try {
                val cm = getSystemService(CONNECTIVITY_SERVICE) as android.net.ConnectivityManager
                val net = cm.activeNetwork
                val caps = cm.getNetworkCapabilities(net)
                Log.i(tag, "Active network: $net, caps: $caps")
            } catch (e: Exception) { Log.w(tag, "ConnectivityManager: ${e.message}") }

            // Test 1: DNS
            try {
                val addrs = java.net.InetAddress.getAllByName("google.com")
                Log.i(tag, "DNS google.com: ${addrs.map { it.hostAddress }}")
            } catch (e: Exception) { Log.e(tag, "DNS FAIL: ${e.message}") }

            // Test 2: TCP to Google port 443
            try {
                val sock = java.net.Socket()
                sock.connect(java.net.InetSocketAddress("142.250.185.206", 443), 5000)
                Log.i(tag, "TCP google:443 OK from ${sock.localAddress}")
                sock.close()
            } catch (e: Exception) { Log.e(tag, "TCP google:443 FAIL: ${e.message}") }

            // Test 3: HTTPS
            try {
                val conn = java.net.URL("https://httpbin.org/ip").openConnection() as java.net.HttpURLConnection
                conn.connectTimeout = 5000; conn.readTimeout = 5000
                val body = conn.inputStream.bufferedReader().readText()
                Log.i(tag, "HTTPS httpbin.org: OK - $body")
            } catch (e: Exception) { Log.e(tag, "HTTPS httpbin.org FAIL: ${e.message}") }

            // Test 4: GCP relay
            try {
                val conn = java.net.URL("https://supertesla-relay-289625450505.europe-west1.run.app/health").openConnection() as java.net.HttpURLConnection
                conn.connectTimeout = 5000; conn.readTimeout = 5000
                val body = conn.inputStream.bufferedReader().readText()
                Log.i(tag, "GCP relay: OK - $body")
            } catch (e: Exception) { Log.e(tag, "GCP relay FAIL: ${e.message}") }

            Log.i(tag, "=== End Diagnostic ===")
        }.start()

        // Global uncaught exception handler — ensures crash info is logged
        val defaultHandler = Thread.getDefaultUncaughtExceptionHandler()
        Thread.setDefaultUncaughtExceptionHandler { thread, throwable ->
            Timber.e(throwable, "UNCAUGHT EXCEPTION on ${thread.name}")
            defaultHandler?.uncaughtException(thread, throwable)
        }
    }
}
