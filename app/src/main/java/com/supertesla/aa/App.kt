package com.supertesla.aa

import android.app.Application
import com.supertesla.aa.core.util.Logger
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Logger.init(BuildConfig.DEBUG)
    }
}
