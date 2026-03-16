package com.google.android.gms.auth.api.signin;

import a.AbstractC0132a;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.location.i;
import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class GoogleSignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new i(5);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1909a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Uri f1910f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f1911g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f1912h;
    public final String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ArrayList f1913j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f1914k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f1915l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final HashSet f1916m = new HashSet();

    public GoogleSignInAccount(int i, String str, String str2, String str3, String str4, Uri uri, String str5, long j6, String str6, ArrayList arrayList, String str7, String str8) {
        this.f1909a = i;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f1910f = uri;
        this.f1911g = str5;
        this.f1912h = j6;
        this.i = str6;
        this.f1913j = arrayList;
        this.f1914k = str7;
        this.f1915l = str8;
    }

    public final HashSet b() {
        HashSet hashSet = new HashSet(this.f1913j);
        hashSet.addAll(this.f1916m);
        return hashSet;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        return googleSignInAccount.i.equals(this.i) && googleSignInAccount.b().equals(b());
    }

    public final int hashCode() {
        return ((this.i.hashCode() + 527) * 31) + b().hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iS0 = AbstractC0132a.s0(parcel, 20293);
        AbstractC0132a.u0(parcel, 1, 4);
        parcel.writeInt(this.f1909a);
        AbstractC0132a.n0(parcel, 2, this.b);
        AbstractC0132a.n0(parcel, 3, this.c);
        AbstractC0132a.n0(parcel, 4, this.d);
        AbstractC0132a.n0(parcel, 5, this.e);
        AbstractC0132a.m0(parcel, 6, this.f1910f, i);
        AbstractC0132a.n0(parcel, 7, this.f1911g);
        AbstractC0132a.u0(parcel, 8, 8);
        parcel.writeLong(this.f1912h);
        AbstractC0132a.n0(parcel, 9, this.i);
        AbstractC0132a.r0(parcel, 10, this.f1913j);
        AbstractC0132a.n0(parcel, 11, this.f1914k);
        AbstractC0132a.n0(parcel, 12, this.f1915l);
        AbstractC0132a.t0(parcel, iS0);
    }
}
