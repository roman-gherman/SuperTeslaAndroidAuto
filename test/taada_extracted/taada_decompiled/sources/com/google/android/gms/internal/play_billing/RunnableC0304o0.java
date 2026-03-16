package com.google.android.gms.internal.play_billing;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.o0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0304o0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zzeu f2109a;
    public final com.android.billingclient.api.A b;

    public RunnableC0304o0(zzeu zzeuVar, com.android.billingclient.api.A a6) {
        this.f2109a = zzeuVar;
        this.b = a6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001c  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r4 = this;
            com.google.android.gms.internal.play_billing.zzeu r0 = r4.f2109a
            boolean r1 = r0 instanceof com.google.android.gms.internal.play_billing.C0
            com.android.billingclient.api.A r2 = r4.b
            if (r1 == 0) goto L24
            r1 = r0
            com.google.android.gms.internal.play_billing.C0 r1 = (com.google.android.gms.internal.play_billing.C0) r1
            com.google.android.gms.internal.play_billing.i0 r1 = (com.google.android.gms.internal.play_billing.AbstractC0286i0) r1
            boolean r3 = r1 instanceof com.google.android.gms.internal.play_billing.zzdy$zzh
            if (r3 == 0) goto L1c
            java.lang.Object r1 = r1.f2083a
            boolean r3 = r1 instanceof com.google.android.gms.internal.play_billing.C0262a0
            if (r3 == 0) goto L1c
            com.google.android.gms.internal.play_billing.a0 r1 = (com.google.android.gms.internal.play_billing.C0262a0) r1
            java.lang.Throwable r1 = r1.f2068a
            goto L1d
        L1c:
            r1 = 0
        L1d:
            if (r1 != 0) goto L20
            goto L24
        L20:
            r2.zza(r1)
            return
        L24:
            boolean r1 = r0.isDone()     // Catch: java.lang.Throwable -> L3b java.util.concurrent.ExecutionException -> L3d
            java.lang.String r3 = "Future was expected to be done: %s"
            if (r1 == 0) goto L51
            r1 = 0
        L2d:
            java.lang.Object r0 = r0.get()     // Catch: java.lang.Throwable -> L43 java.lang.InterruptedException -> L4f
            if (r1 == 0) goto L3f
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L3b java.util.concurrent.ExecutionException -> L3d
            r1.interrupt()     // Catch: java.lang.Throwable -> L3b java.util.concurrent.ExecutionException -> L3d
            goto L3f
        L3b:
            r0 = move-exception
            goto L5f
        L3d:
            r0 = move-exception
            goto L63
        L3f:
            r2.zzb(r0)
            return
        L43:
            r0 = move-exception
            if (r1 != 0) goto L47
            goto L4e
        L47:
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L3b java.util.concurrent.ExecutionException -> L3d
            r1.interrupt()     // Catch: java.lang.Throwable -> L3b java.util.concurrent.ExecutionException -> L3d
        L4e:
            throw r0     // Catch: java.lang.Throwable -> L3b java.util.concurrent.ExecutionException -> L3d
        L4f:
            r1 = 1
            goto L2d
        L51:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L3b java.util.concurrent.ExecutionException -> L3d
            java.lang.Object[] r0 = new java.lang.Object[]{r0}     // Catch: java.lang.Throwable -> L3b java.util.concurrent.ExecutionException -> L3d
            java.lang.String r0 = com.google.android.gms.internal.play_billing.AbstractC0263a1.e(r3, r0)     // Catch: java.lang.Throwable -> L3b java.util.concurrent.ExecutionException -> L3d
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L3b java.util.concurrent.ExecutionException -> L3d
            throw r1     // Catch: java.lang.Throwable -> L3b java.util.concurrent.ExecutionException -> L3d
        L5f:
            r2.zza(r0)
            return
        L63:
            java.lang.Throwable r0 = r0.getCause()
            r2.zza(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.RunnableC0304o0.run():void");
    }

    public final String toString() {
        B2.d dVar = new B2.d(RunnableC0304o0.class.getSimpleName());
        C0279g c0279g = new C0279g();
        ((C0279g) dVar.d).b = c0279g;
        dVar.d = c0279g;
        c0279g.f2077a = this.b;
        return dVar.toString();
    }
}
