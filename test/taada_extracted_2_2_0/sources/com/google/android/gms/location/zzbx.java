package com.google.android.gms.location;

import D.j;
import a.AbstractC0132a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzbx extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbx> CREATOR = new Q.h(25);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2167a;
    public final int b;
    public final int c;
    public final int d;

    public zzbx(int i, int i3, int i4, int i5) {
        j.e(i >= 0 && i <= 23, "Start hour must be in range [0, 23].");
        j.e(i3 >= 0 && i3 <= 59, "Start minute must be in range [0, 59].");
        j.e(i4 >= 0 && i4 <= 23, "End hour must be in range [0, 23].");
        j.e(i5 >= 0 && i5 <= 59, "End minute must be in range [0, 59].");
        j.e(((i + i3) + i4) + i5 > 0, "Parameters can't be all 0.");
        this.f2167a = i;
        this.b = i3;
        this.c = i4;
        this.d = i5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbx)) {
            return false;
        }
        zzbx zzbxVar = (zzbx) obj;
        return this.f2167a == zzbxVar.f2167a && this.b == zzbxVar.b && this.c == zzbxVar.c && this.d == zzbxVar.d;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f2167a), Integer.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.d)});
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(117);
        sb.append("UserPreferredSleepWindow [startHour=");
        sb.append(this.f2167a);
        sb.append(", startMinute=");
        sb.append(this.b);
        sb.append(", endHour=");
        sb.append(this.c);
        sb.append(", endMinute=");
        sb.append(this.d);
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        j.c(parcel);
        int iS0 = AbstractC0132a.s0(parcel, 20293);
        AbstractC0132a.u0(parcel, 1, 4);
        parcel.writeInt(this.f2167a);
        AbstractC0132a.u0(parcel, 2, 4);
        parcel.writeInt(this.b);
        AbstractC0132a.u0(parcel, 3, 4);
        parcel.writeInt(this.c);
        AbstractC0132a.u0(parcel, 4, 4);
        parcel.writeInt(this.d);
        AbstractC0132a.t0(parcel, iS0);
    }
}
