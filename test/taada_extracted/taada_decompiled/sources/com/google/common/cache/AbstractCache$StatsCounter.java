package com.google.common.cache;

/* JADX INFO: loaded from: classes.dex */
public interface AbstractCache$StatsCounter {
    void recordEviction();

    void recordHits(int i);

    void recordLoadException(long j6);

    void recordLoadSuccess(long j6);

    void recordMisses(int i);

    b snapshot();
}
