package com.google.common.util.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public interface Service {
    void addListener(c cVar, Executor executor);

    void awaitRunning();

    void awaitRunning(long j6, TimeUnit timeUnit);

    void awaitTerminated();

    void awaitTerminated(long j6, TimeUnit timeUnit);

    Throwable failureCause();

    boolean isRunning();

    Service startAsync();

    j state();

    Service stopAsync();
}
