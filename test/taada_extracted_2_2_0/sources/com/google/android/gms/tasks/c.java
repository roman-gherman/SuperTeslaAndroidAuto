package com.google.android.gms.tasks;

import D.j;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f2174a = new h();

    public final void a(Exception exc) {
        h hVar = this.f2174a;
        hVar.getClass();
        j.d(exc, "Exception must not be null");
        synchronized (hVar.f2179a) {
            try {
                if (hVar.c) {
                    return;
                }
                hVar.c = true;
                hVar.e = exc;
                hVar.b.a(hVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(Object obj) {
        h hVar = this.f2174a;
        synchronized (hVar.f2179a) {
            try {
                if (hVar.c) {
                    return;
                }
                hVar.c = true;
                hVar.d = obj;
                hVar.b.a(hVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
