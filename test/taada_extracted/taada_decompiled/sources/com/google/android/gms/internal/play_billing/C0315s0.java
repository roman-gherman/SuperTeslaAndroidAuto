package com.google.android.gms.internal.play_billing;

import java.util.logging.Logger;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.s0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0315s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0282h f2124a = new C0282h();
    public final String b;
    public volatile Logger c;

    public C0315s0(Class cls) {
        this.b = cls.getName();
    }

    public final Logger a() {
        Logger logger = this.c;
        if (logger != null) {
            return logger;
        }
        synchronized (this.f2124a) {
            try {
                Logger logger2 = this.c;
                if (logger2 != null) {
                    return logger2;
                }
                Logger logger3 = Logger.getLogger(this.b);
                this.c = logger3;
                return logger3;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
