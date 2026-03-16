package com.android.billingclient.api;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import com.google.android.gms.internal.play_billing.AbstractC0263a1;
import com.google.android.gms.internal.play_billing.AbstractC0289j0;
import com.google.android.gms.internal.play_billing.C0290j1;
import com.google.android.gms.internal.play_billing.C0307p0;
import com.google.android.gms.internal.play_billing.C0318t0;
import com.google.android.gms.internal.play_billing.C0327w0;
import com.google.android.gms.internal.play_billing.C0336z0;
import com.google.android.gms.internal.play_billing.EnumC0298m0;
import com.google.android.gms.internal.play_billing.J1;
import com.google.android.gms.internal.play_billing.L1;
import com.google.android.gms.internal.play_billing.RunnableC0304o0;
import com.google.android.gms.internal.play_billing.RunnableC0330x0;
import com.google.android.gms.internal.play_billing.j2;
import com.google.android.gms.internal.play_billing.k2;
import com.google.android.gms.internal.play_billing.l2;
import com.google.android.gms.internal.play_billing.m2;
import com.google.android.gms.internal.play_billing.n2;
import com.google.android.gms.internal.play_billing.zzeu;
import com.google.android.gms.internal.play_billing.zzev;
import com.google.android.gms.internal.play_billing.zzew;
import fr.sd.taada.billing.BillingManager;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes.dex */
public final class D extends C0253d {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public volatile int f1802A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public volatile com.google.android.gms.internal.play_billing.zzav f1803B;
    public volatile C C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public volatile zzew f1804D;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Context f1805z;

    public D(n0.d dVar, Context context) {
        super(dVar, context);
        this.f1802A = 0;
        this.f1805z = context;
    }

    public final zzeu A(int i) {
        if (!z()) {
            AbstractC0289j0.f("BillingClientTesting", "Billing Override Service is not ready.");
            B(106, 28, H.a(-1, "Billing Override Service connection is disconnected."));
            return new C0307p0();
        }
        z zVar = new z(this, i);
        k2 k2Var = new k2();
        k2Var.c = new n2();
        m2 m2Var = new m2(k2Var);
        k2Var.b = m2Var;
        k2Var.f2099a = z.class;
        try {
            zVar.c(k2Var);
            k2Var.f2099a = "billingOverrideService.getBillingOverride";
            return m2Var;
        } catch (Exception e) {
            C0290j1 c0290j1 = new C0290j1(e);
            AbstractC0263a1 abstractC0263a1 = j2.f2094f;
            l2 l2Var = m2Var.b;
            if (abstractC0263a1.u(l2Var, null, c0290j1)) {
                j2.b(l2Var);
            }
            return m2Var;
        }
    }

    public final void B(int i, int i3, C0257h c0257h) {
        J1 j1B = G.b(i, i3, c0257h);
        Objects.requireNonNull(j1B, "ApiFailure should not be null");
        this.f1828g.zza(j1B);
    }

    public final void C(int i, Consumer consumer, Runnable runnable) {
        zzew zzewVar;
        zzev zzevVar;
        zzev c0327w0;
        zzeu zzeuVarA = A(i);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        synchronized (this) {
            try {
                if (this.f1804D == null) {
                    ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
                    this.f1804D = scheduledExecutorServiceNewSingleThreadScheduledExecutor instanceof zzew ? (zzew) scheduledExecutorServiceNewSingleThreadScheduledExecutor : new C0327w0(scheduledExecutorServiceNewSingleThreadScheduledExecutor);
                }
                zzewVar = this.f1804D;
            } finally {
            }
        }
        if (!zzeuVarA.isDone()) {
            C0336z0 c0336z0 = new C0336z0();
            c0336z0.f2137h = zzeuVarA;
            RunnableC0330x0 runnableC0330x0 = new RunnableC0330x0();
            runnableC0330x0.f2134a = c0336z0;
            c0336z0.i = zzewVar.schedule(runnableC0330x0, 28500L, timeUnit);
            zzeuVarA.zzb(runnableC0330x0, EnumC0298m0.f2104a);
            zzeuVarA = c0336z0;
        }
        A a6 = new A(this, i, consumer, runnable);
        synchronized (this) {
            try {
                if (this.x == null) {
                    ExecutorService executorServiceL = l();
                    if (executorServiceL instanceof zzev) {
                        c0327w0 = (zzev) executorServiceL;
                    } else {
                        c0327w0 = executorServiceL instanceof ScheduledExecutorService ? new C0327w0((ScheduledExecutorService) executorServiceL) : new C0318t0(executorServiceL);
                    }
                    this.x = c0327w0;
                }
                zzevVar = this.x;
            } finally {
            }
        }
        zzeuVarA.zzb(new RunnableC0304o0(zzeuVarA, a6), zzevVar);
    }

    @Override // com.android.billingclient.api.C0253d, com.android.billingclient.api.AbstractC0252c
    public final void a(E1.h hVar, R0.d dVar) {
        C(3, new x(dVar, 1), new y(this, hVar, dVar, 1));
    }

