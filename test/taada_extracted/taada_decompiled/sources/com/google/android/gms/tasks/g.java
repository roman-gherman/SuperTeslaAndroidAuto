package com.google.android.gms.tasks;

import android.os.Looper;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class g implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final O.e f2178a;

    public g() {
        O.e eVar = new O.e(Looper.getMainLooper());
        Looper.getMainLooper();
        this.f2178a = eVar;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f2178a.post(runnable);
    }
}
