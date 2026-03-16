package com.google.android.gms.tasks;

import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f2177a = new Object();
    public ArrayDeque b;
    public boolean c;

    public final void a(b bVar) {
        zzq zzqVar;
        synchronized (this.f2177a) {
            if (this.b != null && !this.c) {
                this.c = true;
                while (true) {
                    synchronized (this.f2177a) {
                        try {
                            zzqVar = (zzq) this.b.poll();
                            if (zzqVar == null) {
                                this.c = false;
                                return;
                            }
                        } finally {
                        }
                    }
                    zzqVar.zzd(bVar);
                }
            }
        }
    }
}
