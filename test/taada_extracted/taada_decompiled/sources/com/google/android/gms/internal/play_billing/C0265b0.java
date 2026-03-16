package com.google.android.gms.internal.play_billing;

import java.util.concurrent.Executor;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.b0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0265b0 {
    public static final C0265b0 d = new C0265b0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f2070a;
    public final Executor b;
    public C0265b0 c;

    public C0265b0() {
        this.f2070a = null;
        this.b = null;
    }

    public C0265b0(Runnable runnable, Executor executor) {
        this.f2070a = runnable;
        this.b = executor;
    }
}
