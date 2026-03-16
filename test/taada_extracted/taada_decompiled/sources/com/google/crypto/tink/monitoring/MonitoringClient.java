package com.google.crypto.tink.monitoring;

import F0.c;

/* JADX INFO: loaded from: classes.dex */
public interface MonitoringClient {

    public interface Logger {
        void log(int i, long j6);

        void logFailure();
    }

    Logger createLogger(c cVar, String str, String str2);
}
