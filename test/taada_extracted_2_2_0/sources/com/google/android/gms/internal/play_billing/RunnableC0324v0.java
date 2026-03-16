package com.google.android.gms.internal.play_billing;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.v0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0324v0 extends AbstractC0286i0 implements Runnable, zzdy$zzh {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Runnable f2130h;

    public RunnableC0324v0(Runnable runnable) {
        runnable.getClass();
        this.f2130h = runnable;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0286i0
    public final String a() {
        return androidx.constraintlayout.core.motion.a.q("task=[", this.f2130h.toString(), "]");
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f2130h.run();
        } catch (Throwable th) {
            c(th);
            throw th;
        }
    }
}
