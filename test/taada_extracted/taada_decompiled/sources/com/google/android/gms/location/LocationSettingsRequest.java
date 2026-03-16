package com.google.android.gms.location;

import a.AbstractC0132a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public final class LocationSettingsRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<LocationSettingsRequest> CREATOR = new Q.h(17);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f2151a;
    public final boolean b;
    public final boolean c;
    public final zzbj d;

    public LocationSettingsRequest(ArrayList arrayList, boolean z6, boolean z7, zzbj zzbjVar) {
        this.f2151a = arrayList;
        this.b = z6;
        this.c = z7;
        this.d = zzbjVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iS0 = AbstractC0132a.s0(parcel, 20293);
        AbstractC0132a.r0(parcel, 1, Collections.unmodifiableList(this.f2151a));
        AbstractC0132a.u0(parcel, 2, 4);
        parcel.writeInt(this.b ? 1 : 0);
        AbstractC0132a.u0(parcel, 3, 4);
        parcel.writeInt(this.c ? 1 : 0);
        AbstractC0132a.m0(parcel, 5, this.d, i);
        AbstractC0132a.t0(parcel, iS0);
    }
}
