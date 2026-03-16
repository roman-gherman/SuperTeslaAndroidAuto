package com.google.android.gms.internal.location;

import A.h;
import a.AbstractC0132a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzaa extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator<zzaa> CREATOR;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Status f2003a;

    static {
        Status status = Status.e;
        CREATOR = new h(25);
    }

    public zzaa(Status status) {
        this.f2003a = status;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f2003a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iS0 = AbstractC0132a.s0(parcel, 20293);
        AbstractC0132a.m0(parcel, 1, this.f2003a, i);
        AbstractC0132a.t0(parcel, iS0);
    }
}
