package com.google.android.material.badge;

import Q.h;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class BadgeState$State implements Parcelable {
    public static final Parcelable.Creator<BadgeState$State> CREATOR = new h(6);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2185a;
    public Integer b;
    public Integer c;
    public Integer d;
    public Integer e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Integer f2186f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Integer f2187g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Integer f2188h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f2189j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f2190k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Locale f2191l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public CharSequence f2192m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f2193n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f2194o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Integer f2195p;
    public Boolean q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Integer f2196r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Integer f2197s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Integer f2198t;
    public Integer u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Integer f2199v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Integer f2200w;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f2185a);
        parcel.writeSerializable(this.b);
        parcel.writeSerializable(this.c);
        parcel.writeSerializable(this.d);
        parcel.writeSerializable(this.e);
        parcel.writeSerializable(this.f2186f);
        parcel.writeSerializable(this.f2187g);
        parcel.writeSerializable(this.f2188h);
        parcel.writeInt(this.i);
        parcel.writeInt(this.f2189j);
        parcel.writeInt(this.f2190k);
        CharSequence charSequence = this.f2192m;
        parcel.writeString(charSequence == null ? null : charSequence.toString());
        parcel.writeInt(this.f2193n);
        parcel.writeSerializable(this.f2195p);
        parcel.writeSerializable(this.f2196r);
        parcel.writeSerializable(this.f2197s);
        parcel.writeSerializable(this.f2198t);
        parcel.writeSerializable(this.u);
        parcel.writeSerializable(this.f2199v);
        parcel.writeSerializable(this.f2200w);
        parcel.writeSerializable(this.q);
        parcel.writeSerializable(this.f2191l);
    }
}
