package com.google.android.gms.internal.location;

import A.h;
import Q.b;
import a.AbstractC0132a;
import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.location.d;
import com.google.android.gms.location.e;
import com.google.android.gms.location.f;
import com.google.android.gms.location.g;
import com.google.android.gms.location.zzbd;

/* JADX INFO: loaded from: classes.dex */
public final class zzbc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbc> CREATOR = new h(27);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2011a;
    public final zzba b;
    public final zzbd c;
    public final PendingIntent d;
    public final com.google.android.gms.location.zzba e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final zzai f2012f;

    public zzbc(int i, zzba zzbaVar, IBinder iBinder, PendingIntent pendingIntent, IBinder iBinder2, IBinder iBinder3) {
        zzbd fVar;
        com.google.android.gms.location.zzba dVar;
        this.f2011a = i;
        this.b = zzbaVar;
        zzai bVar = null;
        if (iBinder == null) {
            fVar = null;
        } else {
            int i3 = g.b;
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationListener");
            fVar = iInterfaceQueryLocalInterface instanceof zzbd ? (zzbd) iInterfaceQueryLocalInterface : new f(iBinder);
        }
        this.c = fVar;
        this.d = pendingIntent;
        if (iBinder2 == null) {
            dVar = null;
        } else {
            int i4 = e.b;
            IInterface iInterfaceQueryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.location.ILocationCallback");
            dVar = iInterfaceQueryLocalInterface2 instanceof com.google.android.gms.location.zzba ? (com.google.android.gms.location.zzba) iInterfaceQueryLocalInterface2 : new d(iBinder2);
        }
        this.e = dVar;
        if (iBinder3 != null) {
            IInterface iInterfaceQueryLocalInterface3 = iBinder3.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            bVar = iInterfaceQueryLocalInterface3 instanceof zzai ? (zzai) iInterfaceQueryLocalInterface3 : new b(iBinder3);
        }
        this.f2012f = bVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iS0 = AbstractC0132a.s0(parcel, 20293);
        AbstractC0132a.u0(parcel, 1, 4);
        parcel.writeInt(this.f2011a);
        AbstractC0132a.m0(parcel, 2, this.b, i);
        zzbd zzbdVar = this.c;
        AbstractC0132a.l0(parcel, 3, zzbdVar == null ? null : zzbdVar.asBinder());
        AbstractC0132a.m0(parcel, 4, this.d, i);
        com.google.android.gms.location.zzba zzbaVar = this.e;
        AbstractC0132a.l0(parcel, 5, zzbaVar == null ? null : zzbaVar.asBinder());
        zzai zzaiVar = this.f2012f;
        AbstractC0132a.l0(parcel, 6, zzaiVar != null ? zzaiVar.asBinder() : null);
        AbstractC0132a.t0(parcel, iS0);
    }
}
