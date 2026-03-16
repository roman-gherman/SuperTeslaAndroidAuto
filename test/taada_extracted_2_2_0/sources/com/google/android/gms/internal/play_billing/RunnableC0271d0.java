package com.google.android.gms.internal.play_billing;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.d0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0271d0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0286i0 f2075a;
    public final zzeu b;

    public RunnableC0271d0(AbstractC0286i0 abstractC0286i0, zzeu zzeuVar) {
        this.f2075a = abstractC0286i0;
        this.b = zzeuVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f2075a.f2083a != this) {
            return;
        }
        zzeu zzeuVar = this.b;
        if (AbstractC0286i0.f2081f.C(this.f2075a, this, AbstractC0286i0.d(zzeuVar))) {
            AbstractC0286i0.g(this.f2075a);
        }
    }
}
