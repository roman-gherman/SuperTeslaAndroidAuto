package com.google.android.gms.internal.play_billing;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes.dex */
public final class O0 {
    public static final O0 b;
    public static final O0 c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CancellationException f2047a;

    static {
        if (j2.d) {
            c = null;
            b = null;
        } else {
            c = new O0(null);
            b = new O0(null);
        }
    }

    public O0(CancellationException cancellationException) {
        this.f2047a = cancellationException;
    }
}
