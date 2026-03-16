package com.google.android.gms.location;

import a.AbstractC0132a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class zzbj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbj> CREATOR = new Q.h(16);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2164a;
    public final String b;
    public final String c;

    public zzbj(String str, String str2, String str3) {
        this.c = str;
        this.f2164a = str2;
        this.b = str3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iS0 = AbstractC0132a.s0(parcel, 20293);
        AbstractC0132a.n0(parcel, 1, this.f2164a);
        AbstractC0132a.n0(parcel, 2, this.b);
        AbstractC0132a.n0(parcel, 5, this.c);
        AbstractC0132a.t0(parcel, iS0);
    }
}
