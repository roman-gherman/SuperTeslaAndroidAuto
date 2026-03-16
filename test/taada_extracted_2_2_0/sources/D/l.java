package D;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.internal.IGmsCallbacks;
import com.google.android.gms.common.internal.zzk;

/* JADX INFO: loaded from: classes.dex */
public final class l extends O.a implements IGmsCallbacks {
    public c b;
    public final int c;

    public l(c cVar, int i) {
        super("com.google.android.gms.common.internal.IGmsCallbacks");
        this.b = cVar;
        this.c = i;
    }

    @Override // O.a
    public final boolean a(int i, Parcel parcel, Parcel parcel2) {
        if (i == 1) {
            int i3 = parcel.readInt();
            IBinder strongBinder = parcel.readStrongBinder();
            Bundle bundle = (Bundle) P.b.a(parcel, Bundle.CREATOR);
            P.b.b(parcel);
            onPostInitComplete(i3, strongBinder, bundle);
        } else if (i == 2) {
            int i4 = parcel.readInt();
            Bundle bundle2 = (Bundle) P.b.a(parcel, Bundle.CREATOR);
            P.b.b(parcel);
            zzb(i4, bundle2);
        } else {
            if (i != 3) {
                return false;
            }
            int i5 = parcel.readInt();
            IBinder strongBinder2 = parcel.readStrongBinder();
            zzk zzkVar = (zzk) P.b.a(parcel, zzk.CREATOR);
            P.b.b(parcel);
            zzc(i5, strongBinder2, zzkVar);
        }
        parcel2.writeNoException();
        return true;
    }

    @Override // com.google.android.gms.common.internal.IGmsCallbacks
    public final void onPostInitComplete(int i, IBinder iBinder, Bundle bundle) {
        j.d(this.b, "onPostInitComplete can be called only once per call to getRemoteService");
        c cVar = this.b;
        cVar.getClass();
        n nVar = new n(cVar, i, iBinder, bundle);
        k kVar = cVar.f189j;
        kVar.sendMessage(kVar.obtainMessage(1, this.c, -1, nVar));
        this.b = null;
    }

    @Override // com.google.android.gms.common.internal.IGmsCallbacks
    public final void zzb(int i, Bundle bundle) {
        Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
    }

    @Override // com.google.android.gms.common.internal.IGmsCallbacks
    public final void zzc(int i, IBinder iBinder, zzk zzkVar) {
        c cVar = this.b;
        j.d(cVar, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
        j.c(zzkVar);
        cVar.f201z = zzkVar;
        onPostInitComplete(i, iBinder, zzkVar.f1967a);
    }
}
