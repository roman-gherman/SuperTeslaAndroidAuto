package com.google.android.gms.common.api;

import A.h;
import D.j;
import E1.k;
import a.AbstractC0132a;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class Status extends AbstractSafeParcelable implements Result, ReflectedParcelable {
    public static final Parcelable.Creator<Status> CREATOR;
    public static final Status e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Status f1927f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1928a;
    public final String b;
    public final PendingIntent c;
    public final ConnectionResult d;

    static {
        new Status(-1);
        e = new Status(0);
        new Status(14);
        new Status(8);
        new Status(15);
        f1927f = new Status(16);
        new Status(17);
        new Status(18);
        CREATOR = new h(1);
    }

    public Status(int i, String str, PendingIntent pendingIntent, ConnectionResult connectionResult) {
        this.f1928a = i;
        this.b = str;
        this.c = pendingIntent;
        this.d = connectionResult;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.f1928a == status.f1928a && j.f(this.b, status.b) && j.f(this.c, status.c) && j.f(this.d, status.d);
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f1928a), this.b, this.c, this.d});
    }

    public final String toString() {
        B.h hVar = new B.h(this, 4);
        String strP = this.b;
        if (strP == null) {
            strP = k.P(this.f1928a);
        }
        hVar.a(strP, "statusCode");
        hVar.a(this.c, "resolution");
        return hVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iS0 = AbstractC0132a.s0(parcel, 20293);
        AbstractC0132a.u0(parcel, 1, 4);
        parcel.writeInt(this.f1928a);
        AbstractC0132a.n0(parcel, 2, this.b);
        AbstractC0132a.m0(parcel, 3, this.c, i);
        AbstractC0132a.m0(parcel, 4, this.d, i);
        AbstractC0132a.t0(parcel, iS0);
    }

    public Status(int i) {
        this(i, null, null, null);
    }
}
