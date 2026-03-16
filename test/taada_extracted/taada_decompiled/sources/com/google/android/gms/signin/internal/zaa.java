package com.google.android.gms.signin.internal;

import Q.h;
import a.AbstractC0132a;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zaa extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator<zaa> CREATOR = new h(2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2169a;
    public final int b;
    public final Intent c;

    public zaa(int i, int i3, Intent intent) {
        this.f2169a = i;
        this.b = i3;
        this.c = intent;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.b == 0 ? Status.e : Status.f1927f;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iS0 = AbstractC0132a.s0(parcel, 20293);
        AbstractC0132a.u0(parcel, 1, 4);
        parcel.writeInt(this.f2169a);
        AbstractC0132a.u0(parcel, 2, 4);
        parcel.writeInt(this.b);
        AbstractC0132a.m0(parcel, 3, this.c, i);
        AbstractC0132a.t0(parcel, iS0);
    }
}
