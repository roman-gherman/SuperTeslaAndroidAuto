package com.google.android.gms.location;

import a.AbstractC0132a;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import androidx.core.location.LocationRequestCompat;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class LocationRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<LocationRequest> CREATOR = new Q.h(14);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2146a;
    public long b;
    public long c;
    public boolean d;
    public long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2147f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f2148g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f2149h;
    public boolean i;

    public final boolean equals(Object obj) {
        if (!(obj instanceof LocationRequest)) {
            return false;
        }
        LocationRequest locationRequest = (LocationRequest) obj;
        if (this.f2146a != locationRequest.f2146a) {
            return false;
        }
        long j6 = this.b;
        long j7 = locationRequest.b;
        if (j6 != j7 || this.c != locationRequest.c || this.d != locationRequest.d || this.e != locationRequest.e || this.f2147f != locationRequest.f2147f || this.f2148g != locationRequest.f2148g) {
            return false;
        }
        long j8 = this.f2149h;
        if (j8 >= j6) {
            j6 = j8;
        }
        long j9 = locationRequest.f2149h;
        if (j9 >= j7) {
            j7 = j9;
        }
        return j6 == j7 && this.i == locationRequest.i;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f2146a), Long.valueOf(this.b), Float.valueOf(this.f2148g), Long.valueOf(this.f2149h)});
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Request[");
        int i = this.f2146a;
        sb.append(i != 100 ? i != 102 ? i != 104 ? i != 105 ? "???" : "PRIORITY_NO_POWER" : "PRIORITY_LOW_POWER" : "PRIORITY_BALANCED_POWER_ACCURACY" : "PRIORITY_HIGH_ACCURACY");
        long j6 = this.b;
        if (i != 105) {
            sb.append(" requested=");
            sb.append(j6);
            sb.append("ms");
        }
        sb.append(" fastest=");
        sb.append(this.c);
        sb.append("ms");
        long j7 = this.f2149h;
        if (j7 > j6) {
            sb.append(" maxWait=");
            sb.append(j7);
            sb.append("ms");
        }
        float f6 = this.f2148g;
        if (f6 > 0.0f) {
            sb.append(" smallestDisplacement=");
            sb.append(f6);
            sb.append("m");
        }
        long j8 = this.e;
        if (j8 != LocationRequestCompat.PASSIVE_INTERVAL) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            sb.append(" expireIn=");
            sb.append(j8 - jElapsedRealtime);
            sb.append("ms");
        }
        int i3 = this.f2147f;
        if (i3 != Integer.MAX_VALUE) {
            sb.append(" num=");
            sb.append(i3);
        }
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iS0 = AbstractC0132a.s0(parcel, 20293);
        AbstractC0132a.u0(parcel, 1, 4);
        parcel.writeInt(this.f2146a);
        AbstractC0132a.u0(parcel, 2, 8);
        parcel.writeLong(this.b);
        AbstractC0132a.u0(parcel, 3, 8);
        parcel.writeLong(this.c);
        AbstractC0132a.u0(parcel, 4, 4);
        parcel.writeInt(this.d ? 1 : 0);
        AbstractC0132a.u0(parcel, 5, 8);
        parcel.writeLong(this.e);
        AbstractC0132a.u0(parcel, 6, 4);
        parcel.writeInt(this.f2147f);
        AbstractC0132a.u0(parcel, 7, 4);
        parcel.writeFloat(this.f2148g);
        AbstractC0132a.u0(parcel, 8, 8);
        parcel.writeLong(this.f2149h);
        AbstractC0132a.u0(parcel, 9, 4);
        parcel.writeInt(this.i ? 1 : 0);
        AbstractC0132a.t0(parcel, iS0);
    }
}
