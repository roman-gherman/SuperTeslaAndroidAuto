package com.google.android.gms.location;

import a.AbstractC0132a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzbo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbo> CREATOR = new Q.h(20);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2165a;
    public final int b;
    public final long c;
    public final long d;

    public zzbo(int i, int i3, long j6, long j7) {
        this.f2165a = i;
        this.b = i3;
        this.c = j6;
        this.d = j7;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzbo) {
            zzbo zzboVar = (zzbo) obj;
            if (this.f2165a == zzboVar.f2165a && this.b == zzboVar.b && this.c == zzboVar.c && this.d == zzboVar.d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.b), Integer.valueOf(this.f2165a), Long.valueOf(this.d), Long.valueOf(this.c)});
    }

    public final String toString() {
        return "NetworkLocationStatus: Wifi status: " + this.f2165a + " Cell status: " + this.b + " elapsed time NS: " + this.d + " system time ms: " + this.c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iS0 = AbstractC0132a.s0(parcel, 20293);
        AbstractC0132a.u0(parcel, 1, 4);
        parcel.writeInt(this.f2165a);
        AbstractC0132a.u0(parcel, 2, 4);
        parcel.writeInt(this.b);
        AbstractC0132a.u0(parcel, 3, 8);
        parcel.writeLong(this.c);
        AbstractC0132a.u0(parcel, 4, 8);
        parcel.writeLong(this.d);
        AbstractC0132a.t0(parcel, iS0);
    }
}
