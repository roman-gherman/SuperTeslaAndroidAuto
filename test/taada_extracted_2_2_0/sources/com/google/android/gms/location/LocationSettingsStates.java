package com.google.android.gms.location;

import a.AbstractC0132a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class LocationSettingsStates extends AbstractSafeParcelable {
    public static final Parcelable.Creator<LocationSettingsStates> CREATOR = new Q.h(19);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f2153a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f2154f;

    public LocationSettingsStates(boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11) {
        this.f2153a = z6;
        this.b = z7;
        this.c = z8;
        this.d = z9;
        this.e = z10;
        this.f2154f = z11;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iS0 = AbstractC0132a.s0(parcel, 20293);
        AbstractC0132a.u0(parcel, 1, 4);
        parcel.writeInt(this.f2153a ? 1 : 0);
        AbstractC0132a.u0(parcel, 2, 4);
        parcel.writeInt(this.b ? 1 : 0);
        AbstractC0132a.u0(parcel, 3, 4);
        parcel.writeInt(this.c ? 1 : 0);
        AbstractC0132a.u0(parcel, 4, 4);
        parcel.writeInt(this.d ? 1 : 0);
        AbstractC0132a.u0(parcel, 5, 4);
        parcel.writeInt(this.e ? 1 : 0);
        AbstractC0132a.u0(parcel, 6, 4);
        parcel.writeInt(this.f2154f ? 1 : 0);
        AbstractC0132a.t0(parcel, iS0);
    }
}
