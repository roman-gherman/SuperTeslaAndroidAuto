package com.google.android.gms.common.internal;

import A.h;
import a.AbstractC0132a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class ConnectionTelemetryConfiguration extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ConnectionTelemetryConfiguration> CREATOR = new h(14);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RootTelemetryConfiguration f1944a;
    public final boolean b;
    public final boolean c;
    public final int[] d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int[] f1945f;

    public ConnectionTelemetryConfiguration(RootTelemetryConfiguration rootTelemetryConfiguration, boolean z6, boolean z7, int[] iArr, int i, int[] iArr2) {
        this.f1944a = rootTelemetryConfiguration;
        this.b = z6;
        this.c = z7;
        this.d = iArr;
        this.e = i;
        this.f1945f = iArr2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iS0 = AbstractC0132a.s0(parcel, 20293);
        AbstractC0132a.m0(parcel, 1, this.f1944a, i);
        AbstractC0132a.u0(parcel, 2, 4);
        parcel.writeInt(this.b ? 1 : 0);
        AbstractC0132a.u0(parcel, 3, 4);
        parcel.writeInt(this.c ? 1 : 0);
        int[] iArr = this.d;
        if (iArr != null) {
            int iS02 = AbstractC0132a.s0(parcel, 4);
            parcel.writeIntArray(iArr);
            AbstractC0132a.t0(parcel, iS02);
        }
        AbstractC0132a.u0(parcel, 5, 4);
        parcel.writeInt(this.e);
        int[] iArr2 = this.f1945f;
        if (iArr2 != null) {
            int iS03 = AbstractC0132a.s0(parcel, 6);
            parcel.writeIntArray(iArr2);
            AbstractC0132a.t0(parcel, iS03);
        }
        AbstractC0132a.t0(parcel, iS0);
    }
}
