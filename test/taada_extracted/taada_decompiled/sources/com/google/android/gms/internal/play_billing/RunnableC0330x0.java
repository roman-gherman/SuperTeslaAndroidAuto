package com.google.android.gms.internal.play_billing;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.x0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0330x0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C0336z0 f2134a;

    @Override // java.lang.Runnable
    public final void run() {
        zzeu zzeuVar;
        C0262a0 c0262a0;
        C0336z0 c0336z0 = this.f2134a;
        if (c0336z0 == null || (zzeuVar = c0336z0.f2137h) == null) {
            return;
        }
        this.f2134a = null;
        if (zzeuVar.isDone()) {
            Object obj = c0336z0.f2083a;
            if (obj == null) {
                if (zzeuVar.isDone()) {
                    if (AbstractC0286i0.f2081f.C(c0336z0, null, AbstractC0286i0.d(zzeuVar))) {
                        AbstractC0286i0.g(c0336z0);
                        return;
                    }
                    return;
                }
                RunnableC0271d0 runnableC0271d0 = new RunnableC0271d0(c0336z0, zzeuVar);
                if (AbstractC0286i0.f2081f.C(c0336z0, null, runnableC0271d0)) {
                    try {
                        zzeuVar.zzb(runnableC0271d0, EnumC0298m0.f2104a);
                        return;
                    } catch (Throwable th) {
                        try {
                            c0262a0 = new C0262a0(th);
                        } catch (Error | Exception unused) {
                            c0262a0 = C0262a0.b;
                        }
                        AbstractC0286i0.f2081f.C(c0336z0, runnableC0271d0, c0262a0);
                        return;
                    }
                }
                obj = c0336z0.f2083a;
            }
            if (obj instanceof Z) {
                zzeuVar.cancel(((Z) obj).f2065a);
                return;
            }
            return;
        }
        try {
            ScheduledFuture scheduledFuture = c0336z0.i;
            c0336z0.i = null;
            String str = "Timed out";
            if (scheduledFuture != null) {
                try {
                    long jAbs = Math.abs(scheduledFuture.getDelay(TimeUnit.MILLISECONDS));
                    if (jAbs > 10) {
                        str = "Timed out (timeout delayed by " + jAbs + " ms after scheduled time)";
                    }
                } catch (Throwable th2) {
                    c0336z0.c(new C0333y0(str));
                    throw th2;
                }
            }
            c0336z0.c(new C0333y0(str + ": " + zzeuVar.toString()));
        } finally {
            zzeuVar.cancel(true);
        }
    }
}
