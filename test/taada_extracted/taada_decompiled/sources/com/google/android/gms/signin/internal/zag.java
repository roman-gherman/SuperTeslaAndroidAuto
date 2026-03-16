package com.google.android.gms.signin.internal;

import Q.h;
import a.AbstractC0132a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zag extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator<zag> CREATOR = new h(3);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f2170a;
    public final String b;

    public zag(ArrayList arrayList, String str) {
        this.f2170a = arrayList;
        this.b = str;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.b != null ? Status.e : Status.f1927f;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iS0 = AbstractC0132a.s0(parcel, 20293);
        AbstractC0132a.o0(parcel, 1, this.f2170a);
        AbstractC0132a.n0(parcel, 2, this.b);
        AbstractC0132a.t0(parcel, iS0);
    }
}
