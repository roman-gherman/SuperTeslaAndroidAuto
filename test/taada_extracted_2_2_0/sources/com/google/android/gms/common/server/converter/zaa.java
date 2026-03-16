package com.google.android.gms.common.server.converter;

import A.h;
import a.AbstractC0132a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zaa extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zaa> CREATOR = new h(22);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1975a;
    public final StringToIntConverter b;

    public zaa(int i, StringToIntConverter stringToIntConverter) {
        this.f1975a = i;
        this.b = stringToIntConverter;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iS0 = AbstractC0132a.s0(parcel, 20293);
        AbstractC0132a.u0(parcel, 1, 4);
        parcel.writeInt(this.f1975a);
        AbstractC0132a.m0(parcel, 2, this.b, i);
        AbstractC0132a.t0(parcel, iS0);
    }

    public zaa(StringToIntConverter stringToIntConverter) {
        this.f1975a = 1;
        this.b = stringToIntConverter;
    }
}
