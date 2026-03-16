package com.google.android.gms.common.server;

import A.h;
import a.AbstractC0132a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class FavaDiagnosticsEntity extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<FavaDiagnosticsEntity> CREATOR = new h(21);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1973a;
    public final String b;
    public final int c;

    public FavaDiagnosticsEntity(int i, int i3, String str) {
        this.f1973a = i;
        this.b = str;
        this.c = i3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iS0 = AbstractC0132a.s0(parcel, 20293);
        AbstractC0132a.u0(parcel, 1, 4);
        parcel.writeInt(this.f1973a);
        AbstractC0132a.n0(parcel, 2, this.b);
        AbstractC0132a.u0(parcel, 3, 4);
        parcel.writeInt(this.c);
        AbstractC0132a.t0(parcel, iS0);
    }
}
