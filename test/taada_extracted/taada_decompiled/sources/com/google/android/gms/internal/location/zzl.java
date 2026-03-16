package com.google.android.gms.internal.location;

import Q.h;
import a.AbstractC0132a;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.location.b;
import com.google.android.gms.location.c;
import com.google.android.gms.location.zzax;

/* JADX INFO: loaded from: classes.dex */
public final class zzl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzl> CREATOR = new h(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2018a;
    public final zzj b;
    public final zzax c;
    public final zzai d;

    public zzl(int i, zzj zzjVar, IBinder iBinder, IBinder iBinder2) {
        zzax bVar;
        this.f2018a = i;
        this.b = zzjVar;
        zzai bVar2 = null;
        if (iBinder == null) {
            bVar = null;
        } else {
            int i3 = c.b;
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.IDeviceOrientationListener");
            bVar = iInterfaceQueryLocalInterface instanceof zzax ? (zzax) iInterfaceQueryLocalInterface : new b(iBinder);
        }
        this.c = bVar;
        if (iBinder2 != null) {
            IInterface iInterfaceQueryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            bVar2 = iInterfaceQueryLocalInterface2 instanceof zzai ? (zzai) iInterfaceQueryLocalInterface2 : new Q.b(iBinder2);
        }
        this.d = bVar2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iS0 = AbstractC0132a.s0(parcel, 20293);
        AbstractC0132a.u0(parcel, 1, 4);
        parcel.writeInt(this.f2018a);
        AbstractC0132a.m0(parcel, 2, this.b, i);
        zzax zzaxVar = this.c;
        AbstractC0132a.l0(parcel, 3, zzaxVar == null ? null : zzaxVar.asBinder());
        zzai zzaiVar = this.d;
        AbstractC0132a.l0(parcel, 4, zzaiVar != null ? zzaiVar.asBinder() : null);
        AbstractC0132a.t0(parcel, iS0);
    }
}
