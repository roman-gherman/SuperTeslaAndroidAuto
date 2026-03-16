package com.google.android.gms.internal.play_billing;

import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class m2 implements zzeu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f2106a;
    public final l2 b = new l2(this);

    public m2(k2 k2Var) {
        this.f2106a = new WeakReference(k2Var);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z6) {
        k2 k2Var = (k2) this.f2106a.get();
        boolean zCancel = this.b.cancel(z6);
        if (!zCancel || k2Var == null) {
            return zCancel;
        }
        k2Var.f2099a = null;
        k2Var.b = null;
        k2Var.c.g(null);
        return true;
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        return this.b.get();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.b.f2096a instanceof O0;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.b.isDone();
    }

    public final String toString() {
        return this.b.toString();
    }

    @Override // com.google.android.gms.internal.play_billing.zzeu
    public final void zzb(Runnable runnable, Executor executor) {
        this.b.zzb(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j6, TimeUnit timeUnit) {
        return this.b.get(j6, timeUnit);
    }
}
