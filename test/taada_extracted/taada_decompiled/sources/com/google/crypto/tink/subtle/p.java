package com.google.crypto.tink.subtle;

import y0.AbstractC0928a;

/* JADX INFO: loaded from: classes.dex */
public final class p {
    public static final p b = new p(new z.e(4));
    public static final p c = new p(new z.e(5));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EngineFactory$Policy f2966a;

    static {
        new p(new D.d(6, (byte) 0));
        new p(new z5.b(5));
        new p(new z5.b(4));
        new p(new n0.d(5));
        new p(new D.d(5, (byte) 0));
    }

    public p(EngineWrapper engineWrapper) {
        if (AbstractC0928a.a()) {
            this.f2966a = new o(engineWrapper, 2);
        } else if ("The Android Project".equals(System.getProperty("java.vendor"))) {
            this.f2966a = new o(engineWrapper, 0);
        } else {
            this.f2966a = new o(engineWrapper, 1);
        }
    }

    public final Object a(String str) {
        return this.f2966a.getInstance(str);
    }
}
