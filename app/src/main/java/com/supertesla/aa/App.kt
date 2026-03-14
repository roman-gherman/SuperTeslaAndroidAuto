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
    }
}
