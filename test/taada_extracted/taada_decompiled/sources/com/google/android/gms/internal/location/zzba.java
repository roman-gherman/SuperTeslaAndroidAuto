package com.google.android.gms.internal.location;

import A.h;
import D.j;
import a.AbstractC0132a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzba extends AbstractSafeParcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LocationRequest f2005a;
    public final List b;
    public final String c;
    public final boolean d;
    public final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f2006f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f2007g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f2008h;
    public final boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f2009j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f2010k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final List f2004l = Collections.EMPTY_LIST;
    public static final Parcelable.Creator<zzba> CREATOR = new h(26);

    public zzba(LocationRequest locationRequest, List list, String str, boolean z6, boolean z7, boolean z8, String str2, boolean z9, boolean z10, String str3, long j6) {
        this.f2005a = locationRequest;
        this.b = list;
        this.c = str;
        this.d = z6;
        this.e = z7;
        this.f2006f = z8;
        this.f2007g = str2;
        this.f2008h = z9;
        this.i = z10;
        this.f2009j = str3;
        this.f2010k = j6;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzba) {
            zzba zzbaVar = (zzba) obj;
            if (j.f(this.f2005a, zzbaVar.f2005a) && j.f(this.b, zzbaVar.b) && j.f(this.c, zzbaVar.c) && this.d == zzbaVar.d && this.e == zzbaVar.e && this.f2006f == zzbaVar.f2006f && j.f(this.f2007g, zzbaVar.f2007g) && this.f2008h == zzbaVar.f2008h && this.i == zzbaVar.i && j.f(this.f2009j, zzbaVar.f2009j)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f2005a.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2005a);
        String str = this.c;
        if (str != null) {
            sb.append(" tag=");
            sb.append(str);
        }
        String str2 = this.f2007g;
        if (str2 != null) {
            sb.append(" moduleId=");
            sb.append(str2);
        }
        String str3 = this.f2009j;
        if (str3 != null) {
            sb.append(" contextAttributionTag=");
            sb.append(str3);
        }
        sb.append(" hideAppOps=");
        sb.append(this.d);
        sb.append(" clients=");
        sb.append(this.b);
        sb.append(" forceCoarseLocation=");
        sb.append(this.e);
        if (this.f2006f) {
            sb.append(" exemptFromBackgroundThrottle");
        }
        if (this.f2008h) {
            sb.append(" locationSettingsIgnored");
        }
        if (this.i) {
            sb.append(" inaccurateLocationsDelayed");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iS0 = AbstractC0132a.s0(parcel, 20293);
        AbstractC0132a.m0(parcel, 1, this.f2005a, i);
        AbstractC0132a.r0(parcel, 5, this.b);
        AbstractC0132a.n0(parcel, 6, this.c);
        AbstractC0132a.u0(parcel, 7, 4);
        parcel.writeInt(this.d ? 1 : 0);
        AbstractC0132a.u0(parcel, 8, 4);
        parcel.writeInt(this.e ? 1 : 0);
        AbstractC0132a.u0(parcel, 9, 4);
        parcel.writeInt(this.f2006f ? 1 : 0);
        AbstractC0132a.n0(parcel, 10, this.f2007g);
        AbstractC0132a.u0(parcel, 11, 4);
        parcel.writeInt(this.f2008h ? 1 : 0);
        AbstractC0132a.u0(parcel, 12, 4);
        parcel.writeInt(this.i ? 1 : 0);
        AbstractC0132a.n0(parcel, 13, this.f2009j);
        AbstractC0132a.u0(parcel, 14, 8);
        parcel.writeLong(this.f2010k);
        AbstractC0132a.t0(parcel, iS0);
    }
}
