package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.J1;
import com.google.android.gms.internal.play_billing.L1;
import com.google.android.gms.internal.play_billing.P1;
import com.google.android.gms.internal.play_billing.Q1;
import com.google.android.gms.internal.play_billing.U;
import com.google.android.gms.internal.play_billing.d2;
import com.google.android.gms.internal.play_billing.e2;

/* JADX INFO: loaded from: classes.dex */
interface zzch {
    public static final /* synthetic */ int zza = 0;

    static {
        U.a(3, new Object[]{"com.android.vending.billing.PURCHASES_UPDATED", Q1.PURCHASES_UPDATED_ACTION, "com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED", Q1.LOCAL_PURCHASES_UPDATED_ACTION, "com.android.vending.billing.ALTERNATIVE_BILLING", Q1.ALTERNATIVE_BILLING_ACTION}, null);
    }

    void zza(J1 j12);

    void zzb(J1 j12, int i);

    void zzc(L1 l12);

    void zzd(L1 l12, int i);

    void zze(P1 p12);

    void zzf(d2 d2Var);

    void zzg(e2 e2Var);
}
