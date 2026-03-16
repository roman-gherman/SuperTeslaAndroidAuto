package com.google.android.gms.location;

import D.j;
import a.AbstractC0132a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class SleepClassifyEvent extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SleepClassifyEvent> CREATOR = new Q.h(22);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2155a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f2156f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f2157g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f2158h;
    public final int i;

    public SleepClassifyEvent(int i, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z6) {
        this.f2155a = i;
        this.b = i3;
        this.c = i4;
        this.d = i5;
        this.e = i6;
        this.f2156f = i7;
        this.f2157g = i8;
        this.f2158h = z6;
        this.i = i9;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SleepClassifyEvent)) {
            return false;
        }
        SleepClassifyEvent sleepClassifyEvent = (SleepClassifyEvent) obj;
        return this.f2155a == sleepClassifyEvent.f2155a && this.b == sleepClassifyEvent.b;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f2155a), Integer.valueOf(this.b)});
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(65);
        sb.append(this.f2155a);
        sb.append(" Conf:");
        sb.append(this.b);
        sb.append(" Motion:");
        sb.append(this.c);
        sb.append(" Light:");
        sb.append(this.d);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        j.c(parcel);
        int iS0 = AbstractC0132a.s0(parcel, 20293);
        AbstractC0132a.u0(parcel, 1, 4);
        parcel.writeInt(this.f2155a);
        AbstractC0132a.u0(parcel, 2, 4);
        parcel.writeInt(this.b);
        AbstractC0132a.u0(parcel, 3, 4);
        parcel.writeInt(this.c);
        AbstractC0132a.u0(parcel, 4, 4);
        parcel.writeInt(this.d);
        AbstractC0132a.u0(parcel, 5, 4);
        parcel.writeInt(this.e);
        AbstractC0132a.u0(parcel, 6, 4);
        parcel.writeInt(this.f2156f);
        AbstractC0132a.u0(parcel, 7, 4);
        parcel.writeInt(this.f2157g);
        AbstractC0132a.u0(parcel, 8, 4);
        parcel.writeInt(this.f2158h ? 1 : 0);
        AbstractC0132a.u0(parcel, 9, 4);
        parcel.writeInt(this.i);
        AbstractC0132a.t0(parcel, iS0);
    }
}
