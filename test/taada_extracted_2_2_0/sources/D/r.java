package D;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.os.StrictMode;
import com.google.android.gms.common.internal.zzt;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class r implements ServiceConnection, zzt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f216a = new HashMap();
    public int b = 2;
    public boolean c;
    public IBinder d;
    public final p e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ComponentName f217f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ t f218g;

    public r(t tVar, p pVar) {
        this.f218g = tVar;
        this.e = pVar;
    }

    public final void a(String str, Executor executor) throws Throwable {
        this.b = 3;
        StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
        if (Build.VERSION.SDK_INT >= 31) {
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder(vmPolicy).permitUnsafeIntentLaunch().build());
        }
        try {
            t tVar = this.f218g;
            K.b bVar = tVar.d;
            Context context = tVar.b;
            try {
                boolean zB = bVar.b(context, str, this.e.a(context), this, executor);
                this.c = zB;
                if (zB) {
                    this.f218g.c.sendMessageDelayed(this.f218g.c.obtainMessage(1, this.e), this.f218g.f223f);
                } else {
                    this.b = 2;
                    try {
                        t tVar2 = this.f218g;
                        tVar2.d.a(tVar2.b, this);
                    } catch (IllegalArgumentException unused) {
                    }
                }
                StrictMode.setVmPolicy(vmPolicy);
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                StrictMode.setVmPolicy(vmPolicy);
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        onServiceDisconnected(componentName);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f218g.f222a) {
            try {
                this.f218g.c.removeMessages(1, this.e);
                this.d = iBinder;
                this.f217f = componentName;
                Iterator it = this.f216a.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceConnected(componentName, iBinder);
                }
                this.b = 1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f218g.f222a) {
            try {
                this.f218g.c.removeMessages(1, this.e);
                this.d = null;
                this.f217f = componentName;
                Iterator it = this.f216a.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceDisconnected(componentName);
                }
                this.b = 2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
