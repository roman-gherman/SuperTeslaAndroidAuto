package com.google.android.gms.common.server.converter;

import A.h;
import a.AbstractC0132a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zac extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zac> CREATOR = new h(24);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1976a;
    public final String b;
    public final int c;

    public zac(int i, int i3, String str) {
        this.f1976a = i;
        this.b = str;
        this.c = i3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iS0 = AbstractC0132a.s0(parcel, 20293);
        AbstractC0132a.u0(parcel, 1, 4);
        parcel.writeInt(this.f1976a);
        AbstractC0132a.n0(parcel, 2, this.b);
        AbstractC0132a.u0(parcel, 3, 4);
        parcel.writeInt(this.c);
        AbstractC0132a.t0(parcel, iS0);
    }

    public zac(String str, int i) {
        this.f1976a = 1;
        this.b = str;
        this.c = i;
    }
}
