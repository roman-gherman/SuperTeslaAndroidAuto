package com.google.android.gms.common.internal;

import A.h;
import a.AbstractC0132a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class TelemetryData extends AbstractSafeParcelable {
    public static final Parcelable.Creator<TelemetryData> CREATOR = new h(5);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1962a;
    public List b;

    public TelemetryData(int i, List list) {
        this.f1962a = i;
        this.b = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iS0 = AbstractC0132a.s0(parcel, 20293);
        AbstractC0132a.u0(parcel, 1, 4);
        parcel.writeInt(this.f1962a);
        AbstractC0132a.r0(parcel, 2, this.b);
        AbstractC0132a.t0(parcel, iS0);
    }
}
