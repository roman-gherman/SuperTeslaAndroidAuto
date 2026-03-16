package B;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import androidx.collection.ArraySet;
import androidx.work.WorkRequest;
import c4.AbstractC0246d;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.TelemetryData;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class d implements Handler.Callback {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Status f85o = new Status(4, "Sign-out occurred while this API call was in progress.", null, null);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Status f86p = new Status(4, "The user must be signed in to make this API call.", null, null);
    public static final Object q = new Object();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static d f87r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f88a;
    public boolean b;
    public TelemetryData c;
    public F.c d;
    public final Context e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final z.b f89f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final h f90g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicInteger f91h;
    public final AtomicInteger i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ConcurrentHashMap f92j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArraySet f93k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArraySet f94l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final O.e f95m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public volatile boolean f96n;

    public d(Context context, Looper looper) {
        z.b bVar = z.b.c;
        this.f88a = WorkRequest.MIN_BACKOFF_MILLIS;
        this.b = false;
        this.f91h = new AtomicInteger(1);
        this.i = new AtomicInteger(0);
        this.f92j = new ConcurrentHashMap(5, 0.75f, 1);
        this.f93k = new ArraySet();
        this.f94l = new ArraySet();
        this.f96n = true;
        this.e = context;
        O.e eVar = new O.e(looper, this);
        Looper.getMainLooper();
        this.f95m = eVar;
        this.f89f = bVar;
        this.f90g = new h(5);
        PackageManager packageManager = context.getPackageManager();
        if (AbstractC0246d.f1789g == null) {
            AbstractC0246d.f1789g = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.automotive"));
        }
        if (AbstractC0246d.f1789g.booleanValue()) {
            this.f96n = false;
        }
        eVar.sendMessage(eVar.obtainMessage(6));
    }

    public static Status b(a aVar, ConnectionResult connectionResult) {
        return new Status(17, androidx.constraintlayout.core.motion.a.r("API: ", aVar.b.b, " is not available on this device. Connection failed with: ", String.valueOf(connectionResult)), connectionResult.c, connectionResult);
    }

    public static d d(Context context) {
        d dVar;
        HandlerThread handlerThread;
        synchronized (q) {
            if (f87r == null) {
                synchronized (D.t.f220g) {
                    try {
                        handlerThread = D.t.i;
                        if (handlerThread == null) {
                            HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", 9);
                            D.t.i = handlerThread2;
                            handlerThread2.start();
                            handlerThread = D.t.i;
                        }
                    } finally {
                    }
                }
                Looper looper = handlerThread.getLooper();
                Context applicationContext = context.getApplicationContext();
                Object obj = z.b.b;
                f87r = new d(applicationContext, looper);
            }
            dVar = f87r;
        }
        return dVar;
    }

    public final boolean a(ConnectionResult connectionResult, int i) {
        boolean zBooleanValue;
        PendingIntent activity;
        Boolean bool;
        z.b bVar = this.f89f;
        Context context = this.e;
        bVar.getClass();
        synchronized (AbstractC0246d.class) {
            Context applicationContext = context.getApplicationContext();
            Context context2 = AbstractC0246d.b;
            if (context2 == null || (bool = AbstractC0246d.c) == null || context2 != applicationContext) {
                AbstractC0246d.c = null;
                boolean zIsInstantApp = applicationContext.getPackageManager().isInstantApp();
                AbstractC0246d.c = Boolean.valueOf(zIsInstantApp);
                AbstractC0246d.b = applicationContext;
                zBooleanValue = zIsInstantApp;
            } else {
                zBooleanValue = bool.booleanValue();
            }
        }
        if (!zBooleanValue) {
            int i3 = connectionResult.b;
            if (i3 == 0 || (activity = connectionResult.c) == null) {
                Intent intentA = bVar.a(context, i3, null);
                activity = intentA != null ? PendingIntent.getActivity(context, 0, intentA, 201326592) : null;
            }
            if (activity != null) {
                int i4 = connectionResult.b;
                int i5 = GoogleApiActivity.b;
                Intent intent = new Intent(context, (Class<?>) GoogleApiActivity.class);
                intent.putExtra("pending_intent", activity);
                intent.putExtra("failing_client_id", i);
                intent.putExtra("notify_manager", true);
                bVar.f(context, i4, PendingIntent.getActivity(context, 0, intent, O.d.f1176a | 134217728));
                return true;
            }
        }
        return false;
    }

    public final m c(com.google.android.gms.common.api.c cVar) {
        ConcurrentHashMap concurrentHashMap = this.f92j;
        a aVar = cVar.e;
        m mVar = (m) concurrentHashMap.get(aVar);
        if (mVar == null) {
            mVar = new m(this, cVar);
            concurrentHashMap.put(aVar, mVar);
        }
        if (mVar.b.requiresSignIn()) {
            this.f94l.add(aVar);
        }
        mVar.j();
        return mVar;
    }

    public final void e(ConnectionResult connectionResult, int i) {
        if (a(connectionResult, i)) {
            return;
        }
        O.e eVar = this.f95m;
        eVar.sendMessage(eVar.obtainMessage(5, i, 0, connectionResult));
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0123  */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean handleMessage(android.os.Message r12) {
        /*
            Method dump skipped, instruction units count: 1174
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: B.d.handleMessage(android.os.Message):boolean");
    }
}
