package com.google.android.gms.signin.internal;

import Q.h;
import a.AbstractC0132a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zav;

/* JADX INFO: loaded from: classes.dex */
public final class zak extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zak> CREATOR = new h(5);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2172a;
    public final ConnectionResult b;
    public final zav c;

    public zak(int i, ConnectionResult connectionResult, zav zavVar) {
        this.f2172a = i;
        this.b = connectionResult;
        this.c = zavVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iS0 = AbstractC0132a.s0(parcel, 20293);
        AbstractC0132a.u0(parcel, 1, 4);
        parcel.writeInt(this.f2172a);
        AbstractC0132a.m0(parcel, 2, this.b, i);
        AbstractC0132a.m0(parcel, 3, this.c, i);
        AbstractC0132a.t0(parcel, iS0);
    }
}
