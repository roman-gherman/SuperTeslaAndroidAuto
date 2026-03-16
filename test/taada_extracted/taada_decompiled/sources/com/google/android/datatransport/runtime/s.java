package com.google.android.datatransport.runtime;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class s implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f1892a;

    public s(ExecutorService executorService) {
        this.f1892a = executorService;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f1892a.execute(new r(runnable));
    }
}
