package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.o;
import com.google.android.datatransport.runtime.u;
import java.io.Closeable;

/* JADX INFO: loaded from: classes.dex */
public interface EventStore extends Closeable {
    int cleanUp();

    long getNextCallTime(u uVar);

    boolean hasPendingEventsFor(u uVar);

    Iterable<u> loadActiveContexts();

    Iterable<d> loadBatch(u uVar);

    d persist(u uVar, o oVar);

    void recordFailure(Iterable<d> iterable);

    void recordNextCallTime(u uVar, long j6);

    void recordSuccess(Iterable<d> iterable);
}
