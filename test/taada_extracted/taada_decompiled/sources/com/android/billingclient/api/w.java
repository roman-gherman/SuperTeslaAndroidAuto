package com.android.billingclient.api;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import androidx.work.WorkRequest;
import com.google.android.gms.internal.play_billing.AbstractBinderC0267c;
import com.google.android.gms.internal.play_billing.AbstractC0289j0;
import com.google.android.gms.internal.play_billing.C0264b;
import com.google.android.gms.internal.play_billing.I1;
import com.google.android.gms.internal.play_billing.J1;
import com.google.android.gms.internal.play_billing.M1;
import com.google.android.gms.internal.play_billing.N1;
import com.google.android.gms.internal.play_billing.P1;
import com.google.android.gms.internal.play_billing.e2;
import com.google.android.gms.internal.play_billing.zzan;
import fr.sd.taada.billing.BillingManager;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class w implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BillingManager f1861a;
    public final /* synthetic */ C0253d b;

    public /* synthetic */ w(C0253d c0253d, BillingManager billingManager) {
        this.b = c0253d;
        this.f1861a = billingManager;
    }

    public final void a(C0257h c0257h) {
        synchronized (this.b.f1826a) {
            try {
                if (this.b.b == 3) {
                    return;
                }
                this.f1861a.onBillingSetupFinished(c0257h);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        boolean z6;
        AbstractC0289j0.f("BillingClient", "Billing service died.");
        try {
            C0253d c0253d = this.b;
            synchronized (c0253d.f1826a) {
                z6 = true;
                if (c0253d.b != 1) {
                    z6 = false;
                }
            }
            if (z6) {
                I i = this.b.f1828g;
                I1 i1P = J1.p();
                i1P.d();
                J1.o((J1) i1P.b, 6);
                M1 m1Q = N1.q();
                m1Q.e(122);
                i1P.e(m1Q);
                i.zza((J1) i1P.b());
            } else {
                this.b.f1828g.zze(P1.m());
            }
        } catch (Throwable th) {
            AbstractC0289j0.g("BillingClient", "Unable to log.", th);
        }
        synchronized (this.b.f1826a) {
            if (this.b.b != 3 && this.b.b != 0) {
                this.b.n(0);
                this.b.o();
                this.f1861a.onBillingServiceDisconnected();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zzan c0264b;
        AbstractC0289j0.e("BillingClient", "Billing service connected.");
        synchronized (this.b.f1826a) {
            try {
                if (this.b.b == 3) {
                    return;
                }
                C0253d c0253d = this.b;
                int i = AbstractBinderC0267c.b;
                if (iBinder == null) {
                    c0264b = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.android.vending.billing.IInAppBillingService");
                    c0264b = iInterfaceQueryLocalInterface instanceof zzan ? (zzan) iInterfaceQueryLocalInterface : new C0264b(iBinder, "com.android.vending.billing.IInAppBillingService", 1);
                }
                c0253d.f1829h = c0264b;
                C0253d c0253d2 = this.b;
                if (C0253d.h(new Callable() { // from class: com.android.billingclient.api.v
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Removed duplicated region for block: B:141:0x01bd  */
                    /* JADX WARN: Removed duplicated region for block: B:142:0x01c2  */
                    @Override // java.util.concurrent.Callable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object call() throws java.lang.Throwable {
                        /*
                            Method dump skipped, instruction units count: 663
                            To view this dump add '--comments-level debug' option
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.v.call():java.lang.Object");
                    }
                }, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, new B.k(this, 4), c0253d2.s(), c0253d2.l()) == null) {
                    C0253d c0253d3 = this.b;
                    C0257h c0257hI = c0253d3.i();
                    c0253d3.u(25, 6, c0257hI);
                    a(c0257hI);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        boolean z6;
        AbstractC0289j0.f("BillingClient", "Billing service disconnected.");
        try {
            C0253d c0253d = this.b;
            synchronized (c0253d.f1826a) {
                z6 = true;
                if (c0253d.b != 1) {
                    z6 = false;
                }
            }
            if (z6) {
                I i = this.b.f1828g;
                I1 i1P = J1.p();
                i1P.d();
                J1.o((J1) i1P.b, 6);
                M1 m1Q = N1.q();
                m1Q.e(121);
                i1P.e(m1Q);
                i.zza((J1) i1P.b());
            } else {
                this.b.f1828g.zzg(e2.m());
            }
        } catch (Throwable th) {
            AbstractC0289j0.g("BillingClient", "Unable to log.", th);
        }
        synchronized (this.b.f1826a) {
            try {
                if (this.b.b == 3) {
                    return;
                }
                this.b.n(0);
                this.f1861a.onBillingServiceDisconnected();
            } finally {
            }
        }
    }
}
