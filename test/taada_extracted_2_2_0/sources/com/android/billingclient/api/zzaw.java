package com.android.billingclient.api;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.google.android.gms.internal.play_billing.AbstractC0263a1;
import com.google.android.gms.internal.play_billing.AbstractC0289j0;

/* JADX INFO: loaded from: classes.dex */
final class zzaw extends ResultReceiver {
    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i, Bundle bundle) {
        Z3.b bVarA = C0257h.a();
        bVarA.f1505a = i;
        if (i == 0) {
            bVarA.a();
            throw null;
        }
        if (bundle == null) {
            C0257h c0257h = H.f1806a;
            throw null;
        }
        bVarA.b = AbstractC0289j0.d(bundle, "BillingClient");
        int i3 = bundle.getInt("INTERNAL_LOG_ERROR_REASON");
        G.c(i3 != 0 ? AbstractC0263a1.l(i3) : 23, 16, bVarA.a(), bundle.getString("INTERNAL_LOG_ERROR_ADDITIONAL_DETAILS"));
        throw null;
    }
}
