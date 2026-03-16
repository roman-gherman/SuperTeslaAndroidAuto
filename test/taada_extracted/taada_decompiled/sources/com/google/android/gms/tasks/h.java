package com.google.android.gms.tasks;

import C0.x;
import D.j;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes.dex */
public final class h extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f2179a = new Object();
    public final f b = new f();
    public boolean c;
    public Object d;
    public Exception e;

    @Override // com.google.android.gms.tasks.b
    public final h a(OnCompleteListener onCompleteListener) {
        e eVar = new e(d.f2175a, onCompleteListener);
        f fVar = this.b;
        synchronized (fVar.f2177a) {
            try {
                if (fVar.b == null) {
                    fVar.b = new ArrayDeque();
                }
                fVar.b.add(eVar);
            } finally {
            }
        }
        synchronized (this.f2179a) {
            try {
                if (!this.c) {
                    return this;
                }
                this.b.a(this);
                return this;
            } finally {
            }
        }
    }

    @Override // com.google.android.gms.tasks.b
    public final Object b() {
        Object obj;
        synchronized (this.f2179a) {
            try {
                j.e(this.c, "Task is not yet complete");
                Exception exc = this.e;
                if (exc != null) {
                    throw new x(exc);
                }
                obj = this.d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }

    @Override // com.google.android.gms.tasks.b
    public final boolean c() {
        boolean z6;
        synchronized (this.f2179a) {
            try {
                z6 = false;
                if (this.c && this.e == null) {
                    z6 = true;
                }
            } finally {
            }
        }
        return z6;
    }

    public final void d() {
        synchronized (this.f2179a) {
            e();
            this.c = true;
            this.d = null;
        }
        this.b.a(this);
    }

    public final void e() {
        boolean z6;
        if (this.c) {
            int i = a.b;
            synchronized (this.f2179a) {
                z6 = this.c;
            }
            if (!z6) {
                throw new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
            }
            synchronized (this.f2179a) {
                Exception exc = this.e;
            }
        }
    }
}
