package com.google.android.datatransport.runtime.scheduling.persistence;

import p.C0751a;

/* JADX INFO: loaded from: classes.dex */
public interface ClientHealthMetricsStore {
    C0751a loadClientMetrics();

    void recordLogEventDropped(long j6, p.c cVar, String str);

    void resetClientMetrics();
}
