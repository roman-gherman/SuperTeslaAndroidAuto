package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.AbstractC0289j0;
import com.google.android.gms.internal.play_billing.U;

/* JADX INFO: renamed from: com.android.billingclient.api.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0257h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1844a;
    public String b;

    public static Z3.b a() {
        Z3.b bVar = new Z3.b();
        bVar.b = "";
        return bVar;
    }

    public final String toString() {
        int i = this.f1844a;
        int i3 = AbstractC0289j0.f2092a;
        U u = com.google.android.gms.internal.play_billing.J.c;
        Integer numValueOf = Integer.valueOf(i);
        return androidx.constraintlayout.core.motion.a.r("Response Code: ", (!u.containsKey(numValueOf) ? com.google.android.gms.internal.play_billing.J.RESPONSE_CODE_UNSPECIFIED : (com.google.android.gms.internal.play_billing.J) u.get(numValueOf)).toString(), ", Debug Message: ", this.b);
    }
}
