package B;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.CoroutineLiveDataKt;
import androidx.collection.ArraySet;
import androidx.work.PeriodicWorkRequest;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api$ApiOptions;
import com.google.android.gms.common.api.Api$Client;
import com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zau;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public final class m implements GoogleApiClient$ConnectionCallbacks, GoogleApiClient$OnConnectionFailedListener, zau {
    public final Api$Client b;
    public final a c;
    public final h d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f104g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f105h;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ d f107k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList f102a = new LinkedList();
    public final HashSet e = new HashSet();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashMap f103f = new HashMap();
    public final ArrayList i = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ConnectionResult f106j = null;

    public m(d dVar, com.google.android.gms.common.api.c cVar) {
        GoogleSignInAccount googleSignInAccount;
        GoogleSignInAccount googleSignInAccount2;
        this.f107k = dVar;
        Looper looper = dVar.f95m.getLooper();
        cVar.getClass();
        C0.t tVar = new C0.t(1, false);
        Api$ApiOptions.NotRequiredOptions notRequiredOptions = cVar.d;
        boolean z6 = notRequiredOptions instanceof Api$ApiOptions.HasGoogleSignInAccountOptions;
        Account account = null;
        if (z6 && (googleSignInAccount2 = ((Api$ApiOptions.HasGoogleSignInAccountOptions) notRequiredOptions).getGoogleSignInAccount()) != null) {
            String str = googleSignInAccount2.d;
            if (str != null) {
                account = new Account(str, "com.google");
            }
        } else if (notRequiredOptions instanceof Api$ApiOptions.HasAccountOptions) {
            account = ((Api$ApiOptions.HasAccountOptions) notRequiredOptions).getAccount();
        }
        tVar.b = account;
        Collection collectionB = (!z6 || (googleSignInAccount = ((Api$ApiOptions.HasGoogleSignInAccountOptions) notRequiredOptions).getGoogleSignInAccount()) == null) ? Collections.EMPTY_SET : googleSignInAccount.b();
        if (((ArraySet) tVar.c) == null) {
            tVar.c = new ArraySet();
        }
        ((ArraySet) tVar.c).addAll(collectionB);
        Context context = cVar.f1930a;
        tVar.e = context.getClass().getName();
        tVar.d = context.getPackageName();
        D.b bVar = new D.b((Account) tVar.b, (ArraySet) tVar.c, (String) tVar.d, (String) tVar.e);
        F.b bVar2 = cVar.c.f1929a;
        D.j.c(bVar2);
        D.e eVar = cVar.d;
        Context context2 = cVar.f1930a;
        bVar2.getClass();
        F.d dVar2 = new F.d(context2, looper, bVar, eVar, this, this);
        String str2 = cVar.b;
        if (str2 != null) {
            dVar2.f200w = str2;
        }
        this.b = dVar2;
        this.c = cVar.e;
        this.d = new h(1);
        this.f104g = cVar.f1931f;
    }

    public final void a(ConnectionResult connectionResult) {
        HashSet hashSet = this.e;
        Iterator it = hashSet.iterator();
        if (!it.hasNext()) {
            hashSet.clear();
        } else {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (D.j.f(connectionResult, ConnectionResult.e)) {
                this.b.getEndpointPackageName();
            }
            throw null;
        }
    }

    public final void b(Status status) {
        D.j.b(this.f107k.f95m);
        c(status, null, false);
    }

    public final void c(Status status, RuntimeException runtimeException, boolean z6) {
        D.j.b(this.f107k.f95m);
        if ((status == null) == (runtimeException == null)) {
            throw new IllegalArgumentException("Status XOR exception should be null");
        }
        Iterator it = this.f102a.iterator();
        while (it.hasNext()) {
            z zVar = (z) it.next();
            if (!z6 || zVar.f114a == 2) {
                if (status != null) {
                    zVar.a(status);
                } else {
                    zVar.b(runtimeException);
                }
                it.remove();
            }
        }
    }

    public final void d() {
        LinkedList linkedList = this.f102a;
        ArrayList arrayList = new ArrayList(linkedList);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            z zVar = (z) arrayList.get(i);
            if (!this.b.isConnected()) {
                return;
            }
            if (h(zVar)) {
                linkedList.remove(zVar);
            }
        }
    }

    public final void e() {
        d dVar = this.f107k;
        D.j.b(dVar.f95m);
        this.f106j = null;
        a(ConnectionResult.e);
        if (this.f105h) {
            O.e eVar = dVar.f95m;
            a aVar = this.c;
            eVar.removeMessages(11, aVar);
            dVar.f95m.removeMessages(9, aVar);
            this.f105h = false;
        }
        Iterator it = this.f103f.values().iterator();
        if (it.hasNext()) {
            it.next().getClass();
            throw new ClassCastException();
        }
        d();
        g();
    }

    public final void f(int i) {
        d dVar = this.f107k;
        D.j.b(dVar.f95m);
        this.f106j = null;
        this.f105h = true;
        String lastDisconnectMessage = this.b.getLastDisconnectMessage();
        h hVar = this.d;
        hVar.getClass();
        StringBuilder sb = new StringBuilder("The connection to Google Play services was lost");
        if (i == 1) {
            sb.append(" due to service disconnection.");
        } else if (i == 3) {
            sb.append(" due to dead object exception.");
        }
        if (lastDisconnectMessage != null) {
            sb.append(" Last reason for disconnect: ");
            sb.append(lastDisconnectMessage);
        }
        hVar.r(true, new Status(20, sb.toString(), null, null));
        O.e eVar = dVar.f95m;
        a aVar = this.c;
        eVar.sendMessageDelayed(Message.obtain(eVar, 9, aVar), CoroutineLiveDataKt.DEFAULT_TIMEOUT);
        O.e eVar2 = dVar.f95m;
        eVar2.sendMessageDelayed(Message.obtain(eVar2, 11, aVar), 120000L);
        ((SparseIntArray) dVar.f90g.b).clear();
        Iterator it = this.f103f.values().iterator();
        if (it.hasNext()) {
            it.next().getClass();
            throw new ClassCastException();
        }
    }

    public final void g() {
        d dVar = this.f107k;
        O.e eVar = dVar.f95m;
        a aVar = this.c;
        eVar.removeMessages(12, aVar);
        O.e eVar2 = dVar.f95m;
        eVar2.sendMessageDelayed(eVar2.obtainMessage(12, aVar), dVar.f88a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean h(B.z r15) {
        /*
            Method dump skipped, instruction units count: 313
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: B.m.h(B.z):boolean");
    }

    public final boolean i(ConnectionResult connectionResult) {
        synchronized (d.q) {
            this.f107k.getClass();
        }
        return false;
    }

    public final void j() {
        d dVar = this.f107k;
        D.j.b(dVar.f95m);
        Api$Client api$Client = this.b;
        if (api$Client.isConnected() || api$Client.isConnecting()) {
            return;
        }
        try {
            h hVar = dVar.f90g;
            Context context = dVar.e;
            hVar.getClass();
            D.j.c(context);
            int iB = 0;
            if (api$Client.requiresGooglePlayServices()) {
                int minApkVersion = api$Client.getMinApkVersion();
                SparseIntArray sparseIntArray = (SparseIntArray) hVar.b;
                int i = sparseIntArray.get(minApkVersion, -1);
                if (i != -1) {
                    iB = i;
                } else {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= sparseIntArray.size()) {
                            iB = -1;
                            break;
                        }
                        int iKeyAt = sparseIntArray.keyAt(i3);
                        if (iKeyAt > minApkVersion && sparseIntArray.get(iKeyAt) == 0) {
                            break;
                        } else {
                            i3++;
                        }
                    }
                    if (iB == -1) {
                        iB = ((z.b) hVar.c).b(context, minApkVersion);
                    }
                    sparseIntArray.put(minApkVersion, iB);
                }
            }
            if (iB == 0) {
                p pVar = new p(dVar, api$Client, this.c);
                if (api$Client.requiresSignIn()) {
                    D.j.c(null);
                    throw null;
                }
                try {
                    api$Client.connect(pVar);
                    return;
                } catch (SecurityException e) {
                    l(new ConnectionResult(10), e);
                    return;
                }
            }
            ConnectionResult connectionResult = new ConnectionResult(iB, null);
            Log.w("GoogleApiManager", "The service for " + api$Client.getClass().getName() + " is not available: " + connectionResult.toString());
            l(connectionResult, null);
        } catch (IllegalStateException e6) {
            l(new ConnectionResult(10), e6);
        }
    }

    public final void k(r rVar) {
        D.j.b(this.f107k.f95m);
        boolean zIsConnected = this.b.isConnected();
        LinkedList linkedList = this.f102a;
        if (zIsConnected) {
            if (h(rVar)) {
                g();
                return;
            } else {
                linkedList.add(rVar);
                return;
            }
        }
        linkedList.add(rVar);
        ConnectionResult connectionResult = this.f106j;
        if (connectionResult == null || connectionResult.b == 0 || connectionResult.c == null) {
            j();
        } else {
            l(connectionResult, null);
        }
    }

    public final void l(ConnectionResult connectionResult, RuntimeException runtimeException) {
        D.j.b(this.f107k.f95m);
        D.j.b(this.f107k.f95m);
        this.f106j = null;
        ((SparseIntArray) this.f107k.f90g.b).clear();
        a(connectionResult);
        if ((this.b instanceof F.d) && connectionResult.b != 24) {
            d dVar = this.f107k;
            dVar.b = true;
            O.e eVar = dVar.f95m;
            eVar.sendMessageDelayed(eVar.obtainMessage(19), PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS);
        }
        if (connectionResult.b == 4) {
            b(d.f86p);
            return;
        }
        if (this.f102a.isEmpty()) {
            this.f106j = connectionResult;
            return;
        }
        if (runtimeException != null) {
            D.j.b(this.f107k.f95m);
            c(null, runtimeException, false);
            return;
        }
        if (!this.f107k.f96n) {
            b(d.b(this.c, connectionResult));
            return;
        }
        c(d.b(this.c, connectionResult), null, true);
        if (this.f102a.isEmpty() || i(connectionResult) || this.f107k.a(connectionResult, this.f104g)) {
            return;
        }
        if (connectionResult.b == 18) {
            this.f105h = true;
        }
        if (!this.f105h) {
            b(d.b(this.c, connectionResult));
            return;
        }
        d dVar2 = this.f107k;
        a aVar = this.c;
        O.e eVar2 = dVar2.f95m;
        eVar2.sendMessageDelayed(Message.obtain(eVar2, 9, aVar), CoroutineLiveDataKt.DEFAULT_TIMEOUT);
    }

    public final void m(ConnectionResult connectionResult) {
        D.j.b(this.f107k.f95m);
        Api$Client api$Client = this.b;
        api$Client.disconnect("onSignInFailed for " + api$Client.getClass().getName() + " with " + String.valueOf(connectionResult));
        l(connectionResult, null);
    }

    public final void n() {
        D.j.b(this.f107k.f95m);
        Status status = d.f85o;
        b(status);
        h hVar = this.d;
        hVar.getClass();
        hVar.r(false, status);
        for (f fVar : (f[]) this.f103f.keySet().toArray(new f[0])) {
            k(new y(new com.google.android.gms.tasks.c()));
        }
        a(new ConnectionResult(4));
        Api$Client api$Client = this.b;
        if (api$Client.isConnected()) {
            api$Client.onUserSignOut(new g(this, 1));
        }
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        Looper looperMyLooper = Looper.myLooper();
        d dVar = this.f107k;
        if (looperMyLooper == dVar.f95m.getLooper()) {
            e();
        } else {
            dVar.f95m.post(new k(this, 0));
        }
    }

    @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        l(connectionResult, null);
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        Looper looperMyLooper = Looper.myLooper();
        d dVar = this.f107k;
        if (looperMyLooper == dVar.f95m.getLooper()) {
            f(i);
        } else {
            dVar.f95m.post(new l(i, 0, this));
        }
    }

    @Override // com.google.android.gms.common.api.internal.zau
    public final void zaa(ConnectionResult connectionResult, com.google.android.gms.common.api.b bVar, boolean z6) {
        throw null;
    }
}
