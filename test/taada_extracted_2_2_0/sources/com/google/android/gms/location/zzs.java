package com.google.android.gms.location;

import a.AbstractC0132a;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import androidx.core.location.LocationRequestCompat;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzs> CREATOR = new i(2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f2168a;
    public final long b;
    public final float c;
    public final long d;
    public final int e;

    public zzs(boolean z6, long j6, float f6, long j7, int i) {
        this.f2168a = z6;
        this.b = j6;
        this.c = f6;
        this.d = j7;
        this.e = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzs)) {
            return false;
        }
        zzs zzsVar = (zzs) obj;
        return this.f2168a == zzsVar.f2168a && this.b == zzsVar.b && Float.compare(this.c, zzsVar.c) == 0 && this.d == zzsVar.d && this.e == zzsVar.e;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.f2168a), Long.valueOf(this.b), Float.valueOf(this.c), Long.valueOf(this.d), Integer.valueOf(this.e)});
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("DeviceOrientationRequest[mShouldUseMag=");
        sb.append(this.f2168a);
        sb.append(" mMinimumSamplingPeriodMs=");
        sb.append(this.b);
        sb.append(" mSmallestAngleChangeRadians=");
        sb.append(this.c);
        long j6 = this.d;
        if (j6 != LocationRequestCompat.PASSIVE_INTERVAL) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            sb.append(" expireIn=");
            sb.append(j6 - jElapsedRealtime);
            sb.append("ms");
        }
        int i = this.e;
        if (i != Integer.MAX_VALUE) {
            sb.append(" num=");
            sb.append(i);
        }
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iS0 = AbstractC0132a.s0(parcel, 20293);
        AbstractC0132a.u0(parcel, 1, 4);
        parcel.writeInt(this.f2168a ? 1 : 0);
        AbstractC0132a.u0(parcel, 2, 8);
        parcel.writeLong(this.b);
        AbstractC0132a.u0(parcel, 3, 4);
        parcel.writeFloat(this.c);
        AbstractC0132a.u0(parcel, 4, 8);
        parcel.writeLong(this.d);
        AbstractC0132a.u0(parcel, 5, 4);
        parcel.writeInt(this.e);
        AbstractC0132a.t0(parcel, iS0);
    }
}
