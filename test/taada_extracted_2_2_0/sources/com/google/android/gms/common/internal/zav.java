package com.google.android.gms.common.internal;

import A.h;
import D.a;
import D.j;
import D.u;
import a.AbstractC0132a;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zav extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zav> CREATOR = new h(8);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1964a;
    public final IBinder b;
    public final ConnectionResult c;
    public final boolean d;
    public final boolean e;

    public zav(int i, IBinder iBinder, ConnectionResult connectionResult, boolean z6, boolean z7) {
        this.f1964a = i;
        this.b = iBinder;
        this.c = connectionResult;
        this.d = z6;
        this.e = z7;
    }

    public final boolean equals(Object obj) {
        Object uVar;
        if (obj != null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof zav) {
                zav zavVar = (zav) obj;
                if (this.c.equals(zavVar.c)) {
                    Object uVar2 = null;
                    IBinder iBinder = this.b;
                    if (iBinder == null) {
                        uVar = null;
                    } else {
                        int i = a.b;
                        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                        uVar = iInterfaceQueryLocalInterface instanceof IAccountAccessor ? (IAccountAccessor) iInterfaceQueryLocalInterface : new u(iBinder, "com.google.android.gms.common.internal.IAccountAccessor", 0);
                    }
                    IBinder iBinder2 = zavVar.b;
                    if (iBinder2 != null) {
                        int i3 = a.b;
                        IInterface iInterfaceQueryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                        uVar2 = iInterfaceQueryLocalInterface2 instanceof IAccountAccessor ? (IAccountAccessor) iInterfaceQueryLocalInterface2 : new u(iBinder2, "com.google.android.gms.common.internal.IAccountAccessor", 0);
                    }
                    if (j.f(uVar, uVar2)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iS0 = AbstractC0132a.s0(parcel, 20293);
        AbstractC0132a.u0(parcel, 1, 4);
        parcel.writeInt(this.f1964a);
        AbstractC0132a.l0(parcel, 2, this.b);
        AbstractC0132a.m0(parcel, 3, this.c, i);
        AbstractC0132a.u0(parcel, 4, 4);
        parcel.writeInt(this.d ? 1 : 0);
        AbstractC0132a.u0(parcel, 5, 4);
        parcel.writeInt(this.e ? 1 : 0);
        AbstractC0132a.t0(parcel, iS0);
    }
}
