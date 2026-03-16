package D;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: loaded from: classes.dex */
public final class n extends h {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final IBinder f212g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ c f213h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(c cVar, int i, IBinder iBinder, Bundle bundle) {
        super(cVar, i, bundle);
        this.f213h = cVar;
        this.f212g = iBinder;
    }

    @Override // D.h
    public final void a(ConnectionResult connectionResult) {
        c cVar = this.f213h;
        B.g gVar = cVar.f198t;
        if (gVar != null) {
            gVar.onConnectionFailed(connectionResult);
        }
        cVar.d = connectionResult.b;
        cVar.e = System.currentTimeMillis();
    }

    @Override // D.h
    public final boolean b() {
        IBinder iBinder = this.f212g;
        try {
            j.c(iBinder);
            String interfaceDescriptor = iBinder.getInterfaceDescriptor();
            c cVar = this.f213h;
            if (!cVar.d().equals(interfaceDescriptor)) {
                Log.w("GmsClient", "service descriptor mismatch: " + cVar.d() + " vs. " + interfaceDescriptor);
                return false;
            }
            IInterface iInterfaceA = cVar.a(iBinder);
            if (iInterfaceA == null || !(c.g(cVar, 2, 4, iInterfaceA) || c.g(cVar, 3, 4, iInterfaceA))) {
                return false;
            }
            cVar.x = null;
            B.g gVar = cVar.f197s;
            if (gVar == null) {
                return true;
            }
            gVar.onConnected(null);
            return true;
        } catch (RemoteException unused) {
            Log.w("GmsClient", "service probably died");
            return false;
        }
    }
}
