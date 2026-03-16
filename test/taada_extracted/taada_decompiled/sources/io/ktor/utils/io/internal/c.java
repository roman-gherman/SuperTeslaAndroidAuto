package io.ktor.utils.io.internal;

import io.ktor.utils.io.e0;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public static final c b = new c(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f3582a;

    public c(Throwable th) {
        this.f3582a = th;
    }

    public final Throwable a() {
        Throwable th = this.f3582a;
        return th == null ? new e0("The channel was closed") : th;
    }

    public final String toString() {
        return "Closed[" + a() + ']';
    }
}
