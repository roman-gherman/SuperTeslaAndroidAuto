package com.google.android.gms.tasks;

import B.o;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class e implements zzq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f2176a;
    public final Object b = new Object();
    public OnCompleteListener c;

    public e(Executor executor, OnCompleteListener onCompleteListener) {
        this.f2176a = executor;
        this.c = onCompleteListener;
    }

    @Override // com.google.android.gms.tasks.zzq
    public final void zzc() {
        synchronized (this.b) {
            this.c = null;
        }
    }

    @Override // com.google.android.gms.tasks.zzq
    public final void zzd(b bVar) {
        synchronized (this.b) {
            try {
                if (this.c == null) {
                    return;
                }
                this.f2176a.execute(new o(1, this, bVar));
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
