package D;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes.dex */
public final class v extends P.a implements zzaa {
    @Override // com.google.android.gms.common.internal.zzaa
    public final int zzc() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.c);
        Parcel parcelA = a(parcelObtain, 2);
        int i = parcelA.readInt();
        parcelA.recycle();
        return i;
    }

    @Override // com.google.android.gms.common.internal.zzaa
    public final IObjectWrapper zzd() {
        IObjectWrapper bVar;
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.c);
        Parcel parcelA = a(parcelObtain, 1);
        IBinder strongBinder = parcelA.readStrongBinder();
        int i = com.google.android.gms.dynamic.a.c;
        if (strongBinder == null) {
            bVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            bVar = iInterfaceQueryLocalInterface instanceof IObjectWrapper ? (IObjectWrapper) iInterfaceQueryLocalInterface : new com.google.android.gms.dynamic.b(strongBinder, "com.google.android.gms.dynamic.IObjectWrapper", 0);
        }
        parcelA.recycle();
        return bVar;
    }
}