    @Override // com.android.billingclient.api.C0253d, com.android.billingclient.api.AbstractC0252c
    public final void b() {
        synchronized (this) {
            L1 l1D = G.d(27);
            Objects.requireNonNull(l1D, "ApiSuccess should not be null");
            this.f1828g.zzc(l1D);
            try {
                try {
                    if (this.C != null && this.f1803B != null) {
                        AbstractC0289j0.e("BillingClientTesting", "Unbinding from Billing Override Service.");
                        this.f1805z.unbindService(this.C);
                        this.C = new C(this, 0);
                    }
                    this.f1803B = null;
                    if (this.f1804D != null) {
                        this.f1804D.shutdownNow();
                        this.f1804D = null;
                    }
                } catch (RuntimeException e) {
                    AbstractC0289j0.g("BillingClientTesting", "There was an exception while ending Billing Override Service connection!", e);
                }
                this.f1802A = 3;
            } catch (Throwable th) {
                this.f1802A = 3;
                throw th;
            }
        }
        super.b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.android.billingclient.api.C0253d, com.android.billingclient.api.AbstractC0252c
    public final C0257h d(Activity activity, C0256g c0256g) {
        int iIntValue = 0;
        try {
            iIntValue = ((Integer) A(2).get(28500L, TimeUnit.MILLISECONDS)).intValue();
        } catch (TimeoutException e) {
            B(114, 28, H.f1818s);
            AbstractC0289j0.g("BillingClientTesting", "Asynchronous call to Billing Override Service timed out.", e);
        } catch (Exception e6) {
            if (e6 instanceof InterruptedException) {
                Thread.currentThread().interrupt();
            }
            B(107, 28, H.f1818s);
            AbstractC0289j0.g("BillingClientTesting", "An error occurred while retrieving billing override.", e6);
        }
        if (iIntValue > 0) {
            C0257h c0257hA = H.a(iIntValue, "Billing override value was set by a license tester.");
            B(105, 2, c0257hA);
            w(c0257hA);
            return c0257hA;
        }
        try {
            return super.d(activity, c0256g);
        } catch (Exception e7) {
            C0257h c0257h = H.i;
            B(115, 2, c0257h);
            AbstractC0289j0.g("BillingClientTesting", "An internal error occurred.", e7);
            return c0257h;
        }
    }

    @Override // com.android.billingclient.api.C0253d, com.android.billingclient.api.AbstractC0252c
    public final void e(o oVar, ProductDetailsResponseListener productDetailsResponseListener) {
        C(7, new x(productDetailsResponseListener, 0), new y(this, oVar, productDetailsResponseListener, 0));
    }

    @Override // com.android.billingclient.api.C0253d, com.android.billingclient.api.AbstractC0252c
    public final void g(BillingManager billingManager) {
        synchronized (this) {
            if (z()) {
                AbstractC0289j0.e("BillingClientTesting", "Billing Override Service connection is valid. No need to re-initialize.");
                L1 l1D = G.d(26);
                Objects.requireNonNull(l1D, "ApiSuccess should not be null");
                this.f1828g.zzc(l1D);
            } else {
                int i = 1;
                if (this.f1802A == 1) {
                    AbstractC0289j0.f("BillingClientTesting", "Client is already in the process of connecting to Billing Override Service.");
                } else if (this.f1802A == 3) {
                    AbstractC0289j0.f("BillingClientTesting", "Billing Override Service Client was already closed and can't be reused. Please create another instance.");
                    B(38, 26, H.a(-1, "Billing Override Service connection is disconnected."));
                } else {
                    this.f1802A = 1;
                    AbstractC0289j0.e("BillingClientTesting", "Starting Billing Override Service setup.");
                    this.C = new C(this, 0);
                    Intent intent = new Intent("com.google.android.apps.play.billingtestcompanion.BillingOverrideService.BIND");
                    intent.setPackage("com.google.android.apps.play.billingtestcompanion");
                    List<ResolveInfo> listQueryIntentServices = this.f1805z.getPackageManager().queryIntentServices(intent, 0);
                    if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
                        i = 41;
                    } else {
                        ServiceInfo serviceInfo = listQueryIntentServices.get(0).serviceInfo;
                        if (serviceInfo != null) {
                            String str = serviceInfo.packageName;
                            String str2 = serviceInfo.name;
                            if (!Objects.equals(str, "com.google.android.apps.play.billingtestcompanion") || str2 == null) {
                                AbstractC0289j0.f("BillingClientTesting", "The device doesn't have valid Play Billing Lab.");
                            } else {
                                ComponentName componentName = new ComponentName(str, str2);
                                Intent intent2 = new Intent(intent);
                                intent2.setComponent(componentName);
                                if (this.f1805z.bindService(intent2, this.C, 1)) {
                                    AbstractC0289j0.e("BillingClientTesting", "Billing Override Service was bonded successfully.");
                                } else {
                                    AbstractC0289j0.f("BillingClientTesting", "Connection to Billing Override Service is blocked.");
                                }
                            }
                            i = 39;
                        }
                    }
                    this.f1802A = 0;
                    AbstractC0289j0.e("BillingClientTesting", "Billing Override Service unavailable on device.");
                    B(i, 26, H.a(2, "Billing Override Service unavailable on device."));
                }
            }
        }
        super.g(billingManager);
    }

    public final /* synthetic */ void x(E1.h hVar, R0.d dVar) {
        super.a(hVar, dVar);
    }

    public final /* synthetic */ void y(o oVar, ProductDetailsResponseListener productDetailsResponseListener) {
        super.e(oVar, productDetailsResponseListener);
    }

    public final synchronized boolean z() {
        if (this.f1802A == 2 && this.f1803B != null) {
            if (this.C != null) {
                return true;
            }
        }
        return false;
    }

    public D(n0.d dVar, Context context, BillingManager billingManager) {
        super(dVar, context, billingManager);
        this.f1802A = 0;
        this.f1805z = context;
    }
}
