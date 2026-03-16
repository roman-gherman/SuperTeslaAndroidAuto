package com.google.android.gms.common.internal;

import A.h;
import a.AbstractC0132a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class RootTelemetryConfiguration extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RootTelemetryConfiguration> CREATOR = new h(10);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1961a;
    public final boolean b;
    public final boolean c;
    public final int d;
    public final int e;

    public RootTelemetryConfiguration(int i, boolean z6, boolean z7, int i3, int i4) {
        this.f1961a = i;
        this.b = z6;
        this.c = z7;
        this.d = i3;
        this.e = i4;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iS0 = AbstractC0132a.s0(parcel, 20293);
        AbstractC0132a.u0(parcel, 1, 4);
        parcel.writeInt(this.f1961a);
        AbstractC0132a.u0(parcel, 2, 4);
        parcel.writeInt(this.b ? 1 : 0);
        AbstractC0132a.u0(parcel, 3, 4);
        parcel.writeInt(this.c ? 1 : 0);
        AbstractC0132a.u0(parcel, 4, 4);
        parcel.writeInt(this.d);
        AbstractC0132a.u0(parcel, 5, 4);
        parcel.writeInt(this.e);
        AbstractC0132a.t0(parcel, iS0);
    }
}
