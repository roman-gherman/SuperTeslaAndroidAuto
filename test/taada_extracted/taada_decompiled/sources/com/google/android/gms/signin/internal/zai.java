package com.google.android.gms.signin.internal;

import Q.h;
import a.AbstractC0132a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zat;

/* JADX INFO: loaded from: classes.dex */
public final class zai extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zai> CREATOR = new h(4);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2171a;
    public final zat b;

    public zai(int i, zat zatVar) {
        this.f2171a = i;
        this.b = zatVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iS0 = AbstractC0132a.s0(parcel, 20293);
        AbstractC0132a.u0(parcel, 1, 4);
        parcel.writeInt(this.f2171a);
        AbstractC0132a.m0(parcel, 2, this.b, i);
        AbstractC0132a.t0(parcel, iS0);
    }
}
