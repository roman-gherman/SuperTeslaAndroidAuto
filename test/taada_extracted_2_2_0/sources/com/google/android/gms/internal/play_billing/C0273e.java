package com.google.android.gms.internal.play_billing;

import android.os.Parcel;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0273e extends P.a implements zzav {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.play_billing.zzav
    public final void zza(String str, String str2, zzax zzaxVar) {
        Parcel parcelB = b();
        parcelB.writeString(str);
        parcelB.writeString(str2);
        int i = AbstractC0270d.f2074a;
        parcelB.writeStrongBinder(zzaxVar);
        e(parcelB, 1);
    }
}
