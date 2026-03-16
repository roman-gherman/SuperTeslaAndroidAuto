package com.google.android.gms.common.internal;

import A.h;
import D.a;
import D.u;
import android.accounts.Account;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class GetServiceRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GetServiceRequest> CREATOR = new h(15);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Scope[] f1946o = new Scope[0];

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Feature[] f1947p = new Feature[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1948a;
    public final int b;
    public final int c;
    public String d;
    public IBinder e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Scope[] f1949f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Bundle f1950g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Account f1951h;
    public Feature[] i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Feature[] f1952j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f1953k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f1954l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f1955m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f1956n;

    public GetServiceRequest(int i, int i3, int i4, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, Feature[] featureArr, Feature[] featureArr2, boolean z6, int i5, boolean z7, String str2) {
        scopeArr = scopeArr == null ? f1946o : scopeArr;
        bundle = bundle == null ? new Bundle() : bundle;
        Feature[] featureArr3 = f1947p;
        featureArr = featureArr == null ? featureArr3 : featureArr;
        featureArr2 = featureArr2 == null ? featureArr3 : featureArr2;
        this.f1948a = i;
        this.b = i3;
        this.c = i4;
        if ("com.google.android.gms".equals(str)) {
            this.d = "com.google.android.gms";
        } else {
            this.d = str;
        }
        if (i < 2) {
            Account accountZzb = null;
            if (iBinder != null) {
                int i6 = a.b;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                IAccountAccessor uVar = iInterfaceQueryLocalInterface instanceof IAccountAccessor ? (IAccountAccessor) iInterfaceQueryLocalInterface : new u(iBinder, "com.google.android.gms.common.internal.IAccountAccessor", 0);
                if (uVar != null) {
                    long jClearCallingIdentity = Binder.clearCallingIdentity();
                    try {
                        try {
                            accountZzb = uVar.zzb();
                        } catch (RemoteException unused) {
                            Log.w("AccountAccessor", "Remote account accessor probably died");
                        }
                    } finally {
                        Binder.restoreCallingIdentity(jClearCallingIdentity);
                    }
                }
            }
            this.f1951h = accountZzb;
        } else {
            this.e = iBinder;
            this.f1951h = account;
        }
        this.f1949f = scopeArr;
        this.f1950g = bundle;
        this.i = featureArr;
        this.f1952j = featureArr2;
        this.f1953k = z6;
        this.f1954l = i5;
        this.f1955m = z7;
        this.f1956n = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        h.a(this, parcel, i);
    }
}
