package com.google.android.gms.internal.location;

import A.h;
import D.j;
import a.AbstractC0132a;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.location.LocationRequestCompat;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.location.zzs;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzj extends AbstractSafeParcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zzs f2017a;
    public final List b;
    public final String c;
    public static final List d = Collections.EMPTY_LIST;
    public static final zzs e = new zzs(true, 50, 0.0f, LocationRequestCompat.PASSIVE_INTERVAL, Integer.MAX_VALUE);
    public static final Parcelable.Creator<zzj> CREATOR = new h(29);

    public zzj(zzs zzsVar, List list, String str) {
        this.f2017a = zzsVar;
        this.b = list;
        this.c = str;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzj)) {
            return false;
        }
        zzj zzjVar = (zzj) obj;
        return j.f(this.f2017a, zzjVar.f2017a) && j.f(this.b, zzjVar.b) && j.f(this.c, zzjVar.c);
    }

    public final int hashCode() {
        return this.f2017a.hashCode();
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.f2017a);
        String strValueOf2 = String.valueOf(this.b);
        int length = strValueOf.length();
        int length2 = strValueOf2.length();
        String str = this.c;
        StringBuilder sb = new StringBuilder(length + 77 + length2 + String.valueOf(str).length());
        sb.append("DeviceOrientationRequestInternal{deviceOrientationRequest=");
        sb.append(strValueOf);
        sb.append(", clients=");
        sb.append(strValueOf2);
        sb.append(", tag='");
        sb.append(str);
        sb.append("'}");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iS0 = AbstractC0132a.s0(parcel, 20293);
        AbstractC0132a.m0(parcel, 1, this.f2017a, i);
        AbstractC0132a.r0(parcel, 2, this.b);
        AbstractC0132a.n0(parcel, 3, this.c);
        AbstractC0132a.t0(parcel, iS0);
    }
}
