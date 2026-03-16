package com.google.android.datatransport.runtime;

import io.ktor.utils.io.b0;

/* JADX INFO: loaded from: classes.dex */
public final class r implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f1891a;

    public r(Runnable runnable) {
        this.f1891a = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f1891a.run();
        } catch (Exception e) {
            b0.k("Executor", "Background execution failure.", e);
        }
    }
}
