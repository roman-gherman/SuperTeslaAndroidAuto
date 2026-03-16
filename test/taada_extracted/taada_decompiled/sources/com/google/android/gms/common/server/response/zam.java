package com.google.android.gms.common.server.response;

import Q.h;
import a.AbstractC0132a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zam extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zam> CREATOR = new h(8);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1987a;
    public final String b;
    public final FastJsonResponse$Field c;

    public zam(int i, String str, FastJsonResponse$Field fastJsonResponse$Field) {
        this.f1987a = i;
        this.b = str;
        this.c = fastJsonResponse$Field;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iS0 = AbstractC0132a.s0(parcel, 20293);
        AbstractC0132a.u0(parcel, 1, 4);
        parcel.writeInt(this.f1987a);
        AbstractC0132a.n0(parcel, 2, this.b);
        AbstractC0132a.m0(parcel, 3, this.c, i);
        AbstractC0132a.t0(parcel, iS0);
    }

    public zam(String str, FastJsonResponse$Field fastJsonResponse$Field) {
        this.f1987a = 1;
        this.b = str;
        this.c = fastJsonResponse$Field;
    }
}
