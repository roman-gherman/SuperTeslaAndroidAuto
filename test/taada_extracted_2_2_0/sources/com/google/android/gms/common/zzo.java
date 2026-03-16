package com.google.android.gms.common;

import a.AbstractC0132a;
import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.a;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.location.i;

/* JADX INFO: loaded from: classes.dex */
public final class zzo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzo> CREATOR = new i(10);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1999a;
    public final boolean b;
    public final boolean c;
    public final Context d;
    public final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f2000f;

    public zzo(String str, boolean z6, boolean z7, IBinder iBinder, boolean z8, boolean z9) {
        IObjectWrapper bVar;
        this.f1999a = str;
        this.b = z6;
        this.c = z7;
        int i = a.c;
        if (iBinder == null) {
            bVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            bVar = iInterfaceQueryLocalInterface instanceof IObjectWrapper ? (IObjectWrapper) iInterfaceQueryLocalInterface : new b(iBinder, "com.google.android.gms.dynamic.IObjectWrapper", 0);
        }
        this.d = (Context) a.b(bVar);
        this.e = z8;
        this.f2000f = z9;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iS0 = AbstractC0132a.s0(parcel, 20293);
        AbstractC0132a.n0(parcel, 1, this.f1999a);
        AbstractC0132a.u0(parcel, 2, 4);
        parcel.writeInt(this.b ? 1 : 0);
        AbstractC0132a.u0(parcel, 3, 4);
        parcel.writeInt(this.c ? 1 : 0);
        AbstractC0132a.l0(parcel, 4, new a(this.d));
        AbstractC0132a.u0(parcel, 5, 4);
        parcel.writeInt(this.e ? 1 : 0);
        AbstractC0132a.u0(parcel, 6, 4);
        parcel.writeInt(this.f2000f ? 1 : 0);
        AbstractC0132a.t0(parcel, iS0);
    }
}
