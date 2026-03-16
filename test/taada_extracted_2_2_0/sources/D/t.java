package D;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.CoroutineLiveDataKt;
import androidx.work.PeriodicWorkRequest;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Object f220g = new Object();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static t f221h;
    public static HandlerThread i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f222a = new HashMap();
    public final Context b;
    public volatile O.e c;
    public final K.b d;
    public final long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f223f;

    public t(Context context, Looper looper) {
        s sVar = new s(this, 0);
        this.b = context.getApplicationContext();
        O.e eVar = new O.e(looper, sVar);
        Looper.getMainLooper();
        this.c = eVar;
        if (K.b.b == null) {
            synchronized (K.b.f919a) {
                try {
                    if (K.b.b == null) {
                        K.b bVar = new K.b();
                        new ConcurrentHashMap();
                        K.b.b = bVar;
                    }
                } finally {
                }
            }
        }
        K.b bVar2 = K.b.b;
        j.c(bVar2);
        this.d = bVar2;
        this.e = CoroutineLiveDataKt.DEFAULT_TIMEOUT;
        this.f223f = PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS;
    }

    public final void a(String str, ServiceConnection serviceConnection, boolean z6) {
        p pVar = new p(str, z6);
        j.d(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f222a) {
            try {
                r rVar = (r) this.f222a.get(pVar);
                if (rVar == null) {
                    throw new IllegalStateException("Nonexistent connection status for service config: ".concat(pVar.toString()));
                }
                if (!rVar.f216a.containsKey(serviceConnection)) {
                    throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=".concat(pVar.toString()));
                }
                rVar.f216a.remove(serviceConnection);
                if (rVar.f216a.isEmpty()) {
                    this.c.sendMessageDelayed(this.c.obtainMessage(0, pVar), this.e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean b(p pVar, m mVar, String str) {
        boolean z6;
        synchronized (this.f222a) {
            try {
                r rVar = (r) this.f222a.get(pVar);
                if (rVar == null) {
                    rVar = new r(this, pVar);
                    rVar.f216a.put(mVar, mVar);
                    rVar.a(str, null);
                    this.f222a.put(pVar, rVar);
                } else {
                    this.c.removeMessages(0, pVar);
                    if (rVar.f216a.containsKey(mVar)) {
                        throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=".concat(pVar.toString()));
                    }
                    rVar.f216a.put(mVar, mVar);
                    int i3 = rVar.b;
                    if (i3 == 1) {
                        mVar.onServiceConnected(rVar.f217f, rVar.d);
                    } else if (i3 == 2) {
                        rVar.a(str, null);
                    }
                }
                z6 = rVar.c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z6;
    }
}
