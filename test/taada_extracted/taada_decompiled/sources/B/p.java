package B;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.util.Log;
import com.android.billingclient.api.I;
import com.android.billingclient.api.K;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api$Client;
import com.google.android.gms.common.api.internal.zacs;
import com.google.android.gms.common.internal.BaseGmsClient$ConnectionProgressReportCallbacks;
import com.google.android.gms.common.internal.IAccountAccessor;
import fr.sd.taada.billing.BillingManager;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class p implements BaseGmsClient$ConnectionProgressReportCallbacks, zacs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f110a;
    public final Object b;
    public final Object c;
    public Object d;
    public Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f111f;

    public p(d dVar, Api$Client api$Client, a aVar) {
        this.f111f = dVar;
        this.d = null;
        this.e = null;
        this.f110a = false;
        this.b = api$Client;
        this.c = aVar;
    }

    public void a(boolean z6) {
        IntentFilter intentFilter = new IntentFilter("com.android.vending.billing.PURCHASES_UPDATED");
        IntentFilter intentFilter2 = new IntentFilter("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED");
        intentFilter2.addAction("com.android.vending.billing.ALTERNATIVE_BILLING");
        this.f110a = z6;
        ((K) this.f111f).a((Context) this.b, intentFilter2);
        if (!this.f110a) {
            ((K) this.e).a((Context) this.b, intentFilter);
            return;
        }
        K k6 = (K) this.e;
        Context context = (Context) this.b;
        synchronized (k6) {
            try {
                if (k6.f1821a) {
                    return;
                }
                if (Build.VERSION.SDK_INT >= 33) {
                    context.registerReceiver(k6, intentFilter, "com.google.android.finsky.permission.PLAY_BILLING_LIBRARY_BROADCAST", null, true != k6.b ? 4 : 2);
                } else {
                    context.registerReceiver(k6, intentFilter, "com.google.android.finsky.permission.PLAY_BILLING_LIBRARY_BROADCAST", null);
                }
                k6.f1821a = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient$ConnectionProgressReportCallbacks
    public void onReportServiceBinding(ConnectionResult connectionResult) {
        ((d) this.f111f).f95m.post(new o(0, this, connectionResult));
    }

    @Override // com.google.android.gms.common.api.internal.zacs
    public void zae(ConnectionResult connectionResult) {
        m mVar = (m) ((d) this.f111f).f92j.get((a) this.c);
        if (mVar != null) {
            mVar.m(connectionResult);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zacs
    public void zaf(IAccountAccessor iAccountAccessor, Set set) {
        if (iAccountAccessor == null || set == null) {
            Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
            zae(new ConnectionResult(4));
            return;
        }
        this.d = iAccountAccessor;
        this.e = set;
        if (this.f110a) {
            ((Api$Client) this.b).getRemoteService(iAccountAccessor, set);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zacs
    public void zag(int i) {
        m mVar = (m) ((d) this.f111f).f92j.get((a) this.c);
        if (mVar != null) {
            if (mVar.f105h) {
                mVar.m(new ConnectionResult(17));
            } else {
                mVar.onConnectionSuspended(i);
            }
        }
    }

    public p(Context context, BillingManager billingManager, I i) {
        this.b = context;
        this.c = billingManager;
        this.d = i;
        this.e = new K(this, true);
        this.f111f = new K(this, false);
    }
}
