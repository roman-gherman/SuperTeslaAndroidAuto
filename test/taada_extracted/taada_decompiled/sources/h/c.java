package h;

import B.g;
import E1.k;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.finsky.externalreferrer.IGetInstallReferrerService;

/* JADX INFO: loaded from: classes.dex */
public final class c extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3348a = 0;
    public final Context b;
    public IGetInstallReferrerService c;
    public b d;

    public c(Context context) {
        this.b = context.getApplicationContext();
    }

    @Override // h.a
    public final void a() {
        this.f3348a = 3;
        if (this.d != null) {
            Log.isLoggable("InstallReferrerClient", 2);
            this.b.unbindService(this.d);
            this.d = null;
        }
        this.c = null;
    }

    @Override // h.a
    public final g b() throws RemoteException {
        if (this.f3348a != 2 || this.c == null || this.d == null) {
            throw new IllegalStateException("Service not connected. Please start a connection before using the service.");
        }
        Bundle bundle = new Bundle();
        bundle.putString("package_name", this.b.getPackageName());
        try {
            return new g(this.c.c(bundle), 27);
        } catch (RemoteException e) {
            k.Z("RemoteException getting install referrer information");
            this.f3348a = 0;
            throw e;
        }
    }
}
