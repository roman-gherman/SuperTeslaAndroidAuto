package t0;

import C0.x;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.RemoteException;
import com.android.billingclient.api.C;
import com.google.android.play.core.review.internal.zzf;
import com.google.android.play.core.review.internal.zzo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final HashMap f4783n = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4784a;
    public final E1.h b;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f4786g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Intent f4787h;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public C f4790l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public zzf f4791m;
    public final ArrayList d = new ArrayList();
    public final HashSet e = new HashSet();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f4785f = new Object();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final e f4788j = new IBinder.DeathRecipient() { // from class: t0.e
        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            h hVar = this.f4782a;
            hVar.b.a("reportBinderDeath", new Object[0]);
            zzo zzoVar = (zzo) hVar.i.get();
            if (zzoVar != null) {
                hVar.b.a("calling onBinderDied", new Object[0]);
                zzoVar.zza();
            } else {
                hVar.b.a("%s : Binder has died.", hVar.c);
                for (d dVar : hVar.d) {
                    RemoteException remoteException = new RemoteException(String.valueOf(hVar.c).concat(" : Binder has died."));
                    com.google.android.gms.tasks.c cVar = dVar.f4781a;
                    if (cVar != null) {
                        cVar.a(remoteException);
                    }
                }
                hVar.d.clear();
            }
            synchronized (hVar.f4785f) {
                hVar.c();
            }
        }
    };

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AtomicInteger f4789k = new AtomicInteger(0);
    public final String c = "com.google.android.finsky.inappreviewservice.InAppReviewService";
    public final WeakReference i = new WeakReference(null);

    /* JADX WARN: Type inference failed for: r0v3, types: [t0.e] */
    public h(Context context, E1.h hVar, Intent intent) {
        this.f4784a = context;
        this.b = hVar;
        this.f4787h = intent;
    }

    public static void b(h hVar, com.google.android.play.core.review.d dVar) {
        zzf zzfVar = hVar.f4791m;
        ArrayList<d> arrayList = hVar.d;
        E1.h hVar2 = hVar.b;
        if (zzfVar != null || hVar.f4786g) {
            if (!hVar.f4786g) {
                dVar.run();
                return;
            } else {
                hVar2.a("Waiting to bind to the service.", new Object[0]);
                arrayList.add(dVar);
                return;
            }
        }
        hVar2.a("Initiate binding to the service.", new Object[0]);
        arrayList.add(dVar);
        C c = new C(hVar, 1);
        hVar.f4790l = c;
        hVar.f4786g = true;
        if (hVar.f4784a.bindService(hVar.f4787h, c, 1)) {
            return;
        }
        hVar2.a("Failed to bind to the service.", new Object[0]);
        hVar.f4786g = false;
        for (d dVar2 : arrayList) {
            x xVar = new x("Failed to bind to the service.");
            com.google.android.gms.tasks.c cVar = dVar2.f4781a;
            if (cVar != null) {
                cVar.a(xVar);
            }
        }
        arrayList.clear();
    }

    public final Handler a() {
        Handler handler;
        HashMap map = f4783n;
        synchronized (map) {
            try {
                if (!map.containsKey(this.c)) {
                    HandlerThread handlerThread = new HandlerThread(this.c, 10);
                    handlerThread.start();
                    map.put(this.c, new Handler(handlerThread.getLooper()));
                }
                handler = (Handler) map.get(this.c);
            } catch (Throwable th) {
                throw th;
            }
        }
        return handler;
    }

    public final void c() {
        HashSet hashSet = this.e;
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((com.google.android.gms.tasks.c) it.next()).a(new RemoteException(String.valueOf(this.c).concat(" : Binder has died.")));
        }
        hashSet.clear();
    }
}
