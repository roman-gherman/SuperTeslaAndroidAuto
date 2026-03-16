package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.j2;
import com.google.android.gms.internal.play_billing.k2;
import com.google.android.gms.internal.play_billing.l2;
import com.google.android.gms.internal.play_billing.m2;

/* JADX INFO: loaded from: classes.dex */
public final class B extends O.a implements com.google.android.gms.internal.play_billing.zzax {
    public final k2 b;

    public B(k2 k2Var) {
        super(3);
        attachInterface(this, "com.google.android.apps.play.billingtestcompanion.aidl.IBillingOverrideServiceCallback");
        this.b = k2Var;
    }

    @Override // com.google.android.gms.internal.play_billing.zzax
    public final void zza(int i) {
        Integer numValueOf = Integer.valueOf(i);
        k2 k2Var = this.b;
        k2Var.d = true;
        m2 m2Var = k2Var.b;
        if (m2Var != null) {
            l2 l2Var = m2Var.b;
            l2Var.getClass();
            if (j2.f2094f.u(l2Var, null, numValueOf)) {
                j2.b(l2Var);
                k2Var.f2099a = null;
                k2Var.b = null;
                k2Var.c = null;
            }
        }
    }
}
