package com.google.android.gms.common.internal;

import A.h;
import a.AbstractC0132a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zax extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zax> CREATOR = new h(9);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1965a;
    public final int b;
    public final int c;
    public final Scope[] d;

    public zax(int i, int i3, int i4, Scope[] scopeArr) {
        this.f1965a = i;
        this.b = i3;
        this.c = i4;
        this.d = scopeArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iS0 = AbstractC0132a.s0(parcel, 20293);
        AbstractC0132a.u0(parcel, 1, 4);
        parcel.writeInt(this.f1965a);
        AbstractC0132a.u0(parcel, 2, 4);
        parcel.writeInt(this.b);
        AbstractC0132a.u0(parcel, 3, 4);
        parcel.writeInt(this.c);
        AbstractC0132a.q0(parcel, 4, this.d, i);
        AbstractC0132a.t0(parcel, iS0);
    }
}
