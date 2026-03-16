package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public final class Z {
    public static final Z c;
    public static final Z d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f2065a;
    public final RuntimeException b;

    static {
        if (AbstractC0286i0.d) {
            d = null;
            c = null;
        } else {
            d = new Z(false, null);
            c = new Z(true, null);
        }
    }

    public Z(boolean z6, RuntimeException runtimeException) {
        this.f2065a = z6;
        this.b = runtimeException;
    }
}
