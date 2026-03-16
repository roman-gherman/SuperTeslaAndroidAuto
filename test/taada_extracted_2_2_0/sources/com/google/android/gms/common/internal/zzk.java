package com.google.android.gms.common.internal;

import A.h;
import a.AbstractC0132a;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzk> CREATOR = new h(13);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Bundle f1967a;
    public Feature[] b;
    public int c;
    public ConnectionTelemetryConfiguration d;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iS0 = AbstractC0132a.s0(parcel, 20293);
        AbstractC0132a.k0(parcel, 1, this.f1967a);
        AbstractC0132a.q0(parcel, 2, this.b, i);
        AbstractC0132a.u0(parcel, 3, 4);
        parcel.writeInt(this.c);
        AbstractC0132a.m0(parcel, 4, this.d, i);
        AbstractC0132a.t0(parcel, iS0);
    }
}
