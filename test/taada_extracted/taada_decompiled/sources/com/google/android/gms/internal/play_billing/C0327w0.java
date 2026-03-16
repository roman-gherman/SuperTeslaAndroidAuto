package com.google.android.gms.internal.play_billing;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.w0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0327w0 extends C0318t0 implements zzew {
    public final ScheduledExecutorService b;

    public C0327w0(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        this.b = scheduledExecutorService;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture schedule(Runnable runnable, long j6, TimeUnit timeUnit) {
        B0 b02 = new B0(Executors.callable(runnable, null));
        return new ScheduledFutureC0321u0(b02, this.b.schedule(b02, j6, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* bridge */ /* synthetic */ ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j6, long j7, TimeUnit timeUnit) {
        RunnableC0324v0 runnableC0324v0 = new RunnableC0324v0(runnable);
        return new ScheduledFutureC0321u0(runnableC0324v0, this.b.scheduleAtFixedRate(runnableC0324v0, j6, j7, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* bridge */ /* synthetic */ ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j6, long j7, TimeUnit timeUnit) {
        RunnableC0324v0 runnableC0324v0 = new RunnableC0324v0(runnable);
        return new ScheduledFutureC0321u0(runnableC0324v0, this.b.scheduleWithFixedDelay(runnableC0324v0, j6, j7, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* bridge */ /* synthetic */ ScheduledFuture schedule(Callable callable, long j6, TimeUnit timeUnit) {
        B0 b02 = new B0(callable);
        return new ScheduledFutureC0321u0(b02, this.b.schedule(b02, j6, timeUnit));
    }
}
