package D;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.internal.IGmsServiceBroker;

/* JADX INFO: loaded from: classes.dex */
public final class m implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f211a;
    public final /* synthetic */ c b;

    public m(c cVar, int i) {
        this.b = cVar;
        this.f211a = i;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        int i;
        int i3;
        c cVar = this.b;
        if (iBinder == null) {
            synchronized (cVar.f190k) {
                i = cVar.f196r;
            }
            if (i == 3) {
                cVar.y = true;
                i3 = 5;
            } else {
                i3 = 4;
            }
            k kVar = cVar.f189j;
            kVar.sendMessage(kVar.obtainMessage(i3, cVar.f183A.get(), 16));
            return;
        }
        synchronized (cVar.f191l) {
            try {
                c cVar2 = this.b;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                cVar2.f192m = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IGmsServiceBroker)) ? new i(iBinder) : (IGmsServiceBroker) iInterfaceQueryLocalInterface;
            } catch (Throwable th) {
                throw th;
            }
        }
        c cVar3 = this.b;
        int i4 = this.f211a;
        cVar3.getClass();
        o oVar = new o(cVar3, 0);
        k kVar2 = cVar3.f189j;
        kVar2.sendMessage(kVar2.obtainMessage(7, i4, -1, oVar));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        c cVar;
        synchronized (this.b.f191l) {
            cVar = this.b;
            cVar.f192m = null;
        }
        int i = this.f211a;
        k kVar = cVar.f189j;
        kVar.sendMessage(kVar.obtainMessage(6, i, 1));
    }
}
