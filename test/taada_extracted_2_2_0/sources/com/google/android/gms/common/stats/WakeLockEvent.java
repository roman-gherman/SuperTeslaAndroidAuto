package com.google.android.gms.common.stats;

import K.c;
import a.AbstractC0132a;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class WakeLockEvent extends StatsEvent {
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1989a;
    public final long b;
    public final int c;
    public final String d;
    public final String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f1990f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f1991g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList f1992h;
    public final String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f1993j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f1994k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f1995l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f1996m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f1997n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f1998o;

    public WakeLockEvent(int i, long j6, int i3, String str, int i4, ArrayList arrayList, String str2, long j7, int i5, String str3, String str4, float f6, long j8, String str5, boolean z6) {
        this.f1989a = i;
        this.b = j6;
        this.c = i3;
        this.d = str;
        this.e = str3;
        this.f1990f = str5;
        this.f1991g = i4;
        this.f1992h = arrayList;
        this.i = str2;
        this.f1993j = j7;
        this.f1994k = i5;
        this.f1995l = str4;
        this.f1996m = f6;
        this.f1997n = j8;
        this.f1998o = z6;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final int b() {
        return this.c;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final long c() {
        return this.b;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final String d() {
        ArrayList arrayList = this.f1992h;
        String strJoin = arrayList == null ? "" : TextUtils.join(",", arrayList);
        StringBuilder sb = new StringBuilder("\t");
        sb.append(this.d);
        sb.append("\t");
        sb.append(this.f1991g);
        sb.append("\t");
        sb.append(strJoin);
        sb.append("\t");
        sb.append(this.f1994k);
        sb.append("\t");
        String str = this.e;
        if (str == null) {
            str = "";
        }
        sb.append(str);
        sb.append("\t");
        String str2 = this.f1995l;
        if (str2 == null) {
            str2 = "";
        }
        sb.append(str2);
        sb.append("\t");
        sb.append(this.f1996m);
        sb.append("\t");
        String str3 = this.f1990f;
        sb.append(str3 != null ? str3 : "");
        sb.append("\t");
        sb.append(this.f1998o);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iS0 = AbstractC0132a.s0(parcel, 20293);
        AbstractC0132a.u0(parcel, 1, 4);
        parcel.writeInt(this.f1989a);
        AbstractC0132a.u0(parcel, 2, 8);
        parcel.writeLong(this.b);
        AbstractC0132a.n0(parcel, 4, this.d);
        AbstractC0132a.u0(parcel, 5, 4);
        parcel.writeInt(this.f1991g);
        AbstractC0132a.o0(parcel, 6, this.f1992h);
        AbstractC0132a.u0(parcel, 8, 8);
        parcel.writeLong(this.f1993j);
        AbstractC0132a.n0(parcel, 10, this.e);
        AbstractC0132a.u0(parcel, 11, 4);
        parcel.writeInt(this.c);
        AbstractC0132a.n0(parcel, 12, this.i);
        AbstractC0132a.n0(parcel, 13, this.f1995l);
        AbstractC0132a.u0(parcel, 14, 4);
        parcel.writeInt(this.f1994k);
        AbstractC0132a.u0(parcel, 15, 4);
        parcel.writeFloat(this.f1996m);
        AbstractC0132a.u0(parcel, 16, 8);
        parcel.writeLong(this.f1997n);
        AbstractC0132a.n0(parcel, 17, this.f1990f);
        AbstractC0132a.u0(parcel, 18, 4);
        parcel.writeInt(this.f1998o ? 1 : 0);
        AbstractC0132a.t0(parcel, iS0);
    }
}
