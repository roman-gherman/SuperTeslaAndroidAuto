package com.google.android.gms.common.internal;

import A.h;
import a.AbstractC0132a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class MethodInvocation extends AbstractSafeParcelable {
    public static final Parcelable.Creator<MethodInvocation> CREATOR = new h(6);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1957a;
    public final int b;
    public final int c;
    public final long d;
    public final long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f1958f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f1959g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f1960h;
    public final int i;

    public MethodInvocation(int i, int i3, int i4, long j6, long j7, String str, String str2, int i5, int i6) {
        this.f1957a = i;
        this.b = i3;
        this.c = i4;
        this.d = j6;
        this.e = j7;
        this.f1958f = str;
        this.f1959g = str2;
        this.f1960h = i5;
        this.i = i6;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iS0 = AbstractC0132a.s0(parcel, 20293);
        AbstractC0132a.u0(parcel, 1, 4);
        parcel.writeInt(this.f1957a);
        AbstractC0132a.u0(parcel, 2, 4);
        parcel.writeInt(this.b);
        AbstractC0132a.u0(parcel, 3, 4);
        parcel.writeInt(this.c);
        AbstractC0132a.u0(parcel, 4, 8);
        parcel.writeLong(this.d);
        AbstractC0132a.u0(parcel, 5, 8);
        parcel.writeLong(this.e);
        AbstractC0132a.n0(parcel, 6, this.f1958f);
        AbstractC0132a.n0(parcel, 7, this.f1959g);
        AbstractC0132a.u0(parcel, 8, 4);
        parcel.writeInt(this.f1960h);
        AbstractC0132a.u0(parcel, 9, 4);
        parcel.writeInt(this.i);
        AbstractC0132a.t0(parcel, iS0);
    }
}
