package com.google.android.gms.common.internal;

import A.h;
import a.AbstractC0132a;
import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zat extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zat> CREATOR = new h(7);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1963a;
    public final Account b;
    public final int c;
    public final GoogleSignInAccount d;

    public zat(int i, Account account, int i3, GoogleSignInAccount googleSignInAccount) {
        this.f1963a = i;
        this.b = account;
        this.c = i3;
        this.d = googleSignInAccount;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iS0 = AbstractC0132a.s0(parcel, 20293);
        AbstractC0132a.u0(parcel, 1, 4);
        parcel.writeInt(this.f1963a);
        AbstractC0132a.m0(parcel, 2, this.b, i);
        AbstractC0132a.u0(parcel, 3, 4);
        parcel.writeInt(this.c);
        AbstractC0132a.m0(parcel, 4, this.d, i);
        AbstractC0132a.t0(parcel, iS0);
    }
}
