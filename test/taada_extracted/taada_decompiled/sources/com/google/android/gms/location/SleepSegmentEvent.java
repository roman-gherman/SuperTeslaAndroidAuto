package com.google.android.gms.location;

import D.j;
import a.AbstractC0132a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class SleepSegmentEvent extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SleepSegmentEvent> CREATOR = new Q.h(23);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f2159a;
    public final long b;
    public final int c;
    public final int d;
    public final int e;

    public SleepSegmentEvent(int i, int i3, int i4, long j6, long j7) {
        j.a("endTimeMillis must be greater than or equal to startTimeMillis", j6 <= j7);
        this.f2159a = j6;
        this.b = j7;
        this.c = i;
        this.d = i3;
        this.e = i4;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof SleepSegmentEvent) {
            SleepSegmentEvent sleepSegmentEvent = (SleepSegmentEvent) obj;
            if (this.f2159a == sleepSegmentEvent.f2159a && this.b == sleepSegmentEvent.b && this.c == sleepSegmentEvent.c && this.d == sleepSegmentEvent.d && this.e == sleepSegmentEvent.e) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f2159a), Long.valueOf(this.b), Integer.valueOf(this.c)});
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(84);
        sb.append("startMillis=");
        sb.append(this.f2159a);
        sb.append(", endMillis=");
        sb.append(this.b);
        sb.append(", status=");
        sb.append(this.c);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        j.c(parcel);
        int iS0 = AbstractC0132a.s0(parcel, 20293);
        AbstractC0132a.u0(parcel, 1, 8);
        parcel.writeLong(this.f2159a);
        AbstractC0132a.u0(parcel, 2, 8);
        parcel.writeLong(this.b);
        AbstractC0132a.u0(parcel, 3, 4);
        parcel.writeInt(this.c);
        AbstractC0132a.u0(parcel, 4, 4);
        parcel.writeInt(this.d);
        AbstractC0132a.u0(parcel, 5, 4);
        parcel.writeInt(this.e);
        AbstractC0132a.t0(parcel, iS0);
    }
}
