package D;

import A2.B;
import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api$Client;
import com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.BaseGmsClient$ConnectionProgressReportCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient$SignOutCallbacks;
import com.google.android.gms.common.internal.GetServiceRequest;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.IGmsServiceBroker;
import com.google.android.gms.common.internal.zaj;
import com.google.android.gms.common.internal.zzk;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public abstract class c implements Api$Client, zaj {

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public static final Feature[] f182D = new Feature[0];

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public final AtomicInteger f183A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public final Set f184B;
    public final Account C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f185a;
    public long b;
    public long c;
    public int d;
    public long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile String f186f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public B f187g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Context f188h;
    public final t i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final k f189j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Object f190k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Object f191l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public IGmsServiceBroker f192m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public BaseGmsClient$ConnectionProgressReportCallbacks f193n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public IInterface f194o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ArrayList f195p;
    public m q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f196r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final B.g f197s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final B.g f198t;
    public final int u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f199v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public volatile String f200w;
    public ConnectionResult x;
    public boolean y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public volatile zzk f201z;

    public c(Context context, Looper looper, int i, b bVar, GoogleApiClient$ConnectionCallbacks googleApiClient$ConnectionCallbacks, GoogleApiClient$OnConnectionFailedListener googleApiClient$OnConnectionFailedListener) {
        synchronized (t.f220g) {
            try {
                if (t.f221h == null) {
                    t.f221h = new t(context.getApplicationContext(), context.getMainLooper());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        t tVar = t.f221h;
        Object obj = z.b.b;
        j.c(googleApiClient$ConnectionCallbacks);
        j.c(googleApiClient$OnConnectionFailedListener);
        B.g gVar = new B.g(googleApiClient$ConnectionCallbacks, 2);
        B.g gVar2 = new B.g(googleApiClient$OnConnectionFailedListener, 3);
        String str = (String) bVar.d;
        this.f186f = null;
        this.f190k = new Object();
        this.f191l = new Object();
        this.f195p = new ArrayList();
        this.f196r = 1;
        this.x = null;
        this.y = false;
        this.f201z = null;
        this.f183A = new AtomicInteger(0);
        j.d(context, "Context must not be null");
        this.f188h = context;
        j.d(looper, "Looper must not be null");
        j.d(tVar, "Supervisor must not be null");
        this.i = tVar;
        this.f189j = new k(this, looper);
        this.u = i;
        this.f197s = gVar;
        this.f198t = gVar2;
        this.f199v = str;
        this.C = (Account) bVar.f181a;
        Set set = (Set) bVar.b;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (!set.contains((Scope) it.next())) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        this.f184B = set;
    }

    public static /* bridge */ /* synthetic */ boolean g(c cVar, int i, int i3, IInterface iInterface) {
        synchronized (cVar.f190k) {
            try {
                if (cVar.f196r != i) {
                    return false;
                }
                cVar.h(iInterface, i3);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract IInterface a(IBinder iBinder);

    public abstract Feature[] b();

    public abstract Bundle c();

    @Override // com.google.android.gms.common.api.Api$Client
    public final void connect(BaseGmsClient$ConnectionProgressReportCallbacks baseGmsClient$ConnectionProgressReportCallbacks) {
        j.d(baseGmsClient$ConnectionProgressReportCallbacks, "Connection progress callbacks cannot be null.");
        this.f193n = baseGmsClient$ConnectionProgressReportCallbacks;
        h(null, 2);
    }

    public abstract String d();

    @Override // com.google.android.gms.common.api.Api$Client
    public final void disconnect() {
        this.f183A.incrementAndGet();
        synchronized (this.f195p) {
            try {
                int size = this.f195p.size();
                for (int i = 0; i < size; i++) {
                    h hVar = (h) this.f195p.get(i);
                    synchronized (hVar) {
                        hVar.f206a = null;
                    }
                }
                this.f195p.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (this.f191l) {
            this.f192m = null;
        }
        h(null, 1);
    }

    @Override // com.google.android.gms.common.api.Api$Client
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i;
        IInterface iInterface;
        IGmsServiceBroker iGmsServiceBroker;
        synchronized (this.f190k) {
            i = this.f196r;
            iInterface = this.f194o;
        }
        synchronized (this.f191l) {
            iGmsServiceBroker = this.f192m;
        }
        printWriter.append((CharSequence) str).append("mConnectState=");
        if (i == 1) {
            printWriter.print("DISCONNECTED");
        } else if (i == 2) {
            printWriter.print("REMOTE_CONNECTING");
        } else if (i == 3) {
            printWriter.print("LOCAL_CONNECTING");
        } else if (i == 4) {
            printWriter.print("CONNECTED");
        } else if (i != 5) {
            printWriter.print("UNKNOWN");
        } else {
            printWriter.print("DISCONNECTING");
        }
        printWriter.append(" mService=");
        if (iInterface == null) {
            printWriter.append("null");
        } else {
            printWriter.append((CharSequence) d()).append("@").append((CharSequence) Integer.toHexString(System.identityHashCode(iInterface.asBinder())));
        }
        printWriter.append(" mServiceBroker=");
        if (iGmsServiceBroker == null) {
            printWriter.println("null");
        } else {
            printWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(iGmsServiceBroker.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.c > 0) {
            PrintWriter printWriterAppend = printWriter.append((CharSequence) str).append("lastConnectedTime=");
            long j6 = this.c;
            printWriterAppend.println(j6 + " " + simpleDateFormat.format(new Date(j6)));
        }
        if (this.b > 0) {
            printWriter.append((CharSequence) str).append("lastSuspendedCause=");
            int i3 = this.f185a;
            if (i3 == 1) {
                printWriter.append("CAUSE_SERVICE_DISCONNECTED");
            } else if (i3 == 2) {
                printWriter.append("CAUSE_NETWORK_LOST");
            } else if (i3 != 3) {
                printWriter.append((CharSequence) String.valueOf(i3));
            } else {
                printWriter.append("CAUSE_DEAD_OBJECT_EXCEPTION");
            }
            PrintWriter printWriterAppend2 = printWriter.append(" lastSuspendedTime=");
            long j7 = this.b;
            printWriterAppend2.println(j7 + " " + simpleDateFormat.format(new Date(j7)));
        }
        if (this.e > 0) {
            printWriter.append((CharSequence) str).append("lastFailedStatus=").append((CharSequence) E1.k.P(this.d));
            PrintWriter printWriterAppend3 = printWriter.append(" lastFailedTime=");
            long j8 = this.e;
            printWriterAppend3.println(j8 + " " + simpleDateFormat.format(new Date(j8)));
        }
    }

    public abstract String e();

    public abstract boolean f();

    @Override // com.google.android.gms.common.api.Api$Client
    public final Feature[] getAvailableFeatures() {
        zzk zzkVar = this.f201z;
        if (zzkVar == null) {
            return null;
        }
        return zzkVar.b;
    }

    @Override // com.google.android.gms.common.api.Api$Client
    public final String getEndpointPackageName() {
        if (!isConnected() || this.f187g == null) {
            throw new RuntimeException("Failed to connect when checking package");
        }
        return "com.google.android.gms";
    }

    @Override // com.google.android.gms.common.api.Api$Client
    public final String getLastDisconnectMessage() {
        return this.f186f;
    }

    @Override // com.google.android.gms.common.api.Api$Client
    public abstract int getMinApkVersion();

    @Override // com.google.android.gms.common.api.Api$Client
    public final void getRemoteService(IAccountAccessor iAccountAccessor, Set set) {
        Bundle bundleC = c();
        String str = this.f200w;
        int i = z.c.f5159a;
        Scope[] scopeArr = GetServiceRequest.f1946o;
        Bundle bundle = new Bundle();
        int i3 = this.u;
        Feature[] featureArr = GetServiceRequest.f1947p;
        GetServiceRequest getServiceRequest = new GetServiceRequest(6, i3, i, null, null, scopeArr, bundle, null, featureArr, featureArr, true, 0, false, str);
        getServiceRequest.d = this.f188h.getPackageName();
        getServiceRequest.f1950g = bundleC;
        if (set != null) {
            getServiceRequest.f1949f = (Scope[]) set.toArray(new Scope[0]);
        }
        if (requiresSignIn()) {
            Account account = this.C;
            if (account == null) {
                account = new Account("<<default account>>", "com.google");
            }
            getServiceRequest.f1951h = account;
            if (iAccountAccessor != null) {
                getServiceRequest.e = iAccountAccessor.asBinder();
            }
        }
        getServiceRequest.i = f182D;
        getServiceRequest.f1952j = b();
        try {
            synchronized (this.f191l) {
                try {
                    IGmsServiceBroker iGmsServiceBroker = this.f192m;
                    if (iGmsServiceBroker != null) {
                        iGmsServiceBroker.getService(new l(this, this.f183A.get()), getServiceRequest);
                    } else {
                        Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            int i4 = this.f183A.get();
            k kVar = this.f189j;
            kVar.sendMessage(kVar.obtainMessage(6, i4, 3));
        } catch (RemoteException e6) {
            e = e6;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            int i5 = this.f183A.get();
            n nVar = new n(this, 8, null, null);
            k kVar2 = this.f189j;
            kVar2.sendMessage(kVar2.obtainMessage(1, i5, -1, nVar));
        } catch (SecurityException e7) {
            throw e7;
        } catch (RuntimeException e8) {
            e = e8;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            int i52 = this.f183A.get();
            n nVar2 = new n(this, 8, null, null);
            k kVar22 = this.f189j;
            kVar22.sendMessage(kVar22.obtainMessage(1, i52, -1, nVar2));
        }
    }

    @Override // com.google.android.gms.common.api.Api$Client
    public final Feature[] getRequiredFeatures() {
        return new Feature[0];
    }

    @Override // com.google.android.gms.common.api.Api$Client
    public final Set getScopesForConnectionlessNonSignIn() {
        return requiresSignIn() ? this.f184B : Collections.EMPTY_SET;
    }

    @Override // com.google.android.gms.common.api.Api$Client
    public final IBinder getServiceBrokerBinder() {
        synchronized (this.f191l) {
            try {
                IGmsServiceBroker iGmsServiceBroker = this.f192m;
                if (iGmsServiceBroker == null) {
                    return null;
                }
                return iGmsServiceBroker.asBinder();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.api.Api$Client
    public final Intent getSignInIntent() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    public final void h(IInterface iInterface, int i) {
        B b;
        if ((i == 4) != (iInterface != null)) {
            throw new IllegalArgumentException();
        }
        synchronized (this.f190k) {
            try {
                this.f196r = i;
                this.f194o = iInterface;
                if (i == 1) {
                    m mVar = this.q;
                    if (mVar != null) {
                        t tVar = this.i;
                        String str = (String) this.f187g.c;
                        j.c(str);
                        this.f187g.getClass();
                        if (this.f199v == null) {
                            this.f188h.getClass();
                        }
                        tVar.a(str, mVar, this.f187g.b);
                        this.q = null;
                    }
                } else if (i == 2 || i == 3) {
                    m mVar2 = this.q;
                    if (mVar2 != null && (b = this.f187g) != null) {
                        Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + ((String) b.c) + " on com.google.android.gms");
                        t tVar2 = this.i;
                        String str2 = (String) this.f187g.c;
                        j.c(str2);
                        this.f187g.getClass();
                        if (this.f199v == null) {
                            this.f188h.getClass();
                        }
                        tVar2.a(str2, mVar2, this.f187g.b);
                        this.f183A.incrementAndGet();
                    }
                    m mVar3 = new m(this, this.f183A.get());
                    this.q = mVar3;
                    String strE = e();
                    boolean zF = f();
                    this.f187g = new B(strE, 1, zF);
                    if (zF && getMinApkVersion() < 17895000) {
                        throw new IllegalStateException("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(String.valueOf((String) this.f187g.c)));
                    }
                    t tVar3 = this.i;
                    String str3 = (String) this.f187g.c;
                    j.c(str3);
                    this.f187g.getClass();
                    String name = this.f199v;
                    if (name == null) {
                        name = this.f188h.getClass().getName();
                    }
                    if (!tVar3.b(new p(str3, this.f187g.b), mVar3, name)) {
                        Log.w("GmsClient", "unable to connect to service: " + ((String) this.f187g.c) + " on com.google.android.gms");
                        int i3 = this.f183A.get();
                        o oVar = new o(this, 16);
                        k kVar = this.f189j;
                        kVar.sendMessage(kVar.obtainMessage(7, i3, -1, oVar));
                    }
                } else if (i == 4) {
                    j.c(iInterface);
                    this.c = System.currentTimeMillis();
                }
            } finally {
            }
        }
    }

    @Override // com.google.android.gms.common.api.Api$Client, com.google.android.gms.common.internal.zaj
    public final boolean isConnected() {
        boolean z6;
        synchronized (this.f190k) {
            z6 = this.f196r == 4;
        }
        return z6;
    }

    @Override // com.google.android.gms.common.api.Api$Client
    public final boolean isConnecting() {
        boolean z6;
        synchronized (this.f190k) {
            int i = this.f196r;
            z6 = true;
            if (i != 2 && i != 3) {
                z6 = false;
            }
        }
        return z6;
    }

    @Override // com.google.android.gms.common.api.Api$Client
    public final void onUserSignOut(BaseGmsClient$SignOutCallbacks baseGmsClient$SignOutCallbacks) {
        baseGmsClient$SignOutCallbacks.onSignOutComplete();
    }

    @Override // com.google.android.gms.common.api.Api$Client
    public final boolean providesSignIn() {
        return false;
    }

    @Override // com.google.android.gms.common.api.Api$Client
    public final boolean requiresAccount() {
        return false;
    }

    @Override // com.google.android.gms.common.api.Api$Client
    public final boolean requiresGooglePlayServices() {
        return true;
    }

    @Override // com.google.android.gms.common.api.Api$Client
    public boolean requiresSignIn() {
        return false;
    }

    @Override // com.google.android.gms.common.api.Api$Client
    public final void disconnect(String str) {
        this.f186f = str;
        disconnect();
    }
}
