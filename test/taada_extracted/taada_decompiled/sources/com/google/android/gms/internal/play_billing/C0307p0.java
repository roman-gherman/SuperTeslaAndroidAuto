package com.google.android.gms.internal.play_billing;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.p0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0307p0 implements zzeu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0315s0 f2111a = new C0315s0(C0307p0.class);

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z6) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        return 0;
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return true;
    }

    public final String toString() {
        Integer num = 0;
        return super.toString() + "[status=SUCCESS, result=[" + num.toString() + "]]";
    }

    @Override // com.google.android.gms.internal.play_billing.zzeu
    public final void zzb(Runnable runnable, Executor executor) {
        if (executor == null) {
            throw new NullPointerException("Executor was null.");
        }
        try {
            executor.execute(runnable);
        } catch (Exception e) {
            f2111a.a().logp(Level.SEVERE, "com.google.common.util.concurrent.ImmediateFuture", "addListener", androidx.constraintlayout.core.motion.a.r("RuntimeException while executing runnable ", runnable.toString(), " with executor ", String.valueOf(executor)), (Throwable) e);
        }
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j6, TimeUnit timeUnit) {
        timeUnit.getClass();
        return 0;
    }
}
