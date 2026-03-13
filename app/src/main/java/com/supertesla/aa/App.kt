package com.supertesla.aa

import android.app.Application
import com.supertesla.aa.core.util.Logger
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        // Force IPv4 - Netty on some Android devices defaults to IPv6 only
        System.setProperty("java.net.preferIPv4Stack", "true")
        Logger.init(BuildConfig.DEBUG)
    }
}
