package com.google.android.gms.internal.play_billing;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.z0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0336z0 extends AbstractC0301n0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public zzeu f2137h;
    public ScheduledFuture i;

    @Override // com.google.android.gms.internal.play_billing.AbstractC0286i0
    public final String a() {
        zzeu zzeuVar = this.f2137h;
        ScheduledFuture scheduledFuture = this.i;
        if (zzeuVar == null) {
            return null;
        }
        String strQ = androidx.constraintlayout.core.motion.a.q("inputFuture=[", zzeuVar.toString(), "]");
        if (scheduledFuture == null) {
            return strQ;
        }
        long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
        if (delay <= 0) {
            return strQ;
        }
        return strQ + ", remaining delay=[" + delay + " ms]";
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0286i0
    public final void b() {
        zzeu zzeuVar = this.f2137h;
        if ((zzeuVar != null) & (this.f2083a instanceof Z)) {
            Object obj = this.f2083a;
            zzeuVar.cancel((obj instanceof Z) && ((Z) obj).f2065a);
        }
        ScheduledFuture scheduledFuture = this.i;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.f2137h = null;
        this.i = null;
    }
}
