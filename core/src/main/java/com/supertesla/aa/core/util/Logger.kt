package com.supertesla.aa.core.util

import timber.log.Timber

object Logger {
    fun init(debug: Boolean) {
        if (debug) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
