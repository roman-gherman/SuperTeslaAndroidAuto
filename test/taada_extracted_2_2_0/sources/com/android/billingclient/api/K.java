package com.android.billingclient.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import com.google.android.gms.internal.play_billing.AbstractC0263a1;
import com.google.android.gms.internal.play_billing.AbstractC0289j0;
import com.google.android.gms.internal.play_billing.C0316s1;
import com.google.android.gms.internal.play_billing.J1;
import com.google.android.gms.internal.play_billing.X0;

/* JADX INFO: loaded from: classes.dex */
public final class K extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1821a;
    public final boolean b;
    public final /* synthetic */ B.p c;

    public K(B.p pVar, boolean z6) {
        this.c = pVar;
        this.b = z6;
    }

    public final synchronized void a(Context context, IntentFilter intentFilter) {
        try {
            if (this.f1821a) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 33) {
                context.registerReceiver(this, intentFilter, true != this.b ? 4 : 2);
            } else {
                context.registerReceiver(this, intentFilter);
            }
            this.f1821a = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void b(Context context) {
        if (!this.f1821a) {
            AbstractC0289j0.f("BillingBroadcastManager", "Receiver is not registered.");
        } else {
            context.unregisterReceiver(this);
            this.f1821a = false;
        }
    }

    public final void c(Bundle bundle, C0257h c0257h, int i) {
        X0 x0O;
        try {
            if (bundle.getByteArray("FAILURE_LOGGING_PAYLOAD") == null) {
                ((I) this.c.d).zza(G.b(23, i, c0257h));
                return;
            }
            I i3 = (I) this.c.d;
            byte[] byteArray = bundle.getByteArray("FAILURE_LOGGING_PAYLOAD");
            X0 x02 = X0.b;
            if (x02 == null) {
                synchronized (X0.class) {
                    try {
                        x0O = X0.b;
                        if (x0O == null) {
                            C0316s1 c0316s1 = C0316s1.c;
                            x0O = AbstractC0263a1.o();
                            X0.b = x0O;
                        }
                    } finally {
                    }
                }
                x02 = x0O;
            }
            i3.zza(J1.m(byteArray, x02));
        } catch (Throwable unused) {
            AbstractC0289j0.f("BillingBroadcastManager", "Failed parsing Api failure.");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0116  */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onReceive(android.content.Context r11, android.content.Intent r12) {
        /*
            Method dump skipped, instruction units count: 289
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.K.onReceive(android.content.Context, android.content.Intent):void");
    }
}
