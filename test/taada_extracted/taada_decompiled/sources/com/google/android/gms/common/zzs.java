package com.google.android.gms.common;

import D.v;
import a.AbstractC0132a;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.a;
import com.google.android.gms.location.i;
import z.j;

/* JADX INFO: loaded from: classes.dex */
public final class zzs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzs> CREATOR = new i(12);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2002a;
    public final j b;
    public final boolean c;
    public final boolean d;

    public zzs(String str, IBinder iBinder, boolean z6, boolean z7) {
        this.f2002a = str;
        j jVar = null;
        if (iBinder != null) {
            try {
                int i = z.i.c;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICertData");
                IObjectWrapper iObjectWrapperZzd = (iInterfaceQueryLocalInterface instanceof zzaa ? (zzaa) iInterfaceQueryLocalInterface : new v(iBinder, "com.google.android.gms.common.internal.ICertData", 0)).zzd();
                byte[] bArr = iObjectWrapperZzd == null ? null : (byte[]) a.b(iObjectWrapperZzd);
                if (bArr != null) {
                    jVar = new j(bArr);
                } else {
                    Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
                }
            } catch (RemoteException e) {
                Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", e);
            }
        }
        this.b = jVar;
        this.c = z6;
        this.d = z7;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iS0 = AbstractC0132a.s0(parcel, 20293);
        AbstractC0132a.n0(parcel, 1, this.f2002a);
        j jVar = this.b;
        if (jVar == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            jVar = null;
        }
        AbstractC0132a.l0(parcel, 2, jVar);
        AbstractC0132a.u0(parcel, 3, 4);
        parcel.writeInt(this.c ? 1 : 0);
        AbstractC0132a.u0(parcel, 4, 4);
        parcel.writeInt(this.d ? 1 : 0);
        AbstractC0132a.t0(parcel, iS0);
    }
}
