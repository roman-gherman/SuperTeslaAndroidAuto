package com.android.billingclient.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.CoroutineLiveDataKt;
import androidx.work.WorkRequest;
import com.android.billingclient.api.C0255f;
import com.google.android.gms.internal.play_billing.AbstractC0263a1;
import com.google.android.gms.internal.play_billing.AbstractC0289j0;
import com.google.android.gms.internal.play_billing.AbstractC0300n;
import com.google.android.gms.internal.play_billing.C0329x;
import com.google.android.gms.internal.play_billing.F0;
import com.google.android.gms.internal.play_billing.G0;
import com.google.android.gms.internal.play_billing.J1;
import com.google.android.gms.internal.play_billing.K1;
import com.google.android.gms.internal.play_billing.L1;
import com.google.android.gms.internal.play_billing.O;
import com.google.android.gms.internal.play_billing.S1;
import com.google.android.gms.internal.play_billing.T1;
import com.google.android.gms.internal.play_billing.f2;
import com.google.android.gms.internal.play_billing.g2;
import com.google.android.gms.internal.play_billing.zzan;
import com.google.android.gms.internal.play_billing.zzev;
import fr.sd.taada.billing.BillingManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;
import java.util.function.Predicate;

/* JADX INFO: renamed from: com.android.billingclient.api.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0253d extends AbstractC0252c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f1826a;
    public volatile int b;
    public final String c;
    public final Handler d;
    public volatile B.p e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Context f1827f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final I f1828g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile zzan f1829h;
    public volatile w i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f1830j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f1831k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f1832l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f1833m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f1834n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f1835o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f1836p;
    public boolean q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f1837r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f1838s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f1839t;
    public final n0.d u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f1840v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ExecutorService f1841w;
    public volatile zzev x;
    public final Long y;

    public C0253d(n0.d dVar, Context context) {
        this.f1826a = new Object();
        this.b = 0;
        this.d = new Handler(Looper.getMainLooper());
        this.f1831k = 0;
        long jNextLong = new Random().nextLong();
        this.y = Long.valueOf(jNextLong);
        this.c = k();
        this.f1827f = context.getApplicationContext();
        S1 s1Q = T1.q();
        String strK = k();
        s1Q.d();
        T1.p((T1) s1Q.b, strK);
        String packageName = this.f1827f.getPackageName();
        s1Q.d();
        T1.o((T1) s1Q.b, packageName);
        s1Q.d();
        T1.n((T1) s1Q.b, jNextLong);
        this.f1828g = new I(this.f1827f, (T1) s1Q.b());
        AbstractC0289j0.f("BillingClient", "Billing client should have a valid listener but the provided is null.");
        this.e = new B.p(this.f1827f, (BillingManager) null, this.f1828g);
        this.u = dVar;
        this.f1827f.getPackageName();
    }

    public static Future h(Callable callable, long j6, Runnable runnable, Handler handler, ExecutorService executorService) {
        try {
            Future futureSubmit = executorService.submit(callable);
            handler.postDelayed(new r(1, futureSubmit, runnable), (long) (j6 * 0.95d));
            return futureSubmit;
        } catch (Exception e) {
            AbstractC0289j0.g("BillingClient", "Async task throws exception!", e);
            return null;
        }
    }

    public static String k() {
        try {
            return (String) Class.forName("com.android.billingclient.ktx.BuildConfig").getField("VERSION_NAME").get(null);
        } catch (Exception unused) {
            return "7.1.1";
        }
    }

    @Override // com.android.billingclient.api.AbstractC0252c
    public void a(E1.h hVar, R0.d dVar) {
        if (!c()) {
            C0257h c0257h = H.f1811k;
            u(2, 3, c0257h);
            dVar.onAcknowledgePurchaseResponse(c0257h);
            return;
        }
        if (TextUtils.isEmpty(hVar.b)) {
            AbstractC0289j0.f("BillingClient", "Please provide a valid purchase token.");
            C0257h c0257h2 = H.f1809h;
            u(26, 3, c0257h2);
            dVar.onAcknowledgePurchaseResponse(c0257h2);
            return;
        }
        if (!this.f1833m) {
            C0257h c0257h3 = H.b;
            u(27, 3, c0257h3);
            dVar.onAcknowledgePurchaseResponse(c0257h3);
        } else if (h(new s(this, dVar, hVar, 3), WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, new r(4, this, dVar), s(), l()) == null) {
            C0257h c0257hI = i();
            u(25, 3, c0257hI);
            dVar.onAcknowledgePurchaseResponse(c0257hI);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0054 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.android.billingclient.api.AbstractC0252c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b() {
        /*
            r5 = this;
            java.lang.String r0 = "Unable to log."
            java.lang.String r1 = "BillingClient"
            r2 = 12
            com.google.android.gms.internal.play_billing.L1 r2 = com.android.billingclient.api.G.d(r2)     // Catch: java.lang.Throwable -> L17
            com.android.billingclient.api.I r3 = r5.f1828g     // Catch: java.lang.Throwable -> L12
            int r4 = r5.f1831k     // Catch: java.lang.Throwable -> L12
            r3.zzd(r2, r4)     // Catch: java.lang.Throwable -> L12
            goto L1b
        L12:
            r2 = move-exception
            com.google.android.gms.internal.play_billing.AbstractC0289j0.g(r1, r0, r2)     // Catch: java.lang.Throwable -> L17
            goto L1b
        L17:
            r2 = move-exception
            com.google.android.gms.internal.play_billing.AbstractC0289j0.g(r1, r0, r2)
        L1b:
            java.lang.Object r0 = r5.f1826a
            monitor-enter(r0)
            B.p r1 = r5.e     // Catch: java.lang.Throwable -> L37
            if (r1 == 0) goto L3f
            B.p r1 = r5.e     // Catch: java.lang.Throwable -> L37
            java.lang.Object r2 = r1.e     // Catch: java.lang.Throwable -> L37
            com.android.billingclient.api.K r2 = (com.android.billingclient.api.K) r2     // Catch: java.lang.Throwable -> L37
            java.lang.Object r3 = r1.b     // Catch: java.lang.Throwable -> L37
            android.content.Context r3 = (android.content.Context) r3     // Catch: java.lang.Throwable -> L37
            r2.b(r3)     // Catch: java.lang.Throwable -> L37
            java.lang.Object r1 = r1.f111f     // Catch: java.lang.Throwable -> L37
            com.android.billingclient.api.K r1 = (com.android.billingclient.api.K) r1     // Catch: java.lang.Throwable -> L37
            r1.b(r3)     // Catch: java.lang.Throwable -> L37
            goto L3f
        L37:
            r1 = move-exception
            java.lang.String r2 = "BillingClient"
            java.lang.String r3 = "There was an exception while shutting down broadcast manager while ending connection!"
            com.google.android.gms.internal.play_billing.AbstractC0289j0.g(r2, r3, r1)     // Catch: java.lang.Throwable -> L68
        L3f:
            java.lang.String r1 = "BillingClient"
            java.lang.String r2 = "Unbinding from service."
            com.google.android.gms.internal.play_billing.AbstractC0289j0.e(r1, r2)     // Catch: java.lang.Throwable -> L4a
            r5.o()     // Catch: java.lang.Throwable -> L4a
            goto L52
        L4a:
            r1 = move-exception
            java.lang.String r2 = "BillingClient"
            java.lang.String r3 = "There was an exception while unbinding from the service while ending connection!"
            com.google.android.gms.internal.play_billing.AbstractC0289j0.g(r2, r3, r1)     // Catch: java.lang.Throwable -> L68
        L52:
            r1 = 3
            monitor-enter(r5)     // Catch: java.lang.Throwable -> L6c
            java.util.concurrent.ExecutorService r2 = r5.f1841w     // Catch: java.lang.Throwable -> L62
            if (r2 == 0) goto L60
            r2.shutdownNow()     // Catch: java.lang.Throwable -> L62
            r2 = 0
            r5.f1841w = r2     // Catch: java.lang.Throwable -> L62
            r5.x = r2     // Catch: java.lang.Throwable -> L62
        L60:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L6c
            goto L64
        L62:
            r2 = move-exception
            goto L6a
        L64:
            r5.n(r1)     // Catch: java.lang.Throwable -> L68
            goto L75
        L68:
            r1 = move-exception
            goto L7c
        L6a:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L62
            throw r2     // Catch: java.lang.Throwable -> L6c
        L6c:
            r2 = move-exception
            java.lang.String r3 = "BillingClient"
            java.lang.String r4 = "There was an exception while shutting down the executor service while ending connection!"
            com.google.android.gms.internal.play_billing.AbstractC0289j0.g(r3, r4, r2)     // Catch: java.lang.Throwable -> L77
            goto L64
        L75:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L68
            return
        L77:
            r2 = move-exception
            r5.n(r1)     // Catch: java.lang.Throwable -> L68
            throw r2     // Catch: java.lang.Throwable -> L68
        L7c:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L68
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.C0253d.b():void");
    }

    @Override // com.android.billingclient.api.AbstractC0252c
    public final boolean c() {
        boolean z6;
        synchronized (this.f1826a) {
            try {
                z6 = false;
                if (this.b == 2 && this.f1829h != null && this.i != null) {
                    z6 = true;
                }
            } finally {
            }
        }
        return z6;
    }

    @Override // com.android.billingclient.api.AbstractC0252c
    public C0257h d(Activity activity, final C0256g c0256g) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        C0257h c0257hA;
        String str6;
        String str7;
        Future futureH;
        int iL;
        String string;
        String str8;
        boolean z6;
        String str9;
        C0255f c0255f;
        String str10;
        boolean z7;
        String str11;
        int i;
        final int i3;
        final C0253d c0253d = this;
        String str12 = "proxyPackageVersion";
        if (c0253d.e == null || ((BillingManager) c0253d.e.c) == null) {
            C0257h c0257h = H.f1817r;
            c0253d.u(12, 2, c0257h);
            return c0257h;
        }
        if (!c0253d.c()) {
            C0257h c0257h2 = H.f1811k;
            c0253d.u(2, 2, c0257h2);
            c0253d.w(c0257h2);
            return c0257h2;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(c0256g.d);
        com.google.android.gms.internal.play_billing.A a6 = c0256g.c;
        Iterator it = arrayList.iterator();
        if ((it.hasNext() ? it.next() : null) != null) {
            throw new ClassCastException();
        }
        C0329x c0329x = (C0329x) a6.iterator();
        C0255f c0255f2 = (C0255f) (c0329x.hasNext() ? c0329x.next() : null);
        n nVar = c0255f2.f1842a;
        String str13 = nVar.c;
        String str14 = nVar.d;
        if (str14.equals("subs") && !c0253d.f1830j) {
            AbstractC0289j0.f("BillingClient", "Current client doesn't support subscriptions.");
            C0257h c0257h3 = H.f1813m;
            c0253d.u(9, 2, c0257h3);
            c0253d.w(c0257h3);
            return c0257h3;
        }
        c0256g.b.getClass();
        if ((c0256g.c.stream().anyMatch(new E()) || c0256g.f1843a) && !c0253d.f1832l) {
            AbstractC0289j0.f("BillingClient", "Current client doesn't support extra params for buy intent.");
            C0257h c0257h4 = H.f1808g;
            c0253d.u(18, 2, c0257h4);
            c0253d.w(c0257h4);
            return c0257h4;
        }
        if (arrayList.size() > 1 && !c0253d.f1836p) {
            AbstractC0289j0.f("BillingClient", "Current client doesn't support multi-item purchases.");
            C0257h c0257h5 = H.f1814n;
            c0253d.u(19, 2, c0257h5);
            c0253d.w(c0257h5);
            return c0257h5;
        }
        if (!a6.isEmpty() && !c0253d.q) {
            AbstractC0289j0.f("BillingClient", "Current client doesn't support purchases with ProductDetails.");
            C0257h c0257h6 = H.f1816p;
            c0253d.u(20, 2, c0257h6);
            c0253d.w(c0257h6);
            return c0257h6;
        }
        if (c0256g.c.isEmpty()) {
            c0257hA = H.f1810j;
            str5 = "proxyPackageVersion";
            str2 = str14;
            str4 = "BUY_INTENT";
            str3 = str13;
            str = null;
        } else {
            C0255f c0255f3 = (C0255f) c0256g.c.get(0);
            int i4 = 1;
            while (true) {
                str = null;
                if (i4 < c0256g.c.size()) {
                    C0255f c0255f4 = (C0255f) c0256g.c.get(i4);
                    str2 = str14;
                    if (!c0255f4.f1842a.d.equals(c0255f3.f1842a.d) && !c0255f4.f1842a.d.equals("play_pass_subs")) {
                        c0257hA = H.a(5, "All products should have same ProductType.");
                        str5 = "proxyPackageVersion";
                        str4 = "BUY_INTENT";
                        str3 = str13;
                        break;
                    }
                    i4++;
                    str14 = str2;
                } else {
                    str2 = str14;
                    String strOptString = c0255f3.f1842a.b.optString("packageName");
                    HashSet hashSet = new HashSet();
                    HashSet hashSet2 = new HashSet();
                    str3 = str13;
                    com.google.android.gms.internal.play_billing.A a7 = c0256g.c;
                    int size = a7.size();
                    str4 = "BUY_INTENT";
                    int i5 = 0;
                    while (true) {
                        str5 = str12;
                        n nVar2 = c0255f3.f1842a;
                        if (i5 < size) {
                            int i6 = i5;
                            C0255f c0255f5 = (C0255f) a7.get(i5);
                            com.google.android.gms.internal.play_billing.A a8 = a7;
                            C0255f c0255f6 = c0255f3;
                            c0255f5.f1842a.d.equals("subs");
                            n nVar3 = c0255f5.f1842a;
                            boolean zContains = hashSet.contains(nVar3.c);
                            String str15 = nVar3.c;
                            if (zContains) {
                                c0257hA = H.a(5, "ProductId can not be duplicated. Invalid product id: " + str15 + ".");
                                break;
                            }
                            hashSet.add(str15);
                            if (!nVar2.d.equals("play_pass_subs") && !nVar3.d.equals("play_pass_subs") && !strOptString.equals(nVar3.b.optString("packageName"))) {
                                c0257hA = H.a(5, "All products must have the same package name.");
                                break;
                            }
                            i5 = i6 + 1;
                            str12 = str5;
                            a7 = a8;
                            c0255f3 = c0255f6;
                        } else {
                            Iterator it2 = hashSet2.iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    String str16 = (String) it2.next();
                                    if (hashSet.contains(str16)) {
                                        c0257hA = H.a(5, "OldProductId must not be one of the products to be purchased. Invalid old product id: " + str16 + ".");
                                        break;
                                    }
                                } else {
                                    C0260k c0260kA = nVar2.a();
                                    c0257hA = (c0260kA == null || c0260kA.f1846f == null) ? H.f1810j : H.a(5, "Both autoPayDetails and autoPayBalanceThreshold is required for constructing ProductDetailsParams for autopay.");
                                }
                            }
                        }
                    }
                }
            }
        }
        if (c0257hA != H.f1810j) {
            c0253d.u(120, 2, c0257hA);
            c0253d.w(c0257hA);
            return c0257hA;
        }
        if (c0253d.f1832l) {
            boolean z8 = c0253d.f1833m;
            c0253d.u.getClass();
            c0253d.u.getClass();
            boolean z9 = c0253d.f1840v;
            String str17 = c0253d.c;
            long jLongValue = c0253d.y.longValue();
            final String packageName = c0253d.f1827f.getPackageName();
            final Bundle bundle = new Bundle();
            AbstractC0289j0.b(bundle, str17, jLongValue);
            c0256g.b.getClass();
            if (TextUtils.isEmpty(str)) {
                str8 = str;
            } else {
                str8 = str;
                bundle.putString("accountId", str8);
            }
            if (!TextUtils.isEmpty(str8)) {
                bundle.putString("obfuscatedProfileId", str8);
            }
            if (!TextUtils.isEmpty(str8)) {
                bundle.putStringArrayList("skusToReplace", new ArrayList<>(Arrays.asList(str8)));
            }
            c0256g.b.getClass();
            if (!TextUtils.isEmpty(str8)) {
                c0256g.b.getClass();
                bundle.putString("oldSkuPurchaseToken", str8);
            }
            if (!TextUtils.isEmpty(str8)) {
                bundle.putString("oldSkuPurchaseId", str8);
            }
            c0256g.b.getClass();
            if (!TextUtils.isEmpty(str8)) {
                c0256g.b.getClass();
                bundle.putString("originalExternalTransactionId", str8);
            }
            if (!TextUtils.isEmpty(str8)) {
                bundle.putString("paymentsPurchaseParams", str8);
            }
            if (z8) {
                z6 = true;
                bundle.putBoolean("enablePendingPurchases", true);
            } else {
                z6 = true;
            }
            if (z9) {
                bundle.putBoolean("enableAlternativeBilling", z6);
            }
            final int i7 = 0;
            if (c0256g.c.stream().anyMatch(new Predicate() { // from class: com.google.android.gms.internal.play_billing.a
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    switch (i7) {
                        case 0:
                            int i8 = AbstractC0289j0.f2092a;
                            break;
                        default:
                            int i9 = AbstractC0289j0.f2092a;
                            break;
                    }
                    return false;
                }
            })) {
                F0 f0M = G0.m();
                final int i8 = 1;
                Iterable iterable = (Iterable) c0256g.c.stream().filter(new Predicate() { // from class: com.google.android.gms.internal.play_billing.a
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        switch (i8) {
                            case 0:
                                int i82 = AbstractC0289j0.f2092a;
                                break;
                            default:
                                int i9 = AbstractC0289j0.f2092a;
                                break;
                        }
                        return false;
                    }
                }).map(new Function() { // from class: com.google.android.gms.internal.play_billing.q
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        int i9 = AbstractC0289j0.f2092a;
                        String str18 = ((C0255f) obj).f1842a.c;
                        D0 d0M = E0.m();
                        H0 h0M = I0.m();
                        String str19 = "subs:" + packageName + ":" + str18;
                        h0M.d();
                        I0.n((I0) h0M.b, str19);
                        d0M.d();
                        E0.n((E0) d0M.b, (I0) h0M.b());
                        I0.m();
                        throw null;
                    }
                }).collect(AbstractC0300n.f2107a);
                f0M.d();
                G0.n((G0) f0M.b, iterable);
                bundle.putByteArray("subscriptionProductReplacementParamsList", ((G0) f0M.b()).b());
            }
            if (arrayList.isEmpty()) {
                ArrayList<String> arrayList2 = new ArrayList<>(a6.size() - 1);
                ArrayList<String> arrayList3 = new ArrayList<>(a6.size() - 1);
                ArrayList<String> arrayList4 = new ArrayList<>();
                ArrayList<String> arrayList5 = new ArrayList<>();
                ArrayList<String> arrayList6 = new ArrayList<>();
                ArrayList<Integer> arrayList7 = new ArrayList<>();
                str9 = "BillingClient";
                int i9 = 0;
                while (i9 < a6.size()) {
                    C0255f c0255f7 = (C0255f) a6.get(i9);
                    C0255f c0255f8 = c0255f2;
                    n nVar4 = c0255f7.f1842a;
                    if (!nVar4.f1851g.isEmpty()) {
                        arrayList4.add(nVar4.f1851g);
                    }
                    arrayList5.add(c0255f7.b);
                    String str18 = nVar4.f1852h;
                    ArrayList arrayList8 = nVar4.f1853j;
                    if (arrayList8 == null || arrayList8.isEmpty()) {
                        str10 = str18;
                    } else {
                        for (C0260k c0260k : nVar4.f1853j) {
                            String str19 = str18;
                            if (!TextUtils.isEmpty(c0260k.e)) {
                                str10 = c0260k.e;
                                break;
                            }
                            str18 = str19;
                        }
                        str10 = str18;
                    }
                    if (!TextUtils.isEmpty(str10)) {
                        arrayList6.add(str10);
                    }
                    if (i9 > 0) {
                        arrayList2.add(((C0255f) a6.get(i9)).f1842a.c);
                        arrayList3.add(((C0255f) a6.get(i9)).f1842a.d);
                    }
                    i9++;
                    c0255f2 = c0255f8;
                }
                c0255f = c0255f2;
                bundle.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList5);
                bundle.putIntegerArrayList("AUTO_PAY_BALANCE_THRESHOLD_LIST", arrayList7);
                if (!arrayList4.isEmpty()) {
                    bundle.putStringArrayList("skuDetailsTokens", arrayList4);
                }
                if (!arrayList6.isEmpty()) {
                    bundle.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList6);
                }
                if (!arrayList2.isEmpty()) {
                    bundle.putStringArrayList("additionalSkus", arrayList2);
                    bundle.putStringArrayList("additionalSkuTypes", arrayList3);
                }
            } else {
                ArrayList<String> arrayList9 = new ArrayList<>();
                new ArrayList();
                new ArrayList();
                new ArrayList();
                new ArrayList();
                Iterator it3 = arrayList.iterator();
                if (it3.hasNext()) {
                    it3.next().getClass();
                    throw new ClassCastException();
                }
                if (!arrayList9.isEmpty()) {
                    bundle.putStringArrayList("skuDetailsTokens", arrayList9);
                }
                if (arrayList.size() > 1) {
                    ArrayList<String> arrayList10 = new ArrayList<>(arrayList.size() - 1);
                    ArrayList<String> arrayList11 = new ArrayList<>(arrayList.size() - 1);
                    if (1 < arrayList.size()) {
                        arrayList.get(1).getClass();
                        throw new ClassCastException();
                    }
                    bundle.putStringArrayList("additionalSkus", arrayList10);
                    bundle.putStringArrayList("additionalSkuTypes", arrayList11);
                }
                c0255f = c0255f2;
                str9 = "BillingClient";
            }
            c0253d = this;
            if (bundle.containsKey("SKU_OFFER_ID_TOKEN_LIST") && !c0253d.f1834n) {
                C0257h c0257h7 = H.f1815o;
                c0253d.u(21, 2, c0257h7);
                c0253d.w(c0257h7);
                return c0257h7;
            }
            C0255f c0255f9 = c0255f;
            if (TextUtils.isEmpty(c0255f9.f1842a.b.optString("packageName"))) {
                z7 = false;
            } else {
                bundle.putString("skuPackageName", c0255f9.f1842a.b.optString("packageName"));
                z7 = true;
            }
            str7 = null;
            if (!TextUtils.isEmpty(null)) {
                bundle.putString("accountName", null);
            }
            Intent intent = activity.getIntent();
            if (intent == null) {
                str6 = str9;
                AbstractC0289j0.f(str6, "Activity's intent is null.");
            } else {
                str6 = str9;
                if (!TextUtils.isEmpty(intent.getStringExtra("PROXY_PACKAGE"))) {
                    String stringExtra = intent.getStringExtra("PROXY_PACKAGE");
                    bundle.putString("proxyPackage", stringExtra);
                    try {
                        str11 = str5;
                    } catch (PackageManager.NameNotFoundException unused) {
                        str11 = str5;
                    }
                    try {
                        bundle.putString(str11, c0253d.f1827f.getPackageManager().getPackageInfo(stringExtra, 0).versionName);
                    } catch (PackageManager.NameNotFoundException unused2) {
                        bundle.putString(str11, "package not found");
                    }
                }
            }
            if (c0253d.q && !a6.isEmpty()) {
                i = 17;
            } else if (c0253d.f1835o && z7) {
                i = 15;
            } else if (c0253d.f1833m) {
                i3 = 9;
                final String str20 = str2;
                final String str21 = str3;
                futureH = h(new Callable(i3, str21, str20, c0256g, bundle) { // from class: com.android.billingclient.api.t
                    public final /* synthetic */ int b;
                    public final /* synthetic */ String c;
                    public final /* synthetic */ String d;
                    public final /* synthetic */ Bundle e;

                    {
                        this.e = bundle;
                    }

                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        Bundle bundleH;
                        zzan zzanVar;
                        C0253d c0253d2 = this.f1858a;
                        int i10 = this.b;
                        String str22 = this.c;
                        String str23 = this.d;
                        Bundle bundle2 = this.e;
                        c0253d2.getClass();
                        try {
                            synchronized (c0253d2.f1826a) {
                                zzanVar = c0253d2.f1829h;
                            }
                            return zzanVar == null ? AbstractC0289j0.h(H.f1811k, 119) : zzanVar.zzg(i10, c0253d2.f1827f.getPackageName(), str22, str23, null, bundle2);
                        } catch (DeadObjectException e) {
                            C0257h c0257h8 = H.f1811k;
                            String strA = G.a(e);
                            bundleH = AbstractC0289j0.h(c0257h8, 5);
                            if (strA != null) {
                                bundleH.putString("ADDITIONAL_LOG_DETAILS", strA);
                            }
                            return bundleH;
                        } catch (Exception e6) {
                            C0257h c0257h9 = H.i;
                            String strA2 = G.a(e6);
                            bundleH = AbstractC0289j0.h(c0257h9, 5);
                            if (strA2 != null) {
                                bundleH.putString("ADDITIONAL_LOG_DETAILS", strA2);
                            }
                            return bundleH;
                        }
                    }
                }, CoroutineLiveDataKt.DEFAULT_TIMEOUT, null, c0253d.d, c0253d.l());
            } else {
                i = 6;
            }
            i3 = i;
            final String str202 = str2;
            final String str212 = str3;
            futureH = h(new Callable(i3, str212, str202, c0256g, bundle) { // from class: com.android.billingclient.api.t
                public final /* synthetic */ int b;
                public final /* synthetic */ String c;
                public final /* synthetic */ String d;
                public final /* synthetic */ Bundle e;

                {
                    this.e = bundle;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Bundle bundleH;
                    zzan zzanVar;
                    C0253d c0253d2 = this.f1858a;
                    int i10 = this.b;
                    String str22 = this.c;
                    String str23 = this.d;
                    Bundle bundle2 = this.e;
                    c0253d2.getClass();
                    try {
                        synchronized (c0253d2.f1826a) {
                            zzanVar = c0253d2.f1829h;
                        }
                        return zzanVar == null ? AbstractC0289j0.h(H.f1811k, 119) : zzanVar.zzg(i10, c0253d2.f1827f.getPackageName(), str22, str23, null, bundle2);
                    } catch (DeadObjectException e) {
                        C0257h c0257h8 = H.f1811k;
                        String strA = G.a(e);
                        bundleH = AbstractC0289j0.h(c0257h8, 5);
                        if (strA != null) {
                            bundleH.putString("ADDITIONAL_LOG_DETAILS", strA);
                        }
                        return bundleH;
                    } catch (Exception e6) {
                        C0257h c0257h9 = H.i;
                        String strA2 = G.a(e6);
                        bundleH = AbstractC0289j0.h(c0257h9, 5);
                        if (strA2 != null) {
                            bundleH.putString("ADDITIONAL_LOG_DETAILS", strA2);
                        }
                        return bundleH;
                    }
                }
            }, CoroutineLiveDataKt.DEFAULT_TIMEOUT, null, c0253d.d, c0253d.l());
        } else {
            str6 = "BillingClient";
            str7 = str;
            futureH = h(new s(c0253d, str3, str2, 2), CoroutineLiveDataKt.DEFAULT_TIMEOUT, null, c0253d.d, c0253d.l());
        }
        try {
            if (futureH == null) {
                C0257h c0257h8 = H.d;
                c0253d.u(25, 2, c0257h8);
                c0253d.w(c0257h8);
                return c0257h8;
            }
            Bundle bundle2 = (Bundle) futureH.get(CoroutineLiveDataKt.DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS);
            int iA = AbstractC0289j0.a(bundle2, str6);
            String strD = AbstractC0289j0.d(bundle2, str6);
            if (iA == 0) {
                Intent intent2 = new Intent(activity, (Class<?>) ProxyBillingActivity.class);
                String str22 = str4;
                intent2.putExtra(str22, (PendingIntent) bundle2.getParcelable(str22));
                activity.startActivity(intent2);
                return H.f1810j;
            }
            AbstractC0289j0.f(str6, "Unable to buy item, Error response code: " + iA);
            C0257h c0257hA2 = H.a(iA, strD);
            if (bundle2 == null) {
                iL = 1;
            } else {
                try {
                    Object obj = bundle2.get("LOG_REASON");
                    if (obj != null) {
                        if (obj instanceof Integer) {
                            iL = AbstractC0263a1.l(((Integer) obj).intValue());
                        } else {
                            AbstractC0289j0.f(str6, "Unexpected type for bundle log reason: " + obj.getClass().getName());
                        }
                    }
                } catch (Throwable th) {
                    AbstractC0289j0.f(str6, "Failed to get log reason from bundle: ".concat(String.valueOf(th.getMessage())));
                }
                iL = 1;
            }
            if (iL == 1) {
                iL = 23;
            }
            if (bundle2 == null) {
                string = str7;
            } else {
                try {
                    string = bundle2.getString("ADDITIONAL_LOG_DETAILS");
                } catch (Throwable th2) {
                    AbstractC0289j0.f(str6, "Failed to get additional log details from bundle: ".concat(String.valueOf(th2.getMessage())));
                    string = str7;
                }
            }
            c0253d.v(iL, 2, c0257hA2, string);
            c0253d.w(c0257hA2);
            return c0257hA2;
        } catch (CancellationException e) {
            e = e;
            AbstractC0289j0.g(str6, "Time out while launching billing flow. Try to reconnect", e);
            C0257h c0257h9 = H.f1812l;
            c0253d.v(4, 2, c0257h9, G.a(e));
            c0253d.w(c0257h9);
            return c0257h9;
        } catch (TimeoutException e6) {
            e = e6;
            AbstractC0289j0.g(str6, "Time out while launching billing flow. Try to reconnect", e);
            C0257h c0257h92 = H.f1812l;
            c0253d.v(4, 2, c0257h92, G.a(e));
            c0253d.w(c0257h92);
            return c0257h92;
        } catch (Exception e7) {
            AbstractC0289j0.g(str6, "Exception while launching billing flow. Try to reconnect", e7);
            C0257h c0257h10 = H.f1811k;
            c0253d.v(5, 2, c0257h10, G.a(e7));
            c0253d.w(c0257h10);
            return c0257h10;
        }
    }

    @Override // com.android.billingclient.api.AbstractC0252c
    public void e(o oVar, ProductDetailsResponseListener productDetailsResponseListener) {
        if (!c()) {
            C0257h c0257h = H.f1811k;
            u(2, 7, c0257h);
            productDetailsResponseListener.onProductDetailsResponse(c0257h, new ArrayList());
        } else {
            if (!this.q) {
                AbstractC0289j0.f("BillingClient", "Querying product details is not supported.");
                C0257h c0257h2 = H.f1816p;
                u(20, 7, c0257h2);
                productDetailsResponseListener.onProductDetailsResponse(c0257h2, new ArrayList());
                return;
            }
            if (h(new s(this, oVar, productDetailsResponseListener, 0), WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, new r(2, this, productDetailsResponseListener), s(), l()) == null) {
                C0257h c0257hI = i();
                u(25, 7, c0257hI);
                productDetailsResponseListener.onProductDetailsResponse(c0257hI, new ArrayList());
            }
        }
    }

    @Override // com.android.billingclient.api.AbstractC0252c
    public final void f(E1.h hVar, PurchasesResponseListener purchasesResponseListener) {
        if (!c()) {
            C0257h c0257h = H.f1811k;
            u(2, 9, c0257h);
            C0329x c0329x = com.google.android.gms.internal.play_billing.A.b;
            purchasesResponseListener.onQueryPurchasesResponse(c0257h, O.e);
            return;
        }
        String str = hVar.b;
        if (TextUtils.isEmpty(str)) {
            AbstractC0289j0.f("BillingClient", "Please provide a valid product type.");
            C0257h c0257h2 = H.f1807f;
            u(50, 9, c0257h2);
            C0329x c0329x2 = com.google.android.gms.internal.play_billing.A.b;
            purchasesResponseListener.onQueryPurchasesResponse(c0257h2, O.e);
            return;
        }
        if (h(new s(this, str, purchasesResponseListener, 1), WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, new r(0, this, purchasesResponseListener), s(), l()) == null) {
            C0257h c0257hI = i();
            u(25, 9, c0257hI);
            C0329x c0329x3 = com.google.android.gms.internal.play_billing.A.b;
            purchasesResponseListener.onQueryPurchasesResponse(c0257hI, O.e);
        }
    }

    @Override // com.android.billingclient.api.AbstractC0252c
    public void g(BillingManager billingManager) {
        C0257h c0257hT;
        synchronized (this.f1826a) {
            try {
                if (c()) {
                    c0257hT = t();
                } else if (this.b == 1) {
                    AbstractC0289j0.f("BillingClient", "Client is already in the process of connecting to billing service.");
                    c0257hT = H.e;
                    u(37, 6, c0257hT);
                } else if (this.b == 3) {
                    AbstractC0289j0.f("BillingClient", "Client was already closed and can't be reused. Please create another instance.");
                    c0257hT = H.f1811k;
                    u(38, 6, c0257hT);
                } else {
                    n(1);
                    o();
                    AbstractC0289j0.e("BillingClient", "Starting in-app billing setup.");
                    this.i = new w(this, billingManager);
                    Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
                    intent.setPackage("com.android.vending");
                    List<ResolveInfo> listQueryIntentServices = this.f1827f.getPackageManager().queryIntentServices(intent, 0);
                    int i = 41;
                    if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
                        n(0);
                        AbstractC0289j0.e("BillingClient", "Billing service unavailable on device.");
                        c0257hT = H.c;
                        u(i, 6, c0257hT);
                    } else {
                        ServiceInfo serviceInfo = listQueryIntentServices.get(0).serviceInfo;
                        i = 40;
                        if (serviceInfo != null) {
                            String str = serviceInfo.packageName;
                            String str2 = serviceInfo.name;
                            if (!Objects.equals(str, "com.android.vending") || str2 == null) {
                                AbstractC0289j0.f("BillingClient", "The device doesn't have valid Play Store.");
                            } else {
                                ComponentName componentName = new ComponentName(str, str2);
                                Intent intent2 = new Intent(intent);
                                intent2.setComponent(componentName);
                                intent2.putExtra("playBillingLibraryVersion", this.c);
                                synchronized (this.f1826a) {
                                    try {
                                        if (this.b == 2) {
                                            c0257hT = t();
                                        } else if (this.b != 1) {
                                            AbstractC0289j0.f("BillingClient", "Client state no longer CONNECTING, returning service disconnected.");
                                            c0257hT = H.f1811k;
                                            u(117, 6, c0257hT);
                                        } else {
                                            w wVar = this.i;
                                            if (this.f1827f.bindService(intent2, wVar, 1)) {
                                                AbstractC0289j0.e("BillingClient", "Service was bonded successfully.");
                                                c0257hT = null;
                                            } else {
                                                AbstractC0289j0.f("BillingClient", "Connection to Billing service is blocked.");
                                                i = 39;
                                            }
                                        }
                                    } finally {
                                    }
                                }
                            }
                        } else {
                            AbstractC0289j0.f("BillingClient", "The device doesn't have valid Play Store.");
                        }
                        n(0);
                        AbstractC0289j0.e("BillingClient", "Billing service unavailable on device.");
                        c0257hT = H.c;
                        u(i, 6, c0257hT);
                    }
                }
            } finally {
            }
        }
        if (c0257hT != null) {
            billingManager.onBillingSetupFinished(c0257hT);
        }
    }

    public final C0257h i() {
        int[] iArr = {0, 3};
        synchronized (this.f1826a) {
            for (int i = 0; i < 2; i++) {
                if (this.b == iArr[i]) {
                    return H.f1811k;
                }
            }
            return H.i;
        }
    }

    public final void j() {
        if (TextUtils.isEmpty(null)) {
            this.f1827f.getPackageName();
        }
    }

    public final synchronized ExecutorService l() {
        try {
            if (this.f1841w == null) {
                this.f1841w = Executors.newFixedThreadPool(AbstractC0289j0.f2092a, new u());
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f1841w;
    }

    public final void m(J1 j12) {
        try {
            this.f1828g.zzb(j12, this.f1831k);
        } catch (Throwable th) {
            AbstractC0289j0.g("BillingClient", "Unable to log.", th);
        }
    }

    public final void n(int i) {
        synchronized (this.f1826a) {
            try {
                if (this.b == 3) {
                    return;
                }
                int i3 = this.b;
                AbstractC0289j0.e("BillingClient", "Setting clientState from " + (i3 != 0 ? i3 != 1 ? i3 != 2 ? "CLOSED" : "CONNECTED" : "CONNECTING" : "DISCONNECTED") + " to " + (i != 0 ? i != 1 ? i != 2 ? "CLOSED" : "CONNECTED" : "CONNECTING" : "DISCONNECTED"));
                this.b = i;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void o() {
        synchronized (this.f1826a) {
            if (this.i != null) {
                try {
                    this.f1827f.unbindService(this.i);
                } catch (Throwable th) {
                    try {
                        AbstractC0289j0.g("BillingClient", "There was an exception while unbinding service!", th);
                        this.f1829h = null;
                        this.i = null;
                    } finally {
                        this.f1829h = null;
                        this.i = null;
                    }
                }
            }
        }
    }

    public final M3.a p(C0257h c0257h, int i, String str, Exception exc) {
        AbstractC0289j0.g("BillingClient", str, exc);
        v(i, 7, c0257h, G.a(exc));
        return new M3.a(c0257h.f1844a, c0257h.b, new ArrayList());
    }

    public final I q(C0257h c0257h, int i, String str, Exception exc) {
        v(i, 9, c0257h, G.a(exc));
        AbstractC0289j0.g("BillingClient", str, exc);
        return new I(c0257h, (ArrayList) null);
    }

    public final void r(R0.d dVar, C0257h c0257h, int i, Exception exc) {
        AbstractC0289j0.g("BillingClient", "Error in acknowledge purchase!", exc);
        v(i, 3, c0257h, G.a(exc));
        dVar.onAcknowledgePurchaseResponse(c0257h);
    }

    public final Handler s() {
        return Looper.myLooper() == null ? this.d : new Handler(Looper.myLooper());
    }

    public final C0257h t() {
        AbstractC0289j0.e("BillingClient", "Service connection is valid. No need to re-initialize.");
        K1 k1O = L1.o();
        k1O.d();
        L1.n((L1) k1O.b, 6);
        f2 f2VarN = g2.n();
        f2VarN.d();
        g2.m((g2) f2VarN.b);
        k1O.d();
        L1.m((L1) k1O.b, (g2) f2VarN.b());
        try {
            this.f1828g.zzd((L1) k1O.b(), this.f1831k);
        } catch (Throwable th) {
            AbstractC0289j0.g("BillingClient", "Unable to log.", th);
        }
        return H.f1810j;
    }

    public final void u(int i, int i3, C0257h c0257h) {
        try {
            m(G.b(i, i3, c0257h));
        } catch (Throwable th) {
            AbstractC0289j0.g("BillingClient", "Unable to log.", th);
        }
    }

    public final void v(int i, int i3, C0257h c0257h, String str) {
        try {
            m(G.c(i, i3, c0257h, str));
        } catch (Throwable th) {
            AbstractC0289j0.g("BillingClient", "Unable to log.", th);
        }
    }

    public final void w(C0257h c0257h) {
        if (Thread.interrupted()) {
            return;
        }
        this.d.post(new r(3, this, c0257h));
    }

    public C0253d(n0.d dVar, Context context, BillingManager billingManager) {
        String strK = k();
        this.f1826a = new Object();
        this.b = 0;
        this.d = new Handler(Looper.getMainLooper());
        this.f1831k = 0;
        long jNextLong = new Random().nextLong();
        this.y = Long.valueOf(jNextLong);
        this.c = strK;
        this.f1827f = context.getApplicationContext();
        S1 s1Q = T1.q();
        s1Q.d();
        T1.p((T1) s1Q.b, strK);
        String packageName = this.f1827f.getPackageName();
        s1Q.d();
        T1.o((T1) s1Q.b, packageName);
        s1Q.d();
        T1.n((T1) s1Q.b, jNextLong);
        this.f1828g = new I(this.f1827f, (T1) s1Q.b());
        if (billingManager == null) {
            AbstractC0289j0.f("BillingClient", "Billing client should have a valid listener but the provided is null.");
        }
        this.e = new B.p(this.f1827f, billingManager, this.f1828g);
        this.u = dVar;
        this.f1840v = false;
        this.f1827f.getPackageName();
    }
}
