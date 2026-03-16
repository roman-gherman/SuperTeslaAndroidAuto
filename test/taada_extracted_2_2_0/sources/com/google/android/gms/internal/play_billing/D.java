package com.google.android.gms.internal.play_billing;

import java.io.Serializable;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class D extends AbstractC0285i implements Serializable {
    public static final D b;
    public static final D c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient O f2024a;

    static {
        C0329x c0329x = A.b;
        b = new D(O.e);
        Object[] objArr = {M.c};
        for (int i = 0; i < 1; i++) {
            if (objArr[i] == null) {
                throw new NullPointerException(B2.b.c(i, "at index "));
            }
        }
        c = new D(A.i(1, objArr));
    }

    public D(O o6) {
        this.f2024a = o6;
    }

    @Override // com.google.android.gms.internal.play_billing.zzdj
    public final /* bridge */ /* synthetic */ Set zzc() {
        O o6 = this.f2024a;
        return o6.isEmpty() ? V.i : new W(o6, K.c);
    }
}
