package h;

import E1.k;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.util.Log;
import com.google.android.finsky.externalreferrer.IGetInstallReferrerService;
import fr.sd.taada.analytics.attribution.PlayReferrerAttributionService$getReferrerFromPlayStore$2$1;
import w.AbstractBinderC0861b;
import w.C0860a;

/* JADX INFO: loaded from: classes.dex */
public final class b implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PlayReferrerAttributionService$getReferrerFromPlayStore$2$1 f3347a;
    public final /* synthetic */ c b;

    public b(c cVar, PlayReferrerAttributionService$getReferrerFromPlayStore$2$1 playReferrerAttributionService$getReferrerFromPlayStore$2$1) {
        this.b = cVar;
        this.f3347a = playReferrerAttributionService$getReferrerFromPlayStore$2$1;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        IGetInstallReferrerService c0860a;
        Log.isLoggable("InstallReferrerClient", 2);
        int i = AbstractBinderC0861b.f4956a;
        if (iBinder == null) {
            c0860a = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
            c0860a = iInterfaceQueryLocalInterface instanceof IGetInstallReferrerService ? (IGetInstallReferrerService) iInterfaceQueryLocalInterface : new C0860a(iBinder);
        }
        c cVar = this.b;
        cVar.c = c0860a;
        cVar.f3348a = 2;
        onInstallReferrerSetupFinished(0);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        k.Z("Install Referrer service disconnected.");
        c cVar = this.b;
        cVar.c = null;
        cVar.f3348a = 0;
        onInstallReferrerServiceDisconnected();
    }
}
