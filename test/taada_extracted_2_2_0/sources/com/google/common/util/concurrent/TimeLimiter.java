package com.google.common.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public interface TimeLimiter {
    <T> T callUninterruptiblyWithTimeout(Callable<T> callable, long j6, TimeUnit timeUnit);

    <T> T callWithTimeout(Callable<T> callable, long j6, TimeUnit timeUnit);

    <T> T newProxy(T t6, Class<T> cls, long j6, TimeUnit timeUnit);

    void runUninterruptiblyWithTimeout(Runnable runnable, long j6, TimeUnit timeUnit);

    void runWithTimeout(Runnable runnable, long j6, TimeUnit timeUnit);
}
